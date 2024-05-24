RECURSO: libro

Vamos a exponer un CRUD de libro que está almacenado en una base de datos

GET---->recuperar
POST--->insertar
PUT---->actualizar
DELETE->eliminar

http://localhost:8080/libros              GET: expone todos los libros
http://localhost:8080/libros/{isbn}       GET: recupere el libro con el isbn indicado en la url
http://localhost:8080/libros              POST: dar de alta un libro del que paso los datos en el cuerpo en formato JSON(@RequestBody)
http://localhost:8080/libros              PUT: actualizar un libro del que paso los datos en el cuerpo en formato JSON (@RequestBody)
http://localhost:8080/libros/{isbn}       DELETE: borrar el libro con el isbn indicado en la url   


ORDEN DE CREACION:
1- Crear el proyecto y poner las dependencias necesarias
2- Definir el modelo de datos  (com.curso.model)
3- Crear capa dao (com.curso.dao)
	Crear interface que extends de JpaRepository<T, ID>
	donde T --> tipo entidad
	y     ID--> tipo de la primary key
	Si se necesitan más métodos que los que estan en JpaRepository se incorporan aquí
	@Query("     ")
	tipoDevuelve metodo(tipoArg arg)

4-Capa de la lógica de negocio, capa de servicio (com.curso.service) 
  4.1 Crear la interface
  4.2 Crear clase que implemente esa interface (no olvidar incluir @Service) y declarar una variable de tipo XXDao y anotarla 
  con  @Autowired
5- Implementar el controlador (com.curso.controller)   (no olvidar @RestController en la clase y   @Autowired LibrosService service)
6- Configuraciones 

   6.1 En la clase lanzadora añadir los paquetes que tienen clases con anotaciones de spring
   	@EntityScan(basePackages="com.curso.model")  -->paquete donde esta la entidad
	@EnableJpaRepositories(basePackages="com.curso.dao")--->paquete donde esta la interface que herada de JpaRepository
	@SpringBootApplication(scanBasePackages= {"com.curso.controller", "com.curso.service"})
   6.2  En el application.properties incorporar las propiedades necesarias para poder trabajar con la base de datos
   
   
   
   
   
   
   
   
   