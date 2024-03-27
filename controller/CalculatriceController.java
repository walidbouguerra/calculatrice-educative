package controller;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import model.*;
import view.*;
import java.sql.*;
public class CalculatriceController {
	
	private CalculatriceView view;
	private CalculatriceModel model;
	private int reponse ;
	
	public CalculatriceController(CalculatriceView view, CalculatriceModel model) {
		this.view = view;
		this.model = model;
		this.view.calculAleatoire(this.model.getX(),this.model.getY(),this.model.getOperation());
		this.view.resultatLecture(new Reponse());
		
		
	}
	
	public void fermerProgramme() throws InterruptedException {
		this.view.boutonVisible(false);
		this.view.publicite();
		Thread.sleep(3000);
		System.exit(0);
	}
	
	
	
	
	class Reponse implements ActionListener{

	 

		public void actionPerformed(ActionEvent e) {
			
			try{
				
				reponse = view.getResultat();
			
					
				if(model.verifResultat(reponse)) {
					view.afficheResultat(true, model.getResultat());
				
					
				}
				else {
					view.afficheResultat(false, model.getResultat());
				}
				
				model.calculAleatoire();
				view.calculAleatoire(model.getX(),model.getY(),model.getOperation());
				view.getReponse1().setIcon(new ImageIcon(CalculatriceView.class.getResource("")));
				view.getReponse2().setIcon(new ImageIcon(CalculatriceView.class.getResource("")));
				view.boutonEnabled(true);
				
			}
			catch(NumberFormatException | InterruptedException ex) {
				System.out.println("Vous devez entrer un résultat !");
			} 
			 
			
			
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException, SQLException {
		
		CalculatriceModel model = new CalculatriceModel();
		CalculatriceView view = new CalculatriceView();
		CalculatriceController c = new CalculatriceController(view, model);
		
		c.view.setVisible(true);
		c.view.publicite();
		c.view.debut();
		while(c.view.getCommencer() == false ) {
			c.view.setVisible(true);
		}
		long startTime = System.currentTimeMillis();
		for(int i = 0; i<=4 ; i++) {
			while(c.view.getReponse()==false) {
				c.view.setVisible(true);
			}
			c.model.setNom(c.view.getNom().getText());
			
			c.view.bonneReponse(c.view.getRes());
			c.model.getNote()[5-c.model.getChances()]=c.view.getRes();
			c.model.setChances(c.model.getChances()-1);
			if(c.view.getRes()==true) {
				c.model.setBonnesReponse(c.model.getBonnesReponse()+1);
				c.view.getChances()[i].setBackground(Color.GREEN);
			}
			else {
				c.view.getChances()[i].setBackground(Color.RED);
			}
		}
		
		long endTime = System.currentTimeMillis();
		  
        long timeElapsed = endTime - startTime;
        int temps = (int) (timeElapsed/1000);
        c.model.setTemps(temps);
        
		c.view.fin(c.model.getBonnesReponse());
		c.view.getFinTemps().setText("Temps : "+String.valueOf(temps)+" secondes");
		if(!c.view.getNom().getText().equals("")) {
			
			c.model.connexion();
			c.model.score();
			c.model.tableauScore(c.view);
			c.model.afficherGagnant(view);
		}
		else {
			c.view.getScrollPane().setVisible(false);
		}
		while(c.view.getQuitter() == false ) {
			c.view.setVisible(true);
		}
		
		c.view.publicite2();
		
	}

	

		
	
	
}
