package pacman;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class Igra {

//meni	
JFrame okvir;	
JPanel pocetniPanel;	
JButton start;
JButton rezultat;
JButton izlaz;
JButton utovar;
JButton nzm;
JLabel pozadinaMeni;
//

//igra

int koordinate[][];
JLabel slike[][];
JPanel igraPanel;
JLabel pozadinaIgre;
String imeIgraca;

StringBuffer bufer=new StringBuffer();


//pocetne koordinate pakmena
int px=1;
int py=1;
//pocetne koordinate fantoma

int fx1=13;
int fy1=13;

int fx2=13;
int fy2=1;

int fx3=1;
int fy3=13;


int bodovi;
JLabel ime;
JLabel poeni;

Timer timer;


// rezultatiiiiii
JPanel rezultatiPanel=new JPanel();
JTextArea rezultati=new JTextArea();
JScrollPane skrol=new JScrollPane();

JButton nazad=new JButton("<-nazad");



Igra(){
	
	okvir=new JFrame("Pacman");
	okvir.setSize(700,700);
	okvir.setLocationRelativeTo(null);
	okvir.setLayout(null);
	okvir.setResizable(false);
	okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	pocetniPanel=new JPanel();
	pocetniPanel.setBounds(0, 0, okvir.getWidth(), okvir.getHeight());
	pocetniPanel.setLayout(null);
	
	pozadinaMeni=new JLabel();
	pozadinaMeni.setBounds(0, 0,okvir.getWidth(), okvir.getHeight());
    pozadinaMeni.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/pacman.png")).getImage()));
    pocetniPanel.add(pozadinaMeni);

    start=new JButton("Start");
    start.setBounds(okvir.getWidth()-150,20,120,40);
    pocetniPanel.add(start,0);
    
    rezultat=new JButton("Rezultat");
    rezultat.setBounds(okvir.getWidth()-150,70,120,40);
    pocetniPanel.add(rezultat,0);
   
    izlaz=new JButton("Izlaz");
    izlaz.setBounds(okvir.getWidth()-150,120,120,40);
    pocetniPanel.add(izlaz,0);
    dodajAkcijeMeni(); 
    dodajKretanjePakmenu();
    
    okvir.add(pocetniPanel,0);
  //panel igre
    
    
    
    igraPanel=new JPanel();
    igraPanel.setBounds(0,0,okvir.getWidth(),okvir.getHeight());
	igraPanel.setLayout(null);
    igraPanel.setVisible(false);
	
	pozadinaIgre=new JLabel();
	pozadinaIgre.setBounds(0,0,okvir.getWidth(),okvir.getHeight());
	pozadinaIgre.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/pacman.png")).getImage()));
	
	 ime=new JLabel();
     poeni=new JLabel();
    
    igraPanel.add(pozadinaIgre);
    igraPanel.add(ime,0);
    igraPanel.add(poeni,0);
    
    
    
    
    
    okvir.add(igraPanel);  
    
    
    
    //panel rezultata
    
    
    rezultatiPanel.setLayout(null);
    rezultatiPanel.setBounds(0,0,okvir.getWidth(),okvir.getHeight());
    rezultatiPanel.setVisible(false);
    
    skrol.setBounds(0,0,okvir.getWidth()-150,okvir.getHeight());  
    
    
     rezultati.setBounds(0, 0, skrol.getWidth(),skrol.getHeight());
     rezultati.setFont(new Font("Arial",Font.BOLD,30));
     
     
     nazad.setBounds(okvir.getWidth()-110,20,80,30);
     
     
     
     skrol.add(rezultati,0);
     rezultatiPanel.add(skrol);
     rezultatiPanel.add(nazad);
     
     okvir.add(rezultatiPanel);
     
     okvir.setVisible(true);
    
    
    
    
}









// akcije za dugmice(meni)


public void dodajAkcijeMeni(){
	
	start.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
             
			
			imeIgraca=JOptionPane.showInputDialog("Igrac(vase ime)","ime");
			
			while(imeIgraca==null || imeIgraca.equals("") || imeIgraca.equals("ime")){
				
				imeIgraca=JOptionPane.showInputDialog("Igrac:(vase ime)","ime");
				
			};
            
			
			 
             bodovi=0;
		    napraviMapu();
		     
		     px=1;
		     py=1;
		     
		     fx1=13;
		     fy1=13;

		     fx2=13;
		     fy2=1;
		     
		     fx3=1;
		     fy3=13;
			
		    koordinate[px][py]=3;
		    koordinate[fx1][fy1]=5;
			koordinate[fx2][fy2]=5;
		    koordinate[fx3][fy3]=5;
			prikaziIgru();
			timer.start();
		}});
	
	
	
	
	
	rezultat.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		  
			igraPanel.setVisible(false);
			pocetniPanel.setVisible(false);
			rezultatiPanel.setVisible(true);
			
			
			
			
		}});

	
	
	
	izlaz.addActionListener(new ActionListener() {

		
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
			
		}});

