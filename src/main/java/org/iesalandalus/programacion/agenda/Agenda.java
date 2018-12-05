package org.iesalandalus.programacion.agenda;

public class Agenda {

	private static int MAX_CONTACTOS = 3;
	private int numContactos = 0;
	private Contacto [] contactos; 
	
	public Agenda() {
	}

	public int getNumContactos() {
		return numContactos;
	}
	
	public Contacto [] getContactos() {
		Contacto [] copiaContactos = contactos;
		return copiaContactos;
	}
	
	
	
}
