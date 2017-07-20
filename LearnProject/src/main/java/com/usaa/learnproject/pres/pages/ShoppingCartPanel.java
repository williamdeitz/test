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

import java.text.NumberFormat;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

/**
 *
 * @author williamdeitz
 */
public class ShoppingCartPanel extends Panel{
    private Cart cart;
    public ShoppingCartPanel(String id, Cart cart){
        super(id);
        this.cart=cart;
        
        add(new ListView("cart", new PropertyModel(this, "cart.cheeses")){
            @Override
            protected void populateItem(ListItem item){
            Cheese cheese = (Cheese) item.getModelObject();
            item.add(new Label("name", cheese.getName()));
            item.add(new Label("price", "$" + cheese.getPrice()));
            item.add(new Link("remove", item.getModel()){
                
                @Override
                public void onClick(){
                    Cheese selected = (Cheese) getModelObject();
                    getCart().getCheeses().remove(selected);
                }
            });
            
        }
        });
        add(new Label("total", new Model(){
            @Override
            public String getObject(){
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                return nf.format(getCart().getTotal());
            }
        }));
    }
    private Cart getCart(){
        return cart;
    }
    
}
