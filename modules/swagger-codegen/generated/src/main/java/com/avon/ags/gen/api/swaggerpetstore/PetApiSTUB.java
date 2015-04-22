package com.avon.ags.gen.api.swaggerpetstore;

import com.avon.ags.gen.model.swaggerpetstore.*;

import com.sun.jersey.core.header.FormDataContentDisposition;
import java.io.InputStream;
import java.util.List;


import com.avon.ags.gen.model.swaggerpetstore.Pet;
import java.io.File;

import java.util.List;
import com.avon.ags.gen.api.swaggerpetstore.NotFoundException;


public class PetApiSTUB implements PetApiInterface{
  
  public void updatePetImpl( Pet body
)
      throws NotFoundException {
      
      return;
      }

  
  public void addPetImpl( Pet body
)
      throws NotFoundException {
      
      return;
      }

  
  public Pet []/*List*/ findPetsByStatusImpl( List<String> status
)
      throws NotFoundException {
      
      return new Pet /*Pet*/   [1]/*List*/ ;
      
      
      }

  
  public Pet []/*List*/ findPetsByTagsImpl( List<String> tags
)
      throws NotFoundException {
      
      return new Pet /*Pet*/   [1]/*List*/ ;
      
      
      }

  
  public Pet getPetByIdImpl( Long petId
)
      throws NotFoundException {
      
      return new Pet /*Pet*/    ()/**/;
      
      
      }

  
  public void updatePetWithFormImpl( String petId
,  String name
,  String status
)
      throws NotFoundException {
      
      return;
      }

  
  public void deletePetImpl( String apiKey
, Long petId
)
      throws NotFoundException {
      
      return;
      }

  
  public void uploadFileImpl( Long petId
,  String additionalMetadata
, InputStream inputStream, FormDataContentDisposition fileDetail
)
      throws NotFoundException {
      
      return;
      }

  
}

