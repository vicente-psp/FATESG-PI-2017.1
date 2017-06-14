/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import classesdedados.Veiculo;
import classesdedados.GerarId;
import classesdedados.Mensagens;
import classesdedados.Modelo;
import classesdedados.Marca;
import interfacedeclasses.CRUD;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileReader;

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
         Modelo modelo = (Modelo) objeto;
         
        try {
            fwVeiculo = new FileWriter(arqVeiculo, true);
            bwVeiculo = new BufferedWriter(fwVeiculo);
            GerarId gerarId = new GerarId();
            veiculo.setidVeiculo(gerarId.getIdVeiculo());
            
            String dados = veiculo.getidVeiculo() + ";" + veiculo.getPlaca() + ";" + veiculo.getMarca() + ";" + veiculo.getModelo() + ";" + veiculo.getStatus() + "/n";
            bwVeiculo.write(dados);
            bwVeiculo.close();
       
       ArrayList<Veiculo> veiculos = (ArrayList<Veiculo>) recuperar();
       
       for(int i = 0; i < veiculos.size(); i++){
           if(veiculos.get(i).getPlaca().equals(veiculo.getPlaca())){
               JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG02"));
               return;
           }
       }
       
       fwVeiculo = new FileWriter(arqVeiculo, true);
       bwVeiculo = new BufferedWriter(fwVeiculo);
       
                
       String dados = veiculo.getidVeiculo() + ";" + veiculo.getPlaca() + ";" + veiculo.getStatus() + ";" + modelo.getDescricao() + ";" + modelo.getAnoDeFabricacao() + ";" +
               modelo.getMarca() + ";" + modelo.getMotor() + ";" + modelo.getValorLocacao() + "/n";
       bwVeiculo.write(dados);
       bwVeiculo.close();
       
       JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG01"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG02"));
        }
    }

    @Override
    public ArrayList<Object> recuperar() throws Exception {
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        
        try {
            File fileVeiculos = new File(arqVeiculo);
            FileReader frVeiculos = new FileReader(fileVeiculos);
            BufferedReader brVeiculos = new BufferedReader(frVeiculos);
            String linhaVeiculos = brVeiculos.readLine();
            
            while(linhaVeiculos != null && !linhaVeiculos.equals("")){
                Veiculo veiculo = new Veiculo();
                Marca marca = new Marca();
                Modelo modelo = new Modelo();
                
                String vVeiculos[] = linhaVeiculos.split(";");
                veiculo.setidVeiculo(Integer.parseInt(vVeiculos[0]));
                veiculo.setPlaca(vVeiculos[1]);
                modelo.setDescricao(vVeiculos[2]);
                marca.setDescricao(vVeiculos[3]);
                veiculo.setStatus(Enum.valueOf(Veiculo.EnumVeiculo.class, vVeiculos[4]));

            veiculos.add(veiculo);
            linhaVeiculos = brVeiculos.readLine();
            }
            
        } catch (Exception e) {
            
        }
        return (ArrayList<Object>) (Object) (veiculos);
    }


    @Override
    public void excluir(int id) throws Exception {
        
    }

    @Override
    public void alterar(int id, Object objeto) throws Exception {
        try {
            Object objVeiculos = recuperar();
            ArrayList<Veiculo> veiculos = (ArrayList<Veiculo>) (objVeiculos);
            Veiculo objVeiculo = (Veiculo) objeto;
            
            String dadosVeiculo = "";
            
            if(veiculos.size() >= 0 && veiculos != null){
                for (int i = 0; i < veiculos.size(); i++){
                    if(veiculos.get(i).get() != id){
                        
                        dadosVeiculo += veiculos.get(i).getidVeiculo() + ";" + veiculos.get(i).getPlaca() + ";" + veiculos.get(i).getMarca() + ";" + veiculos.get(i).getModelo() + ";" + veiculos.get(i).getStatus() + "/n";
                    }else{
                        dadosVeiculo += id + ";" + objVeiculo.getPlaca() + ";" + objVeiculo.getMarca() + ";" + objVeiculo.getModelo() + ";" + objVeiculo.getStatus() + "/n";
                    }
                }
            }
            bwVeiculo = new BufferedWriter(fwVeiculo);
            bwVeiculo.write(dadosVeiculo);
            bwVeiculo.close();
            
        } catch (Exception e) {
            
        }
    }
    
}
