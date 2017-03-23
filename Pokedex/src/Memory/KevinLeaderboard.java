package Memory;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.ClickableScreen;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;
import main.Pokedex;

public class KevinLeaderboard extends main.PokedexScreen implements Runnable, MouseMotionListener
{
	private Button button;
	
	public int combo;
	public int score;
	public static Scanner in;
	public static Scanner in2;
	public static ArrayList<Integer> scores;
	public static ArrayList<String> names;
	public static ArrayList<TextLabel> vName;
	public static ArrayList<TextLabel> vScore;
	
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
	public void initAllObjects(ArrayList<Visible> viewObjects) 
	{
		vName = new ArrayList<TextLabel>();
		vScore = new ArrayList<TextLabel>();
		
		for(int i = 0; i < vName.size();i++)
		{
			vName.add(new TextLabel(50, 50, 50, 50, names.get(i)));
		}
		
		for(int i = 0; i < vScore.size();i++)
		{
			vScore.add(new TextLabel(50,50,50,50,"" + scores.get(i)+ ""));
		}
		button = new Button(35,230,100,45,"Return",Color.orange,new Action() 
		{
			public void act() 
			{
				Pokedex.game.setScreen(new MemoryScreen(getWidth(),getHeight()));
			}
		}); 
		viewObjects.add(button);
		for (int i = 0; i < vScore.size();i++)
		{
			viewObjects.add(vScore.get(i));
			viewObjects.add(vName.get(i));
		}
		System.out.println("displayed");
		
	}

	@Override
	public void initRemainingItems(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		
	}	
}