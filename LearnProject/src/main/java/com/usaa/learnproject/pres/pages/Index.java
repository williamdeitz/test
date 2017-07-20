/*
 * Copyright 2016 williamdeitz.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.usaa.learnproject.pres.pages;


import java.time.Clock;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;


/**
 *
 * @author williamdeitz
 */
public class Index extends CheesrPage {
    public Index(){
        //add(new ListView("cheeses", getCheeses()){
        PageableListView cheeses = new PageableListView("cheeses", getCheeses(), 5){
            @Override
            protected void populateItem(ListItem item){
                Cheese cheese = (Cheese) item.getModelObject();
                item.add(new Label("name", cheese.getName()));
                item.add(new Label("description", cheese.getDescription()));
                item.add(new Label("price", cheese.getPrice()));
                item.add(new Link("add", item.getModel()){
                    @Override
                    public void onClick(){
                    Cheese selected = (Cheese) getModelObject();
                    getCart().getCheeses().add(selected);
                    }
                });
                
            }
        };
        add(cheeses);
        add(new PagingNavigator("navigator", cheeses));
    
        add(new ShoppingCartPanel("shoppingcart", getCart()));
        
        add(new Link("checkout"){
            @Override
            public void onClick(){
                setResponsePage(new CheckOut());
            }
            @Override 
            public boolean isVisible(){
            return !getCart().getCheeses().isEmpty();
        }
    });
        add(new Link("clock"){
            @Override
            public void onClick(){
            setResponsePage(new ClockPage());
        }
        });
    }
    
    
}
