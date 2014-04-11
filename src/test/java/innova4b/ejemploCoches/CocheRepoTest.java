package innova4b.ejemploCoches;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CocheRepoTest {
	
	CocheRepo cocheRepo;
	Coche coche;
	Empleado empleado;

	@Before
	public void setUp() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("innova4b/ejemploCoches/application-context.xml");
		cocheRepo = context.getBean("cocheRepo", CocheRepo.class);

	}

	@Test
	public void get_obtiene_los_datos_de_un_coche(){
		Coche coche = cocheRepo.get(10);
		assertEquals("Seat",coche.getMarca());
		assertEquals("Ibiza",coche.getModelo());
		
	}
	

}
