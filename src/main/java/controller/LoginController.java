package controller;

import br.com.caelum.vraptor.*;
import javax.inject.Inject;
import model.Usuario;
import dao.UsuarioDAO;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author
 */
/*Method to access API Login
And controll access levels into this project */
@Controller
@Path("/")
public class LoginController {

    @Inject
    private Result result;
    @Inject
    private UsuarioDAO dao;

    protected LoginController() {
        this(null);
    }
    public static Integer valor;
    @Inject
    public LoginController(Result result) {
        this.result = result;
    }

    @Path({"/", "/login"})
    public void login() {
    }
       
    @Path("/entrar1")
    public void entrar1(String email, String senha) {
        int contador = 0;
       
        for (Usuario entity : dao.findAllUsers()) {
           if (entity.getEmail().equals(email) && entity.getSenha().equals(senha) ){
                contador++;
                valor=entity.getId();
              
            }
        }
        if (contador !=0) { 
        result.redirectTo(MensagemController.class).create();
        
        } else {
            JOptionPane.showMessageDialog(null, "Senha ou email errado");
            result.redirectTo(LoginController.class).login();
        }

    }

}
