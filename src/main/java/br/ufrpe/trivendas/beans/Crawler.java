package br.ufrpe.trivendas.beans;

import br.ufrpe.trivendas.repository.CACHE;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Crawler extends Thread implements java.io.Serializable {

    br.ufrpe.trivendas.repository.SitesRepository Urls = new br.ufrpe.trivendas.repository.SitesRepository();
    private CACHE cacheWalmart = new CACHE(); private CACHE cacheAli = new CACHE();
    public String siteName;
    private String wal = "Walmart"; private String ali = "Aliexpress";
    private String siteUrl;
    private String loja;
    private GetCleanResult washer = new GetCleanResult();
    private List finalResultWalmart = new ArrayList();
    private List finalResultAlie = new ArrayList();

    public List Crawl(String site, String pesquisa) { siteName = site;
        List finalResult = new ArrayList<>();
        if (site.equals(wal) == true) {
            buscar(pesquisa);
            finalResult = getProductData();
        }
        else if (site.equals(ali) == true) {
            buscar(pesquisa);
            finalResult =  getProductData("TRUE");
        }
        return finalResult;
    }

    public void findElement() {
        Document doc = org.jsoup.Jsoup.parse(siteUrl);
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public List getFinalResultWalmart() {
        return finalResultWalmart;
    }

    public List getFinalResultAlie() {
        return finalResultAlie;
    }

    public void buscar(String pesquisa)
    {
        String[] arr = pesquisa.split("-");
        int i;
        if (siteName.equals(wal)) {
            String finalBusca = Urls.getBuscaWalmart();
            for (i = 0; i < arr.length; i++) {
                finalBusca = finalBusca + arr[i] + "+";
            }
            setUrl(finalBusca + "&PS=40");
        }
        else if (siteName.equals(ali)) {
            String finalBusca = Urls.getBuscaAli();

            for (String palavraChave : arr) {
                finalBusca = finalBusca + palavraChave + "+";
            }
            setUrl(finalBusca);
        }
    }

    public String getLoja()
    {
        return loja;
    }

    public void setUrl(String url) {
        siteUrl = url;
        System.out.println();
    }



    public List getProductData()
    {
        System.out.println("Conecting to walmart ...");
        System.out.println(siteUrl);
        try
        {
            Document doc = org.jsoup.Jsoup.connect(siteUrl).userAgent("Chrome").timeout(100000).get();

            Element[] resultProductName = new Element[4];
            resultProductName[0] = doc.select("#product-list > section > ul > li.column.item-0.shelf-product-item > section > a:nth-child(2) > span").first();
            resultProductName[1] = doc.select("#product-list > section > ul > li.column.item-1.shelf-product-item > section > a:nth-child(2) > span").first();
            resultProductName[2] = doc.select("#product-list > section > ul > li.column.item-2.shelf-product-item > section > a:nth-child(2) > span").first();
            resultProductName[3] = doc.select("#product-list > section > ul > li.column.item-3.shelf-product-item > section > a:nth-child(2) > span").first();
            for (int i = 0; i < resultProductName.length; i++) {
                cacheWalmart.setResults(resultProductName[i]);
                finalResultWalmart.add(washer.cleanResultName("Walmart", cacheWalmart) );
            }
        } catch (IOException e) {
            e.printStackTrace();
            //@TODO show error scene
        } finally {
            return getFinalResultWalmart();
        }
    }


    public List getProductData(String Aliexpress)
    {
        System.out.println("Conecting to aliexpress ...");
        System.out.println(siteUrl);
        try
        {
            Document doc = org.jsoup.Jsoup.connect(siteUrl).userAgent("Chrome").timeout(100000).get();

            Element[] resultProductName = new Element[4];
            resultProductName[0] = doc.select("#hs-below-list-items > li:nth-child(1) > div > div.info > h3 > a").first();
            resultProductName[1] = doc.select("#hs-below-list-items > li:nth-child(2) > div > div.info > h3 > a").first();
            resultProductName[2] = doc.select("#hs-below-list-items > li:nth-child(3) > div > div.info > h3 > a").first();
            resultProductName[3] = doc.select("#hs-below-list-items > li:nth-child(4) > div > div.info > h3 > a").first();
            for (int i = 0; i < resultProductName.length; i++) {
                cacheAli.setResults(resultProductName[i]);
                finalResultAlie.add(washer.cleanResultName("Walmart", cacheWalmart) );
            }

        }
        catch (IOException e) {
            e.printStackTrace();
            //@TODO make show error
        } finally {
            return getFinalResultAlie();
        }

    }
}
