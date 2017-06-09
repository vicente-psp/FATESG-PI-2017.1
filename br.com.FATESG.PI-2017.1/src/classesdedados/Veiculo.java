/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesdedados;

/**
 *
 * @author renatowsilva
 */
public class Veiculo {
    private String placa = "";
    private EnumVeiculo status = null;
    
    
    public Veiculo(){
        
    }
    public Veiculo(String placa, EnumVeiculo status){
        this.placa = placa;
        this.status = status;
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
}
