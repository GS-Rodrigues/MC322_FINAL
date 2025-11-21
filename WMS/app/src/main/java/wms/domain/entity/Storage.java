package wms.domain.entity;

import java.util.ArrayList;
import java.util.List;

import wms.domain.interfaces.InvMoviment;
import wms.domain.order.OrderItem;
import wms.domain.order.PurchaseOrder;
import wms.domain.order.SellingOrder;

public class Storage implements InvMoviment {

    private List<Product> products;
    private List<Transaction> lasttransactions;

    public Storage() {
        this.products = new ArrayList<>();
        this.lasttransactions = new ArrayList<>();
    }

    /**
     * Reabastece o estoque manualmente.
     */
    @Override
    public void restock(Product p, int quantity) {
        StorageAddress address = new StorageAddress("RESTOCK", quantity);
        p.add(quantity, address);
        Transaction t = new Transaction("RESTOCK", p, quantity);
        registerTransaction(t);
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
            PurchaseOrder po = new PurchaseOrder(
                    p.getSupplier(),
                    p.getSupplierPhone(),
                    "PENDING",
                    List.of(new OrderItem(p, quantityToBuy)));
            // registra como “pendente”, para o operador aprovar futuramente
            po.setStatus("PENDING");
            System.out.println("[AUTO] Gerado pedido de compra para "
                    + p.getName() + " de " + quantityToBuy + " unidades.");
        }
        
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

        po.setStatus("COMPLETED");
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

        so.setStatus("COMPLETED");
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

    public List<Transaction> getLastTransactions() {
        return lasttransactions;
    }
}
