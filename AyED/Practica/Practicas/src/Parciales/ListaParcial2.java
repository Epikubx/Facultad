package Parciales;

import tp02.ejercicio1.*;

public class ListaParcial2 {
	private ListaDeEnterosEnlazada lista;
	private int impares;
	
	public ListaParcial2(){
		lista = new ListaDeEnterosEnlazada();
		impares = 0;
	}
	
	public ListaDeEnterosEnlazada getLista(){
		return lista;
	}
	
	public int getImpares(){
		return impares;
	}
	
	public void setImpares(int impares){
		this.impares = impares;
	}
	
	public void setLista(ListaDeEnterosEnlazada lista){
		this.lista = lista;
	}
	
	public String toString(){
		String str = "Impares: " + impares;
		str += "\n";
		lista.comenzar();
		while(!lista.fin()){
			str += lista.proximo() + " => ";
		}
		return str;
	}
}
