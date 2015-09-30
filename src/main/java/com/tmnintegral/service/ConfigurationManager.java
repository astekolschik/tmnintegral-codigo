/**
 * 
 */
package com.tmnintegral.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tmnintegral.domain.Command;
import com.tmnintegral.repository.CommandDao;

/**
 * @author Agustina
 *
 */
@Component
public class ConfigurationManager implements Serializable{

	private static final long serialVersionUID = 1L;

	@Autowired
	private CommandDao commandDao;

	/**
	 * @param commandDao the commandDao to set
	 */
	public void setCommandDao(CommandDao commandDao) {
		this.commandDao = commandDao;
	}
	
	/**
	 * Devuelve la lista de comandos
	 * @return
	 */
	public List<Command> getCommandList(){
		return this.commandDao.getCommandList();
	}
	
	/**
	 * Devuelve el comando seleccionado en el id
	 * @param commandid
	 * @return
	 */
	public Command getCommandById(int command){
		return this.commandDao.getCommand(command);
	}

	/**
	 * Modifica el objeto command
	 * @param commadId
	 * @param command
	 * @param commandType
	 */
	public void modificarComando(int commadId, String command, String commandType){
		Command c = this.getCommandById(commadId);
		if(c != null){
			if (!c.getCommand().equals(command))
				c.setCommand(command);
			if (!c.getCommand_type().equals(commandType))
				c.setCommand_type(commandType);
			
			this.commandDao.updateCommand(c);
		}
	}

	public void crearComando(String comando, String tipoComando) {
		Command c = new Command(null, comando, tipoComando);
		try {
			this.commandDao.saveCommand(c);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void borrarComando(Integer cId) {
		this.commandDao.deleteCommand(cId);
	}
}