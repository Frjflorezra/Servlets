
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <h1>Formulario de registro:</h1>
        <form action="/Listareas/Registro" method="POST">
            
            <label>Cedula:</label>
            <input type = "number" name = "cedula_persona"/>
            <br>
            <label>Nombres: </label>
            <input type="text" name="nombres_persona"/>
            <br>
            <label>Apellidos: </label>
            <input type="text" name="apellidos_persona"/>
            <br>
            <label>Telefono: </label>
            <input type="number" name="telefono_persona"/>
            <br>
            <label>E-mail: </label>
            <input type="email" name="email_persona"/>
            <br>
            <input type="submit" value="REGISTRAR"/>
        </form>
        
        </body>
</html>
