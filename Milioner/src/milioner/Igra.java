package milioner;

import java.awt.BorderLayout; 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.SystemColor;

public class Igra extends JFrame {

	private JPanel contentPane;

	//pocetak
	private JPanel panel;
	private JButton izlazDugme; 
	private JButton startDugme;
    //igra
	private JPanel panelIgra;
	private JButton odgA;
	private JButton odgB;
	private JButton odgC;
	private JButton odgD;
	private  JLabel suma1; 
	private JLabel suma2;
	private JLabel suma3; 
	private JLabel suma4;
	private JLabel suma5;
	private JLabel suma6;
	private JLabel suma7;
	private JLabel suma8;
	private JLabel suma9;
	private JLabel suma10;
	private JLabel pitanje;

	private JButton publika ;
	private JButton prijatelj;
	private JButton pola;
	
//akcije igra
	
ActionListener akcijaA;
ActionListener akcijaB;
ActionListener akcijaC;
ActionListener akcijaD;

ActionListener akcijaPola;
ActionListener akcijaPublika;
ActionListener akcijaPrijatelj;
	
Timer t;
boolean dalje=true;
int brojac;
Thread nit;
String ko;
int  brPitanja;
char odg;

ArrayList<String> pitanja;
String [][] odgovori;





	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Igra frame = new Igra();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Igra() {
		
		
		//pocetak
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(500, 100, 881, 648);
	    setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 panel = new JPanel();
		panel.setBounds(0, -13, 875, 632);
		
		panel.setLayout(null);
		
		JLabel pozadina = new JLabel();
		pozadina.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/milioner2.png")).getImage()));
		pozadina.setBounds(0, 11, 875, 626);
		panel.add(pozadina);
		
		
		
		startDugme = new JButton("Igraj");
		startDugme.setBackground(Color.GRAY);
		startDugme.setForeground(Color.BLACK);
		startDugme.setFont(new Font("Tahoma", Font.BOLD, 25));
		startDugme.setBounds(10, 37, 127, 39);
		panel.add(startDugme,0);
		
		izlazDugme = new JButton("Izlaz");
		izlazDugme.setForeground(Color.BLACK);
		izlazDugme.setFont(new Font("Tahoma", Font.BOLD, 25));
		izlazDugme.setBackground(Color.GRAY);
		izlazDugme.setBounds(10, 97, 127, 39);
		panel.add(izlazDugme,0);
		
		contentPane.add(panel,0);
		
		
		//igraaa

		panelIgra = new JPanel();
		panelIgra.setBounds(0, 0, 875, 619);
		panelIgra.setLayout(null);
		panelIgra.setVisible(false);
		
		JLabel pozadinaIgre = new JLabel("");
		pozadinaIgre.setBounds(0, 0, 876, 619);
		pozadinaIgre.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/pitanja.png")).getImage()));
		panelIgra.add(pozadinaIgre,0);
		
	    
	      //odgovor(igra)
		odgA = new JButton("A:");
	    odgA.setForeground(new Color(255, 165, 0));
		odgA.setBackground(new Color(0, 0, 0));
		odgA.setFont(new Font("Tahoma", Font.BOLD, 16));
		odgA.setHorizontalAlignment(SwingConstants.LEFT);
		odgA.setBounds(320, 436, 172, 51);
		panelIgra.add(odgA,0);
		
		odgB = new JButton("B:");
		odgB.setForeground(new Color(255, 165, 0));
		odgB.setBackground(new Color(0, 0, 0));
		odgB.setFont(new Font("Tahoma", Font.BOLD, 16));
		odgB.setHorizontalAlignment(SwingConstants.LEFT);
		odgB.setBounds(622, 436, 172, 51);
		panelIgra.add(odgB,0);
		
		odgC = new JButton("C:");
		odgC.setFont(new Font("Tahoma", Font.BOLD, 16));
		odgC.setBackground(new Color(0, 0, 0));
		odgC.setForeground(new Color(255, 165, 0));
		odgC.setHorizontalAlignment(SwingConstants.LEFT);
		odgC.setBounds(320, 523, 172, 51);
		panelIgra.add(odgC,0);
		
		odgD = new JButton("D:");
		odgD.setFont(new Font("Tahoma", Font.BOLD, 16));
		odgD.setBackground(new Color(0, 0, 0));
		odgD.setForeground(new Color(255, 165, 0));
		odgD.setHorizontalAlignment(SwingConstants.LEFT);
		odgD.setBounds(622, 522, 172, 52);
		panelIgra.add(odgD,0);
	     
		
		
		//osvojene sume
		suma1 = new JLabel("1.   100.000 $");
		suma1.setFont(new Font("Tahoma", Font.BOLD, 17));
		suma1.setForeground(new Color(255, 165, 0));
		suma1.setOpaque(true);
		suma1.setBackground(new Color(0, 0, 0));
		suma1.setBounds(10, 568, 150, 51);
		panelIgra.add(suma1,0);
	    
		
		
		
		
		suma2 = new JLabel("2.   200.000 $");
		suma2.setForeground(new Color(255, 165, 0));
		suma2.setFont(new Font("Tahoma", Font.BOLD, 17));
		suma2.setBackground(new Color(0, 0, 0));
		suma2.setBounds(10, 506, 150, 51);
		suma2.setOpaque(true);
		panelIgra.add(suma2,0);
		
	    suma3 = new JLabel("3.   300.000 $");
	    suma3.setForeground(new Color(255, 165, 0));
	    suma3.setFont(new Font("Tahoma", Font.BOLD, 17));
	    suma3.setBackground(new Color(0, 0, 0));
		suma3.setBounds(10, 444, 150, 51);
		suma3.setOpaque(true);
		panelIgra.add(suma3,0);
		
		suma4 = new JLabel("4.   400.000 $");
		suma4.setForeground(new Color(255, 165, 0));
		suma4.setFont(new Font("Tahoma", Font.BOLD, 17));
		suma4.setBackground(new Color(0, 0, 0));
		suma4.setBounds(10, 382, 150, 51);
		suma4.setOpaque(true);
		panelIgra.add(suma4,0);
		
		suma5 = new JLabel("5.   500.000 $");
		suma5.setForeground(new Color(255, 165, 0));
		suma5.setFont(new Font("Tahoma", Font.BOLD, 17));
		suma5.setBackground(new Color(0, 0, 0));
		suma5.setBounds(10, 320, 150, 51);
		suma5.setOpaque(true);
		panelIgra.add(suma5,0);
		
		suma6 = new JLabel("6.   600.000 $");
		suma6.setForeground(new Color(255, 165, 0));
		suma6.setFont(new Font("Tahoma", Font.BOLD, 17));
		suma6.setBackground(new Color(0, 0, 0));
		suma6.setBounds(10, 258, 150, 51);
		suma6.setOpaque(true);
		panelIgra.add(suma6,0);
		
		suma7 = new JLabel("7.   700.000 $");
		suma7.setFont(new Font("Tahoma", Font.BOLD, 17));
		suma7.setForeground(new Color(255, 165, 0));
		suma7.setBackground(new Color(0, 0, 0));
		suma7.setBounds(10, 196, 150, 51);
		suma7.setOpaque(true);
		panelIgra.add(suma7,0);
		
		suma8 = new JLabel("8.   800.000 $");
		suma8.setFont(new Font("Tahoma", Font.BOLD, 17));
		suma8.setForeground(new Color(255, 165, 0));
		suma8.setBackground(new Color(0, 0, 0));
		suma8.setBounds(10, 134, 150, 51);
		suma8.setOpaque(true);
		panelIgra.add(suma8,0);
		
		suma9 = new JLabel("9.   900.000 $");
		suma9.setFont(new Font("Tahoma", Font.BOLD, 17));
		suma9.setForeground(new Color(255, 165, 0));
		suma9.setOpaque(true);
		suma9.setBackground(new Color(0, 0, 0));
		suma9.setBounds(10, 72, 150, 51);
		panelIgra.add(suma9,0);
		
		
	    suma10 = new JLabel("10. 1.000.000 $");
	    suma10.setBackground(new Color(0, 0, 0));
	    suma10.setForeground(new Color(255, 165, 0));
	    suma10.setFont(new Font("Tahoma", Font.BOLD, 17));
		suma10.setOpaque(true);
		suma10.setBounds(10, 11, 150, 50);
		panelIgra.add(suma10,0);
		
		//pitanje(igra)
		pitanje = new JLabel();
		pitanje.setOpaque(true);
		pitanje.setForeground(new Color(255, 165, 0));
		pitanje.setBackground(new Color(0, 0, 0));
		pitanje.setHorizontalAlignment(SwingConstants.CENTER);
		pitanje.setFont(new Font("Tahoma", Font.BOLD, 16));
		pitanje.setBounds(320, 52, 474, 60);
		panelIgra.add(pitanje,0);
		
		
		
		
		
		
		
	
		//pomocne(igra)
	    publika = new JButton();
	    
	    publika.setForeground(new Color(25, 25, 112));
	    publika.setBackground(new Color(25, 25, 112));
		publika.setBounds(165, 162, 84, 51);
		panelIgra.add(publika,0);
		
		prijatelj = new JButton();
		prijatelj.setForeground(new Color(25, 25, 112));
		prijatelj.setBackground(new Color(25, 25, 112));
		prijatelj.setBounds(165, 224, 84, 51);
		panelIgra.add(prijatelj,0);
		
	    pola = new JButton();
		pola.setForeground(new Color(25, 25, 112));
		pola.setBackground(new Color(25, 25, 112));
		pola.setBounds(165, 286, 84, 51);
		panelIgra.add(pola,0);
		
		
		pitanja=new ArrayList<String>();
		odgovori=new String[10][4];
		
		pitanja.add("Koji je najveci organ u ljudskom telu?");
		odgovori[0]=new String[] {"A: koza","B: srce","C: bubreg","D: mozak"}; //A
		
		pitanja.add("Rodonacelnik je?");
		odgovori[1]=new String[] {"A: prirodnjak","B: gonic","C: osnivac","D: vladar"};//C
	
		pitanja.add("Glavni grad Ukrajine je?");
		odgovori[2]=new String[] {"A: Moskva","B: Kijev","C: Madrid","D: Berlin"};//B
		
		pitanja.add("Koliko minuta traje fudbalska utakmica?");
		odgovori[3]=new String[] {"A: 90","B: 80","C: 38","D: 100"};//A
		
		pitanja.add("Dogramadzija je turski naziv za kog majstora?");
		odgovori[4]=new String[] {"A: zlatara","B: tapetra","C: obucara","D: drvodelju"};//D
		
		pitanja.add("Kako se zove dvorac u kome obitava Hamlet");
		odgovori[5]=new String[] {"A: Kamelot","B: Elsinor","C: Azir","D: Kodor"}; //B
		
		pitanja.add("Odakle poticu Siki?");
		odgovori[6]=new String[] {"A: Ekvador","B: Koreja","C: Indija","D: Maroko"};//C
		
		pitanja.add("Milos Milojevic je?");
		odgovori[7]=new String[] {"A: istoricar","B: glumac","C: vladar","D: sportista"}; //A
		
		pitanja.add("Propan je vrsta?");
		odgovori[8]=new String[] {"A: stakla","B: pamuka","C: gasa","D: kamena"};//C
		
		pitanja.add("Polis je marka?");
		odgovori[9]=new String[] {"A: cigara","B: odece","C: gitare","D: naocara"};//D
		
		dodajAkcije();
		
		
		
		contentPane.add(panelIgra);
		

		
		
		
	}


//akcije za pocetni meni
public void dodajAkcije(){
	
	
	addWindowListener(new WindowAdapter() {
		
	public void  windowClosing(WindowEvent e){
		
		
	int i=JOptionPane.showOptionDialog(getContentPane(), "Izlaz?", "", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE, null, new String[] {"Da","Ne"}, "Da");
	if(i==0)
	  System.exit(0);
	
	
	}	
		
		
	});
	
	
 
	izlazDugme.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
		
		System.exit(0);	
			
		}
		
		
		
		
	});
	
	
	
	startDugme.addActionListener(new ActionListener() {
		
		
		public void actionPerformed(ActionEvent e){
			
			panel.setVisible(false);
			panelIgra.setVisible(true);
			
			suma1.setBackground(new Color(255,165,0));
			suma1.setForeground(Color.black);
			suma2.setForeground(new Color(255,165,0));
			suma2.setBackground(Color.black);
			suma3.setForeground(new Color(255,165,0));
			suma3.setBackground(Color.black);
			suma4.setForeground(new Color(255,165,0));
			suma4.setBackground(Color.black);
			suma5.setForeground(new Color(255,165,0));
			suma5.setBackground(Color.black);
			suma6.setForeground(new Color(255,165,0));
			suma6.setBackground(Color.black);
			suma7.setForeground(new Color(255,165,0));
			suma7.setBackground(Color.black);
			suma8.setForeground(new Color(255,165,0));
			suma8.setBackground(Color.black);
			suma9.setForeground(new Color(255,165,0));
			suma9.setBackground(Color.black);
			suma10.setForeground(new Color(255,165,0));
			suma10.setBackground(Color.black);
			
			pola.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/pola.png")).getImage()));
			publika.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/publika.png")).getImage()));
			prijatelj.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/prijatelj.png")).getImage()));
			
			pola.removeActionListener(akcijaPola);
			publika.removeActionListener(akcijaPublika);
			prijatelj.removeActionListener(akcijaPrijatelj);
			
			odgA.setVisible(true);
			odgB.setVisible(true);
			odgC.setVisible(true);
			odgD.setVisible(true);
			
			
			brPitanja=0;
			brojac=0;
			
			pitanje.setText(pitanja.get(0));
			odgA.setText(odgovori[0][0]);
			odgB.setText(odgovori[0][1]);
			odgC.setText(odgovori[0][2]);
			odgD.setText(odgovori[0][3]);
			
			
			dodajAkcijeIgri();
			
			
		}
		
		
	});
	
	
	
	
	
	
	
	
	
	
}

