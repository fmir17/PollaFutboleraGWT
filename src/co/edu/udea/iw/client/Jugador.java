package co.edu.udea.iw.client;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import co.edu.udea.iw.bl.impl.UsuarioBLImpl;
import co.edu.udea.iw.client.server.UsuarioService;
import co.edu.udea.iw.dto.UsUsuario;

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
          boolean puedo;
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
				}else if ("".equals(txtEmail.getText())) {
					Window.alert("Debe digitar el Email");
					return;
				}else if (validarCorreo(txtEmail.getText())==false) {
					Window.alert("El Email digitado no esta digitado correctamente");
					return;
				}else if ("".equals(passwordTextbox.getText())) {
					Window.alert("Debe digitar la contraseña");
					return;
				}else if (passwordTextbox.getText().length() < 8 ) {
					Window.alert("Debe digitar una contraseña con mas de 8 caracteres");
					return;
				} else {

				// LLamado al metodo de forma asincrona

				UsuarioService.Util.getInstance().crearNuevoUsuario(
						txtNombre.getText(), passwordTextbox.getText(),
						txtEmail.getText(), null, new AsyncCallback<Void>() {

							@Override
							public void onSuccess(Void result) {
								Window.alert("Se ha registrado Satisfactoriamente!");
								txtNombre.setText("");
								txtEmail.setText("");
								passwordTextbox.setText("");
							}

							@Override
							public void onFailure(Throwable caught) {
								System.out.println(caught.getMessage());
								Window.alert("El regsitro no ha podido llevarse a cabo,puede que este" +
										" Nombre de usuario ya este en uso, intentalo con otro nombre de usuario por favor");
								txtNombre.setText("");
							}
						});

			}}
		});
		
		
		
		lblNombre.addStyleName("label");
		lblEmail.addStyleName("label");
		lblPassword.addStyleName("label");
		txtEmail.addStyleName("campotexto");

	}

	public void setLista(ListaClientes lista) {
		this.lista = lista;
	}
	public boolean validarCorreo(String correo)
	{		
		Boolean b = correo.matches(
		 "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		return b;
    }
	public boolean evaluarUsuario(String nombre ) {	
		
		UsuarioService.Util.getInstance().buscarUsuario(
				nombre, new AsyncCallback<Void>() {
					@Override
					public void onSuccess(Void result) {
						
			
						puedo=false;
						System.out.println("E N C O N T R A D O ");
						
					}

					@Override
					public void onFailure(Throwable caught) {
						System.out.println(caught.getMessage());
						
						puedo= true;
					}
				});
		return puedo;
	}

	
	private void mostrarListado() {

		lista.setVisible(true);
		this.setVisible(false);
	}
}