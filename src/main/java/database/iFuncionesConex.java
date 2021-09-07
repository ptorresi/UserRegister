/*
 * Interface utilizada para crear las funciones basicas de las entidades
 */
package database;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ptorr
 */
public interface iFuncionesConex {
    boolean AgregarDatos(Object o) throws SQLException;
    
    boolean ModificarDatos(Object o) throws SQLException;
    
    boolean BorrarDatos(Object o) throws SQLException;
    
    Object CargarClase (Object o) throws SQLException;
    
    List Listar () throws SQLException;
}
