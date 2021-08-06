/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_gibeon;

/**
 *
 * @author Cloud
 */
public class Conta_poupanca extends Conta {

    Conta_poupanca()
    {
        /*
        * alteração do requisito 1 questão 4
        * da 3 atividade.
        */
        System.out.println("Digite o valor que deseja guardar na conta: ");
        this.saldo = ler.nextDouble();
    }

    public boolean conferindoSaldo(double valor){
       if((this.saldo - valor) < 0){
           return false;
       } else {
           return true;
       }
    }
 
    public void RenderJuros(double taxa_percentual){
        this.saldo = saldo + (saldo*(taxa_percentual/100));
        System.out.println(saldo);
        System.out.println("Rendimento feito com sucesso!");
        System.out.println();
    }
}
