/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_gibeon;

import java.util.Scanner;

/**
 *
 * @author Cloud
 */
public class Conta {
    Scanner ler = new Scanner(System.in);
    private String cod_conta;
    double saldo = 0;
    double valorContagemPontos = 0;
    int pontos = 0;
    
    Conta()
    {
        System.out.println("Digite o código da conta");
        this.cod_conta = ler.nextLine();
    }
    public void set_cod_conta(String codigo){
        cod_conta = codigo;
    }
    public void set_pontos(int maisPontos){
        pontos = pontos + maisPontos;
    }
    public void set_valorContagemPontos(double valorAtual){
        valorContagemPontos = valorAtual;
    }
    public String get_cod_conta(){
        return cod_conta;
    }
    public double get_saldo(){
        return saldo;
    }
    public int get_Pontos(){
        return pontos;
    }
    public double get_valorContagemPontos(){
        return valorContagemPontos;
    }

    public void credito_conta(double valor_credito){
        if (valor_credito <= 0) {
            System.out.println("Valor inválido");
            return;
        }
        this.saldo += valor_credito;
        System.out.println("Deposito realizado com sucesso");
    }

    public void debito_conta(double valor_debito){
        if (valor_debito <= 0) {
            System.out.println("Valor inválido");
            return;
        }
        this.saldo -= valor_debito;
        System.out.println("Saque realizado com sucesso");
    }

    public void mostrar_conta(){
        System.out.println("Código da conta: " + this.get_cod_conta());
        System.out.println("Saldo na conta: R$" + this.get_saldo());
        System.out.println("Pontuação da conta: " + this.get_Pontos());
    }

    public void atualizarPontos(double valor_transferido){
        
        double valorContagem = this.get_valorContagemPontos() + valor_transferido; 
        
        while(valorContagem >= 150){
            valorContagem = valorContagem - 150;
            this.set_pontos(1);
        }
        
        this.set_valorContagemPontos(valorContagem);
    }

    public boolean conferindoSaldo(double valor){
        if((this.saldo - valor) < (-1.000)){
            return false;
        } else {
            return true;
        }
     }
}
