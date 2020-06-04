// A Java program for a Server 
import java.net.*; 
import java.io.*; 
import java.util.*;
public class Server 
{ 
    

    // constructor with port 
    public static void main(String[] args) throws IOException
    { 

        int portNumber = 10;
        int servtie = 0;
        int constie = 0;
        Scanner console = new Scanner(System.in);
        String swapplace = "a";
        String amtplace = "a";
        double serverscore = 0;
        double clientscore = 0;
        int money1 = 100;
        int money2 = 100;
        int bet = 0;
        double betdouble = 0;
        
        int fa = 0;
        int fb = 0;
        int goon = 1;
        int amountswap = 0;
        int amt = 0;
        int betcheck = 0;
        
        Random numbers = new Random();
        String cont = "yes"; 
        try
         (
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        ){

            String inputLine, outputLine;

        

        while(cont.equals("yes")){

        
            //Choosing a bet amount


        System.out.print("Choose a betting amount <= $100: ");

        betcheck = 0;
        while(betcheck==0){
            String betstring = console.next();

        try{
            Double.parseDouble(betstring);
            betdouble = Double.parseDouble(betstring);
            betcheck = 1;
        } catch (NumberFormatException e) {
            System.out.print("Choose a valid bet: ");
        }
        }
        bet = (int) betdouble;
        out.println("The bet is $"+bet);
        
            //


            //setup of decks

        int[][] deck = new int[13][4];
        int[][] player = new int[13][4];
        int[][] player2 = new int[13][4];
        for(int a = 0;a<13;a++){
            for(int b = 0;b<4;b++){
                deck[a][b] = 1;
                player[a][b] = 0;
                player2[a][b] = 0;
            }
        }
        for(int i = 1;i<=5;i++){
            while(goon == 1){
                fa = numbers.nextInt(13);
                fb = numbers.nextInt(4);
                if(deck[fa][fb]==1){
                    player[fa][fb] = i;
                    deck[fa][fb] = 0;
                    goon = 0;
                }
                
            }
            //System.out.println(fa+" "+fb);
            goon = 1;
        }
        System.out.println("Your Cards: ");
        System.out.println(printout(player,0));
        System.out.print("Currently, you have a ");
        System.out.println(strreveal(player, 0));
        for(int i = 1;i<=5;i++){
            while(goon == 1){
                fa = numbers.nextInt(13);
                fb = numbers.nextInt(4);
                if(deck[fa][fb]==1){
                    player2[fa][fb] = i;
                    deck[fa][fb] = 0;
                    goon = 0;
                }
                
            }
            //System.out.println(fa+" "+fb);
            goon = 1;
        }
        out.println("Your Cards: ");
        outputLine = printout(player2, 0);
        
        out.println(outputLine);
        out.print("Currently, you have a ");
        out.println(strreveal(player2, 0));
        out.println("Waiting for Opponent...");

        //



            //swapping server cards

        System.out.print("How many cards to swap: ");
        
        amountswap = getInt();
        while(amountswap>5){
            System.out.print("Please enter a number between 0 and 5: ");
            amountswap = getInt();
        }
        //amountswap = console.nextInt();
        if(amountswap > 0){
            if(amountswap != 5){
                System.out.print("Which card numbers: ");
            }
        }

        int[] swapped = new int[5];


        for(int n = 0;n<amountswap;n++){
            if(amountswap == 5){
                amt = n+1;
            } else {
                amt = getInt();
                //amt--;
                while(swapped[amt-1] == 1){
                    System.out.println("Please enter a card you haven't swapped yet.");
                    amt = getInt();
                }
                swapped[amt-1] = 1;
            }
            for(int a = 0;a<13;a++){
                for(int b = 0;b<4;b++){
                    if(player[a][b] == amt){
                        player[a][b] = 0;
                    }
                }
            }
            while(goon == 1){
                fa = numbers.nextInt(13);
                fb = numbers.nextInt(4);
                if(deck[fa][fb]==1){
                    player[fa][fb] = amt;
                    deck[fa][fb] = 0;
                    goon = 0;
                }
                
            }
            goon = 1;
               
        }

        System.out.println("Waiting for Opponent...");


            //swapping client cards
    
        amountswap = 555;
        
        while(amountswap == 555){
            out.println("How many cards to swap: ");
            swapplace = in.readLine();
        try{
            Integer.parseInt(swapplace);
            amountswap = Integer.parseInt(swapplace);
        } catch (NumberFormatException e){
            
        }
        }

        if(amountswap > 5){
            amountswap = 5;
        }
        if(amountswap < 0){
            amountswap = 0;
        }

        if(amountswap > 0){
            if(amountswap != 5){
                out.println("Which card numbers: ");
            }
        }
        
        int[] oppswapped = new int[5];

        for(int n = 0;n<amountswap;n++){
            if(amountswap == 5){
                amt = n+1;
            } else {
            

                amt = 555;
        
                while(amt == 555){
                    out.println("swap: ");
                    amtplace = in.readLine();
                    try{
                        Integer.parseInt(amtplace);
                        amt = Integer.parseInt(amtplace);
                        //amt--;
                    } catch (NumberFormatException e){
                    
                    }
                }
                while(oppswapped[amt-1] == 1){
                    amt = 555;
        
                while(amt == 555){
                    out.println("Please enter a card number you haven't chosen yet.");
                    out.println("swap: ");
                    amtplace = in.readLine();
                    try{
                        Integer.parseInt(amtplace);
                        amt = Integer.parseInt(amtplace);
                        //amt--;
                        
                    } catch (NumberFormatException e){
                       
                    }
                }
                }
                
                oppswapped[amt-1] = 1;



            }
            for(int a = 0;a<13;a++){
                for(int b = 0;b<4;b++){
                    if(player2[a][b] == amt){
                        player2[a][b] = 0;
                    }
                }
            }
            while(goon == 1){
                fa = numbers.nextInt(13);
                fb = numbers.nextInt(4);
                if(deck[fa][fb]==1){
                    player2[fa][fb] = amt;
                    deck[fa][fb] = 0;
                    goon = 0;
                }
                
            }
            goon = 1;
               
        }
        
        //out.println("--------------------------\n");


            //printing out hands

        System.out.println("--------------------------\n");
        System.out.println("Your Opponent's cards: ");
        System.out.println(printout(player2,0));

        System.out.println("Your Swapped Cards: ");
        System.out.println(printout(player, 0));
        System.out.println("--------------------------\n");

        
        System.out.print("Your opponent got a ");
        System.out.println(strreveal(player2,0));
        System.out.print("You got a ");
        System.out.println(strreveal(player, 0));
        System.out.println();

        out.println("--------------------------\n");

        out.println("Your Opponent's cards: ");
        out.println(printout(player,0));
        out.println("Your Swapped Cards: ");
        out.println(printout(player2, 0));
        out.println("--------------------------\n");
        
        out.println("Your opponent got a "+strreveal(player, 0));
        out.println("You got a "+strreveal(player2, 0));
        out.println();


            //deciding and displaying a winner

        serverscore = handreveal(player, 0);
        clientscore = handreveal(player2, 0);
        if(serverscore > clientscore){
            System.out.println("You win");
            out.println("You lose");
            money1+=bet;
            money2 -=bet;
            
        } else {
            
            if(serverscore == clientscore){
                for(int a = 12;a>=0;a--){
                for(int b = 3;b>=0;b--){

                    servtie+=a*(player[a][b]);
                
                    constie+=a*(player2[a][b]);
                    
                }        
                if(servtie != constie){
                    a=-1;
                }
                }

                if(servtie>constie){
                    System.out.println("You win");
                    out.println("You lose");
                    money1+=bet;
                    money2-=bet;
                } else {
                    System.out.println("You lose");
                    out.println("You win");
                    money1-=bet;
                    money2+= bet;
                }
            
            } else {
                System.out.println("You lose");
                out.println("You win");
                money1-=bet;
                money2+= bet;
            }
           

        }
        
        out.println("You have $"+money2);
        System.out.println("You have $"+money1);

        if(money1 <=0){
            System.out.println("You lost all your money. Client is the winner.");
            out.println("Your opponent lost all their money. You are the winner!");
        }
        if(money2 <=0){
            System.out.println("Your opponent lost all their money. You are the winner!");
            out.println("You lost all your money. Server is the winner.");
        }


            //continuing game

        if(money1 >0 && money2> 0){
            System.out.println();
            System.out.print("Continue? Type yes or no: ");
            cont = console.next();
            if(cont.equals("yes")){
                out.println("Continue? Type yes or no: ");
                cont = in.readLine();
            }
        } else {
            cont = "no";
        }
        


        }
        
        
         
        } 
        catch(IOException i) 
        { 
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(i.getMessage());
        } 
    }
    
    
    
    




    
        //method for hand value (double)
    
