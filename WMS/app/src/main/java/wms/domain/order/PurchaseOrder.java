package wms.domain.order;

import java.util.List;

/**
 * Representa um pedido de compra, contendo informações do fornecedor.
 *
 * @author Guilherme Rodrigues
 * @version 1.0
 * @since 2025-11-21
 */
public class PurchaseOrder extends Order {

    private String supplier; // nome do fornecedor
    private String supplierPhone; // telefone do fornecedor

    /**
     * Cria um novo pedido de compra com os dados do fornecedor.
     *
     * @param supplier      nome do fornecedor
     * @param supplierPhone telefone do fornecedor
     */
    public PurchaseOrder(String supplier, String supplierPhone, String status, List<OrderItem> itens) {
        super(status, itens); 
        this.supplier = supplier;
        this.supplierPhone = supplierPhone;
    }

    /**
     * Retorna o nome do fornecedor.
     *
     * @return nome do fornecedor
     */
    public String getSupplier() {
        return this.supplier;
    }

    /**
     * Retorna o telefone do fornecedor.
     *
     * @return telefone do fornecedor
     */
    public String getSupplierPhone() {
        return this.supplierPhone;
    }
}
