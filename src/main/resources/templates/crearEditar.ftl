<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${titulo}</title>
</head>
<body>
<h1>${label}</h1>
<form action="/estudiante/procesarEstudiante" method="post">
    Matricula: <input name="matricula" type="number" <#if estudiante??> value="${estudiante.matricula?long?c}" readonly </#if> /> <br/>
    Nombre: <input name="nombre" type="text" <#if estudiante??> value="${estudiante.nombre}" </#if>/> <br/>
    Telefono: <input name="telefono" type="text" <#if estudiante??> value="${estudiante.telefono}" </#if>/> <br/>
    <input type="submit"/>
</form>
</body>
</html>

<#--
?long?c //Long
estudiante.matricula?string.number
-->