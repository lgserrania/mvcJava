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
import java.util.EventListener;

public interface EnqueteListener extends EventListener{
    
    //Invocado quando um novo voto é contabilizado na Enquete.
    public void novoVoto(EnqueteEvent event);
    
    //Invocado quando uma nova opção é adicionada à Enquete
    public void novaOpcao(EnqueteEvent event);

}
