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
				break;
			case "Monday":
				System.out.println("Monday");
				break;
			case "Tuesday":
				System.out.println("Tuesday");
				break;
			case "Wednesday":
				System.out.println("Wednesday");
				break;
			case "Thursday":
				System.out.println("Thursday");
				break;
			case "Friday":
				System.out.println("Friday");
				break;
			case "Saturday":
				System.out.println("Saturday");
				break;
			}
			switch(choice) {
			case "Monday":
				System.out.println("You need help");
				break;
			case "Tuesday":
				System.out.println("A little better");
				break;
			case "Wednesday":
				System.out.println("Better");
				break;
			case "Thursday":
				System.out.println("Much better");
				break;
			case "Friday":
				System.out.println("Amazing");
				break;
			case "Saturday":
				System.out.println("Getting worse");
				break;
			case "Sunday":
				System.out.println("Bad but not trash");
				break;
			}
	}
}
