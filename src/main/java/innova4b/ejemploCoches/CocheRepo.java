package innova4b.ejemploCoches;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class CocheRepo {
	
	private JdbcTemplate jdbcTemplate;
	
	public CocheRepo(DriverManagerDataSource dataSoruce) {
		this.jdbcTemplate = new JdbcTemplate(dataSoruce);
	}

	public Coche get(int id) {
		return jdbcTemplate.query("select * from coche where id="+id, new CocheMapper()).get(0);            		
	}
	
	public void updateEmpleado(Coche coche , Empleado empleado){
		String query = "update coche set empleado_id="+empleado.getId()+" where id="+coche.getId();
		jdbcTemplate.update(query);
	}

}
