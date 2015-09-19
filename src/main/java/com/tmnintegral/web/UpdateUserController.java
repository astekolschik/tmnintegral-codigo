/**
 * 
 */
package com.tmnintegral.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tmnintegral.service.UserManager;

/**
 * @author Usuario
 *
 */
@Controller
public class UpdateUserController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private UserManager um;
	
	@RequestMapping(value="/updateUser.htm")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		if (request.getParameter("usuario") == null)
			return new ModelAndView("user/updateUser");
		else{
			
			String user = request.getParameter("usuario");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			
	        try {
				um.crearUsuario(user, nombre, apellido, email, password, 1);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return new ModelAndView("register");
			}
		}
		return new ModelAndView("index");

    }
	
}
