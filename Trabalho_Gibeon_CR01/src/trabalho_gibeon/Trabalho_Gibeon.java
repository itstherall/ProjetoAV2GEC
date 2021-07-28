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
public class Trabalho_Gibeon {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Banco banquinho = new Banco();
        String codigo_conta;
        String codigo_conta2;
        double valor;
        int opcao = 9;
        System.out.println("Bem vindo ao Banco da UF");
        System.out.println("Qual operação desejsa fazer?");
        boolean continuar = true;
        while(opcao != 0 && continuar == true){
            banquinho.menu();
            opcao = ler.nextInt();
            switch(opcao){
                case 0: 
                    return;
                case 1:
                    banquinho.addConta();
                    break;
                case 2:
                    ler.nextLine(); 
                    System.out.println("Entre com o código da conta");
                    codigo_conta = ler.nextLine();
                    System.out.println("Agora com o valor do deposito");
                    valor = ler.nextDouble();
                    banquinho.fazer_deposito(codigo_conta, valor);
                    break;
                case 3:
                    ler.nextLine(); 
                    System.out.println("Entre com o código da conta");
                    codigo_conta = ler.nextLine();
                    System.out.println("Agora com o valor do saque");
                    valor = ler.nextDouble();
                    banquinho.fazer_saque(codigo_conta, valor);
                    break;
                case 4:
                    ler.nextLine(); 
                    System.out.println("Entre com o código da conta origem");
                    codigo_conta = ler.nextLine();
                    System.out.println("Agora com o código da conta destino");
                    codigo_conta2 = ler.nextLine();
                    System.out.println("Agora com o valor a ser transferido");
                    valor = ler.nextDouble();
                    System.out.println(codigo_conta +"," + codigo_conta2+","+ valor);
                    banquinho.transferencia(codigo_conta, codigo_conta2, valor);
                    break;
                case 5:
                    ler.nextLine();
                    System.out.println("Entre com o código da conta");
                    codigo_conta = ler.nextLine();
                    banquinho.mostrar_dados_conta(codigo_conta);
                    break;
                default:
                    System.out.println("Opção inválida");
            }
            System.out.println("Deseja fazer outra operação?1 pra sim, qualquer outro valor irá encerrar");
            int opcao2;
            opcao2 = ler.nextInt();
            if (opcao2 == 1) {
                continuar = true;
            }
            else{
                continuar = false;
            }

        }
    }
} 
