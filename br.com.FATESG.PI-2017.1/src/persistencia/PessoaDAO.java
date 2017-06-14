/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import classesdedados.Email;
import classesdedados.Endereco;
import classesdedados.GerarId;
import classesdedados.Mensagens;
import classesdedados.Pessoa;
import classesdedados.PessoaFisica;
import classesdedados.Telefone;
import interfacedeclasses.CRUD;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.text.SimpleDateFormat;

/**
 *
 * @author Vicente
 */
public class PessoaDAO implements CRUD {

    String diretorio = "C:\\AmbienteTrabalho\\Projetos\\FATESG-PI-2017.1\\br.com.FATESG.PI-2017.1\\src\\arquivos\\";
    String arqClientes = diretorio + "Clientes.csv";
    String arqTelefone = diretorio + "Telefone.csv";
    String arqEndereco = diretorio + "Endereco.csv";
    String arqEmail = diretorio + "Email.csv";

    FileWriter fwClientes = null;
    BufferedWriter bwClientes = null;
    FileWriter fwTelefones = null;
    BufferedWriter bwTelefones = null;
    FileWriter fwEmails = null;
    BufferedWriter bwEmails = null;
    FileWriter fwEnderecos = null;
    BufferedWriter bwEnderecos = null;

    @Override
    public void incluir(Object objeto) throws Exception {
        PessoaFisica pessoaFisica = (PessoaFisica) objeto;

        try {
            fwClientes = new FileWriter(arqClientes, true);
            bwClientes = new BufferedWriter(fwClientes);
            GerarId gerarId = new GerarId();
            pessoaFisica.setId(gerarId.getIdPessoa());
            String dados = pessoaFisica.getId() + ";" + pessoaFisica.getNome().toUpperCase() + ";"
                    + pessoaFisica.getDataDeNasc().toString() + ";" + pessoaFisica.getCpf() + ";"
                    + pessoaFisica.getCnh() + ";" + pessoaFisica.getCategoriaCnh().toString() + ";"
                    + pessoaFisica.getValidadeCnh().toString() + ";" + pessoaFisica.getTipo().toString() + "\n";
            bwClientes.write(dados);
            bwClientes.close();

            ArrayList<Telefone> telefones = pessoaFisica.getTelefone();
            ArrayList<Email> emails = pessoaFisica.getEmail();
            ArrayList<Endereco> enderecos = pessoaFisica.getEndereco();

            fwTelefones = new FileWriter(arqTelefone, true);
            bwTelefones = new BufferedWriter(fwTelefones);
            if (telefones != null) {
                for (int i = 0; i < telefones.size(); i++) {
                    String dadosTelefone = pessoaFisica.getId() + ";" + telefones.get(i).getDdi() + ";"
                            + telefones.get(i).getDdd() + ";" + telefones.get(i).getNumero()
                            + ";" + telefones.get(i).getTipo() + "\n";
                    bwTelefones.write(dadosTelefone);
                }
            }
            bwTelefones.close();

            fwEmails = new FileWriter(arqEmail, true);
            bwEmails = new BufferedWriter(fwEmails);
            if (emails != null) {
                for (int i = 0; i < emails.size(); i++) {
                    String dadosEmail = pessoaFisica.getId() + ";" + emails.get(i).getEmail().toUpperCase() + "\n";
                    bwEmails.write(dadosEmail);
                }
            }
            bwEmails.close();

            fwEnderecos = new FileWriter(arqEndereco, true);
            bwEnderecos = new BufferedWriter(fwEnderecos);
            if (enderecos != null) {
                for (int i = 0; i < enderecos.size(); i++) {
                    String dadosEndereco = pessoaFisica.getId() + ";" + enderecos.get(i).getLogradouro().toUpperCase() + ";" + enderecos.get(i).getNumero()
                            + ";" + enderecos.get(i).getComplemento().toUpperCase() + ";" + enderecos.get(i).getCep() + ";"
                            + enderecos.get(i).getBairro().toUpperCase() + ";" + enderecos.get(i).getCidade().toUpperCase() + ";"
                            + enderecos.get(i).getEstado().toUpperCase() + ";" + enderecos.get(i).getPais().toUpperCase() + "\n";
                    bwEnderecos.write(dadosEndereco);
                }
            }
            bwEnderecos.close();

            gerarId.finalize();
            JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG01"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG02"));
        }
    }

    @Override
    public ArrayList<Object> recuperar() throws Exception {
        ArrayList<PessoaFisica> alPessoaFisica = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        try {
            File fileClientes = new File(arqClientes);
            FileReader frClientes = new FileReader(fileClientes);
            BufferedReader brClientes = new BufferedReader(frClientes);
            String linhaClientes = brClientes.readLine();
            while (linhaClientes != null && !linhaClientes.equals("")) {
                PessoaFisica pessoaFisica = new PessoaFisica();
                String vClientes[] = linhaClientes.split(";");
                pessoaFisica.setId(Integer.parseInt(vClientes[0]));
                pessoaFisica.setNome(vClientes[1]);
                pessoaFisica.setDataDeNasc(sdf.parse(vClientes[2]));
                pessoaFisica.setCpf(vClientes[3]);
                pessoaFisica.setCnh(Integer.parseInt(vClientes[4]));
                pessoaFisica.setCategoriaCnh(Enum.valueOf(PessoaFisica.EnumCnh.class, vClientes[5]));
                pessoaFisica.setValidadeCnh(sdf.parse(vClientes[6]));
                pessoaFisica.setTipo(Enum.valueOf(Pessoa.EnumPessoa.class, vClientes[7]));

                ArrayList<Telefone> alTelefones = new ArrayList<>();
                try {
                    File fileTelefones = new File(arqTelefone);
                    FileReader frTelefones = new FileReader(fileTelefones);
                    BufferedReader brTelefones = new BufferedReader(frTelefones);
                    String linhaTelefones = brTelefones.readLine();
                    while (linhaTelefones != null && !linhaTelefones.equals("")) {
                        Telefone telefone = new Telefone();
                        String vTelefones[] = linhaTelefones.split(";");
                        if (pessoaFisica.getId() == Integer.parseInt(vTelefones[0])) {
                            telefone.setIdPessoa(Integer.parseInt(vTelefones[0]));
                            telefone.setDdi(Integer.parseInt(vTelefones[1]));
                            telefone.setDdd(Integer.parseInt(vTelefones[2]));
                            telefone.setNumero(Integer.parseInt(vTelefones[3]));
                            telefone.setTipo(Enum.valueOf(Telefone.EnumTelefone.class, vTelefones[4]));

                            alTelefones.add(telefone);
                        }
                        linhaTelefones = brTelefones.readLine();
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG15"));
                }

                ArrayList<Email> alEmails = new ArrayList<>();
                try {
                    File fileEmails = new File(arqEmail);
                    FileReader frEmails = new FileReader(fileEmails);
                    BufferedReader brEmails = new BufferedReader(frEmails);
                    String linhaEmails = brEmails.readLine();
                    while (linhaEmails != null && !linhaEmails.equals("")) {
                        Email email = new Email();
                        String vEmaisl[] = linhaEmails.split(";");
                        if (pessoaFisica.getId() == Integer.parseInt(vEmaisl[0])) {
                            email.setIdPessoa(Integer.parseInt(vEmaisl[0]));
                            email.setEmail(vEmaisl[1]);

                            alEmails.add(email);
                        }
                        linhaEmails = brEmails.readLine();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG15"));
                }

                ArrayList<Endereco> alEnderecos = new ArrayList<>();
                try {
                    File fileEnderecos = new File(arqEndereco);
                    FileReader frEnderecos = new FileReader(fileEnderecos);
                    BufferedReader brEnderecos = new BufferedReader(frEnderecos);
                    String linhaEnderecos = brEnderecos.readLine();
                    while (linhaEnderecos != null && !linhaEnderecos.equals("")) {
                        Endereco endereco = new Endereco();
                        String vEnderecos[] = linhaEnderecos.split(";");
                        if (pessoaFisica.getId() == Integer.parseInt(vEnderecos[0])) {
                            endereco.setIdPessoa(Integer.parseInt(vEnderecos[0]));
                            endereco.setLogradouro(vEnderecos[1]);
                            endereco.setNumero(Integer.parseInt(vEnderecos[2]));
                            endereco.setComplemento(vEnderecos[3]);
                            endereco.setCep(Integer.parseInt(vEnderecos[4]));
                            endereco.setBairro(vEnderecos[5]);
                            endereco.setCidade(vEnderecos[6]);
                            endereco.setEstado(vEnderecos[7]);
                            endereco.setPais(vEnderecos[8]);

                            alEnderecos.add(endereco);
                        }
                        linhaEnderecos = brEnderecos.readLine();
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG15"));
                }

                pessoaFisica.setEndereco(alEnderecos);
                pessoaFisica.setEmail(alEmails);
                pessoaFisica.setTelefone(alTelefones);
                alPessoaFisica.add(pessoaFisica);
                linhaClientes = brClientes.readLine();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar informações"); //alterar msg depois
        }

        return (ArrayList<Object>) (Object) (alPessoaFisica);
    }

    @Override
    public void alterar(int id, Object objeto) throws Exception {
        try {
            Object objPessoas = recuperar();
            ArrayList<Pessoa> alPessoa = (ArrayList<Pessoa>) (objPessoas);
            Pessoa objPessoa = (Pessoa) objeto;

            String dadosCliente = "";
            String dadosTels = "";
            String dadosEmails = "";
            String dadosEnderecos = "";

            if (alPessoa.size() >= 0 && alPessoa != null) {
                for (int i = 0; i < alPessoa.size(); i++) {
                    if (alPessoa.get(i).getId() != id) { //adiciona os clientes que não foram modificados
                        //adiciona as informações do cliente
                        dadosCliente += alPessoa.get(i).getId() + ";" + alPessoa.get(i).getNome() + ";" + alPessoa.get(i).getTipo().toString() + "\n";

                        //adiciona as informações de telefones do cliente se houver
                        if (alPessoa.get(i).getTelefone().size() >= 0 && alPessoa.get(i).getTelefone() != null) {
                            for (int j = 0; j < alPessoa.get(i).getTelefone().size(); j++) {
                                if (alPessoa.get(i).getTelefone().get(j).getIdPessoa() != id) {
                                    dadosTels += alPessoa.get(i).getTelefone().get(j).getIdPessoa() + ";" + alPessoa.get(i).getTelefone().get(j).getDdi()
                                            + ";" + alPessoa.get(i).getTelefone().get(j).getDdd() + ";" + alPessoa.get(i).getTelefone().get(j).getNumero()
                                            + ";" + alPessoa.get(i).getTelefone().get(j).getTipo().toString() + "\n";
                                }
                            }
                        }

                        //adiciona as informações de emails do cliente se houver
                        if (alPessoa.get(i).getEmail().size() >= 0 && alPessoa.get(i).getEmail() != null) {
                            for (int j = 0; j < alPessoa.get(i).getEmail().size(); j++) {
                                dadosEmails += alPessoa.get(i).getEmail().get(j).getIdPessoa() + ";" + alPessoa.get(i).getEmail().get(j).getEmail() + "\n";
                            }
                        }

                        //adiciona as informações de endereços do cliente se houver
                        if (alPessoa.get(i).getEndereco().size() >= 0 && alPessoa.get(i).getEndereco() != null) {
                            for (int j = 0; j < alPessoa.get(i).getEndereco().size(); j++) {
                                dadosEnderecos += alPessoa.get(i).getEndereco().get(j).getIdPessoa() + ";" + alPessoa.get(i).getEndereco().get(j).getLogradouro().toUpperCase()
                                        + ";" + alPessoa.get(i).getEndereco().get(j).getNumero() + ";" + alPessoa.get(i).getEndereco().get(j).getComplemento().toUpperCase()
                                        + ";" + alPessoa.get(i).getEndereco().get(j).getCep() + ";" + alPessoa.get(i).getEndereco().get(j).getBairro().toUpperCase()
                                        + ";" + alPessoa.get(i).getEndereco().get(j).getCidade().toUpperCase() + ";" + alPessoa.get(i).getEndereco().get(j).getEstado().toUpperCase()
                                        + ";" + alPessoa.get(i).getEndereco().get(j).getPais().toUpperCase() + "\n";;
                            }
                        }

                    } else { //adiciona o cliente modificado
                        dadosCliente += id + ";" + objPessoa.getNome().toUpperCase() + ";" + objPessoa.getTipo().toString() + "\n";

                        //adiciona informações modificadas de telefones do cliente se houver
                        if (objPessoa.getTelefone().size() >= 0 && objPessoa.getTelefone() != null) {
                            for (int j = 0; j < objPessoa.getTelefone().size(); j++) {
                                dadosTels += id + ";" + objPessoa.getTelefone().get(j).getDdi()
                                        + ";" + objPessoa.getTelefone().get(j).getDdd() + ";" + objPessoa.getTelefone().get(j).getNumero()
                                        + ";" + objPessoa.getTelefone().get(j).getTipo().toString() + "\n";
                            }
                        }

                        //adiciona informações modificadas de emails do cliente se houver
                        if (objPessoa.getEmail().size() >= 0 && objPessoa.getEmail() != null) {
                            for (int j = 0; j < objPessoa.getEmail().size(); j++) {
                                dadosEmails += objPessoa.getEmail().get(j).getIdPessoa() + ";" + objPessoa.getEmail().get(j).getEmail().toUpperCase() + "\n";
                            }
                        }

                        //adiciona informações modificadas de endereços do cliente se houver
                        if (objPessoa.getEndereco().size() >= 0 && objPessoa.getEndereco() != null) {
                            for (int j = 0; j < objPessoa.getEndereco().size(); j++) {
                                dadosEnderecos += objPessoa.getEndereco().get(j).getIdPessoa() + ";" + objPessoa.getEndereco().get(j).getLogradouro().toUpperCase()
                                        + ";" + objPessoa.getEndereco().get(j).getNumero() + ";" + objPessoa.getEndereco().get(j).getComplemento().toUpperCase()
                                        + ";" + objPessoa.getEndereco().get(j).getCep() + ";" + objPessoa.getEndereco().get(j).getBairro().toUpperCase()
                                        + ";" + objPessoa.getEndereco().get(j).getCidade().toUpperCase() + ";" + objPessoa.getEndereco().get(j).getEstado().toUpperCase()
                                        + ";" + objPessoa.getEndereco().get(j).getPais().toUpperCase() + "\n";
                            }
                        }
                    }

                }

            }

            fwClientes = new FileWriter(arqClientes);
            bwClientes = new BufferedWriter(fwClientes);
            bwClientes.write(dadosCliente);
            bwClientes.close();

            if (!dadosTels.equals("")) {
                File file = new File(arqTelefone);
                if (!file.exists()) {
                    fwTelefones = new FileWriter(arqTelefone, false);
                } else {
                    fwTelefones = new FileWriter(arqTelefone);
                }

                bwTelefones = new BufferedWriter(fwTelefones);
                bwTelefones.write(dadosTels);
                bwTelefones.close();

            }

            if (!dadosEmails.equals("")) {
                File file = new File(arqTelefone);
                if (!file.exists()) {
                    fwEmails = new FileWriter(arqEmail, false);
                } else {
                    fwEmails = new FileWriter(arqEmail);
                }

                bwEmails = new BufferedWriter(fwEmails);
                bwEmails.write(dadosEmails);
                bwEmails.close();
            }

            if (!dadosEnderecos.equals("")) {
                File file = new File(arqTelefone);
                if (!file.exists()) {
                    fwEnderecos = new FileWriter(arqEndereco, false);
                } else {
                    fwEnderecos = new FileWriter(arqEndereco);
                }

                bwEnderecos = new BufferedWriter(fwEnderecos);
                bwEnderecos.write(dadosEnderecos);
                bwEnderecos.close();
            }

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, ""); msg de erro ao alterar um cliente
        }

    }

    @Override
    public void excluir(int id) throws Exception {
        try {
            Object objPessoas = recuperar();
            ArrayList<Pessoa> alPessoa = (ArrayList<Pessoa>) (objPessoas);

            boolean achou = false;
            String dadosCliente = "";
            String dadosTels = "";
            String dadosEmails = "";
            String dadosEnderecos = "";

            if (alPessoa.size() >= 0 && alPessoa != null) {
                for (int i = 0; i < alPessoa.size(); i++) {
                    if (alPessoa.get(i).getId() != id) { //adiciona os clientes que não foram modificados
                        //adiciona as informações do cliente
                        dadosCliente += alPessoa.get(i).getId() + ";" + alPessoa.get(i).getNome() + ";" + alPessoa.get(i).getTipo().toString() + "\n";

                        //adiciona as informações de telefones do cliente se houver
                        if (alPessoa.get(i).getTelefone().size() >= 0 && alPessoa.get(i).getTelefone() != null) {
                            for (int j = 0; j < alPessoa.get(i).getTelefone().size(); j++) {
                                if (alPessoa.get(i).getTelefone().get(j).getIdPessoa() != id) {
                                    dadosTels += alPessoa.get(i).getTelefone().get(j).getIdPessoa() + ";" + alPessoa.get(i).getTelefone().get(j).getDdi()
                                            + ";" + alPessoa.get(i).getTelefone().get(j).getDdd() + ";" + alPessoa.get(i).getTelefone().get(j).getNumero()
                                            + ";" + alPessoa.get(i).getTelefone().get(j).getTipo().toString() + "\n";
                                }
                            }
                        }

                        //adiciona as informações de emails do cliente se houver
                        if (alPessoa.get(i).getEmail().size() >= 0 && alPessoa.get(i).getEmail() != null) {
                            for (int j = 0; j < alPessoa.get(i).getEmail().size(); j++) {
                                dadosEmails += alPessoa.get(i).getEmail().get(j).getIdPessoa() + ";" + alPessoa.get(i).getEmail().get(j).getEmail() + "\n";
                            }
                        }

                        //adiciona as informações de endereços do cliente se houver
                        if (alPessoa.get(i).getEndereco().size() >= 0 && alPessoa.get(i).getEndereco() != null) {
                            for (int j = 0; j < alPessoa.get(i).getEndereco().size(); j++) {
                                dadosEnderecos += alPessoa.get(i).getEndereco().get(j).getIdPessoa() + ";" + alPessoa.get(i).getEndereco().get(j).getLogradouro().toUpperCase()
                                        + ";" + alPessoa.get(i).getEndereco().get(j).getNumero() + ";" + alPessoa.get(i).getEndereco().get(j).getComplemento().toUpperCase()
                                        + ";" + alPessoa.get(i).getEndereco().get(j).getCep() + ";" + alPessoa.get(i).getEndereco().get(j).getBairro().toUpperCase()
                                        + ";" + alPessoa.get(i).getEndereco().get(j).getCidade().toUpperCase() + ";" + alPessoa.get(i).getEndereco().get(j).getEstado().toUpperCase()
                                        + ";" + alPessoa.get(i).getEndereco().get(j).getPais().toUpperCase() + "\n";;
                            }
                        }
                    } else {
                        achou = true;
                    }
                }
            }

            if (achou) {
                fwClientes = new FileWriter(arqClientes);
                bwClientes = new BufferedWriter(fwClientes);
                bwClientes.write(dadosCliente);
                bwClientes.close();

                if (!dadosTels.equals("")) {
                    File file = new File(arqTelefone);
                    if (!file.exists()) {
                        fwTelefones = new FileWriter(arqTelefone, false);
                    } else {
                        fwTelefones = new FileWriter(arqTelefone);
                    }

                    bwTelefones = new BufferedWriter(fwTelefones);
                    bwTelefones.write(dadosTels);
                    bwTelefones.close();

                }

                if (!dadosEmails.equals("")) {
                    File file = new File(arqTelefone);
                    if (!file.exists()) {
                        fwEmails = new FileWriter(arqEmail, false);
                    } else {
                        fwEmails = new FileWriter(arqEmail);
                    }

                    bwEmails = new BufferedWriter(fwEmails);
                    bwEmails.write(dadosEmails);
                    bwEmails.close();
                }

                if (!dadosEnderecos.equals("")) {
                    File file = new File(arqTelefone);
                    if (!file.exists()) {
                        fwEnderecos = new FileWriter(arqEndereco, false);
                    } else {
                        fwEnderecos = new FileWriter(arqEndereco);
                    }

                    bwEnderecos = new BufferedWriter(fwEnderecos);
                    bwEnderecos.write(dadosEnderecos);
                    bwEnderecos.close();
                }
                JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG04"));
            } else {
                JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG16"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, new Mensagens().mensagem("MSG17"));
        }
    }
}
