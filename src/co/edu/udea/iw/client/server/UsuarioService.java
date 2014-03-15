package co.edu.udea.iw.client.server;

import co.edu.udea.iw.dto.UsUsuario;
import co.edu.udea.iw.shared.MyGWTException;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("UsuarioService")
public interface UsuarioService extends RemoteService{
	/**
	 * Utility class for simplifying access to the instanhce of async service.
	 */
	public static class Util {
		private static UsuarioServiceAsync instance;
		public static UsuarioServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(UsuarioService.class);
			}
			return instance;
		}
	}
	
	public void crearNuevoUsuario(String nombre,String password, String correo, String tipo)throws MyGWTException;
	
	public void buscarUsuario(String nombre) throws MyGWTException;
	
}
