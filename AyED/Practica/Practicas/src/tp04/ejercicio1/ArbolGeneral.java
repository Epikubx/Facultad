package tp04.ejercicio1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {
		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {
		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {
		return this.dato == null && !this.tieneHijos();
	}

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public Boolean esAncestro_2(T a, T b){
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		cola.encolar(this);
		cola.encolar(null);
		boolean tengo_a = false;
		boolean tengo_b = false;
		while(!cola.esVacia() && (!tengo_a || !tengo_b)){
			ArbolGeneral<T> elem = cola.desencolar();
			if(elem != null){
				if(elem.getDato() == a){
					tengo_a = true;
				}
				if(tengo_a && elem.getDato() == b){
					tengo_b = true;
				}
				ListaGenerica<ArbolGeneral<T>> hijos = elem.getHijos();
				while(!hijos.fin()){
					cola.encolar(hijos.proximo());
				}
			}else if(!cola.esVacia()){
				cola.encolar(null);
			}
		}
		return tengo_a && tengo_b;
	}
	
	public Boolean esAncestro(T a, T b){
		ArbolGeneral<T> nodoA = buscarNodo(a);
		ArbolGeneral<T> nodoB = buscarNodo(b);
		return nodoA.altura() > nodoB.altura();
	}
	
	public ArbolGeneral<T> buscarNodo(T dato){
		if(this.getDato() == dato){
			return this;
		}
		ArbolGeneral<T> retVal = null;
		hijos.comenzar();
		while(!hijos.fin() && retVal == null){
			retVal = hijos.proximo().buscarNodo(dato);
		}
		return retVal;
	}
	
	public Integer altura() {
		int cant = 0;
		int max = -999;
		if(this.esHoja() || this.esVacio()){
			return 0;
		}
		hijos.comenzar();
		while(!hijos.fin()){
			cant = 1 + hijos.proximo().altura();
			if(cant > max){
				max = cant;
			}
		}
		return max;
	}

	public Integer nivel(T dato) {
		if(this.getDato() == dato){
			return 1;
		}
		boolean found = false;
		hijos.comenzar();
		while(!hijos.fin() && !found){
			int datoHijo = this.hijos.proximo().nivel(dato);
			if(datoHijo != -1){
				found = true;
				return datoHijo + 1;
			}
		}
		return -1;
	}

	public Integer ancho() {
		int max = -999;
		int cantHijosNivel = 0;
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		cola.encolar(this);
		cola.encolar(null);
		while(!cola.esVacia()){
			ArbolGeneral<T> elem = cola.desencolar();
			if(elem != null){
				cantHijosNivel++;
				ListaGenerica<ArbolGeneral<T>> hijos = elem.getHijos();
				hijos.comenzar();
				while(!hijos.fin()){
					cola.encolar(hijos.proximo());
				}
			}else if(!cola.esVacia()){
				if(cantHijosNivel > max){
					max = cantHijosNivel;
				}
				cantHijosNivel = 0;
				cola.encolar(null);
			}
		}
		return max;
	}
}