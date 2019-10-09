package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import static java.lang.Double.*; 


public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int antall) {

		// TODO - START
		gpspoints = new GPSPoint [antall]; //refereansetabell 
		this.antall = 0 ; 

		// TODO - SLUTT
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	protected boolean insertGPS(GPSPoint gpspoint) {

		boolean inserted = false;

		// TODO - START
		if (this.antall < gpspoints.length){
			gpspoints[this.antall] = gpspoint; 
			this.antall++; 
			
			inserted = true;
		}
		
		return inserted; 
		// TODO - SLUTT
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {

		GPSPoint gpspoint;

		// TODO - START
		int sekunder = GPSDataConverter.toSeconds(time); 
		double breddegr = parseDouble(latitude); 
		double lengdegr = parseDouble(longitude);
		double høydegr = parseDouble(elevation); 
		
		gpspoint = new GPSPoint(sekunder, breddegr, lengdegr, høydegr); 
		
		return insertGPS(gpspoint); //returnerer for er boolean og får den tilbake er den good.
		

		// TODO - SLUTT
		
	}

	public void print() {

		System.out.println("====== Konvertert GPS Data - START ======");

		// TODO - START

		throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
		
		// System.out.println("====== Konvertert GPS Data - SLUTT ======");

	}
}
