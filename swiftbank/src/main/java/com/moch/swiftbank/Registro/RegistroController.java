package com.moch.swiftbank.Registro;


import com.moch.swiftbank.Registro.Users.Usuarios;
import com.moch.swiftbank.Registro.Users.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistroController {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @PostMapping("principal/register")
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("name") String name,
                           @RequestParam("email") String email,
                           Model model) {
        // Check if username or email already exists
        if (usuariosRepository.findByUsername(username) != null || usuariosRepository.findByEmail(email) != null) {
            model.addAttribute("error", "Username or email already exists.");
            return "principal/register";
        }
        // Check if the username "moch" is already taken
        if (username.equalsIgnoreCase("moch")) {
            model.addAttribute("error", "Username 'moch' is not available. Please choose a different username.");
            return "principal/register";
        }
        // Create a new user
        Usuarios newUser = new Usuarios(name, "", username, password); // Add email validation and set it here
        usuariosRepository.save(newUser);
        // Redirect to success page or login page
        return "redirect:/login";
    }
}