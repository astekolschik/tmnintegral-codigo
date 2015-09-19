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
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tmnintegral.domain.User;
import com.tmnintegral.service.UserManager;

/**
 * @author Usuario
 *
 */
@Controller
public class UserController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private UserManager um;
	
	@RequestMapping(value="/register.htm")
    public ModelAndView registerUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		if (request.getParameter("usuario") == null)
			return new ModelAndView("user/register");
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
				return new ModelAndView("user/register");
			}
		}
		return new ModelAndView("index");

    }
	
	@RequestMapping(value="/updateUser.htm")
    public ModelAndView updateUser(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws ServletException, IOException {

		Map<String, Object> myModel = new HashMap<String, Object>();
		
		if (request.getParameter("saveUser") == null){
			User userobj = this.um.getUser((String)(session.getAttribute("user")));
			myModel.put("userObj", userobj);
		}else{
			String username = ((String)(session.getAttribute("user")));
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			User userobj = this.um.modificarUsuario(nombre, apellido, email, username, password);
			myModel.put("userObj", userobj);
			myModel.put("message", "Los datos se actualizaron con éxito");
		}
		return new ModelAndView("user/updateUser", "model", myModel);
    }

	
}
