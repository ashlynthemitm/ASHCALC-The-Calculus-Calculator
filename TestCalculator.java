import javax.swing.* ; 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.*;
import java.awt.ComponentOrientation;
import java.awt.Component;

// change the layout of the calculator 
// use more data structures, linked list, tress etc. 
// make the white text box the spot for the most basic problems and the pink for everything else 
public class TestCalculator extends JFrame implements ActionListener, ComponentListener { 
	private static ArrayList findsol = new ArrayList();
	private static boolean testvalue1=false; 
	private static boolean testvalue2=false;
	private static String trig1, trig2; 
	private static String operation; 
	private static String operator; 
	private static double pow=1; 
	private static boolean setpower = false; 
	private static double value1, value2=0;
	private static double answer; 
	private static int placeholder=1;  /// insert this to scan within the program 
	private static JLabel enter = new JLabel(""); 
	private static JLabel eqlabel = new JLabel("");
	private static JFrame Calculator=new JFrame(); 
	private static JButton add = new JButton("+"); 
	private static JButton subtract=new JButton("-"); 
	private static JButton multiply= new JButton("x"); 
	private static JButton divide = new JButton("/"); 
	private static JButton equal=new JButton("=");
	private static JButton e = new JButton("e");
	private static JButton sqrt = new JButton("\u221A");
	private static JButton power = new JButton("^");
	private static JButton pi = new JButton("\u03c0");
	private static JButton sin = new JButton("sin"); 
	private static JButton cos = new JButton("cos");
	private static JButton tan = new JButton("tan");
	private static JButton sec = new JButton("sec");
	private static JButton csc = new JButton("csc");
	private static JButton cot = new JButton("cot");
	private static JButton x = new JButton("x");
	private static JButton xy = new JButton("x"+"ʸ");
	private static JButton ce = new JButton("CE");
	private static JButton perc = new JButton("%");
	private static JButton neg = new JButton("(-)");
	private static JButton decimal = new JButton(".");
	//private static JCheckBox integral= new JCheckBox("Integral");
	private static JCheckBox derivative= new JCheckBox("Derivative");
	//private static JCheckBox findy= new JCheckBox("Find y");
	//private static JCheckBox findzeros = new JCheckBox("Find Zeros"); 
	private static JButton backspace = new JButton("<-");
	private static JButton inpa = new JButton("("); 
	private static JButton outpa = new JButton(")"); 
	private static JButton sqrd = new JButton("x"+"²");
	private static JButton log = new JButton("log");
	private static JButton ln = new JButton("ln");
	private static JMenuItem solvemenu, standardmenu ;
	private static JPanel eqpanel = new JPanel();	
	private static JPanel panel=new JPanel(); // remove this panel later 
	private static String [] powamt = {"⁰","¹","²", "³", "⁴", "⁵","⁶", "⁷", "⁸", "⁹"};
	
	public static void main (String[]args) {  
		TestCalculator calc=new TestCalculator();
		Calculator.setVisible(true);
		Calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	}

