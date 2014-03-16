package co.edu.udea.iw.client.server;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;


import co.edu.udea.iw.shared.EquipoGWT;
public interface EquipoServiceAsync {

	
	void obtenerEquipos(AsyncCallback<List<EquipoGWT>> callback) ;
}
