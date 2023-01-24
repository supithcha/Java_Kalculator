//Name: Supithcha Jongphoemwatthaphon
//ID: 6488045
//Section: 2

import java.util.ArrayList;

public class Kalculator {
	//******INSERT YOUR CODE HERE***********
	//Class attributes go here
	
	ArrayList<Double> data = new ArrayList<Double>(); //initialize arraylist แบบdouble
	int size = data.size() ; //ให้ตัวแปรชื่อsize เป็นขนาดของarrayชื่อdata
	
	//**************************************
	/**
	 * Constructor is the fist method to be call at instantiation of a Kalculator object.
	 * If you need to initialize your object, do so here. 
	 */
	Kalculator()
	{
		//******INSERT YOUR CODE HERE***********

		//**************************************
	}
	
	/**
	 * Add number to the list of numbers. 
	 * @param number
	 */
	public void addNumber(double number)
	{	//******INSERT YOUR CODE HERE***********
		
		data.add(number); //addค่าnumberให้มาอยู่ในarraylist
		size = data.size() ;
//		System.out.println("size ="+size) ;
		
		//**************************************
	}
	
	/**
	 * Remove the least recently added number from the list. If the list is empty, do nothing.
	 */
	public void deleteFirstNumber()
	{
		//******INSERT YOUR CODE HERE***********
		if(size>=1) //ถ้าsize>=1 หรือหมายความว่ามีelementในarray
			{ data.remove(0); } //.remove ลบelementตำแหน่งที่0,ตำแหน่งแรกในarray data
		size = data.size(); //ปรับขนาดsizeอีกทีหลังจากลบelement
		
		//**************************************
	}
	
	/**
	 * Remove the most recently added number from the list. If the list is empty, do nothing.
	 */
	public void deleteLastNumber()
	{
		//******INSERT YOUR CODE HERE***********
		if(size>=1) //ถ้าsize>=1 หรือหมายความว่ามีelementในarray
			{ data.remove(size-1); } //.remove(size-1) ลบelementตำแหน่งสุดท้ายในarray data
		size = data.size(); //ปรับขนาดsizeอีกทีหลังจากลบelement
		//**************************************
	}
	
	/**
	 * Calculate the summation of all the numbers in the list, then returns the sum. 
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getSum()
	{
		//******INSERT YOUR CODE HERE***********
		double sum=0; //initialize variable sum สำหรับเก็บค่าผลรวมของค่าในarray data
		for(int i=0; i<size; i++)
			{ sum = data.get(i) + sum ; }
		return sum; //returnค่าsumออกมา
		//**************************************
	}
	
	/**
	 * Calculate and return the average of all the numbers in the list.
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getAvg()
	{
		//******INSERT YOUR CODE HERE***********
		double avg=0; //initialize variable avg สำหรับเก็บค่าเฉลี่ยของค่าในarray data
		double sum=0;
		if(size>=1)
		{
			for(int i=0; i<size; i++)
				{ sum = data.get(i) + sum ; }
			avg = sum/size ;
		}
		return avg; //returnค่าaverageออกมา
		//**************************************
	}
	
	/**
	 * Calculate and return the sample standard deviation of all the numbers in the list.
	 * If the list has fewer than 2 numbers, return 0.
	 * @return
	 */
	public double getStd()
	{
		//******INSERT YOUR CODE HERE***********
		size = data.size();
		double std, sum=0, avg=0 ,sumx=0;
		
		if(size>=1)
		{
			for(int i=0; i<size; i++)
				{ sum = data.get(i) + sum ; }
			avg = sum/size ;
		}
		if(size<=1) //ถ้าsizeน้อยกว่า1 ส่วนจะเป็น0หรือติดลบ=หาค่าไม่ได้
			return 0;
		else
		{
			for(int i=0;i<size;i++)
			{ sumx = sumx + Math.pow((data.get(i)-avg), 2);}
		std = Math.sqrt(sumx/(size-1));
		}
		return std;
		//**************************************
	}
	
