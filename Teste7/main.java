public class Jerks {
	public static void main(String args[])
	{
		String str = "JerksParaHeroes:Desenvolvendo sem Medo";
		String[] arrOfStr = str.split(":");

		for (String a : arrOfStr)
			System.out.println(a);
	}
}
