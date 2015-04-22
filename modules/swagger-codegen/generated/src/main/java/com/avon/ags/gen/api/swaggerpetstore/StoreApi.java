package com.avon.ags.gen.api.swaggerpetstore;

import com.avon.ags.gen.model.swaggerpetstore.*;

import com.avon.ags.api.base.AGSBaseRes;
import com.avon.ags.api.base.AGSError;
import com.avon.ags.api.base.AGSError.SeverityCd;

import com.wordnik.swagger.annotations.*;
import com.sun.jersey.multipart.FormDataParam;

import java.util.Map;
import com.avon.ags.gen.model.swaggerpetstore.Order;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import com.avon.ags.gen.api.swaggerpetstore.NotFoundException;
import com.avon.ags.gen.api.swaggerpetstore.BadRequestException;
import com.avon.ags.gen.api.swaggerpetstore.InternalServerErrorException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.*;

@Path("/store")
@Api(value = "/store", description = "the store API")

public class StoreApi {
	
	//load instance via ServiceLoader
	static StoreApiInterface instance ;//=new StoreApiImpl();
	static  {
		    ServiceLoader<StoreApiInterface> loader = ServiceLoader.load(StoreApiInterface.class);
		    List<StoreApiInterface> output = new ArrayList<StoreApiInterface>();
		    Iterator<StoreApiInterface> itr = loader.iterator();
		    StoreApiInterface stub=null;
		    while(itr.hasNext()) {
		    	
		    	try{
			    	StoreApiInterface next =itr.next();
			    	System.out.println(next.getClass().getName());
			    	if(next.getClass().getName().endsWith("STUB")){
			    		stub=next;
			    	}
			    	else{
			    		instance=next;
			    	}
		    	}catch(Throwable t){
		    		t.printStackTrace();
		    	}
		    }
		    if (instance==null)instance=stub;
		  }
	
	
	
	public StoreApiInterface getInstance() {
		return instance;
	}
	public void setInstance(StoreApiInterface instance) {
		this.instance = instance;
	}

  
  @GET
  @Path("/inventory")
  
  @Produces({ "application/json", "application/xml" })
  @ApiOperation(value = "Returns pet inventories by status", notes = "Returns a map of status codes to quantities", response = Integer.class, responseContainer = "map")
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "successful operation") })

  public Response getInventory()
      throws NotFoundException {
	  Integer []/*map*/ response=null;
	  try{
		  
		  response=
		  instance.getInventoryImpl();
	  } catch (Exception e) {
		return handleException(e);
	  }
      return Response.ok().entity(response).build();
   }

  
  @POST
  @Path("/order")
  
  @Produces({ "application/json", "application/xml" })
  @ApiOperation(value = "Place an order for a pet", notes = "", response = Order.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "successful operation"),
    
    @ApiResponse(code = 400, message = "Invalid Order") })

  public Response placeOrder(@ApiParam(value = "order placed for purchasing the pet"  ) Order body)
      throws NotFoundException {
	  Order response=null;
	  try{
		  
		  response=
		  instance.placeOrderImpl(body);
	  } catch (Exception e) {
		return handleException(e);
	  }
      return Response.ok().entity(response).build();
   }

  
  @GET
  @Path("/order/{orderId}")
  
  @Produces({ "application/json", "application/xml" })
  @ApiOperation(value = "Find purchase order by ID", notes = "For valid response try integer IDs with value <= 5 or > 10. Other values will generated exceptions", response = Order.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 404, message = "Order not found"),
    
    @ApiResponse(code = 200, message = "successful operation"),
    
    @ApiResponse(code = 400, message = "Invalid ID supplied") })

  public Response getOrderById(@ApiParam(value = "ID of pet that needs to be fetched",required=true ) @PathParam("orderId") String orderId)
      throws NotFoundException {
	  Order response=null;
	  try{
		  
		  response=
		  instance.getOrderByIdImpl(  orderId);
	  } catch (Exception e) {
		return handleException(e);
	  }
      return Response.ok().entity(response).build();
   }

  
  @DELETE
  @Path("/order/{orderId}")
  
  @Produces({ "application/json", "application/xml" })
  @ApiOperation(value = "Delete purchase order by ID", notes = "For valid response try integer IDs with value < 1000. Anything above 1000 or nonintegers will generate API errors", response = Void.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 404, message = "Order not found"),
    
    @ApiResponse(code = 400, message = "Invalid ID supplied") })

  public Response deleteOrder(@ApiParam(value = "ID of the order that needs to be deleted",required=true ) @PathParam("orderId") String orderId)
      throws NotFoundException {
	  Void response=null;
	  try{
		  
		  
		  instance.deleteOrderImpl(  orderId);
	  } catch (Exception e) {
		return handleException(e);
	  }
      return Response.ok().entity(response).build();
   }

  
  
    private Response handleException(Exception e) {

	  Response ret = null;
	  
	  AGSBaseRes errorRes = new AGSBaseRes();
	  errorRes.setErrors(new ArrayList<AGSError>());
	  AGSError err = new AGSError();
	  err.setErrorMsg(e.getMessage());
	  
	  if (e instanceof NotFoundException) {
		  err.setSeverityCd(SeverityCd.WARNING);
		  ret = Response.status(Status.NOT_FOUND).entity(errorRes).build();
	  } else if (e instanceof BadRequestException) {
		  err.setSeverityCd(SeverityCd.WARNING);
		  ret = Response.status(Status.BAD_REQUEST).entity(errorRes).build(); 
	  } else if (e instanceof InternalServerErrorException) {
		  err.setSeverityCd(SeverityCd.ERROR);
		  ret = Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorRes).build();
	  } else {
		  err.setSeverityCd(SeverityCd.ERROR);
		  ret = Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorRes).build();
	  }
	  errorRes.getErrors().add(err);
	  
	  return ret; 
  }
  
}

