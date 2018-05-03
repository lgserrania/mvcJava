/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enquete.view;

/**
 *
 * @author a12026
 */
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collection;
import enquete.model.EnqueteListener;
import enquete.model.EnqueteEvent;


public class TelaVotacao extends Frame implements EnqueteListener{
    
    private Collection<String> botoes = new ArrayList();
    
    private ActionListener controller;
    
    public TelaVotacao(ActionListener controller){
        super("Tela de votação - Enquete");
        this.setSize(100, 120);
        this.setLayout(new GridLayout(0,1));
        this.controller = controller;
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                e.getWindow().hide();
                System.exit(0);
            }
        });
    }
    
    public void novaOpcao(EnqueteEvent event){
        String opcao = event.getOpcao();
        Button botao;
        
        if(!botoes.contains(opcao)){
            botoes.add(opcao);
            botao = new Button(opcao);
            botao.setActionCommand(opcao);
            botao.addActionListener(controller);
            this.add(botao);
        }
    }
    
    public void novoVoto(EnqueteEvent event){
        
    }
    
}
