 	package co.edu.udea.iw.shared;

import com.google.gwt.i18n.client.Dictionary;

public class UsuarioGWT {
	
	private String nombre;
	private String email;
	private String tipo;
	
	private static UsuarioGWT instancia;
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public static UsuarioGWT getInstancia(){
		if(instancia == null)
			instancia = new UsuarioGWT();
		
		return instancia;
	}
	
	public static void setUpFromDictionary(Dictionary dic){
		instancia = new UsuarioGWT();
		instancia.setTipo(dic.get("tipo"));
		instancia.setNombre(dic.get("nombre"));
		instancia.setEmail(dic.get("email"));
	}

}
