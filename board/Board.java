package cyvasse.board;

import java.awt.* ;
import javax.swing.* ;

/*************************
 * Credit for a lot of this code goes to salamander2, with his hexmech file being a very big inspriation for this.
 * @author Sanagoo333
 * @author mcwubzy
 */

public class Board {
	public static boolean XYVertex = false ;
	
	private static int borders = 50 ;
	
	private static int s = 0 ;
	private static int t = 0 ;
	private static int r = 0 ;
	private static int h = 0 ;
	
	public static void setBorders(int b) {
		borders = b ;
	}
	
	public static void setSide(int side) {
		s=side;
		t =  (int) (s / 2);
		r =  (int) (s * 0.8660254037844);
		h=2*r;
	}
	public static void setHeight(int height) {
		h = height;
		r = h/2;
		s = (int) (h / 1.73205);
		t = (int) (r / 1.73205);
	}
	
	public static Polygon hex(int x1, int y1) {
		int y = y1 + borders ;
		int x = x1 + borders ;
		
		if (s==0 || h == 0) {
			System.out.println("Error: No hexagon size defined.") ;
			return new Polygon() ;
		}
		
		int[] cx,cy ;
		
		cx = new int[] {x,x+s,x+s+t,x+s,x,x-t};
		
		cy = new int[] {y,y,y+r,y+r+r,y+r+r,y+r};
		
		return new Polygon(cx, cy, 6) ;
	}
	
	public static void drawHex(int i, int j, Graphics2D g) {
		int x = i * (s+t);
		int y = j * h + (i%2) * h/2;
		Polygon poly = hex(x,y);
		//g.setColor(Cyvasse.COLORCELL) ;
		g.setColor(Color.DARK_GRAY) ;
		g.fillPolygon(poly) ;
		//g.setColor(Cyvasse.COLORGRID) ;
		g.setColor(Color.BLACK) ;
		g.drawPolygon(poly) ;
	}
}
