package co.edu.udea.iw.client;

import java.util.List;

import co.edu.udea.iw.client.server.TorneoService;
import co.edu.udea.iw.client.server.UsuarioService;
import co.edu.udea.iw.shared.TorneoGWT;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DatePicker;

public class Oferta  extends Composite{

	public Oferta(){
		
		
		VerticalPanel verticalPanel = new VerticalPanel();
		
		// Paneles horizontales para campos
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		HorizontalPanel horizontalPanel_3 = new HorizontalPanel();
		// Torneo
		Label lblNombre = new Label("Seleccione un Torneo");
		final ListBox lbxListaTorneo = new ListBox();
		horizontalPanel.add(lblNombre);
		horizontalPanel.add(lbxListaTorneo);
		
		//Equipos
		Label lblEqLocal = new Label("Seleccione Local");
		final ListBox lbxListaEquipoLoc= new ListBox();
		horizontalPanel_1.add(lblEqLocal);
		horizontalPanel_1.add(lbxListaEquipoLoc);
		
		Label lblEqVis = new Label("Seleccione Visitante");
		final ListBox lbxListaEquipoVis = new ListBox();
		horizontalPanel_2.add(lblEqVis);
		horizontalPanel_2.add(lbxListaEquipoVis);
		
		
		//Fecha
		Label lblFecha = new Label("Específique Fecha");
		DateBox dbFecha = new DateBox();
		horizontalPanel_3.add(lblFecha);
		horizontalPanel_3.add(dbFecha);
		
		verticalPanel.add(horizontalPanel);
		verticalPanel.add(horizontalPanel_1);
		verticalPanel.add(horizontalPanel_2);
		verticalPanel.add(horizontalPanel_3);
		
		TorneoService.Util.getInstance().obtenerTorneos(new AsyncCallback<List<TorneoGWT>>() {

					@Override
					public void onSuccess(List<TorneoGWT> result) {
						
						
						 for(TorneoGWT torneogwt:result)
						    {
						     lbxListaTorneo.addItem(" -"+torneogwt.getToId()+"- "+ torneogwt.getToNombre() );
							 
							}
						Window.alert("Se ha registrado Satisfactoriamente!");
					}

					@Override
					public void onFailure(Throwable caught) {
						System.out.println(caught.getMessage());

					}
				});
		
	}
	
}
