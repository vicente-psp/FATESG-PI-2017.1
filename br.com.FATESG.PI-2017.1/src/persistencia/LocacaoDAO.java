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
        ArrayList<Locacao> locacoes = new ArrayList<>();
        
        try {
            File fileLocacao = new File(arqLocacao);
            if(!fileLocacao.exists()){
                return null;
            }
            FileReader frLocacao = new FileReader(fileLocacao);
            BufferedReader brLocacao = new BufferedReader(frLocacao);
            String linhaLocacao = brLocacao.readLine();
            while (linhaLocacao != null && !linhaLocacao.equals("")){
                Locacao locacao = new Locacao();
                
                String vLocacao[] = linhaLocacao.split(";");
                locacao.setIdLocacao(Integer.parseInt(vLocacao[0]));
                locacao.setLocalSaidaVeiculo(vLocacao[1]);
                locacao.setLocalChegadaVeiculo(vLocacao[2]);
                locacao.setDataInicio(vLocacao[3]);
                locacao.setDataFim(vLocacao[4]);
                locacao.setFinalidadeDaLocacao(vLocacao[5]);
                locacao.setKmInicial(Integer.parseInt(vLocacao[6]));
                locacao.setKmFinal(Integer.parseInt(vLocacao[7]));
                locacao.setVistoria(vLocacao[8]);
                locacao.setStatus(Enum.valueOf(Locacao.EnumLocacao.class, vLocacao[9]));
                
                locacoes.add(locacao);
                
                linhaLocacao = brLocacao.readLine();                
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG15"));
        }
        return (ArrayList<Object>) (Object) (locacoes);
    }

    @Override
    public void alterar(int id, Object objeto) throws Exception {
        try {
            Object locacao = recuperar();
            ArrayList<Locacao> locacoes = (ArrayList<Locacao>) (locacao);
            Locacao objLocacao = (Locacao) objeto;
            
            String dadosLocacao = "";
            
                if(locacoes.size() >= 0 && locacoes != null){
                    for(int i = 0; i < locacoes.size(); i++){
                        if (locacoes.get(i).getIdLocacao() != id){
                            dadosLocacao += locacoes.get(i).getIdLocacao() + ";" + locacoes.get(i).getLocalSaidaVeiculo() + ";" + locacoes.get(i).getLocalChegadaVeiculo() + ";" +
                        locacoes.get(i).getFinalidadeDaLocacao() + ";" + locacoes.get(i).getDataInicio() + ";" + locacoes.get(i).getDataFim() + ";" + locacoes.get(i).getVistoria() + ";" +
                        locacoes.get(i).getKmInicial() + ";" + locacoes.get(i).getKmFinal() + ";" + locacoes.get(i).getStatus() + "/n"; 
                        }else {
                            dadosLocacao += id + ";" + objLocacao.getIdLocacao() + ";" + objLocacao.getLocalSaidaVeiculo() + ";" + objLocacao.getLocalChegadaVeiculo() + ";" +
                        objLocacao.getFinalidadeDaLocacao() + ";" + objLocacao.getDataInicio() + ";" + objLocacao.getDataFim() + ";" + objLocacao.getVistoria() + ";" +
                        objLocacao.getKmInicial() + ";" + objLocacao.getKmFinal() + ";" + objLocacao.getStatus() + "/n";
                        }
                    }
                    if (!dadosLocacao.equals("")){
                        File file = new File(arqLocacao);
                        if (!file.exists()){
                            fwLocacao = new FileWriter(arqLocacao, false);
                        }else{
                            fwLocacao = new FileWriter(arqLocacao);
                        }
                        fwLocacao = new FileWriter(arqLocacao);
                        bwLocacao = new BufferedWriter(fwLocacao);
                        bwLocacao.write(dadosLocacao);
                        bwLocacao.close();
                    }
                    JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG12"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG13"));
        }
    }

    @Override
    public void excluir(int id) throws Exception {
       Object locacao = recuperar();
       ArrayList<Locacao> locacoes = (ArrayList<Locacao>) (locacao);
       
       boolean achou = false;
       String dadosLocacao = "";
       
        if(locacoes.size() >= 0 && locacoes != null){
            for (int i = 0; i < locacoes.size(); i++){
                if(locacoes.get(i).getIdLocacao() != id){
                dadosLocacao += locacoes.get(i).getIdLocacao() + ";" + locacoes.get(i).getLocalSaidaVeiculo() + ";" + locacoes.get(i).getLocalChegadaVeiculo() + ";" +
                        locacoes.get(i).getFinalidadeDaLocacao() + ";" + locacoes.get(i).getDataInicio() + ";" + locacoes.get(i).getDataFim() + ";" + locacoes.get(i).getVistoria() + ";" +
                        locacoes.get(i).getKmInicial() + ";" + locacoes.get(i).getKmFinal() + ";" + locacoes.get(i).getStatus() + "/n";
            }else {
                    achou = true;
                }
        }
    }
        if (achou)  {
            fwLocacao = new FileWriter(arqLocacao);
            bwLocacao = new BufferedWriter(fwLocacao);
            bwLocacao.write(dadosLocacao);
            bwLocacao.close();
            
            JOptionPane.showMessageDialog(null, "MSG04");
        }else{
            JOptionPane.showMessageDialog(null, "MSG16");
        }
    }
    
}
