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
    private EnumVeiculo status = null;
    private Modelo modelo = null;
    private Marca marca = null;
    
    
    public Veiculo(){
        
    }
    public Veiculo(int idVeiculo, String placa, EnumVeiculo status, Modelo modelo, Marca marca){
        this.idVeiculo = idVeiculo;
        this.placa = placa;
        this.status = status;
        this.modelo = modelo;
        this.marca = marca;
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

    public EnumVeiculo getStatus() {
        return status;
    }

    public void setStatus(EnumVeiculo status) {
        this.status = status;
    }
    
    public enum EnumVeiculo{
        DISPONIVEL, LOCADO, VENDIDO, SINISTRADO;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
}
