/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os_gui1;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author mahmoud ezat
 */
public class cusstomthread extends Thread{
    
  
    
    public JPanel jPanel1 ;
    public JFrame fram;
    public JComboBox combo;
    public Vector<ProcessPL> objVector ;
    public cusstomthread(JFrame fram,JPanel jPanel1 ,Vector<ProcessPL> obj,JComboBox combo)
    {
        
        this.objVector=obj;
        this.jPanel1=jPanel1;
        this.fram=fram;
        this.combo=combo;
    }   

    

   

    public void run()
    {
        
               int s=objVector.size();
               int minIndex=0;
               if(combo.getSelectedItem().toString().equals("FCFS")){
               while(s>0){
                minIndex=minmum(objVector);
                
                //System.out.println("min ="+Integer.parseInt(objVector.get(minIndex).jTextFieldArrivalTime.getText()));
                  int min=Integer.parseInt(objVector.get(minIndex).jTextFieldCpuTime.getText());
                  
                  for(int i=min ;i>0;i--){
                    
                    objVector.get(minIndex).jTextField1.setText(Integer.toString(i));
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(cusstomthread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                  }
                
                            jPanel1.remove(objVector.get(minIndex));
                            objVector.remove(minIndex);
                            fram.repaint();
                            fram.setVisible(true); 
                            try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(cusstomthread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                //objVector.remove(minIndex);
                  
                    s--;
                  
                   
                }
               }
               else if(combo.getSelectedItem().toString().equals("Piriorty")){
                   
                     while(s>0){
                minIndex=minmum2(objVector);
                
                //System.out.println("min ="+Integer.parseInt(objVector.get(minIndex).jTextFieldArrivalTime.getText()));
                  int min=Integer.parseInt(objVector.get(minIndex).jTextFieldCpuTime.getText());
                  
                  for(int i=min ;i>0;i--){
                    
                    objVector.get(minIndex).jTextField1.setText(Integer.toString(i));
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(cusstomthread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                  }
                
                            jPanel1.remove(objVector.get(minIndex));
                            objVector.remove(minIndex);
                            fram.repaint();
                            fram.setVisible(true); 
                            try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(cusstomthread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                //objVector.remove(minIndex);
                  
                    s--;
                  
                   
                }
               }
               
               else
                   JOptionPane.showMessageDialog(null, "you should choose your algorthim ");
            
               
    }
    
    
    public  int minmum(Vector<ProcessPL> x ){
        int min=Integer.parseInt(x.get(0).jTextFieldBlockingTime.getText());
        int ind=0;
       
       for(int i=0;i<x.size();i++){
           if(min>Integer.parseInt(x.get(i).jTextFieldBlockingTime.getText())){
               min=Integer.parseInt(x.get(i).jTextFieldBlockingTime.getText());
               ind=i;
           }
       }
       
       return ind;
    } 
    public  int minmum2(Vector<ProcessPL> x ){
        int min=Integer.parseInt(x.get(0).jTextFieldPriority.getText());
        int ind=0;
       
       for(int i=0;i<x.size();i++){
           if(min>Integer.parseInt(x.get(i).jTextFieldPriority.getText())){
               min=Integer.parseInt(x.get(i).jTextFieldPriority.getText());
               ind=i;
           }
       }
       
       return ind;
    } 
    
}
