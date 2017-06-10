/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacedeclasses;

import java.util.ArrayList;

/**
 *
 * @author Vicente
 */
public interface CRUD {
    void incluir(Object objeto)throws Exception;
    ArrayList<Object> recuperar()throws Exception;
    void alterar(int id, Object objeto)throws Exception;
    void excluir(int id)throws Exception;
}
