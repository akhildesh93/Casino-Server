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

        Scanner console = new Scanner(System.in);
        String swapplace = "a";
        String amtplace = "a";
        double serverscore = 0;
        double clientscore = 0;
        int money1 = 100;
        int money2 = 100;
        String game = "a";
        int joab = 0;
        int fa = 0;
        int fb = 0;
        int goon = 1;
        int amountswap = 0;
        int amt = 0;
        
        
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



        System.out.print("How many cards to swap: ");
        
        amountswap = getInt();
        while(amountswap>5){
            System.out.println("Please enter a number between 0 and 5: ");
            amountswap = getInt();
        }
        //amountswap = console.nextInt();
        if(amountswap > 0){
            if(amountswap != 5){
                System.out.print("Which card numbers: ");
            }
        }
        for(int n = 0;n<amountswap;n++){
            if(amountswap == 5){
                amt = n+1;
            } else {
                amt = console.nextInt();
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


    

        out.println("How many cards to swap: ");
        swapplace = in.readLine();
        //System.out.println(swapplace);
        if(swapplace.equals("0")){
            amountswap = 0;
        }
        if(swapplace.equals("1")){
            amountswap = 1;
        }
        if(swapplace.equals("2")){
            amountswap = 2;
        }
        if(swapplace.equals("3")){
            amountswap = 3;
        }
        if(swapplace.equals("4")){
            amountswap = 4;
        }
        if(swapplace.equals("5")){
            amountswap = 5;
        }

        //System.out.println(amountswap);
        if(amountswap > 0){
            if(amountswap != 5){
                out.println("Which card numbers: ");
            }
        }
        
        for(int n = 0;n<amountswap;n++){
            if(amountswap == 5){
                amt = n+1;
            } else {
                out.println("swap: ");
                amtplace = in.readLine();
                if(amtplace.equals("1")){
                    amt = 1;
                }
                if(amtplace.equals("2")){
                    amt = 2;
                }
                if(amtplace.equals("3")){
                    amt = 3;
                }
                if(amtplace.equals("4")){
                    amt = 4;
                }
                if(amtplace.equals("5")){
                    amt = 5;
                }
                //System.out.println(amt);
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

        System.out.println("--------------------------\n");
        System.out.println("Your Opponent's cards: ");
        System.out.println(printout(player2,0));

        System.out.println("Your Swapped Cards: ");
        System.out.println(printout(player, 0));
        System.out.println("--------------------------\n");

        System.out.print("You got a ");
        System.out.println(strreveal(player, 0));
        System.out.print("Your opponent got a ");
        System.out.println(strreveal(player2,0));
        System.out.println();

        out.println("--------------------------\n");

        out.println("Your Opponent's cards: ");
        out.println(printout(player,0));
        out.println("Your Swapped Cards: ");
        out.println(printout(player2, 0));
        out.println("--------------------------\n");
        out.println("You got a "+strreveal(player2, 0));
        out.println("Your opponent got a "+strreveal(player, 0));
        out.println();


        serverscore = handreveal(player, 0);
        clientscore = handreveal(player2, 0);
        if(serverscore > clientscore){
            System.out.println("You win");
            out.println("You lose");
            money1+=20;
            money2 -=20;
            out.println("You have $"+money2);
            System.out.println("You have $"+money1);
        } else {
            System.out.println("You lose");
            out.println("You win");
            money1-=20;
            money2+= 20;
            out.println("You have $"+money2);
            System.out.println("You have $"+money1);

        }
        System.out.println();
        System.out.print("Continue? Type yes or no: ");
        cont = console.next();
        if(cont.equals("yes")){
            out.println("Continue? Type yes or no: ");
            cont = in.readLine();
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
    
    
    
    




    

    
    public static double handreveal(int[][] player, int joab){

        String hand = "a";
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
                bigscore = 20;
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

        double playernumscore = high+bigscore+(((double)high1)*0.1);
        if(joab == 5){
            System.out.print(hand);

        }
        //System.out.print(" "+playernumscore);
        return playernumscore;


    }
    public static String strreveal(int[][] player, int joab){
        String hah =  "";
        String hand = "a";
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
                bigscore = 20;
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

        double playernumscore = high+bigscore+(((double)high1)*0.1);
        
        //System.out.print(" "+playernumscore);
        return hand;


    }
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
                System.out.print("Type in a whole number. \n");
            }
        }
    }
    
} 
