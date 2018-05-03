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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EnqueteSimples {
    
    private Map <String, Integer> opcoes;
    private List <EnqueteListener> enqueteListeners = new LinkedList();
    
    public EnqueteSimples(){
        opcoes = new HashMap<String,Integer>();
    }
    
    //Adiciona uma opção para ser votada na enquete
    public void addOpcao(String opcao){
        opcoes.put(opcao,new Integer(0));
        this.disparaNovaOpcao(opcao);
    }
    
    //Retorna um iterador de opções disponíveis na enquete
    public Set<String> getOpcoes(){
        return opcoes.keySet();
    }
    
    //Incrementa um voto para opção
    public void votar(String opcao){
        int votoAtual = ((Integer) opcoes.get(opcao)).intValue();
        opcoes.put(opcao, new Integer(++votoAtual));
        this.disparaNovoVoto(opcao);
    }
    
    //Retorna a soma dos votos de todas as opções da enquete
    public int getTotalVotos(){
        int total = 0;
        for(Integer votos : opcoes.values()){
            total += votos.intValue();
        }
        return total;
    }
    
    //Retorna a quantidade de votos de uma opção individual
    public int getVotos(String opcao){
        return (opcoes.get(opcao)).intValue();
    }
    
    //Adiciona um EnqueteListener
    public synchronized void addEnqueteListener(EnqueteListener liste){
        if(enqueteListeners.contains(liste)) return;
        this.enqueteListeners.add(liste);
    }
    
    //Adiciona um EnqueteListener, um objeto interessado em receber
    //eventos lançados pela Enquete
    private synchronized void disparaNovoVoto(String opcao){
        for(EnqueteListener listeners : this.enqueteListeners){
            listeners.novoVoto(new EnqueteEvent(this,opcao));           
        }
    }
    
    //Informa aos objetos interessados nos eventos lançados
    //pela Enquete que uma nova opção foi adicionada
    private synchronized void disparaNovaOpcao(String opcao){
        for(EnqueteListener listeners : this.enqueteListeners){
            listeners.novaOpcao(new EnqueteEvent(this,opcao));           
        }
    }
    
}
