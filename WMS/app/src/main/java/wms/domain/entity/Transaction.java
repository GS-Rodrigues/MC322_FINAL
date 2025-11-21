package wms.domain.entity;

import java.time.LocalDateTime;

/**
 * Representa uma transação realizada no sistema, como entrada ou saída de
 * produtos.
 * Cada transação registra o tipo, o produto envolvido, a quantidade e o momento
 * em que ocorreu.
 * 
 * @author Guilherme Rodrigues
 * @version 1.0
 * @since 2025-11-21
 */
public class Transaction {
    private String type;
    private LocalDateTime date;
    private Product product;
    private int quantity;

    /**
     * Cria uma nova transação com o tipo informado, produto e quantidade.
     * A data da transação é registrada automaticamente como o momento da criação.
     *
     * @param type     o tipo da transação (ex.: "entrada", "saída")
     * @param product  o produto relacionado à transação
     * @param quantity a quantidade movimentada
     */
    public Transaction(String type, Product product, int quantity) {
        this.type = type;
        this.product = product;
        this.quantity = quantity;
        this.date = LocalDateTime.now();
    }

    /**
     * Retorna o tipo da transação.
     *
     * @return o tipo
     */
    public String getType() {
        return this.type;
    }

    /**
     * Retorna a data e hora em que a transação foi registrada.
     *
     * @return a data da transação
     */
    public LocalDateTime getDate() {
        return this.date;
    }

    /**
     * Retorna o produto envolvido na transação.
     *
     * @return o produto
     */
    public Product getProduct() {
        return this.product;
    }

    /**
     * Retorna a quantidade movimentada na transação.
     *
     * @return a quantidade
     */
    public int getQuantity() {
        return this.quantity;
    }
}
