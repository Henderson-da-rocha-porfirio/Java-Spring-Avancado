public class Jerks {
	public static void main(String args[])
	{
		String str = "jerkssss";
		String[] arrOfStr = str.split("s");

		for (String a : arrOfStr)
			System.out.println(a);
	}
}
