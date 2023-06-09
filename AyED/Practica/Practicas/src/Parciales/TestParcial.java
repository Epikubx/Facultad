package Parciales;

import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class TestParcial
{
	public static void main(String [] args){
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
		/*ProcesadorDeArbol parcial = new ProcesadorDeArbol(arbol);
		ListaParcial list = parcial.procesar();
		list.getLista().comenzar();
		System.out.print(list.toString());*/
		Parcial p = new Parcial();
		ListaGenerica<Integer> list = p.resolver(arbol, 3);
		list.comenzar();
		while(!list.fin()){
			System.out.print(list.proximo() + " => ");
		}
	}
}
