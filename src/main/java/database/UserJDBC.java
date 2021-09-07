/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import models.User;

/**
 *
 * @author ptorr
 */
public class UserJDBC implements iFuncionesConex
{
    
    //Sentencias sql
    
    private static final String SQL_BASE="SELECT * FROM user";
    
    private static final String SQL_USER_BY_ID = SQL_BASE + " WHERE " + "Id = ?";
    
    private static final String SQL_USER_LOGIN = SQL_BASE + " WHERE " + "email = ? AND contrasenia = ?";
    
    private static final String SQL_INSERT = "INSERT INTO user ( nombre, email, contrasenia, verificado ) VALUES ( ?, ?, ?, ?)"; 
    
    
    Connection conexionTransaccional;

    public UserJDBC() {
    }

    public UserJDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    @Override
    public boolean AgregarDatos(Object o) throws SQLException {
        boolean retorno = false;
        User usuario = new User();
        Connection cnn = null;
        PreparedStatement ps = null;
        int reg=0;
        
        usuario = (User) o;
        
        try{
            cnn = this.conexionTransaccional!=null ? conexionTransaccional:Conex.getConnection(false);
            ps=cnn.prepareStatement(SQL_INSERT);
            ps.setString(1, usuario.getNombre());
            ps.setString(2,usuario.getEmail());
            ps.setString(3,usuario.getContrasenia());
            ps.setString(4,getVerificationCode());
            
            reg=ps.executeUpdate();
            
            retorno = reg>0?true:false;
        }catch(Exception ex){
            ex.printStackTrace(System.out);
        }finally{
            Conex.close(ps);
            if(conexionTransaccional==null){
                Conex.close(cnn);
            }
        }
        
        
        

        
        return retorno;
    }

    @Override
    public boolean ModificarDatos(Object o) throws SQLException {
       return false;
    }

    @Override
    public boolean BorrarDatos(Object o) throws SQLException {
       return false;
    }

    @Override
    public Object CargarClase(Object o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List Listar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public User login(String mail, String pass){
        User usr = null;
        try{
            Connection cnn = Conex.getConnection(false);
            PreparedStatement ps = cnn.prepareStatement(SQL_USER_LOGIN);
            ps.setString(1, mail);
            ps.setString(2, pass);
            
            ResultSet rs  = ps.executeQuery();
            
            if(rs.next()){
                usr = new User();
                CargarDatos(usr, rs);
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return usr;
    }
    
    
    private String getVerificationCode(){
        Random rnd = new Random();
        int number = rnd.nextInt(99999);
        return String.format("%05d", number);
    }

    private void CargarDatos(User usr, ResultSet rs) throws SQLException {
        usr.setId(rs.getInt("Id"));
        usr.setNombre(rs.getString("nombre"));
        usr.setEmail(rs.getString("email"));
        usr.setContrasenia(rs.getString("contrasenia"));
        usr.setVerificado(rs.getString("verificado"));
              
        
    }
   
    
}
