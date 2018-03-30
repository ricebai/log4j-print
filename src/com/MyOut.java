package com;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import javax.swing.JTextArea;

public class MyOut extends PrintStream {
	
	private JTextArea ta;

	public MyOut(JTextArea ta) throws FileNotFoundException {
		super("MyOut.log");
		this.ta = ta;
	}

	
	
	@Override
	public void write(int b) {
		// TODO Auto-generated method stub
		write(b);
	}



	@Override
	public void write(byte[] buf, int off, int len) {
		// TODO Auto-generated method stub
		write(new String(buf, off, len));
	}



	@Override
	public void print(boolean b) {
		// TODO Auto-generated method stub
		write(b);
	}



	@Override
	public void print(char c) {
		// TODO Auto-generated method stub
		write(c);
	}



	@Override
	public void print(int i) {
		// TODO Auto-generated method stub
		write(i);
	}



	@Override
	public void print(long l) {
		// TODO Auto-generated method stub
		write(l);
	}



	@Override
	public void print(float f) {
		// TODO Auto-generated method stub
		write(f);
	}



	@Override
	public void print(double d) {
		// TODO Auto-generated method stub
		write(d);
	}



	@Override
	public void print(char[] s) {
		write(s);
	}



	@Override
	public void print(String s) {
		write(s);
	}



	@Override
	public void println() {
//		write();
	}



	@Override
	public void println(boolean x) {
		write(x);
	}



	@Override
	public void println(char x) {
		write(x);
	}



	@Override
	public void println(int x) {
		write(x);
	}



	@Override
	public void println(long x) {
		write(x);
	}



	@Override
	public void println(float x) {
		write(x);
	}



	@Override
	public void println(double x) {
		write(x);
	}



	@Override
	public void println(char[] x) {
		write(x);
	}



	@Override
	public void println(String x) {
		write(x);
	}



	@Override
	public void println(Object x) {
		write(x);
	}




	@Override
	public void print(Object o) {
		write(o);
	}

	
	private void write(Object o){
		String str = o+"\n"+ta.getText();
		// 限制输出长度，避免内存溢出
		if(str.length() > 800){
			str = str.substring(0, 800);
		}
		ta.setText(str);
		
	}
}
