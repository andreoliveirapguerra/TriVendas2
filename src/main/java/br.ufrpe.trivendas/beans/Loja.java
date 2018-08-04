package br.ufrpe.trivendas.beans;

import java.io.Serializable;
import java.util.Scanner;

public class Loja implements Serializable {
    Scanner in = new Scanner(System.in);
    public String nome;

    public String getNome() {
        this.nome = in.next();
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlBusca() {
        return urlBusca;
    }

    public void setUrlBusca(String urlBusca) {
        this.urlBusca = urlBusca;
    }

    public String url;
    public String urlBusca;

    public Loja() {
    }

}
