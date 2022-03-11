import java.util.ArrayList;
import java.util.Collections;

public class Player {

	private Card hand[];

	private int nextPlace;

	double values[];

	int nextIndInVals;

	double totalHandValue;

	boolean handValCalled;

	public Player() {

		hand = new Card[5];

		nextPlace = 0;

		nextIndInVals = 0;

		totalHandValue = 0;

		handValCalled = false;

	}

	public void addCard(Card x) {

		if (nextPlace != 5) {

			hand[nextPlace] = x;

			nextPlace = nextPlace + 1;

			values = new double[15];

		}

		return;

	}

	public String toString() {

		String str = "";

		for (int i = 0; i < nextPlace; i++) {

			str = str + hand[i].getFaceValue() + " of " + hand[i].getSuit() + "," + "     ";

		}

		return str;

	}

	private void organizer() {

		Card temp;

		for (int i = 0; i < hand.length - 1; i++) {

			int minIndex = findMinimum(hand, i);

			if (minIndex != i) {

				temp = hand[i];

				hand[i] = hand[minIndex];

				hand[minIndex] = temp;

			}

		}

	}

	private static int findMinimum(Card[] a, int first) {

		int minIndex = first;

		for (int i = first + 1; i < a.length; i++) {

			if (a[i].getValue() < a[minIndex].getValue()) {

				minIndex = i;

			}

		}

		return minIndex;

	}

	public void handValue() {

		// System.out.println("nEXT");

		organizer();

		// for(int i = 0; i < hand.length; i ++) {

		// System.out.println(hand[i].getValue());

		// }

		// System.out.println("organizer " + nextIndInVals);

		flush();

		// System.out.println("flush " + nextIndInVals);

		straight();

		// System.out.println("straight " + nextIndInVals);

		threeOfAKind();
		
		fourOfAKind();
		
		twoPair();
		
		Pair();

		//System.out.println("smatYpes " + nextIndInVals);

		highCard();

		// System.out.println("highCard " + nextIndInVals);

		totalHandValue = 0;

		// for(int i = 0; i <= nextIndInVals; i ++) {

		// System.out.println(values[i]);

		// }
		//System.out.println("indval" + nextIndInVals);
		for (int i = 0; i <= (nextIndInVals); i++) {

			totalHandValue = totalHandValue + (values[i] * Math.pow(10, (15 - i)));

		}
		
		//System.out.println("nex");
		
		//for (int i = 0; i <= nextIndInVals; i++) {

			//System.out.println(values[i]);

		//}

	}

	public double getTotalHandValue() {

		if (!handValCalled) {

			handValue();

			handValCalled = true;

		}

		// System.out.println(totalHandValue);

		return totalHandValue;

	}
	
	
	private void Pair() {
		ArrayList<String> hander = new ArrayList<String>();
		for(int i = 0; i < hand.length; i++) {
			hander.add(hand[i].getFaceValue());
		}
		
		int skipped = -1;
		for(int i = hand.length - 1; i >= 0; i--) {
			
			if(Collections.frequency(hander, hand[i].getFaceValue()) == 2) {
				skipped = i;
				break;
						
			}
			
			
		}
		if(skipped != -1) {
			values[nextIndInVals] = skipped;
		}
		
		
		nextIndInVals ++;
		
		
		
	}
	
	
	private void twoPair() {
		ArrayList<String> hander = new ArrayList<String>();
		for(int i = 0; i < hand.length; i++) {
			hander.add(hand[i].getFaceValue());
		}
		int skipped = -1;
		for(int i = hand.length - 1; i >= 0; i--) {
			
			if(Collections.frequency(hander, hand[i].getFaceValue()) == 2) {
				skipped = i;
				break;
						
			}
			
			
		}
		int other = -1;
		for(int i = hand.length - 1; i >= 0; i--) {
			if(i == skipped) {
				continue;
			}
			if(Collections.frequency(hander, hand[i].getFaceValue()) == 2) {
				other = i;
						
			}
			
			
		}
		
		if((other != -1) && (skipped != -1)) {
			values[nextIndInVals] = skipped;
			values[nextIndInVals + 1] = other;
		}
		
		nextIndInVals = nextIndInVals + 2;
		
		
		
	}
	
