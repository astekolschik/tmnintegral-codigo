/**
 * 
 */
package com.tmnintegral.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tmnintegral.domain.Configuration;
import com.tmnintegral.domain.Device;
import com.tmnintegral.domain.EquipmentInformation;
import com.tmnintegral.domain.Interface;
import com.tmnintegral.domain.Red;
import com.tmnintegral.domain.TipoEquipo;
import com.tmnintegral.repository.ConfigurationDao;
import com.tmnintegral.repository.DeviceDao;
import com.tmnintegral.repository.InterfaceDao;
import com.tmnintegral.repository.RedDao;
import com.tmnintegral.repository.TipoEquipoDao;
import com.tmnintegral.repository.TopologiaDao;

/**
 * @author Agustina/Martin
 *
 */
@Component
public class InventoryManager implements Serializable{

	private static final long serialVersionUID = 1L;

	@Autowired
	private TipoEquipoDao tipoEquipoDao;
	@Autowired
	private DeviceDao deviceDao;
	@Autowired
	private InterfaceDao interfaceDao;
	@Autowired
	private RedDao redDao;
	@Autowired
	private ConfigurationDao configurationDao;
	@Autowired
	private TopologiaDao topologiaDao;

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
	
	public JSONObject obtenerTopologiaDeRed(){
		return this.topologiaDao.getTopologia();
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
	
	public Device modificarDevice(String communityRead, String hostName, String iosType, String iosVersion, String ip, int model,
			int serialNumber, String softwareRelease, TipoEquipo tipoEquipo, Red network, Configuration configuration, EquipmentInformation equipmentInformation, Interface interfaz, String enable, Date last_update_date){
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
//			if (d.getModel()!=model)
//				d.setModel(model);
//			if (d.getSerialNumber()!=serialNumber)
//				d.setSerialNumber(serialNumber);
			if (!d.getSoftwareRelease().equals(softwareRelease))
				d.setSoftwareRelease(softwareRelease);
			if (d.getId_device_type()!=(tipoEquipo.getId()))
				d.setId_device_type(tipoEquipo.getId());
			if (d.getId_network()!= network.getId_network())
				d.setId_network(network.getId_network());
			if (d.getId_configuration()!= configuration.getId_configuration())
				d.setId_configuration(configuration.getId_configuration());
			if (d.getId_equipment_info()!= equipmentInformation.getEquipment_id())
				d.setId_equipment_info(equipmentInformation.getEquipment_id());
//			if (d.getId_interface()!=(interfaz.getId()))
//				d.setId_interface(interfaz.getId());
			if (!d.getEnable().equals(enable))
				d.setEnable(enable);
			if (!d.getLast_update_date().equals(last_update_date))
				d.setLast_update_date(last_update_date);
			
			this.deviceDao.updateDevice(d);
		}
		
		return d;
	}
	
	public Device modificarDevice(int device_id, String communityRead, String hostName, String iosType, String iosVersion, String ip, int model,
			int serialNumber, String softwareRelease, TipoEquipo tipoEquipo, Red network, Configuration configuration, EquipmentInformation equipmentInformation, Interface interfaz, String enable, Date last_update_date){
		Device d = this.getDevice(device_id);
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
//			if (d.getModel()!=model)
//				d.setModel(model);
//			if (d.getSerialNumber()!=serialNumber)
//				d.setSerialNumber(serialNumber);
			if (!d.getSoftwareRelease().equals(softwareRelease))
				d.setSoftwareRelease(softwareRelease);
			if (d.getId_device_type()!=(tipoEquipo.getId()))
				d.setId_device_type(tipoEquipo.getId());
			if (d.getId_network()!= network.getId_network())
				d.setId_network(network.getId_network());
			if (d.getId_configuration()!= configuration.getId_configuration())
				d.setId_configuration(configuration.getId_configuration());
			if (d.getId_equipment_info()!= equipmentInformation.getEquipment_id())
				d.setId_equipment_info(equipmentInformation.getEquipment_id());
//			if (d.getId_interface()!=(interfaz.getId()))
//				d.setId_interface(interfaz.getId());
			if (!d.getEnable().equals(enable))
				d.setEnable(enable);
			if (!d.getLast_update_date().equals(last_update_date))
				d.setLast_update_date(last_update_date);
		}
		
