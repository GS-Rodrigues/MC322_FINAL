package wms.domain.entity;

import java.util.ArrayList;
import java.util.List;

import wms.domain.order.OrderItem;
import wms.domain.order.OrderManager;
import wms.domain.order.PurchaseOrder;
import wms.domain.order.SellingOrder;
import wms.interfaces.InvMoviment;

/**
 * Representa o controle central de estoque do sistema WMS.
 *
 * <p>
 * A classe {@code Storage} concentra todas as operações de entrada e saída de
 * produtos, bem como o registro das transações realizadas. Ela mantém uma lista
 * de produtos armazenados e um histórico das movimentações ocorridas.
 * </p>
 *
 * <p>
 * Além disso, {@code Storage} implementa a interface {@link InvMoviment},
 * fornecendo os métodos padronizados de reabastecimento ({@code restock}),
 * retirada ({@code withdraw}), registro de transações e visualização do
 * histórico. Métodos de mais alto nível, como {@code purchase} e {@code sell},
 * utilizam as operações básicas da interface para manipular o estoque.
 * </p>
 *
 * <p>
 * A classe também é responsável por avaliar quando um item está abaixo da
 * quantidade mínima definida, podendo gerar pedidos automáticos de
 * reposição.
 * </p>
 *
 * @author Guilherme
 * @version 1.4
 * @since 2025-11-21
 */
public class Storage implements InvMoviment {

    private List<Product> products;
    private List<Transaction> lasttransactions;
    private OrderManager ordermanager;

    public Storage() {
        this.products = new ArrayList<>();
        this.lasttransactions = new ArrayList<>();
        this.ordermanager = new OrderManager();
    }

    /**
     * Reabastece o estoque manualmente.
     */
    @Override
    public void restock(Product p, int quantity) {
        boolean flag = false;
        for (Product item : this.products) {
            if (item.getCode().equals(p.getCode())) {
                StorageAddress address = new StorageAddress("RESTOCK", quantity);
                p.add(quantity, address);
                Transaction t = new Transaction("RESTOCK", p, quantity);
                registerTransaction(t);
                flag = true;
                break;
            }
            ;
        }
        if (!flag) {
            this.products.add(p);
            StorageAddress address = new StorageAddress("RESTOCK", quantity);
            p.add(quantity, address);
            Transaction t = new Transaction("RESTOCK", p, quantity);
            registerTransaction(t);

        }

    }

    /**
     * Retira quantidade manualmente.
     */
    @Override
    public void withdraw(Product p, int quantity) {
        p.remove(quantity);
        Transaction t = new Transaction("WITHDRAW", p, quantity);
        registerTransaction(t);
        checkAndGenerateAutoPurchase(p);
    }

    /**
     * Verifica se algum produto está abaixo do estoque mínimo.
     *
     * @return true se produto abaixo do mínimo
     */
    private boolean isBelowMinimum(Product p) {
        if (p.getCurrentQuantity() < p.getMinQuantity()) {
            return true;
        }
        return false;
    }

    private void checkAndGenerateAutoPurchase(Product p) {
        if (isBelowMinimum(p)) {
            int quantityToBuy = p.getMaxQuantity() - p.getCurrentQuantity();
            PurchaseOrder po = new PurchaseOrder(p.getSupplier(), p.getSupplierPhone(), "PENDING");
            po.addItem(new OrderItem(p, quantityToBuy));
            po.setStatus("PENDING");
            System.out.println(
                    "[AUTO] Gerado pedido de compra para " + p.getName() + " de " + quantityToBuy + " unidades.");
            ordermanager.addPo(po);
        }

    }

    public void receiveSellingOrder(SellingOrder neworder) {
        this.ordermanager.addSo(neworder);
    }

    /**
     * Realiza operação de compra (entrada de estoque).
     *
     * @param po pedido de compra
     */
    public void purchase(PurchaseOrder po) {
        for (OrderItem item : po.getItens()) {
            restock(item.getProduct(), item.getQuantity());
        }
        ordermanager.finishPo(po.getCode());
    }

    /**
     * Realiza operação de venda (saída de estoque).
     *
     * @param so pedido de venda
     */
    public void sell(SellingOrder so) {
        for (OrderItem item : so.getItens()) {
            withdraw(item.getProduct(), item.getQuantity());
        }
        ordermanager.finishSo(so.getCode());
    }

    /**
     * Registra transação em XML futuramente
     */
    @Override
    public void registerTransaction(Transaction transaction) {
        lasttransactions.add(transaction);
        // aqui futuramente vamos salva no XML
    }

    /**
     * Mostra o histórico de transações.
     */
    @Override
    public void viewTransactions() {
        for (Transaction t : lasttransactions) {
            System.out.println(
                    t.getType() + " | " + t.getDate() + " | " + t.getProduct().getName() + " | " + t.getQuantity());
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public OrderManager getOrderManager() {
        return this.ordermanager;
    }

    public Product getProductByCode(String code) {
        for (Product item : this.getProducts()) {
            if (item.getCode().equals(code)) {
                return item;
            }
        }
        System.out.print("ERRO: Produto não encontrado!");
        return null;
    }

}
