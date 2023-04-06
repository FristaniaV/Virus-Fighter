package virusFighter;

import java.util.ArrayList;
import java.util.Scanner;

public class VirusFighter {

	Scanner scan = new Scanner(System.in);
	ArrayList<String> nameList = new ArrayList<>();
	ArrayList<Integer> popuList = new ArrayList<>();
 	
	String name;
	Integer popu;
	int index;
	String drug;
	String newName;
	
	public VirusFighter() {
		
		Menu();
		
	}
	
	public void Menu() {
		int choose = 0;

		do {
			try {
				System.out.println("Virus Fighter");
				System.out.println("============");
				System.out.println("1. Generate virus");
				System.out.println("2. Experiment with virus");
				System.out.println("3. Delete all Viruses");
				System.out.println("4. Exit");
				System.out.print(">> ");
				choose = scan.nextInt(); scan.nextLine();
				if (choose == 1) {
					Generate();
				} else if (choose == 2) {
					Experiment();
				} else if (choose == 3) {
					Delete();
				} else if (choose == 4) {
					System.exit(0);
				}
			} catch (Exception e) {
				choose = Integer.MIN_VALUE;
			} 
		} while (choose > 4 || choose < 1);
	}
	
	public void Generate() {
		
		do {
			System.out.println("Input virus name [min 3 characters long]: ");
			name = scan.nextLine();
		} while (name.length() < 3);
		nameList.add(name);
		
		do {
			System.out.println("Input virus population [must above 0]: ");
			popu = scan.nextInt(); scan.nextLine();
		} while (popu < 0);
		popuList.add(popu);
		
		System.out.println(name + " virus added to list, total virus in the list: " + nameList.size() + "!");
		System.out.println("Press enter...");
		scan.nextLine();
		Menu();
	}
	
	public void descendingSort() {
		for (int i = 0; i < nameList.size() - 1; i++) {
			for (int j = 0; j < nameList.size() - i - 1; j++) {
				if (popuList.get(j) < popuList.get(j+1)) {
					int tempPopu = popuList.get(j);
					popuList.set(j, popuList.get(j+1));
					popuList.set(j+1, tempPopu);
					String tempName = nameList.get(j);
					nameList.set(j, nameList.get(j+1));
					nameList.set(j+1, tempName);
				}
			}
		}
	}
	
	public void Experiment() {
		
		Integer randNum = (int)(Math.random() * 100 + 1);
		
		if (nameList.isEmpty()) {
			System.out.println("There are no virus in the list...");
			System.out.println("Press enter...");
			scan.nextLine();
			Menu();
		} else {
			System.out.println("---------------------------Virus Fighter----------------------------");
			System.out.println("====================================================================");
			System.out.printf("| %-5s | %-30s | %-15s |\n", "No", "Name", "Population");
			System.out.println("====================================================================");
			for (int i = 0; i < nameList.size(); i++) {
				System.out.printf("| %-5d | %-30s | %-15d |\n", (i+1), nameList.get(i), popuList.get(i));
			}
			System.out.println("====================================================================");
		
			do {
				System.out.println("Choose virus by index [1 - " + nameList.size() + "]: ");
				index = scan.nextInt(); scan.nextLine();
			} while (index < 0 || index > nameList.size());
			
			do {
				System.out.println("Input drugs name [min 5 characters long]: ");
				drug = scan.nextLine();
			} while (drug.length()  < 5);
			
			System.out.println("Experiment started...");
			System.out.println("Virus resistance = " + randNum + "%");
			
			if (randNum < 51) {
				System.out.println("Virus can be cured...");
				System.out.println();
				System.out.println("Press enter...");
				scan.nextLine();
				Menu();
			} else if (randNum > 50) {
				System.out.println("Virus became resistant and has evolved...");
				System.out.println();
				
				do {
					System.out.println("Input new virus name [must starts with 'E']: ");
					newName =  scan.nextLine();
				} while (!newName.startsWith("E"));
				
				System.out.println();
				nameList.set((index+1), newName);
				System.out.println("Virus name updated...");
				System.out.println();
				System.out.println("Press enter...");
				scan.nextLine();
				Menu();
				
			}
		}
	}
	
	public void Delete() {
		if (nameList.isEmpty()) {
			System.out.println("There are no virus to be deleted...");
			System.out.println("Press enter...");
			scan.nextLine();
			Menu();
		} else {
			System.out.println(nameList.size() + " viruses deleted...");
			nameList.clear();
			popuList.clear();
			System.out.println("Press enter...");
			scan.nextLine();
			Menu();
			
		}
	}

	public static void main(String[] args) {
		new VirusFighter();

	}

}
