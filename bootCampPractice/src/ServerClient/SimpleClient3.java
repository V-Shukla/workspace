package ServerClient;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SimpleClient3 {
                static String clientName;
    
                public static String getClientName() {
                                return clientName;
                }
                public void setClientName(String clientName) {
                                SimpleClient3.clientName = clientName;
                }
                
                
                public static void main(String[] args) {
                                
                   try {
                                   
                                //@SuppressWarnings("resource")
                                                Socket clientSocket = new Socket("Localhost",2222);
                                InputStream clientInputStream = clientSocket.getInputStream();    //defines the input stream
                                //@SuppressWarnings("resource")
                                                Scanner scannerInFromServer = new Scanner(clientInputStream); //allocate stream to pipe
                                                //@SuppressWarnings("resource")
                                                Scanner inFromClientConsole = new Scanner(System.in); // takes in the input from console
                                                DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream()); // gets out the stream

                                                System.out.print("Choose and enter client name: ");
                                                clientName = inFromClientConsole.nextLine();
                                                System.out.print("Client name is : "+SimpleClient3.getClientName()+'\n');
                                                
                                                String clientSentence;
                                                
                                                while (true) {
                                                                
                                                                //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
                                                                // Listen to console, if text is entered in console send it to server
                                                                //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
                                                                if(System.in.available()>0){
                                                                clientSentence = inFromClientConsole.nextLine();
                                                                outToServer.writeBytes(clientName+" : "+ clientSentence + '\n');
                                                                outToServer.flush();
                                                                }//end if nothing in console is entered
                                                                
                                                                //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
                                                                // Listen to input stream, if text is coming print it
                                                                //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%       
                                                                if (clientInputStream.available() > 0) {
                                                                                try {
                                                                                                String lineClient = scannerInFromServer.nextLine();
                                                                                                System.out.println(lineClient);
                                                                                }// end try statement
                                                                                catch (Exception e) {
                                                                                                //do nothing;
                                                                                } finally {//do nothing
                                                                                }
                                                                }// end if statement
                                                }//end while true loop
                                
                   
                }//end first try 
                catch (IOException e) {e.printStackTrace();
                                }//end first catch
                finally {
                                }//end first finally  
                   
       }//end main
} // end class
