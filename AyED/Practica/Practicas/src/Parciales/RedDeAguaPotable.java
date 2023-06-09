package Parciales;

import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class RedDeAguaPotable {

	private ArbolGeneral<Integer> arbol;
	
	public RedDeAguaPotable(ArbolGeneral<Integer> arbol){
		this.arbol = arbol;
	}
	
	public double minimoCaudal(double caudal){
		if(arbol.esHoja()){
			return caudal;
		}
		double min = 999;
		ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
		hijos.comenzar();
		while(!hijos.fin()){
			double cantHijos = new RedDeAguaPotable(hijos.proximo()).minimoCaudal(arbol.getDato()/hijos.tamanio());
			if(cantHijos < min){
				min = cantHijos;
			}
		}
		return min;
	}
}
