package Parciales;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Parcial_Ej11 {

	public static void main(String[] args) {
		/*
		 *   Arbol Binario de Ejemplo:
		 * 
		 *           <- 41 ->
		 *    20               12
		 * 65    99        91      50
		 *          32          72    28
		 */
		ArbolBinario<Integer> arbol = new ArbolBinario<Integer>(41);
		arbol.agregarHijoIzquierdo(new ArbolBinario<Integer>(20));
		arbol.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Integer>(65));
		arbol.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(99));
		arbol.getHijoIzquierdo().getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Integer>(32));
		arbol.agregarHijoDerecho(new ArbolBinario<Integer>(12));
		arbol.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Integer>(91));
		arbol.getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Integer>(50));
		arbol.getHijoDerecho().getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Integer>(72));
		arbol.getHijoDerecho().getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Integer>(28));
		System.out.println(resolver(arbol).toString());
	}
	
	/*
	 *   Arbol Binario de Ejemplo:
	 * 
	 *           <- 41 ->
	 *    20               12
	 * 65    99        91      50
	 *          32          72    28
	 */
	
	public static ListaEnlazadaGenerica<Integer> resolver(ArbolBinario<Integer> ab){
		ListaEnlazadaGenerica<Integer> listaFin = new ListaEnlazadaGenerica<Integer>();
		resolver_recursivo(ab, listaFin);
		return listaFin;
	}
	
	public static ListaEnlazadaGenerica<Integer> resolver_recursivo(ArbolBinario<Integer> ab, ListaEnlazadaGenerica<Integer> listaFin){
		ListaEnlazadaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		ListaEnlazadaGenerica<Integer> aux;
		int cantHI = 0;
		int cantHD = 0;
		lista.agregarFinal(ab.getDato());
		if(ab.tieneHijoIzquierdo()){
			aux = resolver_recursivo(ab.getHijoIzquierdo(), listaFin);
			cantHI += aux.tamanio();
			aux.comenzar();
			while(!aux.fin()){
				lista.agregarFinal(aux.proximo());
			}
		}
		if(ab.tieneHijoDerecho()){
			aux = resolver_recursivo(ab.getHijoDerecho(), listaFin);
			cantHD += aux.tamanio();
			aux.comenzar();
			while(!aux.fin()){
				lista.agregarFinal(aux.proximo());
			}
		}
		if(cantHI == cantHD && cantHD != 0){
			listaFin.agregarFinal(ab.getDato());
		}
		return lista;
	}
}
