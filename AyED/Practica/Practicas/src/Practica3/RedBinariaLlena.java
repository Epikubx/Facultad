package Practica3;

import tp03.ejercicio1.*;

public class RedBinariaLlena {

	private ArbolBinario<Integer> arbol;
	
	public RedBinariaLlena(ArbolBinario<Integer> arbol){
		this.arbol = arbol;
	}
	
	public int retardoReenvio(){
		if(arbol.esHoja()){
			return 0;//no cuento las hojas
		}
		int retardoHijoIzquierdo = 0;
		int retardoHijoDerecho = 0;
		if(arbol.tieneHijoIzquierdo()){
			retardoHijoIzquierdo += new RedBinariaLlena(arbol.getHijoIzquierdo()).retardoReenvio();
		}
		if(arbol.tieneHijoDerecho()){
			retardoHijoDerecho += new RedBinariaLlena(arbol.getHijoDerecho()).retardoReenvio();
		}
		return arbol.getDato() + (retardoHijoDerecho > retardoHijoIzquierdo ? retardoHijoDerecho : retardoHijoIzquierdo);
	}
}