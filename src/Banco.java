/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_gibeon;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cloud
 */
public class Banco {
    private List<Conta> Lista_de_contas = new ArrayList<>();
    private Conta continha;
    
    public Banco() {
        System.out.println();
    	System.out.println("ADICIONANDO A PRIMEIRA CONTA DO BANCO");
    	Conta conta_nova;
    	Lista_de_contas.add(conta_nova = new Conta());
    }
    void addConta(){
    	Conta conta_nova = new Conta();
    	for(int contador = 0; contador<Lista_de_contas.size(); contador++) {
                if(Lista_de_contas.get(contador).get_cod_conta().equals(conta_nova.get_cod_conta())) {
                        System.out.println("Já existe uma conta com um código semelhante");
                        return;
                }
            }
        Lista_de_contas.add(conta_nova);
        System.out.println("Conta criada com sucesso!!!");
        System.out.println();
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
        System.out.println();
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
            System.out.println("nenhuma corrêspondencia");
            System.out.println();
            return;
        }
        for (int contador_destino = 0; contador_destino < Lista_de_contas.size(); contador_destino++) {
            if (Lista_de_contas.get(contador_destino).get_cod_conta().equals(cod_conta_destino)) {
                pos_destino = contador_destino;
                Lista_de_contas.get(pos_destino).credito_conta(valor_transferencia);
                break;
            }
        }
        System.out.println("Transferência feita com sucesso");
        System.out.println();
    }
    public void fazer_deposito(String cod_conta,double valor_deposito){
        for (int contador = 0; contador < Lista_de_contas.size(); contador++) {
            if (cod_conta.equals(Lista_de_contas.get(contador).get_cod_conta())) {
                Lista_de_contas.get(contador).credito_conta(valor_deposito);
                return;
            }
        }
        System.out.println("Nenhuma corrêspondencia");
        System.out.println();
    }
    public void fazer_saque(String cod_conta,double valor_saque){
        for (int contador = 0; contador < Lista_de_contas.size(); contador++) {
            if (cod_conta.equals(Lista_de_contas.get(contador).get_cod_conta())) {
                Lista_de_contas.get(contador).debito_conta(valor_saque);
                return;
            }
        }
        System.out.println("Nenhuma corrêspondencia");
        System.out.println();
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
    public void menu(){

        System.out.println("   1-Criar uma nova conta");
        System.out.println("   2-Fazer um depósito");
        System.out.println("   3-Fazer um saque");
        System.out.println("   4-Fazer uma transferência");
        System.out.println("   5-Mostrar dados da conta");
        System.out.println("   0-Sair");
        System.out.println("--------------------------------");
        System.out.println();
    }
}
