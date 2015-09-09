package com.caece.tmnintegral.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.caece.tmnintegral.dao.RoleDao;
import com.caece.tmnintegral.dao.UserDao;
import com.caece.tmnintegral.repository.Role;
import com.caece.tmnintegral.repository.User;

/**
 * Encargado del manejo de usuarios
 * @author Agustina
 * @version 1.0
 */
@Component
public class UserManager {
	
	@Autowired
	private RoleDao roleDao;
	@Autowired
    private UserDao userDao;
	
	public UserManager(){
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param userId
	 * @param password
	 * @throws Exception 
	 */
	public boolean autenticarUsuario(String username, String password) throws Exception{
		User u = userDao.getUser(username);
		if (u != null){
			String loginPwd = this.generarPassword(username, password);
			if (loginPwd.equals(u.getPassword()))
				return true;
			else
				return false;
		}else{
			throw new Exception("Usuario inexistente");
		}
	}

	/**
	 * Crea un usuario a partir de los datos proporcionados
	 * @param userName
	 * @param nombre
	 * @param apellido
	 * @param email
	 * @param password
	 * @param roleId
	 * @throws Exception 
	 */
	public User crearUsuario(
				String userName,
				String nombre, String apellido, 
				String email, 
				String password, 
				int roleId) throws Exception{
		
		if (!existeUsuario(userName)){
		
			String encPwd = this.generarPassword(userName, password);
			Role r = roleDao.getRole(roleId);
			User u = new User(userName, encPwd, email, nombre, apellido, r);

			userDao.saveUser(u);
			
			return u;
		}else{
			throw new Exception("Usuario duplicado");
		}
	}

	/**
	 * 
	 * @param userId
	 */
	public void eliminarUsuario(String userId){

	}

	public User getUser(String userId){
		return new User();
		//return m_User;
	}

	/**
	 * 
	 * @param nombre
	 * @param apellido
	 * @param email
	 * @param fNac
	 * @param password
	 */
	public void modificarUsuario(String nombre, String apellido, String email, Date fNac, String password){

	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUser(User newVal){

	}

	/**
	 * 
	 * @param userId
	 */
	public boolean usuarioDuplicado(String userId){
		return true;
	}

	/**
	 * Chequea la existencia de un username repetido
	 * @param username
	 * @return userduplicado
	 */
	private boolean existeUsuario(String username){
		if(userDao.getUser(username) != null)
			return true;
		return false;
	}
	
	private String generarPassword(String username, String password){
		return getStringMessageDigest(username + password);
	}
	
	private String getStringMessageDigest(String message){
	     byte[] digest = null;
	     byte[] buffer = message.getBytes();
	     try {
	         MessageDigest messageDigest = MessageDigest.getInstance("MD5");
	         messageDigest.reset();
	         messageDigest.update(buffer);
	         digest = messageDigest.digest();
	     } catch (NoSuchAlgorithmException ex) {
	         System.out.println("Error creando Digest");
	     }
	     return toHexadecimal(digest);
	 }
	
	private static String toHexadecimal(byte[] digest){
        String hash = "";
        for(byte aux : digest) {
            int b = aux & 0xff;
            if (Integer.toHexString(b).length() == 1) hash += "0";
            hash += Integer.toHexString(b);
        }
        return hash;
    }

	/**
	 * @param roleDao the roleDao to set
	 */
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	/**
	 * @param userDao the userDao to set
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}