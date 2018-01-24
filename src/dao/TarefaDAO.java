package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Tarefa;

public class TarefaDAO {
   
    public TarefaDAO() { }
    
    public boolean inserirTarefa (Tarefa tarefa) {
        String sql = "INSERT INTO tb_tarefas (co_tarefa, no_titulo, dt_execucao, de_tarefa) VALUES (?,?,?,?)";
        Boolean retorno = false;
        PreparedStatement ps = Conexao.getPreparedStatement(sql);
        try {
            ps.setString(1, tarefa.getCodigo());
            ps.setString(2, tarefa.getTitulo());
            ps.setString(3, tarefa.getData());
            ps.setString(4, tarefa.getDescricao());
            
            if (ps.executeUpdate() > 0) {
                retorno = true;
            }
        } catch (SQLException e) {
            Logger.getLogger(TarefaDAO.class.getName()).log(Level.SEVERE, null, e);
            retorno = false;
        }
        return retorno;
    }
    
    public boolean atualizarTarefa (Tarefa tarefa) {
        String sql = "UPDATE tb_tarefas SET no_titulo = ?, dt_execucao = ?, de_tarefa = ? WHERE co_tarefa = ?";
        Boolean retorno = false;
        PreparedStatement ps = Conexao.getPreparedStatement(sql);
        try {
            ps.setString(1, tarefa.getTitulo());
            ps.setString(2, tarefa.getData());
            ps.setString(3, tarefa.getDescricao());
            ps.setString(4, tarefa.getCodigo());
            if (ps.executeUpdate() > 0) {
                retorno = true;
            }
        } catch (SQLException e) {
            Logger.getLogger(TarefaDAO.class.getName()).log(Level.SEVERE, null, e);
            retorno = false;
        }
        return retorno;
    }
    
    public boolean excluirTarefa (Tarefa tarefa) {
        String sql = "DELETE FROM tb_tarefas WHERE co_tarefa = ?";
        Boolean retorno = false;
        PreparedStatement ps = Conexao.getPreparedStatement(sql);
        try {
            ps.setString(1, tarefa.getCodigo());
            if (ps.executeUpdate() > 0) {
                retorno = true;
            }
        } catch (SQLException e) {
            Logger.getLogger(TarefaDAO.class.getName()).log(Level.SEVERE, null, e);
            retorno = false;
        }
        return retorno;
    }
    
    public List<Tarefa> listarTarefas () {
    	String sql = "SELECT * FROM tb_tarefas";
        List<Tarefa> retorno = new ArrayList<Tarefa>();
        
        PreparedStatement ps = Conexao.getPreparedStatement(sql);
        try { 
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Tarefa item = new Tarefa();
                item.setCodigo(rs.getString("co_tarefa"));
                item.setTitulo(rs.getString("no_titulo"));
                item.setData(rs.getString("dt_execucao"));
                item.setDescricao(rs.getString("de_tarefa"));
                retorno.add(item);
            }
        } catch (SQLException e) {
            Logger.getLogger(TarefaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return retorno;
    }

    public Tarefa buscarTarefa (Tarefa tarefa) {
        String sql = "SELECT * FROM tb_tarefas WHERE no_titulo = ? OR de_tarefa = ?";
        Tarefa retorno = null;
        
        PreparedStatement ps = Conexao.getPreparedStatement(sql);
        try {
            ps.setString(1, tarefa.getTitulo());
            ps.setString(2, tarefa.getDescricao());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                retorno = new Tarefa();
                retorno.setCodigo(rs.getString("co_tarefa"));
                retorno.setTitulo(rs.getString("no_titulo"));
                retorno.setData(rs.getString("dt_execucao"));
                retorno.setDescricao(rs.getString("de_tarefa"));
            }
        } catch (SQLException e) {
            Logger.getLogger(TarefaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return retorno;
    }
}