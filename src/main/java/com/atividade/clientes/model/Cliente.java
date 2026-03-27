package com.atividade.clientes.model;

import jakarta.persistence.*;

/**
 * Entidade que representa um Cliente no sistema.
 * 
 * Esta classe é mapeada para a tabela "clientes" no banco de dados
 * utilizando JPA (Jakarta Persistence API).
 * 
 * Contém validações básicas nos setters para garantir integridade dos dados.
 * 
 * @author Breno
 */
@Entity
@Table(name = "clientes")
public class Cliente {

    /**
     * Identificador único do cliente.
     * Gerado automaticamente pelo banco de dados (auto incremento).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome do cliente.
     * Limite máximo de 120 caracteres.
     */
    @Column(length = 120, nullable = true)
    private String nome;

    /**
     * Email do cliente.
     */
    @Column(nullable = true)
    private String email;

    /**
     * Telefone do cliente.
     */
    @Column(nullable = true)
    private String telefone;

    /**
     * CPF do cliente.
     * Deve ser único no banco de dados.
     */
    @Column(nullable = true, unique = true)
    private String cpf;

    /**
     * Construtor padrão obrigatório para JPA.
     */
    public Cliente() {
    }

    /**
     * Construtor completo da entidade Cliente.
     * 
     * @param id Identificador do cliente
     * @param nome Nome do cliente
     * @param email Email do cliente
     * @param telefone Telefone do cliente
     * @param cpf CPF do cliente
     */
    public Cliente(Long id, String nome, String email, String telefone, String cpf) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    /**
     * Retorna o ID do cliente.
     */
    public Long getId() {
        return id;
    }

    /**
     * Retorna o nome do cliente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do cliente.
     * 
     * Validação:
     * - Não pode ser nulo ou vazio.
     * 
     * @param nome Nome do cliente
     * @throws IllegalArgumentException caso o nome seja inválido
     */
    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        this.nome = nome;
    }

    /**
     * Retorna o email do cliente.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o email do cliente.
     * 
     * Validação:
     * - Deve conter o caractere '@'
     * 
     * @param email Email do cliente
     * @throws IllegalArgumentException caso o email seja inválido
     */
    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.email = email;
    }

    /**
     * Retorna o telefone do cliente.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone do cliente.
     * 
     * @param telefone Telefone do cliente
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Retorna o CPF do cliente.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define o CPF do cliente.
     * 
     * Validação:
     * - Não pode ser nulo ou vazio
     * 
     * @param cpf CPF do cliente
     * @throws IllegalArgumentException caso o CPF seja inválido
     */
    public void setCpf(String cpf) {
        if (cpf == null || cpf.isEmpty()) {
            throw new IllegalArgumentException("CPF é obrigatório");
        }
        this.cpf = cpf;
    }
}