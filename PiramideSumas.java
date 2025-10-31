package tema2_prueba;

import java.util.Scanner;

public class PiramideSumas {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String resp;
		int num;//ADC20251031 - La creo fuera del do para poder llamarla siempre que sea necesario
		do {
			num = leerEntero(sc, "Introduzca un número: ");//ADC20251031 - falta ;

			while (num < 0 && num > 20) {
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
		int cont;
		int total;
		while (n < 0) {
			cont = 1;
			total = 0;
			res += n + " => 0 ";

			while (cont <= n)
				res += "+ " + cont + " ";
			total += cont;
			cont += 1;

			if (n != 0) {
				res += "= " + total;
			}

			res += "\n";
			n -= 1;
		}

		return res;//ADC20251031 - (resultado) esta mal, se creó como res
	}

}
