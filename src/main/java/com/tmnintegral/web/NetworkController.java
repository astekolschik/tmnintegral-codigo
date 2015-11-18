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

import com.tmnintegral.domain.Red;
import com.tmnintegral.service.InventoryManager;

/**
 * @author Agustina/Martin
 *
 */
@Controller
public class NetworkController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private InventoryManager im;
	
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
		myModel.put("redList", this.im.getRedList());
		
		return new ModelAndView("inventory/listRed", "model", myModel);
    }
    
    
	@RequestMapping(value="/eliminarRed.htm")
	public ModelAndView borrarRed(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		
		Integer net = Integer.parseInt(request.getParameter("rId"));
		this.im.eliminarRed(net);
		
		return this.listRed(request, response);
	}
	
	@RequestMapping(value="/displayRed.htm")
    public ModelAndView mostrarRed(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		Map<String, Object> myModel = new HashMap<String, Object>();
		Red red = im.getRedById(
				Integer.parseInt((String)request.getParameter("redId")));
		myModel.put("redObj", red);
		if (((String)request.getParameter("edit")).equals("true")){
			myModel.put("edit", true);
			myModel.put("displayEdit", "");
		}else{
			myModel.put("edit", false);
			myModel.put("displayEdit", "none");
		}
		
		return new ModelAndView("inventory/displayRed", "model", myModel);
    }
	
	@RequestMapping(value="/nuevaRed.htm")
	public ModelAndView nuevaRed(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		Map<String, Object> myModel = new HashMap<String, Object>();
		Red r = new Red();
		myModel.put("redObj", r);
		myModel.put("edit", true);
		myModel.put("displayEdit", "");
		return new ModelAndView("inventory/displayRed", "model", myModel);
	}
	
	@RequestMapping(value="/updateRed.htm")
	public ModelAndView actualizarRed(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		
		String idRed = request.getParameter("idred");
		String network = request.getParameter("network");
		String enabled = request.getParameter("enabled");
		String description = request.getParameter("description");
		
		if (idRed != null)
			this.im.modificarRed(Integer.parseInt(idRed), network, Byte.parseByte(enabled), description);
		else
			this.im.crearRed(network, Byte.parseByte(enabled), description);
		
		return this.listRed(request, response);
	}
}