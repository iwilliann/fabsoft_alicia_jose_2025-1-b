package br.univille.projfabsoftescolamusica.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // identificar que é uma entidade JPA
public class Aluno {
    @Id // mostrar ao java que é a chave primária/id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // gerar o id automaticamente
    private long id;
    //é bom tipificar os campos
    @Column(length = 1000,nullable = false) // definir o tamanho máximo do campo e 
    // identificar que é um campo obrigatório
    private String nome;
    @Column(length = 1000)
    private String endereco;
    private String telefone;
    private String email;
    private String dataNascimento;
    @Column(length = 11, nullable = false) // CPF tem 11 dígitos
    private String cpf;
    private String sexo;

    // Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    
}