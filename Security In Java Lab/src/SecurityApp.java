
public class SecurityApp {
	 public void checker(String text) {
		 
		 if(hasJava(text)) {
			 System.out.println("Unsafe");
		 }
		 else if (hasSQL(text)) {
			 System.out.println("Unsafe");
			 
		 }
		 else if (octalCheck(text)) {
			 System.out.println("Unsafe");
		 }
		 else if (unevenQuotes(text)) {
			 System.out.println("Unsafe");
		 }
		
		 else if (unevenParen(text)) {
			 System.out.println("Unsafe");
		 }
		 else {
			 System.out.println("Safe");
		 }
	 
	 }

	public boolean hasJava(String text) {
		String[] splitt  = text.split("\\s+");
		for (String java: splitt) {
			if(java.equals("int")) {
				return true;
			}
		}
		
		
		
		return false;
		
	}

	public boolean hasSQL(String text) {
		String[] splitt  = text.split("\\s+");
		boolean selectPresent = false;
		boolean wherePresent = false;
		for (String SQL: splitt) {
			if(SQL.equals("select")) {
				selectPresent = true;
			}
			else if(SQL.equals("where")) {
				wherePresent = true;
			}
			if(selectPresent && wherePresent) {
				return true;
			}
		}
		return false;
	}

	public boolean unevenQuotes(String text) {
		int Counter1 = 0;
		int Counter2 = 0;
		
		String[] splitt = text.split("\\s+");
		for (String quotes: splitt) {
			char[] wordSeperater = quotes.toCharArray();
			for (char quotes2: wordSeperater) {
				if (quotes2 == '"') {
					Counter1++;
				}
				else if(quotes2 == '\'') {
					Counter2++;
				}
			}
		
		}
		
		if(Counter1%2!=0 || Counter2%2!=0) {
			return true;
		}
		return false;
		
	}

	public boolean octalCheck(String text) {
		String[] splitt = text.split("\\s+");
		for (String octal: splitt) {
		char[] characterSeperater = octal.toCharArray();
			if (characterSeperater[0] == '0') {
				return true;
			}
		}
		
		return false;
		
	}

	public boolean unevenParen(String text) {
		int Counter1 = 0;
		int Counter2 = 0;
		
		String[] splitt = text.split("\\s+");
		for (String paren: splitt) {
			char[] wordSeperater = paren.toCharArray();
			for (char paren2: wordSeperater) {
				if (paren2 == '(') {
					Counter1++;
				}
				else if(paren2 == ')') {
					Counter2++;
				}
			}
		
		}
		
		if(Counter1%2!=0 || Counter2%2!=0) {
			return true;
		}
		return false;
		
	}





}


