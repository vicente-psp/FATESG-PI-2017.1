/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesdedados;


/**
 *
 * @author Vicente
 */
public class Telefone {
    private int idPessoa = 0;
    private int ddi = 0;
    private int ddd = 0;
    private int numero = 0;
    private EnumTelefone tipo = null;

    public Telefone() {
    }
    public Telefone(int idPessoa, int ddi, int ddd, int numero, EnumTelefone tipo){
        this.idPessoa = idPessoa;
        this.ddi = ddi;
        this.ddd = ddd;
        this.numero = numero;
        this.tipo = tipo;
    }
            
    
    public int getIdPessoa() {
        return idPessoa;
    }
    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public int getDdi() {
        return ddi;
    }
    public void setDdi(int ddi) {
        this.ddi = ddi;
    }

    public int getDdd() {
        return ddd;
    }
    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public EnumTelefone getTipo() {
        return tipo;
    }
    public void setTipo(EnumTelefone tipo) {
        this.tipo = tipo;
    }
    
    public enum EnumTelefone {
        RESIDENCIAL, PESSOAL, COMERCIAL;
    }
}
