package src;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/*
 * Runs the program
 */
public class Main {
	public static Tokenizer t;
	public static Scanner dataFile;

	public static void main(String[] args) {
		// Open the program file.
		try {
			Scanner programInput = new Scanner(Paths.get(args[0]));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// Open the input file.
		try {
			dataFile = new Scanner(Paths.get(args[1]));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Create the Tokenizer.
		try {
			t = new Tokenizer(args[0]);
			// TODO - print output of Tokenizer to file
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// call prog constructor
		Prog p = new Prog();

		p.parseProg(); // call parseProg
		System.out.println("Program output: \n");
		p.printProg();// call printProg
		System.out.println("Printed program: \n");
		p.execProg();// call execProg
	}
}