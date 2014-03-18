package co.edu.udea.iw.client;

import java.util.List;

import co.edu.udea.iw.client.server.PartidoService;
import co.edu.udea.iw.shared.PartidoGWT;
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

public class ListaPartidosMes extends Composite{

	private static ListaPartidosMesUiBinder uiBinder = GWT.create(ListaPartidosMesUiBinder.class);

	interface ListaPartidosMesUiBinder extends UiBinder<Widget, ListaPartidosMes> {
	}
	
	@UiField
	Label labelMensaje;
	
	@UiField
	FlexTable tabla;
	
	@UiField
	Button agregar;
	
	co.edu.udea.iw.client.Oferta oferta = null;

	public ListaPartidosMes(co.edu.udea.iw.client.Oferta oferta) {
		initWidget(uiBinder.createAndBindUi(this));
		
		tabla.setText(0, 0, "EquipoLocal");
		tabla.setText(0, 1, "EquipoVisitante");
		tabla.setText(0, 2, "Mes");

		
		tabla.getCellFormatter().setWidth(0, 0, "100px");
		tabla.getCellFormatter().setWidth(0, 1, "200px");
		tabla.getCellFormatter().setWidth(0, 2, "200px");

		
//		tabla.getRowFormatter().addStyleName(0, "tablaHeader");
		
		PartidoService.Util.getInstance().obtenerPartidos(new AsyncCallback<List<PartidoGWT>>() {
			
			@Override
			public void onSuccess(List<PartidoGWT> result) {
				
				if(result.size() == 0)
					mostrarMensaje("No hay partidos en la base de datos");
				
				for(PartidoGWT partido : result){
					agregarPartido(partido);
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				mostrarMensaje(caught.getMessage());
			}
		});
		
		if(!UsuarioGWT.getInstancia().getTipo().equals("Admo")){
			agregar.setVisible(false);
		}else{
			agregar.setVisible(true);
		}
		
		this.oferta = oferta;
		
		tabla.addStyleName("tabla");
		labelMensaje.addStyleName("label");
	}
	
	private void mostrarMensaje(String mensaje){
		labelMensaje.setVisible(true);
		labelMensaje.setText(mensaje);
	}
	
	public void agregarPartido(final PartidoGWT partido){
		
		final int indice = tabla.getRowCount();
		
		tabla.setText(indice, 0, partido.getEquipoLocal());
		tabla.setText(indice, 1, partido.getEquipoVisitante());
		tabla.setText(indice, 2, Integer.toString(partido.getPaMes()));
	}
	
	@UiHandler("agregar")
	void onClick(ClickEvent ce){
		
		oferta.setVisible(true);
		
		this.setVisible(false);
	}

}