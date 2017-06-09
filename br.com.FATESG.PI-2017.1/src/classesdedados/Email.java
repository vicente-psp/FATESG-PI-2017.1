/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesdedados;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Vicente
 */
public class Email {
    private int idPessoa = 0;
    private String email = "";

    public Email() {
    }
    public Email(int idPessoa, String descricao){
        this.idPessoa = idPessoa;
        this.email = descricao;
    }

    public int getIdPessoa() {
        return idPessoa;
    }
    public void setIdPessoa(int idPessoa)throws Exception{
        if(idPessoa <= 0)throw new Exception("Id inválido!");
        this.idPessoa = idPessoa;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email)throws Exception{
        if(email.length() == 0)throw new Exception("Informe o email!");

        this.email = email;
        if(!validarEmail())throw new Exception("Email inválido!");
    }

    public boolean validarEmail() {
        String emailPattern = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
        Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(this.email);
        return matcher.matches();
    }
}