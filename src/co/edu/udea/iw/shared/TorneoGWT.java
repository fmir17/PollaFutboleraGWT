package co.edu.udea.iw.shared;

import com.google.gwt.i18n.client.Dictionary;

public class TorneoGWT implements java.io.Serializable{

	
	private static TorneoGWT instancia;
	/**
	 * Codigo que identifica el torneo
	 */
	private int toId;
	/**
	 * Nombre asignado al torneo
	 */
	private String toNombre;
	/**
	 * URL de la imagen que contiene el logo del torneo
	 */
	private String toUriimagen;

	public int getToId() {
		return this.toId;
	}

	public void setToId(int toId) {
		this.toId = toId;
	}

	public String getToNombre() {
		return this.toNombre;
	}

	public void setToNombre(String toNombre) {
		this.toNombre = toNombre;
	}

	public String getToUriimagen() {
		return this.toUriimagen;
	}

	public void setToUriimagen(String toUriimagen) {
		this.toUriimagen = toUriimagen;
	}
	public static TorneoGWT getInstancia(){
		if(instancia == null)
			instancia = new TorneoGWT();
		
		return instancia;
	}
	
	public static void setUpFromDictionary(Dictionary dic){
		instancia = new TorneoGWT();
		instancia.setToNombre(dic.get("nombre"));
		
	}
	
}
