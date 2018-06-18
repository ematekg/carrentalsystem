package edu.mum.carrentalsystem.model.user;


import edu.mum.carrentalsystem.model.ICredential;


public class Credential implements ICredential {

  private Long id;
  private String username;
  private String password;
  private Role role;
}
