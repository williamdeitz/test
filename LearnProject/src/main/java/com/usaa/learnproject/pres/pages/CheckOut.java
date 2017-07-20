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

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.validation.IFormValidator;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;

/**
 *
 * @author williamdeitz
 */
public class CheckOut extends CheesrPage {
    public CheckOut(){
       add(new FeedbackPanel("feedback"));
       Form form = new Form("form");
       add(form);
       Address address = getCart().getBillingAddress();
     final  TextField tf = new TextField<String>("name", new PropertyModel(address, "name"));
       tf.setRequired(true);
       form.add(tf);
       form.add(new TextField("street", new PropertyModel(address, "street")).setRequired(true));
       form.add(new TextField("city", new PropertyModel(address, "city")).setRequired(true));
       form.add(new TextField("zipcode", new PropertyModel(address, "zipcode")).setRequired(true));
       form.add(new IFormValidator() {
           @Override
           public FormComponent<?>[] getDependentFormComponents() {
               return new FormComponent<?>[] { tf };
           }

           @Override
           public void validate(Form<?> form) {
               form.error("Validation!");
           }
       });
       error("who knows!");
       
       form.add(new Link("cancel"){
           @Override
           public void onClick(){
               setResponsePage(Index.class);
           }
       });
       
       form.add(new Button("order"){
           @Override
           public void onSubmit(){
             Cart cart = getCart();
             cart.getCheeses().clear();
             setResponsePage(Index.class);
           }
       });
       
    }
    
}
