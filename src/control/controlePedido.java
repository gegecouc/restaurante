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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.item;
import model.pedido;

/**
 *
 * @author gegec
 */
public class controlePedido {
    private Vector vecPedido;
    private final String arquivo = "pedido.dat";

    public controlePedido() throws Exception {
        vecPedido = new Vector();
        desserializaPedido();
      
    }

    public void cadastrarPedido(int id, int id_func, int qnt, String carne, String dataPedido) {
       try {
            Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataPedido);
            vecPedido.add(new pedido(id, id_func, qnt, carne, data));
            serializaPedido();
        } catch (ParseException ex) {
            Logger.getLogger(controlePedido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(controlePedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     private void serializaPedido() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream(arquivo);
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(vecPedido);
        objOS.flush();
        objOS.close();
    }

    private void desserializaPedido() throws Exception {
        File objFile = new File(arquivo);
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream(arquivo);
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            vecPedido = (Vector) objIS.readObject();
            objIS.close();
        }
    }
    
    //------------------------------------------------------------//
    //LISTAGEM
    //------------------------------------------------------------//
    private String getPedido(pedido objPpedido) {

        return "ID: " + objPpedido.getId()
                + "  Id do Func: " + objPpedido.getId_func()
                + "  Qnt: " + objPpedido.getQnt()
                + "  Item: " + objPpedido.getCarne()
                + "  Data: " + objPpedido.getData()
                + "\n";
    }

    
     public String listaPedido() {
        String result = "";
        pedido objPedido = null;
      
        for (int intIdx = 0; intIdx < vecPedido.size(); intIdx++) {
            objPedido = (pedido) vecPedido.elementAt(intIdx);
            result += getPedido(objPedido);
        }
        if (result.equalsIgnoreCase("")) {
            return "Não existem Pedidos cadastrados.";
        } else {
            return result;
        }
    }
     
   public void getDia(String data){
             Calendar cal = Calendar.getInstance();
             System.out.println(data);
             try {
                Date nova_data = new SimpleDateFormat("dd/mm/yyyy").parse(data);
                cal.setTime(nova_data);
                System.out.println(nova_data);
                boolean monday = cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY;
                System.out.println(monday);
            } catch (ParseException ex) {
                Logger.getLogger(controlePedido.class.getName()).log(Level.SEVERE, null, ex);
            }  
    }
}
