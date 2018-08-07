package br.ufrpe.trivendas.repository;

import br.ufrpe.trivendas.beans.Loja;

public class SitesRepository extends Loja {


    private String url = "https://www.";
    private String safe = "https://";
    private String internacional = ".com";
    private String local = ".com.br";


    private String walmart = "walmart";
    private String ali = "pt.aliexpress";

    private String WalmartURL = url + walmart + local;
    private String aliexpress = safe + ali + internacional;
    private String buscaAli = aliexpress + "/wholesale?SearchText=";
    private String buscaWalmart = WalmartURL + "/busca/?ft=";

    @Override
    public String getUrl() {
        return url;
    }

    public String getInternacional() {
        return internacional;
    }

    public String getLocal() {
        return local;
    }

    public String getWalmart() {
        return walmart;
    }

    public String getAli() {
        return ali;
    }


    public String getWalmartURL() {
        return WalmartURL;
    }


    public String getAliexpress() {
        return aliexpress;
    }

    public String getBuscaAli() {
        return buscaAli;
    }


    public String getBuscaWalmart() {

        return buscaWalmart;
    }

}
