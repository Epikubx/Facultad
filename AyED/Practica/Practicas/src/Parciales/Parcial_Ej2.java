package Parciales;

import tp03.ejercicio1.*;

public class Parcial_Ej2 {
	
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
		System.out.println(sumalmparesPosOrderMayorA(arbol, 35));
	}
	
	public static Integer sumalmparesPosOrderMayorA(ArbolBinario<Integer> ab, int limite){
		int suma = 0;
		if(ab.tieneHijoIzquierdo()){
			suma += sumalmparesPosOrderMayorA(ab.getHijoIzquierdo(), limite);
		}
		if(ab.tieneHijoDerecho()){
			suma += sumalmparesPosOrderMayorA(ab.getHijoDerecho(), limite);
		}
		if(ab.getDato() % 2  != 0 && ab.getDato() > limite){
			suma += ab.getDato();
		}
		return suma;
	}
}
