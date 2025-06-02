/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemabancario;

/**
 *
 * @author Vitor
 */
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
    private String numeroCliente;
    private List<Conta> contas;

    public Cliente() {
        super();
        this.contas = new ArrayList<>();
    }

    public Cliente(String nome, String cpf, String endereco, String numeroCliente) {
        super(nome, cpf, endereco);
        this.numeroCliente = numeroCliente;
        this.contas = new ArrayList<>();
    }

    public String getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public void abrirConta(Conta conta) {
        contas.add(conta);
    }

    public void listarContas() {
        if (contas.isEmpty()) {
            System.out.println("Este cliente nao possui contas cadastradas.");
        } else {
            System.out.println("Contas do cliente " + getNome() + ":");
            for (Conta conta : contas) {
                System.out.println("- Conta Nº " + conta.getNumeroConta() + " | Saldo: R$ " + conta.getSaldo());
            }
        }
    }

    public List<Conta> getContas() {
        return contas;
    }

    public int getIdade() {
        if (getDataNascimento() != null) {
            return Period.between(getDataNascimento(), LocalDate.now()).getYears();
        } else {
            return 0;
        }
    }
}