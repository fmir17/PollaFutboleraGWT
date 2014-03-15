package co.edu.udea.iw.client;

import co.edu.udea.iw.client.server.UsuarioService;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;

public class Jugador extends Composite {
	ListaClientes lista;

	public Jugador() {

		VerticalPanel verticalPanel = new VerticalPanel();

		initWidget(verticalPanel);

		// Paneles horizontales para campos
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		HorizontalPanel horizontalPanel_4 = new HorizontalPanel();

		// Usuario
		Label lblNombre = new Label("Nombre de Usuario:");
		final TextBox txtNombre = new TextBox();
		txtNombre.setMaxLength(50);

		horizontalPanel.add(lblNombre);
		horizontalPanel.add(txtNombre);

		// Usuario
		Label lblEmail = new Label("Email*:");
		final TextBox txtEmail = new TextBox();
		txtEmail.setMaxLength(100);

		horizontalPanel_1.add(lblEmail);
		horizontalPanel_1.add(txtEmail);

		// Password
		Label lblPassword = new Label("Password*:");
		final PasswordTextBox passwordTextbox = new PasswordTextBox();
		passwordTextbox.setMaxLength(32);

		horizontalPanel_2.add(lblPassword);
		horizontalPanel_2.add(passwordTextbox);

		// Botones
		Button btnRegistrar = new Button("Registrar");
		horizontalPanel_4.add(btnRegistrar);
		Button btnCancelar = new Button("Cancelar");
		horizontalPanel_4.add(btnCancelar);

		// Se agregan paneles horizontales al panel vertical
		verticalPanel.add(horizontalPanel);
		verticalPanel.add(horizontalPanel_1);
		verticalPanel.add(horizontalPanel_2);
		verticalPanel.add(horizontalPanel_4);

		/**
		 * Evento clic al botón cancelar
		 */
		btnCancelar.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				// Reseteamos valores
				txtNombre.setText("");
				txtEmail.setText("");
				passwordTextbox.setText("");
				// mostrarListado();
			}
		});

		/**
		 * Evento clic al botón registrar
		 */
		btnRegistrar.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				/**
				 * Validaciones de los campos ingresados
				 */
				if ("".equals(txtNombre.getText())) {
					Window.alert("Debe digitar el Nombre de usuario!");
					return;
				}

				if ("".equals(txtEmail.getText())) {
					Window.alert("Debe digitar el Email");
					return;
				}

				if ("".equals(passwordTextbox.getText())) {
					Window.alert("Debe digitar la contraseña");
					return;
				}

				// LLamado al metodo de forma asincrona

				UsuarioService.Util.getInstance().crearNuevoUsuario(
						txtNombre.getText(), passwordTextbox.getText(),
						txtEmail.getText(), null, new AsyncCallback<Void>() {

							@Override
							public void onSuccess(Void result) {
								Window.alert("Se ha registrado Satisfactoriamente!");
							}

							@Override
							public void onFailure(Throwable caught) {
								System.out.println(caught.getMessage());
								
							}
						});

			}
		});

	}

	public void setLista(ListaClientes lista) {
		this.lista = lista;
	}

	private void mostrarListado() {

		lista.setVisible(true);
		this.setVisible(false);
	}
}
