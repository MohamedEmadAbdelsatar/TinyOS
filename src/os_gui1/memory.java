
package os_gui1;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author MAHMOUD
 */
public class memory extends JFrame{
    
            java.util.Vector refList,tList;
	    memory_table ftable;
	    Object Pages[][],Algo[];
	    boolean flg,erf,erf2;
	    String msg,sAlgo;
	    int row,col,drow,refId,i,j,pfi,phi,k,tmp;
	    java.lang.Integer tmpint,tmpint1;

    public memory() throws HeadlessException {
        msg="";
	        col=0;  
	        erf=true;
	        row=0;
	        Algo=new Object[3];        
	        Algo[0]="Select";
	        Algo[1]="FIFO";
	        Algo[2]="LRU";
	        ftable = new memory_table(row,col);        
	        refList= new java.util.Vector();
	        initComponents(); 
	        this.setLocation(200,150);
	        this.setSize(742,452+35);  
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, 
		size.height/2 - getHeight()/2);
                       
	        
    }
    
    
    public void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jSpinner_PageFrame = new javax.swing.JSpinner();
        jButton_Set = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton_Simulate = new javax.swing.JButton();
        jButton_Reset = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane_RefField = new javax.swing.JScrollPane();
        jList_RefField = new javax.swing.JList();
        jSpinner_RefField = new javax.swing.JSpinner();
        jButton_AddEdit = new javax.swing.JButton();
        jButton_Delete = new javax.swing.JButton();
        jButton_DeleteAll = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField_refField = new javax.swing.JTextField();
        jPanel_PageTable = new javax.swing.JPanel();
        jScrollPane_PageTable = new javax.swing.JScrollPane();
        jTable_PageTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField_PHits = new javax.swing.JTextField();
        jTextField_PFaults = new javax.swing.JTextField();
        jComboBox_Algo = new javax.swing.JComboBox(Algo);
        jLabel9 = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Page Replacement Algorithm Simulation ");
        setResizable(false);
        jLabel1.setText("Page Frames :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 60, 90, 14);

        getContentPane().add(jSpinner_PageFrame);
        jSpinner_PageFrame.setBounds(120, 60, 50, 25);

        jButton_Set.setText("Set");
        jButton_Set.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SetActionPerformed(evt);
            }
        });

        getContentPane().add(jButton_Set);
        jButton_Set.setBounds(180, 60, 50, 23);

        jPanel2.setLayout(null);

        jButton_Simulate.setText("Simulate");
        jButton_Simulate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SimulateActionPerformed(evt);
            }
        });

        jPanel2.add(jButton_Simulate);
        jButton_Simulate.setBounds(20, 10, 80, 30);

        jButton_Reset.setText("Reset");
        jButton_Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ResetActionPerformed(evt);
            }
        });

        jPanel2.add(jButton_Reset);
        jButton_Reset.setBounds(120, 10, 90, 30);

        

        getContentPane().add(jPanel2);
        jPanel2.setBounds(280, 370, 420, 50);

        jPanel3.setLayout(null);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 255)), "Demanded pages"));
        jPanel3.setEnabled(false);
        jScrollPane_RefField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPane_RefField.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jList_RefField.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane_RefField.setViewportView(jList_RefField);

        jPanel3.add(jScrollPane_RefField);
        jScrollPane_RefField.setBounds(30, 70, 50, 130);

        jPanel3.add(jSpinner_RefField);
        jSpinner_RefField.setBounds(30, 30, 50, 25);

        jButton_AddEdit.setText("Add");
        jButton_AddEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddEditActionPerformed(evt);
            }
        });

        jPanel3.add(jButton_AddEdit);
        jButton_AddEdit.setBounds(100, 30, 60, 23);

        jButton_Delete.setText("Delete");
        jButton_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteActionPerformed(evt);
            }
        });

        jPanel3.add(jButton_Delete);
        jButton_Delete.setBounds(100, 80, 70, 23);

        jButton_DeleteAll.setText("Delete All");
        jButton_DeleteAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteAllActionPerformed(evt);
            }
        });

        jPanel3.add(jButton_DeleteAll);
        jButton_DeleteAll.setBounds(100, 120, 80, 23);


        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Num of Demanded Pages:");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(-6, 220, 155, 20);

        jTextField_refField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_refField.setText("0");
        jTextField_refField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextField_refField.setFocusable(false);
        jPanel3.add(jTextField_refField);
        jTextField_refField.setBounds(150, 220, 30, 20);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(30, 90, 210, 260);

        jPanel_PageTable.setLayout(null);

        jPanel_PageTable.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 255)), "Page Table"));
        jScrollPane_PageTable.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPane_PageTable.setFocusable(false);
        jTable_PageTable.setBackground(new java.awt.Color(0, 0, 0));
        jTable_PageTable.setFont(new java.awt.Font("Tahoma", 1, 12));
        jTable_PageTable.setForeground(new java.awt.Color(102, 255, 102));
        jTable_PageTable.setModel(ftable.dataModel);
        jTable_PageTable.setGridColor(new java.awt.Color(198, 198, 48));
        jTable_PageTable.setRowSelectionAllowed(false);
        jTable_PageTable.setSurrendersFocusOnKeystroke(true);
        jTable_PageTable.getTableHeader().setReorderingAllowed(false);
        jTable_PageTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        jScrollPane_PageTable.setViewportView(jTable_PageTable);

        jPanel_PageTable.add(jScrollPane_PageTable);
        jScrollPane_PageTable.setBounds(20, 20, 400, 290);

        jLabel5.setForeground(new java.awt.Color(0, 102, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("PF: ");
        jPanel_PageTable.add(jLabel5);
        jLabel5.setBounds(30, 310, 30, 14);

        jLabel6.setText("Page Fault");
        jPanel_PageTable.add(jLabel6);
        jLabel6.setBounds(60, 310, 60, 14);

        jLabel7.setForeground(new java.awt.Color(0, 102, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("PH: ");
        jPanel_PageTable.add(jLabel7);
        jLabel7.setBounds(130, 310, 30, 14);

        jLabel8.setText("Page Hit");
        jPanel_PageTable.add(jLabel8);
        jLabel8.setBounds(160, 310, 60, 14);

        getContentPane().add(jPanel_PageTable);
        jPanel_PageTable.setBounds(270, 20, 440, 330);

        jPanel1.setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 255)));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Total Page Faults :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 40, 100, 20);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Total Page Hits :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 10, 90, 20);

        jTextField_PHits.setForeground(new java.awt.Color(255, 153, 153));
        jTextField_PHits.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_PHits.setText("0");
        jTextField_PHits.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextField_PHits.setFocusable(false);
        jPanel1.add(jTextField_PHits);
        jTextField_PHits.setBounds(130, 10, 30, 20);

        jTextField_PFaults.setForeground(new java.awt.Color(255, 153, 153));
        jTextField_PFaults.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_PFaults.setText("0");
        jTextField_PFaults.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextField_PFaults.setFocusable(false);
        jPanel1.add(jTextField_PFaults);
        jTextField_PFaults.setBounds(130, 40, 30, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(40, 360, 190, 70);

        jComboBox_Algo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "FIFO", "LRU" }));
        getContentPane().add(jComboBox_Algo);
        jComboBox_Algo.setBounds(150, 20, 75, 26);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Select Algorithm: ");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(50, 20, 100, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents
	

	    private void jButton_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ResetActionPerformed
	// TODO add your handling code here:
	        
	        erf=true;
	        col=0;
	        row=0;
	        ftable.col=0;
	        ftable.row=0;    
	        phi=0;
	        pfi=0;
	        jComboBox_Algo.setSelectedIndex(0);
	        jSpinner_PageFrame.setValue(new java.lang.Integer(0));
	        jSpinner_RefField.setValue(new java.lang.Integer(0));
	        jTextField_refField.setText(""+refList.size());
	        jTextField_PHits.setText(""+phi);
	        jTextField_PFaults.setText(""+pfi);   
	        if(refList.size()>0)
	        {
	            refList.removeAllElements();
	            jTextField_refField.setText(""+refList.size());
	            jList_RefField.setListData(refList);
	        }     
	        ftable.resetModel();
	        jTable_PageTable.setModel(ftable.dataModel); 
	    }//GEN-LAST:event_jButton_ResetActionPerformed
	
	    private void jButton_SetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SetActionPerformed
	// TODO add your handling code here:
	        msg="";
	        col=1;
	        ftable.col=1;
	        tmpint1 = (java.lang.Integer)jSpinner_PageFrame.getValue();        
	        if(tmpint1.intValue()<50&&tmpint1.intValue()>0)
	        {
	            if(erf)
	            {
	                erf=false;
	            }
	            row=tmpint1.intValue();
	            row++;
	            ftable.row=row-1;
	            ftable.resetObj();
	            ftable.resetModel();
	            jTable_PageTable.setModel(ftable.dataModel);
	           
	        }
	        else  {
	           
	            msg+="Page Frames must be between 0 to 50.";
	            javax.swing.JOptionPane.showMessageDialog(this,msg, "Warning",javax.swing.JOptionPane.WARNING_MESSAGE  );
	        }
	    }//GEN-LAST:event_jButton_SetActionPerformed
	
	    private void jButton_DeleteAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteAllActionPerformed
	// TODO add your handling code here:
	        if(refList.size()>0)
	        {
	            refList.removeAllElements();
	            jTextField_refField.setText(""+refList.size());
	           jList_RefField.setListData(refList);
	        }     
	        jTextField_refField.setText(""+refList.size());
	    }//GEN-LAST:event_jButton_DeleteAllActionPerformed
	
	    private void jButton_SimulateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SimulateActionPerformed
	// TODO add your handling code here:
	        msg="";  
	        erf2=true;
	        sAlgo=jComboBox_Algo.getSelectedItem().toString();
	        if(refList.size()>0&&(row-1)<50&&(row-1)>0&&(!sAlgo.equals("Select")))
	        {
	            jSpinner_PageFrame.setValue(new java.lang.Integer(row-1));
	                                 
	            GetData();   
	           erf2=false;
	        }    
	        if(sAlgo.equals("Select"))
	        {
	            msg+="Please select algorithm.\n";
	        }
	        if(erf)
	        {
	            msg+="Please set page frames.\n";
	        }
	        else
	        {
	            jSpinner_PageFrame.setValue(new java.lang.Integer(row-1));
	        }
	        if(refList.size()<1)
	        {
	            msg+="Reference field is empty.\nPlease fill reference field.";
	        }
	        if(erf2)
	        {
	            javax.swing.JOptionPane.showMessageDialog(this,msg, "Warning",javax.swing.JOptionPane.WARNING_MESSAGE  ); 
	        }
	    }//GEN-LAST:event_jButton_SimulateActionPerformed
	
	   
	    private void jButton_AddEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddEditActionPerformed
	// TODO add your handling code here:           
	        tmpint = (java.lang.Integer)jSpinner_RefField.getValue();        
	        if(tmpint.intValue()<0||tmpint.intValue()>99)
	        {         
	            msg="Demanded page must be between 0 to 100.\nPlease re-enter Demanded page.";
	            javax.swing.JOptionPane.showMessageDialog(this,msg, "Warning",javax.swing.JOptionPane.WARNING_MESSAGE  ); 
	        }
	        else
	        {
	            refList.add(jSpinner_RefField.getValue());
	            jTextField_refField.setText(""+refList.size());
	            jList_RefField.setListData(refList);        
	        }
	    }//GEN-LAST:event_jButton_AddEditActionPerformed
	
	  
	    private void jButton_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteActionPerformed
	// TODO add your handling code here:
	       if(!jList_RefField.isSelectionEmpty())
	        {
	            refId=jList_RefField.getSelectedIndex();
	            refList.remove(refId);
	            jTextField_refField.setText(""+refList.size());
	            jList_RefField.setListData(refList);            
	        }
	       jTextField_refField.setText(""+refList.size());
	    }//GEN-LAST:event_jButton_DeleteActionPerformed
	 public void GetData()
	    {              
	        flg=false;
	        pfi=1;
	        phi=0;
	        ftable.row=row;
	        ftable.col=refList.size();
	        col=refList.size();
	        Pages = new Object[col][row];
	        ftable.data = new Object[row][col];
	        for(i=0;i<col;i++)
	        {
	            for(j=0;j<row-1;j++)
	            {
	                Pages[i][j]="-";
	            }                
	        }  
	        for(i=0;i<col;i++)
	        {
	            Pages[i][row-1]="PF";
	        }
	        Pages[0][0]=refList.get(0);
	        if(sAlgo.equals("FIFO"))
	        {
	            for(i=1;i<col;i++)
	            {               
	                flg=false;
	                for(k=0;k<i&&k<row-1&&!flg;k++)
	                {
	                    if(Pages[i-1][k].toString().equals(refList.get(i).toString()))
	                    {
	                        flg=true; 
	                        Pages[i][row-1]="PH";                   
	                    }                 
	                }
	                if(!flg)
	                {                        
	                    for(j=1;j<=i&&j<row-1;j++)
	                    {
	                        Pages[i][j]=Pages[i-1][j-1];
	                    }
	                    Pages[i][0]=refList.get(i); 
	                    pfi++;
	                } 
	                else
	                { 
	                    for(k=0;k<i&&k<row-1;k++)
	                    {
	                        Pages[i][k]=Pages[i-1][k];
	                    }
	                    phi++;
	                }            
	            }
	        }
	        else if(sAlgo.equals("LRU"))
	        {        
	            for(i=1;i<col;i++)
	            {
	                flg=false;
	                for(k=0;k<i&&k<row-1&&!flg;k++)
	                {
	                    if(Pages[i-1][k].toString().equals(refList.get(i).toString()))
	                    {
	                        flg=true; 
	                        tmp=k;
	                        Pages[i][row-1]="PH";                   
	                    }                 
	                }                            
	                if(!flg)
	                {                        
	                    for(j=1;j<=i&&j<row-1;j++)
	                    {
	                        Pages[i][j]=Pages[i-1][j-1];
	                    }
	                    Pages[i][0]=refList.get(i); 
	                    pfi++;
	                } 
	                else
	                { 
	                    Pages[i][0]=Pages[i-1][tmp];
	                    for(k=1;k<=tmp&&k<row-1;k++)
	                    {
	                        Pages[i][k]=Pages[i-1][k-1];
	                    }
	                    for(k=tmp+1;k<i&&k<row-1;k++)
	                    {
	                        Pages[i][k]=Pages[i-1][k];
	                    }
	                    phi++;
	                }          
	            }
	        }
	        for(i=0;i<col;i++)
	        {
	            for(j=0;j<row;j++)
	            {
	                ftable.data[j][i] = Pages[i][j].toString();                
	            }
	        }        
	        jTextField_PHits.setText(""+phi);
	        jTextField_PFaults.setText(""+pfi);        
	        ftable.resetModel();
	        jTable_PageTable.setModel(ftable.dataModel);       
	    }
	   
	   
    private javax.swing.JButton jButton_AddEdit;
    private javax.swing.JButton jButton_Delete;
    private javax.swing.JButton jButton_DeleteAll;
    private javax.swing.JButton jButton_Reset;
    private javax.swing.JButton jButton_Set;
    private javax.swing.JButton jButton_Simulate;
    private javax.swing.JComboBox jComboBox_Algo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList_RefField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel_PageTable;
    private javax.swing.JScrollPane jScrollPane_PageTable;
    private javax.swing.JScrollPane jScrollPane_RefField;
    private javax.swing.JSpinner jSpinner_PageFrame;
    private javax.swing.JSpinner jSpinner_RefField;
    private javax.swing.JTable jTable_PageTable;
    private javax.swing.JTextField jTextField_PFaults;
    private javax.swing.JTextField jTextField_PHits;
    private javax.swing.JTextField jTextField_refField;
    
    
}
