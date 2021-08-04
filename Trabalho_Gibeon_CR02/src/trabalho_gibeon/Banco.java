/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_gibeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Cloud
 */
public class Banco {
    Scanner ler = new Scanner(System.in);
    private List<Conta> Lista_de_contas = new ArrayList<>();
    private List<Conta_poupanca> Lista_de_contas_poupanca = new ArrayList<>();
    private Conta continha;
    
    public Banco() {
        int escolha;
    	System.out.println("ADICIONANDO A PRIMEIRA CONTA DO BANCO");
        System.out.println("Qual o tipo da conta?");
        System.out.println("1-Conta padrão");
        System.out.println("2-Conta bônus");
        escolha = ler.nextByte();
        switch (escolha){
            case 1:
                Conta conta_nova = new Conta();
                Lista_de_contas.add(conta_nova);
                break;
            case 2:
                Conta_poupanca conta_poupanca_nova = new Conta_poupanca();
                Lista_de_contas.add(conta_poupanca_nova);
                Lista_de_contas_poupanca.add(conta_poupanca_nova);
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }

    }
    public void addConta(){
        int escolha;
        System.out.println("Qual o tipo da conta?");
        System.out.println("1-Conta padrão");
        System.out.println("2-Conta bônus");
        System.out.println("3-Conta poupança");
        escolha = ler.nextInt();
        switch (escolha){
            case 1:
                Conta conta_nova = new Conta();
                for(int contador = 0; contador<Lista_de_contas.size(); contador++) {
                    if(Lista_de_contas.get(contador).get_cod_conta().equals(conta_nova.get_cod_conta())) {
                    System.out.println("Já existe uma conta com um código semelhante");
                    return;
                    }
                }
                Lista_de_contas.add(conta_nova);
                System.out.println("Conta criada com sucesso");
                break;
            case 2:
                Conta conta_poupanca_nova = new Conta_poupanca();
                for(int contador = 0; contador<Lista_de_contas.size(); contador++) {
                    if(Lista_de_contas.get(contador).get_cod_conta().equals(conta_poupanca_nova.get_cod_conta())) {
                    System.out.println("Já existe uma conta com um código semelhante");
                    return;
                    }
                }
                Lista_de_contas.add(conta_poupanca_nova);
                Lista_de_contas_poupanca.add((Conta_poupanca) conta_poupanca_nova);
                System.out.println("Conta criada com sucesso");
                break;
            default:
                System.out.println("Opção inválida, tente de novo");
                return;
            }
        }
    public void mostra_saldo(String cod_conta){
        for (int contador = 0; contador < Lista_de_contas.size(); contador++) {
            if (Lista_de_contas.get(contador).get_cod_conta().equals(cod_conta)) {
                System.out.println("O saldo da conta "+ cod_conta);
                System.out.println("É de : R$ " + Lista_de_contas.get(contador).get_saldo());
                return;
            }
        }
        System.out.println("Não achamos nenhuma conta com esse código");
    }
    public void transferencia(String cod_conta_origem, String cod_conta_destino, double valor_transferencia){
        
        int pos_origem;
        int pos_destino;
        
        for (int contador_origem = 0; contador_origem < Lista_de_contas.size(); contador_origem++) {
            if (Lista_de_contas.get(contador_origem).get_cod_conta().equals(cod_conta_origem)) {
                pos_origem = contador_origem;
                Lista_de_contas.get(pos_origem).debito_conta(valor_transferencia);
                break;
            }
            else {
                System.out.println("nenhuma corrêspondencia");
                return;
            }
        }
        
        for (int contador_destino = 0; contador_destino < Lista_de_contas.size(); contador_destino++) {
            if (Lista_de_contas.get(contador_destino).get_cod_conta().equals(cod_conta_destino)) {
                pos_destino = contador_destino;
                Lista_de_contas.get(pos_destino).credito_conta(valor_transferencia);
                Lista_de_contas.get(pos_destino).atualizarPontos(valor_transferencia);
                break;
            }
        }

        System.out.println("Transferência feita com sucesso");
        return;
    }

    public void fazer_deposito(String cod_conta,double valor_deposito){
        for (int contador = 0; contador < Lista_de_contas.size(); contador++) {
            if (cod_conta.equals(Lista_de_contas.get(contador).get_cod_conta())) {
                Lista_de_contas.get(contador).credito_conta(valor_deposito);
                return;
            }
        }
        System.out.println("Nenhuma corrêspondencia");
    }
    public void fazer_saque(String cod_conta,double valor_saque){
        for (int contador = 0; contador < Lista_de_contas.size(); contador++) {
            if (cod_conta.equals(Lista_de_contas.get(contador).get_cod_conta())) {
                Lista_de_contas.get(contador).debito_conta(valor_saque);
                return;
            }
        }
        System.out.println("Nenhuma corrêspondencia");
    }
    public void mostrar_dados_conta(String cod_conta){
         for (int contador = 0; contador < Lista_de_contas.size(); contador++) {
            if (cod_conta.equals(Lista_de_contas.get(contador).get_cod_conta())) {
                Lista_de_contas.get(contador).mostrar_conta();
                return;
            }
        }
        System.out.println("Nenhuma corrêspondecia");
    }
    public void rende_juros(String cod_conta, double percentual_juros){
     for (int contador = 0; contador < Lista_de_contas_poupanca.size(); contador++) {
            if (cod_conta.equals(Lista_de_contas_poupanca.get(contador).get_cod_conta())){              
                Lista_de_contas_poupanca.get(contador).RenderJuros(percentual_juros);
            } 
        }
    }
    public void menu(){
        System.out.println("1-Criar uma nova conta");
        System.out.println("2-Fazer um depósito");
        System.out.println("3-Fazer um saque");
        System.out.println("4- fazer uma transferência");
        System.out.println("5-Mostrar dados da conta");
        System.out.println("6-Render Juros(apenas contas poupança)");
        System.out.println("0-Sair");
    }
}