	private void fourOfAKind() {
		//Collections.frequency(hander, hand[i].getFaceValue())
		ArrayList<String> hander = new ArrayList<String>();
		for(int i = 0; i < hand.length; i++) {
			hander.add(hand[i].getFaceValue());
		}
				
		for(int i = 0; i < hand.length; i++) {
			if(Collections.frequency(hander, hand[i].getFaceValue()) == 4) {
				values[nextIndInVals] = hand[i].getValue();
						
			}
		}
				
			
		nextIndInVals ++;		
	}
	
	private void threeOfAKind() {
		//Collections.frequency(hander, hand[i].getFaceValue())
		ArrayList<String> hander = new ArrayList<String>();
		for(int i = 0; i < hand.length; i++) {
			hander.add(hand[i].getFaceValue());
		}
		
		for(int i = 0; i < hand.length; i++) {
			if(Collections.frequency(hander, hand[i].getFaceValue()) == 3) {
				values[nextIndInVals] = hand[i].getValue();
				
			}
		}
		
	
		nextIndInVals ++;

	}

	private void highCard() {

		/*
		 * 
		 * int highest = 0;
		 * 
		 * 
		 * 
		 * for(int i = 0; i < hand.length; i ++) {
		 * 
		 * 
		 * 
		 * if(hand[i].getValue() > highest) {
		 * 
		 * 
		 * 
		 * highest = hand[i].getValue();
		 * 
		 * 
		 * 
		 * }
		 * 
		 * 
		 * 
		 * }
		 * 
		 * 
		 * 
		 * 
		 * 
		 * System.out.println("highest: " + highest);
		 * 
		 * values[nextIndInVals] = highest;
		 * 
		 */
		for (int i = hand.length - 1; i >= 0; i--) {
			values[nextIndInVals] = (hand[i]).getValue();
			nextIndInVals++;
		}
		// System.out.println("highest: " + (hand[hand.length - 1]).getValue());
		// values[nextIndInVals] = (hand[hand.length - 1]).getValue();

		// nextIndInVals ++;

	}

	private void straight() {


		Card curr = hand[hand.length - 1];

		for (int i = hand.length - 1; i >= 0; i--) {

			if (!(curr.getValue() == (hand[i].getValue() - i))) {
				nextIndInVals++;
				return;

			}

			curr = hand[i];

		}

		values[nextIndInVals] = hand[hand.length - 1].getValue();

		nextIndInVals++;

	}

	private void flush() {

		Card curr = hand[0];

		for (int i = 1; i < hand.length; i++) {

			if (!curr.getSuit().equals(hand[i].getSuit())) {

				nextIndInVals++;
				return;

			}

			curr = hand[i];

		}

		
		values[nextIndInVals] = hand[hand.length - 1].getValue();

		nextIndInVals++;
		

	}

	/*
	 * 
	 * 
	 * 
	 * public int ofOneKind(Card c) {
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * int kind = 1;
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * for(int i = 0; i < hand.length; i ++) {
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * //for(int x = 0; x < hand.length; x ++) {
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * if(hand[i].getFaceValue().equals(c.getFaceValue())) {
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * kind ++;
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * //}
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * return kind;
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * public boolean isPair() {
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * for(int i = 0; i < hand.length; i ++) {
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * if(ofOneKind(hand[i]) == 2) {
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * return true;
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * //if(ofOneKind() == 2) {
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * //}
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * return false;
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * public boolean isTwoPair() {
	 * 
	 * 
	 * 
	 * boolean hasOne = false;
	 * 
	 * 
	 * 
	 * int skip = -1;
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * for(int i = 0; i < hand.length; i ++) {
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * if(ofOneKind(hand[i]) == 2) {
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * hasOne = true;
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * if(!hasOne) {
	 * 
	 * 
	 * 
	 * return false;
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * for(int i = 0; i < hand.length; i ++) {
	 * 
	 * 
	 * 
	 * if(skip == i) {
	 * 
	 * 
	 * 
	 * continue;
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * if(ofOneKind(hand[i]) == 2) {
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * return true;
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * //if(ofOneKind() == 2) {
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * //}
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * return false;
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * public boolean isThreeOfAKind() {
	 * 
	 * 
	 * 
	 * for(int i = 0; i < hand.length; i ++) {
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * if(ofOneKind(hand[i]) == 3) {
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * return true;
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * return false;
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * public Card HighCard() {
	 * 
	 * 
	 * 
	 * for(int)
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 */

}
