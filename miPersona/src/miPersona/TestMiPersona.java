package miPersona;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;


/**
 * Implementa el programa "TestMiPersona.java" que:
 *
 *Guarde un objeto persona en un flujo con los siguientes datos:
 *	-Tu nombre
 *	-Tus apellidos
 *	-Tu fecha de nacimiento 
 *Recupere el objeto persona y muestre:
 *	-Tu nombre
 *	-Tus apellidos
 *	-Tu edad
 *Indica:
 *	-Clases de flujos utilizadas
 *	-Métodos de flujos utilizadas
 *	-Forma de tratar las excepciones
 *	-Interfaces que hayas manejado y por qué.
 * 
 *Resultado preguntas:
 *	-Clases de flujos utilizadas --> ObjectOutputStream y ObjectInputStream
 *	-Métodos de flujos utilizadas --> writeObject() y  readObject
 *	-Forma de tratar las excepciones --> Controlando la excepciones IOException y ClassNotFoundException
 *	-Interfaces que hayas manejado y por qué. --> En persona he usado Serializable, para poder leer y escribir dicho objeto
 * 
 * @author Ponferrada Lopez Javier
 * @version 1.0
 * 
 * */
public class TestMiPersona {
	public static void main(String[] args) {
		
		try {
			Persona persona = new Persona("Pepe", "López", LocalDate.of(1997, 05, 26));
			ObjectOutputStream out =null;
			try {//Escritura al archivo
				out = new ObjectOutputStream(new
				        BufferedOutputStream(new FileOutputStream("Persona.obj")));
				out.writeObject(persona);
			}finally {
				out.close();
			}

			ObjectInputStream in = null;

			try {//Lectura del archivo
				in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("Persona.obj")));
				Persona personaLeida = (Persona) in.readObject();
				System.out.println(personaLeida);
			} finally {
				in.close();
			}
		} catch (IOException|ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		

	}
}
