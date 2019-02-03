/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.item;

/**
 *
 * @author gegec
 */
public class controleItem {
    private Vector vecItem;
    private final String arquivo = "item.dat";

    public controleItem() throws Exception {
        vecItem = new Vector();
        desserializaItem();
        
    }

    public void cadastrarItem(int id, String nome, int qnt) {
        vecItem.add(new item(id, nome, qnt));
        try {
            serializaItem();
        } catch (Exception ex) {
            Logger.getLogger(controleItem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     private void serializaItem() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream(arquivo);
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(vecItem);
        objOS.flush();
        objOS.close();
    }

    private void desserializaItem() throws Exception {
        File objFile = new File(arquivo);
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream(arquivo);
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            vecItem = (Vector) objIS.readObject();
            objIS.close();
        }
    }
    
    //------------------------------------------------------------//
    //LISTAGEM
    //------------------------------------------------------------//
    private String getItem(item objPitem) {

        return "ID: " + objPitem.getId()
                + "  Nome: " + objPitem.getNome()
                + "  Qnt: " + objPitem.getQnt()
                + "\n";
    }

    
     public String listaItem() {
        String result = "";
        item objItem = null;
        for (int intIdx = 0; intIdx < vecItem.size(); intIdx++) {
            objItem = (item) vecItem.elementAt(intIdx);
            result += getItem(objItem);
        }
        if (result.equalsIgnoreCase("")) {
            return "Não existem Itens cadastrados.";
        } else {
            return result;
        }
    }
}

