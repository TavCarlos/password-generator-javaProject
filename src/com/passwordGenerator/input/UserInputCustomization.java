package com.passwordGenerator.input;
	
import java.util.InputMismatchException;
import java.util.Scanner;

import com.passwordGenerator.logic.PasswordGenerator;
	
	
public class UserInputCustomization {
	
	
	public static PasswordGenerator customizePassword(Scanner scanner) {
		int passwordLength = readPasswordLenght(scanner);
		boolean includeNumbers = readBooleanInput(scanner,
				"Would you like to include Numbers? (YES / NO)");
		boolean includeLowerCase = readBooleanInput(scanner,
				"Would you like to include Lower Case Characters? (YES / NO)");
		boolean includeCapitalCase = readBooleanInput(scanner,
				"Would you like to include Capital Case Characters? (YES / NO)");
		boolean includeSpecialChar = readBooleanInput(scanner, 
				"Would you like to include Special Characters? (YES / NO)");
			
		validateOptions(includeNumbers, includeLowerCase, includeCapitalCase, includeSpecialChar);
			
		return new PasswordGenerator(passwordLength, includeNumbers,
					includeLowerCase, includeCapitalCase, includeSpecialChar);
		}
		
		
		private static int readPasswordLenght(Scanner scanner) {
			int passwordLength;
			
			 do {
			       System.out.println("Please enter the desired password length (MINIMUM: 8):");
			       try {
			            passwordLength = scanner.nextInt();
			            if (passwordLength < 8) {
			                System.out.println("Password length must be greater or equal to 8.");
			            }
			        } catch (InputMismatchException e) {
			            System.out.println("Invalid input. Please enter a valid integer.");
			            scanner.nextLine();
			            passwordLength = -1;
			        }
			    } while (passwordLength < 8);
	
			    return passwordLength;
		}
			
		
		public static boolean readBooleanInput(Scanner scanner, String message) {
			boolean includeBoolean;
			
			do {
				System.out.println(message);
				String userInput = scanner.nextLine();
				if("yes".equalsIgnoreCase(userInput)) {
					includeBoolean = true;
				} else if("no".equalsIgnoreCase(userInput)) {
					includeBoolean = false;
					break;
				} else {
					System.out.println("Invalid input. Please enter 'yes' or 'no'.");
					includeBoolean = false;
				}
				
			} while(!includeBoolean);
			
			return includeBoolean;
		}
		
		
		private static void validateOptions(boolean includeNumbers,
				boolean includeLowerCase, boolean includeCapitalCase, boolean includeSpecialChar) {
			if(!includeNumbers && !includeLowerCase && !includeCapitalCase && !includeSpecialChar) {
				throw new RuntimeException("At least one option must be selected.");
			}
		}
	}