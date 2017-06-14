/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesdedados;

import java.util.InputMismatchException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Vicente
 */
public class PessoaFisica extends Pessoa{
    private Date dataDeNasc = null;
    private String cpf = "";
    private String cnh = "";
    private EnumCnh categoriaCnh = null;
    private Date validadeCnh = null;
    private EnumSexo sexo = null;
    
    public PessoaFisica(){        
    }
    public PessoaFisica(Date dataDeNasc, String cpf, String cnh, EnumCnh categoriaCnh, Date validadeCnh, EnumSexo sexo)throws Exception{
        this.dataDeNasc = dataDeNasc;
        this.cpf = cpf;
        this.cnh = cnh;
        this.categoriaCnh = categoriaCnh;
        this.validadeCnh = validadeCnh;
        this.sexo = sexo;
    }
    
    public Date getDataDeNasc() {
        return dataDeNasc;
    }
    public void setDataDeNasc(Date dataDeNasc)throws Exception{
        this.dataDeNasc = dataDeNasc;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf)throws Exception{
        if(cpf.length() != 11 && cpf.length() != 14)throw new Exception("CPF inválido!");
        cpf = cpf.replace('.', ' ');
        cpf = cpf.replace('-', ' ');
        cpf = cpf.replaceAll(" ", "");
        this.cpf = cpf;
        if(!validaCpf())throw new Exception("CPF inválido!");
    }

    public String getCnh() {
        return cnh;
    }
    public void setCnh(String cnh)throws Exception{
        this.cnh = cnh;
    }

    public EnumCnh getCategoriaCnh() {
        return categoriaCnh;
    }
    public void setCategoriaCnh(EnumCnh categoriaCnh)throws Exception{
        this.categoriaCnh = categoriaCnh;
    }

    public Date getValidadeCnh() {
        return validadeCnh;
    }
    public void setValidadeCnh(Date validadeCnh)throws Exception{
        this.validadeCnh = validadeCnh;
    }

    public EnumSexo getSexo() {
        return sexo;
    }
    public void setSexo(EnumSexo sexo){
        this.sexo = sexo;
    }
    
    private boolean validaCpf(){
// considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (this.cpf.equals("00000000000") || this.cpf.equals("11111111111")
                || this.cpf.equals("22222222222") || this.cpf.equals("33333333333")
                || this.cpf.equals("44444444444") || this.cpf.equals("55555555555")
                || this.cpf.equals("66666666666") || this.cpf.equals("77777777777")
                || this.cpf.equals("88888888888") || this.cpf.equals("99999999999")
                || (this.cpf.length() != 11)) {
            return (false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
// Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
// converte o i-esimo caractere do CPF em um numero:
// por exemplo, transforma o caractere '0' no inteiro 0         
// (48 eh a posicao de '0' na tabela ASCII)         
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48); // converte no respectivo caractere numerico
            }
// Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

// Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    private String formatoCPF() {
        return (this.cpf.substring(0, 3) + "." + this.cpf.substring(3, 6) + "."
                + this.cpf.substring(6, 9) + "-" + this.cpf.substring(9, 11));
    }
  
    public enum EnumSexo {
        M, F;
    }
    
    public enum EnumCnh {
        B, C, D, E, AB, AC, AD, AE;
    }
    
    public BigDecimal calcularIdade() throws ParseException {
        String data = String.valueOf(this.dataDeNasc);
        
        // pega a data atual
        GregorianCalendar calendario = new GregorianCalendar();
        String dataIguana = String.valueOf(calendario.DAY_OF_MONTH + "/" + calendario.MONTH + "/" + calendario.YEAR);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String dataAtual = df.format(new Date());
        
        //retorna o intervalo de dias entre duas datas
        DateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");  
        df.setLenient(false);  
        Date dataInicio = df2.parse(data);  
        Date dataFim = df2.parse(dataAtual);  
        long dt = (dataFim.getTime() - dataInicio.getTime()) + 3600000;  
        Long diasCorridosAnoLong = (dt / 86400000L);  
        Integer diasDecorridosInt = Integer.valueOf(diasCorridosAnoLong.toString());  
        String contaDias = String.valueOf(diasDecorridosInt); //Sem numeros formatados; 
        
        // agora para calcular a idade
        BigDecimal qtdDias = new BigDecimal(contaDias);
        BigDecimal ano = new BigDecimal(365.25);
        BigDecimal idade = qtdDias.divide(ano, 0, RoundingMode.DOWN);
        return idade;
    }
    
}
