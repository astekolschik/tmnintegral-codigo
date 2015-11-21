/**
 * 
 */
package com.tmnintegral.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Repository;

import com.tmnintegral.repository.TopologiaDao;

/**
 * @author Agustina
 *
 */
@Repository(value = "topologiaDao")
public class JdbcTopologiaDAO implements TopologiaDao{

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/tmnintegral";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "";

	public JSONObject getTopologia(){
		Connection conn = null;
		Statement stmt = null;

		JSONObject resJson = new JSONObject();
		JSONArray elmtIds = new JSONArray();
		JSONArray linkIds = new JSONArray();

		try{

			conn = this.getConnection();
			stmt = conn.createStatement();

			String sql = "select distinct"
					+ " E.id as 'eq-origen-id',E.elementName EQUIPO_ORIGEN,"
					+ " EI.id as 'in-origen-id', EI.elementName INTERFAZ_ORIGEN ,"
					+ " EI2.id as 'in-destino-id',EI2.elementName INTERFAZ_DESTINO,"
					+ " ED2.id as 'eq-destino-id',ED2.elementName EQUIPO_DESTINO"
					+ " from Element E                                                                     /* EQUIPO */"
					+ " join elementrelationship ER1 on (E.id=ER1.AEnd)                    /* EQUIPO-INTERFAZ ORIGEN */"
					+ " join Element EI ON EI.id=ER1.ZEnd                                       /* INTERFAZ ORIGEN */"
					+ " join elementrelationship ER2 on (ER1.ZEnd=ER2.AEnd )          /* INTERFAZ ORIGEN - INTERFAZ DESTINO*/"
					+ " join Element EI2 ON EI2.id=ER2.ZEnd                                    /* INTERFAZ DESTINO */"
					+ " join elementrelationship ER3 ON ER2.ZEnd = ER3.AEnd          /* EQUIPO - INTERFAZ DESTINO*/"
					+ " JOIN Element ED2 on ED2.id = ER3.ZEnd                              /* EQUIPO DESTINO*/"
					+ " where E.elementClass='Device' and"
					+ " ER1.relationClass='Device-Interf' and"
					+ " ER2.relationClass='Interf-Interf'  and"
					+ " ER3.relationClass='Device-Interf'";

			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){
				//Elementos (equipos e interfaces)
				JSONObject eqOrigen = new JSONObject();
				eqOrigen.put("id", rs.getInt("eq-origen-id"));
				eqOrigen.put("label", rs.getString("EQUIPO_ORIGEN"));
				eqOrigen.put("type", "equipment");
				if (!elmtIds.contains(eqOrigen)) elmtIds.add(eqOrigen);
				
				JSONObject eqDestino = new JSONObject();
				eqDestino.put("id", rs.getInt("eq-destino-id"));
				eqDestino.put("label", rs.getString("EQUIPO_DESTINO"));
				eqDestino.put("type", "equipment");
				if (!elmtIds.contains(eqDestino)) elmtIds.add(eqDestino);
				
				JSONObject iOrigen = new JSONObject();
				iOrigen.put("id", rs.getInt("in-origen-id"));
				iOrigen.put("label", rs.getString("INTERFAZ_ORIGEN"));
				iOrigen.put("type", "interface");
				if (!elmtIds.contains(iOrigen)) elmtIds.add(iOrigen);
				
				JSONObject iDestino = new JSONObject();
				iDestino.put("id", rs.getInt("in-destino-id"));
				iDestino.put("label", rs.getString("INTERFAZ_DESTINO"));
				iDestino.put("type", "interface");
				if (!elmtIds.contains(iDestino)) elmtIds.add(iDestino);
				
				//Links entre elementos
				JSONObject linkorigen = new JSONObject();
				linkorigen.put("from", rs.getInt("eq-origen-id"));
				linkorigen.put("to", rs.getInt("in-origen-id"));
				linkorigen.put("type", "internal");
				linkIds.add(linkorigen);
				
				JSONObject linkorigendestino = new JSONObject();
				linkorigendestino.put("from", rs.getInt("in-origen-id"));
				linkorigendestino.put("to", rs.getInt("in-destino-id"));
				linkorigendestino.put("type", "external");
				linkIds.add(linkorigendestino);
				
				JSONObject linkdestino = new JSONObject();
				linkdestino.put("from", rs.getInt("in-destino-id"));
				linkdestino.put("to", rs.getInt("in-destino-id"));
				linkdestino.put("type", "internal");
				linkIds.add(linkdestino);
			}

			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
		
		resJson.put("elements", elmtIds);
		resJson.put("links", linkIds);
		
		return resJson;
	}

	private Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
}
