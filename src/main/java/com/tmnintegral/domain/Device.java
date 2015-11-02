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
@Table(name="Device") 
public class Device implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "device_id")
	private int id_device; 
	private String communityRead;
	private String hostName;
	private String iosType;
	private String iosVersion;
	private String ip;
	private String model;
	private String serialNumber;
	private String softwareRelease;
//	private TipoEquipo tipoEquipo;
//	private Interface interfaz;
//	private Red red;
	//private Configuration configuration;
	//private EquipmentInfo equipmentInfo;
	private Boolean enable;
	
	
	public Device(){
		super();
	}
	
	public Device(String communityRead, String hostName, String iosType, String iosVersion, String ip, String model,
			String serialNumber, String softwareRelease, TipoEquipo tipoEquipo, Interface interfaz, Red red, Boolean enable){
		super();
		//this.id_device = id_device;
		this.communityRead = communityRead;
		this.hostName = hostName;
		this.iosType = iosType;
		this.iosVersion = iosVersion;
		this.ip = ip;
		this.model = model;
		this.serialNumber = serialNumber;
		this.softwareRelease = softwareRelease;
//		this.tipoEquipo = tipoEquipo;
//		this.interfaz = interfaz;
//		this.red = red;
		//this.configuration = configuration;
		//this.equipmentInfo = equipmentInfo;
		this.enable = enable;
		
	}

	

	public int getId_device() {return id_device;}

	public void setId_device(int id_device) {this.id_device = id_device;}

	public String getCommunityRead() {return communityRead;}
	
	public void setCommunityRead(String cr) {this.communityRead = cr;}
	
	public String getHostName(){return hostName;}
	
	public void setHostName(String hostName){this.hostName = hostName;}
	
	public String getIosType(){return iosType;}
	
	public void setIosType(String iosType){this.iosType = iosType;}
	
	public String getIosVersion(){return iosVersion;}
	
	public void setIosVersion(String iosVersion){this.iosVersion = iosVersion;}
	
	public String getIp(){return ip;}
	
	public void setIp(String ip){this.ip = ip;}
	
	public String getModel(){return model;}
	
	public void setModel(String model){this.model = model;}
	
	public String getSerialNumber(){return serialNumber;}
	
	public void setSerialNumber(String sn){this.serialNumber = sn;}
	
	public String getSoftwareRelease(){return softwareRelease;}
	
	public void setSoftwareRelease(String sr){this.softwareRelease = sr;}
	
//	public TipoEquipo getTipoEquipo(){return tipoEquipo;}
//	
//	public void setTipoEquipo(TipoEquipo te){this.tipoEquipo = te;}
	
//	public Interface getInterface_Device(){return this.interfaz;}
//	
//	public void setInterface_Device(Interface interfaz){this.interfaz = interfaz;}
	
//	public Red getRed_Device(){return red;}
//	
//	public void setRed_Device(Red red){this.red = red;}
//	
	public Boolean getEnable_Device(){return enable;}
	
	public void setEnable_Device(Boolean enable){this.enable = enable;}
	
	
	}