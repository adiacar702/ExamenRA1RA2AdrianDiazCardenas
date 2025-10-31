package tema2_prueba;

import java.util.Scanner;

public class PiramideSumasResuelto {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String resp;
		int num;//ADC20251031 - La creo fuera del do para poder llamarla siempre que sea necesario
		do {
			num = leerEntero(sc, "Introduzca un número: ");//ADC20251031 - falta ;

			while (num < 0 || num > 20) {//ADC20251031 - condicion && da error, cambiar a ||
				num = leerEntero(sc, "**Valor fuera de rango** Introduzca un número entre 0 y 20: ");
			}

			System.out.println("\nSu pirámide de sumas es la siguiente:\n" + piramide(num));

			System.out.print("¿Quiere hacer otra pirámide? (s/n) ");
			resp = sc.next().trim().toUpperCase();//ADC20251031 - borra (String), ya esta creada al principio, solo hay que llamarla

		} while (resp.equals("S"));//ADC20251031 - falta un cierre de parentesis ( ) )

		borrarConsola();
		System.out.println("¡¡¡PROGRAMA FINALIZADO!!!");

		sc.close();
	}

	private static int leerEntero(Scanner sc, String mensaje) {
		System.out.print(mensaje);
		while (!sc.hasNextInt()) {
			System.out.print("**Valor no válido** Introduzca un número entero: ");
			sc.next();
		}
		return sc.nextInt();
	}

	public static void borrarConsola() {
		for (int i = 0; i < 50; i++) {//ADC20251031 - la coma de "i<50(,)" esta mal, cambiar a (;)
			System.out.println();
		}
	}

	public static String piramide(int num) {
		String res = "";
		int n = num;
		while (n >= 0) {//ADC20251031 - cambio (<=) por (>=) para que entre en el bucle
			int cont = 1;
			int total = 0;
			res += n + " => 0 ";

			while (cont <= n) {
				res += "+ " + cont + " ";
				total += cont;
				cont += 1;
				//ADC20251031 - el if dentro del while devolvia logica correcta pero salida por consola erronea.
				//Mostrando por consola (4 => 0 + 1 = 1+ 2 = 3+ 3 = 6+ 4 = 10
				//						 3 => 0 + 1 = 1+ 2 = 3+ 3 = 6
				//						 2 => 0 + 1 = 1+ 2 = 3
				//						 1 => 0 + 1 = 1
				//						 0 => 0  )
			}
			if (n > 0) {
				res += "= " + total;
			} //ADC20251031 - fuera del while muestra el total de la suma junto a la operacion del while

			res += "\n";
			n -= 1;
		}

		return res;//ADC20251031 - (resultado) esta mal, se creó como res
	}

}
