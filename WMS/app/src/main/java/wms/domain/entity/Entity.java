package wms.domain.entity;

import java.time.LocalDateTime;

import wms.support.IdGenerator;

/**
 * Classe base abstrata para qualquer entidade do sistema.
 * Gerencia atributos comuns como identificador único, data de criação,
 * data da última modificação e status de atividade.
 *
 * @author Guilherme Rodrigues
 * @version 1.0
 * @since 2025-11-21
 */
public abstract class Entity {

    private final String id;
    private final LocalDateTime creation;
    private LocalDateTime lastUpdate;
    private boolean active;

    /**
     * Construtor base para entidades.
     * Gera ID automaticamente, define criação e ativa por padrão.
     */
    public Entity() {
        this.id = IdGenerator.nextId(); // usa gerador sequencial
        this.creation = LocalDateTime.now();
        this.lastUpdate = this.creation;
        this.active = true;
    }

    /**
     * Ativa a entidade e atualiza a data de modificação.
     */
    public void activate() {
        this.active = true;
        updateTime();
    }

    /**
     * Desativa a entidade e atualiza a data de modificação.
     */
    public void deactivate() {
        this.active = false;
        updateTime();
    }

    /**
     * Atualiza o timestamp da última modificação.
     * <p>
     * Só pode ser chamado por classes filhas.
     * </p>
     */
    protected void updateTime() {
        this.lastUpdate = LocalDateTime.now();
    }

    /**
     * Retorna o identificador único da entidade.
     *
     * @return ID sequencial da entidade
     */
    public String getId() {
        return this.id;
    }

    /**
     * Indica se a entidade está ativa.
     *
     * @return {@code true} se ativa, {@code false} caso contrário
     */
    public boolean isActive() {
        return this.active;
    }

    /**
     * Obtém o timestamp da última atualização.
     *
     * @return data e hora da última modificação
     */
    public LocalDateTime getLastUpdate() {
        return this.lastUpdate;
    }

    /**
     * Obtém o timestamp de criação da entidade.
     *
     * @return data e hora de criação
     */
    public LocalDateTime getCreation() {
        return this.creation;
    }
}