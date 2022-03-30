package br.com.tuyo.java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) throws Exception {
		serialize();
		unserialize();
	}

	private static void serialize() throws Exception { 	// Método serialize = faz a serialização
		Usuario usuario = new Usuario();				// Cria o Objeto Usuario
		usuario.setId(5); 								// Com ID = 5
		usuario.setNome("Pedro");						// Com Nome = Pedro

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("usuario.bin"))) {
			oos.writeObject(usuario);					// Grava uma saída que gera String: usuario.bin
		}
	}
	
	private static void unserialize() throws Exception { // Método unserialize = faz o contrário do serialize
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("usuario.bin"))) {
			Usuario usuario = (Usuario) ois.readObject();
			System.out.println(usuario);
		}
	}
}
