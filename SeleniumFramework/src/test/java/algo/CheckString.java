package algo;

public class CheckString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "Pooja1234@!Dhonde";

		char[] str = s.toCharArray();

		for(int i=0; i<s.length(); i++)
		{
			if(Character.isLetter(str[i])) {
				System.out.println("Letter:"+str[i]);
				}
			else if (Character.isDigit(str[i])) {
				System.out.println(str[i]);}
			else {
				System.out.println(str[i]);}
		}
	}

}
