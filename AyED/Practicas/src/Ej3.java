import tp02.ejercicio3.PilaGenerica;

public class Ej3
{
	public static void main(String[] args)
	{
		System.out.println(balanced("[(a)]"));
	}
	
	private static Character[] apertura = {'[', '(', '{'};
	private static Character[] cierre = {']', ')', '}'};
	
	public static boolean balanced(String cadena){
		PilaGenerica<Character> pila = new PilaGenerica<Character>();
		if(cadena.length() == 0) return true;
		for (Character c : cadena.toCharArray()){
			if(indexOf(c, apertura) != -1){
				pila.apilar(c);
			}else if(indexOf(c, cierre) != -1){
				Character c2 = pila.desapilar();
				if(indexOf(c, cierre) != indexOf(c2, apertura)){
					return false;
				}
			}
		}
		return pila.esVacia();
	}
	
	private static <T> int indexOf(T elem, T[] arr){
		for (int i = 0; i < arr.length; i++){
			if(arr[i] == elem){
				return i;
			}
		}
		return -1;
	}
}