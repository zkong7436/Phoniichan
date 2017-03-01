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
		in = new Scanner(System.in);
		
		int[] scores = {100000,90000,80000,70000,60000,50000,40000,30000,20000,10000};
		String[] names = {"Alpha","Beta","Gamma","Delta","Epsilon", "Zeta","Eta","Theta","Iota","Kappa"};
		for (int i = 0; i < 10;i++)
		{
			System.out.println(scores[i] + "," + names[i]);
		}
		System.out.print(scores.length + "," + names.length);
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
	           scores.set(j, j-1);
	           names.set(j, j-1);
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
		
		scores.add(MemoryScreen.currentScore);
		names.add(input);
		
		insertionSort(scores,names);

		scores.remove(scores.size()-1);
		names.remove(names.size()-1);
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
