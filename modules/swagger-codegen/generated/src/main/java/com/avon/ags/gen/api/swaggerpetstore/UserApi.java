package com.avon.ags.gen.api.swaggerpetstore;

import com.avon.ags.gen.model.swaggerpetstore.*;

import com.avon.ags.api.base.AGSBaseRes;
import com.avon.ags.api.base.AGSError;
import com.avon.ags.api.base.AGSError.SeverityCd;

import com.wordnik.swagger.annotations.*;
import com.sun.jersey.multipart.FormDataParam;

import com.avon.ags.gen.model.swaggerpetstore.User;
import java.util.*;


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

@Path("/user")
@Api(value = "/user", description = "the user API")

public class UserApi {
	
	//load instance via ServiceLoader
	static UserApiInterface instance ;//=new UserApiImpl();
	static  {
		    ServiceLoader<UserApiInterface> loader = ServiceLoader.load(UserApiInterface.class);
		    List<UserApiInterface> output = new ArrayList<UserApiInterface>();
		    Iterator<UserApiInterface> itr = loader.iterator();
		    UserApiInterface stub=null;
		    while(itr.hasNext()) {
		    	
		    	try{
			    	UserApiInterface next =itr.next();
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
	
	
	
	public UserApiInterface getInstance() {
		return instance;
	}
	public void setInstance(UserApiInterface instance) {
		this.instance = instance;
	}

  
  @POST
  
  
  @Produces({ "application/json", "application/xml" })
  @ApiOperation(value = "Create user", notes = "This can only be done by the logged in user.", response = Void.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 0, message = "successful operation") })

  public Response createUser(@ApiParam(value = "Created user object"  ) User body)
      throws NotFoundException {
	  Void response=null;
	  try{
		  
		  
		  instance.createUserImpl(body);
	  } catch (Exception e) {
		return handleException(e);
	  }
      return Response.ok().entity(response).build();
   }

  
  @POST
  @Path("/createWithArray")
  
  @Produces({ "application/json", "application/xml" })
  @ApiOperation(value = "Creates list of users with given input array", notes = "", response = Void.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 0, message = "successful operation") })

  public Response createUsersWithArrayInput(@ApiParam(value = "List of user object"  ) List<User> body)
      throws NotFoundException {
	  Void response=null;
	  try{
		  
		  
		  instance.createUsersWithArrayInputImpl(body);
	  } catch (Exception e) {
		return handleException(e);
	  }
      return Response.ok().entity(response).build();
   }

  
  @POST
  @Path("/createWithList")
  
  @Produces({ "application/json", "application/xml" })
  @ApiOperation(value = "Creates list of users with given input array", notes = "", response = Void.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 0, message = "successful operation") })

  public Response createUsersWithListInput(@ApiParam(value = "List of user object"  ) List<User> body)
      throws NotFoundException {
	  Void response=null;
	  try{
		  
		  
		  instance.createUsersWithListInputImpl(body);
	  } catch (Exception e) {
		return handleException(e);
	  }
      return Response.ok().entity(response).build();
   }

  
  @GET
  @Path("/login")
  
  @Produces({ "application/json", "application/xml" })
  @ApiOperation(value = "Logs user into the system", notes = "", response = String.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "successful operation"),
    
    @ApiResponse(code = 400, message = "Invalid username/password supplied") })

  public Response loginUser(@ApiParam(value = "The user name for login") @QueryParam("username") String username,
    @ApiParam(value = "The password for login in clear text") @QueryParam("password") String password)
      throws NotFoundException {
	  String response=null;
	  try{
		  
		  response=
		  instance.loginUserImpl(  username,  password);
	  } catch (Exception e) {
		return handleException(e);
	  }
      return Response.ok().entity(response).build();
   }

  
  @GET
  @Path("/logout")
  
  @Produces({ "application/json", "application/xml" })
  @ApiOperation(value = "Logs out current logged in user session", notes = "", response = Void.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 0, message = "successful operation") })

  public Response logoutUser()
      throws NotFoundException {
	  Void response=null;
	  try{
		  
		  
		  instance.logoutUserImpl();
	  } catch (Exception e) {
		return handleException(e);
	  }
      return Response.ok().entity(response).build();
   }

  
  @GET
  @Path("/{username}")
  
  @Produces({ "application/json", "application/xml" })
  @ApiOperation(value = "Get user by user name", notes = "", response = User.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 404, message = "User not found"),
    
    @ApiResponse(code = 200, message = "successful operation"),
    
    @ApiResponse(code = 400, message = "Invalid username supplied") })

  public Response getUserByName(@ApiParam(value = "The name that needs to be fetched. Use user1 for testing. ",required=true ) @PathParam("username") String username)
      throws NotFoundException {
	  User response=null;
	  try{
		  
		  response=
		  instance.getUserByNameImpl(  username);
	  } catch (Exception e) {
		return handleException(e);
	  }
      return Response.ok().entity(response).build();
   }

  
  @PUT
  @Path("/{username}")
  
  @Produces({ "application/json", "application/xml" })
  @ApiOperation(value = "Updated user", notes = "This can only be done by the logged in user.", response = Void.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 404, message = "User not found"),
    
    @ApiResponse(code = 400, message = "Invalid user supplied") })

  public Response updateUser(@ApiParam(value = "name that need to be deleted",required=true ) @PathParam("username") String username,
    @ApiParam(value = "Updated user object"  ) User body)
      throws NotFoundException {
	  Void response=null;
	  try{
		  
		  
		  instance.updateUserImpl(  username,body);
	  } catch (Exception e) {
		return handleException(e);
	  }
      return Response.ok().entity(response).build();
   }

  
  @DELETE
  @Path("/{username}")
  
  @Produces({ "application/json", "application/xml" })
  @ApiOperation(value = "Delete user", notes = "This can only be done by the logged in user.", response = Void.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 404, message = "User not found"),
    
    @ApiResponse(code = 400, message = "Invalid username supplied") })

  public Response deleteUser(@ApiParam(value = "The name that needs to be deleted",required=true ) @PathParam("username") String username)
      throws NotFoundException {
	  Void response=null;
	  try{
		  
		  
		  instance.deleteUserImpl(  username);
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

