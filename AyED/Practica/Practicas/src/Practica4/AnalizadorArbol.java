package Practica4;

import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.*;

public class AnalizadorArbol {

	public AnalizadorArbol(){
		
	}
	
	public static void main(String[] args){
		ArbolGeneral<AreaEmpresa> arbol = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa(53));
		ArbolGeneral<AreaEmpresa> aux;
		
		aux = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa(4));
		aux.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa(19)));
		aux.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa(6)));
		aux.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa(33)));
		arbol.agregarHijo(aux);
		
		aux = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa(77));
		aux.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa(80)));
		arbol.agregarHijo(aux);
		
		aux = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa(61));
		aux.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa(15)));
		aux.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa(1)));
		arbol.agregarHijo(aux);
		
		aux = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa(43));
		aux.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa(68)));
		aux.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa(11)));
		aux.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa(51)));
		//aux.getHijos().comenzar();
		//aux.getHijos().proximo().agregarHijo(new ArbolGeneral<Integer>(33));
		arbol.agregarHijo(aux);
		System.out.println(devolverMaximoPromedio(arbol));
		//53 19 6 33 77 80 61 15 1 4 68 11 51
	}
	
	public static int devolverMaximoPromedio(ArbolGeneral<AreaEmpresa>arbol){
		ColaGenerica<ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<ArbolGeneral<AreaEmpresa>>();
		cola.encolar(arbol);
		cola.encolar(null);
		int cantNivel = 0;
		int cantTotal = 0;
		int maxProm = -999;
		while(!cola.esVacia()){
			ArbolGeneral<AreaEmpresa> ar = cola.desencolar();
			if(ar != null){
				cantTotal += ar.getDato().getRetardo();
				cantNivel++;
				ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos = ar.getHijos();
				hijos.comenzar();
				while(!hijos.fin()){
					cola.encolar(hijos.proximo());
				}
			}else if(!cola.esVacia()){
				int prom = cantTotal/cantNivel;
				if(prom > maxProm){
					maxProm = prom;
				}
				cantTotal = 0;
				cantNivel = 0;
				cola.encolar(null);
			}
		}
		int prom = cantTotal/cantNivel;
		if(prom > maxProm){
			maxProm = prom;
		}
		return maxProm;
	}
	
	/*public static int devolverMaximoPromedio(ArbolGeneral<AreaEmpresa>arbol){
		ListaEnlazadaGenerica<Integer> list = new ListaEnlazadaGenerica<Integer>();
		if(arbol.esHoja()){
			return arbol.getDato().getRetardo();
		}
		ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos = arbol.getHijos();
		hijos.comenzar();
		int retardoHijo = 0;
		int max = -999;
		while(!hijos.fin()){
			retardoHijo += devolverMaximoPromedio(hijos.proximo());
			if(retardoHijo > max){
				max = retardoHijo;
			}
			//list.agregarFinal(retardoHijo/hijos.tamanio());
			//int dato = arbol.getDato().getRetardo();
			//int cantHijos = arbol.getHijos().tamanio();
		}
		int promHijos = retardoHijo/hijos.tamanio();
		if(promHijos > max){
			max = promHijos;
		}
		//return dato/cantHijos;
		return max;
	}*/
}
