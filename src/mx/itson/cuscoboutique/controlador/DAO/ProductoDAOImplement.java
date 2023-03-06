/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.cuscoboutique.controlador.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import mx.itson.cuscoboutique.entidades.Producto;
import mx.itson.cuscoboutique.interfac.ObjetoInterface;

/**
 *
 * @author medin
 */
public class ProductoDAOImplement implements ObjetoInterface{

    private final Connection _connection;

    public ProductoDAOImplement(Connection _connection) {
        this._connection = _connection;
    }

    @Override
    public boolean agregar(Object _object) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Producto p = (Producto) _object;
        
        boolean _respuesta = false;
        
        StringBuilder _sql = new StringBuilder();
        
        _sql.append("INSERT INTO bd_boutique.tbl_productos ")
            .append("(nombre, talla, precio, existencia, descripcion, color ) ")
            .append("VALUES (?, ?, ?, ?, ?, ?);");
        
        PreparedStatement _statement;
        
        try {
            _statement = this._connection.prepareStatement(_sql.toString());
        
            _statement.setString(1, p.getNombre());
            _statement.setString(2, p.getTalla());
            _statement.setDouble(3, p.getPrecio());
            _statement.setInt(4, p.getExistencia());
            _statement.setString(5, p.getDescripcion());
            _statement.setString(6, p.getColor());
            
            _respuesta = _statement.execute();
            
        } catch (SQLException ex) {
            System.out.println("error: " + ex.getMessage());
        }
        
        return _respuesta;
    }

    @Override
    public boolean eliminar(int _object) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean _respuesta = false;
        
        StringBuilder _sql = new StringBuilder();
        
        _sql.append("DELETE FROM bd_boutique.tbl_productos WHERE id = ?;");
        
        PreparedStatement _statement;
        
        try {
            _statement = this._connection.prepareStatement(_sql.toString());
        
            _statement.setInt(1, _object);
            
            _respuesta = _statement.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return _respuesta;
    }

    @Override
    public boolean modificar(Object _object) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        Producto producto = (Producto) _object;
        
        boolean _respuesta = false;
        
        StringBuilder _sql = new StringBuilder();
        
        _sql.append("UPDATE bd_boutique.tbl_productos ")
            .append("SET ")
                .append("nombre = ?, ")
                .append("talla = ?, ")
                .append("precio = ?, ")
                .append("existencia = ?, ")
                .append("descripcion = ?, ")
                .append("color = ? ")
            .append("WHERE id = ?;");
        
        PreparedStatement _statement;
        
        try {
            _statement = this._connection.prepareStatement(_sql.toString());
        
            _statement.setString(1, producto.getNombre());
            _statement.setString(2, producto.getTalla());
            _statement.setDouble(3, producto.getPrecio());
            _statement.setInt(4, producto.getExistencia());
            _statement.setString(5, producto.getDescripcion());
            _statement.setString(6, producto.getColor());
            _statement.setInt(7, producto.getId());
            _statement.execute();
            _respuesta = _statement.getUpdateCount()==1;
        }catch(Exception ex){
        System.out.println(ex.getMessage());
        }
        return _respuesta;
    }

    @Override
    public Object buscarPorId(int _id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        Producto producto = null;
        
        StringBuilder _sql = new StringBuilder();
        
        _sql.append("SELECT  ")
                .append("id, ")
                .append("nombre, ")
                .append("talla, ")
                .append("precio, ")
                .append("existencia, ")
                .append("descripcion, ")
                .append("color ")
            .append("FROM bd_boutique.tbl_productos ")
            .append("WHERE id = ?;");
        
        PreparedStatement _statement;
        
        try {
            _statement = this._connection.prepareStatement(_sql.toString());
        
            _statement.setInt(1, _id);
            
            ResultSet _respuesta = _statement.executeQuery();
            
            if (_respuesta.next()){
                
                producto = new Producto();
                
                producto.setId(_respuesta.getInt("id"));
                producto.setNombre(_respuesta.getString("nombre"));
                producto.setTalla(_respuesta.getString("talla"));
                producto.setPrecio(_respuesta.getDouble("precio"));
                producto.setExistencia(_respuesta.getInt("existencia"));
                producto.setDescripcion(_respuesta.getString("descripcion"));
                producto.setColor(_respuesta.getString("color"));
                
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return producto;
    
    }

    
}
