package com.tmnintegral.service;

import java.io.Serializable;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tmnintegral.domain.Red;
import com.tmnintegral.repository.RedDao;

/**
 * @author Martín
 *
 */
@Component
public class NetworkManager implements Serializable{

	private static final long serialVersionUID = 1L;

	@Autowired
	private RedDao redDao;

	/**
	 * Devuelve la lista de los tipos de equipo
	 * @return
	 */
	public List<Red> getRedList(){
		return this.redDao.getRedList();
	}
	
	public Red altaRed(String net, Boolean enable, String description) throws Exception{
	
	if (!existeNet(net)){
	
		Red r = new Red(net, enable, description);

		redDao.saveRed(r);
		
		return r;
	}else{
		throw new Exception("Network existente");
		}
	}
	
	private boolean existeNet(String net){
		if(redDao.getRed(net) != null)
			return true;
		return false;
	}
	
	public void eliminarRed(int id_red){this.redDao.deleteRed(id_red);}
	
	public void eliminarRed(String net){this.redDao.deleteRed(net);}
	
	public void eliminarRed(Red r){this.redDao.deleteRed(r);}
	
	public Red getRed(String net){
		Red r = this.redDao.getRed(net);
		return r;
	}
	
	public Red getRed(int id_red){
		Red r = this.redDao.getRed(id_red);
		return r;
	}
	
	public Red modificarRed(String net, Boolean enable, String description){
		Red r = this.getRed(net);
		if (r != null){
			if (!r.getNet().equals(net))
				r.setNet(net);
			if (!r.getEnable().equals(enable))
				r.setEnable(enable);
			if (r.getDescription()==(description))
				r.setDescription(description);
			
			this.redDao.updateRed(r);
		}
		
		return r;
	}

}
