package co.edu.udea.iw.client.server;

import java.util.Date;
import java.util.List;

import co.edu.udea.iw.shared.PartidoGWT;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("PartidoService")
public interface PartidoService extends RemoteService {
	public static class Util {
		private static PartidoServiceAsync instance;

		public static PartidoServiceAsync getInstance() {
			if (instance == null) {
				instance = GWT.create(PartidoService.class);
			}
			return instance;
		}
	}
	
	public void registrarNuevoPartido(int idEquipoLoc, int idEquipoVis,
			String fechaPartido, String horaPartido, int idTorneo);
	
	public List<PartidoGWT> obtenerPartidos();

	public List<PartidoGWT> obtenerPartido(int idEquipoLocal, int idEquipoVisitante,
			Date fechaPartido);
}
