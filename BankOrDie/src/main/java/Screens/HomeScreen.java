package Screens;

import java.util.Scanner;

public class HomeScreen implements Screen {
	private Scanner scan = new Scanner (System.in);

	public Screen start() {

		System.out.println("");
		System.out.println("Deposit your Earnings, press 1");
		System.out.println("Withdraw? Think about it!, press 2");
		System.out.println("View your input to the cause, press 3");
		System.out.println("Where does it all go?, View Deposits and Withdraws, press 4");
		System.out.println("Die?, press 5");

		
		String selection = scan.nextLine();
		
		switch (selection) {
		case "1":
			//System.out.println("Deposit Your Earnings");
			Screen ds = new DepositScreen();
			ds.start();
			break;
			
		case "2":
			//System.out.println("Withdraw At Your Own Discretion");
			Screen ws = new WithdrawScreen();
			ws.start();
			break;
			
		case "3":
			//System.out.println("Your Input To The Cause");
			Screen abs = new AccBalScreen();
			abs.start();
			break;
			
		case "4":
			//System.out.println("Deposits and Withdraws At A Glance");
			Screen ths = new TransHistScreen();
			ths.start();
			break;
			
		case "5":
			//System.out.println("Welcome The Almighty Sir!");
			Screen die = new DieScreen();
			die.start();
			break;
			
		default:
			System.out.println("Wrong selection, try again.");
			break;
		
		}
			return this;
	
		}
	}


