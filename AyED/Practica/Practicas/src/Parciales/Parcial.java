package Parciales;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Parcial {

	public ListaGenerica<Integer> resolver(ArbolBinario<Integer> ab, int min){
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		boolean found = resolverAux(ab, min, lista);
		if(found){
			return lista;
		}else{
			return null;
		}
	}
	
	private boolean resolverAux(ArbolBinario<Integer> ab, int min, ListaGenerica<Integer> camino){
	    camino.agregarFinal(ab.getDato());
	    if(ab.esHoja()){
	        camino.comenzar();
	        int pares = 0;
	        while(!camino.fin()){
	            if(camino.proximo() % 2 == 0){
	                pares++;
	            }
	        }
	        return pares >= min;
	    }else{
	        if(ab.tieneHijoIzquierdo()){
	            if(resolverAux(ab.getHijoIzquierdo(), min, camino)){
	                return true;
	            }else{
	                camino.eliminarEn(camino.tamanio());
	            }
	        }
	        if(ab.tieneHijoDerecho()){
	            if(resolverAux(ab.getHijoDerecho(), min, camino)){
	                return true;
	            }else{
	                camino.eliminarEn(camino.tamanio());
	            }
	        }
	    }
	    return false;
	}
}
