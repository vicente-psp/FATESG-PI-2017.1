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
public class VeiculoDAO implements CRUD {

    String diretorio = "C:\\AmbienteTrabalho\\Projetos\\FATESG-PI-2017.1\\br.com.FATESG.PI-2017.1\\src\\arquivos\\";
    String arqVeiculo = diretorio + "Veiculo.csv";

    FileWriter fwVeiculo = null;
    BufferedWriter bwVeiculo = null;

    @Override
    public void incluir(Object objeto) throws Exception {
        Veiculo veiculo = (Veiculo) objeto;

        try {
            fwVeiculo = new FileWriter(arqVeiculo, true);
            bwVeiculo = new BufferedWriter(fwVeiculo);
            GerarId gerarId = new GerarId();
            veiculo.setidVeiculo(gerarId.getIdVeiculo());
            String dados = veiculo.getidVeiculo() + ";" + veiculo.getMarca() + ";" + veiculo.getModelo() + ";" + veiculo.getAnoDeFabricacao() + ";" + veiculo.getMotor() + ";" + veiculo.getPlaca() + ";" + veiculo.getStatus() + "\n";
            bwVeiculo.write(dados);
            bwVeiculo.close();

            gerarId.finalize();
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
            if (!fileVeiculos.exists()) {
                return null;
            }
            FileReader frVeiculos = new FileReader(fileVeiculos);
            BufferedReader brVeiculos = new BufferedReader(frVeiculos);
            String linhaVeiculos = brVeiculos.readLine();
            while (linhaVeiculos != null && !linhaVeiculos.equals("")) {
                Veiculo veiculo = new Veiculo();

                String vVeiculos[] = linhaVeiculos.split(";");
                veiculo.setidVeiculo(Integer.parseInt(vVeiculos[0]));
                veiculo.setMarca(vVeiculos[1]);
                veiculo.setModelo(vVeiculos[2]);
                veiculo.setAnoDeFabricacao((vVeiculos[3]));
                veiculo.setMotor((vVeiculos[4]));
                veiculo.setPlaca(vVeiculos[5]);
                veiculo.setStatus(Enum.valueOf(Veiculo.EnumVeiculo.class, vVeiculos[6]));

                veiculos.add(veiculo);
                linhaVeiculos = brVeiculos.readLine();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG15"));
        }
        return (ArrayList<Object>) (Object) (veiculos);
    }

    @Override
    public void excluir(int id) throws Exception {
        Object objVeiculos = recuperar();
        ArrayList<Veiculo> veiculos = (ArrayList<Veiculo>) (objVeiculos);

        boolean achou = false;
        String dadosVeiculo = "";

        if (veiculos.size() >= 0 && veiculos != null) {
            for (int i = 0; i < veiculos.size(); i++) {
                if (veiculos.get(i).getidVeiculo() != id) {

                    dadosVeiculo += veiculos.get(i).getidVeiculo() + ";" + veiculos.get(i).getMarca() + ";"
                            + veiculos.get(i).getModelo() + ";" + veiculos.get(i).getAnoDeFabricacao() + ";"
                            + veiculos.get(i).getMotor() + ";" + veiculos.get(i).getPlaca() + ";" + veiculos.get(i).getStatus() + "\n";
                } else {
                    achou = true;
                }
            }
        }
        if (achou) {
            fwVeiculo = new FileWriter(arqVeiculo);
            bwVeiculo = new BufferedWriter(fwVeiculo);
            bwVeiculo.write(dadosVeiculo);
            bwVeiculo.close();

            JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG04"));
        } else {
            JOptionPane.showMessageDialog(null, "Registro não foi encontrado!");
        }

    }

    @Override
    public void alterar(int id, Object objeto) throws Exception {
        try {
            Object objVeiculos = recuperar();
            ArrayList<Veiculo> veiculos = (ArrayList<Veiculo>) (objVeiculos);
            Veiculo objVeiculo = (Veiculo) objeto;

            String dadosVeiculo = "";

            if (veiculos.size() >= 0 && veiculos != null) {
                for (int i = 0; i < veiculos.size(); i++) {
                    if (veiculos.get(i).getidVeiculo() != id) {

                        dadosVeiculo += veiculos.get(i).getidVeiculo() + ";" + veiculos.get(i).getMarca() + ";"
                                + veiculos.get(i).getModelo() + ";" + veiculos.get(i).getAnoDeFabricacao() + ";"
                                + veiculos.get(i).getMotor() + ";" + veiculos.get(i).getPlaca() + ";" + veiculos.get(i).getStatus() + "\n";
                    } else {
                        dadosVeiculo += id + ";" + objVeiculo.getMarca() + ";" + objVeiculo.getModelo() + ";"
                                + objVeiculo.getAnoDeFabricacao() + ";" + objVeiculo.getMotor() + ";" + objVeiculo.getPlaca()
                                + ";" + objVeiculo.getStatus() + "\n";
                    }
                }

                if (!dadosVeiculo.equals("")) {
                    File file = new File(arqVeiculo);
                    if (!file.exists()) {
                        fwVeiculo = new FileWriter(arqVeiculo, false);
                    } else {
                        fwVeiculo = new FileWriter(arqVeiculo);
                    }
                    fwVeiculo = new FileWriter(arqVeiculo);
                    bwVeiculo = new BufferedWriter(fwVeiculo);
                    bwVeiculo.write(dadosVeiculo);
                    bwVeiculo.close();
                }
                JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG12"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG13"));
        }
    }
}
