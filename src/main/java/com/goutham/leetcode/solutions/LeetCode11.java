package com.goutham.leetcode.solutions;

public class LeetCode11 {

	public int maxArea(int[] height) {

		int len = height.length;

		int maxSize = 0;

		for (int x = 0; x < len; x++) {
			int hx =height[x];
			int las = 0;
			for (int y = len - 1; y >= x; y--) {
				int hy =height[y];
				if (las < hy) {

					int num2 = Math.min(hx, hy);
					int size = (y - x) * num2;
					if (size > maxSize) {
						maxSize = size;
						las = hy;
					}
				}
			}
		}

		return maxSize;

	}
	
	public int maxArea1(int[] height) {

		int len =height.length ;

		int maxSize = 0;
		int x= 0;
		int y=len-1;

		while(x<len) {
			if(y>=x+1  ) {
				maxSize = Math.max(maxSize,(y - x) * Math.min(height[x], height[y]));
				y--;
			}else {
				x++;
				y=len-1;

			}
			

		}
		return maxSize;

	}
	
	public int maxArea2(int[] height) {
		int x=0;
		int y=height.length-1;
		int maxSize=0;
		while(x<y){
		if(height[x]<height[y])
		{
			System.out.println("x < y = x : " +height[x] +", y : "+height[y]);
			maxSize=Math.max(maxSize,height[x]*(y-x));
			x++;
		}
		else
		{
			System.out.println("x > y = x : " +height[x] +", y : "+height[y]);

			maxSize=Math.max(maxSize,height[y]*(y-x));
			y--;
		}
		}
		return maxSize;
		}
	
}
