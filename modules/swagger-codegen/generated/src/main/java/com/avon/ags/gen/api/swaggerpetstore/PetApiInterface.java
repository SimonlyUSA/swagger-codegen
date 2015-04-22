package com.avon.ags.gen.api.swaggerpetstore;

import com.avon.ags.gen.model.swaggerpetstore.*;


import com.avon.ags.gen.model.swaggerpetstore.Pet;
import java.io.File;


import java.util.List;
import com.avon.ags.gen.api.swaggerpetstore.NotFoundException;
import com.avon.ags.gen.api.swaggerpetstore.InternalServerErrorException;
import com.avon.ags.gen.api.swaggerpetstore.BadRequestException;
import java.io.InputStream;
import com.sun.jersey.core.header.FormDataContentDisposition;



public interface PetApiInterface {
  
  public void updatePetImpl( Pet body
)
      throws NotFoundException, BadRequestException, InternalServerErrorException ;

  
  public void addPetImpl( Pet body
)
      throws NotFoundException, BadRequestException, InternalServerErrorException ;

  
  public Pet []/*List*/ findPetsByStatusImpl( List<String> status
)
      throws NotFoundException, BadRequestException, InternalServerErrorException ;

  
  public Pet []/*List*/ findPetsByTagsImpl( List<String> tags
)
      throws NotFoundException, BadRequestException, InternalServerErrorException ;

  
  public Pet getPetByIdImpl( Long petId
)
      throws NotFoundException, BadRequestException, InternalServerErrorException ;

  
  public void updatePetWithFormImpl( String petId
,  String name
,  String status
)
      throws NotFoundException, BadRequestException, InternalServerErrorException ;

  
  public void deletePetImpl( String apiKey
, Long petId
)
      throws NotFoundException, BadRequestException, InternalServerErrorException ;

  
  public void uploadFileImpl( Long petId
,  String additionalMetadata
, InputStream inputStream, FormDataContentDisposition fileDetail
)
      throws NotFoundException, BadRequestException, InternalServerErrorException ;

  
}


