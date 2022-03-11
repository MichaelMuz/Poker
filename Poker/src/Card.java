// Card class represents a playing card 

  

public class Card 

{ 

     

    private String face; // face of card ie..."Ace","Deuce", "King"..etc 

    private String suit; // suit of card ie "Heart", "Diamond" 

    private int value; 

    static private String [] allValues = {"Deuce", "Three", "Four", "Five", "Six", "Seven", 

            "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"}; 

     

     

    // two argument card constructor 

    public Card( String cardFace, String cardSuit ) 

    { 

        face = cardFace; 

        suit = cardSuit; 

        for(int i = 2; i < allValues.length + 2; i++) { 

            if(allValues[i - 2].equals(cardFace)) { 

                value = i; 

            } 

        } 

    } 

     

    public String toString() 

    { 

        return face + " of " + suit; 

    } 

     

    public String getFaceValue() 

    { 

        return face; 

    } 

     

    public String getSuit() 

    { 

        return suit; 

    } 

    public int getValue() 

    { 

        return value; 

    } 

} 