/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecommerce;

/**
 * @author ester.yasmin
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteADO {

    // Método para inserir um novo cliente no banco
    public void inserirCliente(Cliente cliente) {
        String sql = "INSERT INTO Clientes (Nome, Email, Telefone) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoBanco.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // Aqui a gente coloca os valores do cliente no comando SQL
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());

            // Executa o comando de inserção
            stmt.executeUpdate();
        } catch (SQLException e) {
            // Mostra se deu algum erro
            e.printStackTrace();
        }
    }

    // Método para listar todos os clientes cadastrados no sistema
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Clientes";

        try (Connection conn = ConexaoBanco.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Vai rodando pelos resultados e adicionando na lista de clientes
            while (rs.next()) {
                Cliente cliente = new Cliente(
                    rs.getString("Nome"),
                    rs.getString("Email"),
                    rs.getString("Telefone")
                );
                cliente.setId(rs.getInt("ID"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            // Caso de erro, mostra o que aconteceu
            e.printStackTrace();
        }

        return clientes;
    }

    // Método para buscar um cliente pelo ID
    public Cliente buscarClientePorId(int id) {
        String sql = "SELECT * FROM Clientes WHERE ID = ?";

        try (Connection conn = ConexaoBanco.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);  // Define o parâmetro ID para a consulta
            ResultSet rs = stmt.executeQuery();

            // Se encontrar um cliente com o ID fornecido, cria um objeto Cliente com os dados
            if (rs.next()) {
                Cliente cliente = new Cliente(
                    rs.getString("Nome"),
                    rs.getString("Email"),
                    rs.getString("Telefone")
                );
                cliente.setId(rs.getInt("ID"));
                return cliente;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Retorna null se não encontrar o cliente
    }

    // Método para atualizar os dados de um cliente existente
    public void atualizarCliente(Cliente cliente) {
        String sql = "UPDATE Clientes SET Nome = ?, Email = ?, Telefone = ? WHERE ID = ?";

        try (Connection conn = ConexaoBanco.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // Atualiza os valores de acordo com os novos dados do cliente
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());
            stmt.setInt(4, cliente.getId()); // ID do cliente a ser atualizado

            // Executa a atualização
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para deletar um cliente usando o ID
    public void deletarCliente(int id) {
        String sql = "DELETE FROM Clientes WHERE ID = ?";

        try (Connection conn = ConexaoBanco.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);  // Define o ID do cliente a ser deletado

            // Executa o comando de exclusão
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}