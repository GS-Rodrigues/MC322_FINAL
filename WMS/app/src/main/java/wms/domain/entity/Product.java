package wms.domain.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa um produto armazenado no sistema WMS.
 *
 * <p>
 * A classe {@code Product} contém todas as informações relevantes de um item
 * de estoque, incluindo código, nome, fornecedor, quantidades e endereços de
 * armazenamento ({@link StorageAddress}). Ela também fornece operações básicas
 * de adição e remoção de unidades.
 * </p>
 *
 * @author Guilherme Rodrigues
 * @version 1.1
 * @since 2025-11-20
 */
public class Product extends Entity {
    private String code;
    private String name;
    private String supplier;
    private String supplierphone;
    private List<StorageAddress> address;
    private int currentquantity;
    private int minquantity;
    private int maxquantity;

    /**
     * Cria um novo produto com suas informações básicas.
     *
     * @param code            código identificador único do produto
     * @param name            nome do produto
     * @param supplier        nome do fornecedor
     * @param supplierphone   telefone do fornecedor
     * @param currentquantity quantidade atual em estoque
     * @param minquantity     quantidade mínima aceitável em estoque
     * @param maxquantity     quantidade máxima que o estoque suporta
     */
    public Product(String code, String name, String supplier, String supplierphone,
            int minquantity, int maxquantity) {

        super();
        this.code = code;
        this.name = name;
        this.supplier = supplier;
        this.supplierphone = supplierphone;
        this.currentquantity = 0;
        this.minquantity = minquantity;
        this.maxquantity = maxquantity;
    }

    /**
     * @return o código identificador do produto
     */
    public String getCode() {
        return this.code;
    }

    /**
     * @return o nome do produto
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return o nome do fornecedor
     */
    protected String getSupplier() {
        return this.supplier;
    }

    /**
     * @return o telefone do fornecedor
     */
    protected String getSupplierPhone() {
        return this.supplierphone;
    }

    /**
     * @return lista de endereços de armazenamento onde o produto está alocado
     */
    protected List<StorageAddress> getAddress() {
        return this.address;
    }

    /**
     * @return quantidade atual em estoque
     */
    protected int getCurrentQuantity() {
        return this.currentquantity;
    }

    /**
     * @return quantidade mínima aceitável do produto no estoque
     */
    protected int getMinQuantity() {
        return this.minquantity;
    }

    /**
     * @return quantidade máxima suportada pelo estoque
     */
    protected int getMaxQuantity() {
        return this.maxquantity;
    }

    /**
     * Adiciona uma quantidade do produto em um endereço específico do estoque.
     *
     * @param quantity quantidade a adicionar
     * @param address  endereço onde a quantidade será armazenada
     */
    protected void add(int quantity, StorageAddress address) {
        if (this.address == null) {
            this.address = new ArrayList<>();
        }

        // Soma quantidade no total do produto
        this.currentquantity += quantity;

        // Atualiza a quantidade afetada no endereço
        address.setQuantity(address.getQuantity() + quantity);

        // Adiciona novo endereço na lista
        this.address.add(address);
    }

    /**
     * Remove uma quantidade do produto consumindo os endereços em ordem.
     *
     * @param quantity quantidade a remover
     */
    protected void remove(int quantity) {
        if (this.address == null || this.address.isEmpty()) {
            throw new IllegalStateException("Não há estoque para remover.");
        }

        if (quantity > this.currentquantity) {
            throw new IllegalArgumentException("Quantidade maior que o estoque disponível.");
        }

        this.currentquantity -= quantity;

        while (quantity > 0 && !address.isEmpty()) {
            StorageAddress first = address.get(0);
            int q = first.getQuantity();

            if (q <= quantity) {
                // Consumiu completamente este endereço
                quantity -= q;
                address.remove(0);
            } else {
                // Consumiu parcialmente
                first.setQuantity(q - quantity);
                quantity = 0;
            }
        }
    }

}
