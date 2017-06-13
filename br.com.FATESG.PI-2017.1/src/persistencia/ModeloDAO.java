/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import interfacedeclasses.CRUD;
import classesdedados.Modelo;
import classesdedados.GerarId;
import classesdedados.Marca;
import classesdedados.Mensagens;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
        ArrayList<Modelo> modelos = new ArrayList<>();
        
        try {
            File fileModelos = new File(arqModelos);
            FileReader frModelos = new FileReader(fileModelos);
            BufferedReader brModelos = new BufferedReader(frModelos);
            String linhaModelos = brModelos.readLine();
            while (linhaModelos != null && !linhaModelos.equals("")){
                Modelo modelo = new Modelo();
                Marca marca = new Marca();
                
                String vModelos[] = linhaModelos.split(";");
                modelo.setIdModelo(Integer.parseInt(vModelos[0]));
                modelo.setDescricao(vModelos[1]);
                modelo.setAnoDeFabricacao(Integer.parseInt(vModelos[2]));
                modelo.setMotor(Float.parseFloat(vModelos[3]));
                modelo.setValorLocacao(Float.parseFloat(vModelos[4]));
                marca.setDescricao(vModelos[5]);
                
                modelos.add(modelo);
                
                linhaModelos = brModelos.readLine();
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG15"));
        }
        return (ArrayList<Object>) (Object) (modelos);
    }


    @Override
    public void excluir(int id) throws Exception {
        try {
            Object objModelos = recuperar();
            ArrayList<Modelo> modelos = (ArrayList<Modelo>) (objModelos);
            
            boolean achou = false;
            String dadosModelo = "";
            
            if(modelos.size() >= 0 && modelos != null){
                for (int i = 0; i < modelos.size(); i++){
                    if(modelos.get(i).getIdModelo() != id){
                        
                        dadosModelo += modelos.get(i).getIdModelo() + ";" + modelos.get(i).getDescricao() + ";" + modelos.get(i).getAnoDeFabricacao() + ";" +
                                modelos.get(i).getMarca() + ";" + modelos.get(i).getMotor() + ";" + modelos.get(i).getValorLocacao() + "/n";
                    }
                }
            }else{
                achou = true;
            }
            if (achou){
                fwModelos = new FileWriter(arqModelos);
                bwModelos = new BufferedWriter(fwModelos);
                bwModelos.write(dadosModelo);
                bwModelos.close();
            }
            JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG04"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG17"));
        }
    }

    @Override
    public void alterar(int id, Object objeto) throws Exception {
        try {
            Object objModelos = recuperar();
            ArrayList<Modelo> modelos = (ArrayList<Modelo>) (objModelos);
            Modelo objModelo = (Modelo) objeto;
            
            String dadosModelo = "";
            
            if(modelos.size() >= 0 && modelos != null){
                for(int i = 0; i < modelos.size(); i++){
                    if(modelos.get(i).getIdModelo() != id){
                        
                        dadosModelo += modelos.get(i).getIdModelo() + ";" + modelos.get(i).getDescricao() + ";" + modelos.get(i).getAnoDeFabricacao() + ";" + modelos.get(i).getMarca() +
                                ";" + modelos.get(i).getMotor() + ";" + modelos.get(i).getValorLocacao() + "/n";
                    }else{
                        dadosModelo += id + ";" + objModelo.getDescricao() + ";" + objModelo.getAnoDeFabricacao() + ";" + objModelo.getMarca() + ";" + objModelo.getMotor() + ";" + objModelo.getValorLocacao() + "/n";
                    }
                }
                fwModelos = new FileWriter(arqModelos);
                bwModelos = new BufferedWriter(fwModelos);
                bwModelos.write(dadosModelo);
                bwModelos.close();
                
                if(!dadosModelo.equals("")){
                    File file = new File(arqModelos);
                    if(!file.exists()){
                        fwModelos = new FileWriter(arqModelos, false);
                    }else {
                        fwModelos = new FileWriter (arqModelos);
                    }
                }
                JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG12"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG13"));
            
        }
    }
    
}
