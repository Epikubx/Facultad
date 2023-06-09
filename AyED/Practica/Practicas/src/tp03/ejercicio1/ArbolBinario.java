package tp03.ejercicio1;

import tp02.ejercicio3.ColaGenerica;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 
	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());
	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	public int contarHojas()
	{
		if(this.esHoja()){
			return 1;
		}
		int cantHojas = 0;
		if(this.tieneHijoIzquierdo()){
			cantHojas += this.getHijoIzquierdo().contarHojas();
		}
		if(this.tieneHijoDerecho()){
			cantHojas += this.getHijoDerecho().contarHojas();
		}
		return cantHojas;
	}
	
	public int contarNodos()
	{
		if(this.esVacio()){
			return 0;//caso arbol vac�o
		}
		if(this.esHoja()){
			return 1;//llego al �ltimo nodo, caso baso (retorno porque sino error)
		}
		int cantNodos = 1;//me cuento a mi mismo
		if(this.tieneHijoIzquierdo()){
			cantNodos += this.getHijoIzquierdo().contarNodos();
		}
		if(this.tieneHijoDerecho()){
			cantNodos += this.getHijoDerecho().contarNodos();
		}
		return cantNodos;
	}
	
	public int totalDatos()
	{
		if(this.esVacio()){
			return 0;//caso arbol vac�o
		}
		int cantTotal = 0;
		if(this.tieneHijoIzquierdo()){
			cantTotal += this.getHijoIzquierdo().totalDatos();
		}
		if(this.tieneHijoDerecho()){
			cantTotal += this.getHijoDerecho().totalDatos();
		}
		return (Integer) this.getDato() + cantTotal;
	}

    public ArbolBinario<T> espejo()
    {
    	ArbolBinario<T> arbol = new ArbolBinario<T>(this.getDato());
    	//si no tiene hijos, regresa un nodo con el dato (ser�a la hoja)
    	if(this.tieneHijoIzquierdo()){
    		arbol.agregarHijoDerecho(this.hijoIzquierdo.espejo());
    	}
    	if(this.tieneHijoDerecho()){
    		arbol.agregarHijoIzquierdo(this.hijoDerecho.espejo());
    	}
    	return arbol;
	}

    public void entreNiveles(int n, int m)
    {
    	ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
    	cola.encolar(this);
    	cola.encolar(null);
    	int level = 1;
    	while(!cola.esVacia()){
    		ArbolBinario<T> nodo = cola.desencolar();
    		if(nodo != null){
    			if(level >= n && level <= m){
    				System.out.println(nodo.getDato());
    			}
    			if(nodo.tieneHijoIzquierdo()){
    				cola.encolar(nodo.getHijoIzquierdo());
    			}
    			if(nodo.tieneHijoDerecho()){
    				cola.encolar(nodo.getHijoDerecho());
    			}
    		}else{
    			level++;
    			cola.encolar(null);
    		}
    	}
    }
}