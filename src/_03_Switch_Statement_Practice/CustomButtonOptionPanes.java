package _03_Switch_Statement_Practice;

import javax.swing.JOptionPane;

public class CustomButtonOptionPanes {
	public static void main(String[] args) {
		String[] options = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

		int input = JOptionPane.showOptionDialog(null, "Choose a day of the week", "Custom Buttons", 0, -1, null,
				options, 0);

		String choice = options[input];
		
		//use a switch statement to do something cool for each option
			switch(options[0]) {
			case "Sunday":
				System.out.println("Sunday");
			case "Monday":
				System.out.println("Monday");
			case "Tuesday":
				System.out.println("Tuesday");
			case "Wednesday":
				System.out.println("Wednesday");
			case "Thursday":
				System.out.println("Thursday");
			case "Friday":
				System.out.println("Friday");
			case "Saturday":
				System.out.println("Saturday");
			}
			switch(choice) {
			case "Monday":
				System.out.println("You need help");
			case "Tuesday":
				System.out.println("A little better");
			case "Wednesday":
				System.out.println("Better");
			case "Thursday":
				System.out.println("Much better");
			case "Friday":
				System.out.println("Amazing");
			case "Saturday":
				System.out.println("Getting worse");
			case "Sunday":
				System.out.println("Bad but not trash");
			}
	}
}
