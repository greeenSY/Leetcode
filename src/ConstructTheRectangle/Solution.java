package ConstructTheRectangle;

import java.util.Arrays;

public class Solution {

	public static int[] constructRectangle(int area) {
		for(int i=(int)Math.sqrt(area); i>0; i--){
			if(area % i == 0){
				return new int[]{area/i, i};
			}
		}
		return null;
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(constructRectangle(4)));
		System.out.println(Arrays.toString(constructRectangle(1)));

	}

}
