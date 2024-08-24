//package com.moch.swiftbank;
//
//import com.moch.swiftbank.Acceso.Login;
//import com.moch.swiftbank.Registro.Users.Usuarios;
//import com.moch.swiftbank.Registro.Users.UsuariosService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Scanner;
//
//@Component
//public class PrincipalConsola {
//
//    @Autowired
//    private UsuariosService usuariosService;
//
//    @Autowired
//    private Login loginServicio;
//
//    private Scanner scanner = new Scanner(System.in);
//
//    public void menuInicial() {
//        System.out.println("Bienvenido a Swiftbank");
//        System.out.println("1. Iniciar sesión");
//        System.out.println("2. Registrarse");
//        System.out.println("3. Salir");
//
//        int opcion = scanner.nextInt();
//        scanner.nextLine(); // Consume the newline character
//
//        switch (opcion) {
//            case 1:
//                iniciarSesion();
//                break;
//            case 2:
//                registrarse();
//                break;
//            case 3:
//                System.out.println("Saliendo del sistema...");
//                System.exit(0);
//            default:
//                System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
//                menuInicial();
//        }
//    }
//
//    private void iniciarSesion() {
//        System.out.println("Ingrese su usuario:");
//        String usuario = scanner.nextLine();
//        System.out.println("Ingrese su contraseña:");
//        String password = scanner.nextLine();
//
//        // Validar credenciales
//        Usuarios usuarioEncontrado = usuariosService.obtenerUsuarioPorNombre(usuario);
//        if (usuarioEncontrado != null && usuarioEncontrado.getPassword().equals(password)) {
//            System.out.println("Inicio de sesión exitoso.");
//            // Aquí puedes implementar la lógica para mostrar el menú principal del usuario
//        } else {
//            System.out.println("Usuario o contraseña incorrectos.");
//            iniciarSesion();
//        }
//    }
//
//    private void registrarse() {
//        System.out.println("Ingrese su nombre:");
//        String nombre = scanner.nextLine();
//        System.out.println("Ingrese su apellido:");
//        String apellido = scanner.nextLine();
//        System.out.println("Ingrese su usuario:");
//        String usuario = scanner.nextLine();
//        System.out.println("Ingrese su contraseña:");
//        String password = scanner.nextLine();
//
//        // Crear un nuevo usuario
//        Usuarios nuevoUsuario = new Usuarios(nombre, apellido, usuario, password);
//        usuariosService.registrarUsuario(nuevoUsuario);
//        System.out.println("Usuario registrado correctamente.");
//        menuInicial();
//    }
//}