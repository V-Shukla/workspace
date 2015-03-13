import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.*; 

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//this class will hold draw method which randomly draws a number from 1-52
public class DrawCard {

                private static int holdingNumber;
                static int draw;
//            static List<Integer> allPlayerHoldings = new ArrayList<Integer>();
                protected static List<Integer> ph;
                protected static int n;
                static boolean pause = true;
                
                public static void createAndShowGUI()  {
                	 System.out.println("createAndShowGUI has begun....");        
                        final JFrame frame1 = new JFrame("Player Turn");
                        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        
                        JPanel panel = new JPanel();
                        frame1.add(panel);
                        System.out.println("Panel added to the frame....");   
                        JButton drawButton = new JButton(" Click here to Draw a card ");
                        panel.add(drawButton);
                        //Add action listener to drawButton
                        System.out.println("Button1 Added to the panel....");  
                        drawButton.addActionListener(new ActionListener() {
                
                            public void actionPerformed(ActionEvent e)
                            {
                                //Execute when button is pressed
                                System.out.println("Player decided to draw a card !");
                                
                                buttonDrawCard(n, ph);
                                SequenceMain.pause = false;
                                pause = false;
                                frame1.dispose();
                            }
                        });      
                        
                        JButton pickFromStackButton = new JButton(" Click here pick a card from stack ");
                        panel.add(pickFromStackButton);
                        //Add action listener to drawButton
                        System.out.println("Button2 Added to the panel....");  
                        pickFromStackButton.addActionListener(new ActionListener() {
                
                            public void actionPerformed(ActionEvent e)
                            {
                                //Execute when button is pressed
                                System.out.println("This function is not yet available !");   
                                draw=1000;
                                SequenceMain.pause = false;
                                pause = false;
                                frame1.dispose();
                            }
                        });      
                 
                        frame1.getContentPane().add(panel);
                        //frame1.getContentPane().add(pickFromStackButton);
                        frame1.pack();
                        frame1.setVisible(true);
                    }
                

                public static int DrawCard(int Number, List<Integer> playerHoldings) {
                	System.out.println("Initiating Drawcard method ....");
                                n = Number; 
                                ph= playerHoldings;
                              
                                //javax.swing.SwingUtilities.invokeLater(new Runnable(){public void run() {createAndShowGUI();}});
                                System.out.println("createAndShowGUI....");
                                createAndShowGUI();
                                while(pause){
                                	//System.out.println("Starting Pause....");
                                	try {
										Thread.sleep(500);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										//e.printStackTrace();
										System.out.println("Ending Pause....");
										break;
									}
                                }
                                pause = true;
//                            int tempHolder;
//                            //int draw;// = randomNumber.nextInt(Number);
//                            Random randomNumber = new Random();
//                            // int holdingNumber = playerHoldings.size();
//                            boolean numberExists = false;
//                            
//                            //if (holdingNumber > 0) {
//                                            label: do {
//                                                            draw = randomNumber.nextInt(Number);
//                                                            holdingNumber = playerHoldings.size();
//                                                            //out.println("holdingNumber = "+holdingNumber);
//                                                            for (int i = 0; i < holdingNumber; i++) {
//                                                                            tempHolder = playerHoldings.get(i);
//                                                                            //out.println("In loop draw initial= " + draw + " i = " + i + " tempHolder = " + tempHolder);
//                                                                            if ((draw == tempHolder) || (draw == 0)) {
//                                                                                            numberExists = true;
//                                                                                            break;
//
//                                                                            }// end if for compare
//                                                                            else {
//
//                                                                                            numberExists = false;
//                                                                            }
//
//                                                            }// end for loop
//
//                                                            if (numberExists == true)
//                                                                            continue label;// restart if the number matches any from
//                                                                                                                                            // currently drawn
//
//                                                            break label;
//                                            } while (true); // end do while loop
////
////                        }// end if statement
////                        else {
////                                        draw = randomNumber.nextInt(Number);
////                        }
//                            playerHoldings.add(draw);

                                //out.println("allPlayerHoldings = " + allPlayerHoldings);
                                System.out.println("Returning Final Draw...."+draw);  
                                return draw;
                }//end draw card
                
                public static void buttonDrawCard(int Number, List<Integer> playerHoldings) {
                                int tempHolder;
                                //int draw;// = randomNumber.nextInt(Number);
                                Random randomNumber = new Random();
                                // int holdingNumber = playerHoldings.size();
                                boolean numberExists = false;
                                
                                //if (holdingNumber > 0) {
                                                label: do {
                                                                draw = randomNumber.nextInt(Number);
                                                                holdingNumber = playerHoldings.size();
                                                                //out.println("holdingNumber = "+holdingNumber);
                                                                for (int i = 0; i < holdingNumber; i++) {
                                                                                tempHolder = playerHoldings.get(i);
                                                                                //out.println("In loop draw initial= " + draw + " i = " + i + " tempHolder = " + tempHolder);
                                                                                if ((draw == tempHolder) || (draw == 0)) {
                                                                                                numberExists = true;
                                                                                                break;

                                                                                }// end if for compare
                                                                                else {

                                                                                                numberExists = false;
                                                                                }

                                                                }// end for loop

                                                                if (numberExists == true)
                                                                                continue label;// restart if the number matches any from
                                                                                                                                                // currently drawn

                                                                break label;
                                                } while (true); // end do while loop
//
//                            }// end if statement
//                            else {
//                                            draw = randomNumber.nextInt(Number);
//                            }
                                playerHoldings.add(draw);
                                
                }
                
                
}//end class
