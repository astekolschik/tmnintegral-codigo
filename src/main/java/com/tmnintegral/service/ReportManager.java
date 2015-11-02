/**
 * 
 */
package com.tmnintegral.service;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tmnintegral.domain.EquipmentInformation;
import com.tmnintegral.repository.ReportDao;

/**
 * Encargado del manejo y armado de reportes
 * @author Agustina
 * @version 1.0
 */
@Component
public class ReportManager implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ReportDao reportDao;
	@Autowired
	private InventoryManager inventoryManager;

	/**
	 * Obtiene información para el reporte de memoria disponible para una lista de equipos
	 * @param eqIds
	 * @param from
	 * @param to
	 * @return
	 */
	public String getInformationForMemoriaDisponibleReport(String[] eqIds, Date from, Date to){
		String res = "[";
		for (int i = 0; i < eqIds.length; i++){
			if (i != 0)
				res = res + ",";
			res = res + this.getInformationForMemoriaDisponibleReport(Integer.valueOf(eqIds[i]), from, to);
		}
		res += "]";
		return res;
	}
	
	/**
	 * Obtiene información para el reporte de memoria disponible x equipo
	 * @param eqID
	 * @param from
	 * @param to
	 * @return
	 */
	public String getInformationForMemoriaDisponibleReport(int eqID, Date from, Date to){
		String result = "{ Equipment : '" + eqID + "', "
						+" Data: [";
		
//		Device d = inventoryManager.getDevice(eqID);
		
		List<EquipmentInformation> eqInfo = this.getEquipmentInformationForReport(eqID, from, to);
		Iterator<EquipmentInformation> itEq = eqInfo.iterator();
		EquipmentInformation eq = null;
		while (itEq.hasNext()){
			eq = itEq.next();
			result = result +
						"{ Date: '" + eq.getTimestamp() + "',"
						+ " Value: " + eq.getMemoria_disponible()
						+ "}";
			if (itEq.hasNext())
				result = result + ",";
		}
		
		result += 	"]"
				+ "}";
		return result;
	}
	
	private List<EquipmentInformation> getEquipmentInformationForReport(int eqID, Date from, Date to){
		return this.reportDao.getEquipmentInformation(eqID, from, to);
	}
	
	
	/**
	 * @param reportDao the reportDao to set
	 */
	public void setReportDao(ReportDao reportDao) {
		this.reportDao = reportDao;
	}
	

}
