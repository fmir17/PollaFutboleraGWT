/**
 * 
 */
package co.edu.udea.iw.client.server;

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

}
