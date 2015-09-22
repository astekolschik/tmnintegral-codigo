/**
 * 
 */
package com.tmnintegral.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tmnintegral.domain.TipoEquipo;
import com.tmnintegral.repository.TipoEquipoDao;

/**
 * @author Agustina
 *
 */
@Component
public class InventoryManager implements Serializable{

	private static final long serialVersionUID = 1L;

	@Autowired
	private TipoEquipoDao tipoEquipoDao;

	/**
	 * Devuelve la lista de los tipos de equipo
	 * @return
	 */
	public List<TipoEquipo> getTipoEquiposList(){
		return this.tipoEquipoDao.getTipoEquiposList();
	}
	
	/**
	 * Devuelve el equipo seleccionado en el id
	 * @param tipoEquipo
	 * @return
	 */
	public TipoEquipo getTipoDeEquipoById(int tipoEquipo){
		return this.tipoEquipoDao.getTipoEquipo(tipoEquipo);
	}
	
	/**
	 * Modifica el tipo de equipo
	 * @param id
	 * @param defaultComm
	 * @param defaultSNMP
	 * @param driver
	 * @param technology
	 * @param vendor
	 * @return
	 */
	public TipoEquipo modificarTipoEquipo(
			int id, String defaultComm, String defaultSNMP,
			String driver, String technology, String vendor){
		
		TipoEquipo te = this.getTipoDeEquipoById(id);
		if(te != null){
			if (!te.getDefault_comm_read().equals(defaultComm))
				te.setDefault_comm_read(defaultComm);
			if (!te.getDefault_snmp_version().equals(defaultSNMP))
				te.setDefault_snmp_version(defaultSNMP);
			if (!te.getDriver().equals(driver))
				te.setDriver(driver);
			if (!te.getTechnology().equals(technology))
				te.setTechnology(technology);
			if (!te.getVendor().equals(vendor))
				te.setVendor(vendor);
			
			this.tipoEquipoDao.updateTipoEquipo(te);
		}
		
		return te;
	}
	
	public TipoEquipo crearTipoEquipo(String defaultComm, String defaultSNMP,
			String driver, String technology, String vendor){
		
		TipoEquipo te = new TipoEquipo();
		te.setDefault_comm_read(defaultComm);
		te.setDefault_snmp_version(defaultSNMP);
		te.setDriver(driver);
		te.setTechnology(technology);
		te.setVendor(vendor);

		try {
			te = this.tipoEquipoDao.saveTipoEquipo(te);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return te;
	}
	
	public void borrarTipoEquipo(int idTe){
		this.tipoEquipoDao.deleteTipoEquipo(idTe);
	}
	
}
