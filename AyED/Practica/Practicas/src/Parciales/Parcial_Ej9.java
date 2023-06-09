package Parciales;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Parcial_Ej9 {

	public static void main(String[] args) {
		ArbolGeneral<Integer> arbol= new ArbolGeneral<Integer>(13);

        ArbolGeneral<Integer> hijo1 = new ArbolGeneral<Integer>(2);
        ArbolGeneral<Integer> hijo2 = new ArbolGeneral<Integer>(8);
        ArbolGeneral<Integer> hijo3 = new ArbolGeneral<Integer>(4);
        ArbolGeneral<Integer> hijo4 = new ArbolGeneral<Integer>(4);
        ArbolGeneral<Integer> nieto1 = new ArbolGeneral<Integer>(5);
        ArbolGeneral<Integer> nieto2 = new ArbolGeneral<Integer>(4);
        ArbolGeneral<Integer> nieto3 = new ArbolGeneral<Integer>(10);
        ArbolGeneral<Integer> nieto33 = new ArbolGeneral<Integer>(0);
        ArbolGeneral<Integer> nieto333 = new ArbolGeneral<Integer>(20);
        ArbolGeneral<Integer> nieto3333 = new ArbolGeneral<Integer>(15);

        nieto1.agregarHijo(nieto2);
        hijo2.agregarHijo(nieto3333);
        hijo2.agregarHijo(nieto3);
        hijo2.agregarHijo(nieto1);

        hijo3.agregarHijo(nieto33);
        hijo3.agregarHijo(nieto333);

        arbol.agregarHijo(hijo1);
        arbol.agregarHijo(hijo2);
        arbol.agregarHijo(hijo3);
        arbol.agregarHijo(hijo4);
        ListaEnlazadaGenerica<Integer> lista = procesar(arbol);
        lista.comenzar();
        System.out.println(lista.toString());
	}
	
	public static ListaEnlazadaGenerica<Integer> procesar(ArbolGeneral<Integer> ar){
		ListaEnlazadaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		ListaGenerica<Integer> aux;
		int max = -999;
		lista.agregarFinal(ar.getDato());
		ListaGenerica<ArbolGeneral<Integer>> hijos = ar.getHijos();
		hijos.comenzar();
		while(!hijos.fin()){
			aux = procesar(hijos.proximo());
			aux.comenzar();
			if(aux.tamanio() > max){
				while(max > 0){
					lista.eliminarEn(lista.tamanio());
					max--;
				}
				while(!aux.fin()){
					lista.agregarFinal(aux.proximo());
				}
				max = aux.tamanio();
			}
		}
		return lista;
	}
}