	/**
	 * Find and return the maximum of all the numbers in the list.
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getMax()
	{
		//******INSERT YOUR CODE HERE***********
		if (size<1)
			return 0;
		double max = data.get(0); //initialize variable max สำหรับเก็บค่าmaximumของค่าในarray data กำหนดให้เท่ากับค่าแรกในarray data
		for(int i=0 ;i<size ;i++)
		{
			if( max<data.get(i)) //ถ้าค่าmaxน้อยกว่าค่าในarray dataตัวที่i
			{ max = data.get(i) ;} //ให้ค่าmax = ค่าที่มากกว่าไปเรื่อยๆจนจบarray
		}
		return max;
		//**************************************
	}
	
	/**
	 * Find and return the minimum of all the numbers in the list.
	 * If the list is empty, return 0.
	 */
	public double getMin()
	{
		//******INSERT YOUR CODE HERE***********
		if (size<1)
			return 0;
		
		double min = data.get(0); //initialize variable min สำหรับเก็บค่าminimumของค่าในarray data กำหนดให้เท่ากับค่าแรกในarray data
		for(int i=0 ;i<size ;i++)
		{
			if( min>data.get(i)) //ถ้าค่าminมากกว่าค่าในarray dataตัวที่i
			{ min = data.get(i) ;} //ให้ค่าmin = ค่าที่น้อยกว่าไปเรื่อยๆจนจบarray
		}
		return min;
		//**************************************
	}
	
	/**
	 * Find and return the maximum k numbers of all the numbers in the list as an array of k double number.
	 * The order of the returned k numbers does not matter. (We only care if you can get the max k elements)
	 * If the list has fewer than k numbers, return null.
	 */
	public double[] getMaxK(int k)
	{ //sort part ref: https://www.tutorialcup.com/th/java/how-to-sort-an-array-in-java.htm
		//******INSERT YOUR CODE HERE***********
		if(size <k)
			{ return null; }
		else 
		{
			
			double temp; //สำหรับเก็บค่าที่สลับ
			double[] sortdata = new double[size]; //สร้างarrayที่จะsort =sortdata
			double[] maxk = new double[k]; //สร้าง array สำหรับ maxk
			
			for(int i=0;i<size;i++)
				{ sortdata[i] = data.get(i); }
			
			for(int i=0;i<size;i++)
			{
			for(int j=i+1;j<size;j++)
			{
				if(sortdata[i]>sortdata[j]) //ถ้ามากกว่าให้สลับไปข้างหลัง
				{
					temp = data.get(i);
					sortdata[i] = data.get(j);
					sortdata[j] = temp;
				}
			}
			}
			for(int i=k-1;i>=0;i--) //printจากข้างหลังแต่ต้องลบ1เพราะ arrayเริ่มต้นที่0
				{ maxk[i]=sortdata[size-i-1];}
		
			return maxk ;
		
		}
	
		//**************************************
	}
	
	
	/**
	 * Find and return the minimum k numbers of all the numbers in the list as an array of k double number.
	 * The order of the returned k numbers does not matter. (We only care if you can get the min k elements)
	 * If the list has fewer than k numbers, return null.
	 */
	public double[] getMinK(int k)
	{
		//******INSERT YOUR CODE HERE***********
		if(size <k)
			{ return null; }
		else
		{
			
			double temp;
			double[] sortdata = new double[size]; //สร้างarrayที่จะsort =sortdata
			double[] mink = new double[k]; //สร้าง array สำหรับ mink
			
			for(int i=0;i<size;i++)
				{ sortdata[i] = data.get(i); }
			
			for(int i=0;i<size;i++)
		{
			for(int j=i+1;j<size;j++)
			{
				if(sortdata[i]<sortdata[j]) //ถ้าน้อยกว่าให้สลับไปข้างหลัง
				{
					temp = data.get(i);
					sortdata[i] = data.get(j);
					sortdata[j] = temp;
				}
			}
		}
			for(int i=0;i<k;i++)
				{ mink[i]=sortdata[i];}
			
			return mink;
		
		}		
	
		//**************************************
	}
	
	/**
	 * Print (via System.out.println()) the numbers in the list in format of:
	 * DATA[<N>]:[<n1>, <n2>, <n3>, ...]
	 * Where N is the size of the list. <ni> is the ith number in the list.
	 * E.g., "DATA[4]:[1.0, 2.0, 3.0, 4.0]"
	 */
	public void printData()
	{
		//******INSERT YOUR CODE HERE***********
		size = data.size() ;
		System.out.println("DATA["+size +"]:" +data) ;
		//**************************************
	}
}
