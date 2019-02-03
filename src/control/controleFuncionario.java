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
import model.funcionario;

/**
 *
 * @author gegec
 */
public class controleFuncionario {
    private Vector vecFuncionario;
    private final String arquivo = "funcionario.dat";

    public controleFuncionario() throws Exception {
        vecFuncionario = new Vector();
        desserializaFuncionario();
        
    }

    public void cadastrarFuncionario(int id, String nome, String email) {
        vecFuncionario.add(new funcionario(id, nome, email));
        try {
            serializaFuncionario();
        } catch (Exception ex) {
            Logger.getLogger(controleFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     private void serializaFuncionario() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream(arquivo);
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(vecFuncionario);
        objOS.flush();
        objOS.close();
    }

    private void desserializaFuncionario() throws Exception {
        File objFile = new File(arquivo);
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream(arquivo);
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            vecFuncionario = (Vector) objIS.readObject();
            objIS.close();
        }
    }
    
    //------------------------------------------------------------//
    //LISTAGEM
    //------------------------------------------------------------//
    private String getFuncionario(funcionario objPfuncionario) {

        return "ID: " + objPfuncionario.getId()
                + "  Nome: " + objPfuncionario.getNome()
                + "  Email: " + objPfuncionario.getEmail()               
                + "\n";
    }

    
     public String listaFuncionario() {
        String result = "";
        funcionario objFuncionario = null;
        for (int intIdx = 0; intIdx < vecFuncionario.size(); intIdx++) {
            objFuncionario = (funcionario) vecFuncionario.elementAt(intIdx);
            result += getFuncionario(objFuncionario);
        }
        if (result.equalsIgnoreCase("")) {
            return "Não existem funcionários cadastrados.";
        } else {
            return result;
        }
    }
}

