package Actividad;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

public class Actividad_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String frase = "";
		SealedObject so = null;

		boolean salir = true;

		while (salir) {
			int opcion;
			System.out.println("***************** Menu *************");
			System.out.println("Selecciona el numero de una opcion: ");
			System.out.println("01 Salir del programa ");
			System.out.println("02 Encriptar frase");
			System.out.println("03 Mostrar frase encriptada");
			System.out.println("04 Desencriptar frase");

			opcion = sc.nextInt();

			if (opcion == 01) {
				salir = false;
			}
			if (opcion == 02) {

				try {
					System.out.println("Escribe una frase: ");
					frase = sc.next();

					KeyGenerator generador = KeyGenerator.getInstance("AES");
					SecretKey paloEspartano = generador.generateKey();
					Cipher cifrador = Cipher.getInstance("AES");
					cifrador.init(Cipher.ENCRYPT_MODE, paloEspartano);
					so = new SealedObject(frase, cifrador);

				} catch (Exception gse) {
					System.out.println("Algo ha fallado.." + gse.getMessage());
					gse.printStackTrace();
				}

			}

			if (opcion == 03) {
				System.out.println("Frase encriptada: " + so);

			}
			if (opcion == 04) {
				System.out.println("Frase desencriptada " + frase);
			}

		}
		System.out.println("Sliste del programa");

	}

}
