package se.mah.k3lara.skaneAPI.view;

import java.util.ArrayList;
import java.util.Calendar;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

public class TestClass {

	public static void main(String[] args) {
		//Söker efter resor mellan malmö och lund
		String searchURL = Constants.getURL("80000", "81216", 20);
		System.out.println(searchURL);
		System.out.println("// Results when searching:");

		//Hämtar resor
		Journeys journeys = Parser.getJourneys(searchURL);
		for (Journey journey : journeys.getJourneys()) {
			System.out.print(journey.getStartStation() + " - ");
			System.out.print(journey.getEndStation());
			String time = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY)
					+ ":" + journey.getDepDateTime().get(Calendar.MINUTE);
			System.out.println(" Departs " + time + " that is in "
					+ journey.getTimeToDeparture() + " minutes. And it is "
					+ journey.getDepTimeDeviation() + " min late");
		}

		System.out
				.println("// Stations when searching for stations containing \"Malm\"");
		ArrayList<Station> searchStations = new ArrayList<Station>();
		
		//hämtar alla resor som innehåller "malm"
		searchStations.addAll(Parser.getStationsFromURL("Malm")); 
		for (Station s : searchStations) {
			System.out.println(s.getStationName() + " number:"
					+ s.getStationNbr());
		}
	}
}
