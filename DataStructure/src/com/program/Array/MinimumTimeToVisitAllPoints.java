package com.program.Array;

public class MinimumTimeToVisitAllPoints {
	public static void main(String[] args) {
		MinimumTimeToVisitAllPointsSol sol = new MinimumTimeToVisitAllPointsSol();
		int[][] arr = {{1, 1}, {3, 4}, {-1, 0}};
		System.out.println(sol.minimumTimeToVisitAllPoints(arr));
	}
}

class MinimumTimeToVisitAllPointsSol{
	public int minimumTimeToVisitAllPoints(int[][] points) {
		int rows = points.length;
		System.out.println("Rows count "+ rows);
		int minTime = 0;
		for (int i = 0; i < rows-1; i++) {
			System.out.println("x: points[i][0] " + points[i][0]);
			System.out.println("x: points[i+1][0] " + points[i+1][0]);
			System.out.println("y: points[i][1] " + points[i][1]);
			System.out.println("y: points[i+1][1] " + points[i+1][1]);
			
			int xdiff = Math.abs(points[i][0] - points[i+1][0]);
			int ydiff = Math.abs(points[i][1] - points[i+1][1]);
			
			minTime += Math.max(xdiff, ydiff);
		}
		
		return minTime;
	}
}