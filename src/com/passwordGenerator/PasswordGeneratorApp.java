package com.passwordGenerator;

import java.util.Scanner;

import com.passwordGenerator.input.UserInputCustomization;
import com.passwordGenerator.logic.PasswordGenerator;

public class PasswordGeneratorApp {

	public static void main(String[] args) {
			
			Scanner teclado = new Scanner(System.in);
			PasswordGenerator passwordGenerator;
			
			System.out.println("WELCOME TO THE PASSWORD-GENERATOR!");
			
			
			boolean shouldCustomize = UserInputCustomization.readBooleanInput(teclado, 
					"Would you like to customize your password? (YES / NO)");
			
			if(!shouldCustomize) {
				 passwordGenerator = new PasswordGenerator();
			} else {
				passwordGenerator = UserInputCustomization.customizePassword(teclado);
			}
			
			String RandomPassword = passwordGenerator.randomPasswordGeneratorFunction(); 
			System.out.println("Your password is: " + RandomPassword);

			teclado.close();
		}
}