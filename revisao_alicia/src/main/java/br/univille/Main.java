package br.univille;
import br.univille.entity.Cidade;
import br.univille.entity.Cliente;
import br.univille.entity.Pokemon;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");

        Cidade joinville = new Cidade();
        joinville.setNome("Joinville");
        joinville.setEstado("Santa Catarina");

        Pokemon blaziken = new Pokemon("Blaziken");
        Pokemon charmander = new Pokemon("Charmander");

        Cliente zezinho = new Cliente("Zezinho");
        zezinho.setNome ("Zezinho da Silva Sauro");
        zezinho.setCidade(joinville);

        zezinho.getListaPokemon().add(charmander);
        zezinho.getListaPokemon().add(blaziken);
        

        for(int i=0; i<zezinho.getListaPokemon().size();i++){
            var umPokemon = zezinho.getListaPokemon().get(i);
            System.out.println(umPokemon);
        }
        for(var umPokemon : zezinho.getListaPokemon()){
            System.out.println(umPokemon);
        }

        zezinho.getListaPokemon().stream().forEach(System.out::println);

        Cliente mariazinha = new Cliente();
        mariazinha.setNome ("Mariazinha");



        System.out.println(zezinho);
        System.out.println(mariazinha);

    }
}