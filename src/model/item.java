/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author gegec
 */
public class item implements Serializable{
    private int id;
    private String nome;
    private int qnt;

    public item(int id, String nome, int qnt) {
        this.id = id;
        this.nome = nome;
        this.qnt = qnt;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getQnt() {
        return qnt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }
   
}
