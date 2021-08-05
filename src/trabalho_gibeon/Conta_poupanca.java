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
 
    public void RenderJuros(double taxa_percentual){
        this.saldo = saldo + (saldo*(taxa_percentual/100));
        System.out.println(saldo);
        System.out.println("Rendimento feito com sucesso");
    }
}
