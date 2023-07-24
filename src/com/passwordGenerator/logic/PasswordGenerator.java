package com.passwordGenerator.logic;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class PasswordGenerator {
	
	final static private String LOWER_CASE_ALPHABET = "qwertyuiopasdfghjklzxcvbnm";
	final static private String CAPITAL_CASE_ALPHABET = "QWERTYUIOPASDFGHJKLZXCVBNM";
	final static private String SPECIAL_SYMBOLS = "!@#$%&*";
	final static private String NUMBERS= "0123456789";

	 private int passwordLength;
	 private boolean includeNumbers;
	 private boolean includeLowerCase;
	 private boolean includeCapitalCase;
	 private boolean includeSpecialChar;
	
	public PasswordGenerator() {
		this(12, true, true, true, true);
	}
	
	public PasswordGenerator(int passwordLength, boolean includeNumbers, boolean includeLowerCase, boolean includeCapitalCase,
			boolean includeSpecialChar) {
		this.passwordLength = passwordLength;
		this.includeNumbers = includeNumbers;
		this.includeLowerCase = includeLowerCase;
		this.includeCapitalCase = includeCapitalCase;
		this.includeSpecialChar = includeSpecialChar;
	}

	private char randomCharacter() {
		SecureRandom random = new SecureRandom();
		List<String> AllCharacters = new ArrayList<>();

		if(includeNumbers) {
			AllCharacters.add(NUMBERS);
		}
		
		if(includeLowerCase) {
			AllCharacters.add(LOWER_CASE_ALPHABET);
		}
		
		if(includeCapitalCase) {
			AllCharacters.add(CAPITAL_CASE_ALPHABET);
		}
		
		if(includeSpecialChar) {
			AllCharacters.add(SPECIAL_SYMBOLS);
		}
		
		int randomElementIndex = random.nextInt(AllCharacters.size());
		String selectedElement = AllCharacters.get(randomElementIndex);
		int randomCharIndex = random.nextInt(selectedElement.length());
		return selectedElement.charAt(randomCharIndex);
	}

	public  String randomPasswordGeneratorFunction() {
		String password = "";

		for(int i = 0; i < passwordLength; i++) {
		 password += randomCharacter();
		}
		return password;
	}

}