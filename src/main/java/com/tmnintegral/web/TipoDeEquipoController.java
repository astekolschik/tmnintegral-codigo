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

import com.tmnintegral.service.InventoryManager;

/**
 * @author Agustina
 *
 */
@Controller
public class TipoDeEquipoController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private InventoryManager im;
	
	@RequestMapping(value="/listTipoEquipos.htm")
    public ModelAndView listarEquipos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("tipoEquipoList", im.getTipoEquiposList());
		
		return new ModelAndView("inventory/listTipoEquipos", "model", myModel);
    }

}