/**
 * 
 */
package co.edu.udea.iw.client.server;

import java.util.Date;
import java.util.List;

import co.edu.udea.iw.shared.PartidoGWT;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author fredymiranda
 * @generated generated asynchronous callback interface to be used on the client side
 *
 */
public interface PartidoServiceAsync {

	/**
	 * @param  callback the callback that will be called to receive the return value
	 * @generated generated method with asynchronous callback parameter to be used on the client side
	 */
	void registrarNuevoPartido(int idEquipoLoc, int idEquipoVis,
			String fechaPartido, String horaPartido, int idTorneo,
			AsyncCallback<Void> callback);

	void obtenerPartidos(AsyncCallback<List<PartidoGWT>> callback);
	void obtenerPartido(int idEquipoLocal, int idEquipoVisitante,
			Date fechaPartido, AsyncCallback<List<PartidoGWT>> callback);
	
}
