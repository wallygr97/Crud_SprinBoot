<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${titulo}</title>
</head>
<body>
<h1>Lista de Estudiantes</h1>
<table class="table table-striped table-dark">
    <thead>
        <tr>
            <th>Matricula</th>
            <th>Nombre</th>
            <th>Telefono</th>
            <th>Acciones</th>
        </tr>
    </thead>
    <tbody>
<#list lista as es>
    <tr>
        <td>${es.matricula?long?c}</td>
        <td>${es.nombre}</td>
        <td>${es.telefono}</td>
        <td><a href="/estudiante/${es.matricula?long?c}">Editar</a></td>
        <td><a href="/estudiante/eliminar/${es.matricula?long?c}">Borrar</a></td>
    </tr>
</#list>
    </tbody>
</table>
</body>
</html>