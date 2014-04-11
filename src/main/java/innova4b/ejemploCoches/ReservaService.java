package innova4b.ejemploCoches;

public class ReservaService {
	
	CocheRepo cocheRepo;
	EmpleadoRepo empleadoRepo;
	
	public void setCocheRepo(CocheRepo cocheRepo) {
		this.cocheRepo = cocheRepo;
	}
	
	public void setEmpleadoRepo(EmpleadoRepo empleadoRepo) {
		this.empleadoRepo = empleadoRepo;
	}

	public String reserva(Empleado empleado, Coche coche) {
		String resultado = "KO";
		if (coche.getEmpleadoId()==0 && empleado.getCocheId()==0){
			coche.setEmpleadoId(empleado.getId());
			empleado.setCocheId(coche.getId());
			empleadoRepo.updateCoche(coche, empleado);
			cocheRepo.updateEmpleado(coche, empleado);
			resultado = "OK";
		}
		return resultado;
		
	}
	
	

}
