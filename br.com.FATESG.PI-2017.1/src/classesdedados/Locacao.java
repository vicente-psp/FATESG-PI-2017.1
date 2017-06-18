/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesdedados;
import classesdedados.Pessoa;

/**
 *
 * @author Alexandre Fernandes
 */
public class Locacao {
    private int idLocacao = 0;
    private String dataInicio = "";
    private String dataFim = "";
    private String finalidadeDaLocacao = "";
    private String localSaidaVeiculo = "";
    private String localChegadaVeiculo = "";
    private int kmInicial = 0;
    private int kmFinal = 0;
    private String vistoria = "";
    private EnumLocacao status = null;
    private Pessoa cliente = null;
    
    public Locacao(){
        
    }
    
    public Locacao(int idLocacao, String dataInicio, String dataFim, String finalidadeDaLocacao, String localSaidaVeiculo, String localChegadaVeiculo, int kmInicial, int kmFinal, String vistoria, EnumLocacao status, Pessoa cliente){
        this.idLocacao = idLocacao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.finalidadeDaLocacao = finalidadeDaLocacao;
        this.localChegadaVeiculo = localChegadaVeiculo;
        this.localSaidaVeiculo = localSaidaVeiculo;
        this.vistoria = vistoria;
        this.kmInicial = kmInicial;
        this.kmFinal = kmFinal;
        this.status = status;
        this.cliente = cliente;
    }

    public int getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(int idLocacao) {
        this.idLocacao = idLocacao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getFinalidadeDaLocacao() {
        return finalidadeDaLocacao;
    }

    public void setFinalidadeDaLocacao(String finalidadeDaLocacao) {
        this.finalidadeDaLocacao = finalidadeDaLocacao;
    }

    public String getLocalSaidaVeiculo() {
        return localSaidaVeiculo;
    }

    public void setLocalSaidaVeiculo(String localSaidaVeiculo) {
        this.localSaidaVeiculo = localSaidaVeiculo;
    }

    public String getLocalChegadaVeiculo() {
        return localChegadaVeiculo;
    }

    public void setLocalChegadaVeiculo(String localChegadaVeiculo) {
        this.localChegadaVeiculo = localChegadaVeiculo;
    }

    public int getKmInicial() {
        return kmInicial;
    }

    public void setKmInicial(int kmInicial) {
        this.kmInicial = kmInicial;
    }

    public int getKmFinal() {
        return kmFinal;
    }

    public void setKmFinal(int kmFinal) {
        this.kmFinal = kmFinal;
    }

    public String getVistoria() {
        return vistoria;
    }

    public void setVistoria(String vistoria) {
        this.vistoria = vistoria;
    }

    public enum EnumLocacao {
        LOCADO, DISPONIVEL;
    }

    public EnumLocacao getStatus() {
        return status;
    }

    public void setStatus(EnumLocacao status) {
        this.status = status;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }
    
}
