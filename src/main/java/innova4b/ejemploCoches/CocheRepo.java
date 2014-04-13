package innova4b.ejemploCoches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component
public class CocheRepo {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
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
