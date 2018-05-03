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
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Window;
import java.util.HashMap;
import java.util.Map;
import java.awt.Frame;
import enquete.model.EnqueteListener;
import enquete.model.EnqueteEvent;

public class TelaResultadoPercentual extends Window implements EnqueteListener{
    
    private Map<String,Label>labels = new HashMap();

    public TelaResultadoPercentual(Frame parent){
        super(parent);
        this.setSize(180, 120);
        this.setLayout(new GridLayout(0,2));
        this.add(new Label("Votos"));
        this.add(new Label());
    }
    
    public void novaOpcao(EnqueteEvent event){
        String opcao = event.getOpcao();
        
        Label label;
        Label votos;
        if(!labels.containsKey(opcao)){
            label = new Label(opcao + " - ");
            votos = new Label(""+event.getVotos()+"%");
            labels.put(opcao, votos);
            this.add(label);
            this.add(votos);
        }
    }
    
    public void novoVoto(EnqueteEvent event){
        String opcao = event.getOpcao();
        
        Label votos;
        votos = labels.get(opcao);
        votos.setText((""+event.getVotos()*100/event.getTotalVotos()));
    }
}
