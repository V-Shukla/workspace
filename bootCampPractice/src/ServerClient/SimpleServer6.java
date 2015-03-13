package ServerClient;


import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;


/**
* A simple example of a server. This server accepts connections on port 2222,
* reads and echos text input until a blank line is received, and then writes
* the string "OK" to the client.
* <p>
* Try this with SimpleClient.
*/

public class SimpleServer6 {
                
                public static void main(String[] args) {
                                new SimpleServer6().runServer(2222);
                                //new SimpleClient3();
                }// end main
                
                
                ArrayList<DataOutputStream> listOfOutputStreams = new ArrayList<DataOutputStream>();
                String serverName = "";
                
                public String getServerName() {
                                return serverName;
                }

                public void setServerName(String serverName) {
                                this.serverName = serverName;
                }

                public ArrayList<DataOutputStream> getListOfOutputStreams() {
                                return listOfOutputStreams;
                }

                public void setListOfOutputStreams(
                                                ArrayList<DataOutputStream> listOfOutputStreams) {
                                this.listOfOutputStreams = listOfOutputStreams;
                }



                /**
                * Basic server loop.
                * 
                 * @param port
                *            the port number on which to listen
                */
                public void runServer(int port) {
                                
                                System.out.println("Server has started.");
                                System.out.println("Server will be listening on port " + port);
                                serverName = "Admin";
                                System.out.println("Server name is " + serverName);
                                
                                                                
                                while (true) {
                                                ServerSocket ss = null;
                                                try {
                                                                ss = new ServerSocket(port);
                                                                
                                                                while (true) {

                                                                                // System.out.print("Server : ");
                                                                                // blocks here until a client attempts to connect
                                                                                final Socket s = ss.accept();
                                                                                // handleConnection(s);
                                                                                new Handler(s, this).start();
                                                                }// end second while
                                                } catch (IOException e) {
                                                                System.out.println("I/O error: " + e);
                                                } finally {
                                                                if (ss != null) {
                                                                                try {
                                                                                                ss.close();
                                                                                } catch (IOException e) {
                                                                                                // error trying to close the socket, not much we can do
                                                                                                System.out.println("Error closing socket " + e);
                                                                                }// end of catch
                                                                }// end if statement
                                                }// end finally
                                }// first while loop
                }// end run server

                /**
                * Helper method for handling a client connection. Closes the socket (and
                * therefore the associated streams) when the method returns.
                * 
                 * @param s
                *            Socket representing the client connection
                * @throws IOException
                */

                private static class Handler extends Thread {
                                private Socket socket;
                                private SimpleServer6 callingServer;

                                public Handler(Socket socket, SimpleServer6 simpleServer6) {
                                                this.socket = socket;
                                                this.callingServer = simpleServer6;
                                                
                                } // end handler constructor


                                public void run() {

                                                try {
                                                                handleConnection(this.socket);
                                                } catch (IOException e) {
                                                                e.printStackTrace();
                                                }
                                }

                                private void handleConnection(Socket s) throws IOException {
                                                
                                                
                                                
                                                try {
                                                                //manage list of output streams 
                                                                ArrayList<DataOutputStream> handleListofOutputStreams = new ArrayList<DataOutputStream>();                                                              
                                                                @SuppressWarnings("resource")
                                                                Scanner inFromClient = new Scanner(s.getInputStream());// takes in the input stream from the port 
                                                                @SuppressWarnings("resource")
                                                                Scanner inFromServerConsole = new Scanner(System.in); // takes in the input from console
                                                                DataOutputStream outToClient = new DataOutputStream(s.getOutputStream()); // gets out the stream

                                                                handleListofOutputStreams = callingServer.getListOfOutputStreams(); // get list of output streams from the original class
                                                                handleListofOutputStreams.add(outToClient); // add outToClient
                                                                callingServer.setListOfOutputStreams(handleListofOutputStreams); // set list of output streams from the original class
                                                                
//                                                            //only ask for new server name, if the current memory lookup for servername via the getter method is equal to the empty string ("")
//                                                            if(callingServer.getServerName().equals("")){
//                                                            System.out.print("Enter server name : ");
//                                                            
//                                                            String serverName;
//                                                            serverName = inFromServerConsole.nextLine();
//                                                            callingServer.setServerName(serverName);
//                                                            
//                                                            System.out.print("Server name is : "+ callingServer.getServerName()+'\n');
//                                                            }//end if
                                                                
                                                                
                                                                while (true) {
                                                                                // while (inFromClient.hasNextLine()) {
                                                                                
                                                                                //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
                                                                                // Listen to input stream, if text is coming print it
                                                                                //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%        
                                                                                if (s.getInputStream().available() > 0) {
                                                                                                String line = inFromClient.nextLine();

                                                                                                if (line.length() == 0) {
                                                                                                                break; // blank line terminates input
                                                                                                }
                                                                                                System.out.println(line);
                                                                                                // for each connection, send back the same message to
                                                                                                // all clients that the client in turn has sent
                                                                                                for (DataOutputStream ds : handleListofOutputStreams) {
                                                                                                                ds.writeBytes(line + '\n');
                                                                                                                ds.flush();
                                                                                                }
                                                                                }// end input stream from client if

                                                                                
                                                                                //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
                                                                                // Listen to console, if text is entered in console send it to client
                                                                                //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
                                                                                
                                                                                String serverSentence;
                                                                                if (System.in.available() > 0) {
                                                                                                try {
                                                                                                                serverSentence = callingServer.getServerName()+" : " + inFromServerConsole.nextLine();
                                                                                                                
                                                                                                                for (DataOutputStream dsOut : handleListofOutputStreams) {
                                                                                                                                dsOut.writeBytes(serverSentence + '\n');
                                                                                                                                dsOut.flush();
                                                                                                                }
                                                                                                                
                                                                                                } catch (Exception e) {
                                                                                                                // break;
                                                                                                } finally {
                                                                                                }

                                                                                }// if statement

                                                                }// infinite while loop

                                                } catch (IOException e) {
                                                                e.printStackTrace();

                                                } finally {
                                                                // close the connection in a finally block
                                                                s.close();

                                                }

                                }
                }
} // end class


