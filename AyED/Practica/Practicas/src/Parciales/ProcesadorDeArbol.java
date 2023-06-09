package Parciales;

import tp03.ejercicio1.ArbolBinario;

public class ProcesadorDeArbol {
	
	private ArbolBinario<Integer> arbol;
	
	public ProcesadorDeArbol(ArbolBinario<Integer> arbol){
		this.arbol = arbol;
	}
	
	public ListaParcial procesar()
	{
		//Pre orden: Ver Izq Der
		ListaParcial lista = new ListaParcial();
		ListaParcial aux;
		if(arbol.getDato() % 2 == 0){
			if(arbol.tieneHijoDerecho() && arbol.tieneHijoIzquierdo()){
				lista.getLista().agregarFinal(arbol);
			}
			lista.setPares(lista.getPares() + 1);
		}
		if(arbol.tieneHijoIzquierdo()){
			aux = new ProcesadorDeArbol(arbol.getHijoIzquierdo()).procesar();
			aux.getLista().comenzar();
			lista.setPares(lista.getPares() + aux.getPares());
			while(!aux.getLista().fin()){
				lista.getLista().agregarFinal(aux.getLista().proximo());
			}
		}
		if(arbol.tieneHijoDerecho()){
			aux = new ProcesadorDeArbol(arbol.getHijoDerecho()).procesar();
			aux.getLista().comenzar();
			lista.setPares(lista.getPares() + aux.getPares());
			while(!aux.getLista().fin()){
				lista.getLista().agregarFinal(aux.getLista().proximo());
			}
		}
		return lista;
	}
	
	public ListaParcial2 procesar_2()
	{
		//Post orden: Izq Der Ver
		ListaParcial2 lista = new ListaParcial2();
		ListaParcial2 aux;
		if(arbol.tieneHijoIzquierdo()){
			aux = new ProcesadorDeArbol(arbol.getHijoIzquierdo()).procesar_2();
			aux.getLista().comenzar();
			lista.setImpares(lista.getImpares() + aux.getImpares());
			while(!aux.getLista().fin()){
				lista.getLista().agregarFinal(aux.getLista().proximo());
			}
		}
		if(arbol.tieneHijoDerecho()){
			aux = new ProcesadorDeArbol(arbol.getHijoDerecho()).procesar_2();
			aux.getLista().comenzar();
			lista.setImpares(lista.getImpares() + aux.getImpares());
			while(!aux.getLista().fin()){
				lista.getLista().agregarFinal(aux.getLista().proximo());
			}
		}
		if(arbol.getDato() % 2 != 0){
			if(arbol.tieneHijoDerecho() != arbol.tieneHijoIzquierdo()){
				lista.getLista().agregarFinal(arbol.getDato());
			}
			lista.setImpares(lista.getImpares() + 1);
		}
		return lista;
	}
}
