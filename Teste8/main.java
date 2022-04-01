public class Jerks {
	public static void main(String args[])
	{
		String str = "JerksParaHeroesParaEstudantes";
		String[] arrOfStr = str.split("Para");

		for (String a : arrOfStr)
			System.out.println(a);
	}
}
