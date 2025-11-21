package wms.domain.order;

import java.util.List;

import wms.support.OrderNumberGenerator;

/**
 * Classe abstrata que representa um pedido genérico.
 * <p>
 * Contém código identificador, lista de itens e status atual.
 * É usada como base para pedidos de compra, venda, etc.
 * </p>
 */
public abstract class Order {

    private String code;
    private List<OrderItem> itens;
    private String status;

    /**
     * Construtor base para qualquer tipo de pedido.
     *
     * @param code   código identificador do pedido
     * @param itens  lista de itens do pedido
     * @param status status inicial do pedido
     */

    public Order(String status, List<OrderItem> itens) {
        this.code = OrderNumberGenerator.nextId(); // código único gerado
        this.itens = itens;
        this.status = status;
    }

    /**
     * Retorna o status atual do pedido.
     *
     * @return status
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * Define o status atual do pedido.
     * <p>
     * Protegido para que somente subclasses controlem mudanças de status.
     * </p>
     *
     * @param status novo status
     */
    protected void setStatus(String status) {
        this.status = status;
    }

    /**
     * Retorna o código identificador do pedido.
     *
     * @return código do pedido
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Retorna a lista de itens do pedido.
     *
     * @return lista de {@link OrderItem}
     */
    public List<OrderItem> getItens() {
        return this.itens;
    }
}
