package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.swing.table.DefaultTableModel;

import java.sql.*;
import view.*;

public class CalculatriceModel {

	private int x;
	private int y;
	private String operation;
	private int resultat;
	private int chances = 5;
	private boolean[] note = new boolean[chances];
	private int bonnesReponse = 0;
	private String nom;
	private int temps;
	private Connection conn;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public CalculatriceModel() {

		calculAleatoire();
	}

	public void calculAleatoire() {
		Random random = new Random();
		int x = random.nextInt(10);
		int y = random.nextInt(10);
		boolean operation = random.nextBoolean();

		while ((x + y > 10) || (x - y < 0) || x == 0 || y == 0) {
			x = random.nextInt(10);
			y = random.nextInt(10);
		}
		if (operation == true) {

			this.operation = "+";
			this.resultat = x + y;
		} else {

			this.operation = "-";
			this.resultat = x - y;
		}

		this.x = x;
		this.y = y;
	}

	public int getResultat() {
		return resultat;
	}

	public void setResultat(int resultat) {
		this.resultat = resultat;
	}

	public boolean verifResultat(int resultat) {
		if (this.resultat == resultat) {
			return true;
		} else {
			return false;
		}
	}

	public int getChances() {
		return chances;
	}

	public void setChances(int chances) {
		this.chances = chances;
	}

	public boolean[] getNote() {
		return note;
	}

	public void setNote(boolean[] note) {
		this.note = note;
	}

	public int getBonnesReponse() {
		return bonnesReponse;
	}

	public void setBonnesReponse(int bonnesReponse) {
		this.bonnesReponse = bonnesReponse;
	}

	public Connection connexion() throws SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {

		}

		String url = "jdbc:mysql://localhost:3306/calculatrice";
		String utilisateur = "root";
		String motDePasse = "root";
		Connection connexion = null;

		try {
			connexion = DriverManager.getConnection(url, utilisateur, motDePasse);

		} catch (SQLException e) {

		}
		return this.conn = connexion;
	}

	public void score() throws SQLException {
		Statement stmt = this.conn.createStatement();
		String sql = "INSERT INTO score " +
				"VALUES (NULL,'" + this.nom + "','" + this.bonnesReponse + "','" + this.temps + "')";
		stmt.executeUpdate(sql);
		this.conn.close();
	}

	public void tableauScore(CalculatriceView view) throws SQLException {
		connexion();
		Statement stmt = this.conn.createStatement();
		String sql = "SELECT * FROM score ORDER BY score DESC, temps";

		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			String nom = rs.getString("nom");
			int score = rs.getInt("score");
			int temps = rs.getInt("temps");

			String tbData[] = { nom, String.valueOf(score), String.valueOf(temps) };
			DefaultTableModel tblModel = (DefaultTableModel) view.getTable().getModel();
			tblModel.addRow(tbData);
			view.getTable().setModel(tblModel);
		}

		this.conn.close();
	}

	public void afficherGagnant(CalculatriceView view) throws SQLException {
		connexion();

		Statement stmt = this.conn.createStatement();
		String sql2 = "SELECT * FROM score ORDER BY score DESC, temps LIMIT 1";
		ResultSet rs2 = stmt.executeQuery(sql2);
		while (rs2.next()) {
			String nom = rs2.getString("nom");
			view.getGagnant().setText("Le gagnant est : " + nom + ", BRAVO !");
		}

		this.conn.close();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getTemps() {
		return temps;
	}

	public void setTemps(int temps) {
		this.temps = temps;
	}

}
