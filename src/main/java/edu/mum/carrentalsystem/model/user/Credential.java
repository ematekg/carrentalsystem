package edu.mum.carrentalsystem.model.user;


import edu.mum.carrentalsystem.model.ICredential;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Credential implements ICredential {
  @Id
  @GeneratedValue
  private Long id;
  private String username;
  private String password;
  private Role role;
}
