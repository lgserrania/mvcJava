/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enquete.model;

/**
 *
 * @author a12026
 */
import java.util.EventObject;


public class EnqueteEvent extends EventObject {

    private String opcao = null;
    private int votos = 0;
    
    public EnqueteEvent(EnqueteSimples source){
        super(source);
    }
    
    public EnqueteEvent(EnqueteSimples source, String opcao){
        this(source);
        this.opcao = opcao;
    }
    
    //Retorna a opção associada ao evento gerado
    //A opção pode ser uma nova opção adicionada à EnqueteSimples
    //ou a opção escolhida para adicionar um novo voto.
    public String getOpcao(){
        return opcao;
    }
    
    //Retorna o número de votos da opcao
    public int getVotos(){
        return ((EnqueteSimples)this.source).getVotos(opcao);
    }
    
    //Retorna o total de votos da enquete
    public int getTotalVotos(){
        return ((EnqueteSimples)this.source).getTotalVotos();
    }
    
}
