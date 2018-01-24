package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;

public class UsuarioDAO {
   
    public UsuarioDAO() { }
    
    public Usuario buscarUsuario (Usuario usuario) {
        String sql = "SELECT * FROM tb_usuarios WHERE co_usuario = ?";
        Usuario retorno = null;
        
        PreparedStatement ps = Conexao.getPreparedStatement(sql);
        try {
            ps.setString(1, usuario.getCodigo());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                retorno = new Usuario();
                retorno.setCodigo(rs.getString("co_usuario"));
                retorno.setSenha(rs.getString("co_senha"));
            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return retorno;
    }
}