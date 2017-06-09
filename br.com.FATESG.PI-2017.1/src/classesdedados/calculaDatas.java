/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesdedados;

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
public class calculaDatas {
// metodo que retorna o intervalo de dias entre duas datas
   public String calculaDias(String dataInicialBR, String dataFinalBR) throws ParseException {  
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");  
        df.setLenient(false);  
        Date dataInicio = df.parse(dataInicialBR);  
        Date dataFim = df.parse(dataFinalBR);  
        long dt = (dataFim.getTime() - dataInicio.getTime()) + 3600000;  
        Long diasCorridosAnoLong = (dt / 86400000L);  
        Integer diasDecorridosInt = Integer.valueOf(diasCorridosAnoLong.toString());  
        String diasDecorridos = String.valueOf(diasDecorridosInt); //Sem numeros formatados;  
        return diasDecorridos;  
    } 
// método para pegar a data do dia
    public  String dataAtual(){
        GregorianCalendar calendario = new GregorianCalendar();
        int dia = calendario.get(calendario.DAY_OF_MONTH);
        int mes = calendario.get(calendario.MONTH) + 1;
        int ano = calendario.get(calendario.YEAR);
        String dataIguana = String.valueOf(dia + "/" + mes + "/" + ano);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String diaIguana = df.format(new Date());
        return diaIguana;
    }
// agora para calcular a idade
     public BigDecimal calculaIdade(String dataDoMeuNascimento) throws ParseException{
        BigDecimal qtdDias = new BigDecimal(calculaDias(dataDoMeuNascimento,dataAtual()));
        BigDecimal ano = new BigDecimal(365.25);
        BigDecimal idade = qtdDias.divide(ano,0, RoundingMode.DOWN);
        return idade;        
    }
}