    public static double handreveal(int[][] player, int joab){

        String hand = "a";
        //String handadd = "";
        int high = 0;
        int bigscore = 0;
        int high1 = 0;
        int high2 = 0;
        int[] paircount = new int[13];
        int[] straightcheck = new int[5];
        int[] flushcheck = new int[5];

        int straight = 0;
        int flush = 0;
        for(int a = 0;a<13;a++){
        for(int b = 0;b<4;b++){
            if(player[a][b] >0){
                paircount[a]+= 1;
                straightcheck[player[a][b]-1] = a;
                flushcheck[player[a][b]-1] = b;
                if(a > high){
                    high = a;
                }
                if(a < high){
                    if(a > high1){
                        high1 = a;
                    } 
                }
                
            
            }
            
        }
        }
        hand = "High Card";

        int doublepair = 0;
        int threekind = 0;
        for(int i = 0;i<13;i++){
            if(paircount[i] == 2){
                doublepair++;
                hand = "Pair";
                
                bigscore = 30;
                high = i;
            }
            
            if(paircount[i] == 3){
                hand = "Three of a Kind";
                
                threekind++;
                bigscore = 100;
                high = i;
            }
            if(paircount[i] == 4){
                hand = "Four of a Kind";
                
                bigscore = 250;
                high = i;
            }
        }
        if(doublepair == 2){
            hand = "Two Pair";
            bigscore = 50;
            
        }
        if(threekind == 1){
            if(doublepair == 1){
                hand = "Full House";
                bigscore = 200;
            }
        }
        if(straightcheck[1] -1 == straightcheck[0]){
            if(straightcheck[2]-1==straightcheck[1]){
                if(straightcheck[3]-1==straightcheck[2]){
                    if(straightcheck[4]-1 == straightcheck[3]){
                        straight = 1;
                        hand = "Straight";
                        bigscore = 100;
                        high = straightcheck[4];
                    }
                }
            }
        }
        if(flushcheck[0] == flushcheck[1]){
            if(flushcheck[1] == flushcheck[2]){
                if(flushcheck[2] == flushcheck[3]){
                    if(flushcheck[3] == flushcheck[4]){
                        flush = 1;
                        hand = "Flush";
                        bigscore = 150;
                        high = flushcheck[4];
                    }
                }
            }
        }
        if(flush == 1){
            if(straight == 1){
                hand = "Straight Flush";
            }
            bigscore = 1000;
        }

        
        //double playernumscore = high+bigscore+(((double)high1)*0.1);
        double playernumscore = high+bigscore;
        if(joab == 5){
            System.out.print(hand);

        }
        //System.out.print(" "+playernumscore);
        return playernumscore;


    }


