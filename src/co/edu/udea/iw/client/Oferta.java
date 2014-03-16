package co.edu.udea.iw.client;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import co.edu.udea.iw.client.server.EquipoService;
import co.edu.udea.iw.client.server.PartidoService;
import co.edu.udea.iw.client.server.TorneoService;
import co.edu.udea.iw.client.server.UsuarioService;
import co.edu.udea.iw.shared.EquipoGWT;
import co.edu.udea.iw.shared.TorneoGWT;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;

public class Oferta extends Composite {

	public Oferta() {

		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);

		// Paneles horizontales para campos
		HorizontalPanel horizontalPanelTorneo = new HorizontalPanel();
		HorizontalPanel horizontalPanelEquipoL = new HorizontalPanel();
		HorizontalPanel horizontalPanelEquipoV = new HorizontalPanel();
		HorizontalPanel horizontalPanelFecha = new HorizontalPanel();
		HorizontalPanel horizontalPanelHora = new HorizontalPanel();
		HorizontalPanel horizontalPanelbtn = new HorizontalPanel();

		HorizontalPanel horizontalPanelespacio = new HorizontalPanel();
		// Torneo
		Label lblNombre = new Label("Seleccione un Torneo");
		final ListBox lbxListaTorneo = new ListBox();
		horizontalPanelTorneo.add(lblNombre);
		horizontalPanelTorneo.add(lbxListaTorneo);

		// Equipos
		Label lblEqLocal = new Label("Seleccione Local");
		final ListBox lbxListaEquipoLoc = new ListBox();
		horizontalPanelEquipoL.add(lblEqLocal);
		horizontalPanelEquipoL.add(lbxListaEquipoLoc);

		Label lblEqVis = new Label("Seleccione Visitante");
		final ListBox lbxListaEquipoVis = new ListBox();
		horizontalPanelEquipoV.add(lblEqVis);
		horizontalPanelEquipoV.add(lbxListaEquipoVis);

		// Fecha
		Label lblFecha = new Label("Específique Fecha");
		final DateBox dbFecha = new DateBox();
		final DateTimeFormat format = DateTimeFormat.getFormat("yyyy-MM-dd");
		dbFecha.setFormat(new DefaultFormat(format));

		horizontalPanelFecha.add(lblFecha);
		horizontalPanelFecha.add(dbFecha);

		// Hora
		Label lblHora = new Label("Específique Hora");
		final ListBox lbxHora = new ListBox();
		final ListBox lbxMinuto = new ListBox();

		// llenamos horas
		for (int x = 1; x < 60; x++) {
			if (x < 10) {
				lbxHora.addItem("0" + x);
				lbxMinuto.addItem("0" + x);

			}
			if (x > 9 & x < 24) {
				lbxHora.addItem(x + "");
				lbxMinuto.addItem(x + "");
			}
			if (x > 23) {
				lbxMinuto.addItem(x + "");
			}

		}
		;
		horizontalPanelHora.add(lblHora);
		horizontalPanelHora.add(lbxHora);
		horizontalPanelHora.add(lbxMinuto);

		// Guardar
		Button btnGuardar = new Button();
		Button btnCancelar = new Button();
		btnGuardar.setText("Guardar");
		btnCancelar.setText("Cancelar");
		horizontalPanelbtn.add(btnGuardar);
		horizontalPanelbtn.add(btnCancelar);

		verticalPanel.add(horizontalPanelTorneo);
		verticalPanel.add(horizontalPanelEquipoL);
		verticalPanel.add(horizontalPanelEquipoV);
		verticalPanel.add(horizontalPanelFecha);
		verticalPanel.add(horizontalPanelHora);
		verticalPanel.add(horizontalPanelespacio);
		verticalPanel.add(horizontalPanelespacio);

		verticalPanel.add(horizontalPanelbtn);

		TorneoService.Util.getInstance().obtenerTorneos(
				new AsyncCallback<List<TorneoGWT>>() {

					@Override
					public void onSuccess(List<TorneoGWT> result) {

						for (TorneoGWT torneogwt : result) {
							lbxListaTorneo.addItem(torneogwt.getToId() + ". "
									+ torneogwt.getToNombre());

						}

					}

					@Override
					public void onFailure(Throwable caught) {
						System.out.println(caught.getMessage());

					}
				});

		EquipoService.Util.getInstance().obtenerEquipos(
				new AsyncCallback<List<EquipoGWT>>() {

					@Override
					public void onSuccess(List<EquipoGWT> result) {

						for (EquipoGWT equipogwt : result) {
							lbxListaEquipoLoc.addItem(equipogwt.getEqId() + "."
									+ equipogwt.getEqNombre());
							lbxListaEquipoVis.addItem(equipogwt.getEqId() + "."
									+ equipogwt.getEqNombre());
						}

					}

					@Override
					public void onFailure(Throwable caught) {
						System.out.println(caught.getMessage());

					}
				});

		/**
		 * Evento clic al botón guardar
		 */
		btnGuardar.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				/**
				 * Validaciones de los campos ingresados
				 */
				if (dbFecha.getValue() == null || "".equals(dbFecha.getValue())) {
					Window.alert("Debe Seleccionar una Fecha!");
					return;
				}

				int idT = lbxListaTorneo.getItemText(
						lbxListaTorneo.getSelectedIndex()).indexOf(".");
				int idEqL = lbxListaEquipoLoc.getItemText(
						lbxListaEquipoLoc.getSelectedIndex()).indexOf(".");
				int idEqV = lbxListaEquipoVis.getItemText(
						lbxListaEquipoVis.getSelectedIndex()).indexOf(".");

				int idtorneo = Integer.parseInt(lbxListaTorneo.getItemText(
						lbxListaTorneo.getSelectedIndex()).substring(0, idT));
				int idEqLoc = Integer.parseInt(lbxListaTorneo.getItemText(
						lbxListaTorneo.getSelectedIndex()).substring(0, idEqL));
				int idEqVis = Integer.parseInt(lbxListaTorneo.getItemText(
						lbxListaTorneo.getSelectedIndex()).substring(0, idEqV));

				// BORRAR
				Window.alert("Vamos a guadar: " + "torneo :" + idtorneo
						+ "local: " + idEqLoc + "vis: " + idEqLoc + "fecha :"
						+ dbFecha.getTextBox().getText() + "hora :"
						+ lbxHora.getItemText(lbxHora.getSelectedIndex())
						+ "minuto :"
						+ lbxMinuto.getItemText(lbxMinuto.getSelectedIndex()));

				String horaPartidoString = lbxHora.getItemText(lbxHora
						.getSelectedIndex())+ ":"
						+ lbxMinuto.getItemText(lbxMinuto.getSelectedIndex())
						+ ":00";
						
				// LLamado al metodo de forma asincrona
				PartidoService.Util.getInstance().registrarNuevoPartido(
						idEqLoc, idEqVis, dbFecha.getTextBox().getText(), horaPartidoString, idtorneo,
						new AsyncCallback<Void>() {

							@Override
							public void onSuccess(Void result) {
								Window.alert("Se ha registrado la oferta satisfactoriamente!!");
							}

							@Override
							public void onFailure(Throwable caught) {
								System.out.println(caught.getMessage());

							}
						});

			}
		});

	}
}
