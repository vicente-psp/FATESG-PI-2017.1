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
public class Endereco {

    private int idPessoa = 0;
    private String logradouro = "";
    private int numero = 0;
    private String complemento = "";
    private int cep = 0;
    private String bairro = "";
    private String cidade = "";
    private String estado = "";
    private String pais = "";

    public Endereco() {
    }

    public Endereco(int idPessoa, String logradouro, int numero, String complemento,
            int cep, String bairro, String cidade, String estado, String pais) {
        this.idPessoa = idPessoa;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) throws Exception {
        if (idPessoa <= 0) {
            throw new Exception(new Mensagens().mensagem("MSG11"));
        }
        this.idPessoa = idPessoa;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) throws Exception {
        if (logradouro.length() == 0) {
            throw new Exception(new Mensagens().mensagem("MSG11"));
        }
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) throws Exception {
        if (numero <= 0) {
            throw new Exception(new Mensagens().mensagem("MSG14"));
        }
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) throws Exception {
        String validaCep = String.valueOf(cep);
        if (validaCep.length() != 8) {
            throw new Exception(new Mensagens().mensagem("MSG14"));
        }
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) throws Exception {
        if (bairro.length() == 0) {
            throw new Exception(new Mensagens().mensagem("MSG11"));
        }
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) throws Exception {
        if (cidade.length() == 0) {
            throw new Exception(new Mensagens().mensagem("MSG11"));
        }
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) throws Exception {
        if (estado.length() == 0) {
            throw new Exception(new Mensagens().mensagem("MSG11"));
        }
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) throws Exception {
        if (pais.length() == 0) {
            throw new Exception(new Mensagens().mensagem("MSG11"));
        }
        this.pais = pais;
    }

}
