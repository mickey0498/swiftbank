import com.moch.swiftbank.Acceso.Login;
import com.moch.swiftbank.Registro.Users.Usuarios;
import com.moch.swiftbank.Registro.Users.UsuariosService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller public class PrincipalController {
    @Autowired
    private UsuariosService usuariosService;
    @Autowired
    private Login loginServicio;
    @GetMapping("principal/login")
    public String showLoginForm(Model model) {
        return "principal/index"; // Assuming your login page is index.html
    }
    @GetMapping("/principal/menu")
    public String showMenu(Model model) {
        // ... your logic here ...
        return "principal/menu"; // Assuming you have a menu.html template
    }
    @PostMapping("/principal/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        if (loginServicio.validarCredenciales(username, password)) {
            // Authentication successful
            Usuarios usuarioEncontrado = usuariosService.obtenerUsuarioPorNombre(username);
            if (usuarioEncontrado != null) {
                model.addAttribute("username", usuarioEncontrado.getName());
                return "redirect:/principal/menu"; // Redirect to the menu page
            }
        }
        // Authentication failed
        model.addAttribute("error", "Invalid credentials. Please try again.");
        return "principal/index"; // Return to the login page
    }
    @GetMapping("/principal/register")
    public String showRegisterForm(Model model) {
        return "principal/register";
    }
    @GetMapping("/principal/welcome")
    public String showWelcomePage(Model model) {
        return "principal/welcome";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        // Invalidate the user's session
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        // Redirect to the login page
        return "redirect:/login";
    }
}