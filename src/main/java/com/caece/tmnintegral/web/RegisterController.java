/**
 * 
 */
package com.caece.tmnintegral.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.caece.tmnintegral.dao.RoleDao;
import com.caece.tmnintegral.dao.UserDao;
import com.caece.tmnintegral.service.UserManager;

/**
 * @author Usuario
 *
 */
@Controller
public class RegisterController {

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value="/register.htm")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		if (request.getParameter("usuario") == null)
			return new ModelAndView("register");
		else{
			
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	        
			String user = request.getParameter("usuario");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			
			UserManager um = new UserManager();
			um.setRoleDao((RoleDao) context.getBean("roleDao"));
	        um.setUserDao((UserDao) context.getBean("userDao"));
			
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
