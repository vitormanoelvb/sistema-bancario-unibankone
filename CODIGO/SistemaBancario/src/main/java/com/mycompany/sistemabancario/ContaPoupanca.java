/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemabancario;

/**
 *
 * @author Vitor
 */
public class ContaPoupanca extends Conta {
    private double taxaJuros;

    public ContaPoupanca(String numeroConta, Cliente titular, double taxaJuros) {
        super(numeroConta, titular);
        this.taxaJuros = taxaJuros;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public void aplicarJuros() {
        double juros = saldo * taxaJuros;
        saldo += juros;
    }
}