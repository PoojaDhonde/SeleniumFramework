package algo;

public class ThisKeyword {
	
	int num = 100;
	public void calc(int num) {
		this.num = num * 10;
	}
	public void printNum() {
		System.out.println(num);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThisKeyword obj = new ThisKeyword();
		obj.calc(2);
		obj.printNum();
	}

}
