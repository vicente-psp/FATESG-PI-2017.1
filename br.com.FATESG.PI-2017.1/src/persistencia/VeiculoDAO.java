/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import classesdedados.Veiculo;
import interfacedeclasses.CRUD;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Vicente
 */
public class VeiculoDAO implements CRUD{
    String diretorio = "C:\\Users\\Vicente\\Google Drive\\ADS\\01 - FATESG\\2017.1\\Projetos Equipe ADS\\Projeto Integrador\\br.com.FATESG.PI-2017.1\\br.com.FATESG.PI-2017.1\\FATESG-PI-2017.1\\br.com.FATESG.PI-2017.1\\src\\arquivos\\";
    String arqVeiculo = diretorio + "Veiculo.csv";
    
    FileWriter fwVeiculo = null;
    BufferedWriter bwVeiculo = null;
    
    @Override
    public void incluir(Object objeto) throws Exception {
       Veiculo veiculo = (Veiculo) objeto;
       fwVeiculo = new FileWriter(arqVeiculo, true);
       bwVeiculo = new BufferedWriter(fwVeiculo);
              
       String dados = veiculo.getPlaca() + ";" + veiculo.getStatus() + "/n";
       bwVeiculo.write(dados);
       
       JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso.");
       
       bwVeiculo.close();
       
    }

    @Override
    public ArrayList<Object> recuperar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int id) throws Exception {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
