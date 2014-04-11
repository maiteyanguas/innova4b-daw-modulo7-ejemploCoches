package innova4b.ejemploCoches;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@RunWith(MockitoJUnitRunner.class)
public class ReservaServiceTest {

	private static final int ID_COCHE = 25;
	private static final int ID_EMPLEADO = 98;
	ReservaService reservaService;
	Coche coche;
	Empleado empleado;
	
	@Mock
	private CocheRepo cocheRepoMock;	
	@Mock
	private EmpleadoRepo empleadoRepoMock;
	
	@Before
	public void setUp() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("innova4b/ejemploCoches/application-context.xml");
		reservaService = context.getBean("reservaService", ReservaService.class);
		reservaService.setCocheRepo(cocheRepoMock);
		reservaService.setEmpleadoRepo(empleadoRepoMock);
		buildCoche();	
		buildEmpleado();
	}

	private void buildEmpleado() {
		empleado = new Empleado();
		empleado.setId(ID_EMPLEADO);
		empleado.setNombre("Xabi");
		empleado.setApellido("Alonso");
	}

	private void buildCoche() {
		coche = new Coche();
		coche.setId(ID_COCHE);
		coche.setMarca("Hyundai");
		coche.setModelo("Accord");
	}
	
	@Test
	public void reserva_asigna_el_coche_al_empleado_y_el_empleado_al_coche() {
		reservaService.reserva(empleado, coche);
		
		assertEquals(ID_COCHE, empleado.getCocheId());
		verify(cocheRepoMock).updateEmpleado(coche, empleado);
		verify(empleadoRepoMock).updateCoche(coche, empleado);
	}

	@Test
	public void reserva_no_ejecuta_la_reserva_si_el_coche_esta_ya_reservado() {
		coche.setEmpleadoId(89);
		
		reservaService.reserva(empleado, coche);
		
		assertEquals(0,empleado.getCocheId());
		verify(cocheRepoMock,never()).updateEmpleado(coche, empleado);
	}
	
	@Test
	public void reserva_no_ejecuta_la_reserva_si_el_empleado_ya_tiene_coche_reservado() {
		empleado.setCocheId(89);
		
		reservaService.reserva(empleado, coche);
		
		assertEquals(0,coche.getEmpleadoId());
		verify(cocheRepoMock,never()).updateEmpleado(coche, empleado);
	}
}
