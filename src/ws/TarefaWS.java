package ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import com.google.gson.Gson;

import dao.TarefaDAO;
import modelo.Tarefa;

@Path("tarefas")
public class TarefaWS {

    @Context
    private UriInfo context;
    
    public TarefaWS() {  }
    
    @GET
    @Produces("application/xml")
    @Path("Tarefa/{codigo}")
    public String getTarefa(@PathParam("codigo") String codigo) {
        Tarefa t = new Tarefa();
        t.setCodigo(codigo);
        
        TarefaDAO dao = new TarefaDAO();
        t = dao.buscarTarefa(t);
       
        Gson g = new Gson();
        return g.toJson(t);
    }
    
    @GET
    @Produces("application/json")
    @Path("Tarefa/lista")
    public String listTarefas() {
        List<Tarefa> lista;
        
        TarefaDAO dao = new TarefaDAO();
        lista = dao.listarTarefas();
        
        Gson g = new Gson();
        return g.toJson(lista);
    }
    
}