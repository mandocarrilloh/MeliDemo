<div id="top"></div>

<div align="center">
<h3 align="center">Prueba Mercado Libre</h3>
</div>


<!-- ABOUT THE PROJECT -->
## Acerca del projecto

[![Product Name Screen Shot][product-screenshot]]()

App disenada como prueba tecnica:

##Objetivo
App diseñada como prueba tecnica, con la finalidad de consumir servicios API de mercadolibre

La APP cuenta con tres pantallas.
* Search: 
Vista para realizar listar los resultados

* Suggestion: (Compose) 
Vista donde se realiza la busqueda y se carga el historial de busqueda

* Detail: 
Vista donde se ve la informacion detalla de un producto.


El aplicativo consta de una base de datos local donde se almanecena las palabra consultados con anteriodad por el usuario.
Se realiz consumo  de 3 servicio de la API Mercadolibre
/sites/MCO/search?q={search}
/items/{itemId}
/items/{itemId}/description

La vista donde se vizualiza el listado de sugeriencias fue realizada en COMPOSE.


### Arquitectura usada
* Clean architecture
* MVVM

### Capas/Modulos
* Data
Capa en la cual esta la implementacion de los repositorios (Product y Search) Dto
* Domain
Capa en la que estan lo casos de uso para encapsular la logica de datos.
* App
Presentacion de datos.


### Librerias usadas
* Room
* Coroutines
* Glide
* Flow
* Junit
* Mockito
* Koin
* Chucker
* Groupie
* Leakcanary
* Compose

<!-- GETTING STARTED -->


<!-- IMAGES -->
[product-screenshot]: assets/images/screenshot_1.jpeg


