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
    private int anoDeFabricacao = 0;
    private float motor = 0;
    private float valorLocacao = 0;
    private Marca marca = null;
    
    public Modelo(){
        
    }
    public Modelo (int idModelo, String descricao, int anoDeFabricacao, float motor, float valorLocacao, Marca marca ){
        this.idModelo = idModelo;
        this.descricao = descricao;
        this.anoDeFabricacao = anoDeFabricacao;
        this.motor = motor;
        this.valorLocacao = valorLocacao;
        this.marca = marca;
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

    public int getAnoDeFabricacao() {
        return anoDeFabricacao;
    }

    public void setAnoDeFabricacao(int anoDeFabricacao) {
        this.anoDeFabricacao = anoDeFabricacao;
    }

    public float getMotor() {
        return motor;
    }

    public void setMotor(float motor) {
        this.motor = motor;
    }

    public float getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(float valorLocacao) {
        this.valorLocacao = valorLocacao;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
        
}
