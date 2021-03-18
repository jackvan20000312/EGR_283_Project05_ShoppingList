package edu.mtc.egr283.project05;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ShoppingListGUI extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	private Container contentPane;
	
	private JPanel additionPane;
	private JPanel removalPane;
	private JLabel positionLabel;
	private JLabel inputLabel;
	
	private JEditorPane outputBox;
	
	private JTextField inputBox;
	private JTextField positionBox;
	
	private JButton addButton;
	private JButton addSpecButton;
	private JButton removeDataButton;
	private JButton removeButton;
	private JButton clearButton;
	private JButton clearAllButton;

	private ShoppingList list = new ShoppingList();
	
		/**
	 * Constructor for the user interface. Creates a 420x420 GUI with a visual
	 * Shopping List and some basic tools for manipulating the list.
	 */
	public ShoppingListGUI() {
		super();
		this.setTitle("Shopping List(Dark Mode)");
		this.setSize(420, 420);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.contentPane = this.getContentPane();
		this.contentPane.setBackground(Color.DARK_GRAY);
		this.contentPane.setLayout(new FlowLayout());
		
		this.outputBox = new JEditorPane("Items", this.list.toString());
		this.outputBox.setEditable(false);
		this.outputBox.setPreferredSize(new Dimension(300, 200));;
		this.outputBox.setBackground(Color.DARK_GRAY);
		this.outputBox.setForeground(Color.WHITE);
		this.outputBox.setBorder(BorderFactory.createEtchedBorder(Color.ORANGE, Color.RED));
		this.add(this.outputBox);
		
		this.additionPane = new JPanel();
		this.additionPane.setBackground(Color.DARK_GRAY);
		this.additionPane.setForeground(Color.WHITE);
		this.additionPane.setBorder(BorderFactory.createEtchedBorder(Color.ORANGE, Color.RED));
		this.add(this.additionPane);
		
		this.removalPane = new JPanel();
		this.removalPane.setBackground(Color.DARK_GRAY);
		this.removalPane.setForeground(Color.WHITE);
		this.removalPane.setPreferredSize(new Dimension(340,115));
		this.removalPane.setBorder(BorderFactory.createEtchedBorder(Color.ORANGE, Color.RED));
		this.add(this.removalPane);
		
		this.inputLabel = new JLabel("ITEM:");
		this.inputLabel.setForeground(Color.WHITE);
		this.additionPane.add(this.inputLabel);
		
		this.inputBox = new JTextField(12);
		this.inputBox.setBackground(Color.DARK_GRAY);
		this.inputBox.setForeground(Color.WHITE);
		this.inputBox.setBorder(BorderFactory.createEtchedBorder(Color.ORANGE, Color.RED));
		this.inputBox.setCaretColor(Color.WHITE);
		this.inputBox.setToolTipText("Name of item to add to the list.");
		this.additionPane.add(this.inputBox);
		
		this.positionLabel = new JLabel("POSITION: #");
		this.positionLabel.setForeground(Color.WHITE);
		this.additionPane.add(this.positionLabel);
		
		this.positionBox = new JTextField(10);
		this.positionBox.setText("");
		this.positionBox.setBackground(Color.DARK_GRAY);
		this.positionBox.setForeground(Color.WHITE);
		this.positionBox.setBorder(BorderFactory.createEtchedBorder(Color.ORANGE, Color.RED));
		this.positionBox.setCaretColor(Color.WHITE);
		this.positionBox.setToolTipText("Enter an integer");
		this.additionPane.add(this.positionBox);
		
		this.addButton = new JButton("Add Item");
		this.addButton.setBackground(Color.DARK_GRAY);
		this.addButton.setForeground(Color.WHITE);
		this.addButton.addActionListener(this);
		this.removalPane.add(this.addButton);
		
		this.addSpecButton = new JButton("Add Item at Position");
		this.addSpecButton.setBackground(Color.DARK_GRAY);
		this.addSpecButton.setForeground(Color.WHITE);
		this.addSpecButton.addActionListener(this);
		this.removalPane.add(this.addSpecButton);
		
		this.removeDataButton = new JButton("Remove Item");
		this.removeDataButton.setBackground(Color.DARK_GRAY);
		this.removeDataButton.setForeground(Color.WHITE);
		this.removeDataButton.addActionListener(this);
		this.removalPane.add(this.removeDataButton);
		
		this.removeButton = new JButton("Remove Item at Position");
		this.removeButton.setBackground(Color.DARK_GRAY);
		this.removeButton.setForeground(Color.WHITE);
		this.removeButton.addActionListener(this);
		this.removalPane.add(this.removeButton);
	
		this.clearButton = new JButton("Clear Fields");
		this.clearButton.setBackground(Color.DARK_GRAY);
		this.clearButton.setForeground(Color.WHITE);
		this.clearButton.addActionListener(this);
		this.removalPane.add(this.clearButton);
		
		this.clearAllButton = new JButton("Clear Shopping List");
		this.clearAllButton.setBackground(Color.DARK_GRAY);
		this.clearAllButton.setForeground(Color.WHITE);
		this.clearAllButton.addActionListener(this);
		this.removalPane.add(this.clearAllButton);
	
		
		
	}// Ending bracket of constructor
	
	/**
	 * Method to handle button actions.  Each button has a corresponding method
	 * in the Shopping List class.  The 'Clear Fields' button and 'Clear Shopping List'
	 * buttons are provided for ease of use.
	 * @param e the name of the button pressed.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		int position = -1;
		
		if(actionCommand.equalsIgnoreCase("Add Item")) {
			if(!this.inputBox.getText().equals("")) {
				this.list.addAtBottom(this.inputBox.getText());
				this.clear();
			}else {
				this.clear();
			}// Ending bracket of INNER if-else

		}else if(actionCommand.equals("Remove Item")) {
			if(this.inputBox.getText().equals("")) {
				this.clear();
			}else {
				try {
					this.list.removeData(this.inputBox.getText());
					this.clear();
				}catch(ItemNotFoundException infe) {
					this.inputBox.setText(infe.getMessage());
				}// Ending bracket of try-catch
			}// Ending bracket of INNER if- else
		}else if(actionCommand.equals("Remove Item at Position")) {
			if(!this.positionBox.getText().equals("")){
				position = Integer.parseInt(this.positionBox.getText());
				this.clear();
			}else {
				this.clear();
			}// Ending bracket of INNER if-else
			try {
				this.list.remove(position);
				this.clear();
			} catch(ItemNotFoundException infe) {
				if(!this.positionBox.getText().equals("")) {
					this.inputBox.setText(infe.getMessage());
				}// Ending bracket of inner if
			}// Ending bracket of try-catch
		}else if(actionCommand.equals("Add Item at Position")) {
			if(!this.inputBox.getText().equals("") && !this.positionBox.getText().equals("")) {
				this.list.addItem(this.inputBox.getText(), Integer.parseInt(this.positionBox.getText()));
				this.clear();
			}// Ending bracket of inner if
		}else if(actionCommand.equals("Clear Fields")){
			this.clear();
		}else if(actionCommand.equals("Clear Shopping List")) {
			this.clear();
			for(int i = this.list.getSize(); i > 0; --i) {
				try {
					this.list.remove(i);
				}catch(ItemNotFoundException infe) {
					this.inputBox.setText(infe.getMessage());
				}// Ending bracket of try-catch
			}// Ending bracket of for loop
		}// Ending bracket of if-else

		
		// Update list
		this.outputBox.setText(this.list.toString());
		
	}// Ending bracket of method actionPerformed
	
	// Private helper method to facilitate clearing text boxes
	private void clear() {
		this.inputBox.setText("");
		this.positionBox.setText("");
	}// Ending bracket of method clear

}// Ending bracket of class GUI
