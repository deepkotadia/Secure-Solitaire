package solitaire;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class tester {

	public static void traverse (CardNode rear){

		if (rear == null){
		System.out.println("empty");
		return;
		}

		CardNode ptr = rear.next;//front



		do{
		System.out.print("->" + ptr.cardValue + "-");
		ptr = ptr.next;

		}while(ptr!= rear.next);



		}




		public static void main (String[] args) throws FileNotFoundException, IOException{

		Solitaire ss = new Solitaire();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter deck file name => ");
		Scanner sc = new Scanner(new File(br.readLine()));


		ss.makeDeck(sc);
		/*
		System.out.println("original");
		traverse(ss.deckRear);

		System.out.println();

		ss.jokerA();

		System.out.println("jokera");
		traverse(ss.deckRear);


		System.out.println();
		ss.jokerB();

		System.out.println("joker b");
		traverse(ss.deckRear);

		System.out.println();
		ss.tripleCut();

		System.out.println("triple cut");
		traverse(ss.deckRear);

		System.out.println();
		ss.countCut();

		System.out.println("count cut");
		traverse(ss.deckRear);
		*/

		/*for(int i=1; i<20 ; i++)
		{
			System.out.println("Round: " + i);
		
		traverse(ss.deckRear);
		System.out.println();
		ss.jokerA();		
		System.out.println("jokerA");
		traverse(ss.deckRear);
		System.out.println();
		ss.jokerB();
		System.out.println("jokerB");
		traverse(ss.deckRear);
		System.out.println();
		ss.tripleCut();
		System.out.println("Triple Cut");
		traverse(ss.deckRear);
		System.out.println();
		ss.countCut();
		System.out.println("Count Cut");
		traverse(ss.deckRear);
		System.out.println();
		}*/
		
		traverse(ss.deckRear);
		ss.tripleCut();
		System.out.println();
		traverse(ss.deckRear);
		}

}

