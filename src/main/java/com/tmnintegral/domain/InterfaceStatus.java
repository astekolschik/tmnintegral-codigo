package com.tmnintegral.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Agustina
 *
 */
@Entity
@Table(name="flt_interface_status") 
public class InterfaceStatus implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id")
	private int id;
	private int idVariable; 
	private String valor;
	private String elementName;
	private BigInteger last_update_state;
	private int retry_enable;
	@Column(name = "last_email_sent")
	@Temporal(TemporalType.TIMESTAMP)
	private Date last_email_sent;
	
	public InterfaceStatus(){
		super();
	}


	/**
	 * @param idVariable
	 * @param valor
	 * @param elementName
	 * @param last_update_state
	 * @param retry_enable
	 */
	public InterfaceStatus(int idVariable, String valor, String elementName, BigInteger last_update_state,
			int retry_enable, Date last_email_sent) {
		super();
		this.idVariable = idVariable;
		this.valor = valor;
		this.elementName = elementName;
		this.last_update_state = last_update_state;
		this.retry_enable = retry_enable;
		this.last_email_sent = last_email_sent;
	}

	/**
	 * @return the idVariable
	 */
	public int getIdVariable() {
		return idVariable;
	}


	/**
	 * @param idVariable the idVariable to set
	 */
	public void setIdVariable(int idVariable) {
		this.idVariable = idVariable;
	}


	/**
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}


	/**
	 * @param valor the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}


	/**
	 * @return the elementName
	 */
	public String getElementName() {
		return elementName;
	}


	/**
	 * @param elementName the elementName to set
	 */
	public void setElementName(String elementName) {
		this.elementName = elementName;
	}


	/**
	 * @return the last_update_state
	 */
	public BigInteger getLast_update_state() {
		return last_update_state;
	}


	/**
	 * @param last_update_state the last_update_state to set
	 */
	public void setLast_update_state(BigInteger last_update_state) {
		this.last_update_state = last_update_state;
	}


	/**
	 * @return the retry_enable
	 */
	public int getRetry_enable() {
		return retry_enable;
	}


	/**
	 * @param retry_enable the retry_enable to set
	 */
	public void setRetry_enable(int retry_enable) {
		this.retry_enable = retry_enable;
	}


	/**
	 * @return the last_email_sent
	 */
	public Date getLast_email_sent() {
		return last_email_sent;
	}


	/**
	 * @param last_email_sent the last_email_sent to set
	 */
	public void setLast_email_sent(Date last_email_sent) {
		this.last_email_sent = last_email_sent;
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


}