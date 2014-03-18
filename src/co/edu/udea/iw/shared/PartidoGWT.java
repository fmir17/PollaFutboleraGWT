package co.edu.udea.iw.shared;

import java.util.Calendar;
import java.util.Date;

import co.edu.udea.iw.dto.PaPartidoId;
import co.edu.udea.iw.dto.ToTorneo;

import com.google.gwt.i18n.client.Dictionary;

public class PartidoGWT implements java.io.Serializable{

	private static PartidoGWT instancia;
	/**
	 * Campo que contiene la clave de partido
	 */
	private String equipoLocal;
	
	private String equipoVisitante;

	/**
	 * Campo para determinar la hora del partido
	 */
	private Date paHora;

	/**
	 * Campo para extraer el mes de la fecha.
	 */
	private int paMes;

	/**
	 * Campo que indica el numero de goles del visitante
	 */
	private int paNroGolVis;
	/**
	 * Campo que indica el numero de goles del local
	 */
	private int paNroGolLoc;

	public String getEquipoLocal() {
		return equipoLocal;
	}
	
	public String getEquipoVisitante() {
		return equipoVisitante;
	}

	public void setEquipoLocal(String equipoLocal) {
		this.equipoLocal = equipoLocal;
	}
	
	public void setEquipoVisitante(String equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}
		
	public void setPaMes(String mes) {
		this.paMes = Integer.parseInt(mes);
	}

	public int getPaMes() {
		return paMes;
	}

	public Date getPaHora() {
		return paHora;
	}

	public void setPaHora(Date paHora) {
		this.paHora = paHora;
	}

	public int getPaNroGolVis() {
		return paNroGolVis;
	}

	public void setPaNroGolVis(int paNroGolVis) {
		this.paNroGolVis = paNroGolVis;
	}

	public int getPaNroGolLoc() {
		return paNroGolLoc;
	}

	public void setPaNroGolLoc(int paNroGolLoc) {
		this.paNroGolLoc = paNroGolLoc;
	}

	public static PartidoGWT getInstancia() {
		if (instancia == null)
			instancia = new PartidoGWT();

		return instancia;
	}

	public static void setUpFromDictionary(Dictionary dic) {
		instancia = new PartidoGWT();
		instancia.setPaMes(dic.get("mes"));
		instancia.setEquipoLocal(dic.get("equipoLocal"));

	}
}
