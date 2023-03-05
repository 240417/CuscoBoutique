/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.cuscoboutique.basedata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author medin
 */
public class DataBase {
    private Connection _connection = null;

    /*public DataBase() {
        

        String _url = "jdbc:mysql://localhost/bd_boutique?allowPublicKeyRetrieval=true&useSSL=false";

        String _user = "user";

        String _password="Poke6470";
       
        try{
            
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this._connection = DriverManager.getConnection(_url, _user, _password);
            
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }

    }*/
    
    public Connection getConnection(){
        return this._connection;
    }
    
    public void closeConnection(){
        
        if(this._connection!=null){
            try {
                this._connection = DriverManager.getConnection("dbc:mysql://localhost/bd_boutique?user=root&password=Poke6470");
                //this._connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
            }
        }
    }
}
