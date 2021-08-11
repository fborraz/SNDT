import java.util.ArrayList;



public class Hoja {
	private String nombre;
	private Hoja padre;
	private String tipoMetabolismo, tipoReproduccion = null;
	
	public ArrayList<Hoja> hijos = null;
	
	public Hoja(String nombre, Hoja padre, String tipoReproduccion, String tipoMetabolismo){
		this.nombre = nombre;
		this.padre = padre;
		this.tipoReproduccion = tipoReproduccion;
		this.tipoMetabolismo = tipoMetabolismo;
		hijos = new ArrayList<Hoja>();
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setPadre(Hoja padre) {
		this.padre = padre;
	}
	
	public Hoja getPadre() {
		return padre;
	}
	
	public void setHijos(ArrayList<Hoja> hijos) {
		this.hijos = hijos;
	}
	
	public ArrayList<Hoja> getHijos(){
		return hijos;
	}
	
	public void insertarHijo(Hoja node) {
		if (!this.hijos.contains(node)){
			this.hijos.add(node);
		}
	}
	
	public int ContainsNode(Hoja node){
		for(int i=0; i<this.hijos.size(); i++){
			if(this.hijos.get(i).getNombre().equals(node.getNombre())){
				return i;
			}
		}
		return -1;
	}

	public String getTipoMetabolismo() {
		return tipoMetabolismo;
	}

	public void setTipoMetabolismo(String tipoMetabolismo) {
		this.tipoMetabolismo = tipoMetabolismo;
	}

	public String getTipoReproduccion() {
		return tipoReproduccion;
	}

	public void setTipoReproduccion(String tipoReproduccion) {
		this.tipoReproduccion = tipoReproduccion;
	}
	
	
	
}
