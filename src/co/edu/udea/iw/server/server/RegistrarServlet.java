package co.edu.udea.iw.server.server;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gwt.user.client.ui.RootPanel;

import co.edu.udea.iw.bl.impl.UsuarioBLImpl;
import co.edu.udea.iw.client.Jugador;
import co.edu.udea.iw.client.ListaClientes;
import co.edu.udea.iw.dto.UsUsuario;
import co.edu.udea.iw.shared.UsuarioGWT;

public class RegistrarServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession sesion = request.getSession();
		
		UsuarioGWT usuarioGWT = new UsuarioGWT();		
		usuarioGWT.setNombre("sinRegistrar");
		usuarioGWT.setTipo("noRegistrado");
		usuarioGWT.setEmail("c@gmail.com");
		
		
		sesion.setAttribute("UsuarioConectado", usuarioGWT);
		
		String referer = request.getHeader("referer");

		response.sendRedirect(referer);
	}
}