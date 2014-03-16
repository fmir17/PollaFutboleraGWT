package co.edu.udea.iw.client.server;

import java.util.List;


import co.edu.udea.iw.util.exception.IWDaoException;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import co.edu.udea.iw.shared.TorneoGWT;

@RemoteServiceRelativePath("TorneoService")
public interface TorneoService extends RemoteService{

	public static class Util {
		private static TorneoServiceAsync instance;
		public static TorneoServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(TorneoService.class);
			}
			return instance;
		}
	}
	
	public List<TorneoGWT> obtenerTorneos();
}
