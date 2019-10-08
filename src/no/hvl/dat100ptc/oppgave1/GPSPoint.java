package no.hvl.dat100ptc.oppgave1;

import no.hvl.dat100ptc.TODO;

public class GPSPoint {

	// TODO - objektvariable
	private int time;
	private double latitude;
	private double longitude;
	private double elevation;

	public GPSPoint(int time, double latitude, double longitude, double elevation) {

		// TODO - konstruktur
		this.time = time;
		this.latitude = latitude;
		this.longitude = longitude;
		this.elevation = elevation;

	}

	// TODO - get/set metoder
	public int getTime() {

		return time;
	}

	public void setTime(int time) {
		time = time;

	}

	public double getLatitude() {

		return latitude;
	}

	public void setLatitude(double latitude) {

		latitude = latitude;
	}

	public double getLongitude() {

		return longitude;
	}

	public void setLongitude(double longitude) {

		longitude = longitude;
	}

	public double getElevation() {

		return elevation; 
	}

	public void setElevation(double elevation) {

		elevation = elevation; 
	}

	public String toString() {

		String str;

		// TODO - start


		// TODO - slutt
		return time + " " + (longitude + " " + latitude) + " " + elevation;  
	}
}