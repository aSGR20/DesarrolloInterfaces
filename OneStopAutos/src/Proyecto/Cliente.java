package Proyecto;

public class Cliente {
    String DNI, nombre, apellidos, teléfono, domicilio, correo;

    public Cliente(String DNI, String nombre, String apellidos, String teléfono, String domicilio, String correo) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.teléfono = teléfono;
        this.domicilio = domicilio;
        this.correo = correo;
    }
    
    public Cliente(String nombre, String apellidos, String teléfono, String domicilio) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.teléfono = teléfono;
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        return DNI + ";" + nombre + ";" + apellidos + ";" + teléfono + ";" + domicilio + ";" + correo;
    }

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTeléfono() {
		return teléfono;
	}

	public void setTeléfono(String teléfono) {
		this.teléfono = teléfono;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
}