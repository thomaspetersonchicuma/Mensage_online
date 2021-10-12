
package controller;

import br.com.caelum.vraptor.*;
import dao.UsuarioDAO;
import java.time.Instant;
import java.util.Date;
import model.Usuario;
import javax.inject.Inject;
import javax.swing.JOptionPane;


/**
 *
 * @author 
 */

 /* User Controller Methods
 This controller can give you all priviges to manage user data */

@Controller
@Path("/usuario")
public class UsuarioController {

    @Inject private Result result;
    @Inject private UsuarioDAO dao;
    
    @Path("/create")
    public void create() {
        result.include("list", dao.findAllUsers());
    }
    @Path("/editar")
    public void editar() {
        result.include("list", dao.findAllUsers());
    }
    
    
    @Path("/add")
    public void add(Usuario entity, String nome, String email,String senha,String confirmarsenha) {
        entity.setNome(nome);
        entity.setEmail(email);
        entity.setSenha(senha);
        entity.setConfirmarsenha(confirmarsenha);
        entity.setData(Date.from(Instant.now()));
        entity.setEstado(1);
        dao.create(entity);
//        JOptionPane.showMessageDialog(null,"Sucesso");
        result.redirectTo(LoginController.class).login();
       
    }
        @Path("/visualizar")
    public void visualizar() {
        result.include("list", dao.findAllUsers());
    }

    public void edita(Integer id) {
        Usuario adm = dao.find(id);
        result.include("entity", dao.find(adm.getId()));
        result.redirectTo(UsuarioController.class).editar();
    }
    @Path("/edita1")
    public void edita1(Usuario entity, Integer id, String nome, String email,
        String senha,String confirmarsenha) {
        entity = dao.find(id);
        entity.setNome(nome);
        entity.setEmail(email);
        entity.setSenha(senha);
        entity.setConfirmarsenha(confirmarsenha);
        dao.update(entity);
        result.redirectTo(UsuarioController.class).visualizar();
    }

    public void remove(Integer id) {
        Usuario adm = dao.find(id);
        adm.setEstado(0);
        dao.update(adm);
        result.redirectTo(UsuarioController.class).visualizar();
    }

    public void find(Integer id) {
        Usuario adm = dao.find(id);
        dao.find(id);
        result.redirectTo(UsuarioController.class).create();
    }
}
