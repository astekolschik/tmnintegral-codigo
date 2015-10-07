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
@Table(name="Interface") 
public class Interface implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id")
	private int id; 
	private String adminStatus;
	private String alias;
	private String name;
	private int shelf;
	private int slot;
	private int port;
	private int subPort;
	private String type;
	private Device device;  //en la base de datos tiene un id device//
	
	
	public Interface(){
		super();
	}
	
	public Interface(String adminStatus, String alias, String name, int shelf, int slot, int port, int subPort, String type, Device device){
		super();
		
		this.adminStatus = adminStatus;
		this.alias = alias;
		this.name = name;
		this.shelf = shelf;
		this.slot = slot;
		this.port = port;
		this.subPort = subPort;
		this.type = type;
		this.device = device;
		
	}

	

	public int getId() {return id;}

	public void setId(int id) {this.id = id;}

	public String getAdminStatus() {return adminStatus;}
	
	public void setAdminStatus(String as) {this.adminStatus = as;}
	
	public String getAlias(){return alias;}
	
	public void setAlias(String alias){this.alias = alias;}
	
	public String getName(){return name;}
	
	public void setName(String name){this.name = name;}
	
	public int getShelf(){return shelf;}
	
	public void setShelf(int shelf){this.shelf = shelf;}
	
	public int getSlot(){return slot;}
	
	public void setSlot(int slot){this.slot = slot;}
	
	public int getPort(){return port;}
	
	public void setPort(int port){this.port = port;}
	
	public int getSubPort(){return subPort;}
	
	public void setSubPort(int sp){this.subPort = sp;}
	
	public String getType(){return type;}
	
	public void setType(String type){this.type = type;}
	
	public Device getDevice(){return device;}
	
	public void setDevice(Device de){this.device = de;}
	
	}