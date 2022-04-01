// Programa Java para demonstrar o funcionamento prático do split(regex, limit) com o limit negativo = -2.
public class Jerk {
	public static void main(String args[])
	{
		String str = "jerks@para@heroes";
		String[] arrOfStr = str.split("@", -2);

		for (String a : arrOfStr)
			System.out.println(a);
	}
}
