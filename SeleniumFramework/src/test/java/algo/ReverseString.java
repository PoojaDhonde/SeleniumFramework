package algo;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Pooja";
		char str1[] = str.toCharArray();
		String reverse = "";
		
		for (int i = str1.length; i>=0 ; i--) {
			reverse = reverse + str1[i];
		}
		
		System.out.println(reverse);

	}

}