		return d;
	}
	public TipoEquipo getTipoEquipo(int id_tipoEquipo) {return tipoEquipoDao.getTipoEquipo(id_tipoEquipo);}
	
	public Interface getInterface(int iId) {
		return interfaceDao.getInterface(iId);
	}
	
	public Interface getInterface(String name) {
		return interfaceDao.getInterface(name);
	}
	
	public Red getRed(String net) {return redDao.getRed(net);}
	
	public Red getRed(int net) {
		return redDao.getRed(net);
	}
	
	public Configuration getConfiguration (int id_configuration){return configurationDao.getConfiguration(id_configuration);}
	
	public EquipmentInformation getEquipmentInformation (int id_equipment_information){
		return new EquipmentInformation();//equipmentInformationDao.getEquipmentInformation(id_equipment_information);
	}
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
	
	public void eliminarInterface(Integer id){
		interfaceDao.deleteInterface(id);
	}
	
	public void eliminarInterface(Interface i){interfaceDao.deleteInterface(i);}
	
	public Interface modificarInterface(Integer id, String adminStatus, String alias, String name, Integer shelf, Integer slot, 
			Integer port, Integer subPort, String type, Integer deviceId, Integer ifIndex, String ipAdEntIfIndex, 
			String mac, Integer ip_next_hop, String mac_next_hop){
		Interface i = this.getInterface(id);
		if (i != null){
			if (!i.getAdminStatus().equals(adminStatus))
				i.setAdminStatus(adminStatus);
			if (!i.getAlias().equals(alias))
				i.setAlias(alias);
			if (!i.getName().equals(name))
				i.setName(name);
			if (i.getShelf() != (shelf))
				i.setShelf(shelf);
			if (i.getSlot() != (slot))
				i.setSlot(slot);
			if (i.getPort() != (port))
				i.setPort(port);
			if (i.getSubPort() != (subPort))
				i.setSubPort(subPort);
			if (!i.getType().equals(type))
				i.setType(type);
			if (i.getId_device()!= deviceId)
				i.setId_device(deviceId);
			if (i.getIfIndex()!= ifIndex)
				i.setIfIndex(ifIndex);
			if (!i.getIpAdEntIfIndex().equals(ipAdEntIfIndex))
				i.setIpAdEntIfIndex(ipAdEntIfIndex);
			if (i.getMac()!= mac)
				i.setMac(mac);
			if (i.getIp_next_hop()!=ip_next_hop)
				i.setIp_next_hop(ip_next_hop);
			if (i.getMac_next_hop()!= mac_next_hop)
				i.setMac_next_hop(mac_next_hop);
			
			i.setLast_update_date(new Date());
			this.interfaceDao.updateInterface(i);
		}
		return i;
	}
	
	public Interface crearInterface(String adminStatus, String alias, String name, int shelf, int slot, 
			int port, int subPort, String type, int deviceId, int ifIndex, String ipAdEntIfIndex, 
			String mac, int ip_next_hop, String mac_next_hop){
		Interface i = new Interface();
		i.setAdminStatus(adminStatus);
		i.setAlias(alias);
		i.setName(name);
		i.setShelf(shelf);
		i.setSlot(slot);
		i.setPort(port);
		i.setSubPort(subPort);
		i.setType(type);
		i.setId_device(deviceId);
		i.setIfIndex(ifIndex);
		i.setIpAdEntIfIndex(ipAdEntIfIndex);
		i.setMac(mac);
		i.setIp_next_hop(ip_next_hop);
		i.setMac_next_hop(mac_next_hop);
		i.setLast_update_date(new Date());
		
		try {
			this.interfaceDao.saveInterface(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public List<Red> getRedList(){
		return this.redDao.getRedList();
	}
	
	public void eliminarRed(int id_red){
		this.redDao.deleteRed(id_red);
	}
	
	public Red getRedById(int redId){
		return this.redDao.getRed(redId);
	}
	
	public Red modificarRed(Integer id, String network, byte enabled, String description){
		Red r = this.getRed(id);
		if (r != null){
			if (!r.getNetwork().equals(network))
				r.setNetwork(network);
			if (r.getEnabled() != enabled)
				r.setEnabled(enabled);
			if (!r.getDescription().equals(description))
				r.setDescription(description);
			
			this.redDao.updateRed(r);
		}
		return r;
	}
	
	public Red crearRed(String network, byte enabled, String description){
		Red r = new Red();
		r.setNetwork(network);
		r.setEnabled(enabled);
		r.setDescription(description);
		
		try {
			this.redDao.saveRed(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return r; 
	}
	
	
	public Device modificarDevice(int dId, String communityRead, String hostName, String iosType, String iosVersion, String ip,
			String model, String serialNumber, String softwareRelease, Integer id_device_type, Integer id_network,
			Integer id_configuration, Integer id_equipment_info, String enable){
		
		Device d = this.getDevice(dId);
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
		if (!d.getModel().equals(model))
			d.setModel(model);
		if (!d.getSerialNumber().equals(serialNumber))
			d.setSerialNumber(serialNumber);
		if (!d.getSoftwareRelease().equals(softwareRelease))
			d.setSoftwareRelease(softwareRelease);
		if (d.getDevice_id() != id_device_type)
			d.setId_device_type(id_device_type);
		if (d.getId_network() != id_network)
			d.setId_network(id_network);
		if (d.getId_configuration() != id_configuration)
			d.setId_configuration(id_configuration);
		if (d.getId_equipment_info() != id_equipment_info)
			d.setId_equipment_info(id_equipment_info);
		if (!d.getEnable().equals(enable))
			d.setEnable(enable);
		d.setLast_update_date(new Date());

		this.deviceDao.updateDevice(d);
		
		return d;
	}
	
	
	public Device crearDevice(String communityRead, String hostName, String iosType, String iosVersion, String ip,
			String model, String serialNumber, String softwareRelease, Integer id_device_type, Integer id_network,
			Integer id_configuration, Integer id_equipment_info, String enable){
		Device d = new Device();
		d.setCommunityRead(communityRead);
		d.setHostName(hostName);
		d.setIosType(iosType);
		d.setIosVersion(iosVersion);
		d.setIp(ip);
		d.setModel(model);
		d.setSerialNumber(serialNumber);
		d.setSoftwareRelease(softwareRelease);
		d.setId_device_type(id_device_type);
		d.setId_network(id_network);
		d.setId_configuration(id_configuration);
		d.setId_equipment_info(id_equipment_info);
		d.setEnable(enable);
		d.setLast_update_date(new Date());
		
		try {
			this.deviceDao.saveDevice(d);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return d;
	}

	/**
	 * @param topologiaDao the topologiaDao to set
	 */
	public void setTopologiaDao(TopologiaDao topologiaDao) {
		this.topologiaDao = topologiaDao;
	}
}
