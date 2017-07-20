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

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

/**
 *
 * @author williamdeitz
 */
public class ClockPage extends CheesrPage{

    public ClockPage() {
        //final String time;
     
        
        Model clock;
        clock = new Model(){
            @Override
            public String getObject(){
                SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss");
                String time = df.format(new Date());
                
                return time;
            }
        };
        
        add(new Label("clock", clock));
        add(new Link("refresh"){
            public void onClick(){
            }
        });
         
    }
}

