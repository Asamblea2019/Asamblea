package Util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author APRENDIZ
 */
public class Conexion 
{
    private String driver,urlBD,userBD,passwordBD,bd;
    private Connection con;
    
    public Conexion ()
    {
        driver= "com.mysql.jdbc.Driver";
        userBD="root";
        passwordBD="";
        bd="gestion_asamblea";
        urlBD="jdbc:mysql://localhost:3306/"+bd;
        try {
            
            Class.forName(driver).newInstance();
            con= DriverManager.getConnection(urlBD,userBD,passwordBD);
            System.out.println("!Conexion ok");
        } catch (Exception e) {
            System.out.println("Error al conectar"+e.toString());
        }
        
    }
    public Connection Conectar()
    {
        return con;
    }
    public Connection Desconectar() throws SQLException
    {
        con.close();
        con =null;
        return con;
    }
    public static void main(String[] args) {
        new Conexion();
    }
}
