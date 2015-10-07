/**
 * 
 */
package com.tmnintegral.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tmnintegral.service.InventoryManager;
import com.tmnintegral.service.NetworkManager;

/**
 * @author Agustina/Martin
 *
 */
@Controller
public class NetworkController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private InventoryManager im;
	@Autowired
	private NetworkManager nm;
	
	@RequestMapping(value="/displayNetwork.htm")
    public ModelAndView listarRedes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("networkList", new HashSet<>());
		
		return new ModelAndView("inventory/displayNetwork", "model", myModel);
    }
	
	@RequestMapping(value="displayNetworkGraph.htm")
	@ResponseBody
	public String obtenerTopologiaDeRed(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		return this.im.obtenerTopologiaDeRed(Integer.parseInt(request.getParameter("netId")));
	}
	
	@RequestMapping(value="/listRed.htm")
    public ModelAndView listRed(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("redList", nm.getRedList());
		
		return new ModelAndView("inventory/listRed", "model", myModel);
    }
    
    
	@RequestMapping(value="/altaRed.htm")
    public ModelAndView altaRed(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
			Boolean enable2= false;
			
		 	String net = request.getParameter("net");
		 	String description = request.getParameter("description");
		 	String enable = request.getParameter("enable");
		 	
		    
		    if (enable=="On"){ enable2 = true;}//Lo tengo que cambiar a algo más prolijo//
		      
		    
	        try {
				nm.altaRed(net, enable2, description);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return new ModelAndView("inventory/altaRed");
			}
	        return new ModelAndView("inventory/listRed");
		}
	
	@RequestMapping(value="/updateRed.htm")
	public ModelAndView actualizarRed(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		
		Boolean enable2= false;
		
		String net = request.getParameter("net");
	 	String description = request.getParameter("description");
	 	String enable = request.getParameter("enable");
	 	
	    
	    if (enable=="On"){ enable2 = true;}//Lo tengo que cambiar a algo más prolijo//
	      
		
		if (net != null)
			this.nm.modificarRed(net, enable2, description);
		else{
			System.out.println("Red inexistente");
			return  new ModelAndView("inventory/updateRed");
			}
		
		return this.listRed(request, response);
	}
	
	@RequestMapping(value="/deleteRed.htm")
	public ModelAndView borrarRed(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		
		String net = request.getParameter("Network");
		
		this.nm.eliminarRed(net);;
		
		return this.listRed(request, response);
	}
}