	public TestCalculator() {

		// Layout 
		Calculator.setResizable(false);
		final int WIDTH=260;
		final int HEIGHT=550; 	
		JMenuBar menuBar = new JMenuBar();
		JMenu dropmenu = new JMenu("☰");
		solvemenu = new JMenuItem("Solve equation"); 
		dropmenu.add(solvemenu);
		menuBar.add(dropmenu);
		menuBar.setBackground(Color.black);
		dropmenu.setForeground(Color.pink);
		solvemenu.setBackground(Color.pink);
		Calculator.setJMenuBar(menuBar);
		Container c=Calculator.getContentPane();
		panel.setPreferredSize(new Dimension(200,25));
		c.setLayout(new FlowLayout(FlowLayout.CENTER,0,60)); 
		eqpanel.setPreferredSize(new Dimension(200,150));
		panel.setBackground(Color.white);
		eqpanel.setBackground(Color.pink); 
		Font font=new Font("Times New Roman", Font.BOLD, 20);
		
		
		JButton clear=new JButton("C");
		JButton one = new JButton("1");
		JButton two = new JButton("2");
		JButton three= new JButton("3");
		JButton four= new JButton("4");
		JButton five= new JButton("5");
		JButton six = new JButton("6");
		JButton seven= new JButton("7");
		JButton eight= new JButton("8");
		JButton nine= new JButton("9");
		JButton zero = new JButton("0");

		enter.setVerticalAlignment(JLabel.CENTER);
		Calculator.getContentPane().setBackground(Color.black);Calculator.getContentPane().setBackground(Color.BLACK);
		Calculator.setTitle("AshCalc");
		Calculator.setSize(WIDTH, HEIGHT);
		Calculator.setLayout(new FlowLayout());
		
		one.setBackground(Color.white);two.setBackground(Color.white);three.setBackground(Color.white);four.setBackground(Color.white);five.setBackground(Color.white);six.setBackground(Color.white);
		seven.setBackground(Color.white);eight.setBackground(Color.white);nine.setBackground(Color.white);zero.setBackground(Color.white);clear.setBackground(Color.white);multiply.setBackground(Color.white);
		add.setBackground(Color.white);subtract.setBackground(Color.white);divide.setBackground(Color.white);equal.setBackground(Color.white);sin.setBackground(Color.white);
		cos.setBackground(Color.white);tan.setBackground(Color.white);sec.setBackground(Color.white);csc.setBackground(Color.white);cot.setBackground(Color.white);e.setBackground(Color.white);power.setBackground(Color.white);sqrt.setBackground(Color.white);pi.setBackground(Color.white);
		x.setBackground(Color.white);inpa.setBackground(Color.white);outpa.setBackground(Color.white);log.setBackground(Color.white);ln.setBackground(Color.white);sqrd.setBackground(Color.white);
		backspace.setBackground(Color.white);xy.setBackground(Color.white);derivative.setBackground(Color.pink);
		//integral.setBackground(Color.pink);findy.setBackground(Color.pink);//findzeros.setBackground(Color.pink);
		clear.setFont(font);equal.setFont(font);add.setFont(font);subtract.setFont(font);multiply.setFont(font);divide.setFont(font);backspace.setFont(font);
		
		//Calculator.add(numpanel);//Calculator.add(oppanel);//numpanel.add(one); numpanel.add(two); numpanel.add(three); numpanel.add(four); numpanel.add(five); numpanel.add(six); numpanel.add(seven); numpanel.add(eight);numpanel.add(nine); numpanel.add(zero);
		eqpanel.add(eqlabel);panel.add(enter);Calculator.add(eqpanel);Calculator.add(panel);Calculator.add(backspace);Calculator.add(equal);Calculator.add(clear);Calculator.add(add);Calculator.add(subtract);Calculator.add(multiply);Calculator.add(divide);
		Calculator.add(one); Calculator.add(two); Calculator.add(three);Calculator.add(four); Calculator.add(five); Calculator.add(six);Calculator.add(seven); Calculator.add(eight); Calculator.add(nine);Calculator.add(zero);
		Calculator.add(power);Calculator.add(sqrd);Calculator.add(pi); Calculator.add(e); Calculator.add(sin);Calculator.add(cos);Calculator.add(tan); Calculator.add(sec);Calculator.add(csc);Calculator.add(cot);
		Calculator.add(log);Calculator.add(ln); Calculator.add(sqrt); Calculator.add(x);Calculator.add(xy); Calculator.add(inpa); Calculator.add(outpa);
		backspace.getRootPane().setSize(50,600);
		clear.addActionListener(new clear());
		one.addActionListener(new one());two.addActionListener(new two());three.addActionListener(new three());four.addActionListener(new four());five.addActionListener(new five());six.addActionListener(new six());seven.addActionListener(new seven());eight.addActionListener(new eight());nine.addActionListener(new nine());zero.addActionListener(new zero());
		add.addActionListener(new opps());subtract.addActionListener(new opps());multiply.addActionListener(new opps());divide.addActionListener(new opps());equal.addActionListener( new opps());power.addActionListener(new opps()); 
		//integral.addActionListener(new solveeq());findy.addActionListener(new solveeq());findzeros.addActionListener(new solveeq());
		derivative.addActionListener(new solveeq());
		sin.addActionListener(new trig());cos.addActionListener(new trig());tan.addActionListener(new trig());sec.addActionListener(new trig());csc.addActionListener(new trig());cot.addActionListener(new trig());ln.addActionListener(new trig());log.addActionListener(new trig());sqrd.addActionListener(new trig()); x.addActionListener(new trig());inpa.addActionListener(new trig());outpa.addActionListener(new trig());xy.addActionListener(new trig());
		solvemenu.addActionListener(this);backspace.addActionListener(this);
		pi.addActionListener(new pi()); 
		e.addActionListener(new efunc()); 
		sqrt.addActionListener(new sqrt()); 


	}






