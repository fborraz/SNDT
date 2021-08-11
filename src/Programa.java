import java.util.Scanner;

public class Programa {
	static Scanner teclado = new Scanner(System.in);
	public static void main (String args[]) {
		String hijo = null;
		String padre = null;
		String node = null;
		int opcionModulos, opcionAdmin, opcionConsulta;
		String nombreDominio, nombreDominio2 = null;
		int opTipoMetabolismo, opTipoReproduccion;
		String tipoMetabolismo = null, tipoReproduccion = null;
		
		System.out.println("*****************************************");
		System.out.println("Sistema de Nombres de Dominio Taxonómico");
		System.out.println("*****************************************");
		System.out.println("\n");
		Arbol arbol = new Arbol();
		Hoja root = arbol.enviarNodoRaiz();
		
		do {
			System.out.println("Ingrese la opción\n"
					+ "1- Módulo de administracion\n"
					+ "2- Modulo de consultas\n"
					+ "3- Salir\n");
			opcionModulos = teclado.nextInt();
		
			if(opcionModulos == 1){
				do {
					System.out.println("*****************************************");
					System.out.println("Módulo de administración");
					System.out.println("*****************************************\n");
					System.out.println("Opciones");
					System.out.println("------------------------------------------\n");
					System.out.println("1- Ingreso y almacenamiento de nombres de dominio taxonomico\n"
							+ "2- Eliminacion de nombres de especies\n"
							+ "3- Volver atrás\n");
					
					opcionAdmin = teclado.nextInt();
					
					switch(opcionAdmin) {
						case 1:
							System.out.println("Ingrese nombre de dominio taxonómico: ");
							nombreDominio = teclado.next();
							
							
							System.out.println("Ingrese tipo de reproduccion:\n"
									+ "1- Sexual\n"
									+ "2- Asexual\n");
							opTipoReproduccion = teclado.nextInt();
							
							if(opTipoReproduccion == 1) {
								tipoReproduccion = "sexual";
							}
							else if(opTipoReproduccion == 2) {
								tipoReproduccion = "asexual";
							}
							
							System.out.println("Ingrese tipo de metabolismo:\n"
									+ "1- Anábolico\n"
									+ "2- Catabólico\n");
							
							opTipoMetabolismo = teclado.nextInt();
							if(opTipoMetabolismo == 1) {
								tipoMetabolismo = "anabolico";
							}
							else if(opTipoMetabolismo == 2) {
								tipoMetabolismo = "catabolico";
							}
							
							nombreDominio2 = "null." + nombreDominio;
							String [] categorias = nombreDominio2.split("\\.");
							for(int i = 1; i < categorias.length; i++) {
								hijo = categorias[i];
								padre = categorias[i-1];
								if(padre.equals("null")) {
									root.insertarHijo(new Hoja(hijo, root, null, null));
									arbol.setControl(true);
								}
								else {
									if(i == 7) {
										root = arbol.agregarHijo(hijo, padre, root, tipoReproduccion, tipoMetabolismo);
										System.out.println("El tipo de reproduccion y metabolismo fue agregado correctamente");
									}
									else{
										root = arbol.agregarHijo(hijo, padre, root, null, null);
									}
									
								}
								if (arbol.isControl()){
									System.out.println("El nodo ha sido añadido correctamente.");
									arbol.setControl(false);
								}else{
									System.out.println("El padre no ha sido encontrado.");
								}
							}
							
							break;
						case 2:
							System.out.println( "Inserta el nombre del nodo a borrar: " );
							node = teclado.next();
							arbol.eliminarNodo(node,root);
							if (arbol.isControl()){
								System.out.println("El nodo ha sido eliminado.");
								arbol.setControl(false);
							}else{
								System.out.println("El nodo no ha sido encontrado.");
							}
							break;
						default:
							System.out.println("Opción incorrecta");
						}
				}while(opcionAdmin != 3);
		
			}
			else if(opcionModulos == 2) {
				System.out.println("Módulo de consultas\n"
						+ "Ingrese una opcion\n"
						+ "1- Imprimir tipo de reproduccion y metabolismo de una especie\n"
						+ "2- Imprimir especies dependientes de una clase\n"
						+ "3- Imprimir categorias taxonomicas de una determinada profundidad\n"
						+ "4- Volver\n");
				opcionConsulta = teclado.nextInt();
				if(opcionConsulta == 1) {
					System.out.println("Ingrese el nombre de una especie: ");
					String especie = teclado.next();
					System.out.println("Propiedades de la especie " + especie + ".\n");
					System.out.println("--------------------------------------------\n");
					arbol.imprimirCaracteristicasEspecie(especie, root);
					
					
				}
				else if(opcionConsulta == 2) {
					System.out.println("Ingrese nombre dominio taxonomico correspondiente a una clase: \n");
					String nomDomTaxClase = teclado.next();
					System.out.println("Listado de especies dependientes de la clase " + nomDomTaxClase + "\n");
					System.out.println("-----------------------------------------------------------------\n");
					Hoja claseHoja = arbol.getNodoClase(nomDomTaxClase, root);
					arbol.mostrarEspecies(claseHoja);
				}
				else if(opcionConsulta == 3) {
					System.out.println("Ingrese profundidad: ");
					int prof = teclado.nextInt();
					
					System.out.println("Listado de categorías taxonómicas ubicadas en el nivel " + prof + ".\n");
					System.out.println("----------------------------------------------------------------------\n");
					arbol.imprimirNodosProfundidad(root, prof);
				}
				else if(opcionConsulta == 4) {
					
				}
			}
		}while(opcionModulos != 3);
			System.out.println("Terminado");
			
		}
	
		}