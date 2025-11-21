package wms.domain.order;

import wms.domain.entity.Entity;
import wms.domain.entity.Product;

/**
 * Representa um item dentro de um pedido, contendo o produto e a quantidade.
 * 
 * @author Guilherme Rodrigues
 * @version 1.0
 * @since 2025-11-21
 */
public class OrderItem  extends Entity{
    private Product product;
    private int quantity;

    /**
     * Cria um novo OrderItem com o produto e a quantidade informados.
     *
     * @param product  o produto deste item
     * @param quantity a quantidade do produto
     */
    public OrderItem(Product product, int quantity) {
        super();
        this.quantity = quantity;
        this.product = product;
    } 

    /**
     * Retorna a quantidade deste item.
     *
     * @return a quantidade
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Retorna o produto associado a este item.
     *
     * @return o produto
     */
    public Product getProduct() {
        return this.product;
    }
}
