package co.edu.udea.iw.server.server;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


import co.edu.udea.iw.bl.UsuarioBL;
import co.edu.udea.iw.client.server.UsuarioService;
import co.edu.udea.iw.dto.UsUsuario;
import co.edu.udea.iw.util.exception.IWBLException;
import co.edu.udea.iw.util.exception.IWDaoException;
import co.edu.udea.iw.shared.MyGWTException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class UsuarioServiceImpl extends RemoteServiceServlet implements UsuarioService {

	@Override
	public void crearNuevoUsuario(String nombre, String password,
			String correo, String tipo) throws MyGWTException {
		// TODO Auto-generated method stub
		ServletContext sc = getServletContext();
		ApplicationContext webApp = WebApplicationContextUtils.getWebApplicationContext(sc);
		
		HttpServletRequest req = this.getThreadLocalRequest();
		HttpSession ses = req.getSession();
		
		try{
			UsuarioBL usuarioBL = (UsuarioBL)webApp.getBean("usuarioBLImpl");
			usuarioBL.crearNuevoUsuario(nombre, password, correo, "Jug");
		}catch (IWBLException e) {
			throw new MyGWTException(e.getMessage());
		}catch (IWDaoException e) {
			e.getStackTrace();
		}
	}

	@Override
	public void buscarUsuario(String nombre) throws MyGWTException {
		// TODO Auto-generated method stub
		
	}
	
}