        //method for printing out hand TYPE

    public static String strreveal(int[][] player, int joab){
        String hah =  "";
        String hand = "a";
        String handadd = "";
        int high = 0;
        int bigscore = 0;
        int high1 = 0;
        int high2 = 0;
        int[] paircount = new int[13];
        int[] straightcheck = new int[5];
        int[] flushcheck = new int[5];

        int straight = 0;
        int flush = 0;
        for(int a = 0;a<13;a++){
        for(int b = 0;b<4;b++){
            if(player[a][b] >0){
                paircount[a]+= 1;
                straightcheck[player[a][b]-1] = a;
                flushcheck[player[a][b]-1] = b;
                if(a > high){
                    high = a;
                }
                if(a < high){
                    if(a > high1){
                        high1 = a;
                    } 
                }
                
            
            }
            
        }
        }
        
        hand = "High Card";

        int doublepair = 0;
        int threekind = 0;
        for(int i = 0;i<13;i++){
            if(paircount[i] == 2){
                doublepair++;
                hand = "Pair";
                if(i<=8){
                    handadd+= " ("+(i+2)+")";
                }
                if(i==9){
                    handadd+= " (jack)";
                }
                if(i==10){
                    handadd+= " (queen)";
                }
                if(i == 11){
                    handadd+= " (king)";
                }
                if(i==12){
                    handadd+= " (ace)";
                }
                bigscore = 20;
                high = i;
            }
            
            if(paircount[i] == 3){
                hand = "Three of a Kind";
                if(i<=8){
                    handadd+= " ("+(i+2)+")";
                }
                if(i==9){
                    handadd+= " (jack)";
                }
                if(i==10){
                    handadd+= " (queen)";
                }
                if(i == 11){
                    handadd+= " (king)";
                }
                if(i==12){
                    handadd+= " (ace)";
                }
                threekind++;
                bigscore = 100;
                high = i;
            }
            if(paircount[i] == 4){
                hand = "Four of a Kind";
                if(i<=8){
                    handadd= " ("+(i+2)+")";
                }
                if(i==9){
                    handadd= " (jack)";
                }
                if(i==10){
                    handadd= " (queen)";
                }
                if(i == 11){
                    handadd= " (king)";
                }
                if(i==12){
                    handadd= " (ace)";
                }
                bigscore = 250;
                high = i;
            }
        }
        if(doublepair == 2){
            hand = "Two Pair";
            bigscore = 50;
            
        }
        if(threekind == 1){
            if(doublepair == 1){
                hand = "Full House";
                bigscore = 200;
            }
        }
        if(straightcheck[1] -1 == straightcheck[0]){
            if(straightcheck[2]-1==straightcheck[1]){
                if(straightcheck[3]-1==straightcheck[2]){
                    if(straightcheck[4]-1 == straightcheck[3]){
                        straight = 1;
                        hand = "Straight";
                        bigscore = 100;
                        high = straightcheck[4];
                    }
                }
            }
        }
        if(flushcheck[0] == flushcheck[1]){
            if(flushcheck[1] == flushcheck[2]){
                if(flushcheck[2] == flushcheck[3]){
                    if(flushcheck[3] == flushcheck[4]){
                        flush = 1;
                        hand = "Flush";
                        bigscore = 150;
                        high = flushcheck[4];
                    }
                }
            }
        }
        if(flush == 1){
            if(straight == 1){
                hand = "Straight Flush";
            }
            bigscore = 1000;
        }
        if(hand.equals("High Card")){
            if(high < 9){
                handadd+=" ("+(high+2)+")";
            }
            if(high==9){
                handadd+=" (jack)";
            }
            if(high == 10){
                handadd+=" (queen)";
            }
            if(high == 11){
                handadd+=" (king)";
            }
            if(high==12){
                handadd+=" (ace)";
            }
        }
        //System.out.println(handadd);
        hand = hand+handadd;
        double playernumscore = high+bigscore+(((double)high1)*0.1);
        
        //System.out.print(" "+playernumscore);
        return hand;


    }


