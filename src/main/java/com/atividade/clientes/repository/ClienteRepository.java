package com.atividade.clientes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade.clientes.model.Cliente;

/**
 * Interface de repositório responsável pelo acesso e manipulação
 * dos dados da entidade Cliente.
 * 
 * Estende JpaRepository, que fornece automaticamente operações CRUD:
 * - save()
 * - findAll()
 * - findById()
 * - deleteById()
 * - existsById()
 * 
 * Além disso, define métodos de consulta personalizados baseados
 * em convenções de nomenclatura do Spring Data JPA.
 * 
 * @author Breno
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    /**
     * Busca um cliente pelo email.
     * 
     * O retorno é um Optional para tratar a possibilidade
     * de não existir um cliente com o email informado.
     * 
     * @param email Email do cliente
     * @return Optional contendo o cliente encontrado ou vazio
     */
    Optional<Cliente> findByEmail(String email);

    /**
     * Busca clientes com nome exatamente igual ao informado.
     * 
     * @param nome Nome exato do cliente
     * @return Lista de clientes que possuem o nome informado
     */
    List<Cliente> findByNome(String nome);

    /**
     * Busca clientes cujo nome começa com o valor informado.
     * 
     * Utiliza busca parcial (prefixo), muito útil para filtros e autocomplete.
     * 
     * Exemplo:
     * nome = "Br" → retorna "Breno", "Bruna", etc.
     * 
     * @param nome Prefixo do nome
     * @return Lista de clientes cujo nome inicia com o valor informado
     */
    List<Cliente> findByNomeStartingWith(String nome);
}