# Literalura

## Descripción

**Literalura** es una aplicación de consola en Java que permite a los usuarios interactuar con una API de libros llamada Gutendex y almacenar los resultados en una base de datos local PostgreSQL. La aplicación ofrece varias opciones para buscar libros, listar autores, y realizar filtrados específicos. Su diseño robusto asegura que pueda manejar entradas inválidas sin interrumpir la ejecución.

## Características

- **Buscar Libro por Título**: Permite al usuario buscar libros por su título usando la API de Gutendex.
- **Listar Libros Registrados**: Muestra todos los libros almacenados en la base de datos local.
- **Listar Autores Registrados**: Proporciona una lista de todos los autores presentes en la base de datos local.
- **Listar Autores Vivos en un Determinado Año**: Filtra y muestra los autores que estaban vivos en un año específico.
- **Listar Libros por Idioma**: Permite filtrar los libros registrados en la base de datos por idioma, con opciones de búsqueda en español, inglés, francés y portugués.

## Requisitos

- **Java**: JDK 8 o superior
- **PostgreSQL**: Instalación y configuración de una base de datos PostgreSQL
- **IDE**: Cualquier IDE compatible con Java
- **Sistema Operativo**: Cualquier sistema operativo que soporte Java (Windows, macOS, Linux)

## Instalación

1. **Clonar el Repositorio**:
   ```bash
   git clone https://github.com/tuusuario/literalura.git
   ```
   
2. **Configurar la Base de Datos**:
   - Crea una base de datos PostgreSQL.
   - Configura las credenciales de la base de datos en el archivo de configuración de la aplicación.

3. **Compilar el Código**:
   Navega al directorio del proyecto y compila el código con el siguiente comando:
   ```bash
   javac Main.java
   ```

4. **Ejecutar el Programa**:
   Ejecuta el programa con:
   ```bash
   java Main
   ```

## Uso

Al ejecutar la aplicación, el usuario verá el siguiente menú:

```
***************BIENVENIDO A LITERALURA**************
Selecciona una opción del menú:
1. Buscar libro por título
2. Listar libros registrados
3. Listar autores registrados
4. Listar autores vivos en un determinado año
5. Listar libros por idioma

0. Salir
```

### Opciones del Menú:

1. **Buscar Libro por Título**: Permite ingresar el título del libro para buscarlo en la API Gutendex y agregarlo a la base de datos local.
2. **Listar Libros Registrados**: Muestra todos los libros actualmente almacenados en la base de datos.
3. **Listar Autores Registrados**: Presenta una lista de todos los autores disponibles en la base de datos.
4. **Listar Autores Vivos en un Determinado Año**: Permite al usuario ingresar un año y listar los autores que estaban vivos en ese tiempo.
5. **Listar Libros por Idioma**: Solicita al usuario seleccionar un idioma de la lista y muestra los libros correspondientes almacenados en la base de datos:

```
Seleccione el idioma que desee buscar:
1. Español
2. Inglés
3. Francés
4. Portugués
```

## Contribución

Si deseas contribuir al proyecto, sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama para tu función (`git checkout -b feature/nueva-funcion`).
3. Realiza tus cambios y haz commit (`git commit -m 'Agrega nueva función'`).
4. Empuja a la rama (`git push origin feature/nueva-funcion`).
5. Abre un Pull Request.

## Contacto

Para cualquier consulta o sugerencia, por favor contacta a [pf.cantuvillanueva@outlook.com](mailto:pf.cantuvillanueva@outlook.com).

