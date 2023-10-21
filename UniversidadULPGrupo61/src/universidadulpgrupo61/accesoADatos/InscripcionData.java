package universidadulpgrupo61.accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadulpgrupo61.entidades.Alumno;
import universidadulpgrupo61.entidades.Inscripcion;
import universidadulpgrupo61.entidades.Materia;

public class InscripcionData {

    private Connection con = null;
    private MateriaData matData = new MateriaData();
    private AlumnoData aluData = new AlumnoData();

    public InscripcionData() {
        con = Conexion.getConnection();
    }

    public void guardarInscripcion(Inscripcion insc) {
        try {

            String sql = "INSERT INTO inscripcion(idAlumno,idMateria,nota) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, insc.getAlumno().getIdAlumno());
            ps.setInt(2, insc.getMateria().getIdMateria());
            ps.setDouble(3, insc.getNota());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                //rs.getInt("idinscripcion") da error con el insert y el generated keys, seria con un SELECT idMateria FROM inscripcion WHERE dni = ?
                insc.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripción añadida con éxito.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción " + ex.getMessage());
        } catch (NullPointerException np){
            JOptionPane.showMessageDialog(null, "No hay registros que modificar.");
        }

    }

    public List<Inscripcion> obtenerInscripciones() {
        List<Inscripcion> inscripciones = new ArrayList<>();

        try {
            String sql = "SELECT * FROM inscripcion";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Inscripcion inscripcion = new Inscripcion();
                Alumno alumno = new Alumno();
                Materia materia = new Materia();

                inscripcion.setIdInscripcion(rs.getInt("idInscripcion"));
                alumno = aluData.buscarAlumno(rs.getInt("idAlumno"));
                materia = matData.buscarMateria(rs.getInt("idMateria"));
                inscripcion.setAlumno(alumno);
                inscripcion.setMateria(materia);
                inscripcion.setNota(rs.getDouble("nota"));

                inscripciones.add(inscripcion);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion." + ex.getMessage());
        }
        return inscripciones;
    }

    public void actualizarNota(int idAlumno, int idMateria, double nota) {
        try {
            String sql = "UPDATE inscripcion"
                       + "   SET nota = ?"
                       + " WHERE idAlumno = ?"
                       + "   AND idMateria = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            int fila = ps.executeUpdate();
//            if (fila == 1) {
//                JOptionPane.showMessageDialog(null, "Nota actualizada");
//            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla");
        } catch (NumberFormatException np){
            JOptionPane.showMessageDialog(null, "Alguna nota ingresada no es válida.");
        }
    }

    public void borrarInscripcion(int idAlumno, int idMateria) {
        try {
            String sql = "DELETE FROM inscripcion WHERE idAlumno = ? AND idMateria = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Inscripcion Borrada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
    }

    public List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno) {
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();

        try {
            String sql = "SELECT * FROM inscripcion WHERE idAlumno = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Inscripcion inscripcion = new Inscripcion();
                Alumno alumno = new Alumno();
                Materia materia = new Materia();

                inscripcion.setIdInscripcion(rs.getInt("idInscripcion"));
                alumno = aluData.buscarAlumno(rs.getInt("idAlumno"));
                materia = matData.buscarMateria(rs.getInt("idMateria"));
                inscripcion.setAlumno(alumno);
                inscripcion.setMateria(materia);
                inscripcion.setNota(rs.getDouble("nota"));

                inscripciones.add(inscripcion);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion." + ex.getMessage());
        }
        return inscripciones;
    }

    public List<Materia> obtenerMateriasCursadas(int idAlumno) {
        ArrayList<Materia> materias = new ArrayList();
        try {
            String sql = "SELECT inscripcion.idMateria"
                       + "      ,nombre"
                       + "      ,año"
                       + "  FROM inscripcion "
                       + "  JOIN materia "
                       + "    ON inscripcion.idMateria = materia.idMateria"
                       + " WHERE idAlumno = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materias.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
        return materias;
    }

    public List<Materia> obtenerMateriasNoCursadas(int idAlumno) {
        ArrayList<Materia> materias = new ArrayList();
        String sql = "SELECT *"
                   + "  FROM materia"
                   + " WHERE estado = 1"
                   + "   AND idMateria NOT IN (SELECT idMateria FROM inscripcion WHERE idAlumno = ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materias.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
        return materias;
    }

    public List<Alumno> obtenerAlumnosPorMateria(int idMateria) {
        ArrayList<Alumno> alumnosMateria = new ArrayList();

        String sql = "SELECT a.idAlumno,dni,nombre,apellido,fechaNacimiento,estado"
                   + "  FROM inscripcion i"
                   + "  JOIN alumno a"
                   + "    ON i.idAlumno = a.idAlumno"
                   + " WHERE idMateria= ? AND a.estado = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));
                alumnosMateria.add(alumno);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a table inscripcion");
        }
        return alumnosMateria;
    }
    
    
}
