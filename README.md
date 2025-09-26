# ConexionConMySQL
Una aplicación Java que implementa un sistema CRUD (Create, Read, Update, Delete) para gestionar información de programadores (Coders) utilizando MySQL como base de datos y JOptionPane para la interfaz de usuario.

## 🚀 Características

Crear Coders: Agregar nuevos programadores con nombre, edad y clan
Listar Coders: Ver todos los programadores registrados
Actualizar Coders: Modificar información existente de los programadores
Eliminar Coders: Remover programadores del sistema
Interfaz amigable: Utiliza ventanas de diálogo para la interacción con el usuario

## 🛠️ Tecnologías utilizadas

Java 24: Lenguaje de programación principal
MySQL: Sistema de gestión de base de datos
MySQL Connector/J 9.1.0: Driver JDBC para conectar con MySQL
Swing (JOptionPane): Para la interfaz gráfica de usuario
IntelliJ IDEA: IDE de desarrollo

## 📋 Prerrequisitos

Java Development Kit (JDK) 24 o superior
MySQL Server
MySQL Connector/J 9.1.0

## 🗄️ Configuración de la base de datos

Crear la base de datos en MySQL:

sqlCREATE DATABASE usuarios_db;

Crear la tabla coder:

sqlUSE usuarios_db;

CREATE TABLE coder (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    clan VARCHAR(100) NOT NULL
);
⚙️ Configuración del proyecto

Clonar el repositorio:

bashgit clone <URL_DEL_REPOSITORIO>
cd ConexionConMySQL

Configurar la conexión a la base de datos:
Edita el archivo src/database/ConfigDB.java y modifica las credenciales de conexión:

javaString url = "jdbc:mysql://localhost:3306/usuarios_db";
String user = "TU_USUARIO";
String password = "TU_CONTRASEÑA";

Asegurar que el MySQL Connector esté disponible:
El proyecto está configurado para usar mysql-connector-j-9.1.0.jar. Asegúrate de que el archivo JAR esté en la ruta correcta según el archivo .iml.

🚀 Cómo ejecutar

Abre el proyecto en IntelliJ IDEA (o tu IDE preferido)
Ejecuta la clase Main.java
Utiliza el menú interactivo para realizar las operaciones CRUD

Opciones del menú:

1: Crear un nuevo coder
2: Listar todos los coders
3: Eliminar un coder por ID
4: Actualizar un coder existente
5: Salir de la aplicación

📁 Estructura del proyecto
src/
├── Controller/
│   └── CoderController.java    # Controlador con la lógica de la aplicación
├── Entity/
│   └── Coder.java              # Entidad que representa un programador
├── Model/
│   └── CoderModel.java         # Modelo con operaciones CRUD
├── database/
│   ├── ConfigDB.java           # Configuración de conexión a BD
│   └── CRUD.java               # Interfaz para operaciones CRUD
└── Main.java                   # Clase principal
🏗️ Arquitectura
El proyecto sigue el patrón MVC (Model-View-Controller):

Model (CoderModel): Maneja la lógica de acceso a datos y operaciones CRUD
View (JOptionPane): Interfaz de usuario mediante ventanas de diálogo
Controller (CoderController): Coordina la interacción entre el modelo y la vista
Entity (Coder): Representa la estructura de datos del programador

🔍 Funcionalidades principales
Crear Coder
Permite agregar un nuevo programador solicitando:

Nombre
Edad
Clan

Listar Coders
Muestra todos los programadores registrados con su información básica.
Actualizar Coder
Permite modificar los datos de un programador existente:

Muestra la lista actual de coders
Solicita el ID del coder a actualizar
Permite editar nombre, edad y clan

Eliminar Coder
Elimina un programador del sistema:

Solicita el ID del coder a eliminar
Confirma la acción antes de proceder
Elimina el registro de la base de datos

🤝 Contribuir

Fork el proyecto
Crea una rama para tu feature (git checkout -b feature/AmazingFeature)
Commit tus cambios (git commit -m 'Add some AmazingFeature')
Push a la rama (git push origin feature/AmazingFeature)
Abre un Pull Request

📝 Notas adicionales

El proyecto utiliza PreparedStatement para prevenir inyecciones SQL
La conexión a la base de datos se maneja de forma manual (abrir/cerrar en cada operación)
La interfaz es básica utilizando ventanas de diálogo de Java Swing

🐛 Posibles mejoras

Implementar pool de conexiones
Agregar validación de datos de entrada
Crear una interfaz gráfica más robusta (JavaFX o Swing completo)
Implementar manejo de excepciones más específico
Agregar logging
Implementar pruebas unitarias

📄 Licencia
Este proyecto es de uso educativo y está disponible bajo la licencia MIT.
