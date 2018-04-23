
public class JUnitMethods {

	public int addInts(int x, int y) {
		return x+y;
	}
	
	public String addStrings(String x, String y) {
		return x+y;
	}
	
	public int findLen(String x ) {
		 return x.length();
	}
	
	public Integer divXByY(int x, int y) {
		if (y==0) {
			return null;
		}
		else {
			return (int) x/y;
		}
	}

	public int[] reverseIntArray(int[] x) {
		int[] y = new int[x.length];
		int sum = 0;
		for(int i = x.length-1; i>=0; i--) {
			y[sum] = x[i];
			sum+=1;
		}
		return y;
	}
	
}
