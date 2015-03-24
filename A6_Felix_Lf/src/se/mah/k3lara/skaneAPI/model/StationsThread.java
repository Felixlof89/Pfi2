package se.mah.k3lara.skaneAPI.model;

import java.util.ArrayList;

import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.view.GUI;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

public class StationsThread extends Thread {

	
	private GUI gui;
	private boolean stationSearch = false;

	public StationsThread(GUI g) {
		
		this.gui = g;
		stationSearch = true;
	}

	public void run() {
		if (stationSearch){
			gui.searchStations = new ArrayList<Station>();

			gui.results.setText("Searching... \n");
			gui.searchStations.addAll(Parser.getStationsFromURL(gui.searchbox.getText()));

			for (Station s : gui.searchStations) {
				gui.results.append(s.getStationName() + " number:" + s.getStationNbr() + "\n");

			}
		}
	}
}

