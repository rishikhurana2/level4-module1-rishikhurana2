package _05_Enum_Stuff;

import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class _00_Horoscope {
	// 1. Create an enum in a separate file called Zodiac that contains a category for
	//    all 12 zodiac signs.
	
	// 2. Write a method that takes in a Zodiac enum object and uses a JOPtionPane to display
	//    a different horoscope based on the Zodiac's state.
	static void DisplayHoroscope(Zodiac z) throws IOException {
		String Horoscope = "";
		switch(z) {
		case ARIES: {
			Horoscope = "aries.png";
			break;
		}
		case TAURUS: {
			Horoscope = "taurus.png";
			break;
		}
		case GEMINI: {
			Horoscope = "gemini.jpeg";
			break;
		}
		case CANCER: {
			Horoscope = "cancerhoroscope.jpeg";
			break;
		}
		case LEO: {
			Horoscope = "Leo-Sun-Sign-720x340.jpg";
			break;
		}
		case VIRGO: {
			Horoscope = "Virgo.jpeg";
			break;
		}
		case LIBRA: {
			Horoscope = "Libra.jpeg";
			break;
		}
		case SCORPIO: {
			Horoscope = "Scorpio.png";
			break;
		}
		case SAGITTARIUS: {
			Horoscope = "sagittarius-yearly-horoscope-2018.jpg";
			break;
		}
		case CAPRICORN: {
			Horoscope = "capricorn-daily-overview-1038x519.png";
			break;
		}
		case AQUARIUS: {
			Horoscope = "Aquarius-w.png";
			break;
		}
		case PISCES: {
			Horoscope = "Pisces.jpeg";
			break;
		}
		default:
			System.out.println("Not a zodiac...");
			break;
		}
		if (Horoscope != "") {
			JFrame frame = new JFrame();
			ImageIcon icon = new ImageIcon("src/" + Horoscope);
			JLabel label = new JLabel(icon);
			frame.add(label);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setVisible(true);
		}
	}
	// 3. Make a main method to test your method
	public static void main(String[] args) throws IOException {
		Zodiac z = Zodiac.ARIES;
		DisplayHoroscope(z);
	}
}
