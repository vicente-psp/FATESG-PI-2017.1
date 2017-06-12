/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesdedados;

/**
 *
 * @author Alexandre Fernandes
 */
public class Marca {
    private int idMarca = 0;
    private String descricao = "";
    
    public Marca(){
        
    }
    
    public Marca(int idMarca, String descricao){
        this.idMarca = idMarca;
        this.descricao = descricao;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
        
}
