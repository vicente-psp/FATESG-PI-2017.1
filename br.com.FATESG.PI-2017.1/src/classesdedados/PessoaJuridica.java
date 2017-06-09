/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesdedados;

/**
 *
 * @author Vicente
 */
public class PessoaJuridica extends Pessoa{
    private String cnpj = "";

    public PessoaJuridica() {
    }
    public PessoaJuridica(String cnpj){
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj)throws Exception{
        if(cnpj.length() == 0) throw new Exception("Informe o CNPJ!");
        this.cnpj = cnpj;
        if(!validaCnpj())throw new Exception("CNPJ inválido!");
    }

    private boolean validaCnpj()throws Exception {
        if (!this.cnpj.substring(0, 1).equals("")) {
            try {
                this.cnpj = this.cnpj.replace('.', ' ');//onde há ponto coloca espaço
                this.cnpj = this.cnpj.replace('/', ' ');//onde há barra coloca espaço
                this.cnpj = this.cnpj.replace('-', ' ');//onde há traço coloca espaço
                this.cnpj = this.cnpj.replaceAll(" ", "");//retira espaço
                int soma = 0, dig;
                String cnpj_calc = cnpj.substring(0, 12);
                if (this.cnpj.length() != 14) {
                    return false;
                }
                char[] chr_cnpj = this.cnpj.toCharArray();
                /* Primeira parte */
                for (int i = 0; i < 4; i++) {
                    if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                        soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
                    }
                }
                for (int i = 0; i < 8; i++) {
                    if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9) {
                        soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
                    }
                }
                dig = 11 - (soma % 11);
                cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(
                        dig);
                /* Segunda parte */
                soma = 0;
                for (int i = 0; i < 5; i++) {
                    if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                        soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
                    }
                }
                for (int i = 0; i < 8; i++) {
                    if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9) {
                        soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
                    }
                }
                dig = 11 - (soma % 11);
                cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(
                        dig);
                return this.cnpj.equals(cnpj_calc);
            }
            catch (Exception e) {
                return false;
            }
        }
        else {
            return false;
        }
    }
}
