package innova4b.ejemploCoches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoRepo {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public EmpleadoRepo(DriverManagerDataSource dataSoruce) {
		this.jdbcTemplate = new JdbcTemplate(dataSoruce);
	}

	public Empleado get(int id) {
		return jdbcTemplate.query("select * from empleado where id="+id, new EmpleadoMapper()).get(0); 
	}

	public void updateCoche(Coche coche , Empleado empleado){
		String query = "update empleado set coche_id="+coche.getId()+" where id="+empleado.getId();
		jdbcTemplate.update(query);
	}

}
