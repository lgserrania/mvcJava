/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enquete;

/**
 *
 * @author a12026
 */
import enquete.model.EnqueteSimples;
import enquete.controller.TelaVotacaoCtrl;
import enquete.view.*;

public class Enquete {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Modelo
        EnqueteSimples enquete = new EnqueteSimples();
        
        //Controlador da Interface "TelaVotacao"
        TelaVotacaoCtrl ctrl = new TelaVotacaoCtrl(enquete);
        
        //Interface que altera o estado do modelo
        TelaVotacao votacao = new TelaVotacao(ctrl);
        
        //Interface que exibe o resultado absoluto
        TelaResultado resultado = new TelaResultado(votacao);
        resultado.setLocation(120, 5);
        
        //Interface que exibe o resultado percentual
        TelaResultadoPercentual resultadoPerc = new TelaResultadoPercentual(votacao);
        resultadoPerc.setLocation(250, 5);
        
        //Adicionando as interfaces interessadas na mudança do estado do modelo
        enquete.addEnqueteListener(votacao);
        enquete.addEnqueteListener(resultado);
        enquete.addEnqueteListener(resultadoPerc);
        
        //Povoando modelo
        enquete.addOpcao("Opção 1");
        enquete.addOpcao("Opção 2");
        enquete.addOpcao("Opção 3");
        enquete.addOpcao("Opção 4");
        
        //Exibindo a interface
        votacao.show();
        resultado.show();
        resultadoPerc.show();
    }
    
}