	@Override
	public void actionPerformed(ActionEvent d) {  /// get one to work at a time 
		if (d.getSource()==backspace) {	
			eqlabel.setText(eqlabel.getText().substring(0,eqlabel.getText().length()-1));
			enter.setText(enter.getText().substring(0,enter.getText().length()-1));
		}

		if (d.getSource()==solvemenu) {
			// add buttons for integrals etc. 
			eqlabel.setText("f(x)="+" ");
			eqlabel.setText("f(x)=");
			//Calculator.add(integral);
			Calculator.add(derivative);
			//Calculator.add(findy);
			//Calculator.add(findzeros);
		}

		if (d.getSource()==standardmenu) { // adjust the way the panels show and not show for the feature later 
			//Calculator.remove(integral);
			Calculator.remove(derivative);
			//Calculator.remove(findy);
			//Calculator.remove(findzeros);
		}
		
		

	}


	private static class trig implements ActionListener{ // multiply times place holder 
		public void actionPerformed(ActionEvent a) { 
			if (a.getSource()==sec) {
				eqlabel.setText(eqlabel.getText()+"sec"); 
			} else if (a.getSource()==csc) {
				eqlabel.setText(eqlabel.getText()+"csc"); 
			} else if (a.getSource()==cot) {
				eqlabel.setText(eqlabel.getText()+"cot"); 
			}
				
			if (a.getSource()==xy) {
				setpower = true; 
			}
			if (a.getSource()==x) {
				eqlabel.setText(eqlabel.getText()+"x");
			}
			if (a.getSource()==sqrd) {
				double b = Double.parseDouble(enter.getText());
				b = Math.pow(b, 2);
				enter.setText(Double.toString(b));
				eqlabel.setText(eqlabel.getText()+"²");
			}

			if (a.getSource()==inpa) {
				eqlabel.setText(eqlabel.getText()+"(");
			}
			if (a.getSource()==outpa) {
				eqlabel.setText(eqlabel.getText()+")");
			}
			if (a.getSource()==sin) { // add in setting the text to what is being inputted 

				if (trig1==null) {
					trig1="sin";  // say if == this use Math.sin
					eqlabel.setText(eqlabel.getText()+"sin");
					enter.setText(enter.getText()+"sin");
				} else {
					trig2="sin";
					eqlabel.setText(eqlabel.getText()+"sin");
					enter.setText(enter.getText()+"sin");
				}

			} else if (a.getSource()==cos) {
				if (trig1==null) {
					trig1="cos";  // say if == this use Math.sin
					eqlabel.setText(eqlabel.getText()+"cos");
					enter.setText(enter.getText()+"cos");
				} else {
					trig2="cos";
					eqlabel.setText(eqlabel.getText()+"cos");
					enter.setText(enter.getText()+"cos");
				}

			} else if (a.getSource()==tan) {
				if (trig1==null) {
					trig1="tan";  // say if == this use Math.sin
					eqlabel.setText(eqlabel.getText()+"tan");
					enter.setText(enter.getText()+"tan");
				} else {
					trig2="tan";
					eqlabel.setText(eqlabel.getText()+"tan");
					enter.setText(enter.getText()+"tan");
				}

			} else if (a.getSource()==ln) {
				if (trig1==null) {
					trig1="ln";  // say if == this use Math.sin
					eqlabel.setText(eqlabel.getText()+"ln");
					enter.setText(enter.getText()+"ln");
				} else {
					trig2="tan";
					eqlabel.setText(eqlabel.getText()+"ln");
					enter.setText(enter.getText()+"ln");
				}
			} else if (a.getSource()==log) {
				if (trig1==null) {
					trig1="log";  // say if == this use Math.sin
					eqlabel.setText(eqlabel.getText()+"log");
					enter.setText(enter.getText()+"log");
				} else {
					trig2="tan";
					eqlabel.setText(eqlabel.getText()+"log");
					enter.setText(enter.getText()+"log");
				}
			}



		}
	}
	private static class opps implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setpower = false; 
			if (e.getSource()==equal&&pow!=1) {
				value1=Math.pow(value1, pow); 
				enter.setText(Double.toString(value1));
			}

