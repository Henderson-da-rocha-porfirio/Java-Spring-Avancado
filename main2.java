// Programa Java para demonstrar o funcionamento prático do split(regex, limit) com o limit alto = 5.
public class Jerk {
	public static void main(String args[])
	{
		String str = "jerk@para@heroes";
		String[] arrOfStr = str.split("@", 5);

		for (String a : arrOfStr)
			System.out.println(a);
	}
}
