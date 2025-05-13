# Accenture

Buen día, en este READ ME se especificará como desplegar el proyecto de prueba técnica 
de Accenture.

De primera mano se debe contar con Java 21, Git o uan cuenta de Github, postman o cualquier herramienta de consumo de APIs 
y permiso para tener conexión a la base de datos que se encuentra
en AWS.

1. Se debe clonar el repositorio el cuál contiene la carpeta del proyecto.
2. Verificar que se tenga conexión a la bd desde tu entorno local antes intentar iniciar el proyecto.
3. Ejecutar el proyecto y empezar a provar la exposición de los endpoints especificados en la prueba.

Estos serían los siguientes corriendo de ambiente local:
1. POST: http://localhost:8080/franquicias, http://localhost:8080/franquicias/{franquiciaId}/sucursales, http://localhost:8080/franquicias/{franquiciaId}/sucursales/{sucursalId}/producto
2. GET: http://localhost:8080/franquicias/{franquiciaId}/productos-con-mayor-stock
3. DELETE: http://localhost:8080/franquicias/{franquiciaId}/sucursales/{sucursalId}/productos/{productoId}
4. PUT: http://localhost:8080/franquicias/{franquiciaId}, http://localhost:8080/franquicias/{franquiciaId}/sucursales/{sucursalId}, http://localhost:8080/franquicias/{franquiciaId}/sucursales/{sucursalId}productos/{productoId}/nombre,
http://localhost:8080/franquicias/{franquiciaId}/sucursales/{sucursalId}productos/{productoId}/stock.
