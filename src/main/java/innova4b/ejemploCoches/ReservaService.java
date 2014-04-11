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
		if (!cocheRepo.isCocheReservado(coche) && empleado.getCocheId()==0){
			empleado.setCocheId(coche.getId());
			empleadoRepo.updateCoche(coche, empleado);
			resultado = "OK";
		}
		return resultado;
		
	}
	
	

}
