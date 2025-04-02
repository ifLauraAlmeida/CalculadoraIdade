/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seuprojeto.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Laura
 */
public class dataBaseConnection {
       private static final String URL = "jdbc:sqlite:idade.db"; // Caminho do banco
    
    public static Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC"); // Carregar driver SQLite
            conn = DriverManager.getConnection(URL);
            System.out.println("✅ Conectado ao banco: " + URL);
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Driver SQLite não encontrado!");
        } catch (SQLException e) {
            System.out.println("❌ Erro ao conectar ao banco!");
        }
        return conn;
    }
}