nazad.addActionListener(new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		rezultatiPanel.setVisible(false);
		pocetniPanel.setVisible(true);
		
	} 
	
	
	
});



}








// pravljenje mape
public void napraviMapu(){
	
	koordinate=new int [] []{
		{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
		{2,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
		{2,1,1,1,1,2,1,1,1,1,1,2,1,1,2},
		{2,1,1,1,1,2,1,1,1,1,1,2,1,1,2},
		{2,1,1,1,1,2,1,1,1,1,1,2,1,1,2},
		{2,1,1,1,1,1,1,1,1,1,1,2,1,1,2},//5
		{2,2,2,2,1,1,1,1,2,2,2,2,1,1,2},
		{2,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
		{2,1,1,1,1,1,1,1,2,2,2,1,1,1,2},
		{2,1,1,1,2,1,1,1,2,1,2,1,1,1,2},
		{2,1,1,1,2,1,2,2,2,1,2,1,1,1,2},
		{2,1,1,1,2,1,1,1,1,1,1,1,1,1,2},
		{2,1,1,1,2,2,2,2,1,1,1,1,1,1,2},
		{2,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
		{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
		
		
	};
	
	
	slike=new JLabel[koordinate.length][koordinate[0].length];
	
	for(int i=0;i<slike.length;i++)
	for(int j=0;j<slike[i].length;j++)
		slike[i][j]=new JLabel();
	


     





}








public void prikaziIgru(){
	
	
	pocetniPanel.setVisible(false); 
	
	ime.setText("Igrac: "+imeIgraca);
	ime.setFont(new Font("Arial",Font.BOLD,25));
	ime.setForeground(Color.white);
	ime.setBounds(5, 5,200,30);
	
	poeni.setText("Poeni: "+bodovi);
	poeni.setFont(new Font("Arial",Font.BOLD,25));
	poeni.setForeground(Color.white);
	poeni.setBounds(okvir.getWidth()-150, 5,200,30);
	
	for(int i=0;i<koordinate.length;i++){
	for(int j=0;j<koordinate[i].length;j++){
		
		slike[i][j].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/"+koordinate[i][j]+".png")).getImage()));
		slike[i][j].setBounds(50+(j*40),50+(i*40),40,40);
		igraPanel.add(slike[i][j],0);
	
	}	
		
	}
	igraPanel.setVisible(true);
	
}









//kretanje pakmena

public void  dodajKretanjePakmenu(){
	
	
	  okvir.addKeyListener(new KeyAdapter() {
		  
		  public void keyPressed(KeyEvent e){
			  
		 
			if(e.getKeyCode()==KeyEvent.VK_DOWN){
			  
			
			switch(koordinate[px+1][py]){
				
			case 0: {  koordinate[px][py]=0;  koordinate[++px][py]=3;  prikaziIgru();}	
			break;
			
			case 1:{  bodovi++;   koordinate[px][py]=0; koordinate[++px][py]=3;  prikaziIgru();  if(bodovi==135) { timer.stop();   JOptionPane.showMessageDialog(okvir,"Pobedili ste!!!!!! ");    igraPanel.setVisible(false);   pocetniPanel.setVisible(true);     rezultati.setText(rezultati.getText()+"\n"+imeIgraca+" "+bodovi);  } else         prikaziIgru();}
			break;
			
			case 5: { timer.stop(); JOptionPane.showMessageDialog(okvir,"Izgubili ste");    igraPanel.setVisible(false); pocetniPanel.setVisible(true); rezultati.setText(rezultati.getText()+"\n"+imeIgraca+" "+bodovi);  }
			break;
			}  
			  
        } else if(e.getKeyCode()==KeyEvent.VK_UP){
			  
			  

			switch(koordinate[px-1][py]){
				
			case 0: {  koordinate[px][py]=0;  koordinate[--px][py]=3;  prikaziIgru();}	
			break;
			
			case 1:{  bodovi++;    koordinate[px][py]=0; koordinate[--px][py]=3; prikaziIgru();  if(bodovi==135) { timer.stop();   JOptionPane.showMessageDialog(okvir,"Pobedili ste!!!!!! ");    igraPanel.setVisible(false);   pocetniPanel.setVisible(true); rezultati.setText(rezultati.getText()+"\n"+imeIgraca+" "+bodovi);  } else         prikaziIgru();}
			break;
			
			case 5: {timer.stop(); JOptionPane.showMessageDialog(okvir,"Izgubili ste");   igraPanel.setVisible(false);  pocetniPanel.setVisible(true); rezultati.setText(rezultati.getText()+"\n"+imeIgraca+" "+bodovi); }
			break;
			}  
			  
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT){
			
			

			switch(koordinate[px][py-1]){
				
			case 0: {  koordinate[px][py]=0;  koordinate[px][--py]=3;  prikaziIgru();}	
			break;
			
			case 1:{ bodovi++;    koordinate[px][py]=0; koordinate[px][--py]=3; prikaziIgru();  if(bodovi==135) { timer.stop();   JOptionPane.showMessageDialog(okvir,"Pobedili ste!!!!!! ");    igraPanel.setVisible(false);   pocetniPanel.setVisible(true);  rezultati.setText(rezultati.getText()+"\n"+imeIgraca+" "+bodovi);  } else         prikaziIgru();       }
			break;
			
			case 5: { timer.stop();  JOptionPane.showMessageDialog(okvir,"Izgubili ste");   igraPanel.setVisible(false);  pocetniPanel.setVisible(true);  rezultati.setText(rezultati.getText()+"\n"+imeIgraca+" "+bodovi);  }
			break;
			}  
			
			
		}else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			

			switch(koordinate[px][py+1]){
				
			case 0: {  koordinate[px][py]=0;  koordinate[px][++py]=3;  prikaziIgru();}	
			break;
			
			case 1:{ bodovi++; koordinate[px][py]=0; koordinate[px][++py]=3;   if(bodovi==135) { timer.stop();   JOptionPane.showMessageDialog(okvir,"Pobedili ste!!!!!! ");    igraPanel.setVisible(false);  pocetniPanel.setVisible(true);  rezultati.setText(rezultati.getText()+"\n"+imeIgraca+" "+bodovi);  } else         prikaziIgru();}
			break;
			
			case 5: {timer.stop(); JOptionPane.showMessageDialog(okvir,"Izgubili ste");   igraPanel.setVisible(false);  pocetniPanel.setVisible(true);rezultati.setText(rezultati.getText()+"\n"+imeIgraca+"  "+bodovi );}
			break;
			}  
			
			}  
			  
			  
		  }
		  
		  
      });
		   
		   
         		   
	  timer=new Timer(200,new ActionListener() {

		  
		  
		 //Kretanje fantoma 
		  
		  
		
		public void actionPerformed(ActionEvent arg0) {
			
			
		int f1=(int)(Math.random()*4);
		int f2=(int)(Math.random()*4);
		int f3=(int)(Math.random()*4);
		
		
		switch(f1){
		
		
		case 0:  if(koordinate[fx1-1][fy1]==3){   timer.stop();   JOptionPane.showMessageDialog(okvir, "Izgubili ste :(");    igraPanel.setVisible(false);  pocetniPanel.setVisible(true);  rezultati.setText(rezultati.getText()+"\n"+imeIgraca+" "+bodovi); return;}
	             else if(koordinate[fx1-1][fy1]==1){  koordinate[fx1][fy1]=1;   koordinate[--fx1][fy1]=5; prikaziIgru();}  
	             else if(koordinate[fx1-1][fy1]==0){  koordinate[fx1][fy1]=0;   koordinate[--fx1][fy1]=5; prikaziIgru();}
		       
		       break;
		         
		case 1:   if(koordinate[fx1+1][fy1]==3){   timer.stop(); JOptionPane.showMessageDialog(okvir, "Izgubili ste :(");    igraPanel.setVisible(false);  pocetniPanel.setVisible(true);  rezultati.setText(rezultati.getText()+"\n"+imeIgraca+" "+bodovi); return;}
                  else if(koordinate[fx1+1][fy1]==1){  koordinate[fx1][fy1]=1;   koordinate[++fx1][fy1]=5;  prikaziIgru();}  
                  else if(koordinate[fx1+1][fy1]==0){  koordinate[fx1][fy1]=0;   koordinate[++fx1][fy1]=5;  prikaziIgru();}
                 
		         break;
		
		case 2:   if(koordinate[fx1][fy1-1]==3){  timer.stop(); JOptionPane.showMessageDialog(okvir, "Izgubili ste :(");    igraPanel.setVisible(false);     pocetniPanel.setVisible(true);   rezultati.setText(rezultati.getText()+"\n"+imeIgraca+" "+bodovi); return;}
                  else if(koordinate[fx1][fy1-1]==1){  koordinate[fx1][fy1]=1;   koordinate[fx1][--fy1]=5;  prikaziIgru();}  
                  else if(koordinate[fx1][fy1-1]==0){  koordinate[fx1][fy1]=0;   koordinate[fx1][--fy1]=5;   prikaziIgru();}
                  break;
		
		case 3:   if(koordinate[fx1][fy1+1]==3){  timer.stop();  JOptionPane.showMessageDialog(okvir, "Izgubili ste :(13");    igraPanel.setVisible(false);  pocetniPanel.setVisible(true); rezultati.setText(rezultati.getText()+"\n"+imeIgraca+" "+bodovi);  return;}
                  else if(koordinate[fx1][fy1+1]==1){  koordinate[fx1][fy1]=1;   koordinate[fx1][++fy1]=5;      prikaziIgru();}  
                  else if(koordinate[fx1+1][fy1+1]==0){  koordinate[fx1][fy1]=0;   koordinate[fx1][++fy1]=5;    prikaziIgru();}
                  break;
		
		
		}
		
		
		//fantom2	

		switch(f2){
		
		
		case 0:  if(koordinate[fx2-1][fy2]==3){  timer.stop();    JOptionPane.showMessageDialog(okvir, "Izgubili ste :(");    igraPanel.setVisible(false);  pocetniPanel.setVisible(true);  rezultati.setText(rezultati.getText()+"\n"+imeIgraca+" "+bodovi); return; }
	             else if(koordinate[fx2-1][fy2]==1){  koordinate[fx2][fy2]=1;   koordinate[--fx2][fy2]=5; prikaziIgru();}  
	             else if(koordinate[fx2-1][fy2]==0){  koordinate[fx2][fy2]=0;   koordinate[--fx2][fy2]=5; prikaziIgru();}
		         break;
		         
		case 1:   if(koordinate[fx2+1][fy2]==3){  timer.stop();  JOptionPane.showMessageDialog(okvir, "Izgubili ste :(");    igraPanel.setVisible(false);  pocetniPanel.setVisible(true);  rezultati.setText(rezultati.getText()+"\n"+imeIgraca+" "+bodovi); return; }
                  else if(koordinate[fx2+1][fy2]==1){  koordinate[fx2][fy2]=1;   koordinate[++fx2][fy2]=5;  prikaziIgru();}  
                  else if(koordinate[fx2+1][fy2]==0){  koordinate[fx2][fy2]=0;   koordinate[++fx2][fy2]=5;  prikaziIgru();}
                  break;
		
		case 2:   if(koordinate[fx2][fy2-1]==3){ timer.stop(); JOptionPane.showMessageDialog(okvir, "Izgubili ste :(");    igraPanel.setVisible(false);   pocetniPanel.setVisible(true);  rezultati.setText(rezultati.getText()+"\n"+imeIgraca+" "+bodovi); return; }
                  else if(koordinate[fx2][fy2-1]==1){  koordinate[fx2][fy2]=1;   koordinate[fx2][--fy2]=5;  prikaziIgru();}  
                  else if(koordinate[fx2][fy2-1]==0){  koordinate[fx2][fy2]=0;   koordinate[fx2][--fy2]=5;   prikaziIgru();}
                  break;
		
		case 3:   if(koordinate[fx2][fy2+1]==3){  timer.stop();  JOptionPane.showMessageDialog(okvir, "Izgubili ste :(");    igraPanel.setVisible(false);  pocetniPanel.setVisible(true); rezultati.setText(rezultati.getText()+"\n"+imeIgraca+" "+bodovi); return;  }
                  else if(koordinate[fx2][fy2+1]==1){  koordinate[fx2][fy2]=1;   koordinate[fx2][++fy2]=5;      prikaziIgru();}  
                  else if(koordinate[fx2+1][fy2+1]==0){  koordinate[fx2][fy2]=0;   koordinate[fx2][++fy2]=5;    prikaziIgru();}
                  break;
		
		
		}		


		
		
switch(f3){
		
		
		case 0:  if(koordinate[fx3-1][fy3]==3){   timer.stop();   JOptionPane.showMessageDialog(okvir, "Izgubili ste :(");    igraPanel.setVisible(false);  pocetniPanel.setVisible(true);  rezultati.setText(rezultati.getText()+"\n"+imeIgraca+" "+bodovi); return; }
	             else if(koordinate[fx3-1][fy3]==1){  koordinate[fx3][fy3]=1;   koordinate[--fx3][fy3]=5; prikaziIgru();}  
	             else if(koordinate[fx3-1][fy3]==0){  koordinate[fx3][fy3]=0;   koordinate[--fx3][fy3]=5; prikaziIgru();}
		         break;
		         
		case 1:   if(koordinate[fx3+1][fy3]==3){  timer.stop();  JOptionPane.showMessageDialog(okvir, "Izgubili ste :(");    igraPanel.setVisible(false);  pocetniPanel.setVisible(true);  rezultati.setText(rezultati.getText()+"\n"+imeIgraca+" "+bodovi); return; }
                  else if(koordinate[fx3+1][fy3]==1){  koordinate[fx3][fy3]=1;   koordinate[++fx3][fy3]=5;  prikaziIgru();}  
                  else if(koordinate[fx3+1][fy3]==0){  koordinate[fx3][fy3]=0;   koordinate[++fx3][fy3]=5;  prikaziIgru();}
                  break;
		
		case 2:   if(koordinate[fx3][fy3-1]==3){ timer.stop(); JOptionPane.showMessageDialog(okvir, "Izgubili ste :(");    igraPanel.setVisible(false);   pocetniPanel.setVisible(true);  rezultati.setText(rezultati.getText()+"\n"+imeIgraca+" "+bodovi); return; }
                  else if(koordinate[fx3][fy3-1]==1){  koordinate[fx3][fy3]=1;   koordinate[fx3][--fy3]=5;  prikaziIgru();}  
                  else if(koordinate[fx3][fy3-1]==0){  koordinate[fx3][fy3]=0;   koordinate[fx3][--fy3]=5;   prikaziIgru();}
                  break;
		
		case 3:   if(koordinate[fx3][fy3+1]==3){  timer.stop();  JOptionPane.showMessageDialog(okvir, "Izgubili ste :(");    igraPanel.setVisible(false);  pocetniPanel.setVisible(true); rezultati.setText(rezultati.getText()+"\n"+imeIgraca+" "+bodovi); return; }
                  else if(koordinate[fx3][fy3+1]==1){  koordinate[fx3][fy3]=1;   koordinate[fx3][++fy3]=5;      prikaziIgru();}  
                  else if(koordinate[fx3+1][fy3+1]==0){  koordinate[fx3][fy3]=0;   koordinate[fx3][++fy3]=5;    prikaziIgru();}
                  break;
		
		
		}				
		
		
		
		
		
}	
	



                }); 
	




	  
	  
	  
	  
	  
}





}
