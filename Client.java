import java.net.*; 
import java.io.*; 
import java.util.*;
public class Client 
{ 
    
  
    public static void main(String[] args) throws IOException
    { 
        
        
        String hostName = "10.0.0.210";
        //deshmukh5g = 10.0.0.210
        //cutover = 10.153.72.94
        int portNumber = 10;
        try (
            Socket kkSocket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(kkSocket.getInputStream()));
        ) {
            BufferedReader stdIn =
                new BufferedReader(new InputStreamReader(System.in));
            String fromServer;
            String fromUser;
            //System.out.println("Waiting for Opponent...");

            while ((fromServer = in.readLine()) != null) {
                System.out.println(fromServer);
                if(fromServer.equals("How many cards to swap: ")){
                    fromUser = stdIn.readLine();
                    out.println(fromUser);
                    
                }
                if(fromServer.equals("swap: ")){
                    fromUser = stdIn.readLine();
                    out.println(fromUser);
                }
                if(fromServer.equals("Continue? Type yes or no: ")){
                    fromUser = stdIn.readLine();
                    out.println(fromUser);
                }


                
                    
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            
            System.exit(1);
        }
        
    }
         

     
    
    
    
} 