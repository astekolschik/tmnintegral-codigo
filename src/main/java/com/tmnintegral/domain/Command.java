/**
 * 
 */
package com.tmnintegral.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Agustina
 *
 */
@Entity
@Table(name="commands") 
public class Command implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id_command")
	private Integer id_command;
	
	private String command;
	private String command_type;
	
	@ManyToMany
    @JoinTable(name="command_devicetype",
    		joinColumns={@JoinColumn(name="id_command", referencedColumnName="id_command")},
    	    inverseJoinColumns={@JoinColumn(name="id_device_type", referencedColumnName="id")})
	private Set<TipoEquipo> deviceTypes;
	
	public Command(){
		super();
	}
	
	public Command(Integer id, String command, String command_type) {
		super();
		this.id_command = id;
		this.command = command;
		this.command_type = command_type;
	}
	
	/**
	 * @return the command
	 */
	public String getCommand() {
		return command;
	}
	/**
	 * @param command the command to set
	 */
	public void setCommand(String command) {
		this.command = command;
	}
	/**
	 * @return the command_type
	 */
	public String getCommand_type() {
		return command_type;
	}
	/**
	 * @param command_type the command_type to set
	 */
	public void setCommand_type(String command_type) {
		this.command_type = command_type;
	}

	/**
	 * @return the deviceTypes
	 */
	public Set<TipoEquipo> getDeviceTypes() {
		return deviceTypes;
	}

	/**
	 * @param deviceTypes the deviceTypes to set
	 */
	public void setDeviceTypes(Set<TipoEquipo> deviceTypes) {
		this.deviceTypes = deviceTypes;
	}

	/**
	 * @return the id_command
	 */
	public Integer getId_command() {
		return id_command;
	}

	/**
	 * @param id_command the id_command to set
	 */
	public void setId_command(Integer id_command) {
		this.id_command = id_command;
	}
	
}
