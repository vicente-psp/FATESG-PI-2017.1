/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import interfacedeclasses.CRUD;
import classesdedados.Modelo;
import classesdedados.GerarId;
import classesdedados.Mensagens;
import java.io.BufferedWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author Vicente
 */
public class ModeloDAO implements CRUD{
    
    String diretorio = "C:\\Users\\Vicente\\Google Drive\\ADS\\01 - FATESG\\2017.1\\Projetos Equipe ADS\\Projeto Integrador\\br.com.FATESG.PI-2017.1\\br.com.FATESG.PI-2017.1\\FATESG-PI-2017.1\\br.com.FATESG.PI-2017.1\\src\\arquivos\\";
    String arqModelos = diretorio + "Modelos.csv";
        
    FileWriter fwModelos = null;
    BufferedWriter bwModelos = null;

    @Override
    public void incluir(Object objeto) throws Exception {
        Modelo modelo = (Modelo) objeto;
        
        try {
            fwModelos = new FileWriter(arqModelos, true);
            bwModelos = new BufferedWriter(fwModelos);
            GerarId gerarId = new GerarId();
            modelo.setIdModelo(gerarId.getIdModelo());
            String dados = modelo.getIdModelo() + ";" + modelo.getDescricao() + ";" + modelo.getAnoDeFabricacao() + ";" +
                    modelo.getMarca() + ";" + modelo.getMotor() + ";" + modelo.getValorLocacao() + "/n";
            bwModelos.write(dados);
            bwModelos.close();
            
            gerarId.finalize();
            
            JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG01"));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG02"));
        }
    }

    @Override
    public ArrayList<Object> recuperar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void excluir(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(int id, Object objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
