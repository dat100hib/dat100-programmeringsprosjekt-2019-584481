package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;		
		min = da[0];
		
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		return min;
	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		// TODO - START
	
		double[] tab = new double[gpspoints.length];
		for(int i= 0;i<tab.length;i++) {
			tab[i]= gpspoints[i].getLatitude();	
		}
		return tab;
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		double[] tab = new double[gpspoints.length];
		for(int i= 0;i<tab.length;i++) {
			tab[i]= gpspoints[i].getLongitude();
		}
		return tab;
	}

	
	private static int R = 6371000; // jordens radius
	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {
		
		double d;
		double latitude1, longitude1, latitude2, longitude2;
		//Radians = Degrees * PI / 180
		double rlatitude1 = gpspoint1.getLatitude()*PI/180;
		double rlatitude2 = gpspoint2.getLatitude()*PI/180;		
		double dlatitude = rlatitude2-rlatitude1;
		double dlongitude = gpspoint2.getLongitude()-gpspoint1.getLongitude();
		double rlongitude = dlongitude *PI/180;
		double a = pow(sin(dlatitude/2),2) + cos(rlatitude1)*cos(rlatitude2)*pow(sin(rlongitude/2),2);
		double c = 2*atan2(sqrt(a),sqrt(1-a));
		d = R*c;
		return d;
		
	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;

		
		throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";

		// TODO - START

		throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT

	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;

		// TODO - START

		throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
		
	}
}
