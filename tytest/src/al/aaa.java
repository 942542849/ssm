package al;

import java.util.Scanner;

public class aaa {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		String[] str = in.nextLine().split(",");
		int x = Integer.valueOf(str[0]);
		int y = Integer.valueOf(str[1]);
		
		double angle = 0;
		String[] str1 = in.nextLine().split(",");
		int x0 = 0,y0 = 0,x1 = 0,y1 = 0;
		for(int i = 0; i+2 < str1.length; i = i + 2) {
			x0 = Integer.valueOf(str1[i]);
			y0 = Integer.valueOf(str1[i+1]);
			x1 = Integer.valueOf(str1[i+2]);
			y1 = Integer.valueOf(str1[i+3]);
			double cosValue = (x0-x)*(x1-x) + (y0-y)*(y1-y);
			cosValue /= (Math.sqrt((x0-x)*(x0-x) + (y0-y)*(y0-y)) + Math.sqrt((x1-x)*(x1-x) + (y1-y)*(y1-y)));
			angle += Math.acos(cosValue)*180/Math.PI;
		}
		x0 = Integer.valueOf(str1[0]);
		y0 = Integer.valueOf(str1[1]);
		double cosValue = (x0-x)*(x1-x) + (y0-y)*(y1-y);
		cosValue /= (Math.sqrt((x0-x)*(x0-x) + (y0-y)*(y0-y)) + Math.sqrt((x1-x)*(x1-x) + (y1-y)*(y1-y)));
		angle += Math.acos(cosValue)*180/Math.PI;
		//夹角是360度判断是否在内部
		if(360 == angle) {
			System.out.println("yes,0");
		}else {
			int min1 = 99999, min2 = 100000, min1I = -1,min2I = -1;
			for(int i = 0; i < str1.length; i = i + 2) {
				x0 = Integer.valueOf(str1[i]);
				y0 = Integer.valueOf(str1[i+1]);
				int temp = (x0-x)*(x0-x) + (y0-y)*(y0-y);
				if(temp <= min1) {
					min2I = min1I;
					min1I = i;
					min2 = min1;
					min1 = temp;
				}else if(temp <= min2) {
					min2 = temp;
					min2I = i;
				}
			}
			double ax = Integer.valueOf(str1[min1I]);
			double ay = Integer.valueOf(str1[min1I+1]);
			double bx = Integer.valueOf(str1[min2I]);
			double by = Integer.valueOf(str1[min2I+1]);
			double result = 0.0;
			//点斜式求直线要考虑斜率不存在的情况
			if(ax == bx) {
				result = x - ax;
			}else if((ay == by)){
				result = y - ay;
			}else {
				double k = (ay - by)/(ax - bx);
				double b = ay - k*ax;
				result = (Math.abs(y-k*x-b)/Math.sqrt(1+k*k));
			}
			System.out.println("no," + (int)Math.rint(result));
		}
	}
}
