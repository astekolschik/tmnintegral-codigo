package com.tmnintegral.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author Usuario
 *
 */
@Entity
@Table(name="interface") 
public class Interface implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id")
	private int id; 
	private String adminStatus;
	private String alias;
	private String name;
	private Integer shelf;
	private Integer slot;
	private Integer port;
	private Integer subPort;
	private String type;
	private Integer id_device;  //en la base de datos tiene un id device//
	private Integer ifIndex;
	private String ipAdEntIfIndex;
	private String mac;
	private Integer ip_next_hop;
	private String mac_next_hop;
	private Date last_update_date;
	
	
	public Interface(){
		super();
	}
	
	

	/**
	 * Constructor
	 * @param id
	 * @param adminStatus
	 * @param alias
	 * @param name
	 * @param shelf
	 * @param slot
	 * @param port
	 * @param subPort
	 * @param type
	 * @param id_device
	 * @param ifIndexe
	 * @param ipAdEntIfIndex
	 * @param mac
	 * @param ip_next_hop
	 * @param mac_next_hop
	 * @param last_update_date
	 */
	public Interface(int id, String adminStatus, String alias, String name, int shelf, int slot, int port, int subPort,
			String type, int id_device, int ifIndexe, String ipAdEntIfIndex, String mac, int ip_next_hop,
			String mac_next_hop, Date last_update_date) {
		super();
		this.id = id;
		this.adminStatus = adminStatus;
		this.alias = alias;
		this.name = name;
		this.shelf = shelf;
		this.slot = slot;
		this.port = port;
		this.subPort = subPort;
		this.type = type;
		this.id_device = id_device;
		this.ifIndex = ifIndexe;
		this.ipAdEntIfIndex = ipAdEntIfIndex;
		this.mac = mac;
		this.ip_next_hop = ip_next_hop;
		this.mac_next_hop = mac_next_hop;
		this.last_update_date = last_update_date;
	}



	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the adminStatus
	 */
	public String getAdminStatus() {
		return adminStatus==null?"":adminStatus;
	}

	/**
	 * @param adminStatus the adminStatus to set
	 */
	public void setAdminStatus(String adminStatus) {
		this.adminStatus = adminStatus;
	}

	/**
	 * @return the alias
	 */
	public String getAlias() {
		return alias==null?"":alias;
	}

	/**
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name==null?"":name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the shelf
	 */
	public Integer getShelf() {
		return shelf;
	}

	/**
	 * @param shelf the shelf to set
	 */
	public void setShelf(int shelf) {
		this.shelf = shelf;
	}

	/**
	 * @return the slot
	 */
	public Integer getSlot() {
		return slot;
	}

	/**
	 * @param slot the slot to set
	 */
	public void setSlot(int slot) {
		this.slot = slot;
	}

	/**
	 * @return the port
	 */
	public Integer getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * @return the subPort
	 */
	public Integer getSubPort() {
		return subPort;
	}

	/**
	 * @param subPort the subPort to set
	 */
	public void setSubPort(int subPort) {
		this.subPort = subPort;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type==null?"":type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the id_device
	 */
	public Integer getId_device() {
		return id_device;
	}

	/**
	 * @param id_device the id_device to set
	 */
	public void setId_device(int id_device) {
		this.id_device = id_device;
	}


	/**
	 * @return the ipAdEntIfIndex
	 */
	public String getIpAdEntIfIndex() {
		return ipAdEntIfIndex==null?"":ipAdEntIfIndex;
	}

	/**
	 * @param ipAdEntIfIndex the ipAdEntIfIndex to set
	 */
	public void setIpAdEntIfIndex(String ipAdEntIfIndex) {
		this.ipAdEntIfIndex = ipAdEntIfIndex;
	}

	/**
	 * @return the mac
	 */
	public String getMac() {
		return mac==null?"":mac;
	}

	/**
	 * @param mac the mac to set
	 */
	public void setMac(String mac) {
		this.mac = mac;
	}

	/**
	 * @return the ip_next_hop
	 */
	public Integer getIp_next_hop() {
		return ip_next_hop;
	}

	/**
	 * @param ip_next_hop the ip_next_hop to set
	 */
	public void setIp_next_hop(int ip_next_hop) {
		this.ip_next_hop = ip_next_hop;
	}

	/**
	 * @return the mac_next_hop
	 */
	public String getMac_next_hop() {
		return mac_next_hop==null?"":mac_next_hop;
	}

	/**
	 * @param mac_next_hop the mac_next_hop to set
	 */
	public void setMac_next_hop(String mac_next_hop) {
		this.mac_next_hop = mac_next_hop;
	}

	/**
	 * @return the last_update_date
	 */
	public Date getLast_update_date() {
		return last_update_date;
	}

	/**
	 * @param last_update_date the last_update_date to set
	 */
	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}



	/**
	 * @return the ifIndex
	 */
	public Integer getIfIndex() {
		return ifIndex;
	}



	/**
	 * @param ifIndex the ifIndex to set
	 */
	public void setIfIndex(int ifIndex) {
		this.ifIndex = ifIndex;
	}

	

	
	}