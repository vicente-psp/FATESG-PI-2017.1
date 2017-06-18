/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;
import interfacedeclasses.CRUD;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import classesdedados.GerarId;
import classesdedados.Locacao;
import classesdedados.GerarId;
import classesdedados.Mensagens;

/**
 *
 * @author Alexandre Fernandes
 */
public class LocacaoDAO implements CRUD {
    
    String diretorio = "C:\\Users\\Vicente\\Google Drive\\ADS\\01 - FATESG\\2017.1\\Projetos Equipe ADS\\Projeto Integrador\\br.com.FATESG.PI-2017.1\\br.com.FATESG.PI-2017.1\\FATESG-PI-2017.1\\br.com.FATESG.PI-2017.1\\src\\arquivos\\";
    String arqLocacao = diretorio + "Locacao.csv";
        
    FileWriter fwLocacao = null;
    BufferedWriter bwLocacao = null;

    @Override
    public void incluir(Object objeto) throws Exception {
        Locacao locacao = (Locacao) objeto;
        
        try {
            fwLocacao = new FileWriter(arqLocacao, true);
            bwLocacao = new BufferedWriter(fwLocacao);
            GerarId gerarId = new GerarId();
            locacao.setIdLocacao(gerarId.getIdLocacao());
            String dados = locacao.getIdLocacao() + ";" + locacao.getDataInicio() + ";" + locacao.getDataFim() + ";" + locacao.getFinalidadeDaLocacao() + ";" + locacao.getLocalSaidaVeiculo() + ";"
                    + locacao.getLocalChegadaVeiculo() + ";" + locacao.getVistoria() + ";" + locacao.getKmInicial() + ";" + locacao.getKmFinal() + ";" + locacao.getCliente() + ";" + locacao.getStatus() + "/n";
            bwLocacao.write(dados);
            bwLocacao.close();
            
            gerarId.finalize();
            
            JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG01"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG02"));
        }
    }

    @Override
    public ArrayList<Object> recuperar() throws Exception {
        ArrayList<Locacao> locacao = new ArrayList<>();
        
        try {
            File fileLocacao = new File(arqLocacao);
            FileReader frLocacao = new FileReader(fileLocacao);
            BufferedReader brLocacao = new BufferedReader(frLocacao);
            String linhaLocacao = brLocacao.readLine();
            
        } catch (Exception e) {
        }
        return (ArrayList<Object>) (Object) (locacao);
    }

    @Override
    public void alterar(int id, Object objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
