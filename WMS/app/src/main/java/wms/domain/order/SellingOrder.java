package wms.domain.order;

/**
 * Representa um pedido de venda, contendo dados básicos do cliente.
 */
public class SellingOrder {

    private String customerName; // nome do cliente
    private String cep; // CEP do cliente

    /**
     * Cria um novo pedido de venda com os dados do cliente.
     *
     * @param customerName nome do cliente
     * @param cep          CEP do cliente
     */
    public SellingOrder(String customerName, String cep) {
        this.customerName = customerName;
        this.cep = cep;
    }

    /**
     * Retorna o nome do cliente associado ao pedido.
     *
     * @return nome do cliente
     */
    public String getCustomerName() {
        return this.customerName;
    }

    /**
     * Retorna o CEP associado ao pedido.
     *
     * @return CEP do cliente
     */
    public String getCep() {
        return this.cep;
    }
}
