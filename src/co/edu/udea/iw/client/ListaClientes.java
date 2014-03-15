package co.edu.udea.iw.client;

import java.util.List;



import co.edu.udea.iw.shared.UsuarioGWT;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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
	


	public ListaClientes() {
		initWidget(uiBinder.createAndBindUi(this));
		
		tabla.setText(0, 0, "C\u00E9dula");
		tabla.setText(0, 1, "Nombre");
		tabla.setText(0, 2, "Correo electr\u00F3nico");
		tabla.setText(0, 3, "Acciones");
		
		tabla.getCellFormatter().setWidth(0, 0, "100px");
		tabla.getCellFormatter().setWidth(0, 1, "200px");
		tabla.getCellFormatter().setWidth(0, 2, "200px");
		tabla.getCellFormatter().setWidth(0, 3, "50px");
		
		tabla.getRowFormatter().addStyleName(0, "tablaHeader");
		
	}
	
	private void mostrarMensaje(String mensaje){
		labelMensaje.setVisible(true);
		labelMensaje.setText(mensaje);
	}
	

	
	@UiHandler("agregar")
	void onClick(ClickEvent ce){
		

	}

}
