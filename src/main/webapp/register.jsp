<%-- 
    Document   : Formulario de Registro de Usuario
    Created on : 1 sept. 2021, 12:02:10
    Author     : ptorr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Cuenta</title>
        <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWeirel="stylesheet">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div class="regbox box">
                <img class="sirpla" src="img/LogoUxEq2008.png">
                <h1>Registrar Cuenta</h1>
                <form action="RegisterServlet" method="post">
                    <p>Nombre de Usuario</p>
                    <input type="text" placeholder="Usuario" name="name" required>
                    <p>Email</p>
                    <input type="email" placeholder="Email" name="email" required>
                    <p>Contraseña</p>
                    <input type="password" placeholder="Contraseña" name="password" required>
                    <input type="submit" value="Registrar">
                    <a href="index.jsp"> Ya tengo una cuenta</a>
                </form>
                
            </div>
        </div>
    </body>
</html>
