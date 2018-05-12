package gw2eventtimer_java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fp = "E:\\0_myworkspace\\gw2eventtimer\\invasion_new.txt";
		MainFrame frame = new MainFrame(400,400);
		//read_csv(fp);
	}
	
	public static void read_csv(String filename) {
		System.out.println("Reading "+filename);
		Scanner scn;
		Hashtable<String,String> dict = new Hashtable<String, String>();
		int index=0;
		List<String> in = new ArrayList<>();

		try {
			scn = new Scanner(new File(filename));
			
			scn.useDelimiter(",");
			while (scn.hasNext()) {
				in.add(scn.next());
				index++;
			}
			scn.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(in != null) {
			for(int i=0;i<in.size();i++) {
				if(i%9==0)
				{
					System.out.print("Line"+i+":");
					for(int j=0;j<=7;j++) {
						System.out.print(in.get(i+j)+" - ");
					}
					System.out.println("\n");
				}
				
			}
		}
	
		
	}

}
