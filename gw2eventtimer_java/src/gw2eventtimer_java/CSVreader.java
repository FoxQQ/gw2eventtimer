package gw2eventtimer_java;

import java.io.*;

public class CSVreader {
	String[][] myMat;
	
	public CSVreader(String path) throws IOException{
		myMat= Matrix(path);
	}
	
	
	public static String[][] Matrix(String path) throws IOException{
		
		String[][] myMatrix; 
		myMatrix = new String[24][7];
		String s ="";
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		
		for (int i=0; i<24; i++) 
		{
			s=br.readLine();
			myMatrix[i]=s.split(",");	
		}
		br.close();
	
	return myMatrix;
	}
	
	public String getEntry (int row, int col) throws IOException {
		
		String entry = myMat[row][col];
		return entry;
	}
	
	public void printMatrix () {
		for (int j=0; j<24; j++) 
		{
			for (int k=0; k<7; k++) 
			{
				System.out.print(myMat[j][k] + "@");
			}
			System.out.println();
		}
		
	}
}
