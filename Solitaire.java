package solitaire;

import java.io.IOException;
import java.util.Scanner;
import java.util.Random;
import java.util.NoSuchElementException;

/**
 * This class implements a simplified version of Bruce Schneier's Solitaire Encryption algorithm.
 * 
 * @author RU NB CS112
 */
public class Solitaire {
	
	/**
	 * Circular linked list that is the deck of cards for encryption
	 */
	CardNode deckRear;
	
	/**
	 * Makes a shuffled deck of cards for encryption. The deck is stored in a circular
	 * linked list, whose last node is pointed to by the field deckRear
	 */
	public void makeDeck() {
		// start with an array of 1..28 for easy shuffling
		int[] cardValues = new int[28];
		// assign values from 1 to 28
		for (int i=0; i < cardValues.length; i++) {
			cardValues[i] = i+1;
		}
		
		// shuffle the cards
		Random randgen = new Random();
 	        for (int i = 0; i < cardValues.length; i++) {
	            int other = randgen.nextInt(28);
	            int temp = cardValues[i];
	            cardValues[i] = cardValues[other];
	            cardValues[other] = temp;
	        }
	     
	    // create a circular linked list from this deck and make deckRear point to its last node
	    CardNode cn = new CardNode();
	    cn.cardValue = cardValues[0];
	    cn.next = cn;
	    deckRear = cn;
	    for (int i=1; i < cardValues.length; i++) {
	    	cn = new CardNode();
	    	cn.cardValue = cardValues[i];
	    	cn.next = deckRear.next;
	    	deckRear.next = cn;
	    	deckRear = cn;
	    }
	}
	
	/**
	 * Makes a circular linked list deck out of values read from scanner.
	 */
	public void makeDeck(Scanner scanner) 
	throws IOException {
		CardNode cn = null;
		if (scanner.hasNextInt()) {
			cn = new CardNode();
		    cn.cardValue = scanner.nextInt();
		    cn.next = cn;
		    deckRear = cn;
		}
		while (scanner.hasNextInt()) {
			cn = new CardNode();
	    	cn.cardValue = scanner.nextInt();
	    	cn.next = deckRear.next;
	    	deckRear.next = cn;
	    	deckRear = cn;
		}
	}
	
	/**
	 * Implements Step 1 - Joker A - on the deck.
	 */
	void jokerA() {
		// COMPLETE THIS METHOD
		if(deckRear.cardValue == 27){
			CardNode prevNode;
			for(prevNode= deckRear; prevNode.next.cardValue != 27; prevNode= prevNode.next){
				
			}
			prevNode.next= deckRear.next;
			deckRear.next= deckRear.next.next;
			prevNode.next.next= deckRear;
			deckRear= prevNode.next;
			
		}
		else{
			CardNode jokerNode;
			for(jokerNode= deckRear; jokerNode.cardValue != 27; jokerNode= jokerNode.next){
				
			}
			CardNode prevNode;
			for(prevNode= deckRear; prevNode.next.cardValue != 27; prevNode= prevNode.next){
				
			}
			prevNode.next= jokerNode.next;
			jokerNode.next= prevNode.next.next;
			prevNode.next.next= jokerNode;
			
			if(deckRear.next== jokerNode){
				deckRear= jokerNode;
			}
		}
	}
	
