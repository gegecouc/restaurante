/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author gegec
 */
public class pedido implements Serializable{
    private int id;
    private int id_func;
    private int qnt;
    private String carne;
    private Date data;

    public void setId(int id) {
        this.id = id;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }



    public int getId() {
        return id;
    }

    public int getQnt() {
        return qnt;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getData() {
        return data;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public void setId_func(int id_func) {
        this.id_func = id_func;
    }

    public int getId_func() {
        return id_func;
    }

 
    public pedido(int id, int qnt, int id_func, String carne, Date data) {
        this.id = id;
        this.qnt = qnt;
        this.carne = carne;
        this.data = data;
        this.id_func=id_func;
    }
    
    
}
