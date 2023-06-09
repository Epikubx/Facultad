package Parciales;

import tp03.ejercicio1.ArbolBinario;

public class Parcial_Ej10 {

	public static void main(String[] args) {
		/*
		 *   Arbol Binario de Ejemplo:
		 * 
		 *             41
		 *    20               12
		 * 65    99        91      50
		 *          32          72    28 
		 *          
		 *           2
		 *    2             0
		 * 2     2       4     4
		 */
		ArbolBinario<Integer> arbol = new ArbolBinario<Integer>(2);
		arbol.agregarHijoIzquierdo(new ArbolBinario<Integer>(2));
		arbol.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Integer>(2));
		arbol.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(2));
		//arbol.getHijoIzquierdo().getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Integer>(32));
		arbol.agregarHijoDerecho(new ArbolBinario<Integer>(0));
		arbol.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Integer>(4));
		arbol.getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Integer>(4));
		//arbol.getHijoDerecho().getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Integer>(72));
		//arbol.getHijoDerecho().getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Integer>(28));
		System.out.println(monoDistante(arbol, 6));
	}
	
	public static boolean monoDistante(ArbolBinario<Integer> ar, int x){
		x -= ar.getDato();
		if(ar.esHoja() && x == 0){
			return true;
		}
		boolean nodos = false;
		if(ar.tieneHijoIzquierdo()){
			nodos = monoDistante(ar.getHijoIzquierdo(), x);
		}
		if(ar.tieneHijoIzquierdo()){
			nodos = monoDistante(ar.getHijoIzquierdo(), x);
		}
		return nodos;
	}
	
	public static boolean monoDistante_2(ArbolBinario<Integer> ar, int x, int cant){
		cant += ar.getDato();
		if(ar.esHoja() && cant == x){
			return true;
		}
		boolean nodos = false;
		if(ar.tieneHijoIzquierdo()){
			nodos = monoDistante_2(ar.getHijoIzquierdo(), x, cant);
		}
		if(ar.tieneHijoIzquierdo()){
			nodos = monoDistante_2(ar.getHijoIzquierdo(), x, cant);
		}
		return nodos;
	}
}