	/**
	 * Implements Step 2 - Joker B - on the deck.
	 */
	void jokerB() {
	    // COMPLETE THIS METHOD
		CardNode prevNode;
		for(prevNode= deckRear; prevNode.next.cardValue != 28; prevNode= prevNode.next){
			
		}
		CardNode jokerNode;
		for(jokerNode= deckRear; jokerNode.cardValue != 28; jokerNode= jokerNode.next){
			
		}
		CardNode secondlastNode;
		for(secondlastNode= deckRear; secondlastNode.next != deckRear; secondlastNode= secondlastNode.next){
			
		}
		
		if(deckRear.cardValue == 28){
			prevNode.next= deckRear.next;
			deckRear.next= deckRear.next.next;
			prevNode.next.next= deckRear;
			deckRear= prevNode.next;
			
			prevNode= prevNode.next;
			
			prevNode.next= jokerNode.next;
			jokerNode.next= prevNode.next.next;
			prevNode.next.next= jokerNode;
			
			if(deckRear.next== jokerNode){
				deckRear= jokerNode;
			}
			prevNode= prevNode.next;
			
		}
		else if(secondlastNode.cardValue == 28){
			prevNode.next= jokerNode.next;
			jokerNode.next= prevNode.next.next;
			prevNode.next.next= jokerNode;
			
			if(deckRear.next== jokerNode){
				deckRear= jokerNode;
			}
			prevNode= prevNode.next;
			
			prevNode.next= deckRear.next;
			deckRear.next= deckRear.next.next;
			prevNode.next.next= deckRear;
			deckRear= prevNode.next;
			prevNode= prevNode.next;
			
		}
		else{
			prevNode.next= jokerNode.next;
			jokerNode.next= prevNode.next.next;
			prevNode.next.next= jokerNode;
			
			if(deckRear.next== jokerNode){
				deckRear= jokerNode;
			}
			prevNode= prevNode.next;
			
			prevNode.next= jokerNode.next;
			jokerNode.next= prevNode.next.next;
			prevNode.next.next= jokerNode;
			
			if(deckRear.next== jokerNode){
				deckRear= jokerNode;
			}
			prevNode= prevNode.next;
		}
	}
	
	/**
	 * Implements Step 3 - Triple Cut - on the deck.
	 */
	void tripleCut() {
		// COMPLETE THIS METHOD
		

		if(deckRear.cardValue == 27 && deckRear.next.cardValue == 28){ //first and last cards are jokers
			return;
		}
		
		else if(deckRear.cardValue == 28 && deckRear.next.cardValue == 27){ //first and last cards are jokers
			return;
		}
		
		else if(deckRear.cardValue == 27 || deckRear.cardValue == 28){ //there are no cards after the second joker
			CardNode firstjokerprev;
			for(firstjokerprev= deckRear.next; firstjokerprev != deckRear; firstjokerprev= firstjokerprev.next){
				if(firstjokerprev.next.cardValue == 27 || firstjokerprev.next.cardValue == 28){
					break;
				}
			}
			
			deckRear= firstjokerprev;
			
		}
		
		else if(deckRear.next.cardValue == 27 || deckRear.next.cardValue == 28){ //there are no cards before the first joker
			CardNode secondjoker;
			for(secondjoker= deckRear.next.next; secondjoker != deckRear.next; secondjoker= secondjoker.next){
				if(secondjoker.cardValue == 27 || secondjoker.cardValue == 28){
					break;
				}
			}
			
			deckRear= secondjoker;
			
		}
		
		else{

			CardNode firstnode= deckRear.next;
			CardNode lastnode= deckRear;
			CardNode firstjokerprev;
			for(firstjokerprev= deckRear.next; firstjokerprev != deckRear; firstjokerprev= firstjokerprev.next){
				if(firstjokerprev.next.cardValue == 27 || firstjokerprev.next.cardValue == 28){
					break;
				}

			}
			CardNode firstjoker= firstjokerprev.next;
			CardNode secondjoker;
			for(secondjoker= firstjoker.next; secondjoker != deckRear; secondjoker= secondjoker.next){
				if(secondjoker.cardValue == 27 || secondjoker.cardValue == 28){
					break;
				}
		
			}
			CardNode secondjokerafter= secondjoker.next;
			
			lastnode.next= firstjoker;
			secondjoker.next= firstnode;
			firstjokerprev.next= secondjokerafter;
			
			deckRear= firstjokerprev;
			
		}
	}
	
