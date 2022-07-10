/*
 * Class: CMSC203 
 * Instructor:Grinberg
 * Description: Caesar and Bellaso Encryption and Decryption
 * Due: 7/10/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Michael Bushman
*/

/**
 * This class contains methods in order to successfully run the Caesar and Bellaso Encryption and Decryption
 * @author Michael Bushman
 */
public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	
	// Takes a string as an input and determines if it can be encrypted or not
	public static boolean stringInBounds (String plainText) 
	{
		
		boolean Valid = true; 	// Variables

		for (int i = 0; i < plainText.length(); i++) { // Loops
			
			char c = plainText.charAt(i); // Variables

			if (c < LOWER_BOUND || c > UPPER_BOUND) // Checks
			{ 
				Valid = false;
			}
		}

		return Valid; // Return
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	
	// Encrypts a string using provided key for Caesar Ciphers methods
	public static String encryptCaesar(String plainText, int key) 
	{
		
		if (!stringInBounds(plainText)) 
		{ 
			return ""; 
		} 
		
		String encrypted = "";  // Variables

		for (int i = 0; i < plainText.length(); i++) // Loops
		{ 
			
			char c = plainText.charAt(i); // Variables
			int encrypt = (int)c + key;

			while (encrypt > UPPER_BOUND)  // Loops
			{ 
				encrypt -= RANGE; 
			} 

			encrypted += (char) encrypt;
		}

		return encrypted; // Return
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	
	// Encrypts a string using provided key for Bellaso Ciphers methods
	public static String encryptBellaso(String plainText, String bellasoStr) 
	{
		
		String encrypted = ""; // Variables
		int bell = bellasoStr.length(); 
		int ub = (int) UPPER_BOUND; 

		for (int i = 0; i < plainText.length(); i++) //Loops
		{ 
			
			char c = plainText.charAt(i); // Variables
			int encrypt = (int)c + (int)bellasoStr.charAt(i % bell);

			while (encrypt > ub) // Loops
			{ 
				encrypt -= RANGE; 
			} 

			encrypted += (char) encrypt;
		}

		return encrypted; // Return
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	
	// Decrypts a string using provided key for Caesar Ciphers methods
	public static String decryptCaesar(String encryptedText, int key) 
	{
		
		String decrypted = ""; 
		
		for (int i = 0; i < encryptedText.length(); i++) // Loops
		{
			char c = encryptedText.charAt(i); 
			int decrypt = (int)c - key;
			
			while (decrypt < LOWER_BOUND)  // Loops
			{ 
				decrypt += RANGE; 
			} 

			decrypted += (char) decrypt;
		}

		return decrypted; // Return
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	
	// Decrypts a string using provided key for Bellaso Ciphers methods
	public static String decryptBellaso(String encryptedText, String bellasoStr) 
	{
		
		String decrypted = ""; // Variables
		int bell = bellasoStr.length();
		int lb = (int) LOWER_BOUND; 

		for (int i = 0; i < encryptedText.length(); i++) // Loops
		{ 
			
			char c = encryptedText.charAt(i); // Variables
			int decrypt = (int)c - (int)bellasoStr.charAt(i % bell);

			while (decrypt < lb)  // Loops
			{ 
				decrypt += RANGE;
			} 

			decrypted += (char) decrypt;
		}
		
		return decrypted; // Return
	}
}