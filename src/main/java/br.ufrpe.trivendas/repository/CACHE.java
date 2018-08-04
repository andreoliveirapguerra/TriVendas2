package br.ufrpe.trivendas.repository;

import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

public class CACHE {
    private List<Element> results = new ArrayList <>();
    private int lenght;

    public int getLenght() {
        return this.lenght;
    }

    public void setLenght() {
        this.lenght = results.size();
    }
    public List <Element> getResults() {
        return this.results;
    }

    public void setResults(Element result) {
        this.results.add(result);
    }

}
