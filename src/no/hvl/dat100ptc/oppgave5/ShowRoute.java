package no.hvl.dat100ptc.oppgave5;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

public class ShowRoute extends EasyGraphics {

	private static int MARGIN = 50;
	private static int MAPXSIZE = 800;
	private static int MAPYSIZE = 800;

	private GPSPoint[] gpspoints;
	private GPSComputer gpscomputer;
	
	public ShowRoute() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("Route", MAPXSIZE + 2 * MARGIN, MAPYSIZE + 2 * MARGIN);

		showRouteMap(MARGIN + MAPYSIZE);

		playRoute(MARGIN + MAPYSIZE);
		
		showStatistics();
	}

	// antall x-pixels per lengdegrad
	public double xstep() {

		double maxlon = GPSUtils.findMax(GPSUtils.getLongitudes(gpspoints));
		double minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));

		double xstep = MAPXSIZE / (Math.abs(maxlon - minlon)); 

		return xstep;
	}

	// antall y-pixels per breddegrad
	public double ystep() {
	
		// TODO - START
		double maxlat = GPSUtils.findMax(GPSUtils.getLatitudes(gpspoints));
		double minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));

		double ystep = MAPYSIZE / (Math.abs(maxlat - minlat)); 

		return ystep;

		// TODO - SLUTT
		
	}

	public void showRouteMap(int ybase) {
		//som tegner punkter i vinduet svarende til de (lengdegrad,breddegrad) posisjoner som 
		//finnes i GPS datafilen. 
		//Parameteren ybase angir det sted på y-aksen som skal svare til den minste breddegrad 
		//som finnes i datafilen.
		
		double[] latitudes = GPSUtils.getLatitudes(gpspoints);
		double[] longitudes = GPSUtils.getLongitudes(gpspoints); 
		
		for (int i = 0; i < gpspoints.length; i++) {
			double y =  latitudes[i];
			double x =  longitudes[i];
			
			int xpos =(int)((x - GPSUtils.findMin(longitudes))*xstep());
			int ypos = (int)  ((GPSUtils.findMax(latitudes)-y)* ystep());
			
			drawCircle(xpos,ypos,2);
		}
		
	}

	public void showStatistics() {

		int TEXTDISTANCE = 20;

		setColor(0,0,0);
		setFont("Courier",12);
		
		// TODO - START
		
		System.out.println("dude"); 
		//throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT;
	}

	public void playRoute(int ybase) {

		// TODO - START
		
		//throw new UnsupportedOperationException(TODO.method());
		System.out.println("dude"); 
		// TODO - SLUTT
	}

}
