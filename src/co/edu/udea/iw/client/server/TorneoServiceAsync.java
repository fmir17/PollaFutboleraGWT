package co.edu.udea.iw.client.server;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import co.edu.udea.iw.shared.TorneoGWT;


public interface TorneoServiceAsync {

	void obtenerTorneos(AsyncCallback<List<TorneoGWT>> callback);
}
