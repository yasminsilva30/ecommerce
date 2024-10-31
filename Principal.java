/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecommerce;

/**
 * @author ester.yasmin
 */

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ClienteADO clienteADO = new ClienteADO();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            // Exibindo o menu de opções pro usuário
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Atualizar cliente");
            System.out.println("4. Excluir cliente");
            System.out.println("5. Buscar cliente por ID");
            System.out.println("6. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer de entrada

            switch (opcao) {
                case 1:
                    // Cadastro de novo cliente
                    System.out.println("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.println("Email: ");
                    String email = scanner.nextLine();
                    System.out.println("Telefone: ");
                    String telefone = scanner.nextLine();
                    
                    Cliente cliente = new Cliente(nome, email, telefone);
                    clienteADO.inserirCliente(cliente);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;
                case 2:
                    // Lista todos os clientes cadastrados
                    clienteADO.listarClientes().forEach(System.out::println);
                    break;
                case 3:
                    // Atualiza um cliente existente
                    System.out.println("Digite o ID do cliente que deseja atualizar: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer
                    
                    Cliente clienteExistente = clienteADO.buscarClientePorId(idAtualizar);
                    if (clienteExistente != null) {
                        System.out.println("Nome atual: " + clienteExistente.getNome());
                        System.out.println("Email atual: " + clienteExistente.getEmail());
                        System.out.println("Telefone atual: " + clienteExistente.getTelefone());

                        System.out.println("Novo Nome (deixe em branco para manter o atual): ");
                        String novoNome = scanner.nextLine();
                        System.out.println("Novo Email (deixe em branco para manter o atual): ");
                        String novoEmail = scanner.nextLine();
                        System.out.println("Novo Telefone (deixe em branco para manter o atual): ");
                        String novoTelefone = scanner.nextLine();

                        // Atualizando apenas os campos que o usuário preencheu
                        if (!novoNome.isEmpty()) clienteExistente.setNome(novoNome);
                        if (!novoEmail.isEmpty()) clienteExistente.setEmail(novoEmail);
                        if (!novoTelefone.isEmpty()) clienteExistente.setTelefone(novoTelefone);

                        clienteADO.atualizarCliente(clienteExistente);
                        System.out.println("Cliente atualizado com sucesso!");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 4:
                    // Exclui um cliente
                    System.out.println("Digite o ID do cliente que deseja excluir: ");
                    int idExcluir = scanner.nextInt();
                    
                    Cliente clienteParaExcluir = clienteADO.buscarClientePorId(idExcluir);
                    if (clienteParaExcluir != null) {
                        clienteADO.deletarCliente(idExcluir);
                        System.out.println("Cliente excluído com sucesso!");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 5:
                    // Busca um cliente por ID
                    System.out.println("Digite o ID do cliente que deseja buscar: ");
                    int idBuscar = scanner.nextInt();
                    
                    Cliente clienteBuscado = clienteADO.buscarClientePorId(idBuscar);
                    if (clienteBuscado != null) {
                        System.out.println("Cliente encontrado: " + clienteBuscado.getNome());
                        System.out.println("Email: " + clienteBuscado.getEmail());
                        System.out.println("Telefone: " + clienteBuscado.getTelefone());
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 6:
                    // Sai do programa
                    System.out.println("Saindo...");
                    return;
                default:
                    // Caso o usuário digite uma opção inválida
                    System.out.println("Opção inválida.");
            }
        }
    }
}