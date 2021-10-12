package controller;

import br.com.caelum.vraptor.*;
import dao.MensagemDAO;
import dao.UsuarioDAO;
import java.time.Instant;
import java.util.Date;
import model.Usuario;
import javax.inject.Inject;
import javax.swing.JOptionPane;
import model.Mensagem;

/**
 *
 * @author
 */
@Controller
@Path("/mensagem")
public class MensagemController {

    @Inject
    private Result result;
    @Inject
    private UsuarioDAO usodao;
    @Inject
    private MensagemDAO dao;
//    private Integer valor;
     @Inject
    private LoginController log;

    @Path("/create")
    public void create() {
        
        result.include("lista", usodao.findAllUsers1(LoginController.valor));
        result.include("lista1", usodao.findAllUsers(LoginController.valor));
        
    }

    @Path("/visualizar")
    public void visualizar() {
        
       
        result.include("list", dao.findAllUsers1(LoginController.valor));
    }

    @Path("/add")
    public void add(Mensagem entity, Integer receptor,String descricao) {
        Usuario uso = usodao.find(receptor);
        Usuario uso1 = usodao.find(LoginController.valor);
        
        entity.setDescricao(descricao);
        entity.setReceptor(uso);
        entity.setEmissor(uso1);
        entity.setData(Date.from(Instant.now()));
        entity.setEstado(1);
        dao.create(entity);
        result.include("lista", dao.find(entity.getId()));
        result.redirectTo(MensagemController.class).create();

    }

    public void remove(Integer id) {
        Mensagem adm = dao.find(id);
        adm.setEstado(0);
        dao.update(adm);
//        result.redirectTo(MensagemController.class).visualizar();
    }

}
