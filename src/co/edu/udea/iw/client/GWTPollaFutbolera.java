package co.edu.udea.iw.client;



import co.edu.udea.iw.shared.UsuarioGWT;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.i18n.client.Dictionary;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWTPollaFutbolera implements EntryPoint {
	
		
	public void onModuleLoad() {
		
		Dictionary var = Dictionary.getDictionary("userInSession");
		UsuarioGWT.setUpFromDictionary(var);
		
		
		
	}
	
}