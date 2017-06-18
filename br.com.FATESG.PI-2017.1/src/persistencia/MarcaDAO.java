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
public class MarcaDAO implements CRUD {

    String diretorio = "C:\\AmbienteTrabalho\\Projetos\\FATESG-PI-2017.1\\br.com.FATESG.PI-2017.1\\src\\arquivos\\";
    String arqMarcas = diretorio + "Marcas.csv";

    FileWriter fwMarcas = null;
    BufferedWriter bwMarcas = null;

    @Override
    public void incluir(Object objeto) throws Exception {
        Marca marca = (Marca) objeto;

        try {
            Object dao = recuperar();
            ArrayList<Marca> alMarcas = (ArrayList<Marca>) dao;

            if (alMarcas != null) {
                //pega o maior ID acrescido de +1
                for (int i = alMarcas.size() - 1; i >= 0; i--) {
                    if (alMarcas.get(i).getDescricao().equals(marca.getDescricao())) {
                        JOptionPane.showMessageDialog(null, "Marca já cadastrada!");
                        return;
                    }
                    if (alMarcas.get(i).getIdMarca() > marca.getIdMarca()) {
                        marca.setIdMarca(alMarcas.get(i).getIdMarca() + 1);
                    }
                }
            } else {
                marca.setIdMarca(1);
            }

            fwMarcas = new FileWriter(arqMarcas, true);
            bwMarcas = new BufferedWriter(fwMarcas);
            String dados = marca.getIdMarca() + ";" + marca.getDescricao() + "\n";
            bwMarcas.write(dados);
            bwMarcas.close();

            JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG01"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG02"));
        }
    }

    @Override
    public ArrayList<Object> recuperar() throws Exception {
        ArrayList<Marca> alMarcas = new ArrayList<>();

        try {
            File fileMarcas = new File(arqMarcas);
            if (!fileMarcas.exists()) {
                return null;
            }
            FileReader frMarcas = new FileReader(fileMarcas);
            BufferedReader brMarcas = new BufferedReader(frMarcas);
            String linhaMarcas = brMarcas.readLine();
            while (linhaMarcas != null && !linhaMarcas.equals("")) {
                Marca marca = new Marca();

                String vMarcas[] = linhaMarcas.split(";");
                marca.setIdMarca(Integer.parseInt(vMarcas[0]));
                marca.setDescricao(vMarcas[1]);

                alMarcas.add(marca);

                linhaMarcas = brMarcas.readLine();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG15"));
        }
        return (ArrayList<Object>) (Object) (alMarcas);
    }

    @Override
    public void excluir(int id) throws Exception {
        Object dao = recuperar();
        ArrayList<Marca> alMarcas = (ArrayList<Marca>) (dao);

        boolean achou = false;
        String dadosMarca = "";

        if (alMarcas.size() >= 0 && alMarcas != null) {
            for (int i = 0; i < alMarcas.size(); i++) {
                if (alMarcas.get(i).getIdMarca() != id) {
                    dadosMarca += alMarcas.get(i).getIdMarca() + ";" + alMarcas.get(i).getDescricao() + "\n";
                } else {
                    achou = true;
                }
            }
        }
        if (achou) {
            fwMarcas = new FileWriter(arqMarcas);
            bwMarcas = new BufferedWriter(fwMarcas);
            bwMarcas.write(dadosMarca);
            bwMarcas.close();
            
            JOptionPane.showMessageDialog(null, "Marca excluída!");
        }else{
            JOptionPane.showMessageDialog(null, "Registro não foi encontrado!");
        }
    }

    @Override
    public void alterar(int id, Object objeto) throws Exception {
        try {
            Object dao = recuperar();
            ArrayList<Marca> alMarcas = (ArrayList<Marca>) (dao);
            Marca objMarca = (Marca) objeto;

            String dadosMarca = "";
            if (alMarcas.size() >= 0 && alMarcas != null) {
                for (int i = 0; i < alMarcas.size(); i++) {
                    if (alMarcas.get(i).getIdMarca() != id) {
                        dadosMarca += alMarcas.get(i).getIdMarca() + ";" + alMarcas.get(i).getDescricao() + "\n";
                    } else {
                        dadosMarca += id + ";" + objMarca.getDescricao() + "\n";
                    }
                }

                if (!dadosMarca.equals("")) {
                    File file = new File(arqMarcas);
                    if (!file.exists()) {
                        fwMarcas = new FileWriter(arqMarcas, false);
                    } else {
                        fwMarcas = new FileWriter(arqMarcas);
                    }

                    fwMarcas = new FileWriter(arqMarcas);
                    bwMarcas = new BufferedWriter(fwMarcas);
                    bwMarcas.write(dadosMarca);
                    bwMarcas.close();
                }
                JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG12"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG13"));
        }
    }

}
