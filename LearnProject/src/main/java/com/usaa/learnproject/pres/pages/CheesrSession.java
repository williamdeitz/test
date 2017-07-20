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

/**
 *
 * @author williamdeitz
 */
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

//import wicket.in.action.common.WiaSession;

/*
 * Extends WiaSession instead of WebSession to make the 
 * cheesr application work within the examples.
 */
public class CheesrSession extends WebSession {
  private Cart cart = new Cart();

  public CheesrSession(Request request) {
    super(request);
  }

  public Cart getCart() {
    return cart;
  }
}
