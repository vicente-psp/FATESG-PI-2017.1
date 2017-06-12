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
public class Mensagens {

    public String mensagem(String numMSG) {
        switch (numMSG) {
            case "MSG01":
                return "Cadastro realizado com sucesso.";
            case "MSG02":
                return "Cadastro não realizado, existem campos obrigatórios não preenchidos!";
            case "MSG03":
                return "Locação concluída com sucesso";
            case "MSG04":
                return "Exclusão realizada com sucesso!";
            case "MSG05":
                return "Nenhum dado encontrado.";
            case "MSG06":
                return "A marca esta vinculada ao modelo ";
            case "MSG07":
                return "O modelo está vinculado ao Veículo ";
            case "MSG08":
                return "O veículo está vinculado a locação ";
            case "MSG09":
                return "A locação está vinculado ao cliente ";
            case "MSG10":
                return "O cliente está vinculado a locação ";
            case "MSG11":
                return "Operação não realizada, existem campos obrigatórios não informados.";
            case "MSG12":
                return "Alteração realizada com sucesso.";
            case "MSG13":
                return "Alteração não realizada, existem campos obrigatórios não informados.";
            case "MSG14":
                return "Operação não realizada, informação inválida.";
            case "MSG15":
                return "Erro ao buscar registros.";
            case "MSG16":
                return "Nenhum registro foi excluído.";
            case "MSG17":
                return "Erro ao tentar excluir registro.";
                
            default:
                return "Mensagem não cadastrada.";
        }
    }
}
