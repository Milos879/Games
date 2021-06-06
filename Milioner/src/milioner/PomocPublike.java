package milioner;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;

public class PomocPublike extends JFrame {

	private JPanel contentPane;
	private JProgressBar odgA;
	private JProgressBar odgB;
	private JProgressBar odgC;
	private JProgressBar odgD;
	private JLabel zaA;
	private JLabel zaB;
	private JLabel zaC;
	private JLabel zaD;

	
	public PomocPublike() {
		setResizable(false);
		
		setBounds(100, 100, 564, 472);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		odgA = new JProgressBar();
		odgA.setForeground(Color.GREEN);
		odgA.setOrientation(SwingConstants.VERTICAL);
		odgA.setBackground(Color.WHITE);
		odgA.setBounds(138, 48, 55, 276);
		odgA.setValue(90);
		contentPane.add(odgA);
		
		odgB = new JProgressBar();
		odgB.setOrientation(SwingConstants.VERTICAL);
		odgB.setValue(97);
		odgB.setForeground(Color.GREEN);
		odgB.setToolTipText("\"ssss");
		odgB.setBounds(216, 48, 55, 276);
		contentPane.add(odgB);
		
		odgC = new JProgressBar();
		odgC.setForeground(Color.GREEN);
		odgC.setValue(555);
		odgC.setOrientation(SwingConstants.VERTICAL);
		odgC.setBounds(298, 48, 55, 276);
		contentPane.add(odgC);
		
		odgD = new JProgressBar();
		odgD.setValue(5);
		odgD.setForeground(Color.GREEN);
		odgD.setOrientation(SwingConstants.VERTICAL);
		odgD.setBounds(380, 48, 55, 276);
		contentPane.add(odgD);
		
		zaA = new JLabel("100%");
		zaA.setForeground(new Color(255, 255, 240));
		zaA.setFont(new Font("Tahoma", Font.BOLD, 15));
		zaA.setBounds(138, 11, 55, 26);
		contentPane.add(zaA);
		
		zaB = new JLabel("100%");
		zaB.setForeground(new Color(230, 230, 250));
		zaB.setFont(new Font("Tahoma", Font.BOLD, 15));
		zaB.setBounds(216, 11, 55, 26);
		contentPane.add(zaB);
		
		zaC = new JLabel("100%");
		zaC.setFont(new Font("Tahoma", Font.BOLD, 15));
		zaC.setForeground(new Color(230, 230, 250));
		zaC.setBounds(298, 11, 55, 26);
		contentPane.add(zaC);
		
		zaD = new JLabel("100%");
		zaD.setForeground(new Color(250, 240, 230));
		zaD.setFont(new Font("Tahoma", Font.BOLD, 15));
		zaD.setBounds(380, 11, 55, 26);
		contentPane.add(zaD);
		
		JLabel a = new JLabel("A");
		a.setForeground(new Color(255, 255, 255));
		a.setFont(new Font("Tahoma", Font.BOLD, 17));
		a.setBounds(161, 323, 12, 32);
		contentPane.add(a);
		
		JLabel lblNewLabel_2 = new JLabel("B");
		lblNewLabel_2.setForeground(new Color(255, 255, 240));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setBounds(238, 323, 12, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("C");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3.setForeground(new Color(240, 248, 255));
		lblNewLabel_3.setBounds(319, 326, 12, 26);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("D");
		lblNewLabel_4.setForeground(new Color(255, 255, 224));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4.setBounds(401, 332, 22, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
		   setVisible(false);
			
			}
		});
		btnNewButton.setBounds(194, 400, 192, 32);
		contentPane.add(btnNewButton);
		}

       
	
	
	    public void postaviRezultat(int brPitanja){
	    	
	           if(brPitanja==0){
	    		
	    		odgA.setValue(60);
	    		zaA.setText("60%");
	    		
	    		odgB.setValue(20);
	    		zaB.setText("20%");
	    		
	    		odgC.setValue(10);
	    		zaC.setText("10%");
	    		
	    		odgD.setValue(10);
	    		zaD.setText("10%");
	    		
	    		
	    	}
	    	
	          else if(brPitanja==1){
		    		
		    		odgA.setValue(13);
		    		zaA.setText("13%");
		    		
		    		odgB.setValue(10);
		    		zaB.setText("10%");
		    		
		    		odgC.setValue(10);
		    		zaC.setText("10%");
		    		
		    		odgD.setValue(67);
		    		zaD.setText("67%");
		    		
		    		
		    	}
	    	
	    	
	          else if(brPitanja==2){
		    		
		    		odgA.setValue(20);
		    		zaA.setText("20%");
		    		
		    		odgB.setValue(60);
		    		zaB.setText("60%");
		    		
		    		odgC.setValue(10);
		    		zaC.setText("10%");
		    		
		    		odgD.setValue(10);
		    		zaD.setText("10%");
		    		
		    		
		    	}
	    	
	          else if(brPitanja==3){
		    		
		    		odgA.setValue(50);
		    		zaA.setText("50%");
		    		
		    		odgB.setValue(20);
		    		zaB.setText("20%");
		    		
		    		odgC.setValue(10);
		    		zaC.setText("10%");
		    		
		    		odgD.setValue(20);
		    		zaD.setText("20%");
		    		
		    		
		    	}
	    	
	    	
	          else if(brPitanja==4){
		    		
		    		odgA.setValue(13);
		    		zaA.setText("13%");
		    		
		    		odgB.setValue(10);
		    		zaB.setText("10%");
		    		
		    		odgC.setValue(10);
		    		zaC.setText("10%");
		    		
		    		odgD.setValue(67);
		    		zaD.setText("67%");
		    		
		    		
		    	}
	          else if(brPitanja==5){
		    		
		    		odgA.setValue(10);
		    		zaA.setText("10%");
		    		
		    		odgB.setValue(50);
		    		zaB.setText("50%");
		    		
		    		odgC.setValue(30);
		    		zaC.setText("30%");
		    		
		    		odgD.setValue(10);
		    		zaD.setText("10%");
		    		
		    		
		    	}
	    
	          else if(brPitanja==6){
		    		
		    		odgA.setValue(25);
		    		zaA.setText("25%");
		    		
		    		odgB.setValue(25);
		    		zaB.setText("25%");
		    		
		    		odgC.setValue(40);
		    		zaC.setText("40%");
		    		
		    		odgD.setValue(10);
		    		zaD.setText("10%");
		    		
		    		
		    	}
	          else if(brPitanja==7){
		    		
		    		odgA.setValue(100);
		    		zaA.setText("100%");
		    		
		    		odgB.setValue(0);
		    		zaB.setText("0%");
		    		
		    		odgC.setValue(0);
		    		zaC.setText("0%");
		    		
		    		odgD.setValue(0);
		    		zaD.setText("0%");
		    		
		    		
		    	}
	          else if(brPitanja==8){
		    		
		    		odgA.setValue(60);
		    		zaA.setText("60%");
		    		
		    		odgB.setValue(20);
		    		zaB.setText("20%");
		    		
		    		odgC.setValue(10);
		    		zaC.setText("10%");
		    		
		    		odgD.setValue(10);
		    		zaD.setText("10%");
		    		
		    		
		    	}
	          else if(brPitanja==9){
		    		
		    		odgA.setValue(10);
		    		zaA.setText("10%");
		    		
		    		odgB.setValue(30);
		    		zaB.setText("30%");
		    		
		    		odgC.setValue(20);
		    		zaC.setText("20%");
		    		
		    		odgD.setValue(40);
		    		zaD.setText("40%");
		    		
		    		
		    	}
	    
	    
	    }
}
