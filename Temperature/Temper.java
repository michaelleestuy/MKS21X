import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Temper extends JFrame implements ActionListener{
    private Container pane;
    private JTextField t;
    private JButton ctof;
    private JButton ftoc;
    private JLabel j;
    
    public Temper(){
	this.setTitle("Temperature Conversions");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	ctof = new JButton("C to F");
	ctof.addActionListener(this);
	ctof.setActionCommand("ctof");
	
	ftoc = new JButton("F to C");
	ftoc.addActionListener(this);
	ftoc.setActionCommand("ftoc");
	
	t = new JTextField(10);
	t.addActionListener(this);

	j = new JLabel("Converted Degrees");
	
	pane.add(ctof);
	pane.add(ftoc);
	pane.add(t);
	pane.add(j);
    }
    
    public void actionPerformed(ActionEvent e){
	String event = e.getActionCommand();

	if(event.equals("ftoc")){
	    String text = t.getText();
	    double newtext = Temps.FtoC(Double.parseDouble(text));
	    t.setText(Double.toString(newtext));
	    
	}

	if(event.equals("ctof")){
	    String text = t.getText();
	    double newtext = Temps.CtoF(Double.parseDouble(text));
	    t.setText(Double.toString(newtext));
	}
	
	
    }

    public static void main(String[]args){
	Temper g = new Temper();
	g.setVisible(true);
    }
    
}
