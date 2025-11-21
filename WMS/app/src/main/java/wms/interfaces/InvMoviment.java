package wms.interfaces;

import wms.domain.entity.Product;
import wms.domain.entity.Transaction;

/**
 * Define o contrato para operações de movimentação de estoque no sistema WMS.
 *
 * <p>
 * A interface {@code InvMoviment} especifica as ações obrigatórias relacionadas
 * a entradas e saídas de produtos no estoque, além do registro dessas
 * movimentações. Qualquer classe que gerencie ou mexa no estoque deve
 * implementar esta interface.
 * </p>
 *
 * <p>
 * As funcionalidades incluem: reabastecimento, retirada de produtos, registro
 * de transações e visualização do histórico de movimentações.
 * </p>
 *
 * @author Guilherme Rodrigues
 * @version 1.0
 * @since 2025-11-20
 */
public interface InvMoviment {
    /**
     * Reabastece o estoque de um {@code Produto}
     */
    public void restock(Product p, int quantity);

    /**
     * Retira {@code Produto} do estoque
     */
    public void withdraw(Product product, int quantity);

    /**
     * Registra uma transação da classe Transaction em um arquivo XML.
     */
    public void registerTransaction(Transaction transaction);

    /**
     * Exibe o histórico de transações.
     */
    public void viewTransactions();
}
