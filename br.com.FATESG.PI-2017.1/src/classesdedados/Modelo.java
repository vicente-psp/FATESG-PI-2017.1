/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesdedados;

import classesdedados.Marca;

/**
 *
 * @author Alexandre Fernandes
 */
public class Modelo {

    

    private int idModelo = 0;
    private String descricao = "";
    private EnumCategoria categoria = null;
    private float valorLocacao = 0;
    private String marca = "";

    public Modelo() {

    }

    public Modelo(int idModelo, String descricao, int anoDeFabricacao,
            float motor, float valorLocacao, String marca, EnumCategoria categoria) {
        this.idModelo = idModelo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.valorLocacao = valorLocacao;
        this.marca = marca;
    }
    
    public EnumCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(EnumCategoria categoria) {
        this.categoria = categoria;
    }
    
    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(float valorLocacao) {
        this.valorLocacao = valorLocacao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public enum EnumCategoria {
        BASICO, COMPLETO;
    }
}
