/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemabancario;

/**
 *
 * @author Vitor
 */
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Cliente> listaClientes;
    private List<Conta> listaContas;

    public Banco(String nome) {
        this.nome = nome;
        this.listaClientes = new ArrayList<>();
        this.listaContas = new ArrayList<>();
    }

    public void cadastrarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public Cliente buscarClientePorCpf(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "").trim();
        for (Cliente c : listaClientes) {
            String cpfCliente = c.getCpf().replaceAll("[^0-9]", "").trim();
            if (cpfCliente.equals(cpf)) {
                return c;
            }
        }
        return null;
    }

    public void adicionarConta(Conta conta) {
        listaContas.add(conta);
    }

    public Conta buscarContaPorNumero(String numeroConta) {
        for (Conta c : listaContas) {
            if (c.getNumeroConta().equals(numeroConta)) {
                return c;
            }
        }
        return null;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public List<Conta> getListaContas() {
        return listaContas;
    }

    public String getNome() {
        return nome;
    }
} 