package co.edu.udea.iw.server.server;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import co.edu.udea.iw.bl.TorneoBL;
import co.edu.udea.iw.client.server.TorneoService;
import co.edu.udea.iw.shared.TorneoGWT;
import co.edu.udea.iw.util.exception.IWDaoException;

public class TorneoServiceImpl extends RemoteServiceServlet implements
		TorneoService {

	
	@Override
	public List<TorneoGWT> obtenerTorneos()  {

		ServletContext sc = getServletContext();
		ApplicationContext webApp = WebApplicationContextUtils
				.getWebApplicationContext(sc);

		HttpServletRequest req = this.getThreadLocalRequest();
		HttpSession ses = req.getSession();
		List<TorneoGWT> torneos = new ArrayList<TorneoGWT>();
		
		try {
			TorneoBL torneoBL= (TorneoBL)webApp.getBean("TorneoBL");
		    
			
		    for(co.edu.udea.iw.dto.ToTorneo torneodto:torneoBL.obtener())
		    {
		    	TorneoGWT torneogwt = new TorneoGWT();
		    	torneogwt.setToNombre(torneodto.getToNombre());
		    	torneogwt.setToId(torneodto.getToId());
		    	
		    	torneos.add(torneogwt);
			}
		    
		    
		    return torneos;
			
		} catch (IWDaoException e) {
			e.getStackTrace();
			return null;
		}
	
	}

}