        //method for printing out individual cards in hand

    public static String printout(int[][] player, int bjcount){
        String ghah = "";
        //String bhah = "";
        for(int y = 1;y<=5+bjcount;y++){
        for(int a = 0;a<13;a++){
            for(int b = 0;b<4;b++){
                if(player[a][b] == y){
                    if(player[a][b]>=bjcount){
                    //System.out.print("("+y+"): ");
                    ghah+=("("+y+"): ");
                    if(a<9){
                        if(a >= 0){
                            //System.out.print(a+2);
                            ghah+=a+2;
                        } 
                    }
                    if(a == 9){
                        //System.out.print("jack");
                        ghah+="jack";
                    }
                    if(a == 10){
                        //System.out.print("queen");
                        ghah+= "queen";
                    }
                    if(a == 11){
                        //System.out.print("king");
                        ghah+= "king";
                    }
                    if(a == 12){
                        //System.out.print("ace");
                        ghah+= "ace";
                    }
                    //System.out.print(" of ");
                    ghah+=" of ";
                    if(b == 0){
                        //System.out.println("hearts");
                        ghah+= "hearts";
                    }
                    if(b == 1){
                        //System.out.println("spades");
                        ghah+= "spades";
                    }
                    if(b == 2){
                        //System.out.println("diamonds");
                        ghah+= "diamonds";
                    }
                    if(b == 3){
                        //System.out.println("clubs");
                        ghah+= "clubs";
                    }
                    ghah+="\n";
                }
            }
            }
        }
    }
    return ghah;
    }
    public static int getInt() {
        //System.out.print(prompt);
        while(true){
            try {
                return Integer.parseInt(new Scanner(System.in).next());
            } catch(NumberFormatException ne) {
                System.out.print("Type in a whole number: ");
            }
        }
    }
    
} 
