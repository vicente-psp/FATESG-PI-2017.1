/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesdedados;
import classesdedados.Modelo;
import classesdedados.Marca;

/**
 *
 * @author renatowsilva
 */
public class Veiculo {
    private int idVeiculo = 0;
    private String placa = "";
    private String status = "";
    private String modelo = "";
    private String marca = "";
    protected int anoDeFabricacao = 0;
    protected float motor = 0;
    
    
    public Veiculo(){
        
    }
    public Veiculo(int idVeiculo, String placa, String status, String modelo, String marca, int anoDeFabricacao,
                            float motor){
        this.idVeiculo = idVeiculo;
        this.placa = placa;
        this.status = status;
        this.modelo = modelo;
        this.marca = marca;
        this.anoDeFabricacao = anoDeFabricacao;
        this.motor = motor;
    }

    public int getidVeiculo(){
        return idVeiculo;
    }
    
    public void setidVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

//    public EnumVeiculo getStatus() {
//        return status;
//    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getStatus() {
        return status;
    }
    
//    public enum EnumVeiculo{
//        DISPONIVEL, LOCADO, VENDIDO, SINISTRADO;
//    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the anoDeFabricacao
     */
    public int getAnoDeFabricacao() {
        return anoDeFabricacao;
    }

    /**
     * @param anoDeFabricacao the anoDeFabricacao to set
     */
    public void setAnoDeFabricacao(int anoDeFabricacao) {
        this.anoDeFabricacao = anoDeFabricacao;
    }

    /**
     * @return the motor
     */
    public float getMotor() {
        return motor;
    }

    /**
     * @param motor the motor to set
     */
    public void setMotor(float motor) {
        this.motor = motor;
    }
    
}
