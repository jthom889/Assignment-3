package mru.tsc.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import mru.tsc.model.Toys;
import mru.tsc.model.Animals;
import mru.tsc.model.BoardGames;
import mru.tsc.model.Figures;
import mru.tsc.model.Puzzles;


public class StoreMenu {
	//file name
	private final String FILE_PATH = "res/text.txt" ;
	private ArrayList<Toys> toys = new ArrayList<>();
	Scanner in = new Scanner(System.in);
	
	
	/**
	 * Class constructor
	 * Hold the new file
	 * @param file the current file
	 */
	public StoreMenu() throws Exception {
		loadData();
	}
	
	/**
	 * Method that loads all information
	 * @param file the current file
	 * @throws Exception 
	 */
	public void loadData() throws Exception {
			
		File db = new File(FILE_PATH);
		String currentLine;
		String[] splittedLine;

		// reading the file
		if (db.exists()) {
			Scanner fileReader = new Scanner(db);

			while (fileReader.hasNextLine()) {

				currentLine = fileReader.nextLine();
				splittedLine = currentLine.split(";");
				char SN = splittedLine[0].charAt(0);

				if (toyType(SN) == "F") {
					Toys Figure = new Figures(splittedLine[0], splittedLine[1], splittedLine[2],
							Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]),
							Integer.parseInt(splittedLine[5]), splittedLine[6]);
					toys.add(Figure);

				}
				if (toyType(SN) == "A") {
					Toys Animals = new Animals(splittedLine[0], splittedLine[1], splittedLine[2],
							Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]),
							Integer.parseInt(splittedLine[5]), splittedLine[6], splittedLine[7]);
					toys.add(Animals);
				}
				if (toyType(SN) == "P") {
					Toys Puzzle = new Puzzles(splittedLine[0], splittedLine[1], splittedLine[2],
							Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]),
							Integer.parseInt(splittedLine[5]), splittedLine[6]);
					toys.add(Puzzle);
				}
				if (toyType(SN) == "B") {
					Toys BoardGame = new BoardGames(splittedLine[0], splittedLine[1], splittedLine[2],
							Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]),
							Integer.parseInt(splittedLine[5]), splittedLine[6], splittedLine[7]);
					toys.add(BoardGame);

				}
			}

			// closing the filereader
			fileReader.close();
		}
	}
	
	
	/**
	 * This method searches the serial number of toy
	 * @param serialNum - serial number of toy
	 * @return toy
	 */
	public Toys searchSerialNo(String serialNo) {
		Toys toy = null;
		for (Toys t : toys) {
			if (t.getSerialNo().equals(serialNo)) {
				toy = t;
				break;
			}
		}
		return toy;
	}
	
	/**
	 * This method checks if there is a repeated serial number being added
	 * @param serialNum - serial number of toy
	 * @return repeatedSerialNum
	 * @throws Exception
	 */
	public boolean repeatedSerialNo(String serialNo) throws Exception {
		boolean repeatedSerialNo = false;
		String savedSerialNo = "0";
		int i = 0;
		while (i < toys.size()) {
			savedSerialNo = toys.get(i).getSerialNo();
			if (savedSerialNo.equals(serialNo)) {
				repeatedSerialNo = true;
			}
			i++;
		}
		return repeatedSerialNo;

	}
	
	/**
	 *  Used to search the file for the name
	 * @param name of the toy
	 * @param in the users input
	 * @return 
	 */
	public String searchByName(String name) {
		Toys toy = null;
		String output = "";
		for (Toys t1 : toys) {
			if ((t1.getName().toUpperCase()).contains(name.toUpperCase())) {
				toy = t1;
				output = output + "\n" + toy.toString();
			
			}
			
		}
		return output;
	}
	
	
	/**
	 * This method searches the type of toy
	 * @param choice
	 * @return output
	 */
	public String searchByType(String choice) {
		String result = "Matches Found:";
		int i;
		char typeOfToy = choice.toUpperCase().charAt(0);
		if (typeOfToy == 'A') {
			i = 0;
			while (i < toys.size()) {
				if (toys.get(i) instanceof Animals) {
					Animals a = (Animals) toys.get(i);
					result = result + "\n" + a.toString();
				}
				i++;
			}
		}
		if (typeOfToy == 'B') {
			i = 0;
			while (i < toys.size()) {
				if (toys.get(i) instanceof BoardGames) {
					BoardGames bg = (BoardGames) toys.get(i);
					result = result + "\n" + bg.toString();
				}
				i++;
			}
		}
		if (typeOfToy == 'F') {
			i = 0;
			while (i < toys.size()) {

				if (toys.get(i) instanceof Figures) {
					Figures f = (Figures) toys.get(i);
					result = result + "\n" + f.toString();
				}
				i++;
			}
		}
		if (typeOfToy == 'P') {
			i = 0;
			while (i < toys.size()) {

				if (toys.get(i) instanceof Puzzles) {
					Puzzles p = (Puzzles) toys.get(i);
					result = result + "\n" + p.toString();
				}
				i++;
			}
		}
		if (typeOfToy != 'P' && typeOfToy != 'F' && typeOfToy != 'B' && typeOfToy != 'A') {
			result = "Please Enter a Valid Toy Type, the valid types are\n(A)nimal\n(B)oard Game\n(F)igure\n(P)uzzle";
		}
		return result;
	}
	
	
	
	/**
	 * Used to search the file for the type
	 * @param type that is selected
	 * @param in the users input
	 */
	public String toyType(char serialNo) {
		String toyType = null;
		switch (serialNo) {
		case '0':
		case '1':
			toyType = "F";
			break;
		case '2':
		case '3':
			toyType = "A";
			break;
		case '4':
		case '5':
		case '6':
			toyType = "P";
			break;
		case '7':
		case '8':
		case '9':
			toyType = "B";
			break;
		}
		return toyType;
	}
	
	
	/**
	 * This method adds the figure toy to the inventory of toys
	 * @param serialNum - serial number of toy
	 * @param toyName - name of toy
	 * @param toyBrand - brand of toy
	 * @param price - price of toy
	 * @param toyAmount - amount available of toy
	 * @param ageGroup - age recommended for toy
	 * @param type - type of toy
	 */
	public void addFigure(String serialNo, String name, String brand, double price, int avaliableCount, int ageAppropriate, String Class) {
		Toys Figure = new Figures(serialNo, name, brand, price, avaliableCount, ageAppropriate, Class);
		toys.add(Figure);
	}

	/**
	 * This method adds animal toy to the inventory of toys
	 * @param serialNum - serial number of toy
	 * @param toyName - name of toy
	 * @param toyBrand - brand of toy
	 * @param price - price of toy
	 * @param toyAmount - amount available of toy
	 * @param ageGroup - age recommended for toy
	 * @param material - material of toy
	 * @param Size - size of toy
	 */
	public void addAnimal(String serialNo, String name, String brand, double price, int avaliableCount, int ageAppropriate, String material,
			String sz) {
		Toys Animals = new Animals(serialNo, name, brand, price, avaliableCount, ageAppropriate, material, sz);
		toys.add(Animals);
	}

	
	
	/**
	 * This method adds puzzle toy to the inventory of toys
	* @param serialNum - serial number of toy
	 * @param toyName - name of toy
	 * @param toyBrand - brand of toy
	 * @param price - price of toy
	 * @param count - amount available of toy
	 * @param ageGroup - age recommended for toy
	 * @param type - type of toy
	 */
	public void addPuzzle(String serialNo, String name, String brand, double price, int avaliableCount, int ageAppropriate, String puzzleT) {
		Toys Puzzle = new Puzzles(serialNo, name, brand, price, avaliableCount, ageAppropriate, puzzleT);
		toys.add(Puzzle);
	}

	
	/**
	 * This method adds the boardgame to the inventory of toys
	 * @param serialNum
	 * @param toyName
	 * @param toyBrand
	 * @param price
	 * @param toyAmount
	 * @param ageGroup
	 * @param numPlayers
	 * @param designer
	 */
	public void addBoardGame(String serialNo, String name, String brand, double price, int avaliableCount, int ageAppropriate, String noOfPlayers,
			String designer) {
		Toys BoardGame = new BoardGames(serialNo, name, brand, price, avaliableCount, ageAppropriate, noOfPlayers, designer);
		toys.add(BoardGame);
	}
	
	/**
	 * This method removes the toy using serial number
	 * @param serialNum
	 */
	public void RemoveToy(String serialNum) {
		int i = 0;
		while (i < toys.size()) {
			String savedSerialNum = toys.get(i).getSerialNo();
			if (savedSerialNum.equals(serialNum)) {
				toys.remove(i);
			}
			i++;
		}
	}
	
	/**
	 * Saves the information into the file before terminating the program
	 */
	public void exit() throws IOException {
		File db = new File(FILE_PATH);
		PrintWriter pw = new PrintWriter(db);
		int i = 0;
		while (i < toys.size()) {
			if (toys.get(i) instanceof Animals) {
				Animals Animals = (Animals) toys.get(i);
				pw.println(Animals.Format());
			}
			if (toys.get(i) instanceof BoardGames) {
				BoardGames BoardGame = (BoardGames) toys.get(i);
				pw.println(BoardGame.Format());
			}
			if (toys.get(i) instanceof Figures) {
				Figures Figure = (Figures) toys.get(i);
				pw.println(Figure.Format());
			}
			if (toys.get(i) instanceof Puzzles) {
				Puzzles Puzzle = (Puzzles) toys.get(i);
				pw.println(Puzzle.Format());
			}
			i++;
		}

		pw.close();
	}
}