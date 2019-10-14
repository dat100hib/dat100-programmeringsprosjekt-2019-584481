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

		double ystep = (MAPYSIZE -2*MARGIN)/ (Math.abs(maxlat - minlat)); 

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
		
		for (int i = 0; i < gpspoints.length-1; i++) {
			double y =  latitudes[i];
			double x =  longitudes[i];
			double y2 = latitudes[i+1];
			double x2 = longitudes[i+1]; 
			
			int xpos =(int)((x - GPSUtils.findMin(longitudes))*xstep());
			int ypos = (int)  ((GPSUtils.findMax(latitudes)-y)* ystep());
			
			int xpos2 =(int)((x2 - GPSUtils.findMin(longitudes))*xstep());
			int ypos2 = (int)  ((GPSUtils.findMax(latitudes)-y2)* ystep());
			
			if(i == gpspoints.length-2) {
				setColor(0,0,255); 
				fillCircle(xpos,MARGIN+ypos,3); 
		}else {
			setColor(0,250,0);
			fillCircle(xpos,MARGIN+ypos,3);
			}
			
			
			setColor(250,0,0);
			drawLine(xpos,MARGIN+ypos,xpos2,MARGIN+ypos2); 
			

		
			
		}
		
	}

	public void showStatistics() {

		int TEXTDISTANCE = 20;

		setColor(0,0,0);
		setFont("Courier",12);
		
		// TODO - START
		
		gpscomputer.displayStatistics();
		
		int xpos =20;
		int ypos =40;
		double WEIGHT = 80.0;
		
		drawString("==============================================",xpos,ypos);
		
		drawString("Total Time     :   "+gpscomputer.totalTime(),xpos,ypos+TEXTDISTANCE);
		drawString("Total distance :   "+gpscomputer.totalDistance()+" km", xpos, ypos+TEXTDISTANCE*2);
		drawString("Total elevation:   "+gpscomputer.totalElevation()+" m",xpos,ypos+TEXTDISTANCE*3);
		drawString("Max speed      :   "+gpscomputer.maxSpeed()+" km/t",xpos,ypos+TEXTDISTANCE*4);
		drawString("Average speed  :   "+gpscomputer.averageSpeed()+" km/t",xpos,ypos+TEXTDISTANCE*5);
		drawString("Energy         :   "+gpscomputer.totalKcal(WEIGHT)+" kcal",xpos,ypos+TEXTDISTANCE*6);
//		
		drawString("==============================================",xpos,ypos+TEXTDISTANCE*7);
		
		// TODO - SLUTT;mmedou
	}

	public void playRoute(int ybase) {

		// TODO - START
		
		//throw new UnsupportedOperationException(TODO.method());
		System.out.println("dude"); 
		// TODO - SLUTT
	}

}
