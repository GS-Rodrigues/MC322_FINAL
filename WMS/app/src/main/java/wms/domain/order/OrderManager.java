package wms.domain.order;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Gerencia pedidos de compra (PurchaseOrder) e pedidos de venda (SellingOrder).
 * 
 * Mantém duas listas principais:
 * - Pedidos pendentes (po e so)
 * - Pedidos finalizados (finishedpo e finishedso)
 * 
 * Permite adicionar pedidos, finalizar e mover para a lista de finalizados.
 * 
 * @author Guilherme Rodrigues
 * @version 1.0
 * @since 2025-11-21
 */
public class OrderManager {

    private List<PurchaseOrder> po;
    private List<SellingOrder> so;

    private List<PurchaseOrder> finishedpo;
    private List<SellingOrder> finishedso;

    /**
     * Cria um novo gerenciador de pedidos, inicializando todas as listas.
     */
    public OrderManager() {
        this.po = new ArrayList<>();
        this.so = new ArrayList<>();
        this.finishedpo = new ArrayList<>();
        this.finishedso = new ArrayList<>();
    }

    /**
     * Adiciona um pedido de compra à lista de pedidos pendentes.
     *
     * @param po Pedido de compra a ser adicionado.
     */
    public void addPo(PurchaseOrder po) {
        this.po.add(po);
    }

    /**
     * Finaliza um pedido de venda movendo-o da lista de pendentes para a lista
     * de finalizados.
     *
     * @param socode Código do pedido de venda a ser finalizado.
     */
    public void finishSo(String socode) {
        Iterator<SellingOrder> it = this.getSo().iterator();

        while (it.hasNext()) {
            SellingOrder item = it.next();

            if (item.getCode().equals(socode)) {
                item.setStatus("COMPLETED");
                finishedso.add(item); // adiciona na lista de pedidos finalizados
                it.remove(); // remove da lista de pedidos pendentes
            }
        }
    }

    /**
     * Finaliza um pedido de compra movendo-o da lista de pendentes para a lista
     * de finalizados.
     *
     * @param pocode Código do pedido de compra a ser finalizado.
     */
    public void finishPo(String pocode) {
        Iterator<PurchaseOrder> it = this.getPo().iterator();

        while (it.hasNext()) {
            PurchaseOrder item = it.next();

            if (item.getCode().equals(pocode)) {
                item.setStatus("COMPLETED");
                finishedpo.add(item); // adiciona na lista de pedidos finalizados
                it.remove(); // remove da lista de pedidos pendentes
            }
        }
    }

    /**
     * Adiciona um pedido de venda à lista de pedidos pendentes.
     *
     * @param so Pedido de venda a ser adicionado.
     */
    public void addSo(SellingOrder so) {
        this.so.add(so);
    }

    /**
     * Retorna a lista de pedidos de venda pendentes.
     *
     * @return Lista de SellingOrder.
     */
    public List<SellingOrder> getSo() {
        return this.so;
    }

    /**
     * Retorna a lista de pedidos de compra pendentes.
     *
     * @return Lista de PurchaseOrder.
     */
    public List<PurchaseOrder> getPo() {
        return this.po;
    }
}
