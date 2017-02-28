package memory;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import java.util.Scanner;

import guiPractice.components.ClickableScreen;
import guiPractice.components.Visible;

public class KevinLeaderboard extends ClickableScreen implements Runnable, MouseMotionListener
{
	public int combo;
	public int score;
	public static Scanner in;
	public int	 [] scores;
	public String[] names;
	
	
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
	}
	
	public static void insertionSort(int[] score, String[] names)
	{
	   for (int i=1; i < score.length; i++)
	   {
	      int sIndex = score[i]; 
	      String nIndex = names[i];
	      int j = i;
	      while (j > 0 && score[j-1] > sIndex)
	      {
	           score[j] = score[j-1];
	           names[j] = names[j-1];
	           j--;
	      }
	      score[j] = sIndex;
	      names[j] = nIndex;
	   }
	}
	public void addName()
	{
		System.out.println("Please enter your name");
		String input = in.nextLine();
		
		scores[10] = MemoryScreen.currentScore;
		names[10] = input;
		
		insertionSort(scores,names);
		
		//delete the last element of both lists
		// because last is not significant enough 
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
