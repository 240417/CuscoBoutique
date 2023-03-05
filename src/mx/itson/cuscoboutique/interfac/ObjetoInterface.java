/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.cuscoboutique.interfac;

/**
 *
 * @author medin
 */
public interface ObjetoInterface {
    
    boolean agregar(Object _object);
    boolean eliminar(int _object);
    boolean modificar(Object _object);
    Object buscarPorId(int _id);
    Object buscarPor(String _campo, String _dato);
    Object buscarTodo();

}
