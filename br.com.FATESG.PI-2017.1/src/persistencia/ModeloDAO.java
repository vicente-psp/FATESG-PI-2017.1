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
    
    String diretorio = "C:\\Users\\Vicente\\Desktop\\Teste\\FATESG-PI-2017.1\\br.com.FATESG.PI-2017.1\\src\\arquivos\\";
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
            String dados = modelo.getIdModelo() + ";" + modelo.getDescricao() + ";" + modelo.getMarca() + "\n"; 
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
            if (!fileModelos.exists()) {
                return null;
            }
            FileReader frModelos = new FileReader(fileModelos);
            BufferedReader brModelos = new BufferedReader(frModelos);
            String linhaModelos = brModelos.readLine();
            while (linhaModelos != null && !linhaModelos.equals("")){
                Modelo modelo = new Modelo();
                
                String vModelos[] = linhaModelos.split(";");
                modelo.setIdModelo(Integer.parseInt(vModelos[0]));
                modelo.setDescricao(vModelos[1]);
                modelo.setMarca(vModelos[2]);
                
                modelos.add(modelo);
                
                linhaModelos = brModelos.readLine();
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG15"));
        }
        return (ArrayList<Object>) (Object) modelos;
    }


    @Override
    public void excluir(int id) throws Exception {
        Object objModelos = recuperar();
        ArrayList<Modelo> modelos = (ArrayList<Modelo>) (objModelos);

        boolean achou = false;
        String dadosModelo = "";

        if(modelos.size() >= 0 && modelos != null){
            for (int i = 0; i < modelos.size(); i++){
                if(modelos.get(i).getIdModelo() != id){

                    dadosModelo += modelos.get(i).getIdModelo() + ";" + modelos.get(i).getDescricao() + ";" +
                            modelos.get(i).getMarca() + "\n";
                }else{
            achou = true;
        }
            }
        }
        if (achou){
            fwModelos = new FileWriter(arqModelos);
            bwModelos = new BufferedWriter(fwModelos);
            bwModelos.write(dadosModelo);
            bwModelos.close();
        }
        JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG04"));
        
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
                        dadosModelo += modelos.get(i).getIdModelo() + ";" + modelos.get(i).getDescricao() + ";" + modelos.get(i).getMarca() + "\n";
                    }else{
                        dadosModelo += id + ";" + objModelo.getDescricao() + ";" + objModelo.getMarca() + "\n";
                    }
                }
                
                if(!dadosModelo.equals("")){
                    File file = new File(arqModelos);
                    if(!file.exists()){
                        fwModelos = new FileWriter(arqModelos, false);
                    }else {
                        fwModelos = new FileWriter (arqModelos);
                    }
                    
                    fwModelos = new FileWriter(arqModelos);
                    bwModelos = new BufferedWriter(fwModelos);
                    bwModelos.write(dadosModelo);
                    bwModelos.close();
                }
                JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG12"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG13"));
            
        }
    }
    
}