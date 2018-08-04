package br.ufrpe.trivendas.beans;

import java.io.Serializable;

public class Resultado extends Loja implements Serializable {
    public String name;
    public double preco;
    public String urlSite;

    public Resultado(String name, double preco) {
        this.name = name;
        this.preco = preco;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getUrlSite() {
        return urlSite;
    }

    public void setUrlSite(String urlSite) {
        this.urlSite = urlSite;
    }
}
