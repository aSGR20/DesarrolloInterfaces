package Proyecto;

public class Cliente {
    String DNI, nombre, apellidos, tel�fono, domicilio, correo;

    public Cliente(String DNI, String nombre, String apellidos, String tel�fono, String domicilio, String correo) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.tel�fono = tel�fono;
        this.domicilio = domicilio;
        this.correo = correo;
    }
    
    public Cliente(String nombre, String apellidos, String tel�fono, String domicilio) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.tel�fono = tel�fono;
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        return DNI + ";" + nombre + ";" + apellidos + ";" + tel�fono + ";" + domicilio + ";" + correo;
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

	public String getTel�fono() {
		return tel�fono;
	}

	public void setTel�fono(String tel�fono) {
		this.tel�fono = tel�fono;
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