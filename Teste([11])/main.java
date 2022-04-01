// using regular expressions
public class Jerks {
	public static void main(String args[])
	{
		String str = "palavra1, palavra2 palavra3@palavra4?palavra5.palavra6";
		String[] arrOfStr = str.split("[, ?.@]+");

		for (String a : arrOfStr)
			System.out.println(a);
	}
}

