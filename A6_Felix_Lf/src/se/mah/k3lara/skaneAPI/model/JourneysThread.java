package se.mah.k3lara.skaneAPI.model;

import java.util.Calendar;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.view.GUI;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

public class JourneysThread extends Thread {

	
	private GUI gui;

	public JourneysThread(GUI g) {
		
		this.gui = g;
	}

	public void run() {
		// search journeys
		gui.textArea.setText(null);
		String searchURL = Constants.getURL(gui.from.getText(),
				gui.to.getText(), 1);

		Journeys journeys = Parser.getJourneys(searchURL);

		for (Journey journey : journeys.getJourneys()) {
			gui.textArea.setText(journey.getStartStation() + " - ");
			gui.textArea.append(journey.getEndStation() + ("") + "\n");
			String time = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY)
					+ ":" + journey.getDepDateTime().get(Calendar.MINUTE)
					+ ("\n");
			gui.textArea.append("Departs " + time + "That is in "
					+ journey.getTimeToDeparture() + " minutes. \nAnd it is "
					+ journey.getDepTimeDeviation() + " min late");
		}
	}
}
