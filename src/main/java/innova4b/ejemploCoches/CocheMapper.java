package innova4b.ejemploCoches;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CocheMapper implements RowMapper<Coche> {

	public Coche mapRow(ResultSet rs, int rowNum) throws SQLException {
		Coche coche = new Coche();
		coche.setId(rs.getInt("id"));
		coche.setMarca(rs.getString("marca"));
		coche.setModelo(rs.getString("modelo"));
		coche.setEmpleadoId(rs.getInt("empleado_id"));
		return coche;
	}

}
