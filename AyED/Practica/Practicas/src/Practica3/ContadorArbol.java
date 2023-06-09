package Practica3;
import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio1.*;
public class ContadorArbol {

	private ArbolBinario<Integer> arbol;
	
	public ContadorArbol(ArbolBinario<Integer> arbol){
		this.arbol = arbol;
	}
	
	/*public PilaGenerica<Integer> numerosPares_pila(){
		PilaGenerica<Integer> pila = new PilaGenerica<Integer>();
		inOrden_pila(arbol, pila);
		return pila;
	}
	
	private void inOrden_pila(ArbolBinario<Integer> arbol, PilaGenerica<Integer> pila){
		if(arbol.getDato() % 2 == 0){
			pila.apilar(arbol.getDato());
		}
		if(arbol.tieneHijoIzquierdo()){
			inOrden(arbol.getHijoIzquierdo(), pila);
		}
		if(arbol.tieneHijoDerecho()){
			inOrden(arbol.getHijoDerecho(), pila);
		}
	}
	*/
	
	public ColaGenerica<Integer> numerosPares_inOrden(){
		ColaGenerica<Integer> cola = new ColaGenerica<Integer>();
		inOrden(arbol, cola);
		return cola;
	}
	
	public ColaGenerica<Integer> numerosPares_postOrden(){
		ColaGenerica<Integer> cola = new ColaGenerica<Integer>();
		postOrden(arbol, cola);
		return cola;
	}
	
	private void inOrden(ArbolBinario<Integer> arbol, ColaGenerica<Integer> cola){
		if(arbol.tieneHijoIzquierdo()){
			inOrden(arbol.getHijoIzquierdo(), cola);
		}
		if(arbol.getDato() != 0){
			cola.encolar(arbol.getDato());
		}
		if(arbol.tieneHijoDerecho()){
			inOrden(arbol.getHijoDerecho(), cola);
		}
	}
	
	private void postOrden(ArbolBinario<Integer> arbol, ColaGenerica<Integer> cola){
		if(arbol.tieneHijoIzquierdo()){
			postOrden(arbol.getHijoIzquierdo(), cola);
		}
		if(arbol.tieneHijoDerecho()){
			postOrden(arbol.getHijoDerecho(), cola);
		}
		if(arbol.getDato() != 0){
			cola.encolar(arbol.getDato());
		}
	}
}
