<!doctype html> 
<%@page import="co.edu.udea.iw.shared.UsuarioGWT"%>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">

    <link type="text/css" rel="stylesheet" href="estilos/estilo.css">

    <title>Bienvenidos a LPF</title>

  </head>

  <body id="cuerpo" background="estilos/hierba.jpg" style="height: 822px; ">
  <p align="center">
		<img src="estilos/logotipo.png" ></p>

  
  <div id="tituloPpal"> <h1>¡Bienvenido a la Polla Futbolera!</h1> 
 
  
  
  </div>
  <% 
  		if(session.getAttribute("UsuarioConectado") != null){
  			UsuarioGWT user = (UsuarioGWT)session.getAttribute("UsuarioConectado");
  	%>
  	
  	<script type="text/javascript">
  		var userInSession = {
  			"email" : "<%=user.getEmail()%>",
  			"nombre" : "<%=user.getNombre()%>",
  			"tipo" : "<%=user.getTipo()%>"
  		}
  	  	
  	  	</script>

<script type="text/javascript" language="javascript" src="gwtpollafutbolera/gwtpollafutbolera.nocache.js"></script>
    <iframe src="javascript:''" id="__gwt_historyFrame" tabIndex='-1' style="position:absolute;width:0;height:0;border:0"></iframe>
    
    <noscript>
      <div style="width: 22em; position: absolute; left: 50%; margin-left: -11em; color: red; background-color: white; border: 1px solid red; padding: 4px; font-family: sans-serif">
        Your web browser must have JavaScript enabled
        in order for this application to display correctly.
      </div>
    </noscript>

	<table border="0" cellspacing="0" cellpadding="0" align="center">
     	<tr>
     		<td align="right">
    			<%=user.getNombre()%>(<a href ="logout">Salir</a>)
    		</td>
    	</tr>
    	<tr>
			<td align="center">
    			<div id="contenido"></div>
    		</td>
		</tr>
	</table>

	<%}else{ %>

	<table border="0" cellspacing="0" cellpadding="0" align="center">

		<tr>
			<td>
				<form action="login" method="post">
					<table border="0">

						<tr>
							 <h1>INICIO DE SESION</h1>
							
							<td><span class="label">Nombre de usuario:</span></td>
							<td><input type="text" name="usuario" value=""></td>
						</tr>
						<tr>
							<td><span class="label">Contraseña:</span></td>
							<td><input type="password" name="pws" value=""></td>
						</tr>
					</table>
					<tr>
							<td align="center"><button type="submit" class="boton" value="Login"
								style="width: 169px;">
								<img src="estilos/ingresar.png" alt="" /> INGRESAR
							</button>
	</td>
						</tr>
					<tr align="center">
						<%
							if( session.getAttribute("DatosInvalidos") != null ){
						%>

							<td><%= (String)session.getAttribute("DatosInvalidos") %></td>


						<%
							}
						%>


					</tr>
				</form>
		</tr>
<tr>

<form action="registrar" method="post">
	<table border="0" cellspacing="0" cellpadding="0" align="center">
	<tr><td><br><br><br></td></tr>
	<tr align="center">
	<td>¿No tienes una cuenta?. Registrate, es gratis!</td>
	</tr>

	<tr><td  align="center">
	
	
	<button type="submit" class="boton" value="Registrar">
								<img src="estilos/registrar.gif" alt="" /> REGISTRARSE
							</button>
	
	</td></tr>
	</table>
    </form>
</tr>
	</table>

	<%
		}
	%>
	
  </body>
</html>