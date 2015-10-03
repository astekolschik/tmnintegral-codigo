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

/**
 * @author Agustina
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
	
}