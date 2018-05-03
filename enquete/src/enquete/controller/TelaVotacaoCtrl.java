/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enquete.controller;

/**
 *
 * @author a12026
 */
import java.awt.event.*;
import enquete.model.*;

public class TelaVotacaoCtrl implements ActionListener {
    
    private EnqueteSimples enquete;
    
    public TelaVotacaoCtrl(EnqueteSimples enquete){
        this.enquete = enquete;
    }
    
    //Evento lançado pelo clique nos botões da TelaVotação
    public void actionPerformed(ActionEvent event){
        enquete.votar(event.getActionCommand());
    }
    
}
