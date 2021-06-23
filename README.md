# AK-Hera2-NYTimesData
Repositorio para la abstracción del repository external

- ¿Para que esta destinado?
 
  Esta desarrollado para obtener articulos de NYTimes. 
  Más especifico:
    - Descripción, en concreto el abstract del articulo que brinda NYTimes 
    - URL del articulo en concreto
    - Logo de NYTimes
    
- ¿Como conseguir el articulo?
  - 1 -> Agregar como submodulo al proyecto.
  - 2 -> Luego haciendo referencia a getArticleInfo(artistName) de la interfaz NYTimesArticleService, donde artistName es el nombre del artista deseado.
  - 3 -> Se retornara un NYTArticle, el cual es una implementación de Article, que debera ser parseado a la entidad Card.
  
- Casos extremos
  - En el caso de no tener conexión a internet se devolvera "null"
  - En el caso de que no exista articulo se devolvera "null" también

