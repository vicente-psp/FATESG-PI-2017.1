/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import classesdedados.GerarId;
import classesdedados.Pessoa;
import interfacedeclasses.CRUD;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Vicente
 */
public class PessoaDAO implements CRUD{
    String diretorio = "C:\\Users\\Vicente\\Google Drive\\ADS\\01 - FATESG\\2017.1\\Projetos Equipe ADS\\Projeto Integrador\\br.com.FATESG.PI-2017.1\\br.com.FATESG.PI-2017.1\\FATESG-PI-2017.1\\br.com.FATESG.PI-2017.1\\src\\arquivos\\";
    String arqPJ = diretorio + "PessoaJuridica.csv";
    String arqPF = diretorio + "PessoaFisica.csv";
    String arqTelefone = diretorio + "Telefone.csv";
    String arqEndereco = diretorio + "Endereco.csv";
    String arqEmail = diretorio + "Email.csv";
    
    FileWriter fwPessoa = null;
    BufferedWriter bwPessoa = null;
    FileWriter fwTelefone = null;
    
    @Override
    public void incluir(Object objeto) throws Exception {
        Pessoa pessoa = (Pessoa) objeto;
        
        if(pessoa.getTipo().toString().equals("FISICA")){
            fwPessoa = new FileWriter(arqPF, true);
        }else{
            fwPessoa = new FileWriter(arqPJ, true);
        }
        bwPessoa = new BufferedWriter(fwPessoa);
        GerarId gerarId = new GerarId();
        pessoa.setId(gerarId.getIdPessoa());
        
        String dados = pessoa.getId() + ";" + pessoa.getNome() + ";" + pessoa.getTipo().toString() + "\n";
        bwPessoa.write(dados);
        
        JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso.");
        
        gerarId.finalize();
        bwPessoa.close();
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
