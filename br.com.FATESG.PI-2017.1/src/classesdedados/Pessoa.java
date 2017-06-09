/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesdedados;

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
    private ArrayList<Email> email = null;
    private ArrayList<Endereco> endereco = null;
    
    
    
    
    public Pessoa(){}
    public Pessoa(int id, String nome, EnumPessoa tipo, ArrayList<Telefone> telefone, ArrayList<Email> email, ArrayList<Endereco> endereco){
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
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

    public ArrayList<Telefone> getTelefone() {
        return telefone;
    }

    public void setTelefone(ArrayList<Telefone> telefone) {
        this.telefone = telefone;
    }

    public ArrayList<Email> getEmail() {
        return email;
    }

    public void setEmail(ArrayList<Email> email) {
        this.email = email;
    }

    public ArrayList<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(ArrayList<Endereco> endereco) {
        this.endereco = endereco;
    }

    public enum EnumPessoa {
        JURIDICA, FISICA;
    }
    
}
