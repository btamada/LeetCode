public class PowerOfFour {
	
	public static void main(String... args) {
		System.out.println(isPowerOfFour(5));
	}

	static boolean isPowerOfFour(int num) {
		if(num == 0) return false;
		while(num != 1) {
			if(num%4 != 0) return false;
			num = num / 4;
		}
		return true;
	}

}