package br.ufrpe.trivendas.repository;

import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

public class CleanResultsList {
    private List<Element> results = new ArrayList<>();

    public void setResults(List<Element> results) {
        this.results = results;
    }

    public void setResults(Element results) {
        this.results.add(results);
    }

    public List<String> getResults() {
        List<String> resultado = new ArrayList<>();



        return resultado;
    }

    public void addElement(List<Element> results) {
        this.results = results;
    }

}
