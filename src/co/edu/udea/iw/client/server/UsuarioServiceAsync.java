package co.edu.udea.iw.client.server;

import com.google.gwt.user.client.rpc.AsyncCallback;

import co.edu.udea.iw.dto.UsUsuario;
import co.edu.udea.iw.shared.MyGWTException;
import co.edu.udea.iw.util.exception.IWBLException;
import co.edu.udea.iw.util.exception.IWDaoException;

public interface UsuarioServiceAsync {

	void crearNuevoUsuario(String nombre, String password, String correo,
			String tipo, AsyncCallback<Void> callback);

	void buscarUsuario(String nombre, AsyncCallback<Void> callback);

}
