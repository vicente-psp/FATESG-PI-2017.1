/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import classesdedados.GerarId;
import classesdedados.Marca;
import classesdedados.Mensagens;
import interfacedeclasses.CRUD;
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
public class MarcaDAO implements CRUD{
    
    String diretorio = "/Users/renatowsilva/Documents/Faculdade Senai/Segundo Semestre/NetBeansProjects/FATESG-PI-2017.1/br.com.FATESG.PI-2017.1/src/arquivos/";
    String arqMArcas = diretorio + "Marcas.csv";
        
    FileWriter fwMarcas = null;
    BufferedWriter bwMarcas = null;
    
    @Override
    public void incluir(Object objeto) throws Exception {
       Marca marca = (Marca) objeto;
       
        try {
            fwMarcas = new FileWriter(arqMArcas, true);
            bwMarcas = new BufferedWriter(fwMarcas);
            GerarId gerarId = new GerarId();
            marca.setIdMarca(gerarId.getIdMarca());
            String dados = marca.getIdMarca() + ";" + marca.getDescricao() + "\n";
            bwMarcas.write(dados);
            bwMarcas.close();
            
            gerarId.finalize();
            JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG01"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG02"));
        }
    }

    @Override
    public ArrayList<Object> recuperar() throws Exception {
        ArrayList<Object> marcas = new ArrayList<>();
        
        try {
            File fileMarcas = new File(arqMArcas);
            FileReader frMarcas = new FileReader(fileMarcas);
            BufferedReader brMarcas = new BufferedReader(frMarcas);
            String linhaMarcas = brMarcas.readLine();
            while (linhaMarcas != null && !linhaMarcas.equals("")){
                Marca marca = new Marca();
                
                String vMarcas[] = linhaMarcas.split(";");
                marca.setIdMarca(Integer.parseInt(vMarcas[0]));
                marca.setDescricao(vMarcas[1]);
            
                marcas.add(marca);
                
                linhaMarcas = brMarcas.readLine();
            }            
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG15"));
        }
        return marcas;
    }

    @Override
    public void excluir(int id) throws Exception {
        Object objMarcas = recuperar();
        ArrayList<Marca> marcas = (ArrayList<Marca>) (objMarcas);
        
        boolean achou = false;
        String dadosMarca = "";
        
        if(marcas.size() >= 0 && marcas != null){
            for (int i = 0; i < marcas.size(); i++){
                if(marcas.get(i).getIdMarca() != id){
                    
                    dadosMarca += marcas.get(i).getIdMarca() + ";" + marcas.get(i).getDescricao() + "/n";
                }
            }
        }else {
            achou = true;
        }
        if (achou){
            fwMarcas = new FileWriter(arqMArcas);
            bwMarcas = new BufferedWriter(fwMarcas);
            bwMarcas.write(dadosMarca);
            bwMarcas.close();
        }
    }

    @Override
    public void alterar(int id, Object objeto) throws Exception {
        try {
            Object objMarcas = recuperar();
            ArrayList<Marca> marcas = (ArrayList<Marca>) (objMarcas);
            Marca objMarca = (Marca) objeto;
            
            String dadosMarca = "";
            
            if(marcas.size() >= 0 && marcas != null){
                for (int i = 0; i < marcas.size(); i++){
                    if(marcas.get(i).getIdMarca() != id){
                        
                        dadosMarca += marcas.get(i).getIdMarca() + ";" + marcas.get(i).getDescricao() + "/n";
                    }else {
                        dadosMarca += id + ";" + objMarca.getDescricao() + "/n";
                    }
                }
                fwMarcas = new FileWriter(arqMArcas);
                bwMarcas = new BufferedWriter(fwMarcas);
                bwMarcas.write(dadosMarca);
                bwMarcas.close();
                
                if(!dadosMarca.equals("")){
                    File file = new File(arqMArcas);
                    if(!file.exists()){
                        fwMarcas = new FileWriter(arqMArcas, false);
                    }else {
                        fwMarcas = new FileWriter(arqMArcas);
                    }
                }
                JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG12"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG13"));
        }
    }
    
}
