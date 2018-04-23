import static org.junit.Assert.*;
import org.junit.*;

public class JUnitTests {
JUnitMethods jm = new JUnitMethods();

	@Test
	public void addIntTest() {
		int x = 10;
		int y = 20;
		int check = jm.addInts(x, y);
		int expected = 30;
		
		x = 10;
		y = -20;
		int check1 = jm.addInts(x, y);
		int expected1 = -10;
		
		x = -10;
		y = -20;
		int check2 = jm.addInts(x, y);
		int expected2 = -30;
		
		assertEquals(check, expected);
		assertEquals(check1, expected1);
		assertEquals(check2, expected2);
	}

	@Test
	public void stringAddition() {
		String firstName = "Roger";
		String lastName = "Robinson";
		int before = firstName.length() + lastName.length();
		String check = jm.addStrings(firstName, lastName);
		int after = check.length();
		
		assertEquals(before, after);
	}

	@Test
	public void getLength() {
		String gg = "";
		int expected = 0;
		int lennn = jm.findLen(gg);
		String gg1 = "Roger";
		int expected1 = 5;
		int lennn1 = jm.findLen(gg1);
		
		assertEquals(expected, lennn);
		assertEquals(expected1, lennn1);
	}
	
	@Test
	public void division() {
		int x = 6;
		int y = 7;
		int num = jm.divXByY(x, y);
		int expected = 0;
		
		x = 6;
		y = 0;
		Integer num1 = jm.divXByY(x, y);
		Integer expected1 = null;
		
		assertEquals(expected, num);
		assertEquals(expected1, num1);
	}
	
	@Test
	public void reverseReverse() {
		int[] x = {1,2,3,4,5};
		int[] r = jm.reverseIntArray(x);
		int rev1;
		int rev2;
		rev1 = 0;
		rev2 = 0;
		
		for(int i:x) {
			rev1+=i;
		}
		for(int i:r) {
			rev2+=i;
		}	
	
		assertEquals(rev1,rev2);
	}


}
