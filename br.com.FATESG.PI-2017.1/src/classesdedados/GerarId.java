/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesdedados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandre Fernandes
 */
public class GerarId {
    String diretorio = "C:\\AmbienteTrabalho\\Projetos\\FATESG-PI-2017.1\\br.com.FATESG.PI-2017.1\\src\\arquivos\\";
    private int idPessoa = 0;
    private int idModelo = 0;
    private int idMarca = 0;
    private int idLocacao = 0;
    private int idVeiculo = 0;
        
    String arquivoID = diretorio + "GeradorDeID.csv";

    public GerarId() {

        try {
            File file = new File(arquivoID);
            if(!file.exists()) {
                
                FileWriter fw = new FileWriter(arquivoID, false);
                BufferedWriter bw = new BufferedWriter(fw);

                String saida = 0 + ";" + 0 + ";" + 0 + ";" + 0 + ";" + 0;
                bw.write(saida);

                bw.close();
            }
            
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String linha = br.readLine();
            if(linha != null && !linha.equals("")){
                    String vetorString[] = linha.split(";");
                    idPessoa = Integer.parseInt(vetorString[0]);
                    idModelo = Integer.parseInt(vetorString[1]);
                    idMarca = Integer.parseInt(vetorString[2]);
                    idLocacao = Integer.parseInt(vetorString[3]);
                    idVeiculo = Integer.parseInt(vetorString[4]);
            }
            br.close();
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }

    }

    public int getIdPessoa() {
        return ++idPessoa;
    }

    public int getIdModelo() {
        return ++idModelo;
    }
    
    public int getIdMarca() {
        return ++idMarca;
    }

    public int getIdLocacao() {
        return ++idLocacao;
    }
    
    public int getIdVeiculo(){
        return ++idVeiculo;
    }
        
    @Override
    public void finalize() {
        try {

            FileWriter fw = new FileWriter(arquivoID, false);
            BufferedWriter bw = new BufferedWriter(fw);

            String saida = this.idPessoa + ";" + this.idModelo + ";" + this.idMarca + ";" + this.idLocacao + ";" + this.idVeiculo;
            bw.write(saida);

            bw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    
}
