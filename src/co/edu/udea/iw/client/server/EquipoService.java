package co.edu.udea.iw.client.server;

import java.util.List;

import co.edu.udea.iw.shared.EquipoGWT;
import co.edu.udea.iw.util.exception.IWDaoException;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("EquipoService")
public interface EquipoService  extends RemoteService{
	public static class Util {
		private static EquipoServiceAsync instance;
		public static EquipoServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(EquipoService.class);
			}
			return instance;
		}
	}
	public List<EquipoGWT> obtenerEquipos() ;
}
