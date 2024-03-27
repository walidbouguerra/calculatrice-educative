package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JSplitPane;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class CalculatriceView extends JFrame {

	private JPanel contentPane;
	private JLabel xLabel;
	private JLabel reponse1 = new JLabel("");
	

	private JLabel yLabel = new JLabel("");
	private JButton bouttonOk = new JButton("OK");
	private JLabel opLabel = new JLabel("");
	private JLabel resultat = new JLabel("");
	private JLabel reponse2 = new JLabel("");
	private JLabel opLabel_1 = new JLabel("");

	private boolean reponse = false;
	private JButton btn9 = new JButton("9");
	private JButton btn8 = new JButton("8");
	private JButton btn7 = new JButton("7");
	private JButton btn6 = new JButton("6");
	private JButton btn5 = new JButton("5");
	private JButton btn4 = new JButton("4");
	private JButton btn3 = new JButton("3");
	private JButton btn2 = new JButton("2");
	private JButton btn1 = new JButton("1");
	private JButton btn0 = new JButton("0");
	private JButton btnGomme = new JButton("");
	private final JLabel texteFin = new JLabel("");
	private final JLabel reponseImage = new JLabel("");
	private final JLabel lblNewLabel = new JLabel("");
	private JLabel pub = new JLabel("");
	private JLabel pub_text = new JLabel("Publicit\u00E9 : patientez 5 secondes ...");
	private JLabel texteNom = new JLabel("Nom :");
	
	private boolean res;
	private int bonResultat;
	private final JButton btnQuitter = new JButton("Quitter");
	private boolean quitter = false;
	private JLabel chance_1 = new JLabel("");
	private JLabel chance_2 = new JLabel("");
	private final JLabel chance_3 = new JLabel("");
	private final JLabel chance_4 = new JLabel("");
	private final JLabel chance_5 = new JLabel("");
	private JLabel[] chances = new JLabel[5];
	public JLabel[] getChances() {
		return chances;
	}

	private final JLabel fin = new JLabel("");
	private final JLabel finTexte = new JLabel();
	private JTextField nom;
	private final JButton btnCommencer = new JButton("Commencer");
	private boolean commencer = false;
	private  JLabel finTemps = new JLabel("");
	private JTable table  = new JTable() ;
	JScrollPane scrollPane = new JScrollPane();
	private final JLabel gagnant = new JLabel("");
   public JScrollPane getScrollPane() {
		return scrollPane;
	}
public JTable getTable() {
		return table;
	}
public JLabel getFinTemps() {
		return finTemps;
	}
private void chances(){
        JLabel[] chances =new JLabel[5];
          chances[0]=chance_1;
          chances[1]=chance_2;
          chances[2]=chance_3;
          chances[3]=chance_4;
          chances[4]=chance_5;
	        
        this.chances = chances;
	    }
	public JTextField getNom() {
		return nom;
	}
	public void setCommencer(boolean commencer) {
		this.commencer = commencer;
		chances();
		chance_1.setVisible(true);
		chance_2.setVisible(true);
		chance_3.setVisible(true);
		chance_4.setVisible(true);
		chance_5.setVisible(true);
		
	}

	public JButton getBtnQuitter() {
		return btnQuitter;
	}

	public JLabel getReponse1() {
		return reponse1;
	}

	public JLabel getReponse2() {
		return reponse2;
	}

	public boolean getRes() {
		return res;
	}
	
	
	public boolean getQuitter() {
		return quitter;
	}

	public void setQuitter(boolean quitter) {
		this.quitter = quitter;
	}
	public void publicite() throws InterruptedException {
		scrollPane.setVisible(false);
		table.setVisible(false);
		btnCommencer.setVisible(false);
		texteNom.setVisible(false);
		nom.setVisible(false);
		chance_1.setVisible(false);
		chance_2.setVisible(false);
		chance_3.setVisible(false);
		chance_4.setVisible(false);
		chance_5.setVisible(false);
		boutonVisible(false);
		Thread.sleep(5000);
		pub.setVisible(false);
		pub_text.setVisible(false);
		chance_1.setVisible(true);
		chance_2.setVisible(true);
		chance_3.setVisible(true);
		chance_4.setVisible(true);
		chance_5.setVisible(true);
		boutonVisible(true);
	}
	public void publicite2() throws InterruptedException {
		gagnant.setVisible(false);
		finTemps.setVisible(false);
		scrollPane.setVisible(false);
		texteNom.setVisible(false);
		nom.setVisible(false);
		finTexte.setVisible(false);
		fin.setVisible(false);
		this.btnQuitter.setVisible(false);
		chance_1.setVisible(false);
		chance_2.setVisible(false);
		chance_3.setVisible(false);
		chance_4.setVisible(false);
		chance_5.setVisible(false);
		boutonVisible(false);
		pub.setVisible(true);
		pub_text.setText("Publicit\u00E9 : patientez 3 secondes ...");
		pub_text.setVisible(true);
		Thread.sleep(3000);
		System.exit(0);
	}
	public void debut() {
		chance_1.setVisible(false);
		chance_2.setVisible(false);
		chance_3.setVisible(false);
		chance_4.setVisible(false);
		chance_5.setVisible(false);
		btnCommencer.setVisible(true);
		finTexte.setText("DÉBUT DE LA PARTIE");
		boutonVisible(false);
		xLabel.setVisible(false);
		yLabel.setVisible(false);
		opLabel.setVisible(false);
		opLabel_1.setVisible(false);
		reponse1.setVisible(false);
		reponse2.setVisible(false);
		texteNom.setVisible(true);
		nom.setVisible(true);
	}
	public void fin(int note) throws InterruptedException {
		scrollPane.setVisible(true);
		table.setVisible(true);
		btnQuitter.setVisible(true);
		finTexte.setText("FIN DE LA PARTIE");
		boutonVisible(false);
		xLabel.setVisible(false);
		yLabel.setVisible(false);
		opLabel.setVisible(false);
		opLabel_1.setVisible(false);
		reponse1.setVisible(false);
		reponse2.setVisible(false);
		this.fin.setText("Note : "+String.valueOf(note)+"/5");
	
	
			
	}
	public boolean getReponse() {
		return this.reponse;
	}

	public void resultatLecture(ActionListener e) {
		this.bouttonOk.addActionListener(e);
		
		
	}

	public void bonneReponse(boolean res) throws InterruptedException{
		
		boutonVisible(false);
		if(res == true) {
			this.texteFin.setText(" Bonne réponse ! ");
		}
		else{
			this.texteFin.setText(" Mauvaise réponse, résultat = ");
			this.reponseImage.setIcon(new ImageIcon(CalculatriceView.class.getResource("/media/"+String.valueOf(this.bonResultat)+".jpg")));
			this.reponseImage.setVisible(true);
		}
		this.texteFin.setVisible(true);
		xLabel.setVisible(false);
		yLabel.setVisible(false);
		opLabel.setVisible(false);
		opLabel_1.setVisible(false);
		reponse1.setVisible(false);
		reponse2.setVisible(false);
		Thread.sleep(2000);
		xLabel.setVisible(true);
		yLabel.setVisible(true);
		opLabel.setVisible(true);
		opLabel_1.setVisible(true);
		reponse1.setVisible(true);
	
		this.texteFin.setVisible(false);
		this.reponseImage.setVisible(false);
		boutonVisible(true);
		this.reponse= false;
	}
	public void boutonVisible(boolean bool) {
		 btn9.setVisible(bool);
		 btn8.setVisible(bool);
		 btn7.setVisible(bool);
		 btn6.setVisible(bool);
		 btn5.setVisible(bool);
		 btn4.setVisible(bool);
		 btn3.setVisible(bool);
		 btn2.setVisible(bool);
		 btn1.setVisible(bool);
		 btn0.setVisible(bool);
		 bouttonOk.setVisible(bool);
		 btnGomme.setVisible(bool);
		
	}
	public void boutonEnabled(boolean bool) {
		btn9.setEnabled(bool);
		 btn8.setEnabled(bool);
		 btn7.setEnabled(bool);
		 btn6.setEnabled(bool);
		 btn5.setEnabled(bool);
		 btn4.setEnabled(bool);
		 btn3.setEnabled(bool);
		 btn2.setEnabled(bool);
		 btn1.setEnabled(bool);
	}
	public void afficheResultat(boolean res, int resultat) throws InterruptedException {
	
		this.res = res;
		this.bonResultat = resultat;
		this.reponse = true;
		
	}

	
	public void calculAleatoire(int x, int y, String operation) {
		this.xLabel.setIcon(new ImageIcon(CalculatriceView.class.getResource("/media/"+String.valueOf(x)+".jpg")));
		this.yLabel.setIcon(new ImageIcon(CalculatriceView.class.getResource("/media/"+String.valueOf(y)+".jpg")));
		this.opLabel.setIcon(new ImageIcon(CalculatriceView.class.getResource("/media/"+operation+".jpg")));
	}
	public int getResultat() {
		return Integer.parseInt(resultat.getText());
	}
		
	
	public CalculatriceView() throws InterruptedException {
			
		setTitle("Calculatrice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 465);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		reponse2.setVisible(false);
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setQuitter(true);
			}
		});
		btnCommencer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCommencer(true);
				boutonVisible(true);
				xLabel.setVisible(true);
				yLabel.setVisible(true);
				opLabel.setVisible(true);
				opLabel_1.setVisible(true);
				reponse1.setVisible(true);
				texteNom.setVisible(false);
				nom.setVisible(false);
				finTexte.setText("");
				btnCommencer.setVisible(false);
				
			}
		});
		gagnant.setFont(new Font("Tahoma", Font.BOLD, 16));
		gagnant.setHorizontalAlignment(SwingConstants.CENTER);
		gagnant.setBounds(13, 290, 407, 39);
		
		contentPane.add(gagnant);
		finTexte.setHorizontalAlignment(SwingConstants.CENTER);
		finTexte.setFont(new Font("Tahoma", Font.BOLD, 18));
		finTexte.setBounds(10, 26, 414, 26);
		
		contentPane.add(finTexte);
		finTemps.setFont(new Font("Tahoma", Font.BOLD, 16));
		finTemps.setHorizontalAlignment(SwingConstants.CENTER);
		finTemps.setBounds(16, 105, 401, 26);
		
		contentPane.add(finTemps);
		fin.setFont(new Font("Tahoma", Font.BOLD, 18));
		fin.setHorizontalAlignment(SwingConstants.CENTER);
		fin.setBounds(10, 60, 414, 39);
		
		contentPane.add(fin);
		
		
		scrollPane.setBounds(61, 142, 312, 137);
		contentPane.add(scrollPane);
		
	
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nom", "Score", "Temps"
			}
		));
		
		btnCommencer.setBounds(157, 290, 120, 39);
		
		contentPane.add(btnCommencer);
		
		
		texteNom.setBounds(63, 262, 46, 14);
		contentPane.add(texteNom);
		
		nom = new JTextField();
		nom.setBounds(119, 259, 196, 20);
		contentPane.add(nom);
		nom.setColumns(10);
		
		
		chance_2.setOpaque(true);
		chance_2.setBackground(Color.WHITE);
		chance_2.setBounds(384, 233, 40, 36);
		contentPane.add(chance_2);
		
		
		chance_1.setOpaque(true);
		chance_1.setBackground(Color.WHITE);
		chance_1.setBounds(384, 192, 40, 36);
		contentPane.add(chance_1);
		chance_5.setOpaque(true);
		chance_5.setBounds(384, 356, 40, 36);
		
		contentPane.add(chance_5);
		chance_4.setOpaque(true);
		chance_4.setBounds(384, 315, 40, 36);
		
		contentPane.add(chance_4);
		chance_3.setBackground(Color.WHITE);
		chance_3.setOpaque(true);
		chance_3.setBounds(384, 274, 40, 36);
		
		contentPane.add(chance_3);
		
		
		btnQuitter.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnQuitter.setBounds(131, 365, 171, 50);
		
		contentPane.add(btnQuitter);
		btnQuitter.setVisible(false);
		contentPane.add(texteFin);
		contentPane.add(reponseImage);
	
		
		pub_text.setHorizontalAlignment(SwingConstants.CENTER);
		pub_text.setOpaque(true);
		pub_text.setFont(new Font("Tahoma", Font.BOLD, 16));
		pub_text.setForeground(Color.RED);
		pub_text.setBounds(0, 0, 434, 26);
		contentPane.add(pub_text);
		pub.setIcon(new ImageIcon(CalculatriceView.class.getResource("/media/pub.jpg")));
		pub.setBounds(0, 0, 434, 426);
		contentPane.add(pub);
		
	
	
		
		xLabel = new JLabel("");
		xLabel.setOpaque(true);
		xLabel.setHorizontalAlignment(SwingConstants.CENTER);
		xLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		xLabel.setBackground(Color.WHITE);
		xLabel.setBounds(10, 11, 70, 85);
		contentPane.add(xLabel);
		
		
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String str = ((JButton)e.getSource()).getText();
				 resultat.setText(str);
				 reponse1.setIcon(new ImageIcon(CalculatriceView.class.getResource("/media/"+str+".jpg")));
			}
		});
		btn7.setForeground(new Color(255, 255, 255));
		btn7.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
		btn7.setBackground(new Color(30, 144, 255));
		btn7.setBounds(51, 120, 50, 50);
		contentPane.add(btn7);
		
		
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String str = ((JButton)e.getSource()).getText();
				 resultat.setText(str);
				 reponse1.setIcon(new ImageIcon(CalculatriceView.class.getResource("/media/"+str+".jpg")));
			}
		});
		btn8.setForeground(new Color(255, 255, 255));
		btn8.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
		btn8.setBackground(new Color(30, 144, 255));
		btn8.setBounds(121, 120, 50, 50);
		contentPane.add(btn8);
		
		
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String str = ((JButton)e.getSource()).getText();
				 resultat.setText(str);
				 reponse1.setIcon(new ImageIcon(CalculatriceView.class.getResource("/media/"+str+".jpg")));
			}	
		});
		btn9.setForeground(new Color(255, 255, 255));
		btn9.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
		btn9.setBackground(new Color(30, 144, 255));
		btn9.setBounds(191, 120, 50, 50);
		contentPane.add(btn9);
		
	
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String str = ((JButton)e.getSource()).getText();
				 resultat.setText(str);
				 reponse1.setIcon(new ImageIcon(CalculatriceView.class.getResource("/media/"+str+".jpg")));
			}
		});
		btn4.setForeground(new Color(255, 255, 255));
		btn4.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
		btn4.setBackground(new Color(30, 144, 255));
		btn4.setBounds(51, 190, 50, 50);
		contentPane.add(btn4);
		
	
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String str = ((JButton)e.getSource()).getText();
				 resultat.setText(str);
				 reponse1.setIcon(new ImageIcon(CalculatriceView.class.getResource("/media/"+str+".jpg")));
			}
		});
		btn5.setForeground(new Color(255, 255, 255));
		btn5.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
		btn5.setBackground(new Color(30, 144, 255));
		btn5.setBounds(121, 190, 50, 50);
		contentPane.add(btn5);
		
	
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String str = ((JButton)e.getSource()).getText();
				 resultat.setText(str);
				 reponse1.setIcon(new ImageIcon(CalculatriceView.class.getResource("/media/"+str+".jpg")));
			}
		});
		btn6.setForeground(new Color(255, 255, 255));
		btn6.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
		btn6.setBackground(new Color(30, 144, 255));
		btn6.setBounds(191, 190, 50, 50);
		contentPane.add(btn6);
		
	
		
	
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String str = ((JButton)e.getSource()).getText();
				 resultat.setText(str);
				 reponse1.setIcon(new ImageIcon(CalculatriceView.class.getResource("/media/"+str+".jpg")));
			}
		});
		btn2.setForeground(new Color(255, 255, 255));
		btn2.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
		btn2.setBackground(new Color(30, 144, 255));
		btn2.setBounds(121, 260, 50, 50);
		contentPane.add(btn2);
		
		
		btn3.setForeground(new Color(255, 255, 255));
		btn3.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
		btn3.setBackground(new Color(30, 144, 255));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String str = ((JButton)e.getSource()).getText();
				 resultat.setText(str);
				 reponse1.setIcon(new ImageIcon(CalculatriceView.class.getResource("/media/"+str+".jpg")));
			}
		});
		btn3.setBounds(191, 260, 50, 50);
		contentPane.add(btn3);
		
		
		btn0.setForeground(new Color(255, 255, 255));
		btn0.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
		btn0.setBackground(new Color(30, 144, 255));
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String str = ((JButton)e.getSource()).getText();
				 if(resultat.getText()=="1") {
					 reponse2.setVisible(true);
					 reponse2.setIcon(new ImageIcon(CalculatriceView.class.getResource("/media/"+str+".jpg")));
					 resultat.setText("10");
				 }
				 else {
					 resultat.setText(str);
					 reponse1.setIcon(new ImageIcon(CalculatriceView.class.getResource("/media/"+str+".jpg")));
				 }
				 
			}
		});
		btn0.setBounds(51, 330, 50, 50);
		contentPane.add(btn0);
		
	
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String str = ((JButton)e.getSource()).getText();
				 resultat.setText(str);
				 reponse1.setIcon(new ImageIcon(CalculatriceView.class.getResource("/media/"+str+".jpg")));
				 boutonEnabled(false);
			}
		});
		btn1.setForeground(new Color(255, 255, 255));
		btn1.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
		btn1.setBackground(new Color(30, 144, 255));
		btn1.setBounds(51, 260, 50, 50);
		contentPane.add(btn1);
		
		
		bouttonOk.setForeground(new Color(255, 255, 255));
		bouttonOk.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
		bouttonOk.setBackground(new Color(50, 205, 50));
		bouttonOk.setBounds(121, 330, 120, 50);
		contentPane.add(bouttonOk);
		
		
		btnGomme.setIcon(new ImageIcon(CalculatriceView.class.getResource("/media/gomme.jpg")));
		btnGomme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boutonEnabled(true);
				resultat.setText("");
				reponse1.setIcon(new ImageIcon(CalculatriceView.class.getResource("")));
				reponse2.setVisible(false);
				reponse2.setIcon(new ImageIcon(CalculatriceView.class.getResource("")));
				 
			}
		});
		btnGomme.setForeground(new Color(255, 255, 255));
		btnGomme.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
		btnGomme.setBackground(new Color(220, 20, 60));
		btnGomme.setBounds(261, 159, 65, 120);
		contentPane.add(btnGomme);
		
		
		reponse1.setOpaque(true);
		reponse1.setHorizontalAlignment(SwingConstants.CENTER);
		reponse1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		reponse1.setBackground(Color.WHITE);
		reponse1.setBounds(293, 11, 70, 85);
		contentPane.add(reponse1);
		
		
		yLabel.setOpaque(true);
		yLabel.setHorizontalAlignment(SwingConstants.CENTER);
		yLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		yLabel.setBackground(Color.WHITE);
		yLabel.setBounds(140, 11, 70, 85);
		contentPane.add(yLabel);
		
		
		opLabel.setOpaque(true);
		opLabel.setHorizontalAlignment(SwingConstants.CENTER);
		opLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		opLabel.setBackground(Color.WHITE);
		opLabel.setBounds(80, 26, 61, 50);
		contentPane.add(opLabel);
		
		
		reponse2.setOpaque(true);
		reponse2.setHorizontalAlignment(SwingConstants.CENTER);
		reponse2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		reponse2.setBackground(Color.WHITE);
		reponse2.setBounds(364, 11, 70, 85);
		contentPane.add(reponse2);
		
		
		opLabel_1.setIcon(new ImageIcon(CalculatriceView.class.getResource("/media/=.jpg")));
		opLabel_1.setOpaque(true);
		opLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		opLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		opLabel_1.setBackground(Color.WHITE);
		opLabel_1.setBounds(220, 26, 61, 50);
		contentPane.add(opLabel_1);
		
		lblNewLabel.setIcon(new ImageIcon(CalculatriceView.class.getResource("/media/pub.jpg")));
		lblNewLabel.setBounds(0, 0, 434, 426);
		
		
		
		texteFin.setFont(new Font("Rubik", Font.BOLD, 20));
		texteFin.setHorizontalAlignment(SwingConstants.CENTER);
		texteFin.setBounds(0, 156, 434, 39);
		
	
		reponseImage.setHorizontalAlignment(SwingConstants.CENTER);
		reponseImage.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		reponseImage.setBackground(Color.WHITE);
		reponseImage.setBounds(166, 251, 70, 85);
		
	
		

	
	}

	public JLabel getGagnant() {
		return gagnant;
	}
	public JLabel getChance_1() {
		return chance_3;
	}

	public JLabel getChance_2() {
		return chance_4;
	}

	public JLabel getChance_3() {
		return chance_5;
	}

	public boolean getCommencer() {
		return commencer;
	}
}
