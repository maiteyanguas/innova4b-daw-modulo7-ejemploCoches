package innova4b.ejemploCoches;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmpleadoMapper implements RowMapper<Empleado> {

	public Empleado mapRow(ResultSet rs, int rowNum) throws SQLException {
		Empleado empleado = new Empleado();
		empleado.setId(rs.getInt("id"));
		empleado.setNombre(rs.getString("nombre"));
		empleado.setApellido(rs.getString("apellido"));
		empleado.setCocheId(rs.getInt("coche_id"));
		return empleado;
	}

}
