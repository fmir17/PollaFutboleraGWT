package co.edu.udea.iw.client;



import co.edu.udea.iw.shared.UsuarioGWT;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.i18n.client.Dictionary;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWTPollaFutbolera implements EntryPoint {
	
	Jugador jugador=null;
	ListaClientes lista = null;
	Oferta oferta = null;
	public void onModuleLoad() {
		
		Dictionary var = Dictionary.getDictionary("userInSession");
		UsuarioGWT.setUpFromDictionary(var);
		
		jugador = new Jugador();	
		lista = new ListaClientes(jugador);
		oferta=new Oferta();
		
		lista.setVisible(false);
		jugador.setVisible(false);
		
		RootPanel.get("contenido").add(lista);
		RootPanel.get("contenido").add(jugador);
	    RootPanel.get("contenido").add(oferta);
		
	}
	
}