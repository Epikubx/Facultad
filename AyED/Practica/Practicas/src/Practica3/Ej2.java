package Practica3;
//import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio1.*;

public class Ej2
{
	public static void main(String[] args)
	{
		ArbolBinario<Integer> arbol = new ArbolBinario<Integer>(1);
		agregarIzq(arbol, 2);
		agregarIzq(arbol, 4);
		arbol.getHijoIzquierdo().agregarHijoDerecho(crearNodo(5));
		arbol.agregarHijoDerecho(crearNodo(3));
		arbol.getHijoDerecho().agregarHijoDerecho(crearNodo(6));
		//arbol.entreNiveles(1, 3);
		System.out.println("Cant Hojas " + arbol.contarHojas());
		System.out.println("CantNodos " + arbol.contarNodos());
		System.out.println("Suma Total " + arbol.totalDatos());
		/*ContadorArbol contador = new ContadorArbol(arbol);
		ColaGenerica<Integer> cola;
		cola = contador.numerosPares_inOrden();
		printCola(cola);
		cola = contador.numerosPares_postOrden();
		printCola(cola);*/
		ProfundidadDeArbolBinario prof = new ProfundidadDeArbolBinario(arbol);
		System.out.println(prof.sumaElementosProfundidad(2));
		//4 5 2 6 3 1 = 21
	}
	
	private static ArbolBinario<Integer> crearNodo(Integer dato){
		return new ArbolBinario<Integer>(dato);
	}
	
	/*private static void printCola(ColaGenerica<Integer> cola){
		System.out.println("<Print Cola>");
		while(!cola.esVacia()){
			int value = cola.desencolar();
			System.out.print(value + " ");
		}
		System.out.println();
	}*/
	
	private static void agregarIzq(ArbolBinario<Integer> arbol, Integer dato){
		ArbolBinario<Integer> init = arbol;
		while(!arbol.esHoja()){
			arbol = arbol.getHijoIzquierdo();
		}
		arbol.agregarHijoIzquierdo(crearNodo(dato));
		arbol = init;
	}
	
	/*private static void agregar(ArbolBinario<Integer> arbol, Integer dato)
	{
		if(arbol != null){
			if(dato < arbol.getDato()){
				if(arbol.getHijoIzquierdo() == null){
					arbol.agregarHijoIzquierdo(crearNodo(dato));
				}else{
					agregar(arbol.getHijoIzquierdo(), dato);
				}
			}else{
				if(arbol.getHijoDerecho() == null){
					arbol.agregarHijoDerecho(crearNodo(dato));
				}else{
					agregar(arbol.getHijoDerecho(), dato);
				}
			}
		}else{
			arbol = crearNodo(dato);
		}
	}*/
	
	/*
	private static void agregar(ArbolBinario<Integer> arbol, Integer dato)
	{
		if(!arbol.esVacio()){
			if(dato < arbol.getDato()){
				if(arbol.getHijoIzquierdo() == null){
					arbol.agregarHijoIzquierdo(crearNodo(dato));
				}else{
					agregar(arbol.getHijoIzquierdo(), dato);
				}
			}else{
				if(arbol.getHijoDerecho() == null){
					arbol.agregarHijoDerecho(crearNodo(dato));
				}else{
					agregar(arbol.getHijoDerecho(), dato);
				}
			}
		}else{
			arbol = crearNodo(dato);
		}
	}*/
	
}