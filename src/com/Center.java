package com;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.apache.log4j.Logger;

public class Center extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JScrollPane js;
	private JTextArea ta;

	public Center() {
		setLayout(new BorderLayout());
		
		add(new JLabel("日志捕获输出", 0), BorderLayout.NORTH);
		add(js = new JScrollPane(ta = new JTextArea())
				, BorderLayout.CENTER);
		ta.setLineWrap(true);
		ta.setFont(new Font("微软雅黑", 1, 14));
		
		try {
			// 对应设置 log4j.properties 中的流指向自定义流
			System.setOut(new MyOut(ta));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		// 实例化日志
		final Logger logger = Logger.getLogger(Center.class);
		
		
		JButton but = new JButton("启动日志模拟输出（间隔500毫秒）");
		but.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// 
				JButton b = ((JButton)e.getSource());
				b.setEnabled(false);
				System.out.println(b.getText());
				
				// 启动线程模拟日志
				new Thread(new Runnable() {
					public void run() {
						while(true){
							logger.info("...........test action.........");
							try {
								Thread.currentThread().sleep(500);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}).start();
			}
		});
		add(but, BorderLayout.SOUTH);
		js.setBorder(null);
		ta.setEditable(false);
		
	}
	
}
