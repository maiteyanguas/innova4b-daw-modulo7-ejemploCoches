package innova4b.ejemploCoches;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("innova4b/ejemploCoches/application-context.xml");
    	ReservaService reservaService = context.getBean("reservaService", ReservaService.class);
    	EmpleadoRepo empleadoRepo = context.getBean("empleadoRepo", EmpleadoRepo.class);
    	CocheRepo cocheRepo = context.getBean("cocheRepo", CocheRepo.class);
    	Empleado empleado = empleadoRepo.get(2);
    	Coche coche = cocheRepo.get(11);
    	System.out.println(reservaService.reserva(empleado, coche));
    }
}
