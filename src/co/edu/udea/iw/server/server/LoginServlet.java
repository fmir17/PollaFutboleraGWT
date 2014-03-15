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

import co.edu.udea.iw.bl.impl.UsuarioBLImpl;
import co.edu.udea.iw.dto.UsUsuario;
import co.edu.udea.iw.shared.UsuarioGWT;

public class LoginServlet extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		procesarLogin(request, response);
		
		String referer = request.getHeader("referer");
		
		response.sendRedirect(referer);
	}
	
	
	protected void procesarLogin(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		String userName = request.getParameter("usuario");
		
		
		String password = request.getParameter("pws");
		
		HttpSession sesion = request.getSession();
		
		try{
			System.out.println("Usuario: " + userName);
			if(getUsuarioService().verificarUsuario(userName, password)!=null){

				UsUsuario usuario =getUsuarioService().verificarUsuario(userName, password);
				UsuarioGWT usuarioGWT = new UsuarioGWT();
				
				usuarioGWT.setNombre(userName);
				usuarioGWT.setTipo(usuario.getUsTipo());
				usuarioGWT.setEmail(usuario.getUsEmail());
				
				sesion.setAttribute("UsuarioConectado", usuarioGWT);
				
			}else{
				sesion.setAttribute("UsuarioConectado", null);
				sesion.setAttribute("DatosInvalidos", "Usuario o contrase\u00F1a no v\u00E3lido");
				System.out.println("Usuario o contrase\u00F1a no v\u00E3lido");
			}
		}catch(Exception e){
			sesion.setAttribute("UsuarioConectado", null);
			sesion.setAttribute("DatosInvalidos", "Ocurri\u00f3 un error validando los datos del usuario");
			e.printStackTrace();
		}
		
	}
	
	
	public UsuarioBLImpl getUsuarioService(){
		
		ServletContext sc = getServletContext();
		ApplicationContext context =  WebApplicationContextUtils.getWebApplicationContext(sc);
		return (UsuarioBLImpl)context.getBean("usuarioBLImpl");
	}
	
	

}
