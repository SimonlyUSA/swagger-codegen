package com.avon.ags.gen.api.swaggerpetstore;

import com.avon.ags.gen.model.swaggerpetstore.*;


import com.avon.ags.gen.model.swaggerpetstore.User;
import java.util.*;


import java.util.List;
import com.avon.ags.gen.api.swaggerpetstore.NotFoundException;
import com.avon.ags.gen.api.swaggerpetstore.InternalServerErrorException;
import com.avon.ags.gen.api.swaggerpetstore.BadRequestException;
import java.io.InputStream;
import com.sun.jersey.core.header.FormDataContentDisposition;



public interface UserApiInterface {
  
  public void createUserImpl( User body
)
      throws NotFoundException, BadRequestException, InternalServerErrorException ;

  
  public void createUsersWithArrayInputImpl( List<User> body
)
      throws NotFoundException, BadRequestException, InternalServerErrorException ;

  
  public void createUsersWithListInputImpl( List<User> body
)
      throws NotFoundException, BadRequestException, InternalServerErrorException ;

  
  public String loginUserImpl( String username
, String password
)
      throws NotFoundException, BadRequestException, InternalServerErrorException ;

  
  public void logoutUserImpl()
      throws NotFoundException, BadRequestException, InternalServerErrorException ;

  
  public User getUserByNameImpl( String username
)
      throws NotFoundException, BadRequestException, InternalServerErrorException ;

  
  public void updateUserImpl( String username
, User body
)
      throws NotFoundException, BadRequestException, InternalServerErrorException ;

  
  public void deleteUserImpl( String username
)
      throws NotFoundException, BadRequestException, InternalServerErrorException ;

  
}


