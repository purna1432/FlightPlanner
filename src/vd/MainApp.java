package vd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {

		FlightDetails[] arr = new FlightDetails[10];
		int count = 0;
		File file = new File("data.csv");
		try {
			Scanner sc = new Scanner(file);
			sc.useDelimiter(",");
			sc.nextLine();
			while (sc.hasNext()) {
				arr[count++] = new FlightDetails(sc.next().trim(), sc.next().trim(), sc.next().trim(), sc.next().trim(),
						sc.next().trim());
			}

//			Task 1
			displayRoutes(arr);

//			Task 2 Get flights using source details
			getDirectFlights(arr, "Delhi");

			Arrays.sort(arr, 0, count, new Comparator<FlightDetails>() {

				@Override
				public int compare(FlightDetails o1, FlightDetails o2) {
					return o1.getTo().compareTo(o2.getTo());
				}
			});

//			Task 3 Get flights using source details and sort
			System.out.println("================================");
			getDirectFlights(arr, "Delhi");

//			Task 4 Get Flight using source and destination
			getFlights(arr, "Delhi", "Banglore");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	private static void getFlights(FlightDetails[] arr, String source, String destination) {
		boolean found = false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				if (arr[i].getFrom().equals(source) && arr[i].getTo().equals(destination)) {
					found = true;
					printFlightDetail(arr, i);
				}
			}
		}

		if (!found) {
			System.out.println("Sorry We don't have any flights from " + source + " to " + destination);
		}

	}

	private static void getDirectFlights(FlightDetails[] arr, String source) {
		boolean found = false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				if (arr[i].getFrom().equals(source)) {
					found = true;
					printFlightDetail(arr, i);
				}
			}
		}

		if (!found) {
			System.out.println("Sorry We don't have any flights from " + source);
		}

	}

	public static String clean(String uncleaned) {
		return uncleaned.trim();
	}

	public static void displayRoutes(FlightDetails[] arr) {
		System.out.format("%10s %10s %10s %10s %10s", "From", "To", "Distance", "Travel Time", "Fare");
		System.out.println();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				printFlightDetail(arr, i);
			}
		}
	}

	private static void printFlightDetail(FlightDetails[] arr, int i) {
		System.out.format("%10s %10s %10s %10s %10s", arr[i].getFrom(), arr[i].getTo(), arr[i].getDistance(),
				arr[i].getTravelTime(), arr[i].getFare());
		System.out.println();
	}
}
