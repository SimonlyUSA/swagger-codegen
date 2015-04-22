package com.avon.ags.gen.api.swaggerpetstore;

import com.avon.ags.gen.model.swaggerpetstore.*;


import java.util.Map;
import com.avon.ags.gen.model.swaggerpetstore.Order;


import java.util.List;
import com.avon.ags.gen.api.swaggerpetstore.NotFoundException;
import com.avon.ags.gen.api.swaggerpetstore.InternalServerErrorException;
import com.avon.ags.gen.api.swaggerpetstore.BadRequestException;
import java.io.InputStream;
import com.sun.jersey.core.header.FormDataContentDisposition;



public interface StoreApiInterface {
  
  public Integer []/*map*/ getInventoryImpl()
      throws NotFoundException, BadRequestException, InternalServerErrorException ;

  
  public Order placeOrderImpl( Order body
)
      throws NotFoundException, BadRequestException, InternalServerErrorException ;

  
  public Order getOrderByIdImpl( String orderId
)
      throws NotFoundException, BadRequestException, InternalServerErrorException ;

  
  public void deleteOrderImpl( String orderId
)
      throws NotFoundException, BadRequestException, InternalServerErrorException ;

  
}


