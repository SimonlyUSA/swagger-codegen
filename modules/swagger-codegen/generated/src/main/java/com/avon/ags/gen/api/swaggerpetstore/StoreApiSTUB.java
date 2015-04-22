package com.avon.ags.gen.api.swaggerpetstore;

import com.avon.ags.gen.model.swaggerpetstore.*;

import com.sun.jersey.core.header.FormDataContentDisposition;
import java.io.InputStream;
import java.util.List;


import java.util.Map;
import com.avon.ags.gen.model.swaggerpetstore.Order;

import java.util.List;
import com.avon.ags.gen.api.swaggerpetstore.NotFoundException;


public class StoreApiSTUB implements StoreApiInterface{
  
  public Integer []/*map*/ getInventoryImpl()
      throws NotFoundException {
      
      return new Integer /*Map*/   [1]/*map*/ ;
      
      
      }

  
  public Order placeOrderImpl( Order body
)
      throws NotFoundException {
      
      return new Order /*Order*/    ()/**/;
      
      
      }

  
  public Order getOrderByIdImpl( String orderId
)
      throws NotFoundException {
      
      return new Order /*Order*/    ()/**/;
      
      
      }

  
  public void deleteOrderImpl( String orderId
)
      throws NotFoundException {
      
      return;
      }

  
}

