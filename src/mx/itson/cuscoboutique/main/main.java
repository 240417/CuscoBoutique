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
            System.out.println("Esta es la informacion que pediste:...");
                
                producto = (Producto) p.buscarPorId(5);
                
                System.out.println(producto.getNombre());
                System.out.println(producto.getTalla());
                System.out.println(producto.getPrecio());
                System.out.println(producto.getExistencia());
                System.out.println(producto.getDescripcion());
                System.out.println(producto.getColor());
                
            p.modificar(producto);
            
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
                System.out.println("Esta es la informacion que pediste:...");
                
                producto = (Producto) p.buscarPorId(1);
                
                System.out.println(producto.getNombre());
                System.out.println(producto.getTalla());
                System.out.println(producto.getPrecio());
                System.out.println(producto.getExistencia());
                System.out.println(producto.getDescripcion());
                System.out.println(producto.getColor());
                
            }
            //String
        /*List<Producto> producto = (List<Producto>)p.buscarPorId(1);
        
        for (Producto pr: producto){
        
            System.out.println("id : " + pr.getId());
            System.out.println("Nombre: " + pr.getNombre());
            System.out.println("talla: " + pr.getTalla());
            System.out.println("precio: " + pr.getPrecio());
            System.out.println("Cantidad: " + pr.getExistencia());
            System.out.println("descripcion: " + pr.getDescripcion());
            System.out.println("Color: " + pr.getColor());
            System.out.println("----------------------------------------------------------");
        }*/}catch(Exception e){
            System.out.println(e.getMessage());
        
        }
        
    }
    
}
