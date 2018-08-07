package br.ufrpe.trivendas.beans;

import br.ufrpe.trivendas.repository.SitesRepository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sorter extends SitesRepository implements Serializable {
     public List <Loja> ordenar(List<Loja> Lojas){
        List<Loja> listaOrdenada = new ArrayList <>();
         //@TODO ordena pelo menor preco os resultados

         return listaOrdenada;
     }
}
