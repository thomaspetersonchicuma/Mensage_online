
package controller;

import br.com.caelum.vraptor.*;
import javax.inject.Inject;


/**
 *
 * @author 
 */
/*Login da API e nao da APP*/

@Controller
@Path("inicial")
public class InicialController {

    @Inject private Result result;

    /* Initial dashboard page Controller 
    This method can make you access the initial project home page*/
    protected InicialController() {
	this(null);
    }
	
    /* Initial dashboard Controller 
    Get all data to initial project home page*/
    @Inject
    public InicialController(Result result) {
        this.result = result;
    }

    /* Initial dashboard pege Controller 
    project home page*/
    @Path("/inicial")
    public void inicial() {
    }

    /* Initial dashboard pege Controller 
    Access client home page*/
    @Path("/paginacliente")
    public void paginacliente() {  
    }
}
