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
    private double saldo = 0;
    
    Conta()
    {
        System.out.println("Digite o código da conta");
        this.cod_conta = ler.nextLine();
    }
    public void set_cod_conta(String codigo){
        cod_conta = codigo;
    }
    public String get_cod_conta(){
        return cod_conta;
    }
    public double get_saldo(){
        return saldo;
    }
    public void credito_conta(double valor_credito){
        if (valor_credito <= 0) {
            System.out.println("Valor inválido");
            System.out.println();
            return;
        }
        this.saldo += valor_credito;
        System.out.println("Deposito realizado com sucesso");
        System.out.println();
    }
    public void debito_conta(double valor_debito){
        if (valor_debito <= 0) {
            System.out.println("Valor inválido");
            System.out.println();
            return;
        }
        this.saldo -= valor_debito;
        System.out.println("Saque realizado com sucesso");
        System.out.println();
    }
    
    public void mostrar_conta(){

        System.out.println("Dados da conta " + this.get_cod_conta());
        System.out.println("Código da conta: " + this.get_cod_conta());
        System.out.println("Saldo na conta: R$" + this.get_saldo());
        System.out.println();
    }
}
