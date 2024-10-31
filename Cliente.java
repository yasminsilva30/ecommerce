/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ecommerce;

/**
 * @author ester.yasmin
 */

public class Cliente {
    // Atributos do cliente: ID, nome, email e telefone
    private int id;
    private String nome;
    private String email;
    private String telefone;

    // Construtor pra criar um novo cliente com nome, email e telefone (útil no cadastro)
    public Cliente(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    // Construtor vazio, útil pra quando queremos preencher os dados depois
    public Cliente() {
    }

    // Getters e Setters pra acessar e modificar os dados do cliente

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Sobrescrevendo toString pra exibir os dados do cliente de forma mais amigável
    @Override
    public String toString() {
        return "Cliente ID: " + id + ", Nome: " + nome + ", Email: " + email + ", Telefone: " + telefone;
    }
}