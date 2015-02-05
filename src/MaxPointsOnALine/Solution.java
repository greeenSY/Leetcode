package MaxPointsOnALine;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	class Point {
		int x;
		int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
	}
	private static int gcd(int a, int b) {
	    return b > 0 ? gcd(b, a % b) : a;
	}
	public static int maxPoints(Point[] points) {
		int n = points.length;
		int res = 0;
		for(int i = 0; i < n; i++){
			int maxNum = 1;
			int SameI = 0;
			Map<String,Integer> ks = new HashMap<String,Integer>(); 
			for(int j = i + 1; j < n; j++){
				int x,y;
				if (points[i].x >= points[j].x) {
			          x = points[i].x - points[j].x;
			          y = points[i].y - points[j].y;
		        } else {
			          x = points[j].x - points[i].x;
			          y = points[j].y - points[i].y;
		        }
				int gcdXY = gcd(Math.abs(x), Math.abs(y));
		        if (gcdXY == 0) {
		        	SameI ++;
		        	continue;
		        } else {
		            x /= gcdXY;
		            y /= gcdXY;
		        }
		        if(x == 0 || y == 0) {
		            x = Math.abs(x);
		            y = Math.abs(y);
		         }
		         String k = x + ":" + y;
		          
				if(ks.containsKey(k)){
					ks.put(k, ks.get(k) + 1);
				} else{
					ks.put(k, 2);
				}
				if(maxNum < ks.get(k))
					maxNum = ks.get(k);
			}
			if(res < maxNum + SameI)
				res = maxNum + SameI;
			ks.clear();
		}
		return res;
        
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		Point[] p = new Point[5];
		p[0] = s.new Point(2,3);
		p[1] = s.new Point(1,0);
		p[2] = s.new Point(0,1);
		p[3] = s.new Point(3,3);
		p[4] = s.new Point(-5,3);
		
		System.out.println(maxPoints(p));
		

	}

}