//akcije za ogovore i pomoc



public void dodajAkcijeIgri(){

	
	
	
	
	
	
	  akcijaA=new ActionListener(){
		
		
		public void actionPerformed(ActionEvent e){
		
		    brPitanja++;
			ko="AT";
			odg='A';
			t.start();
			
			
	    
			
			
			
			}
		
		
	};
	
	
odgA.addActionListener(akcijaA);
	
	





   akcijaB= new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		    
		    brPitanja++;
		    ko="BN";
		    odg='B';
		    t.start();
		
	   }
	   };



	odgB.addActionListener(akcijaB);	
	
	
	
	
	
	
	
	
	akcijaC= new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
		
			brPitanja++;
			ko="CN";
			odg='C';
			t.start();
			
			
			
		}

	};

		odgC.addActionListener(akcijaC);
	
	
	
		
		
		
		
		
	
		akcijaD= new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				brPitanja++;
				ko="DN";
				odg='D';
				t.start();
				
				
			   }
			   };



			odgD.addActionListener(akcijaD);
	
	
			
								
				
			
			
			
			//AKCIJE ZA POMOC 
				 
			akcijaPola=new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
				
					
					switch(brPitanja){
					
					
					case 0:  odgB.setVisible(false); odgD.setVisible(false);
					break;
					case 1:  odgA.setVisible(false); odgB.setVisible(false);
					break;
					case 2:  odgA.setVisible(false); odgC.setVisible(false);
					break;
					case 3:  odgB.setVisible(false); odgC.setVisible(false);
					break;
					case 4:  odgA.setVisible(false); odgB.setVisible(false);
					break;
					case 5:  odgA.setVisible(false); odgD.setVisible(false);
					break;
					case 6:  odgA.setVisible(false); odgB.setVisible(false);
					break;
					case 7:  odgB.setVisible(false); odgC.setVisible(false);
					break;
					case 8:  odgD.setVisible(false); odgA.setVisible(false);
					break;
					case 9:  odgB.setVisible(false); odgA.setVisible(false);
					break;
					}
				     
					pola.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/polaG.png")).getImage()));
					pola.removeActionListener(akcijaPola);
					
					
				}};
			pola.addActionListener(akcijaPola);
			
			akcijaPrijatelj=new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
				
					
					switch(brPitanja){
					
					
					case 0:  JOptionPane.showMessageDialog(getContentPane(), "Prijatelj: A je tacan odgovor!");
					break;
					case 1:  JOptionPane.showMessageDialog(getContentPane(), "Prijatelj: C je tacan odgovor!");
					break;
					case 2:  JOptionPane.showMessageDialog(getContentPane(), "Prijatelj: B je tacan odgovor!");
					break;
					case 3:   JOptionPane.showMessageDialog(getContentPane(), "Prijatelj: A je tacan odgovor!");
					break;
					case 4:  JOptionPane.showMessageDialog(getContentPane(), "Prijatelj: D je tacan odgovor!");
					break;
					case 5:  JOptionPane.showMessageDialog(getContentPane(), "Prijatelj: B je tacan odgovor!");
					break;
					case 6:  JOptionPane.showMessageDialog(getContentPane(), "Prijatelj: C je tacan odgovor!");
					break;
					case 7:  JOptionPane.showMessageDialog(getContentPane(), "Prijatelj: A je tacan odgovor!");
					break;
					case 8:  JOptionPane.showMessageDialog(getContentPane(), "Prijatelj: C je tacan odgovor!");
					break;
					case 9:  JOptionPane.showMessageDialog(getContentPane(), "Prijatelj: D je tacan odgovor!");
					break;
					}
				     
					prijatelj.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/prijateljG.png")).getImage()));
					prijatelj.removeActionListener(akcijaPola);
					
					
				}};
			prijatelj.addActionListener(akcijaPrijatelj);
			
			
			
			akcijaPublika=new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
				
				PomocPublike p=new PomocPublike();
				
				p.postaviRezultat(brPitanja);
				p.setVisible(true);
				publika.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/publikaG.png")).getImage()));
				publika.removeActionListener(akcijaPublika);
				
					
					
				}};
			
			
			publika.addActionListener(akcijaPublika);
			
			
			
			
			
			
			
				 
				 
				 
				 
				 
	//promena odgovora i trepcuca boja
	
	 t=new Timer(500,new ActionListener() {
      
		
	public void actionPerformed(ActionEvent e) {
			
		
		//trepcuca boja
		
		if("AT".equals(ko)) {
		
		  if (dalje) {
				brojac++;
			    dalje=false;
				odgA.setBackground(Color.green);
			}else {
				odgA.setBackground(Color.black);
			    brojac++;
				dalje=true;  
			   }
			
		   
	      }else if("AN".equals(ko)){
	    	  
	    	  
	    	  if (dalje) {
					brojac++;
				    dalje=false;
					odgA.setBackground(Color.RED);
				}else {
					odgA.setBackground(Color.black);
				    brojac++;
					dalje=true;  
				   }
	    	  
	    	  }
		
		
		
	      else if("BT".equals(ko)){
	    	  
	    	    if (dalje) {
					brojac++;
				    dalje=false;
					odgB.setBackground(Color.GREEN);
				}else {
					odgB.setBackground(Color.black);
				    brojac++;
					dalje=true;  
				   }
	    	  }
	      else if("BN".equals(ko)) {
	    	  
	    	  
               if (dalje) {
					brojac++;
				    dalje=false;
					odgB.setBackground(Color.RED);
				}else {
					odgB.setBackground(Color.black);
				    brojac++;
					dalje=true;  
				   }  
	    	      }
		
		
		
	      else if("CT".equals(ko)){
	    	  
	    	  
	    	  if (dalje) {
					brojac++;
				    dalje=false;
					odgC.setBackground(Color.GREEN);
				}else {
					odgC.setBackground(Color.black);
				    brojac++;
					dalje=true;  
				   }  
	    	  
	    	   }
	      else if("CN".equals(ko)){
	    	  
	    	  if (dalje) {
					brojac++;
				    dalje=false;
					odgC.setBackground(Color.RED);
				}else {
					odgC.setBackground(Color.black);
				    brojac++;
					dalje=true;  
				   }  
	    	      }
		
		
		
	      else if("DT".equals(ko)){
	    	  
	    	  if (dalje) {
					brojac++;
				    dalje=false;
					odgD.setBackground(Color.GREEN);
				}else {
					odgD.setBackground(Color.black);
				    brojac++;
					dalje=true;  
				   }  
	    	     }
	      else if("DN".equals(ko)){
	    	  
	    	  if (dalje) {
					brojac++;
				    dalje=false;
					odgD.setBackground(Color.RED);
				}else {
					odgD.setBackground(Color.black);
				    brojac++;
					dalje=true;  
				   }  
	    	   }
		
		
		
		
		
		
			
			//promene odgovora i pitanja
			
			if(brojac==4) {
			 
			brojac=0;
			
				//prvo pitanje KADA SE PRITISNJE NA NJEGA
			
			if(brPitanja==1){
				
				
				//tacno
			 if(odg=='A') {
				 
			 odgA.removeActionListener(akcijaA);  
			 odgB.removeActionListener(akcijaB);
			 odgC.removeActionListener(akcijaC);
			 odgD.removeActionListener(akcijaD);	 
				 
			 odgA.setVisible(true);
			 odgB.setVisible(true);
			 odgC.setVisible(true);
			 odgD.setVisible(true);
			 
			 
			 pitanje.setText(pitanja.get(1));
			 odgA.setText(odgovori[1][0]);
			 odgB.setText(odgovori[1][1]);
			 odgC.setText(odgovori[1][2]);
			 odgD.setText(odgovori[1][3]);
			 
			 suma1.setForeground(new Color(255,165,0));
			 suma1.setBackground(Color.black);
			 suma2.setBackground(new Color(255,165,0));
			 suma2.setForeground(Color.black);
			 
		

			  akcijaA=new ActionListener(){
				
				
				public void actionPerformed(ActionEvent e){
				
				    brPitanja++;
					ko="AN";
					odg='A';
					t.start();
				    }};
			  odgA.addActionListener(akcijaA);
			    
			 

			  akcijaB=new ActionListener(){
				
				
				public void actionPerformed(ActionEvent e){
				
				    brPitanja++;
					ko="BN";
					odg='B';
					t.start();
					
				}};
			odgB.addActionListener(akcijaB);
			 
			  
			  
             akcijaC=new ActionListener(){
			 
             public void actionPerformed(ActionEvent e){
				
				    brPitanja++;
					ko="CT";
					odg='C';
					t.start();
					
				}};
			odgC.addActionListener(akcijaC);
			  
			  
			  
                 akcijaD=new ActionListener(){
				
				
				public void actionPerformed(ActionEvent e){
				
				    brPitanja++;
					ko="DN";
					odg='D';
					t.start();
					
				}};
			odgD.addActionListener(akcijaD); 
			  
			 
				 
				 
			 }	
			 else if(odg=='B') {   
			 
			JOptionPane.showMessageDialog(getContentPane(), "Izgubili ste :("); 
			odgA.removeActionListener(akcijaA);  
			odgB.removeActionListener(akcijaB);
			odgC.removeActionListener(akcijaC);
			odgD.removeActionListener(akcijaD);
			panelIgra.setVisible(false);panel.setVisible(true);
			}	
			
			 
			 
			 else if(odg=='C') {  
				 
		    JOptionPane.showMessageDialog(getContentPane(), "Izgubili ste :("); 
		    odgA.removeActionListener(akcijaA);  
			odgB.removeActionListener(akcijaB);
			odgC.removeActionListener(akcijaC);
			odgD.removeActionListener(akcijaD);
			panelIgra.setVisible(false);panel.setVisible(true);
			} 
				 
			 		
			 else if(odg=='D') {  
				 
		     JOptionPane.showMessageDialog(getContentPane(), "Izgubili ste :("); 
			 odgA.removeActionListener(akcijaA);  
			 odgB.removeActionListener(akcijaB);
			 odgC.removeActionListener(akcijaC);
			 odgD.removeActionListener(akcijaD);
			 panelIgra.setVisible(false);panel.setVisible(true);		 
				 
				 
				 
			 }	
			 
			 }
			
			
			
			
			else if(brPitanja==2){
				
			//tacno
			if(odg=='C'){
				
				 odgA.removeActionListener(akcijaA);  
				 odgB.removeActionListener(akcijaB);
				 odgC.removeActionListener(akcijaC);
				 odgD.removeActionListener(akcijaD);	 
					 
				 odgA.setVisible(true);
				 odgB.setVisible(true);
				 odgC.setVisible(true);
				 odgD.setVisible(true);
				 
				 
				 pitanje.setText(pitanja.get(2));
				 odgA.setText(odgovori[2][0]);
				 odgB.setText(odgovori[2][1]);
				 odgC.setText(odgovori[2][2]);
				 odgD.setText(odgovori[2][3]);
				 
				 suma2.setForeground(new Color(255,165,0));
				 suma2.setBackground(Color.black);
				 suma3.setBackground(new Color(255,165,0));
				 suma3.setForeground(Color.black);
				
				

				  akcijaA=new ActionListener(){
					
					
					public void actionPerformed(ActionEvent e){
					
					    brPitanja++;
						ko="AN";
						odg='A';
						t.start();
					    }};
				  odgA.addActionListener(akcijaA);
				    
				 

				  akcijaB=new ActionListener(){
					
					
					public void actionPerformed(ActionEvent e){
					
					    brPitanja++;
						ko="BT";
						odg='B';
						t.start();
						
					}};
				odgB.addActionListener(akcijaB);
				 
				  
				  
	             akcijaC=new ActionListener(){
				 
	             public void actionPerformed(ActionEvent e){
					
					    brPitanja++;
						ko="CN";
						odg='C';
						t.start();
						
					}};
				odgC.addActionListener(akcijaC);
				  
				  
				  
	                 akcijaD=new ActionListener(){
					
					
					public void actionPerformed(ActionEvent e){
					
					    brPitanja++;
						ko="DN";
						odg='D';
						t.start();
						
					}};
				odgD.addActionListener(akcijaD); 
				  
				 
				}
			else if(odg=='A'){
				
				     JOptionPane.showMessageDialog(getContentPane(), "Izgubili ste :("); 
					 odgA.removeActionListener(akcijaA);  
					 odgB.removeActionListener(akcijaB);
					 odgC.removeActionListener(akcijaC);
					 odgD.removeActionListener(akcijaD);
					 panelIgra.setVisible(false);panel.setVisible(true);
				
				
				
			}
			else if(odg=='B'){
				
				     JOptionPane.showMessageDialog(getContentPane(), "Izgubili ste :("); 
					 odgA.removeActionListener(akcijaA);  
					 odgB.removeActionListener(akcijaB);
					 odgC.removeActionListener(akcijaC);
					 odgD.removeActionListener(akcijaD);
					 panelIgra.setVisible(false);panel.setVisible(true);
				
			}
			else if(odg=='D'){
			       	
				     JOptionPane.showMessageDialog(getContentPane(), "Izgubili ste :("); 
					 odgA.removeActionListener(akcijaA);  
					 odgB.removeActionListener(akcijaB);
					 odgC.removeActionListener(akcijaC);
					 odgD.removeActionListener(akcijaD);
					 panelIgra.setVisible(false);panel.setVisible(true); 
           				
				 }
				
				
			     }
			
			else if(brPitanja==3){
				
				
				if(odg=='B'){
					
					
					 odgA.removeActionListener(akcijaA);  
					 odgB.removeActionListener(akcijaB);
					 odgC.removeActionListener(akcijaC);
					 odgD.removeActionListener(akcijaD);	 
						 
					 odgA.setVisible(true);
					 odgB.setVisible(true);
					 odgC.setVisible(true);
					 odgD.setVisible(true);
					 
					 
					 pitanje.setText(pitanja.get(3));
					 odgA.setText(odgovori[3][0]);
					 odgB.setText(odgovori[3][1]);
					 odgC.setText(odgovori[3][2]);
					 odgD.setText(odgovori[3][3]);
					 
					 suma3.setForeground(new Color(255,165,0));
					 suma3.setBackground(Color.black);
					 suma4.setBackground(new Color(255,165,0));
					 suma4.setForeground(Color.black);
						
					

					  akcijaA=new ActionListener(){
						
						
						public void actionPerformed(ActionEvent e){
						
						    brPitanja++;
							ko="AT";
							odg='A';
							t.start();
						    }};
					  odgA.addActionListener(akcijaA);
					    
					 

					  akcijaB=new ActionListener(){
						
						
						public void actionPerformed(ActionEvent e){
						
						    brPitanja++;
							ko="BN";
							odg='B';
							t.start();
							
						}};
					odgB.addActionListener(akcijaB);
					 
					  
					  
		             akcijaC=new ActionListener(){
					 
		             public void actionPerformed(ActionEvent e){
						
						    brPitanja++;
							ko="CN";
							odg='C';
							t.start();
							
						}};
					odgC.addActionListener(akcijaC);
					  
					  
					  
		                 akcijaD=new ActionListener(){
						
						
						public void actionPerformed(ActionEvent e){
						
						    brPitanja++;
							ko="DN";
							odg='D';
							t.start();
							
						}};
					odgD.addActionListener(akcijaD); 
					  
					
					
					
				}
				
				else if(odg=='A'){
					
					
					JOptionPane.showMessageDialog(getContentPane(), "Izgubili ste :("); 
				    odgA.removeActionListener(akcijaA);  
					odgB.removeActionListener(akcijaB);
					odgC.removeActionListener(akcijaC);
					odgD.removeActionListener(akcijaD);
					panelIgra.setVisible(false);panel.setVisible(true);
					
				}
				else if(odg=='C') {
					
					JOptionPane.showMessageDialog(getContentPane(), "Izgubili ste :("); 
				    odgA.removeActionListener(akcijaA);  
					odgB.removeActionListener(akcijaB);
					odgC.removeActionListener(akcijaC);
					odgD.removeActionListener(akcijaD);
					panelIgra.setVisible(false);panel.setVisible(true);
					
					
				}
				else if(odg=='D'){
					
					JOptionPane.showMessageDialog(getContentPane(), "Izgubili ste :("); 
				    odgA.removeActionListener(akcijaA);  
					odgB.removeActionListener(akcijaB);
					odgC.removeActionListener(akcijaC);
					odgD.removeActionListener(akcijaD);
					panelIgra.setVisible(false);panel.setVisible(true);
					
					
					
					
				}
				
				
				
				
			}
			
			else if(brPitanja==4){
				
				if(odg=='A'){
					
					 odgA.removeActionListener(akcijaA);  
					 odgB.removeActionListener(akcijaB);
					 odgC.removeActionListener(akcijaC);
					 odgD.removeActionListener(akcijaD);	 
						 
					 odgA.setVisible(true);
					 odgB.setVisible(true);
					 odgC.setVisible(true);
					 odgD.setVisible(true);
					 
					 
					 pitanje.setText(pitanja.get(4));
					 odgA.setText(odgovori[4][0]);
					 odgB.setText(odgovori[4][1]);
					 odgC.setText(odgovori[4][2]);
					 odgD.setText(odgovori[4][3]);
					 
					 suma4.setForeground(new Color(255,165,0));
					 suma4.setBackground(Color.black);
					 suma5.setBackground(new Color(255,165,0));
					 suma5.setForeground(Color.black);	
					
					     akcijaA=new ActionListener(){
							
							
							public void actionPerformed(ActionEvent e){
							
							    brPitanja++;
								ko="AN";
								odg='A';
								t.start();
							    }};
						  odgA.addActionListener(akcijaA);
					
						   akcijaB=new ActionListener(){
								
								
								public void actionPerformed(ActionEvent e){
								
								    brPitanja++;
									ko="BN";
									odg='B';
									t.start();
								    }};
							  odgB.addActionListener(akcijaB);
				         
							  akcijaC=new ActionListener(){
									
									
									public void actionPerformed(ActionEvent e){
									
									    brPitanja++;
										ko="CN";
										odg='C';
										t.start();
									    }};
								  odgC.addActionListener(akcijaC);
				
								  akcijaD=new ActionListener(){
										
										
										public void actionPerformed(ActionEvent e){
										
										    brPitanja++;
											ko="DT";
											odg='D';
											t.start();
										    }};
									  odgD.addActionListener(akcijaD);
				
				}
				else if (odg=='B'){
					
					
					JOptionPane.showMessageDialog(getContentPane(), "Izgubili ste :("); 
				    odgA.removeActionListener(akcijaA);  
					odgB.removeActionListener(akcijaB);
					odgC.removeActionListener(akcijaC);
					odgD.removeActionListener(akcijaD);
					panelIgra.setVisible(false);panel.setVisible(true);
					
					
					
				}
				
				else if(odg=='C') {
					
					JOptionPane.showMessageDialog(getContentPane(), "Izgubili ste :("); 
				    odgA.removeActionListener(akcijaA);  
					odgB.removeActionListener(akcijaB);
					odgC.removeActionListener(akcijaC);
					odgD.removeActionListener(akcijaD);
					panelIgra.setVisible(false);panel.setVisible(true);
					
					
				}
				
				else if(odg=='D'){
					
					JOptionPane.showMessageDialog(getContentPane(), "Izgubili ste :("); 
				    odgA.removeActionListener(akcijaA);  
					odgB.removeActionListener(akcijaB);
					odgC.removeActionListener(akcijaC);
					odgD.removeActionListener(akcijaD);
					panelIgra.setVisible(false);panel.setVisible(true);
					
					
					
				}
			}
				else if(brPitanja==5){
					
					
					if(odg=='D'){
						

						 odgA.removeActionListener(akcijaA);  
						 odgB.removeActionListener(akcijaB);
						 odgC.removeActionListener(akcijaC);
						 odgD.removeActionListener(akcijaD);	 
							 
						 odgA.setVisible(true);
						 odgB.setVisible(true);
						 odgC.setVisible(true);
						 odgD.setVisible(true);
						 
						 
						 pitanje.setText(pitanja.get(5));
						 odgA.setText(odgovori[5][0]);
						 odgB.setText(odgovori[5][1]);
						 odgC.setText(odgovori[5][2]);
						 odgD.setText(odgovori[5][3]);
						 
						 suma5.setForeground(new Color(255,165,0));
						 suma5.setBackground(Color.black);
						 suma6.setBackground(new Color(255,165,0));
						 suma6.setForeground(Color.black);
						
						 
						 
						 akcijaA=new ActionListener(){
								
								
								public void actionPerformed(ActionEvent e){
								
								    brPitanja++;
									ko="AN";
									odg='A';
									t.start();
								    }};
							  odgA.addActionListener(akcijaA);
						
							   akcijaB=new ActionListener(){
									
									
									public void actionPerformed(ActionEvent e){
									
									    brPitanja++;
										ko="BT";
										odg='B';
										t.start();
									    }};
								  odgB.addActionListener(akcijaB);
					         
								  akcijaC=new ActionListener(){
										
										
										public void actionPerformed(ActionEvent e){
										
										    brPitanja++;
											ko="CN";
											odg='C';
											t.start();
										    }};
									  odgC.addActionListener(akcijaC);
					
									  akcijaD=new ActionListener(){
											
											
											public void actionPerformed(ActionEvent e){
											
											    brPitanja++;
												ko="DN";
												odg='D';
												t.start();
											    }};
										  odgD.addActionListener(akcijaD);
					
						
						
					}
					else if(odg=='A'){
						
						
						JOptionPane.showMessageDialog(getContentPane(), "Izgubili ste :("); 
					    odgA.removeActionListener(akcijaA);  
						odgB.removeActionListener(akcijaB);
						odgC.removeActionListener(akcijaC);
						odgD.removeActionListener(akcijaD);
						panelIgra.setVisible(false);panel.setVisible(true);
						
					}
					else if(odg=='B'){
						
						JOptionPane.showMessageDialog(getContentPane(), "Izgubili ste :("); 
					    odgA.removeActionListener(akcijaA);  
						odgB.removeActionListener(akcijaB);
						odgC.removeActionListener(akcijaC);
						odgD.removeActionListener(akcijaD);
						panelIgra.setVisible(false);panel.setVisible(true);
						
						
					}
					else if(odg=='C'){
						
						JOptionPane.showMessageDialog(getContentPane(), "Izgubili ste :("); 
					    odgA.removeActionListener(akcijaA);  
						odgB.removeActionListener(akcijaB);
						odgC.removeActionListener(akcijaC);
						odgD.removeActionListener(akcijaD);
						panelIgra.setVisible(false);panel.setVisible(true);
						
					}
					
				}
			
			    else if(brPitanja==6){
			    	
			    	if(odg=='B'){
			    		

						 odgA.removeActionListener(akcijaA);  
						 odgB.removeActionListener(akcijaB);
						 odgC.removeActionListener(akcijaC);
						 odgD.removeActionListener(akcijaD);	 
							 
						 odgA.setVisible(true);
						 odgB.setVisible(true);
						 odgC.setVisible(true);
						 odgD.setVisible(true);
						 
						 
						 pitanje.setText(pitanja.get(6));
						 odgA.setText(odgovori[6][0]);
						 odgB.setText(odgovori[6][1]);
						 odgC.setText(odgovori[6][2]);
						 odgD.setText(odgovori[6][3]);
						 
						 suma6.setForeground(new Color(255,165,0));
						 suma6.setBackground(Color.black);
						 suma7.setBackground(new Color(255,165,0));
						 suma7.setForeground(Color.black);
			    		
						 
						 akcijaA=new ActionListener(){
								
								
								public void actionPerformed(ActionEvent e){
								
								    brPitanja++;
									ko="AN";
									odg='A';
									t.start();
								    }};
							  odgA.addActionListener(akcijaA);
						
							   akcijaB=new ActionListener(){
									
									
									public void actionPerformed(ActionEvent e){
									
									    brPitanja++;
										ko="BN";
										odg='B';
										t.start();
									    }};
								  odgB.addActionListener(akcijaB);
					         
								  akcijaC=new ActionListener(){
										
										
										public void actionPerformed(ActionEvent e){
										
										    brPitanja++;
											ko="CT";
											odg='C';
											t.start();
										    }};
									  odgC.addActionListener(akcijaC);
					
									  akcijaD=new ActionListener(){
											
											
											public void actionPerformed(ActionEvent e){
											
											    brPitanja++;
												ko="DN";
												odg='D';
												t.start();
											    }};
										  odgD.addActionListener(akcijaD);
					
			    		
						 
			    		
			    	}
			    	else if(odg=='A'){
			    		
			    		JOptionPane.showMessageDialog(getContentPane(), "Izgubili ste :("); 
					    odgA.removeActionListener(akcijaA);  
						odgB.removeActionListener(akcijaB);
						odgC.removeActionListener(akcijaC);
						odgD.removeActionListener(akcijaD);
						panelIgra.setVisible(false);panel.setVisible(true);
			    		
			    		
			    	}
			    	else if(odg=='C'){
			    		
			    		JOptionPane.showMessageDialog(getContentPane(), "Izgubili ste :("); 
					    odgA.removeActionListener(akcijaA);  
						odgB.removeActionListener(akcijaB);
						odgC.removeActionListener(akcijaC);
						odgD.removeActionListener(akcijaD);
						panelIgra.setVisible(false);panel.setVisible(true);
			    		
			    		
			    	}
			    	else if(odg=='D'){
			    		
			    		JOptionPane.showMessageDialog(getContentPane(), "Izgubili ste :("); 
					    odgA.removeActionListener(akcijaA);  
						odgB.removeActionListener(akcijaB);
						odgC.removeActionListener(akcijaC);
						odgD.removeActionListener(akcijaD);
						panelIgra.setVisible(false);panel.setVisible(true);
			    		
			    	}
			    	
			    }
			
			    else if(brPitanja==7){
			    	
			    	if(odg=='C'){
			    		
			    		 odgA.removeActionListener(akcijaA);  
						 odgB.removeActionListener(akcijaB);
						 odgC.removeActionListener(akcijaC);
						 odgD.removeActionListener(akcijaD);	 
							 
						 odgA.setVisible(true);
						 odgB.setVisible(true);
						 odgC.setVisible(true);
						 odgD.setVisible(true);
						 
						 
						 pitanje.setText(pitanja.get(7));
						 odgA.setText(odgovori[7][0]);
						 odgB.setText(odgovori[7][1]);
						 odgC.setText(odgovori[7][2]);
						 odgD.setText(odgovori[7][3]);
						 
						 suma7.setForeground(new Color(255,165,0));
						 suma7.setBackground(Color.black);
						 suma8.setBackground(new Color(255,165,0));
						 suma8.setForeground(Color.black);
			    		
						 
						 
						 akcijaA=new ActionListener(){
								
								
								public void actionPerformed(ActionEvent e){
								
								    brPitanja++;
									ko="AT";
									odg='A';
									t.start();
								    }};
							  odgA.addActionListener(akcijaA);
						
							   akcijaB=new ActionListener(){
									
									
									public void actionPerformed(ActionEvent e){
									
									    brPitanja++;
										ko="BN";
										odg='B';
										t.start();
									    }};
								  odgB.addActionListener(akcijaB);
					         
								  akcijaC=new ActionListener(){
										
										
										public void actionPerformed(ActionEvent e){
										
										    brPitanja++;
											ko="CN";
											odg='C';
											t.start();
										    }};
									  odgC.addActionListener(akcijaC);
					
									  akcijaD=new ActionListener(){
											
											
											public void actionPerformed(ActionEvent e){
											
											    brPitanja++;
												ko="DN";
												odg='D';
												t.start();
											    }};
										  odgD.addActionListener(akcijaD);
					
						 
						 
						 
						 
			    		
			    		
			    	}
			    	else if(odg=='A'){
			    		
			    		JOptionPane.showMessageDialog(getContentPane(), "Izgubili ste :("); 
					    odgA.removeActionListener(akcijaA);  
						odgB.removeActionListener(akcijaB);
						odgC.removeActionListener(akcijaC);
						odgD.removeActionListener(akcijaD);
						panelIgra.setVisible(false);panel.setVisible(true);
			    		
			    	}
			    	else if(odg=='B'){
			    		
			    		JOptionPane.showMessageDialog(getContentPane(), "Izgubili ste :("); 
					    odgA.removeActionListener(akcijaA);  
						odgB.removeActionListener(akcijaB);
						odgC.removeActionListener(akcijaC);
						odgD.removeActionListener(akcijaD);
						panelIgra.setVisible(false);panel.setVisible(true);
			    		
			    		
			    	}
			    	
			    	else if (odg=='D'){
			    		
			    		JOptionPane.showMessageDialog(getContentPane(), "Izgubili ste :("); 
					    odgA.removeActionListener(akcijaA);  
						odgB.removeActionListener(akcijaB);
						odgC.removeActionListener(akcijaC);
						odgD.removeActionListener(akcijaD);
						panelIgra.setVisible(false);panel.setVisible(true);	
			    		
			    	}
			    }
			
			    else if(brPitanja==8){
			    	
			    	if(odg=='A'){
			    		
			    		 odgA.removeActionListener(akcijaA);  
						 odgB.removeActionListener(akcijaB);
						 odgC.removeActionListener(akcijaC);
						 odgD.removeActionListener(akcijaD);	 
							 
						 odgA.setVisible(true);
						 odgB.setVisible(true);
						 odgC.setVisible(true);
						 odgD.setVisible(true);
						 
						 
						 pitanje.setText(pitanja.get(8));
						 odgA.setText(odgovori[8][0]);
						 odgB.setText(odgovori[8][1]);
						 odgC.setText(odgovori[8][2]);
						 odgD.setText(odgovori[8][3]);
						 
						 suma8.setForeground(new Color(255,165,0));
						 suma8.setBackground(Color.black);
						 suma9.setBackground(new Color(255,165,0));
						 suma9.setForeground(Color.black);
			    		
			    	

						   akcijaA=new ActionListener(){
								
								
								public void actionPerformed(ActionEvent e){
								
								    brPitanja++;
									ko="AN";
									odg='A';
									t.start();
								    }};
							  odgA.addActionListener(akcijaA);
						
							
						   akcijaB=new ActionListener(){
								
								
								public void actionPerformed(ActionEvent e){
								
								    brPitanja++;
									ko="BN";
									odg='B';
									t.start();
								    }};
							  odgB.addActionListener(akcijaB);
				         
							  akcijaC=new ActionListener(){
									
									
									public void actionPerformed(ActionEvent e){
									
									    brPitanja++;
										ko="CT";
										odg='C';
										t.start();
									    }};
								  odgC.addActionListener(akcijaC);
				
								  akcijaD=new ActionListener(){
										
										
										public void actionPerformed(ActionEvent e){
										
										    brPitanja++;
											ko="DN";
											odg='D';
											t.start();
										    }};
									  odgD.addActionListener(akcijaD);
				
						 
						 
						 
						 
			    	}
			    	else if(odg=='B'){
			    		
			    		JOptionPane.showMessageDialog(getContentPane(), "Izgubili ste :("); 
					    odgA.removeActionListener(akcijaA);  
						odgB.removeActionListener(akcijaB);
						odgC.removeActionListener(akcijaC);
						odgD.removeActionListener(akcijaD);
						panelIgra.setVisible(false);panel.setVisible(true);	
			    		
			    		
			    	}
			    	else if(odg=='C'){
			    		
			    		JOptionPane.showMessageDialog(getContentPane(), "Izgubili ste :("); 
					    odgA.removeActionListener(akcijaA);  
						odgB.removeActionListener(akcijaB);
						odgC.removeActionListener(akcijaC);
						odgD.removeActionListener(akcijaD);
						panelIgra.setVisible(false);panel.setVisible(true);	
			    		
			    		
			    	}
			    	
			    	else if(odg=='D'){
			    		JOptionPane.showMessageDialog(getContentPane(), "Izgubili ste :("); 
					    odgA.removeActionListener(akcijaA);  
						odgB.removeActionListener(akcijaB);
						odgC.removeActionListener(akcijaC);
						odgD.removeActionListener(akcijaD);
						panelIgra.setVisible(false);panel.setVisible(true);	
			    		
			    	}
			    	
			    }
			
			    else if(brPitanja==9){
			    	
			    	if(odg=='C'){
			    		
			    		odgA.removeActionListener(akcijaA);  
						 odgB.removeActionListener(akcijaB);
						 odgC.removeActionListener(akcijaC);
						 odgD.removeActionListener(akcijaD);	 
							 
						 odgA.setVisible(true);
						 odgB.setVisible(true);
						 odgC.setVisible(true);
						 odgD.setVisible(true);
						 
						 
						 pitanje.setText(pitanja.get(9));
						 odgA.setText(odgovori[9][0]);
						 odgB.setText(odgovori[9][1]);
						 odgC.setText(odgovori[9][2]);
						 odgD.setText(odgovori[9][3]);
						 
						 suma9.setForeground(new Color(255,165,0));
						 suma9.setBackground(Color.black);
						 suma10.setBackground(new Color(255,165,0));
						 suma10.setForeground(Color.black);
			    		
						 akcijaA=new ActionListener(){
								
								
								public void actionPerformed(ActionEvent e){
								
								    brPitanja++;
									ko="AN";
									odg='A';
									t.start();
								    }};
							  odgA.addActionListener(akcijaA);
						
							
						   akcijaB=new ActionListener(){
								
								
								public void actionPerformed(ActionEvent e){
								
								    brPitanja++;
									ko="BN";
									odg='B';
									t.start();
								    }};
							  odgB.addActionListener(akcijaB);
				         
							  akcijaC=new ActionListener(){
									
									
									public void actionPerformed(ActionEvent e){
									
									    brPitanja++;
										ko="CN";
										odg='C';
										t.start();
									    }};
								  odgC.addActionListener(akcijaC);
				
								  akcijaD=new ActionListener(){
										
										
										public void actionPerformed(ActionEvent e){
										
										    brPitanja++;
											ko="DT";
											odg='D';
											t.start();
										    }};
									  odgD.addActionListener(akcijaD);
				
						 
			    		
			    	}
			    	else if(odg=='A') {
			    		JOptionPane.showMessageDialog(getContentPane(), "Izgubili ste :("); 
					    odgA.removeActionListener(akcijaA);  
						odgB.removeActionListener(akcijaB);
						odgC.removeActionListener(akcijaC);
						odgD.removeActionListener(akcijaD);
						panelIgra.setVisible(false);panel.setVisible(true);	
			    		
			    	}
			    	else if(odg=='B'){
			    		JOptionPane.showMessageDialog(getContentPane(), "Izgubili ste :("); 
					    odgA.removeActionListener(akcijaA);  
						odgB.removeActionListener(akcijaB);
						odgC.removeActionListener(akcijaC);
						odgD.removeActionListener(akcijaD);
						panelIgra.setVisible(false);panel.setVisible(true);	
			    		
			    	}	
			    	else if(odg=='D'){
			    		
			    		JOptionPane.showMessageDialog(getContentPane(), "Izgubili ste :("); 
					    odgA.removeActionListener(akcijaA);  
						odgB.removeActionListener(akcijaB);
						odgC.removeActionListener(akcijaC);
						odgD.removeActionListener(akcijaD);
						panelIgra.setVisible(false);panel.setVisible(true);	
			    		
			    		
			    	}
			    	
			    }
			    else if(brPitanja==10){
			    	
			    	if(odg=='D'){
			    		
			    		
			    		
			    		JOptionPane.showMessageDialog(getContentPane(),"Postali ste milioner!!!! :)");
			    		
			    		odgA.removeActionListener(akcijaA);  
						odgB.removeActionListener(akcijaB);
						odgC.removeActionListener(akcijaC);
						odgD.removeActionListener(akcijaD);
						panelIgra.setVisible(false);panel.setVisible(true);	
						
						
			    		
			    	}
			    	else if(odg=='A'){
			    		
			    		JOptionPane.showMessageDialog(getContentPane(), "Izgubili ste :("); 
					    odgA.removeActionListener(akcijaA);  
						odgB.removeActionListener(akcijaB);
						odgC.removeActionListener(akcijaC);
						odgD.removeActionListener(akcijaD);
						panelIgra.setVisible(false);panel.setVisible(true);	
			    		
			    		
			    	}
			    else if(odg=='B') {
			    	    
			    	JOptionPane.showMessageDialog(getContentPane(), "Izgubili ste :("); 
				    odgA.removeActionListener(akcijaA);  
					odgB.removeActionListener(akcijaB);
					odgC.removeActionListener(akcijaC);
					odgD.removeActionListener(akcijaD);
					panelIgra.setVisible(false);panel.setVisible(true);	
			    	
			    	
			    }	
			    else if(odg=='C'){
			    	JOptionPane.showMessageDialog(getContentPane(), "Izgubili ste :("); 
				    odgA.removeActionListener(akcijaA);  
					odgB.removeActionListener(akcijaB);
					odgC.removeActionListener(akcijaC);
					odgD.removeActionListener(akcijaD);
					panelIgra.setVisible(false);panel.setVisible(true);	
			    	
			    	
			    }	
			    	
			    }
			   
			    t.stop();
		     
		   }
			
			
		}});
	
	
}



}
