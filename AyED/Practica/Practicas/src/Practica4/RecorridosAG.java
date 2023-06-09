package Practica4;

import tp02.ejercicio2.*;
import tp02.ejercicio3.*;
import tp04.ejercicio1.ArbolGeneral;

public class RecorridosAG
{
	//private ArbolGeneral<Integer> arbol;
	
	public static void main(String[] args) {
		ArbolGeneral<Integer> arbol = new ArbolGeneral<Integer>(53);
		ArbolGeneral<Integer> aux;
		
		aux = new ArbolGeneral<Integer>(4);
		aux.agregarHijo(new ArbolGeneral<Integer>(19));
		aux.agregarHijo(new ArbolGeneral<Integer>(6));
		aux.agregarHijo(new ArbolGeneral<Integer>(33));
		arbol.agregarHijo(aux);
		
		aux = new ArbolGeneral<Integer>(77);
		aux.agregarHijo(new ArbolGeneral<Integer>(80));
		arbol.agregarHijo(aux);
		
		aux = new ArbolGeneral<Integer>(61);
		aux.agregarHijo(new ArbolGeneral<Integer>(15));
		aux.agregarHijo(new ArbolGeneral<Integer>(1));
		arbol.agregarHijo(aux);
		
		aux = new ArbolGeneral<Integer>(43);
		aux.agregarHijo(new ArbolGeneral<Integer>(68));
		aux.agregarHijo(new ArbolGeneral<Integer>(11));
		aux.agregarHijo(new ArbolGeneral<Integer>(51));
		aux.getHijos().comenzar();
		aux.getHijos().proximo().agregarHijo(new ArbolGeneral<Integer>(33));
		arbol.agregarHijo(aux);
		//53 19 6 33 77 80 61 15 1 4 68 11 51
		//ListaEnlazadaGenerica<Integer> list = (ListaEnlazadaGenerica<Integer>)numerosImparesMayoresQuePorNiveles(arbol, 1);
		//RedDeAguaPotable test = new RedDeAguaPotable(arbol);
		System.out.println(arbol.esAncestro_2(53,33));
	}
	
	private static boolean esImparMayor(int dato, int n){
		return dato % 2 != 0 && dato > n;
	}
	
	public static ListaGenerica<Integer> numerosImparesMayoresQuePreOrden(ArbolGeneral<Integer> a, Integer n){
		ListaGenerica<Integer> list = new ListaEnlazadaGenerica<Integer>();		
		ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
		if(esImparMayor(a.getDato(), n)){
			list.agregarFinal(a.getDato());
		}
		hijos.comenzar();
		while(!hijos.fin()){//si no tiene hijos, no entra
			ListaGenerica<Integer> lista = numerosImparesMayoresQuePreOrden(hijos.proximo(), n);
			lista.comenzar();
			while(!lista.fin()){
				list.agregarFinal(lista.proximo());
			}
		}
		return list;
	}
	
	public static ListaGenerica<Integer> numerosImparesMayoresQueInOrden(ArbolGeneral<Integer> a, Integer n){
		ListaGenerica<Integer> list = new ListaEnlazadaGenerica<Integer>();	
		ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
		hijos.comenzar();
		if(a.tieneHijos()){
			ListaGenerica<Integer> lista = numerosImparesMayoresQueInOrden(hijos.proximo(), n);
			lista.comenzar();
			while(!lista.fin()){
				list.agregarFinal(lista.proximo());
			}
		}
		list.agregarFinal(a.getDato());
		while(!hijos.fin()){
			//te da toda la otra rama de hijos y lo hace recursivo (o algo asi)
			ListaGenerica<Integer> lista = numerosImparesMayoresQueInOrden(hijos.proximo(), n);
			lista.comenzar();
			while(!lista.fin()){
				list.agregarFinal(lista.proximo());
			}
		}
		return list;
	}
	
	public static ListaGenerica<Integer> numerosImparesMayoresQuePostOrden(ArbolGeneral<Integer> a, Integer n){
		ListaGenerica<Integer> list = new ListaEnlazadaGenerica<Integer>();		
		if(a.tieneHijos()){
			ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
			while(!hijos.fin()){
				ListaGenerica<Integer> lista = numerosImparesMayoresQuePostOrden(hijos.proximo(), n);
				while(!lista.fin()){
					list.agregarFinal(lista.proximo());
				}
			}
		}
		if(esImparMayor(a.getDato(), n)){
			list.agregarFinal(a.getDato());
		}
		return list;
	}
	
	public static ListaGenerica<Integer> numerosImparesMayoresQuePorNiveles(ArbolGeneral<Integer> a, Integer n){
		ListaGenerica<Integer> list = new ListaEnlazadaGenerica<Integer>();
		ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<ArbolGeneral<Integer>>();
		cola.encolar(a);
		cola.encolar(null);
		while(!cola.esVacia()){
			ArbolGeneral<Integer> ar = cola.desencolar();
			if(ar != null){
				list.agregarFinal(ar.getDato());
				ListaGenerica<ArbolGeneral<Integer>> hijos = ar.getHijos();
				hijos.comenzar();
				while(!hijos.fin()){
					cola.encolar(hijos.proximo());
				}
			}else if(!cola.esVacia()){///en caso de que sea null el que desencolo, pregunto si no hay mas elementos
				cola.encolar(null);
			}
		}
		return list;
	}
}