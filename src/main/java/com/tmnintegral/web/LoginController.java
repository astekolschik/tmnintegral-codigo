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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.tmnintegral.domain.User;
import com.tmnintegral.service.LogManager;
import com.tmnintegral.service.UserManager;

/**
 * @author Usuario
 *
 */
@Controller
public class LoginController {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private UserManager um;
	@Autowired
	private LogManager logManager;

	@RequestMapping(value="/login.htm")
    public ModelAndView login(HttpSession session, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		Map<String, Object> myModel = new HashMap<String, Object>();
        
		if (request.getParameter("usuario") == null)
			return new ModelAndView("login");
		else{
			
			String user = request.getParameter("usuario");
			String password = request.getParameter("password");
			
	        try {
	        	User u = um.autenticarUsuario(user, password);
				if (u != null){
					session.setAttribute("user", u);
					logManager.saveLoginLog(u.getId());
					myModel.put("logs", logManager.getLastUserLogs(u.getId()));
					return new ModelAndView("index", "model", myModel);
				}else{
					myModel.put("status", "Error en el usuario/contraseña. Intente nuevamente.");
					return new ModelAndView("login", "model", myModel);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				myModel.put("status", "Usuario inexistente. Intente nuevamente.");
				return new ModelAndView("login");
			}
		}

    }
	
	@RequestMapping(value="/olvidePass.htm")
    public ModelAndView resetPassword(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		Map<String, Object> myModel = new HashMap<String, Object>();
        
		if (request.getParameter("username") == null)
			return new ModelAndView("olvidePass");
		else{
			String username = request.getParameter("username");
	        try {
				if (um.resetearContrasena(username)){
					this.logManager.saveResetPassLog(username);
					myModel.put("status", "Su nueva contraseña fue enviada por email.");
					return new ModelAndView("login", "model", myModel);
				}else{
					myModel.put("status", "El usuario es inexistente.");
					return new ModelAndView("olvidePass", "model", myModel);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				myModel.put("status", "El usuario es inexistente.");
				return new ModelAndView("olvidePass", "model", myModel);
			}
		}
    }
	
	@RequestMapping(value="/logout.htm")
    public ModelAndView logout(HttpSession session, SessionStatus status)
            throws ServletException, IOException {
		
		logManager.saveLogoutLog(((User)session.getAttribute("user")).getId());
		
		status.setComplete();
		session.removeAttribute("user");
		return new ModelAndView("login");
    }

	/**
	 * @param um the um to set
	 */
	public void setUm(UserManager um) {
		this.um = um;
	}

	/**
	 * @param logManager the logManager to set
	 */
	public void setLogManager(LogManager logManager) {
		this.logManager = logManager;
	}
	
}
