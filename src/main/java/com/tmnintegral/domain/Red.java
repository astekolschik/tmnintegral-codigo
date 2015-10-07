package com.tmnintegral.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Usuario
 *
 */
@Entity
@Table(name="Red") 
public class Red implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id_red")
	private int id_red; 
	private String net;
	private Boolean enable;
	private String description;
	
	
	public Red(){
		super();
	}
	
	public Red(String net, Boolean enable, String description){
		super();
		this.net = net;
		this.enable = enable;
		this.description = description;
		
	}

	

	public int getId_red() {return id_red;}

	public void setId_red(int id_red) {this.id_red = id_red;}

	public String getNet() {return net;}
	
	public void setNet(String net) {this.net = net;}
	
	public Boolean getEnable(){return enable;}
	
	public void setEnable(Boolean enable){this.enable = enable;}
	
	public String getDescription(){return description;}
	
	public void setDescription(String description){this.description = description;}
	
	}