			if (e.getSource()==add) {
				operation="add"; 
				if (!eqlabel.getText().equals("")) {
					eqlabel.setText(eqlabel.getText()+"+");
				}
			} else if (e.getSource() == subtract) {
				operation="subtract";
				if (!eqlabel.getText().equals("")) {
					eqlabel.setText(eqlabel.getText()+"-");
				}
			} else if (e.getSource()== multiply) {
				operation="multiply";
				if (!eqlabel.getText().equals("")) {
					eqlabel.setText(eqlabel.getText()+"*");
				}
			} else if (e.getSource()== divide) {
				operation="divide";
				if (!eqlabel.getText().equals("")) { // adjust this if I have to 
					eqlabel.setText(eqlabel.getText()+"/");
				}
			} else if (e.getSource()== power) {
				operation="power";
				if (!eqlabel.getText().equals("")) { // adjust this if I have to 
					eqlabel.setText(eqlabel.getText()+"^");
				}

			}
			if(value1==0&&value2==0&&e.getSource()!=equal) { // change these if statements

				// change this trig reading around to fit parantheses 
				if (trig1!=null) { // if substring (0,2).equals sin or cos or tan
					String x=enter.getText().substring(3); 
					double a=Double.parseDouble(x);
					if(trig1=="sin") {	
						value1=Math.sin(a);
					} else if (trig1=="cos") {
						value1=Math.cos(a);	

					} else if (trig1=="tan") {
						value1=Math.tan(a);	
					} else if (trig1=="ln") {
						value1=Math.log(a);
					} else if (trig1=="log") {
						value1=Math.log10(a);
					}
				} else {
					value1=Double.parseDouble(enter.getText()); // setting the first value equal to the value1 value 
				}

				testvalue1=true; // now it will be known that one value has been established 
				enter.setText("");
			} else if (value1!=0&&testvalue1==true) {

				if (trig2!=null) {
					String x=enter.getText().substring(3);
					double a=Double.parseDouble(x);
					if(trig2=="sin") {	
						value2=Math.sin(a);
					} else if (trig2=="cos") {
						value2=Math.cos(a);	
					} else if (trig2=="tan") {
						value2=Math.tan(a);	
					} else if (trig2=="ln") {
						value2=Math.log(a);
					} else if (trig2=="log") {
						value2=Math.log10(a);
					}

				} else {
					value2=Double.parseDouble(enter.getText());; 
				}
				testvalue2=true; 
				enter.setText("");
			} 



