//Evan J Gniadek period 3
//The purpose of this code is to test my ability to use queues and stacks 


import java.util.Scanner;
import java.io.File;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayDeque;
import java.util.Deque;

public class MyProgram {
	public static int val = 0;
	public static void main(String[] args) {

		int limitTrackA = 100000, limitTrackB = 100000, limitTrackC = 100000;
		ArrayDeque<Train> track0 = new ArrayDeque<Train>();

		Scanner x = new Scanner(System.in);
			
			try{
			File f = new File("HelloWorldProject/src/data.txt");
			x = new Scanner (f);
			while(x.hasNextLine()){	
				String name = x.nextLine();
				if(name.indexOf("CAR") != -1)
				{
					track0.addLast(new Train(name, x.nextLine(), x.nextLine(), x.nextLine(), Integer.valueOf(x.nextLine()), Integer.valueOf(x.nextLine())));
				}
				else
				{
					track0.addLast(new Train(name, x.nextLine()));
				}
					
			}

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("yep");
		

		ArrayDeque<Train> trackA = new ArrayDeque<Train>();
		ArrayDeque<Train> trackB = new ArrayDeque<Train>();
		ArrayDeque<Train> trackC = new ArrayDeque<Train>();
		ArrayDeque<Train> trackD = new ArrayDeque<Train>();
		int weightA = 0, weightB = 0, weightC = 0;

		while(!track0.isEmpty()){
			Train temp = track0.removeFirst();
			System.out.println(weightA);
			//System.out.println("trenton " + weightA); System.out.println("Charlotte " + weightB); System.out.println("Baltimore " +weightC);
			if(temp.getDestination().equals("Trenton"))
			{
				if(temp.getName().indexOf("CAR") == -1)
				{
					trackA.addFirst(temp);
					printTrack(trackA);
					trackA.clear();
					weightA = 0;
				}//end of if 
				else if(temp.getWeight() + weightA > limitTrackA) 
				{
						trackA.addFirst(new Train("ENG00000", "trenton"));
						printTrack(trackA);
						trackA.clear();
						weightA = 0;
						trackA.addFirst(temp);
						weightA += temp.getWeight();

				}			//end of else if 	
				else
				{ 
					trackA.addFirst(temp);
					weightA += temp.getWeight();
				} //end of else
			} //end of if
			else if(temp.getDestination().equals("Charlotte"))
			{
				if(temp.getName().indexOf("CAR") == -1)
				{
					trackB.addFirst(temp);
					printTrack(trackB);
					trackB.clear();
					weightB = 0;
				}//end of if 
				else if(temp.getWeight() + weightB > limitTrackB) 
				{
					trackB.addFirst(new Train("ENG00000", "Charlotte"));
					printTrack(trackB);
					trackB.clear();
					weightB = 0;
					trackB.addFirst(temp);
					weightB += temp.getWeight();
		
				}		//end of else if 
				else{
					trackB.addFirst(temp);
					weightB += temp.getWeight();

				}//end of else 
			}
			else if(temp.getDestination().equals("Baltimore"))
			{
				if(temp.getName().indexOf("CAR") == -1)
				{
					trackC.addFirst(temp);
					printTrack(trackC);
					trackC.clear();
					weightC = 0;
				}//end of if 
				else if(temp.getWeight() + weightC > limitTrackC) 
				{
					trackC.addFirst(new Train("ENG00000", "Baltimore"));
					printTrack(trackC);
					trackC.clear();
					weightC = 0;
					trackC.addFirst(temp);
					weightC += temp.getWeight();
				}//end of else if 
				else
				{
					trackC.addFirst(temp);	
					weightC += temp.getWeight();	
				}//end of else 
				}
			else
			{
				if(temp.getName().indexOf("CAR") == -1)
				{
					trackD.addFirst(temp);
					printTrack(trackD);
					trackD.clear();
				}//end of if 
				else
					trackD.addFirst(temp);
			}
		}//end of while
		trackA.addFirst(new Train("ENG00000", "Trenton"));

		printTrack(trackA);
		trackA.clear();
		trackB.addFirst(new Train("ENG00000", "Charlotte"));

		printTrack(trackB);
		trackB.clear();
		trackC.addFirst(new Train("ENG00000", "Baltimore"));

		printTrack(trackC);


		trackC.clear();
		trackD.addFirst(new Train("ENG00000", "Anywhere"));

		printTrack(trackD);
		trackD.clear();
		}
		
		public static void printTrack(ArrayDeque<Train> track){
			if(track.isEmpty()) return;
			Train temp = track.removeFirst();
			System.out.println(temp.getName() + " leaving for " + temp.getDestination() + " with the following cars: " );
			while(!track.isEmpty())
				System.out.println(track.removeFirst().toString());
		}//end of this method 
	}//end of this class