	/**
	 * Implements Step 4 - Count Cut - on the deck.
	 */
	void countCut() {		
		// COMPLETE THIS METHOD
		CardNode prevnode;
		for(prevnode= deckRear; prevnode.next != deckRear; prevnode= prevnode.next){
			
		}
		
		
		
		CardNode startlist= deckRear.next;
		CardNode endlist; 
		int count= 1;
		if(deckRear.cardValue == 28 || deckRear.cardValue == 27 ) return;

		if(deckRear.cardValue == 28){
			for(endlist= startlist; count< 27; endlist= endlist.next){
				count++;
			}
		}
		else{
			for(endlist= startlist; count< deckRear.cardValue; endlist= endlist.next){
				count++;
			}
		}
		
		deckRear.next= endlist.next;
		prevnode.next= startlist;
		endlist.next= deckRear;
	}
	
	/**
	 * Gets a key. Calls the four steps - Joker A, Joker B, Triple Cut, Count Cut, then
	 * counts down based on the value of the first card and extracts the next card value 
	 * as key. But if that value is 27 or 28, repeats the whole process (Joker A through Count Cut)
	 * on the latest (current) deck, until a value less than or equal to 26 is found, which is then returned.
	 * 
	 * @return Key between 1 and 26
	 */
	int getKey() {
		// COMPLETE THIS METHOD
		int key= 0;
		
		while(true){
		jokerA();
		jokerB();
		tripleCut();
		countCut();
		int firstcard= deckRear.next.cardValue;
		
		int count= 0;
		CardNode ptr;
		if(firstcard== 28){
			for(ptr= deckRear; count< 27; ptr= ptr.next){
			count++;	
			}
		}
		else{
			for(ptr= deckRear; count< firstcard; ptr= ptr.next){
				count++;	
				}
		}
		
		if(ptr.next.cardValue != 27 && ptr.next.cardValue != 28){
			key= ptr.next.cardValue;
			break;
		}
		
		}
		
		
	    return key;
	}
	
	/**
	 * Utility method that prints a circular linked list, given its rear pointer
	 * 
	 * @param rear Rear pointer
	 */
	private static void printList(CardNode rear) {
		if (rear == null) { 
			return;
		}
		System.out.print(rear.next.cardValue);
		CardNode ptr = rear.next;
		do {
			ptr = ptr.next;
			System.out.print("," + ptr.cardValue);
		} while (ptr != rear);
		System.out.println("\n");
	}

	/**
	 * Encrypts a message, ignores all characters except upper case letters
	 * 
	 * @param message Message to be encrypted
	 * @return Encrypted message, a sequence of upper case letters only
	 */
	public String encrypt(String message) {	
		// COMPLETE THIS METHOD

		String finalmsg= "";
		
		for(int count= 0; count< message.length(); count++){
			char alphabet= message.charAt(count);
			if(Character.isLetter(alphabet)== false){				
				continue;
			}
			
			int keystream= getKey();
			alphabet= Character.toUpperCase(alphabet);
			
			int encryptsum= keystream + ((alphabet - 'A') + 1);
			
			if(encryptsum> 26){
				encryptsum= encryptsum-26;
			}
			
			
			char encrypt= Character.toUpperCase((char)((encryptsum - 1) + 'A'));
						
			
			finalmsg= finalmsg + encrypt;
			
		}
		
	    return finalmsg;
	}
	
	/**
	 * Decrypts a message, which consists of upper case letters only
	 * 
	 * @param message Message to be decrypted
	 * @return Decrypted message, a sequence of upper case letters only
	 */
	public String decrypt(String message) {	
		// COMPLETE THIS METHOD
		String decryptmsg= "";
		
		for(int c= 0; c< message.length(); c++){
			int key= getKey();
			char code= Character.toUpperCase(message.charAt(c));
			
			int decryptnum= 0;
			int codenum= (code - 'A') + 1;
			if(codenum <= key){
				decryptnum= (26 + codenum) - key;
			}
			else{
				decryptnum= codenum - key;
			}
			
			char decrypt= Character.toUpperCase((char)((decryptnum -1) + 'A'));
			
			decryptmsg= decryptmsg + decrypt;
		}
		
	    return decryptmsg;
	}
}
