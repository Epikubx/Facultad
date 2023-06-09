package Parciales;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Parcial_Ej5 {

	public static void main(String[] args) {
		/*
		 *   Arbol Binario de Ejemplo:
		 * 
		 *	           <- 7 ->
		 *	      56              25
		 *	 38      31         5    6
		 *87    77	    94
		 *    16		   2
		 *    	 43			 1
		 *      9  10	   
		 */
		ArbolBinario<Integer> arbol = new ArbolBinario<Integer>(7);
		arbol.agregarHijoIzquierdo(new ArbolBinario<Integer>(56));
		
		arbol.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Integer>(38));
		arbol.getHijoIzquierdo().getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Integer>(87));
		arbol.getHijoIzquierdo().getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(77));
		arbol.getHijoIzquierdo().getHijoIzquierdo().getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Integer>(16));
		arbol.getHijoIzquierdo().getHijoIzquierdo().getHijoDerecho().getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(43));
		arbol.getHijoIzquierdo().getHijoIzquierdo().getHijoDerecho().getHijoIzquierdo().getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Integer>(9));
		arbol.getHijoIzquierdo().getHijoIzquierdo().getHijoDerecho().getHijoIzquierdo().getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Integer>(10));
		
		arbol.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(31));
		arbol.getHijoIzquierdo().getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Integer>(94));
		arbol.getHijoIzquierdo().getHijoDerecho().getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Integer>(2));
		arbol.getHijoIzquierdo().getHijoDerecho().getHijoDerecho().getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Integer>(1));
		
		arbol.agregarHijoDerecho(new ArbolBinario<Integer>(25));
		arbol.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Integer>(5));
		arbol.getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Integer>(6));
		ListaGenerica<Integer> lista = resolver(arbol, 3);
		lista.comenzar();
		while(!lista.fin()){
			System.out.print(lista.proximo() + " => ");
		}
	}
	
	public static ListaGenerica<Integer> resolver(ArbolBinario<Integer> ab, int min){
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		if(!ab.esVacio()){
			resolverAux(ab, min, lista);
		}
		return lista;
	}
	
	public static boolean resolverAux(ArbolBinario<Integer> ab, int min, ListaGenerica<Integer> lista){
		boolean fin = false;
		lista.agregarFinal(ab.getDato());
		if(ab.getDato() % 2 == 0){
			min--;
		}
		if(ab.esHoja() && min <= 0){
			return true;
		}
		if(ab.tieneHijoIzquierdo()){
			fin = resolverAux(ab.getHijoIzquierdo(), min, lista);
		}
		if(ab.tieneHijoDerecho() && !fin){
			fin = resolverAux(ab.getHijoDerecho(), min, lista);
		}
		if(!fin){
			lista.eliminarEn(lista.tamanio());
		}
		return fin;
	}
}
