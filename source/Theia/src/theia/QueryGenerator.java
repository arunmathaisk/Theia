/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theia;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author arun
 */
public class QueryGenerator {
  
  String search_keyword;
  String query;
  ArrayList<String> engines_checked;
  
  
  public QueryGenerator(String search_keyword,ArrayList<String> engines_checked)
  {
      this.search_keyword = search_keyword;
      this.engines_checked = engines_checked;
      replaceSpaces();
      createQuery();
  }
  
  public void replaceSpaces()
  {
      search_keyword = search_keyword.replaceAll(" ", "%20");
  }
   public void createQuery()
  {
      query = "/search?q=";
      query  = query + search_keyword;
      query = query +"&engines=";
      
      String commaseparatedEngineList = engines_checked.stream().collect(Collectors.joining(","));
     
      query = query + commaseparatedEngineList ;
      
      System.out.println(query);
      
      
  }
  
  public String getQuery()
  {
      return query;
      
  }
  
    
}
