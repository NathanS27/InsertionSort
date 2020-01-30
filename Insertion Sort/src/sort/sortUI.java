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
	
	JLabel sortLbl = addLabel("Sorted:",6,1,1,1);
	JLabel display = addLabel("", 6, 2, 4, 1);

	JButton add = addButton("add", 4, 1, 1, 1);
	JButton output = addButton("sort", 4, 2, 1, 1);
	JButton clear = addButton("clear", 4, 3, 1, 1);

	sorter list = new sorter();
	
	public sortUI() {
	}
	
	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == add) {
			if (!inputNum.getText().trim().isEmpty()) {
				try {
					list.addNum(inputNum.getText());
				}
				catch(ImproperFormatException e) {
					errorMsg(e.getMessage());
				}
				inputNum.setText("");
				inputtedNumbers.setText(list.print());
				inputNum.grabFocus();
			}
		} 
		else if(buttonObj==clear) {
			list.clear();
			inputtedNumbers.setText("");
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
