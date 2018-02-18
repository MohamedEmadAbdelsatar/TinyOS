/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os_gui1;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

/**
 *
 * @author Mohamed
 */
public class memory_table {
    
    Object data[][];
		int row,col,i,j,k;
		TableModel dataModel;
		DefaultTableCellRenderer colorRenderer;
	  	public memory_table(int irow,int icol) 
	        {
	            row = irow;
	            col=  icol;
	            data = new Object[row][col];
	            
	           
	            for(i=0;i<row;i++)
	            {
	                    for(j=0;j<col;j++)
	                    {
	                            data[i][j]="";                            
	                    }
	            }  		
	                    resetModel();    		
	        }
	     
	     public void resetModel()
	     {	     		
	            dataModel = new AbstractTableModel() {
	            public int getColumnCount() { return col; }
	            public int getRowCount() { return row;}
	            public Object getValueAt(int rowi, int coli) {return data[rowi][coli];}
	            public String getColumnName(int column) {return "";}
	            public Class getColumnClass(int c) {return getValueAt(0, c).getClass();}
		    	public boolean isCellEditable(int rowi, int coli) {return false;}
	            public void setValueAt(Object aValue, int rowi, int columni) { data[rowi][columni] = aValue; }
	         };         
	     }
	     
	     
	     public boolean GetObj()
	     {
	         for(i=0;i<row;i++)
	    	{
	    		for(j=0;j<col;j++)
	    		{
	    			if(!data[i][j].toString().equals(""))
	                            return true;
	    		}
	    	}     	
	        return false;
	     }
	     
	     public void resetObj()
	     {
	     	data = new Object[row][col];
	    	for(i=0;i<row;i++)
	    	{
	    		for(j=0;j<col;j++)
	    		{
	    			data[i][j]=new Object();
	    			data[i][j]="";
	    		}
	    	}     	
	     }
	    
	    public void setVal(int irow,int icol,int ino)
	    {
	    	data[irow][icol]=String.valueOf(ino);
	    	resetModel();    	
	    }
    
}