			// tie together the answer here 
			if (testvalue1==true&&testvalue2==true&&e.getSource()==equal) {
				if(operation.equals("add")) {
					answer=value1+value2;
				} if (operation.equals("subtract")) {
					answer=value1-(value2);
				} if (operation.equals("multiply")) {
					answer=(value1)*(value2);
					System.out.println(answer);
				} if (operation.equals("divide")) {
					answer=value1/value2; // divide a number by 0 and understand it is equal to infinity :)
				} if (operation.equals("power")) {
					answer=Math.pow(value1, value2);
				}
				eqlabel.setText(eqlabel.getText()+ "="+Double.toString(answer)+"\n;");
				
				enter.setText(Double.toString(answer));
				testvalue1=false;
				testvalue2=false; 
				value1=0; 
				value2=0; 
			}
		}
	}

	private static class one implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			enter.setText(enter.getText()+"1");
			if (setpower) {
				eqlabel.setText(eqlabel.getText()+powamt[1]);
			}else {
				eqlabel.setText(eqlabel.getText()+"1");
			}
		}
	} private static class two implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			enter.setText(enter.getText()+"2");
			if (setpower) {
				eqlabel.setText(eqlabel.getText()+powamt[2]);
			}else {
				eqlabel.setText(eqlabel.getText()+"2");
			}
		}
	} private static class three implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			enter.setText(enter.getText()+"3");
			if (setpower) {
				eqlabel.setText(eqlabel.getText()+powamt[3]);
			}else {
				eqlabel.setText(eqlabel.getText()+"3");
			}
		}
	} private static class four implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			enter.setText(enter.getText()+"4");
			if (setpower) {
				eqlabel.setText(eqlabel.getText()+powamt[4]);
			}else {
				eqlabel.setText(eqlabel.getText()+"4");
			}
		}
	} private static class five implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			enter.setText(enter.getText()+"5");
			if (setpower) {
				eqlabel.setText(eqlabel.getText()+powamt[5]);
			}else {
				eqlabel.setText(eqlabel.getText()+"5");
			}
		}
	} private static class six implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			enter.setText(enter.getText()+"6");
			if (setpower) {
				eqlabel.setText(eqlabel.getText()+powamt[6]);
			}else {
				eqlabel.setText(eqlabel.getText()+"6");
			}
		}
	} private static class seven implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			enter.setText(enter.getText()+"7");
			if (setpower) {
				eqlabel.setText(eqlabel.getText()+powamt[7]);
			}else {
				eqlabel.setText(eqlabel.getText()+"7");
			}
		}
	} private static class eight implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			enter.setText(enter.getText()+"8");
			if (setpower) {
				eqlabel.setText(eqlabel.getText()+powamt[8]);
			}else {
				eqlabel.setText(eqlabel.getText()+"8");
			}
		}
	} private static class nine implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			enter.setText(enter.getText()+"9");
			if (setpower) {
				eqlabel.setText(eqlabel.getText()+powamt[9]);
			}else {
				eqlabel.setText(eqlabel.getText()+"9");
			}
		}
	} private static class zero implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			enter.setText(enter.getText()+"0");
			if (setpower) {
				eqlabel.setText(eqlabel.getText()+powamt[0]);
			}else {
				eqlabel.setText(eqlabel.getText()+"0");
			}
		}
	} private static class clear implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setpower = false; 
			eqlabel.setText("");
			enter.setText("");
			value1=0;
			value2=0; 
			trig1=null; 
			trig2=null; 

			testvalue1=false; 
			testvalue2=false; 

		}
	} private static class pi implements ActionListener { // change the input into the equation label into the pi symbol .... from there it'll read it 
		public void actionPerformed(ActionEvent e) {

			eqlabel.setText(eqlabel.getText()+"\u03c0");
			if (enter.getText().equals("")&&value1==0) {
				//enter.setText(Double.toString(Math.PI));
				value1=Math.PI;
				testvalue1=true; 
				enter.setText(Double.toString(value1));	

			} else if (enter.getText().equals("")&&value2==0) {
				value2=Math.PI;
				testvalue2=true; 
				enter.setText(Double.toString(value2));

			} else if (trig1!=null&&trig2==null) { // may have to adjust this condition
				// left off here  
				System.out.println(enter.getText().substring(3)+"this");
				if(enter.getText().substring(3).equals(null)) {
					enter.setText(enter.getText()+Math.PI);

				} else {
					double b =Double.parseDouble(enter.getText().substring(3)); 
					value1=Math.PI*b; 

				}

			} else if (trig2!=null) { // may have to adjust this condition
				if(enter.getText().substring(3).equals(null)) {
					enter.setText(enter.getText()+Math.PI);
				} else {
					double b =Double.parseDouble(enter.getText().substring(3)); 
					value1=Math.PI*b; 

				}

			}
			else {
				double b=Double.parseDouble(enter.getText());
				b=b*Math.PI;
				enter.setText(Double.toString(b));

			}
		}
	} private static class efunc implements ActionListener { // fix e later 
		public void actionPerformed(ActionEvent e) {
			eqlabel.setText(eqlabel.getText()+"e");
			if (enter.getText().equals("")&&value1==0) {
				//enter.setText(Double.toString(Math.PI));
				value1=Math.E;
				testvalue1=true; 
				enter.setText(Double.toString(value1));
			} else if (enter.getText().equals("")&&value2==0) {
				value2=Math.E;
				testvalue2=true; 
				enter.setText(Double.toString(value2));
			} else {
				double b=Double.parseDouble(enter.getText());
				b=b*Math.E;
				enter.setText(Double.toString(b));
			}
		}
	} 
	private static class sqrt implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			double b=Math.sqrt(Double.parseDouble(enter.getText()));
			enter.setText(Double.toString(b));
			eqlabel.setText(eqlabel.getText()+Double.toString(b));
		}
	}
	private static class solveeq implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String x = eqlabel.getText();
			// Make a checkbox to set an x value .. some kind of enter option 
			if (e.getSource()==derivative) {
				 x=CalcOpp.findder(x);
			enter.setText("Derivative: "+x);
			}
			


		}
	}

}	

