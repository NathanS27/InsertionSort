package sort;

import BreezySwing.*;
import java.awt.Color;
import javax.swing.*;
import java.util.*;

public class sortUI extends GBFrame {

	JLabel instructions = addLabel("Enter the numbers seperated by a ',' ", 1, 1, 4, 1);

	JTextField inputNum = addTextField("", 3, 1, 4, 1);

	JLabel inputNumlbl = addLabel("Inputted Numbers:",5,1,1,1);
	JLabel inputtedNumbers = addLabel(" ", 5, 2, 4, 1);
	
	JLabel display = addLabel("", 6, 2, 4, 1);
	JTextArea details= addTextArea("",7,1,3,1);

	JButton add = addButton("add", 4, 1, 1, 1);
	JButton clear = addButton("clear", 4, 3, 1, 1);

	sorter list = new sorter();
	
	public sortUI() {
	}
	
	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == add) {
			if (!inputNum.getText().trim().isEmpty()) {
				try {
					list.addNum(inputNum.getText());
				inputNum.setText("");
				inputtedNumbers.setText(list.print());
				inputNum.grabFocus();
				String str="";
				str+=String.format("Mean: %.3f", list.getMean());
				str+=String.format("\nMedian: %s", list.getMedian());
				str+=String.format("\nMode: %s", list.getMode());
				str+=String.format("\nStandard Deviation: %s", list.getSD());
				str+=String.format("\nList: %s", list.print());
				details.setText(str);
				}
				catch(ImproperFormatException e) {
					errorMsg(e.getMessage());
					inputNum.setText("");
					inputNum.grabFocus();
				}
			}
		} 
		else if(buttonObj==clear) {
			list.clear();
			details.setText("");
			inputtedNumbers.setText("");
			inputNum.grabFocus();
		}
	}
	
	private void errorMsg(String str) {
		ErrorDlg frm= new ErrorDlg(this,str);
		frm.setVisible(true);
	}
	
	public static void main(String[] args) {
		JFrame frm = new sortUI();
		frm.setSize(500,300);
		frm.setTitle("Nathan's Sort program ");
		frm.getContentPane().setBackground(new Color(186,225,255));
		frm.setResizable(true);
		frm.setVisible(true);
		frm.setLocationRelativeTo(null);
	}
}
