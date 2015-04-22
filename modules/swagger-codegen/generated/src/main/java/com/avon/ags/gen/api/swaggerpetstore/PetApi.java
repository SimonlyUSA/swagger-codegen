package com.avon.ags.gen.api.swaggerpetstore;

import com.avon.ags.gen.model.swaggerpetstore.*;

import com.avon.ags.api.base.AGSBaseRes;
import com.avon.ags.api.base.AGSError;
import com.avon.ags.api.base.AGSError.SeverityCd;

import com.wordnik.swagger.annotations.*;
import com.sun.jersey.multipart.FormDataParam;

import com.avon.ags.gen.model.swaggerpetstore.Pet;
import java.io.File;


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

@Path("/pet")
@Api(value = "/pet", description = "the pet API")

public class PetApi {
	
	//load instance via ServiceLoader
	static PetApiInterface instance ;//=new PetApiImpl();
	static  {
		    ServiceLoader<PetApiInterface> loader = ServiceLoader.load(PetApiInterface.class);
		    List<PetApiInterface> output = new ArrayList<PetApiInterface>();
		    Iterator<PetApiInterface> itr = loader.iterator();
		    PetApiInterface stub=null;
		    while(itr.hasNext()) {
		    	
		    	try{
			    	PetApiInterface next =itr.next();
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
	
	
	
	public PetApiInterface getInstance() {
		return instance;
	}
	public void setInstance(PetApiInterface instance) {
		this.instance = instance;
	}

  
  @PUT
  
  @Consumes({ "application/json", "application/xml",  })
  @Produces({ "application/json", "application/xml" })
  @ApiOperation(value = "Update an existing pet", notes = "", response = Void.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 405, message = "Validation exception"),
    
    @ApiResponse(code = 404, message = "Pet not found"),
    
    @ApiResponse(code = 400, message = "Invalid ID supplied") })

  public Response updatePet(@ApiParam(value = "Pet object that needs to be added to the store"  ) Pet body)
      throws NotFoundException {
	  Void response=null;
	  try{
		  
		  
		  instance.updatePetImpl(body);
	  } catch (Exception e) {
		return handleException(e);
	  }
      return Response.ok().entity(response).build();
   }

  
  @POST
  
  @Consumes({ "application/json", "application/xml",  })
  @Produces({ "application/json", "application/xml" })
  @ApiOperation(value = "Add a new pet to the store", notes = "", response = Void.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 405, message = "Invalid input") })

  public Response addPet(@ApiParam(value = "Pet object that needs to be added to the store"  ) Pet body)
      throws NotFoundException {
	  Void response=null;
	  try{
		  
		  
		  instance.addPetImpl(body);
	  } catch (Exception e) {
		return handleException(e);
	  }
      return Response.ok().entity(response).build();
   }

  
  @GET
  @Path("/findByStatus")
  
  @Produces({ "application/json", "application/xml" })
  @ApiOperation(value = "Finds Pets by status", notes = "Multiple status values can be provided with comma seperated strings", response = Pet.class, responseContainer = "List")
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "successful operation"),
    
    @ApiResponse(code = 400, message = "Invalid status value") })

  public Response findPetsByStatus(@ApiParam(value = "Status values that need to be considered for filter") @QueryParam("status") List<String> status)
      throws NotFoundException {
	  Pet []/*List*/ response=null;
	  try{
		  
		  response=
		  instance.findPetsByStatusImpl(  status);
	  } catch (Exception e) {
		return handleException(e);
	  }
      return Response.ok().entity(response).build();
   }

  
  @GET
  @Path("/findByTags")
  
  @Produces({ "application/json", "application/xml" })
  @ApiOperation(value = "Finds Pets by tags", notes = "Muliple tags can be provided with comma seperated strings. Use tag1, tag2, tag3 for testing.", response = Pet.class, responseContainer = "List")
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "successful operation"),
    
    @ApiResponse(code = 400, message = "Invalid tag value") })

  public Response findPetsByTags(@ApiParam(value = "Tags to filter by") @QueryParam("tags") List<String> tags)
      throws NotFoundException {
	  Pet []/*List*/ response=null;
	  try{
		  
		  response=
		  instance.findPetsByTagsImpl(  tags);
	  } catch (Exception e) {
		return handleException(e);
	  }
      return Response.ok().entity(response).build();
   }

  
  @GET
  @Path("/{petId}")
  
  @Produces({ "application/json", "application/xml" })
  @ApiOperation(value = "Find pet by ID", notes = "Returns a pet when ID < 10.  ID > 10 or nonintegers will simulate API error conditions", response = Pet.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 404, message = "Pet not found"),
    
    @ApiResponse(code = 200, message = "successful operation"),
    
    @ApiResponse(code = 400, message = "Invalid ID supplied") })

  public Response getPetById(@ApiParam(value = "ID of pet that needs to be fetched",required=true ) @PathParam("petId") Long petId)
      throws NotFoundException {
	  Pet response=null;
	  try{
		  
		  response=
		  instance.getPetByIdImpl(  petId);
	  } catch (Exception e) {
		return handleException(e);
	  }
      return Response.ok().entity(response).build();
   }

  
  @POST
  @Path("/{petId}")
  @Consumes({ "application/x-www-form-urlencoded",  })
  @Produces({ "application/json", "application/xml" })
  @ApiOperation(value = "Updates a pet in the store with form data", notes = "", response = Void.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 405, message = "Invalid input") })

  public Response updatePetWithForm(@ApiParam(value = "ID of pet that needs to be updated",required=true ) @PathParam("petId") String petId,
    @ApiParam(value = "Updated name of the pet" )@FormParam("name")  String name,
    @ApiParam(value = "Updated status of the pet" )@FormParam("status")  String status)
      throws NotFoundException {
	  Void response=null;
	  try{
		  
		  
		  instance.updatePetWithFormImpl(  petId,  name,  status);
	  } catch (Exception e) {
		return handleException(e);
	  }
      return Response.ok().entity(response).build();
   }

  
  @DELETE
  @Path("/{petId}")
  
  @Produces({ "application/json", "application/xml" })
  @ApiOperation(value = "Deletes a pet", notes = "", response = Void.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 400, message = "Invalid pet value") })

  public Response deletePet(@ApiParam(value = ""  )@HeaderParam("apiKey") String apiKey,
    @ApiParam(value = "Pet id to delete",required=true ) @PathParam("petId") Long petId)
      throws NotFoundException {
	  Void response=null;
	  try{
		  
		  
		  instance.deletePetImpl(  apiKey,  petId);
	  } catch (Exception e) {
		return handleException(e);
	  }
      return Response.ok().entity(response).build();
   }

  
  @POST
  @Path("/{petId}/uploadImage")
  @Consumes({ "multipart/form-data",  })
  @Produces({ "application/json", "application/xml" })
  @ApiOperation(value = "uploads an image", notes = "", response = Void.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 0, message = "successful operation") })

  public Response uploadFile(@ApiParam(value = "ID of pet to update",required=true ) @PathParam("petId") Long petId,
    @ApiParam(value = "Additional data to pass to server" )@FormParam("additionalMetadata")  String additionalMetadata,
    @ApiParam(value = "file to upload") @FormDataParam("file") InputStream inputStream,
    @ApiParam(value = "file detail") @FormDataParam("file") FormDataContentDisposition fileDetail)
      throws NotFoundException {
	  Void response=null;
	  try{
		  
		  
		  instance.uploadFileImpl(  petId,  additionalMetadata,  inputStream,  fileDetail);
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

