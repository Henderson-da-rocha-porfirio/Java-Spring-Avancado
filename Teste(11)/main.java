public class Jerks {
	public static void main(String args[])
	{
		String str = "JerksparaparaHeroespara ";
		String[] arrOfStr = str.split("para");

		for (String a : arrOfStr)
			System.out.println(a);
	}
}

