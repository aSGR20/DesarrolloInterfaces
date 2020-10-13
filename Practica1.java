

package Practica_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Practica1 {
	private static String OS = System.getProperty("os.name");
	public static Scanner sc = new Scanner(System.in);
	public static ProcessBuilder processBuilder = new ProcessBuilder();
	
	public static void main(String[] args) {
		//System.out.println(OS); //Muestra el SO que tienes
		System.out.println("Eliga la opción que desee realizar:");
		System.out.println("\t1.- Crear un directorio");
		System.out.println("\t2.- Crear un fichero");
		System.out.println("\t3.- Listar todas las interfaces de red");
		System.out.println("\t4.- Listar la IP de la interfaz que escribas");
		System.out.println("\t5.- Listar la MAC de la interfaz que escribas");
		System.out.println("\t6.- Comprueba que tengas conexión a internet");
		System.out.println("\t7.- Salir");
		System.out.print("Opción: ");
		int opcion = sc.nextInt();
		switch(opcion) {
		case 1:
			crearDirectorio();
			break;
		case 2:
			crearFichero();
			break;
		case 3:
			listarInterfaces();
			break;
		case 4:
			listarIP();
			break;
		case 5:
			listarMAC();
			break;
			case 6:
			testInternet();
			break;
		}
	}
	
	/**
	 * Creación de un directorio mediante
	 * uso de comandos
	 */
	public static void crearDirectorio() {
		//Solicito la ruta absoluta
		System.out.print("Introduce la ruta ABSOLUTA:");
		String ruta = sc.next();
		char lastWordChar = ruta.charAt(ruta.length()-1);
		String lastWord = String.valueOf(lastWordChar);
		
		//Solicito el nombre de la carpeta
		System.out.print("Introduce el nombre de la carpeta:");
		String nombreDirectorio = sc.next();
		
		//**** Creación de la carpeta ****
		//Si el último símbolo de la ruta introducida acaba en
		// \ o /, no añade el slash
		if(lastWord.equals("\\") || lastWord.equals("//")) {
			if(OS.equals("Windows 10")) {
				processBuilder.command("cmd.exe", "/c", "mkdir " + ruta + nombreDirectorio);
			}else {
				processBuilder.command("/bin/bash", "-c", "mkdir " + ruta + nombreDirectorio);
			}
			
		//En caso de no acabar en esos símbolos, lo añade
		}else {
			String slash = "";
			if(OS.equals("Windows 10")) {
				slash = "\\";
					processBuilder.command("cmd.exe", "/c", "mkdir " + ruta + slash + nombreDirectorio);
			}else {
				slash = "//";
					processBuilder.command("/bin/bash", "-c", "mkdir " + ruta + slash + nombreDirectorio);
			}
		}
		
		//Comienza a realizar el proceso
		try {
			Process process = processBuilder.start();
			StringBuilder buffer = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String linea;
			while((linea = reader.readLine()) != null) {
				buffer.append(linea + "\n");
			}
			System.out.println("Directorio creado correctamente");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Creación de un fichero mediante
	 * el uso de comandos
	 */
	public static void crearFichero() {		
		//Solicito la ruta absoluta 
		System.out.print("Introduce la ruta ABSOLUTA:");
		String ruta = sc.next();
		
		//Obtengo el último carácter de la ruta y lo guardo en una variable
		char lastWordChar = ruta.charAt(ruta.length()-1);
		String lastWord = String.valueOf(lastWordChar);
		
		//Solicito el nombre del fichero
		System.out.print("Introduce el nombre y extensión del fichero:");
		String nombreFichero = sc.next();
		
		//**** Creación de un fichero ****
		//Si el último símbolo de la ruta introducida acaba en
		// \ o /, no añade el slash
		if(lastWord.equals("\\") || lastWord.equals("//")) {
			if(OS.equals("Windows 10")) {
				processBuilder.command("cmd.exe", "/c", "copy > " + ruta + nombreFichero);
			}else {
				processBuilder.command("/bin/bash", "-c", "touch > " + ruta + nombreFichero);
			}
			
		//En caso de no acabar en esos símbolos, lo añade
		}else {
			String slash = "";
			if(OS.equals("Windows 10")) {
				slash = "\\";
					processBuilder.command("cmd.exe", "/c", "copy > " + ruta + slash + nombreFichero);
			}else if (OS.equals("Linux")){
				slash = "//";
					processBuilder.command("/bin/bash", "-c", "touch > " + ruta + slash + nombreFichero);
			}
		}
		
		//Comienza a realizar el proceso
		try {
			Process process = processBuilder.start();
			StringBuilder buffer = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String linea;
			while((linea = reader.readLine()) != null) {
				buffer.append(linea + "\n");
			}
			System.out.println("Fichero creado correctamente");
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	
	/**
	 * Muestra por consola la interfaz de red mediante
	 * el uso de comandos
	 */
	public static void listarInterfaces() {
		if (OS.equals("Windows 10")) {
			processBuilder.command("cmd.exe", "/c", "ipconfig /all");
		}else {
			processBuilder.command("/bin/bash", "-c",  "ifconfig");
		}
		
		try {
			System.out.println("************************ CONFIGURACIÓN DE RED ************************");
			Process process = processBuilder.start();
			StringBuilder buffer = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String linea;
			while((linea = reader.readLine()) != null) {
				buffer.append(linea + "\n");
			}
			try {
				if (process.waitFor() == 0) {
					System.out.println(buffer);
				} else {
					System.out.println("No puedo mostrar todas tu interfaces de red");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	
	/**
	 * Muestra por consola la ip del adaptador
	 * introducido mediante el uso de comando
	 */
	public static void listarIP() {
		//Obtiene nombre del adaptador
		System.out.print("IP del adaptador: ");
		String adapterName = sc.next();
		
		//Dependiendo del OS carga un comando u otro
		if (OS.equals("Windows 10")) {
			processBuilder.command("cmd.exe", "/c", "ipconfig");
			try {
				Process process = processBuilder.start();
				BufferedReader buffer = new BufferedReader(
		                new InputStreamReader(process.getInputStream()));
				String line;
		        boolean foundAdapter = false;
		        
		        //Mira línea por línea en búsqueda de "Ethernet adapter " + (nombre de la variable introducido)
		        while ((line = buffer.readLine()) != null) {
		            line = line.trim();
		            if (line.equals("Ethernet adapter " + adapterName + ':')) {
		                foundAdapter = true;
		                break;
		            }
		        }
		        if (!foundAdapter) {
		            throw new IOException("No se encuentra el adaptador");
		        }

		        //Busca la IP en la sección encontrada
		        ArrayList<String> ips = new ArrayList<String>();
		        while ((line = buffer.readLine()) != null) {
		            if (line.length() > 0 && line.charAt(0) != ' ') {
		                break;
		            }
		            line = line.trim();

		            //Extrae la IP
		            if (line.startsWith("IP Address.") ||
		                line.startsWith("IPv4 Address.")) {

		                int colonIndex;
		                if ((colonIndex = line.indexOf(':')) != 1) {
		                    ips.add(line.substring(colonIndex + 2));
		                }
		            }
		        }
		        System.out.println(ips);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}else {
			processBuilder.command("/bin/bash", "-c", "hostname -I");
			try {
				Process process = processBuilder.start();
				StringBuilder buffer = new StringBuilder();
				BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String linea;
				while((linea = reader.readLine()) != null) {
					buffer.append(linea + "\n");
					try {
						if (process.waitFor() == 0) {
							System.out.println(buffer);
						} else {
							System.out.println("No se ha encontrado su direccion IP");
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
	/**
	 * Muestra por consola la mac del adaptador
	 * introducido mediante el uso de comando
	 */
	public static void listarMAC() {
		//Obtiene nombre del adaptador
		System.out.print("Diga el adaptardor para obtener la MAC: ");
		String adapterName = sc.next();
		
		//Dependiendo del OS carga un comando u otro
		if (OS.equals("Windows 10")) {
			processBuilder.command("cmd.exe", "/c", "ipconfig /all");
			try {
				Process process = processBuilder.start();
				BufferedReader buffer = new BufferedReader(
		                new InputStreamReader(process.getInputStream()));
				String line;
		        boolean foundAdapter = false;
		        
		        //Mira línea por línea en búsqueda de "Ethernet adapter " + (nombre de la variable introducido)
		        while ((line = buffer.readLine()) != null) {
		            line = line.trim();
		            if (line.equals("Ethernet adapter " + adapterName + ':')) {
		                foundAdapter = true;
		                break;
		            }
		        }
		        if (!foundAdapter) {
		            throw new IOException("No se encuentra el adaptador");
		        }

		        //Busca la MAC en la sección encontrada
		        ArrayList<String> ips = new ArrayList<String>();
		        while ((line = buffer.readLine()) != null) {
		            if (line.length() > 0 && line.charAt(0) != ' ') {
		                break;
		            }
		            line = line.trim();

		            //Extrae la MAC
		            if (line.startsWith("Physical Address")) {

		                int colonIndex;
		                if ((colonIndex = line.indexOf(':')) != 1) {
		                    ips.add(line.substring(colonIndex + 2));
		                }
		            }
		        }
		        System.out.println(ips);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}else {
			processBuilder.command("/bin/bash", "-c", "cat //sys//class//net//"+adapterName+"//address");
			try {
				Process process = processBuilder.start();
				StringBuilder buffer = new StringBuilder();
				BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String linea;
				while((linea = reader.readLine()) != null) {
					buffer.append(linea + "\n");
					try {
						if (process.waitFor() == 0) {
							System.out.println(buffer);
						} else {
							System.out.println("No se ha encontrado su direccion IP");
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
	/**
	 * Muestra por consola sin el dispostivo tiene internet
	 * mediante el uso de comandos
	 */
	public static void testInternet() {
		if(OS.equals("Windows 10")) {
			processBuilder.command("cmd.exe", "/c", "ping -n 1 8.8.8.8");
		}else {
			processBuilder.command("/bin/bash", "-c", "ping -c 1 8.8.8.8");
		}
		
		try {
			Process process = processBuilder.start();
			BufferedReader buffer = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			Boolean tieneInternet = false;

	        while ((line = buffer.readLine()) != null) {
	            line = line.trim();
	            if (line.equals("Packets: Sent = 1, Received = 1, Lost = 0 (0% loss),") || line.equals("1 packets transmitted, 1 received, 0% packet loss")) {
	            	tieneInternet = true;
	            	break;
	            }
	        }
	        
	        if(tieneInternet) {
	        	System.out.println("Tienes internet");
	        }else {
	        	System.out.println("NO tienes internet");
	        }
	        
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
