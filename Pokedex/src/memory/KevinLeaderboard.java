package memory;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import java.util.Scanner;

import guiPractice.components.ClickableScreen;
import guiPractice.components.Visible;

public class KevinLeaderboard extends ClickableScreen implements Runnable, MouseMotionListener
{
	public int combo;
	public int score;
	public static Scanner in;
	public static Scanner in2;
	public static ArrayList<Integer> scores;
	public static ArrayList<String> names;
	
	
	public KevinLeaderboard(int width, int height) 
	{
		super(width,height);
		Thread app = new Thread(this);
		app.start();
		
	}
	
	public static void main(String[] args)
	{
		scores = new ArrayList<Integer>();
		scores.add(90000);
		scores.add(60000);
		scores.add(30000);
		scores.add(70000);
		scores.add(100000);
		scores.add(50000);
		scores.add(40000);
		scores.add(20000);
		scores.add(80000);
		scores.add(10000);
		
		names = new ArrayList<String>();
		names.add("Alpha");
		names.add("Beta");
		names.add("Gamma");
		names.add("Delta");
		names.add("Epsilon");
		names.add("Zeta");
		names.add("Eta");
		names.add("Theta");
		names.add("Iota");
		names.add("Kappa");
		
		in = new Scanner(System.in);
	
		insertionSort(scores,names);
		for (int i = 0; i < 10;i++)
		{
			System.out.println(scores.get(i) + "," + names.get(i));
		}
		System.out.print(scores.size() + "," + names.size());
		
		addName();
		
		System.out.println("Leaderboard Updating....");
		for (int i = 0; i < 10;i++)
		{
			System.out.println(scores.get(i) + "," + names.get(i));
		}
		System.out.print(scores.size() + "," + names.size());
	}
	
	public static void insertionSort(ArrayList<Integer> scores, ArrayList<String> names)
	{
	   for (int i=1; i < scores.size(); i++)
	   {
	      int sIndex = scores.get(i); 
	      String nIndex = names.get(i);
	      int j = i;
	      while (j > 0 && scores.get(j-1) > sIndex)
	      {
	           scores.set(j, scores.get(j-1));
	           names.set(j, names.get(j-1));
	           j--;
	      }
	      scores.set(j, sIndex);
	      names.set(j, nIndex);
	   }
	}
	public static void addName()
	{
		System.out.println("Please enter your name");
		String input = in.nextLine();
		names.add(input);
		
		//testing purposes
//		System.out.println("What was your score just now?");
//		Integer input2 = Integer.parseInt(in.nextLine());
//		scores.add(input2);
		scores.add(MemoryScreen.currentScore);
		
		insertionSort(scores,names);

		scores.remove(0);
		names.remove(0);
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) 
	{
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) 
	{
		
	}

	@Override
	public void run() 
	{
		
	}

	@Override
	public void initAllObjects(ArrayList<Visible> arg0) 
	{
		
	} 
}
