/**
 * 
 */
package com.tmnintegral.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
		JSONObject topologia = this.im.obtenerTopologiaDeRed();
		myModel.put("networkGraph", topologia.toJSONString().replaceAll("\"", "'"));
		
		
		return new ModelAndView("inventory/displayNetwork", "model", myModel);
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
	
	@RequestMapping(value="/callDiscoveryPgm.htm")
	public ModelAndView discoveryProgram(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		
		
		System.out.println("Llamada al programa que ejecuta el discovery de red.");
		//ejemplo para llamar a un pograma
		/*Process process = new ProcessBuilder(
				"C:\\PathToExe\\MyExe.exe","param1","param2").start();*/

		Process process = Runtime.getRuntime().exec("cmd /c dir"); 

		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String line;
		while ((line = br.readLine()) != null) {
		  System.out.println(line);
		}

		
		return this.listRed(request, response);
	}
}