/**
 * 
 */
package com.tmnintegral.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tmnintegral.domain.Device;
import com.tmnintegral.service.InventoryManager;

@Controller
public class DeviceController {
	
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private InventoryManager im;
	

    @RequestMapping(value="/listDevice.htm")
    public ModelAndView listDevice(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("deviceList", im.getDeviceList());
		
		return new ModelAndView("inventory/listDevice", "model", myModel);
    }
    
    
	@RequestMapping(value="/eliminarEquipo.htm")
	public ModelAndView borrarDevice(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("dId"));
		this.im.eliminarDevice(id);
		return this.listDevice(request, response);
	}
	
	@RequestMapping(value="/displayDevice.htm")
    public ModelAndView mostrarEquipo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		Map<String, Object> myModel = new HashMap<String, Object>();
		Device d = im.getDevice(
				Integer.parseInt((String)request.getParameter("dId")));
		myModel.put("deviceObj", d);
		if (((String)request.getParameter("edit")).equals("true")){
			myModel.put("edit", true);
			myModel.put("displayEdit", "");
		}else{
			myModel.put("edit", false);
			myModel.put("displayEdit", "none");
		}
		
		return new ModelAndView("inventory/displayDevice", "model", myModel);
    }
	
	@RequestMapping(value="/nuevoEquipo.htm")
	public ModelAndView nuevoEquipo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		Map<String, Object> myModel = new HashMap<String, Object>();
		Device d = new Device();
		myModel.put("deviceObj", d);
		myModel.put("edit", true);
		myModel.put("displayEdit", "");
		return new ModelAndView("inventory/displayDevice", "model", myModel);
	}
	
	@RequestMapping(value="/updateEquipo.htm")
	public ModelAndView actualizarEquipo(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		
		String idDevice = request.getParameter("idDevice");
		String communityRead = request.getParameter("communityRead");
		String hostName = request.getParameter("hostName");
		String iosType = request.getParameter("iosType");
		String iosVersion = request.getParameter("iosVersion");
		String ip = request.getParameter("ip");
		String model = request.getParameter("model");
		String serialNumber = request.getParameter("serialNumber");
		String softwareRelease = request.getParameter("softwareRelease");
		Integer id_device_type = Integer.parseInt(request.getParameter("id_device_type"));
		Integer id_network = Integer.parseInt(request.getParameter("id_network"));
		Integer id_configuration = Integer.parseInt(request.getParameter("id_configuration"));
		Integer id_equipment_info = Integer.parseInt(request.getParameter("id_equipment_info"));
		String enable = request.getParameter("enable");
		
		if (idDevice != null)
			this.im.modificarDevice(Integer.parseInt(idDevice), communityRead, hostName, iosType, iosVersion, ip, model, serialNumber, 
					softwareRelease,id_device_type, id_network, id_configuration, id_equipment_info, enable);
		else
			this.im.crearDevice(communityRead, hostName, iosType, iosVersion, ip, model, serialNumber, softwareRelease,
					id_device_type, id_network, id_configuration, id_equipment_info, enable);
		
		return this.listDevice(request, response);
	}
}



