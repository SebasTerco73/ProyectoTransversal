package universidadulpgrupo61.accesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidadulpgrupo61.entidades.Alumno;
import universidadulpgrupo61.entidades.Materia;

public class MateriaData {

    private Connection con = null;

    public MateriaData() {
        con = Conexion.getConnection();
    }

    public void guardarMateria(Materia materia) {

        try {
            String sql = "INSERT INTO materia(nombre,año,estado) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3, materia.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                //rs.getInt("idAlumno") da error con el insert y el generated keys, seria con un SELECT idMateria FROM alumno WHERE dni = ?
                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Materia añadida con éxito.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia " + ex.getMessage());
        }
    }
    
    public void guardarMateriaConId(Materia materia) {

        try {
            String sql = "INSERT INTO materia(idMateria,nombre,año,estado) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,materia.getIdMateria());
            ps.setString(2, materia.getNombre());
            ps.setInt(3, materia.getAnioMateria());
            ps.setBoolean(4, materia.isEstado());
            int fila=ps.executeUpdate();
            if(fila!=0){
                JOptionPane.showMessageDialog(null, "Materia añadida con exito");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia " + ex.getMessage());
        }
    }

    public Materia buscarMateria(int id) {

        Materia materia = null;
        String sql = "SELECT nombre,año,estado FROM materia WHERE idMateria = ? AND estado = 1";

        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(id);
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materia.setEstado(true);
            } else {
                JOptionPane.showMessageDialog(null, "No existe la materia.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia " + ex.getMessage());
        }

        return materia;
    }

    public void modificarMateria(Materia materia) {

        String sql = "UPDATE materia SET nombre = ?, año = ? WHERE idMateria = ? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setInt(3, materia.getIdMateria());

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "La materia no existe.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia " + ex.getMessage());
        }
    }

    public void eliminarMateria(int id) {

        try {
            String sql = "UPDATE materia SET estado = 0 WHERE idMateria = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Se eliminó la materia.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la materia.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia " + ex.getMessage());
        }
    }

    public List<Materia> listaMaterias() {

        List<Materia> materias = new ArrayList<>();

        try {
            String sql = "SELECT * FROM materia WHERE estado = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materia.setEstado(rs.getBoolean("estado"));

                materias.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno." + ex.getMessage());
        }
        return materias;
    }

}
