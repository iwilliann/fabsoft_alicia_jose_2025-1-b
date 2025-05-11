package br.univille.entity;

import java.util.ArrayList;

public class Cliente extends Cidade     {

    // seta contínua completa vira variável no java
    // Nesse caso, Cliente recebe variável

    //variavel ou atributo
    private String nome;
    private long id;
    private String endereco;

    private Cidade cidade; // seta do diagrama de classe // 1 cidade tem vários clientes
    
    private ArrayList<Pokemon> listaPokemon = new ArrayList<Pokemon>();
    
    public ArrayList<Pokemon> getListaPokemons(){
        return listaPokemon;
    }
    public void setListaPokemons(ArrayList<Pokemon> listaPokemon) {
        this.listaPokemon = listaPokemon;
    }


    //construtor
    public Cliente(String nome) {
        this.nome = nome;
    }

    // polimorfismo - várias formas de existir o mesmo objeto
    public Cliente() {
    
    }

    //método
    @Override //sobreescrita de método
    public String toString(){
        return getNome();
    }
    
    //método
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    // encapsulamento = esconder a implementação dentro do objeto

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public ArrayList getListaPokemon() {
        return listaPokemon;
    }

    public void setListaPokemon(ArrayList listaPokemon) {
        this.listaPokemon = listaPokemon;
    }

    
    
}
