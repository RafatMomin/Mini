package mini;

/**
 * @author Rafat  Momin
 * Utility class with static methods for loop practice.
 */
public class LoopsInfinityAndBeyond {

	/**
	 * Private constructor to disable instantiation.
	 */
	private LoopsInfinityAndBeyond() {
	}

	/**
	 * Define a flying saucer as the following string pattern: one ‘(‘, followed by
	 * zero to many ‘=’, followed by one ‘)’. Write a Java method that, given a
	 * string find the first instance of a flying saucer (starting from the left)
	 * and return its length. If no flying saucer exists return 0.
	 * <p>
	 * For example: Given: "(==)" Return: 4
	 * <p>
	 * Given: "***()**(===)" Return: 2
	 * <p>
	 * Given: "****(***)" Return: 0
	 * 
	 * @param source input string
	 * @return the length
	 */
	public static int flyingSaucerLength(String source) {
		int flyingSaucerLength = 0;
		boolean firstBracketFound = false;
		
		for (int i = 0; i < source.length(); ++i) {
			
			if(firstBracketFound) {
				if(source.charAt(i)== '=') {
					
					flyingSaucerLength++;
					
				} else if(source.charAt(i)== ')') {
					
					return ++flyingSaucerLength;
					
				} else {
					
					flyingSaucerLength = 0;
					firstBracketFound = false;
				}

			}
			
			if(source.charAt(i)== '(') {
				flyingSaucerLength++;
				firstBracketFound = true;
			}
				
		}
		
		return flyingSaucerLength;
	}

	/**
	 * Write a Java method that, given a string which many contain a flying saucer
	 * broken into two parts with characters in between, return a string where the
	 * flying is fixed by removing the in between characters. Look for the two parts
	 * of the flying saucer from left to right and fix the saucer with the first
	 * available parts.
	 * <p>
	 * For example:
	 * Given: ***(==****===)***
	 * Return: ***(=====)***
	 * <p>
	 * Given: ***(==****)**=)*
	 * Return: ***(==)**=)*
	 * <p>
	 * Given: ***(==)**
	 * Return: ***(==)**
	 * 
	 * @param s
	 * @return
	 */
	public static String fixFlyingSaucer(String source) {
		StringBuilder outputString = new StringBuilder();
		boolean isPatternFound = false;
		
		for(int i=0; i < source.length(); ++i) {
			
			if(isPatternFound) {
				
				if(source.charAt(i)== '=') {
					outputString.append(source.charAt(i));
				}
				else if(source.charAt(i)== ')') {
					outputString.append(source.charAt(i));
					isPatternFound = false;
				}
				
			} else {

				if(source.charAt(i) == '(') {
					isPatternFound = true;
				}
				
				outputString.append(source.charAt(i));
			}
			
			
		}
		return outputString.toString();
	}

	/**
	 * Write a Java method that, given a string which many contain many flying
	 * saucers, return the number of flying saucers. For this problem a flying
	 * saucer may wrap around from the right side of the string to the left.
	 * <p>
	 * For example:
	 * Given: ***(===)***
	 * Return: 1
	 * <p>
	 * Given: **(==)**(=)
	 * Return: 2
	 * <p>
	 * Given: ***(=*=)**
	 * Return: 0
	 * 
	 * @param s
	 * @return
	 */
	public static int countFlyingSaucers(String source) {
		int numberOfFlyingSaucers = 0;
		boolean isFirstBracketFound = false;
		boolean patternAlreadyFound = false;
		
		for(int i = 0; i < source.length(); ++i) {
			
			if(isFirstBracketFound) {
				if(source.charAt(i)== '=') {
					
				} else if(source.charAt(i)== ')') {
					
					numberOfFlyingSaucers++;
					isFirstBracketFound = false;
					
				} else {
					
					isFirstBracketFound = false;
				}

			}
			
			if(source.charAt(i)== '(') {
				isFirstBracketFound = true;
				patternAlreadyFound = true;
			} else if(source.charAt(i)== ')' && patternAlreadyFound == false) {
				source = source.substring(i + 1, source.length()) + source.substring(0, i + 1);
				i = -1;
				patternAlreadyFound = true;
			}
		}
		
		
		return numberOfFlyingSaucers;
	}

	/**
	 * Write a Java method that, given a string which many contain many flying
	 * saucers, shifts all of the saucers one character to the right. For this
	 * problem a flying saucer may wrap around from the right side of the string to
	 * the left. The returned string should have the same number of characters as
	 * the given string. This is achieved by moving the character to the right of a
	 * saucer to its left. It can be assumed that saucers will never be touching
	 * each other (i.e., there will always be at least one character between any two
	 * saucers). Also, a saucer will not touch itself (e.g., "=)(=").
	 * <p>
	 * For example:
	 * Given: ***(===)***
	 * Return: ****(===)**
	 * <p>
	 * Given: =)**(==)**(
	 * Return: (=)***(==)*
	 * <p>
	 * Given: a()bcde(=*=)fg
	 * Return: ab()cde(=*=)fg
	 * 
	 * @param s
	 * @return
	 */
	public static String flyingSaucersFly(String source) {
		boolean isFirstBracketFound = false;
		int firstBracketIndex = 0;
		
		for(int i = 0; i < source.length(); ++i) {
			
			if(isFirstBracketFound) {
				if(source.charAt(i)== '=') {
					
				} else if(source.charAt(i)== ')') {
					source = source.substring(0, firstBracketIndex) + source.charAt(i + 1)+ 
							source.substring(firstBracketIndex, i + 1) + source.substring(i + 2, source.length());
					break;
					
				} else {
					isFirstBracketFound = false;
				}

			}
			
			if(source.charAt(i)== '(') {
				isFirstBracketFound = true;
				firstBracketIndex = i;
			} else if(source.charAt(i)== ')' && !isFirstBracketFound) {
				source = source.charAt(source.length() - 1) + source.substring(0, source.length() - 1);
				break;
			}
			
			if(source.charAt(source.length() - 1)== ')') {
				source = source.charAt(source.length() - 1) + source.substring(0, source.length() - 1);
				break;
			}
		}
		
		
		return source;
	}
	
}
