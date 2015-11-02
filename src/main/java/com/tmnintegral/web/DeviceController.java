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


import com.tmnintegral.domain.Interface;
import com.tmnintegral.domain.Red;
import com.tmnintegral.domain.TipoEquipo;
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
    
    
	@RequestMapping(value="/altaDevice.htm")
    public ModelAndView altaDevice(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
			Boolean enable2= false;
			
		 	String communityRead = request.getParameter("communityRead");
		 	String hostName = request.getParameter("hostName");
		 	String iosType = request.getParameter("iosType");
		 	String iosVersion = request.getParameter("iosVersion");
		 	String ip = request.getParameter("ip");
		 	String model = request.getParameter("model");
		 	String serialNumber = request.getParameter("serialNumber");
		    String softwareRelease = request.getParameter("softwareRelease");
		    int id_tipoEquipo = Integer.parseInt(request.getParameter("id_tipoEquipo")); //necesito que venga un nombre del tipo y despues lo busco con el IM
		    String name = request.getParameter("name");
		    String net = request.getParameter("net");
		    String enable = request.getParameter("enable");
		    
		    if (enable=="On"){ enable2 = true;}//Lo tengo que cambiar a algo más prolijo//
		    
		    
		    TipoEquipo t = im.getTipoEquipo(id_tipoEquipo); //necesito que le pongan un nombre a tipo equipo
		    Interface i = im.getInterface(name);
		    Red r = im.getRed(net);
		    
		    
		    
	        try {
				im.altaDevice(communityRead, hostName, iosType, iosVersion, ip, model, serialNumber, softwareRelease, t, i, r, enable2);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return new ModelAndView("inventory/altaDevice");
			}
	        return new ModelAndView("inventory/listDevice");
		}
		
	@RequestMapping(value="/updateDeviceID.htm")
	public ModelAndView actualizarDevice(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		
		Boolean enable2= false;
		
		String id_device = request.getParameter("id_device");
		String communityRead = request.getParameter("communityRead");
	 	String hostName = request.getParameter("hostName");
	 	String iosType = request.getParameter("iosType");
	 	String iosVersion = request.getParameter("iosVersion");
	 	String ip = request.getParameter("ip");
	 	String model = request.getParameter("model");
	 	String serialNumber = request.getParameter("serialNumber");
	    String softwareRelease = request.getParameter("softwareRelease");
	    int id_tipoEquipo = Integer.parseInt(request.getParameter("id_tipoEquipo")); //necesito que venga un nombre del tipo y despues lo busco con el IM
	    String name = request.getParameter("name");
	    String net = request.getParameter("net");
	    String enable = request.getParameter("enable");
	    
	    if (enable=="On"){ enable2 = true;}//Lo tengo que cambiar a algo más prolijo//
	    
	    
	    TipoEquipo t = im.getTipoEquipo(id_tipoEquipo); //necesito que le pongan un nombre a tipo equipo
	    Interface i = im.getInterface(name);
	    Red r = im.getRed(net);
		
		if (id_device != null)
			this.im.modificarDevice(Integer.valueOf(id_device),communityRead, hostName, iosType, iosVersion, ip, model, serialNumber, softwareRelease, t, i, r, enable2);
		else{
			System.out.println("ID invexistente");
			return  new ModelAndView("inventory/updateDevice");
			}
		
		return this.listDevice(request, response);
	}
	
	@RequestMapping(value="/updateDevice.htm")
	public ModelAndView actualizarDeviceIP(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		
		Boolean enable2= false;
		
		String communityRead = request.getParameter("communityRead");
	 	String hostName = request.getParameter("hostName");
	 	String iosType = request.getParameter("iosType");
	 	String iosVersion = request.getParameter("iosVersion");
	 	String ip = request.getParameter("ip");
	 	String model = request.getParameter("model");
	 	String serialNumber = request.getParameter("serialNumber");
	    String softwareRelease = request.getParameter("softwareRelease");
	    int id_tipoEquipo = Integer.parseInt(request.getParameter("id_tipoEquipo")); //necesito que venga un nombre del tipo y despues lo busco con el IM
	    String name = request.getParameter("name");
	    String net = request.getParameter("net");
	    String enable = request.getParameter("enable");
	    
	    if (enable=="On"){ enable2 = true;}//Lo tengo que cambiar a algo más prolijo//
	    
	    
	    TipoEquipo t = im.getTipoEquipo(id_tipoEquipo); //necesito que le pongan un nombre a tipo equipo
	    Interface i = im.getInterface(name);
	    Red r = im.getRed(net);
	    
		
		if (ip != null)
			this.im.modificarDevice(communityRead, hostName, iosType, iosVersion, ip, model, serialNumber, softwareRelease, t, i, r, enable2);
		else{
			System.out.println("IP inexistente");
			return  new ModelAndView("inventory/updateDevice");
			}
		
		return this.listDevice(request, response);
	}
	
	@RequestMapping(value="/deleteDevice.htm")
	public ModelAndView borrarDevice(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		
		String ip = request.getParameter("ip");
		
		this.im.eliminarDevice(ip);
		
		return this.listDevice(request, response);
	}
}



