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

	public boolean isCocheReservado(Coche coche) {
		return jdbcTemplate.query("select * from empleado where coche_id="+coche.getId(), new EmpleadoMapper()).size()>0;   
	}

}
