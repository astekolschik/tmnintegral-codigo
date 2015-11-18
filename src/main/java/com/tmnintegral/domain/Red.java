package com.tmnintegral.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Agustina
 *
 */
@Entity
@Table(name="network") 
public class Red implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id_network")
	private int id_network; 
	private String network;
	private byte enabled;
	private String description;

	public Red(){
		super();
	}
	
	/**
	 * @param id_network
	 * @param network
	 * @param enable
	 * @param description
	 */
	public Red(int id_network, String network, byte enable, String description) {
		super();
		this.id_network = id_network;
		this.network = network;
		this.enabled = enable;
		this.description = description;
	}
	/**
	 * @return the id_network
	 */
	public int getId_network() {
		return id_network;
	}
	/**
	 * @param id_network the id_network to set
	 */
	public void setId_network(int id_network) {
		this.id_network = id_network;
	}
	/**
	 * @return the network
	 */
	public String getNetwork() {
		return network;
	}
	/**
	 * @param network the network to set
	 */
	public void setNetwork(String network) {
		this.network = network;
	}
	/**
	 * @return the enable
	 */
	public byte getEnabled() {
		return enabled;
	}
	/**
	 * @param enable the enable to set
	 */
	public void setEnabled(byte enable) {
		this.enabled = enable;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
}