/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.cuscoboutique.main;

import java.util.List;
import java.util.Scanner;
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
        
        Scanner sr = new Scanner(System.in);
        DataBase bd = new DataBase();
        Producto producto = new Producto();
        try{
            
            ProductoDAOImplement p = new ProductoDAOImplement(bd.getConnection());
        
            System.out.println("Que deseas hacer?");
            System.out.println("Eliminar [1]");
            System.out.println("Crear [2]");
            System.out.println("Modificar [3]");
            System.out.println("buscar [4]");
            int res = sr.nextInt();
            if(res==1){
                System.out.println("Ingresa el id de el producto que desea eliminar");
                res=sr.nextInt();
                p.eliminar(res);
            
            }
            if(res==2){
            String dato ;
            
            System.out.println("nombre del producto:");
            dato=sr.next();
            producto.setNombre(dato);
            
            System.out.println("precio del producto:");
            double precio = sr.nextDouble();
            producto.setPrecio(precio);
            
            System.out.println("talla del producto:");
            dato = sr.next();
            producto.setTalla(dato);
            
            System.out.println("cantodad de producto:");
            int cantidad = sr.nextInt();
            producto.setExistencia(cantidad);
            
            System.out.println("descripción:");
            dato=sr.next();
            producto.setDescripcion(dato);
            
            System.out.println("color del producto:");
            dato = sr.next();
            producto.setColor(dato);
            
            p.agregar(producto);
            }
            if(res==3){
            String dato ;
            System.out.println("Ingresa el id de el producto a modificar:");
            int _id = sr.nextInt();
                
                producto = (Producto) p.buscarPorId(_id);
                System.out.println("Los datos del producto son:");
                System.out.println(producto.getNombre());
                System.out.println(producto.getTalla());
                System.out.println(producto.getPrecio());
                System.out.println(producto.getExistencia());
                System.out.println(producto.getDescripcion());
                System.out.println(producto.getColor());
                System.out.println("");
                System.out.println("Ingrese los nuevos datos:");
            //p.modificar(producto);
            
            System.out.println("nombre del producto:");
            dato=sr.next();
            producto.setNombre(dato);
            
            System.out.println("precio del producto:");
            double precio = sr.nextDouble();
            producto.setPrecio(precio);
            
            System.out.println("talla del producto:");
            dato = sr.next();
            producto.setTalla(dato);
            
            System.out.println("cantodad de producto:");
            int cantidad = sr.nextInt();
            producto.setExistencia(cantidad);
            
            System.out.println("descripción:");
            dato=sr.next();
            producto.setDescripcion(dato);
            
            System.out.println("color del producto:");
            dato = sr.next();
            producto.setColor(dato);
            
            p.modificar(producto);
                
                
            }
            if(res==4){
                System.out.println("Ingresa el id:");
                int _id=sr.nextInt();
                producto = (Producto) p.buscarPorId(_id);
                
                System.out.println(producto.getNombre());
                System.out.println(producto.getTalla());
                System.out.println(producto.getPrecio());
                System.out.println(producto.getExistencia());
                System.out.println(producto.getDescripcion());
                System.out.println(producto.getColor());
                
            }
      
        }catch(Exception e){
            System.out.println("Ocurrio un error, porfavor intente mas tarde: "+e.getMessage());
        
        }
        
    }
    
}
