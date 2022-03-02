/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theia;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author arun
 */
public class QueryMaker {
    
    
    String instanceUrl;
    String query;
    String url;
    String external_links[];
    
    
    public QueryMaker(String instanceUrl, String query)
    {
       this.instanceUrl = instanceUrl;
       this.query = query;
       url = instanceUrl + query;
       makeQuery();
    }
    
    public void makeQuery()
    { 
        
         try
         {
            Document document = Jsoup.connect(url).get();
            Elements text = document.select("div[class=external-link]");
            String[] links = new String[text.size()];
            for (int i = 0; i < text.size(); i++) {
                links[i] = text.get(i).text();
            }
            external_links = links;
        } catch (IOException e) {
        }
        
        
    }
    
    public String[] getExternalLinks()
    {
        
       return external_links;
       
    }
    
   
    
}
