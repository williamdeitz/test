package com.usaa.learnproject.pres.core;

//import com.sun.java.util.jar.pack.ConstantPool.Index;

import java.util.Collections;
import java.util.List;

import org.apache.wicket.Application;
import com.usaa.learnproject.pres.pages.Cheese;
import com.usaa.learnproject.pres.pages.CheesrSession;
import com.usaa.learnproject.pres.pages.Index;
//import java.util.ArrayList;
import java.util.Arrays;
import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
//import org.eclipse.jetty.server.Request;
//mport org.eclipse.jetty.server.Response;

//import wicket.in.action.WicketInActionApplication;

/*
 * Extends WicketInActionApplication instead of WebApplication, to
 * ensure the Cheesr pages work inside these example
 */
public class CheesrApplication extends WebApplication {
  private List<Cheese> cheeses = Arrays.asList(
    new Cheese("American", "American is American", 2.00),
    new Cheese("Stinky", "Stinky Cheese is Stinky", 3.50),
    new Cheese("Parmesean", "This goes on Spaghetti", 2.75),
    new Cheese("Pepper Jack", "This is good on sangwiches", 5.50),
    new Cheese("Cheddar", "This goes on everything else", 3.50),
   new Cheese("Blue Cheese", "This belongs in dressing", 2.00),
    new Cheese("Swiss", "Who likes this???", 3.50),
    new Cheese("Provolone", "Good on subs from subway", 2.75),
    new Cheese("Kraft American", "Good ole fashioned grilled cheese", 5.50),
    new Cheese("Gouda", "What is this???", 3.50));

  public CheesrApplication(){
      
  }

 
  @Override
  protected void init() {
    super.init();

    // read the list of cheeses from a properties file
   //readCheeses();
  }

  public static CheesrApplication get() {
    return (CheesrApplication) Application.get();
  }
  
  @Override
  public Class<? extends Page> getHomePage(){
      return Index.class;
  }

 
  @Override
  public Session newSession(Request request, Response response) {
    return new CheesrSession(request);
  }

  /*
   * Removed the getHomePage() override, as this application does not match
   * the cheese store 100% to fit the overall examples.
   */

  public List<Cheese> getCheeses() {
    return Collections.unmodifiableList(cheeses);
  }

  /**
   * Reads the list of cheeses from a properties file.
   */
  /*
private void readCheeses() {
    Properties props = new Properties();
    try {
      props.load(CheesrApplication.class
          .getResourceAsStream("cheeses.properties"));
    } catch (IOException e) {
      e.printStackTrace();
    }

    for (Object obj : props.keySet()) {
      String key = obj.toString();

      // only process a cheese once (identified by its name)
      if (!key.endsWith(".name"))
        continue;
      key = key.substring(0, key.indexOf("."));

      // retrieve each property value
      String name = props.getProperty(key + ".name");
      String description = props.getProperty(key + ".description");
      double price = Double.valueOf(props.getProperty(key + ".price"));

      cheeses.add(new Cheese(name, description, price));
    }
*/
  }

