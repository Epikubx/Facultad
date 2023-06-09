package Parciales;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ListaParcial {
	private ListaGenerica<ArbolBinario<Integer>> lista;
	private int pares;
	
	public ListaParcial(){
		lista = new ListaEnlazadaGenerica<ArbolBinario<Integer>>();
		pares = 0;
	}
	
	public ListaGenerica<ArbolBinario<Integer>> getLista(){
		return lista;
	}
	
	public int getPares(){
		return pares;
	}
	
	public void setPares(int pares){
		this.pares = pares;
	}
	
	public void setLista(ListaGenerica<ArbolBinario<Integer>> lista){
		this.lista = lista;
	}
	
	public String toString(){
		String str = "Pares: " + pares;
		str += "\n";
		lista.comenzar();
		while(!lista.fin()){
			str += lista.proximo().toString() + " => ";
		}
		return str;
	}
}
