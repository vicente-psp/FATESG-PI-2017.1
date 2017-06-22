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
    private String modelo = "";
    private String marca = "";
    private String anoDeFabricacao = "";
    private String motor = "";
    private EnumVeiculo status = null;

    public Veiculo() {

    }

    public Veiculo(int idVeiculo, String placa, String modelo, String marca, String anoDeFabricacao,
            String motor, EnumVeiculo status) {
        this.idVeiculo = idVeiculo;
        this.placa = placa;
        this.status = status;
        this.modelo = modelo;
        this.marca = marca;
        this.anoDeFabricacao = anoDeFabricacao;
        this.motor = motor;
    }

    public int getidVeiculo() {
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

    public EnumVeiculo getStatus() {
        return status;
    }

    public void setStatus(EnumVeiculo status) {
        this.status = status;
    }


    public enum EnumVeiculo {
        DISPONIVEL, LOCADO, VENDIDO, SINISTRADO;
    }

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
    public String getAnoDeFabricacao() {
        return anoDeFabricacao;
    }

    /**
     * @param anoDeFabricacao the anoDeFabricacao to set
     */
    public void setAnoDeFabricacao(String anoDeFabricacao) {
        this.anoDeFabricacao = anoDeFabricacao;
    }

    /**
     * @return the motor
     */
    public String getMotor() {
        return motor;
    }

    /**
     * @param motor the motor to set
     */
    public void setMotor(String motor) {
        this.motor = motor;
    }

}
