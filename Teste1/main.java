// Programa Java para demonstrar o funcionamento prático do split(regex, limit) com o limit baixo = 2.
public class jerk {
	public static void main(String args[])
	{
		String str = "jerk@para@heroes";
		String[] arrOfStr = str.split("@", 2);

		for (String a : arrOfStr)
			System.out.println(a);
	}
}
