
public class Arbol {
		Hoja nodoClase = null;
		private boolean control;
				
		public Arbol(){}
			public boolean isControl() {
				return control;
		}
		
		public void setControl(boolean control) {
			this.control = control;
		}
		
		public Hoja agregarHijo(String nombreHijo, String nombrePadre , Hoja nodoRaiz, String tipoReproduccion, String tipoMetabolismo){
			for(int i=0; i<nodoRaiz.getHijos().size(); i++){
				Hoja nodoP = nodoRaiz.getHijos().get(i);
				if(nodoP.getNombre().equals(nombrePadre)){
					nodoP.insertarHijo(new Hoja(nombreHijo, nodoP, tipoReproduccion, tipoMetabolismo));
					control = true;
					break;
				}
				if (nodoP.getHijos().size() != 0){
					agregarHijo(nombreHijo, nombrePadre, nodoP, tipoReproduccion, tipoMetabolismo);
				}
			}
			return nodoRaiz;
		}
		
		
		public void imprimirNodosProfundidad(Hoja nodo, int k)  
	    { 
	        if (nodo == null) 
	            return; 
	        if (k == 0)  
	        { 
	            System.out.print(nodo.getNombre() + " "); 
	            return; 
	        }  
	        else 
	        { 
	        	for (int i = 0; i < nodo.getHijos().size(); i++) {
	        		imprimirNodosProfundidad(nodo.getHijos().get(i), k - 1);
				}
	        } 
	    }
		
		
		public void imprimirCaracteristicasEspecie(String nodo, Hoja nodoRaiz) {
			for(int i=0; i<nodoRaiz.getHijos().size();i++) {
				Hoja nodoP = nodoRaiz.getHijos().get(i);
				if(nodoP.getNombre().equals(nodo)) {
					System.out.println("Especie: " + nodoP.getNombre() + "\n"
									 + "Tipo de metabolismo: " + nodoP.getTipoMetabolismo() + "\n"
									 + "Tipo de reproducción: " + nodoP.getTipoReproduccion() + "\n");
					control = true;
					break;
				}
				imprimirCaracteristicasEspecie(nodo, nodoP);
			}
		}
		
		public Hoja getNodoClase(String nodo, Hoja nodoRaiz){
			for (int i = 0; i < nodoRaiz.getHijos().size(); i++) {
				Hoja nodoP = nodoRaiz.getHijos().get(i);
				if(nodoP.getNombre().equals(nodo)) {
					nodoClase = nodoP;
					break;
				}else {
					getNodoClase(nodo, nodoP);	
				}	
			}
			return nodoClase;
		}
		
		public void mostrarEspecies(Hoja nodo) {
			for (int i = 0; i < nodo.getHijos().size(); i++) {
				Hoja nodoP = nodo.getHijos().get(i);
				if (nodoP.getHijos().size() != 0) {
					mostrarEspecies(nodoP);
				}
				else {
					System.out.println("" + nodoP.getNombre() + ("\n"));
				}
			}
		}

		public void eliminarNodo(String nodo, Hoja nodoRaiz){
			for(int i=0; i<nodoRaiz.getHijos().size(); i++){
				Hoja nodoP = nodoRaiz.getHijos().get(i);
				if(nodoP.getNombre().equals(nodo)){
					nodoRaiz.getHijos().remove(i);
					control = true;
					break;
				}
				eliminarNodo(nodo, nodoP);
			}
		}
		
		public Hoja enviarNodoRaiz(){
			Hoja root = new Hoja("RootNode", null, null, null);
			return root;
		}	
}