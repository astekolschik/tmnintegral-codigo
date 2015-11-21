/**
 * 
 */
package com.tmnintegral.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
 * @author Agustina
 *
 */
@Controller
public class UserController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private UserManager um;
	
	private static int REGISTER_ROLE = 3;
	private static int USER_ROLE = 2;
	private static int ADMIN_ROLE = 1;
	
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
				um.crearUsuario(user, nombre, apellido, email, password, REGISTER_ROLE);
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
			User userobj = (User)(session.getAttribute("user"));
			myModel.put("userObj", userobj);
		}else{
			String username = ((User)(session.getAttribute("user"))).getUser_name();
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
	
	@RequestMapping(value="/deleteUser.htm")
    public ModelAndView deleteUsers(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws ServletException, IOException {

		Map<String, Object> myModel = new HashMap<String, Object>();
		
		if (request.getParameter("deleteUserList") == null){
			List<User> userList = this.um.getUserList();
			myModel.put("userList", userList);
		}else{
			String userList = request.getParameter("deleteUserList");
			String[] usersToDel = userList.split(",");
			for (int i=0; i<usersToDel.length; i++){
				this.um.eliminarUsuario(usersToDel[i]);
			}
			List<User> newUserList = this.um.getUserList();
			myModel.put("userList", newUserList);
		}
		return new ModelAndView("user/deleteUser", "model", myModel);
    }

	@RequestMapping(value="/enableUser.htm")
    public ModelAndView enableUsers(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws ServletException, IOException {

		Map<String, Object> myModel = new HashMap<String, Object>();
		List<User> userList = this.um.getUserList();
		myModel.put("userList", userList);
		
		if (request.getParameter("adminUserList") != null){
			String[] adminUserList = request.getParameter("adminUserList").split(",");
			String[] enableUserList = request.getParameter("userList").split(",");
			String[] reportUserList = request.getParameter("reportList").split(",");
			
			Iterator<User> uIterator = userList.iterator();
			while (uIterator.hasNext()){
				User u = uIterator.next();
				if (isInList(reportUserList, u.getUser_name()))
					u.setRole_id(REGISTER_ROLE);
				if (isInList(enableUserList, u.getUser_name()))
					u.setRole_id(USER_ROLE);
				if (isInList(adminUserList, u.getUser_name()))
					u.setRole_id(ADMIN_ROLE);
				this.um.updateUser(u);
			}
		}
		return new ModelAndView("user/enableUser", "model", myModel);
    }

	private boolean isInList(String[] list, String value){
		for (int i=0; i<list.length; i++){
			if (list[i].equals(value))
				return true;
		}
		return false;
	}
}

