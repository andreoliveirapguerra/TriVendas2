package br.ufrpe.trivendas.beans;

import br.ufrpe.trivendas.repository.CACHE;
import org.jsoup.nodes.Element;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GetCleanResult implements Serializable {

    public String cleanResultName(String loja, CACHE temp) {
        String finalResult = new String();
        List<Element> sujo = new ArrayList<>();
        int size = sujo.size();
        List<Element> tempList ;
        List<String> finalClean = new ArrayList<>();
        String[] cleaning ;
        String[] cleaning2 ;
        List<String> clean = new ArrayList<>();
        if (loja.equals("Wallmart")){
            for (Element element:
                 sujo) {
                    finalClean.add(element.toString() );
            }
            for (String resultado:
                 finalClean) {
                 cleaning = resultado.split("<");
                 cleaning2 = cleaning[1].split(">");
                 finalResult = cleaning2[1];
            }
        } else if (loja.equals("Ali")){
            //TODO same for ali code here
        } else {
            //TODO error window doge
        }
        return finalResult;
    }



}
