package org.iesalandalus.programacion.agenda;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contacto {
	private static final String ER_TELEFONO = "[96][0-9]{8}";
	private static final String ER_CORREO = "\\w+[\\.\\w]@[A-Za-z]+[\\.[A-Za-z]]\\.[A-Za-z]{2,5}";
	
	private String nombre;
	private String telefono;
	private String correo;
	
	//Llama a los set que se han hecho anteriormente validados 
	public Contacto (String nombre, String telefono, String correo) {
		setNombre(nombre);
		setTelefono(telefono);
		setCorreo(correo);
	}
	
	
	public String getNombre() {
		return nombre;
	}
	private void setNombre(String nombre) {
		if (nombre == null || nombre.equals("")) {
			throw new IllegalArgumentException("El nombre de un contacto no puede ser nulo o vacío.");
		}else {
			this.nombre = nombre;
		}
		
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		if (telefono == null || telefono.equals("") ) {
			throw new IllegalArgumentException("El teléfono de un contacto no puede ser nulo o vacío.");
		}
		if (!telefono.matches(ER_TELEFONO)) {
			throw new IllegalArgumentException("El teléfono no tiene un formato válido.");
		}else {
			this.telefono = telefono;
		}
	}
	
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		Pattern patron;
		Matcher comparador;
	
		if (correo == null || correo.equals("")) {
			throw new IllegalArgumentException("El correo de un contacto no puede ser nulo o vacío.");
		}
		patron = Pattern.compile(ER_CORREO);
		comparador = patron.matcher(correo);
		
		if (!comparador.find()) {
			throw new IllegalArgumentException("El correo no tiene un formato válido.");
		}
		this.correo = correo;
	}
	
	//Método para sacar las iniciales del nombre 
	private String getIniciales() {
		String [] nombres = nombre.split(" "); //Genera array de String  Maria del Mar --> ["María" "del" "Mar"] 
		String iniciales = ""; //introduzco las iniciales
		for (String nombre : nombres) {
			if(!nombre.equals("")) {
			iniciales = iniciales + nombre.charAt(0); //MdM
			}
		}
		return iniciales.toUpperCase(); // devuelve las iniciales en mayúsculas
	}

	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacto other = (Contacto) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equalsIgnoreCase(other.nombre))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return getIniciales()  + " [" + getTelefono() + ", " + getCorreo() + "]" ;  
		
	}


	
	
	
	
	

}
