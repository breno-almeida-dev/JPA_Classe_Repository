package com.atividade.clientes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.atividade.clientes.model.Cliente;
import com.atividade.clientes.repository.ClienteRepository;

/**
 * Controller responsável por expor os endpoints REST para gerenciamento de clientes.
 * 
 * Esta classe segue o padrão RESTful, permitindo operações de:
 * - Criação (POST)
 * - Consulta (GET)
 * - Exclusão (DELETE)
 * 
 * Utiliza o ClienteRepository para persistência dos dados.
 * 
 * @author Breno
 */
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    /**
     * Repositório responsável pelo acesso aos dados da entidade Cliente.
     * Injetado via construtor (Dependency Injection).
     */
    private final ClienteRepository repository;

    /**
     * Construtor para injeção do repositório.
     * 
     * @param repository Repositório de clientes
     */
    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    /**
     * Endpoint responsável por cadastrar um novo cliente.
     * 
     * Realiza validações básicas antes de persistir os dados.
     * 
     * Método HTTP: POST
     * URL: /clientes
     * 
     * @param cliente Objeto Cliente recebido no corpo da requisição (JSON)
     * @return Cliente salvo no banco de dados
     * @throws RuntimeException caso algum campo obrigatório esteja inválido
     */
    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente) {

        // Validação do nome
        if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
            throw new RuntimeException("Nome é obrigatório");
        }

        // Validação do email
        if (cliente.getEmail() == null || cliente.getEmail().isEmpty()) {
            throw new RuntimeException("Email é obrigatório");
        }

        // Validação do CPF
        if (cliente.getCpf() == null || cliente.getCpf().isEmpty()) {
            throw new RuntimeException("CPF é obrigatório");
        }

        // Persiste o cliente no banco de dados
        return repository.save(cliente);
    }

    /**
     * Endpoint para listar todos os clientes cadastrados.
     * 
     * Método HTTP: GET
     * URL: /clientes
     * 
     * @return Lista de todos os clientes
     */
    @GetMapping
    public List<Cliente> listar() {
        return repository.findAll();
    }

    /**
     * Endpoint para buscar um cliente pelo ID.
     * 
     * Método HTTP: GET
     * URL: /clientes/{id}
     * 
     * @param id Identificador do cliente
     * @return Cliente encontrado ou null caso não exista
     */
    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id) {
        Optional<Cliente> cliente = repository.findById(id);
        return cliente.orElse(null);
    }

    /**
     * Endpoint para deletar um cliente pelo ID.
     * 
     * Método HTTP: DELETE
     * URL: /clientes/{id}
     * 
     * @param id Identificador do cliente
     * @return Mensagem informando o resultado da operação
     */
    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Cliente removido com sucesso!";
        }
        return "Cliente não encontrado!";
    }

    /**
     * Endpoint para buscar clientes pelo nome (prefixo).
     * 
     * Método HTTP: GET
     * URL: /clientes/buscarPorNome?nome=valor
     * 
     * @param nome Prefixo do nome a ser buscado
     * @return Lista de clientes cujo nome começa com o valor informado
     */
    @GetMapping("/buscarPorNome")
    public List<Cliente> buscarPorNome(@RequestParam String nome) {
        return repository.findByNomeStartingWith(nome);
    }

    /**
     * Endpoint para buscar um cliente pelo email.
     * 
     * Método HTTP: GET
     * URL: /clientes/buscarPorEmail?email=valor
     * 
     * @param email Email do cliente
     * @return Cliente encontrado ou null caso não exista
     */
    @GetMapping("/buscarPorEmail")
    public Cliente buscarPorEmail(@RequestParam String email) {
        return repository.findByEmail(email).orElse(null);
    }
}