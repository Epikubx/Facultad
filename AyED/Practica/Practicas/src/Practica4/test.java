package Practica4;

import tp02.ejercicio2.*;
import tp04.ejercicio1.*;

public class test {

	public static void main(String[] args) {
		ArbolGeneral<String> a1 = new ArbolGeneral<String>("1");
		ArbolGeneral<String> a2 = new ArbolGeneral<String>("2");
		ArbolGeneral<String> a3 = new ArbolGeneral<String>("3");
		ListaGenerica<ArbolGeneral<String>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<String>>();
		a1.agregarHijo(new ArbolGeneral<String>("4"));
		hijos.agregarFinal(a1);
		hijos.agregarFinal(a2);
		hijos.agregarFinal(a3);
		//ArbolGeneral<String> a = new ArbolGeneral<String>("0", hijos);
		System.out.println("Datos del Arbol: ");//a.preOrden());
	}
}