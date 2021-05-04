package algo;

public class QualysInterviewQ {

	public static void main(String[] args) {

		String str = "The Name is The Name";
		int count;

		//ArrayList<String> str1 = new ArrayList<String>();

		String[] str1 = str.split(" ");

		for(int i = 0; i<str1.length; i++) {
			System.out.println(str1[i]);
		}

		for(int j = 0; j<str1.length; j++) {
			count = 1;
			for(int k = 1+j; k<str1.length; k++) {
				if(str1[j].equals(str1[k])) {
					count++;
					str1[k] = "x";
				}
			}
			
			if (count>=1 && str1[j] != "x") {
				System.out.println(str1[j] + " count is: " + count);
			}
		}
		
		


	}

}
