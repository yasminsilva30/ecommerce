/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecommerce;

/**
 * @author ester.yasmin
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
    // Método para conectar no banco de dados
    public static Connection getConnection() {
        // Definindo URL, usuário e senha pra acessar o banco
        String url = "jdbc:mysql://localhost:3306/ecommerce";
        String usuario = "root";
        String senha = "sua_senha"; // <--- Aqui você coloca a senha do seu banco

        try {
            // Tenta conectar no banco e retorna a conexão
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            // Mostra o erro se der algo errado com a conexão
            e.printStackTrace();
            return null;
        }
    }
}