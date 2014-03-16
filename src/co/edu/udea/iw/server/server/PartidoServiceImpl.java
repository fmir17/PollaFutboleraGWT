package co.edu.udea.iw.server.server;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import co.edu.udea.iw.bl.EquipoBL;
import co.edu.udea.iw.bl.PartidoBL;
import co.edu.udea.iw.client.server.PartidoService;
import co.edu.udea.iw.util.exception.IWBLException;
import co.edu.udea.iw.util.exception.IWDaoException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class PartidoServiceImpl extends RemoteServiceServlet implements
		PartidoService {

	@Override
	public void registrarNuevoPartido(int idEquipoLoc, int idEquipoVis,
			String fechaPartido, String horaPartido, int idTorneo) {
		// TODO Auto-generated method stub
		ServletContext sc = getServletContext();
		ApplicationContext webApp = WebApplicationContextUtils
				.getWebApplicationContext(sc);

		HttpServletRequest req = this.getThreadLocalRequest();
		HttpSession ses = req.getSession();
		try {
			
			

			PartidoBL partidoBL = (PartidoBL) webApp.getBean("partidoBLImpl");
			//format a las fechas
			Date fechaPartidodate = null;
			Date horaPartidodate = null;
			DateFormat df2 = new SimpleDateFormat("HH:mm:ss");
			try {
				fechaPartidodate = new SimpleDateFormat("yyyy-MM-dd")
						.parse(fechaPartido);
				horaPartidodate = df2.parse(horaPartido);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			partidoBL.registrarNuevoPartido(idEquipoLoc, idEquipoVis,
					fechaPartidodate, horaPartidodate, idTorneo);

		} catch (IWDaoException e) {
			e.getStackTrace();

		} catch (IWBLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
