
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingrese</title>
        <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div class="box">
                <img class="sirpla" src="img/LogoUxEq2008.png">
                <h1>Cuenta de Acceso</h1>
                <form action="LoginServlet" method="post">
                    <p>Usuario</p>
                    <input type="email" placeholder="Email acceso" name="email" required>
                    <p>Contraseña</p>
                    <input type="password" placeholder="Contraseña" name="contraseña" required><!-- comment -->
                    
                    <input type="submit" value="Ingresar">
                    <a href="#">¿Olvido su Contraseña?</a><br>
                    <a href="register.jsp">Crear nueva cuenta</a>
                    
                </form>
            </div>
        </div>
        
    </body>
</html>
