import javax.swing.*;  
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
import java.util.*;
import java.awt.ComponentOrientation;
import java.awt.Component;


public class CalcOpp extends TestCalculator{ 

	public static void main(String[] args) {
		String [][] power = {{"0", "⁰"}, {"1", "¹"}, {"2", "²"}, 
				{"3", "³"}, {"4", "⁴"}, {"5", "⁵"}, 
				{"6", "⁶"}, {"7", "⁷"}, {"8", "⁸"}, {"9", "⁹"}}; 
	
		
		System.out.println(findy("57x+5","2"));
		System.out.println(findder("tan(x)+15x²+sin(x)+3x+5"));
	}
	public static int superscript(String str) {  
		str = str.replaceAll( "⁰","0");
		str = str.replaceAll( "¹","1");
		str = str.replaceAll( "²","2");
		str = str.replaceAll("³","3" );
		str = str.replaceAll( "⁴","4");
		str = str.replaceAll( "⁵","5");
		str = str.replaceAll( "⁶","6");
		str = str.replaceAll( "⁷","7");
		str = str.replaceAll( "⁸","8");
		str = str.replaceAll( "⁹","9");  
		return Integer.parseInt(str);
	}
	public static String backscript(String str) {
		str = str.replaceAll( "0","⁰");
		str = str.replaceAll( "1","¹");
		str = str.replaceAll( "2","²");
		str = str.replaceAll("3","³" );
		str = str.replaceAll("4", "⁴");
		str = str.replaceAll( "5","⁵");
		str = str.replaceAll( "6","⁶");
		str = str.replaceAll( "7","⁷");
		str = str.replaceAll( "8","⁸");
		str = str.replaceAll( "9","⁹"); 
		if (str.equals("¹")) {
			str ="";
		}
		return str; 
	}
	public static String fixeq(String str) {
		 
		str = str.replaceAll( "0","⁰");
		str = str.replaceAll( "1","¹");
		str = str.replaceAll( "2","²");
		str = str.replaceAll("3","³" );
		str = str.replaceAll("4", "⁴");
		str = str.replaceAll( "5","⁵");
		str = str.replaceAll( "6","⁶");
		str = str.replaceAll( "7","⁷");
		str = str.replaceAll( "8","⁸");
		str = str.replaceAll( "9","⁹"); 
			
		
		
		
		return str; 
	}
	public static String [] stored (String equation) {
		int eq=0; 
		String [] store = {"","","","","","","",""};
		int count = 0;
		int spots = 1;
		boolean neg = false; 

		for (int i=0; i<equation.length(); i++) {
			if (equation.substring(i,i+1).equals("+")||equation.substring(i,i+1).equals("-")) {
				count++; 
				spots++; 
			} 
			if (equation.substring(i,i+1).equals("+")) {
				i++; 
			}
			store [count] = store[count] + equation.substring(i,i+1);
		}	
		return store; 
	}
	
	
	public static String findder(String equation) { 
		int c=1; 
		int n=1; 
		String derivative = "";
		String [] trig_deriv = {"sin(x)", "cos(x)","tan(x)","sec(x)","csc(x)","cot(x)","sec(x)tan(x)","sec²(x)","cot²(x)" ,"csc²(x)",
								"ln(x)","sin¹(1x¹)", "cos¹(1x¹)","tan¹(1x¹)","sec¹(1x¹)","csc¹(1x¹)" }; 
		int spots=1; 
		String [] store = stored(equation);
		for (int i=0; i<equation.length();i++) {
			if (equation.substring(i,i+1).equals("+")||equation.substring(i,i+1).equals("-")) {
				spots++; 
			}
		}
		for (int i=0; i<store.length;i++) {
		if (store[i].equals(trig_deriv[0])) { // sin
			derivative = derivative + trig_deriv[1]+"+";
			store[i]="1";  
		} else if (store[i].equals(trig_deriv[1])) { // cos 
			derivative = derivative + "-" + trig_deriv[0]+"+";
			store[i]="1"; 
		} else if (store[i].equals(trig_deriv[2])) { // tan
			derivative = derivative + trig_deriv[7]+"+";
			store[i]="1"; 
		} else if (store[i].equals(trig_deriv[3])) { // sec 
			derivative = derivative + trig_deriv[6]+"+";
			store[i]="1"; 
		} else if (store[i].equals(trig_deriv[4])) { // csc 
			derivative = derivative + "-"+ trig_deriv[4]+trig_deriv[5];
		} else if (store[i].equals(trig_deriv[5])) { // cot
			derivative = derivative + "-" + trig_deriv[9]; 
		} else if (store[i].equals(trig_deriv[10])) { // ln(x)
			derivative = derivative + "1/x";
		}
		}
		
		for (int i=0; i<spots; i++) {
			if (store[i].contains("x")) {
				c=Integer.parseInt(store[i].substring(0,store[i].indexOf("x"))); // assigning the values for the formula cx^n --> (c*n)x^(n-1)
				if (store[i].indexOf("x")!=store[i].length()-1) {
				n=superscript(store[i].substring(store[i].indexOf("x")+1)); // getting the n variable amount --> now to do the formula 
				c = n*c; 
				n = n-1; 
				String power=backscript(Integer.toString(n));
				if (power.equals("⁰")) { // adding an incase its to the power of 0
				derivative = derivative+"1"+"+";	
				}else {
				derivative =derivative+c + "x" + power+"+";
				}
			
				} else {
					derivative = derivative+Integer.toString(c)+"+";
				}
			}  
			
			
		}
		
		
			return derivative.substring(0,derivative.length()-1);
	
	}

	public String findinter(String equation) {
		String str_integral [] = {"ex","x²/2","x³/3","x⁴/4","x⁵/5","x⁶/6","x⁷/7","x⁸/8","x⁹/9"};
		String integral = ""; 
		
		// in the works
		
		
		
		
		return integral; 
		
	}

	public static String findy(String equation, String x) {  
		int eq=0; 
		String [] store = {"","","","","","","",""};
		int count = 0;
		int spots = 1;
		System.out.println(equation);

		for (int i=0; i<equation.length(); i++) {
			if (equation.substring(i,i+1).equals("+")||equation.substring(i,i+1).equals("-")) { 
				count++; 
				spots++; 
			} 
			if (equation.substring(i,i+1).equals("+")) {
				i++; 
			}
			store [count] = store[count] + equation.substring(i,i+1);
		}	
		
		for (int a=0; a<=spots; a++) {
			for (int i=0; i<=store[a].length();i++) {
				if (store[a].contains("x")) {
					int b =  Integer.parseInt(store[a].substring(0,store[a].indexOf("x")))*Integer.parseInt(x);       
					// System.out.println(b); 
					store[a]= Integer.toString(b);
					// System.out.println(store[a]);  
				}
			}
		}
		
		for (int a=0; a<spots; a++) {
			if (store[a].equals("")) {
				a++; 
			}
			eq = eq + Integer.parseInt(store[a]);
		}

		return "y="+eq; 
	}



	public String findzeros(String equation) { // only for quadratic equations 
		String zeros = "";
		// in process
		return zeros; // seperate seperate values by commas if needed 
	}





}
