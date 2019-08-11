package br.com.cg.conversao;

import javax.swing.JOptionPane;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

public class Conversao {
	public static void main(String[] args) {
		double[][] data = {{0.4124, 0.3576, 0.1805},{0.2126, 0.7152, 0.0722},{0.0193, 0.1192, 0.9505}};
		RealMatrix mt = MatrixUtils.createRealMatrix(data);
		double r = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de R:"))/255;
		double g = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do G:"))/255;
		double b = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do B:"))/255;
		
		double[][] rgb = {{r*100},{g*100},{b*100}};
		
		RealMatrix mrgb = MatrixUtils.createRealMatrix(rgb);
		
		RealMatrix xyz = mt.multiply(mrgb);
		
		System.out.println("x: "+ xyz.getRowVector(0));
		System.out.println("y: "+ xyz.getRowVector(1));
		System.out.println("z: "+ xyz.getRowVector(2));
		
		double w = Math.max(Math.max(r/255, g/255), b/255);
		double c = (w - r)/w;
		double m = (w - g)/w;
		double y = (w - b)/w;
		double k = 1-w;
		System.out.println("c ="+c+"\nm ="+m+"\ny ="+y+"\nk ="+k);
	}

}
