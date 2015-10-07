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
public class InterfaceController {
	
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private InventoryManager im;
	

    @RequestMapping(value="/listInterface.htm")
    public ModelAndView listInterface(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("interfaceList", im.getInterfaceList());
		
		return new ModelAndView("inventory/listInterface", "model", myModel);
    }
    
    
	@RequestMapping(value="/altaInterface.htm")
    public ModelAndView altaInterface(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
			
		 	String adminStatus = request.getParameter("adminStatus");
		 	String alias = request.getParameter("alias");
		 	String name = request.getParameter("name");
		 	int shelf = Integer.parseInt(request.getParameter("shelf"));
		 	int slot = Integer.parseInt(request.getParameter("slot"));
		 	int port = Integer.parseInt(request.getParameter("port"));
		    int subPort = Integer.parseInt(request.getParameter("subPort"));
		    String type = request.getParameter("type");
		    String ip_device = request.getParameter("device");
		    
		    Device d = im.getDevice(ip_device);
		    
	        try {
				im.altaInterface(adminStatus, alias, name, shelf, slot, port, subPort, type, d);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return new ModelAndView("inventory/altaInterface");
			}
	        return new ModelAndView("inventory/listInterface");
		}
		
	@RequestMapping(value="/modificarInterface.htm")
	public ModelAndView modificarInterface(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		
	 	String adminStatus = request.getParameter("adminStatus");
	 	String alias = request.getParameter("alias");
	 	String name = request.getParameter("name");
	 	int shelf = Integer.parseInt(request.getParameter("shelf"));
	 	int slot = Integer.parseInt(request.getParameter("slot"));
	 	int port = Integer.parseInt(request.getParameter("port"));
	    int subPort = Integer.parseInt(request.getParameter("subPort"));
	    String type = request.getParameter("type");
	    String ip_device = request.getParameter("device");
	    
	    Device d = im.getDevice(ip_device);
	    
		if (name != null)
			this.im.modificarInterface(adminStatus, alias, name, shelf, slot, port, subPort, type, d);
		else{
			System.out.println("Interface inexistente");
			return  new ModelAndView("inventory/modificarInterface");
			}
		
		return this.listInterface(request, response);
	}
	
	
	@RequestMapping(value="/eliminarInterface.htm")
	public ModelAndView eliminarInterface(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		
		String name = request.getParameter("name");
		
		this.im.eliminarInterface(name);
		
		return this.listInterface(request, response);
	}
}



