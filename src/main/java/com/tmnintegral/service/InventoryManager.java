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
import com.tmnintegral.domain.Device;
import com.tmnintegral.repository.DeviceDao;
import com.tmnintegral.domain.Interface;
import com.tmnintegral.repository.InterfaceDao;
import com.tmnintegral.domain.Red;
import com.tmnintegral.repository.RedDao;

/**
 * @author Agustina/Martin
 *
 */
@Component
public class InventoryManager implements Serializable{

	private static final long serialVersionUID = 1L;

	@Autowired
	private TipoEquipoDao tipoEquipoDao;
	private DeviceDao deviceDao;
	private InterfaceDao interfaceDao;
	private RedDao redDao;

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
			int id, String description, String defaultComm, String defaultSNMP,
			String driver, String technology, String vendor){
		
		TipoEquipo te = this.getTipoDeEquipoById(id);
		if(te != null){
			if (!te.getDescription().equals(description))
				te.setDescription(description);
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
	
	/**
	 * Crea un nuevo tipo de equipo
	 * @param description
	 * @param defaultComm
	 * @param defaultSNMP
	 * @param driver
	 * @param technology
	 * @param vendor
	 * @return
	 */
	public TipoEquipo crearTipoEquipo(String description, String defaultComm, String defaultSNMP,
			String driver, String technology, String vendor){
		
		TipoEquipo te = new TipoEquipo();
		te.setDescription(description);
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
	
	/**
	 * Elimina el tipo de equipo seleccionado
	 * @param idTe
	 */
	public void borrarTipoEquipo(int idTe){
		this.tipoEquipoDao.deleteTipoEquipo(idTe);
	}
	
	public String obtenerTopologiaDeRed(int netId){
		switch(netId){
		case 1: return "red -> red -> 2; 2 -> 3; 2 -- 4; 2 -> red ";
		case 2: return "red -> 2; 2 -> 3; 2 -- 4; 2 -> red; 5 -> 2";
		case 3: return "red -> red ";
		case 4: return "red -> 3; 2 -- 4; 2 -> red ";
		}
		
		return "";
	}
	
	/*
	 * 
	 * 
	 * 
	 * Device
	 * 
	 * 
	 * 
	 */
	public List<Device> getDeviceList(){
		return this.deviceDao.getDeviceList();
	}
	
	public Device altaDevice(String communityRead, String hostName, String iosType, String iosVersion, String ip, int model,
							int serialNumber, String softwareRelease, TipoEquipo tipoEquipo, Interface interfaz, Red red, Boolean enable) throws Exception{
	
	if (!existeIp(ip)){
	
		Device d = new Device(communityRead, hostName, iosType, iosVersion, ip, model, serialNumber, softwareRelease, tipoEquipo, interfaz, red, enable);

		deviceDao.saveDevice(d);
		
		return d;
	}else{
		throw new Exception("Ip ya está en uso");
		}
	}
	
	private boolean existeIp(String ip){
		if(deviceDao.getDevice(ip) != null)
			return true;
		return false;
	}
	
	public void eliminarDevice(int id_device){this.deviceDao.deleteDevice(id_device);}
	
	public void eliminarDevice(String ip){this.deviceDao.deleteDevice(ip);}
	
	public void eliminarDevice(Device d){this.deviceDao.deleteDevice(d);}
	
	public Device getDevice(String IP){
		Device d = this.deviceDao.getDevice(IP);
		return d;
	}
	
	public Device getDevice(int id_device){
		Device d = this.deviceDao.getDevice(id_device);
		return d;
	}
	
	public Device modificarDevice(String communityRead, String hostName, String iosType, String iosVersion, String ip, int model, int serialNumber, String softwareRelease, TipoEquipo tipoEquipo, Interface interfaz, Red red, Boolean enable){
		Device d = this.getDevice(ip);
		if (d != null){
			if (!d.getCommunityRead().equals(communityRead))
				d.setCommunityRead(communityRead);
			if (!d.getHostName().equals(hostName))
				d.setHostName(hostName);
			if (!d.getIosType().equals(iosType))
				d.setIosType(iosType);
			if (!d.getIosVersion().equals(iosVersion))
				d.setIosVersion(iosVersion);
			if (!d.getIp().equals(ip))
				d.setIp(ip);
			if (d.getModel()!=model)
				d.setModel(model);
			if (d.getSerialNumber()!=serialNumber)
				d.setSerialNumber(serialNumber);
			if (!d.getSoftwareRelease().equals(softwareRelease))
				d.setSoftwareRelease(softwareRelease);
			if (!d.getTipoEquipo().equals(tipoEquipo))
				d.setTipoEquipo(tipoEquipo);
			if (!d.getInterface_Device().equals(interfaz))
				d.setInterface_Device(interfaz);
			if (!d.getRed_Device().equals(red))
				d.setRed_Device(red);
			if (!d.getEnable_Device().equals(enable))
				d.setEnable_Device(enable);
			
			this.deviceDao.updateDevice(d);
		}
		
		return d;
	}
	
	public Device modificarDevice(int id_device, String communityRead, String hostName, String iosType, String iosVersion, String ip, int model, int serialNumber, String softwareRelease, TipoEquipo tipoEquipo, Interface interfaz, Red red, Boolean enable){
		Device d = this.getDevice(id_device);
		if (d != null){
			if (!d.getCommunityRead().equals(communityRead))
				d.setCommunityRead(communityRead);
			if (!d.getHostName().equals(hostName))
				d.setHostName(hostName);
			if (!d.getIosType().equals(iosType))
				d.setIosType(iosType);
			if (!d.getIosVersion().equals(iosVersion))
				d.setIosVersion(iosVersion);
			if (!d.getIp().equals(ip))
				d.setIp(ip);
			if (d.getModel()!=model)
				d.setModel(model);
			if (d.getSerialNumber()!=serialNumber)
				d.setSerialNumber(serialNumber);
			if (!d.getSoftwareRelease().equals(softwareRelease))
				d.setSoftwareRelease(softwareRelease);
			if (!d.getTipoEquipo().equals(tipoEquipo))
				d.setTipoEquipo(tipoEquipo);
			if (!d.getInterface_Device().equals(interfaz))
				d.setInterface_Device(interfaz);
			if (!d.getRed_Device().equals(red))
				d.setRed_Device(red);
			if (!d.getEnable_Device().equals(enable))
				d.setEnable_Device(enable);
			
			this.deviceDao.updateDevice(d);
		}
		
		return d;
	}
	public TipoEquipo getTipoEquipo(int id_tipoEquipo) {return tipoEquipoDao.getTipoEquipo(id_tipoEquipo);}
	
	public Interface getInterface(String name) {return interfaceDao.getInterface(name);}
	
	public Red getRed(String net) {return redDao.getRed(net);}
	
	/*
	 *
	 *
	 *	Interface
	 *
	 *
	 *
	 */
	public List<Interface> getInterfaceList(){
		return this.interfaceDao.getInterfaceList();
	}
	
	public Interface altaInterface(String adminStatus, String alias, String name, int shelf, int slot, int port, int subPort, String type, Device d) throws Exception{

			if (!existeNameInterface(name)){

				Interface i = new Interface(adminStatus, alias, name, shelf, slot, port, subPort, type, d);

				interfaceDao.saveInterface(i);

				return i;
			}else{
				throw new Exception("Nombre de la interface ya está en uso");
			}
	}
	
	private Boolean existeNameInterface(String name){
		if (interfaceDao.getInterface(name) != null){
			return true;
		}return false;
	}
	
	public void eliminarInterface(String name){interfaceDao.deleteInterface(name);}
	
	public void eliminarInterface(Interface i){interfaceDao.deleteInterface(i);}
	
	public Interface modificarInterface(String adminStatus, String alias, String name, int shelf, int slot, int port, int subPort, String type, Device d){
		Interface i = this.getInterface(name);
		if (i != null){
			if (!i.getAdminStatus().equals(adminStatus))
				i.setAdminStatus(adminStatus);
			if (!i.getName().equals(name))
				i.setName(name);
			if (i.getShelf() != (shelf))
				i.setShelf(shelf);
			if (i.getSlot() != (slot))
				i.setSlot(slot);
			if (i.getPort() != (port))
				i.setPort(port);
			if (i.getSubPort() != subPort)
				i.setSubPort(subPort);
			if (!i.getType().equals(type))
				i.setType(type);
			if (!i.getDevice().equals(d))
				i.setDevice(d);
			
			this.interfaceDao.updateInterface(i);
		}
		
		return i;
	}
	
	
}
