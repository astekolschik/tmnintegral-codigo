package com.tmnintegral.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tmnintegral.domain.Device;
import com.tmnintegral.repository.DeviceDao;

/**
 * @author Agustina
 *
 */
@Repository(value = "DeviceDao")
public class JPADeviceDao implements DeviceDao{

	private EntityManager em = null;

    /*
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
	
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
	public Device getDevice(int id_device) throws NoResultException{
    	Device d = null;
    	try{
    		d = (Device) em.createQuery("select d from Device d where d.id_device = " + id_device).getSingleResult();
    	}catch(NoResultException e){
    		//log ("No se encontro el rol con id: " + roleId);
    	}
    	return d;
	}
    
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
	public Device getDevice(String ip) throws NoResultException{
    	Device d = null;
    	try{
    		d = (Device) em.createQuery("select d from Device d where d.ip = " + ip).getSingleResult();
    	}catch(NoResultException e){
    		//log ("No se encontro el rol con id: " + roleId);
    	}
    	return d;
	}

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
	public List<Device> getDeviceList() {
		return em.createQuery("select d from Device d order by d.id_device").getResultList();
	}

    @Transactional(readOnly = false)
    @SuppressWarnings("unchecked")
	public void saveDevice(Device d) throws Exception {
    	if (this.getDevice(d.getId_device()) == null){
    		int id_device = (Integer) em.createQuery("select max(id_device) + 1 from Device").getSingleResult();
    		d.setId_device(id_device);
    		em.merge(d);
    	}else{
    		throw new Exception("El Device con ese id ya existe");
    	}
	}
    

    @Transactional(readOnly = false)
    @SuppressWarnings("unchecked")
	public void updateDevice(Device d) {
		em.merge(d);
	}

    @Transactional(readOnly = false)
    @SuppressWarnings("unchecked")
	public void deleteDevice(Device d) {
		em.remove(d);
	}

    @Transactional(readOnly = false)
    @SuppressWarnings("unchecked")
	public void deleteDevice(int id_device) {
		em.createQuery("delete from Device d where d.id_device=" + id_device).executeUpdate();
	}
    
    @Transactional(readOnly = false)
    @SuppressWarnings("unchecked")
	public void deleteDevice(String ip) {
		em.createQuery("delete from Device d where d.ip=" + ip).executeUpdate();
	}
    

}
