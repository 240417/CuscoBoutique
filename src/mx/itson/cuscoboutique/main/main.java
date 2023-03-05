/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.cuscoboutique.main;

import java.util.List;
import mx.itson.cuscoboutique.basedata.DataBase;
import mx.itson.cuscoboutique.controlador.DAO.ProductoDAOImplement;
import mx.itson.cuscoboutique.entidades.Producto;

/**
 *
 * @author medin
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DataBase bd = new DataBase();
        try{
        ProductoDAOImplement p = new ProductoDAOImplement(bd.getConnection());
        
        List<Producto> producto = (List<Producto>)p.buscarTodo();
        
        for (Producto pr: producto){
        
            System.out.println("id : " + pr.getId());
            System.out.println("Nombre: " + pr.getNombre());
            System.out.println("talla: " + pr.getTalla());
            System.out.println("precio: " + pr.getPrecio());
            System.out.println("Cantidad: " + pr.getExistencia());
            System.out.println("descripcion: " + pr.getDescripcion());
            System.out.println("Color: " + pr.getColor());
            System.out.println("----------------------------------------------------------");
        }}catch(Exception e){
            System.out.println(e.getMessage());
        
        }
        
    }
    
}
