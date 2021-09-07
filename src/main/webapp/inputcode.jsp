<%-- 
    Document   : inputcode
    Created on : 4 sept. 2021, 11:16:27
    Author     : ptorr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingresar Codigo</title>
        <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWeirel="stylesheet">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        
        <style>
            input::webkit-inner-spin-button,
            input::webkit-outer-spin-button{
                -webkit-appearance: none
            }
        </style>
        <script src="js/inputcode.js" type="text/javascript"></script>
    
    </head>
    <body>
        <div class="container">
            <div class="verificationbox">
                <h1>Ingresar Código</h1>
                <form action="VerificationServlet" method="post">
                    
                    <br>
                    <div class="inputcode">
                        <input type="text" id="digito1" minlength="1" maxlength="1" onkeyup="pasarFoco(event.keyCode, 1)" required autofocus>
                        <input type="text" id="digito2" minlength="1" maxlength="1" onkeyup="pasarFoco(event.keyCode, 2)"required>
                        <input type="text" id="digito3" minlength="1" maxlength="1" onkeyup="pasarFoco(event.keyCode, 3)"required>
                        <input type="text" id="digito4" minlength="1" maxlength="1" onkeyup="pasarFoco(event.keyCode, 4)"required>
                        <input type="text" id="digito5" minlength="1" maxlength="1" onkeyup="pasarFoco(event.keyCode, 5)"required>
                    </div>
                    <br>
                    <p id="auxiliartext">El código fue enviado a su mail. Por favor revise su carpeta de spam. Si no recibió ningun codigo, puede volver a solicitar el envio de un codigo nuevo</p>
                    <br>
                    <input type="submit" value="Validar Cuenta">
                </form>
                <a href="${pageContext.request.contextPath}/RegisterServlet?accion=enviarcodigo">Reenviar Código</a> 
            </div>
        </div>
    </body>
</html>
