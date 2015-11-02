/**
 * 
 */
package com.tmnintegral.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.tmnintegral.service.ReportManager;
import com.tmnintegral.service.UserManager;

/**
 * @author Usuario
 *
 */
@Controller
public class ReportController {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private LogManager logManager;
	@Autowired
	private ReportManager reportManager;

	@RequestMapping(value="/parametrosReporte.htm")
    public ModelAndView parametrosReporte(HttpSession session, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		return new ModelAndView("reportes/parametrosReporte");
    }
	
	@RequestMapping(value="/generarReporte.htm")
    public ModelAndView generarReporte(HttpSession session, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		String tipoReporte = request.getParameter("tipo-reporte");
		String eqsId = "1";//request.getParameter("nombre-equipo");
		
		String dateFromStr = request.getParameter("fecha-desde");
		String dateToStr = request.getParameter("fecha-hasta");
		
		DateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateFrom = null, dateTo = null;
		try {
			dateFrom = sourceFormat.parse(dateFromStr);
			dateTo = sourceFormat.parse(dateToStr);
		} catch (ParseException e) {
			System.err.println("Error al parsear las fechas");
		}
		
		
		String resp = this.reportManager.getInformationForMemoriaDisponibleReport(eqsId.split(","), dateFrom, dateTo);
		Map<String, Object> myModel = new HashMap<>();
		myModel.put("reportData", resp);
		return new ModelAndView("reportes/reporte", "model", myModel);
    }
	
	/**
	 * @param logManager the logManager to set
	 */
	public void setLogManager(LogManager logManager) {
		this.logManager = logManager;
	}

	/**
	 * @param reportManager the reportManager to set
	 */
	public void setReportManager(ReportManager reportManager) {
		this.reportManager = reportManager;
	}
	
}
