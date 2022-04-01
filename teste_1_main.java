// Programa Java para demonstrar o funcionamento do split (regex, limit) com pequenos limit.
// Para testar remova "teste_1_" e deixe apenas main.java e crie o projeto com o nome que quiser.
public class GFG {
	public static void main(String args[])
	{
		String str = "jerk@para@heroes";
		String[] arrOfStr = str.split("@", 2);

		for (String a : arrOfStr)
			System.out.println(a);
	}
}

// Output:
// jerk
// para@heroes
