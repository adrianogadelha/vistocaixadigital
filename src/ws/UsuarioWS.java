package ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import com.google.gson.Gson;

import dao.UsuarioDAO;
import modelo.Usuario;

@Path("usuarios")
public class UsuarioWS {

    @Context
    private UriInfo context;
    
    public UsuarioWS() {  }
    
    @GET
    @Produces("application/xml")
    @Path("Usuario/{codigo}")
    public String getUsuario(@PathParam("codigo") String codigo) {
        Usuario u = new Usuario();
        u.setCodigo(codigo);
        
        UsuarioDAO dao = new UsuarioDAO();
        u = dao.buscarUsuario(u);
       
        Gson g = new Gson();
        return g.toJson(u);
    }
   
}