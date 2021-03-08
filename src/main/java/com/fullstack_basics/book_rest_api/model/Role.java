package com.fullstack_basics.book_rest_api.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "role_tbl")
public class Role {
    
	@Id
	@GeneratedValue
	public int id;

	public String name;
	@OneToMany(targetEntity = User.class,mappedBy = "role",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	public Set<User> roles;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
