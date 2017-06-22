/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesdedados;

import classesdedados.Pessoa;
import java.util.*;
import java.text.*;

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
    private Veiculo veiculo = null;
    private float valorLocacao = (float) 0.0;
    private float valorCaucao = (float) 0.0;
    private String dataDevolucao = "";

    public Locacao() {

    }

    public Locacao(int idLocacao, String dataInicio, String dataFim, String finalidadeDaLocacao, String localSaidaVeiculo,
            String localChegadaVeiculo, int kmInicial, int kmFinal, String vistoria, EnumLocacao status, Pessoa cliente, Veiculo veiculo,
            float valorLocacao, float valorCaucao, String dataDevolucao) {
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
        this.veiculo = veiculo;
        this.valorLocacao = valorLocacao;
        this.valorCaucao = valorCaucao;
        this.dataDevolucao = dataDevolucao;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
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

    public float getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(float valorLocacao) {
        this.valorLocacao = valorLocacao;
    }

    public float getValorCaucao() {
        return valorCaucao;
    }

    public void setValorCaucao(float valorCaucao) {
        this.valorCaucao = valorCaucao;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public float calcularLocacao(Modelo.EnumCategoria categoria, int dias) {
        float valor = (float) 0.0;
        if (categoria.toString().equals("BASICO")) {
            valor = (float) 100.0 * dias;
        } else if (categoria.toString().equals("COMPLETO")) {
            valor = (float) 150.0 * dias;
        }
        return (float) valor;
    }

    public int calculaDias(String data1, String data2) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        Date d1 = df.parse(data1);
        Date d2 = df.parse(data2);
        long dt = (d2.getTime() - d1.getTime()) + 3600000; // 1 hora para compensar horário de verão
        return (int)(dt / 86400000L);
    }

}
