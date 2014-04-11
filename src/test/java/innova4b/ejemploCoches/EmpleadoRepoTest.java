package innova4b.ejemploCoches;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpleadoRepoTest {
	
	EmpleadoRepo empleadoRepo;

	@Before
	public void setUp() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("innova4b/ejemploCoches/application-context.xml");
		empleadoRepo = context.getBean("empleadoRepo", EmpleadoRepo.class);
	}

	@Test
	public void get_obtiene_los_datos_de_un_empleado() {
		Empleado empleado = empleadoRepo.get(1);
		assertEquals("Maite", empleado.getNombre());
		assertEquals("Yanguas", empleado.getApellido());		
	}

}
