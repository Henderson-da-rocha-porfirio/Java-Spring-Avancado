// Programa Java para demonstrar o funcionamento prático do split(regex com "s", limit) com o limit alto = 5.
public class Jerk {
	public static void main(String args[])
	{
		String str = "jerks@para@heroes";
		String[] arrOfStr = str.split("s", 5);

		for (String a : arrOfStr)
			System.out.println(a);
	}
}
