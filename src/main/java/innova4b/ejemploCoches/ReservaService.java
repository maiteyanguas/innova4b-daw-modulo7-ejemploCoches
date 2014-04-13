package innova4b.ejemploCoches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservaService {
	
	@Autowired
	CocheRepo cocheRepo;
	@Autowired
	EmpleadoRepo empleadoRepo;
	
	public void setCocheRepo(CocheRepo cocheRepo) {
		this.cocheRepo = cocheRepo;
	}
	
	public void setEmpleadoRepo(EmpleadoRepo empleadoRepo) {
		this.empleadoRepo = empleadoRepo;
	}

	public String reserva(Empleado empleado, Coche coche) {
		String resultado = "KO";
		if (!cocheRepo.isCocheReservado(coche) && empleado.getCocheId()==0){
			empleado.setCocheId(coche.getId());
			empleadoRepo.updateCoche(coche, empleado);
			resultado = "OK";
		}
		return resultado;
		
	}
	
	

}
