// Java program to demonstrate working of split()
public class Jerks {
	public static void main(String args[])
	{
		String str = "Jerks Para Heroes";
		String[] arrOfStr = str.split(" ");

		for (String a : arrOfStr)
			System.out.println(a);
	}
}
