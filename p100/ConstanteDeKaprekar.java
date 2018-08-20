package com.aceptaelreto.ecosistemajava.p100;

import java.util.Arrays;
import java.util.Scanner;

public class ConstanteDeKaprekar {

	private static Scanner in = new Scanner(System.in);
	private static final String CONSTANTE_DE_KAPREKAR = "6174";
	
	public static void main(String[] args) {
		leerDatos();
	}

	private static void leerDatos() {
		int numeroCasos = in.nextInt();
		for(int i = 0; i < numeroCasos; i++) {
			String numero = in.next();
			resolverCaso(numero);
		}
	}
	
	private static void resolverCaso(String numero) {
		numero = rellenarCeros(numero);
		int iteraciones = 0;
		
		for(;!numero.equals(CONSTANTE_DE_KAPREKAR) && iteraciones < 8;iteraciones++) {
			String numeroMenor = ordenarMenor(numero);
			String numeroMayor = ordenarMayor(numeroMenor);
			numero = rellenarCeros(String.valueOf(Integer.parseInt(numeroMayor) - Integer.parseInt(numeroMenor)));
		}
		
		System.out.println(iteraciones);
	}
	
	private static String rellenarCeros(String numero) {
		while(numero.length() < 4) {
			numero = "0" + numero;
		}
		
		return numero;
	}

	private static String ordenarMenor(String numero) {
		int [] numeroArray = new int [4];
		for(int i = 0; i < numero.length(); i++) {
			numeroArray[i] = Integer.parseInt(String.valueOf(numero.charAt(i)));
		}
		
		Arrays.sort(numeroArray);
		numero = "";
		for(int i = 0; i < numeroArray.length; i++) {
			numero += String.valueOf(numeroArray[i]);
		}
		
		return numero;
	}
	
	private static String ordenarMayor(String numeroMenor) {
		String resultado = "";
		
		for(int i = 0; i < numeroMenor.length(); i++) {
			resultado = numeroMenor.charAt(i) + resultado;
		}
		
		return resultado;
	}
	
}
