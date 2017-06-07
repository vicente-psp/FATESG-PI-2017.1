/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesdedados;

import enumeradores.EnumPessoa;
import java.util.ArrayList;

/**
 *
 * @author Vicente
 */
public class Pessoa {
    private int id = 0;
    private String nome = "";
    private EnumPessoa tipo = null;
    private ArrayList<Telefone> telefone = null;
    
    
    Pessoa(){}
    Pessoa(int id, String nome, EnumPessoa tipo){
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public EnumPessoa getTipo() {
        return tipo;
    }
    public void setTipo(EnumPessoa tipo) {
        this.tipo = tipo;
    }

    
    
}
