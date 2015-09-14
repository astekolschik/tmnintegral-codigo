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
public class LoginController {

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value="/login.htm")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		if (request.getParameter("usuario") == null)
			return new ModelAndView("login");
		else{
			
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	        
			String user = request.getParameter("usuario");
			String password = request.getParameter("password");
			UserManager um = new UserManager();
			um.setRoleDao((RoleDao) context.getBean("roleDao"));
	        um.setUserDao((UserDao) context.getBean("userDao"));
			
	        try {
				um.autenticarUsuario(user, password);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return new ModelAndView("login");
			}
		}
		return new ModelAndView("index");

    }
	
}
