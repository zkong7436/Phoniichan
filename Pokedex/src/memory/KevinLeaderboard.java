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
	public String[] leaderboard;
	public String[] name;
	public int	 [] scores;
	
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
		String[] name = {};
	}
	
	public static void sort()
	{
		
	}
	public int updateScore(boolean correct, int level, int combo, int currentScore)
	{
		if(correct == true)
		{
			MemoryScreen.combo = +1;
			MemoryScreen.currentScore =+ (combo * level);
		}
		else
		{
			MemoryScreen.combo = 1;
		}
		return currentScore;
	}
	
	public void addName()
	{
		System.out.println("Please enter your name");
		String input = in.nextLine();
		sort();
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
