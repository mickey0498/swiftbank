//package com.moch.swiftbank.Registro.Users;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import lombok.Data;
//import org.springframework.stereotype.Component;
//
//import java.util.Random;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//@Entity
//@Data
//@Component
//public class UsuariosConditions {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String usuario;
//    private String password;
//    private String nombre;
//    private String apellido;
//    private String telefono;
//    private String email;
//
//    public UsuariosConditions() {
//    }
//
//    // Existing constructor
//    public UsuariosConditions(String usuario, String password, String nombre, String apellido, String telefono, String email) {
//        this.usuario = usuario;
//        this.password = password;
//        this.nombre = nombre;
//        this.apellido = apellido;
//        this.telefono = telefono;
//        this.email = email;
//    }
//
//    public boolean validarUsuario(String usuario) {
//        if (usuario.isEmpty()) {
//            return false;
//        } else if (usuario.length() < 6) {
//            return false;
//        } else {
//            Pattern pattern = Pattern.compile("[^a-zA-Z0-9]+");
//            return !pattern.matcher(usuario).find();
//        }
//    }
//
//    public String completarUsuario(String usuario) {
//        if (usuario.length() >= 6) {
//            return usuario;
//        } else {
//            int complementoUsuario = 6 - usuario.length();
//            Random random = new Random();
//            String numbers = "";
//
//            for (int i = 0; i < complementoUsuario; ++i) {
//                numbers = numbers + random.nextInt(10);
//            }
//
//            return usuario + numbers;
//        }
//    }
//
//    public String mayusculaInicial(String text) {
//        if (text == null || text.isEmpty()) {
//            return text;
//        } else {
//            return text.substring(0, 1).toUpperCase() + text.substring(1);
//        }
//    }
//
//    public boolean validarPassword(String password) {
//        if (password.isEmpty()) {
//            return false;
//        } else if (password.length() < 8) {
//            return false;
//            }
//            else if (password.equals(usuario)){
//            System.out.println("La contraseña no puede ser igual al nombre de usuario");
//                return false;
//        } else {
//            Pattern mayuscula = Pattern.compile(".*[A-Z].*");
//            Pattern especial = Pattern.compile(".*[!@#$%^&*()_+{}\\[\\]:;<>,.?/~`].*");
//            Pattern numero = Pattern.compile(".*[0-9].*");
//            return mayuscula.matcher(password).find() && especial.matcher(password).find() && numero.matcher(password).find();
//        }
//    }
//
//    public boolean validarNombre(String nombre) {
//        if (nombre.isEmpty()) {
//            return false;
//        } else {
//            Pattern letras = Pattern.compile("^[a-zA-Z]+$");
//            return letras.matcher(nombre).matches();
//        }
//    }
//
//    public boolean validarApellido(String apellido) {
//        if (apellido.isEmpty()) {
//            return false;
//        } else {
//            Pattern letras = Pattern.compile("^[a-zA-Z]+$");
//            return letras.matcher(apellido).matches();
//        }
//    }
//
//    public boolean validarTelefono(String telefono) {
//        if (telefono.isEmpty()) {
//            return false;
//        } else {
//            String patron = "\\d{3}-\\d{3}-\\d{4}";
//            return telefono.matches(patron);
//        }
//    }
//
//    public boolean validarEmail(String email) {
//        if (email.isEmpty()) {
//            return false;
//        } else {
//            String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[a-zA-Z]{2,4}$";
//            Pattern pattern = Pattern.compile(regex);
//            Matcher matcher = pattern.matcher(email);
//            return matcher.matches();
//        }
//    }
//
//    public void mostrarInformacion(String usuario, String nombre, String apellido, String telefono, String email) {
//        System.out.println("Información ingresada:");
//        System.out.println("Nombre de usuario: " + usuario);
//        System.out.println("Nombre: " + nombre);
//        System.out.println("Apellido: " + apellido);
//        System.out.println("Teléfono: " + telefono);
//        System.out.println("Correo electrónico: " + email);
//    }
//
//}
//
