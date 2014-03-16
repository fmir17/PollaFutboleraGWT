package co.edu.udea.iw.server.server;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import co.edu.udea.iw.bl.EquipoBL;
import co.edu.udea.iw.client.server.EquipoService;
import co.edu.udea.iw.shared.EquipoGWT;
import co.edu.udea.iw.util.exception.IWDaoException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class EquipoServiceImpl extends RemoteServiceServlet implements
		EquipoService {

	@Override
	public List<EquipoGWT> obtenerEquipos()  {
		ServletContext sc = getServletContext();
		ApplicationContext webApp = WebApplicationContextUtils
				.getWebApplicationContext(sc);

		HttpServletRequest req = this.getThreadLocalRequest();
		HttpSession ses = req.getSession();

		List<EquipoGWT> equiposgwt = new ArrayList<EquipoGWT>();
		try {
		EquipoBL equipobl = (EquipoBL)webApp.getBean("EquipoBL");

		for(co.edu.udea.iw.dto.EqEquipo equipodto:equipobl.obtener())
	    {
			EquipoGWT equipogwt = new EquipoGWT();
			equipogwt.setEqId(equipodto.getEqId());
			equipogwt.setEqNombre(equipodto.getEqNombre());
			
			equiposgwt.add(equipogwt);
			
	    }
		
		return equiposgwt;
		} catch (IWDaoException e) {
			e.getStackTrace();
			return null;
		}
	
	}

}
