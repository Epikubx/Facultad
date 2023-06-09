package Parciales;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Parcial_Ej3 {

	private static ArbolGeneral<Integer> arbol;
	
	public static void main(String[] args) {
		
	}
	
	public Parcial_Ej3(ArbolGeneral<Integer> arbol){
		//this.arbol = arbol;
	}
	
	public static ListaGenerica<Integer> resolver(){
		ListaEnlazadaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		resolver_helper(arbol, lista);
		return lista;
	}
	
	public static void resolver_helper(ArbolGeneral<Integer> ab, ListaEnlazadaGenerica<Integer> lista){
		ListaGenerica<ArbolGeneral<Integer>> hijos = ab.getHijos();
		hijos.comenzar();
		while(!hijos.fin()){
			resolver_helper(hijos.proximo(), lista);
		}
		if(hijos.tamanio() % 2 != 0){
			hijos.comenzar();
			int count = 0;
			while(!hijos.fin()){
				count += hijos.proximo().getDato();
			}
			lista.agregarFinal(count);
		}
	}
}
