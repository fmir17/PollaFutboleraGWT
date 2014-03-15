package co.edu.udea.iw.client;



import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class ListaClientes extends Composite{

	private static ListaClientesUiBinder uiBinder = GWT.create(ListaClientesUiBinder.class);

	interface ListaClientesUiBinder extends UiBinder<Widget, ListaClientes> {
	}
	
	@UiField
	Label labelMensaje;
	
	@UiField
	FlexTable tabla;
	
	@UiField
	Button agregar;
	
	co.edu.udea.iw.client.Jugador jugador = null;

	public ListaClientes(co.edu.udea.iw.client.Jugador jugador) {
		initWidget(uiBinder.createAndBindUi(this));
		
		tabla.setText(0, 0, "C\u00E9dula");
		tabla.setText(0, 1, "Nombre");
		tabla.setText(0, 2, "Correo electr\u00F3nico");
		tabla.setText(0, 3, "Acciones");
		
		tabla.getRowFormatter().addStyleName(0, "tablaHeader");
		
		this.jugador= jugador;
		
	}
	
	private void mostrarMensaje(String mensaje){
		labelMensaje.setVisible(true);
		labelMensaje.setText(mensaje);
	}
	

	@UiHandler("agregar")
	void onClick(ClickEvent ce){

		Window.alert("clic!");
		jugador.setVisible(true);
		
		this.setVisible(false);

	}

}
