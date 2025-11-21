package wms.domain.entity;

/**
 * Representa um endereço físico de armazenamento dentro do sistema WMS.
 *
 * <p>
 * Um {@code StorageAddress} corresponde a uma prateleira ou localização
 * específica onde parte da quantidade de um produto está armazenada. Cada
 * endereço mantém a informação da sua identificação ({@code shelf}) e da
 * quantidade alocada naquele ponto.
 * </p>
 *
 * <p>
 * Esta classe é utilizada pela classe {@code Product} para distribuir a
 * quantidade total de um item entre diferentes posições físicas do estoque.
 * </p>
 *
 * @author Guilherme Rodrigues
 * @version 1.0
 * @since 2025-11-20
 */
public class StorageAddress extends Entity{
    private String shelf;
    private int quantity;

    /**
     * Cria um novo endereço de armazenamento.
     *
     * @param shelf    identificador da prateleira ou localização
     * @param quantity quantidade armazenada neste endereço
     */
    public StorageAddress(String shelf, int quantity) {
        super();
        this.shelf = shelf;
        this.quantity = quantity;
    }

    /**
     * @return o identificador da prateleira
     */
    public String getShelf() {
        return shelf;
    }

    /**
     * @return a quantidade armazenada neste endereço
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Atualiza a quantidade armazenada neste endereço.
     *
     * @param quantity nova quantidade a ser registrada
     */ 
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Verifica se o endereço está vazio.
     *
     * @return {@code true} se a quantidade armazenada for zero, caso contrário
     *         {@code false}
     */
    public boolean isEmpty() {
        return quantity == 0;
    }
}
