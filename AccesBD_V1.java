package com.uasz.mmp.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.uasz.mmp.model.bean.Classe;
import com.uasz.mmp.model.bean.Cours;
import com.uasz.mmp.model.bean.Enseignant;
import com.uasz.mmp.model.bean.HeureDeCours;
import com.uasz.mmp.model.bean.JourDeCours;
import com.uasz.mmp.model.bean.Matiere;
import com.uasz.mmp.model.bean.Salle;

public class AccesBD {
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3308/java_ee";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "";
	   
	   Connection conn ;
	   Statement stmt ;
	   PreparedStatement preparedStmt;
	   
	   ///////////
	   String sql_select_cours = "SELECT * FROM cours";
	   String sql_select_classes = "SELECT * FROM classe";
	   String sql_select_enseignants = "SELECT * FROM enseignant";
	   String sql_select_salles = "SELECT * FROM salle";
	   String sql_select_matieres = "SELECT * FROM matiere";
	   
	   String sql_insert_cours = "INSERT INTO cours (jour, HeureDebut, HeureFin, salle, enseignant, classe, matiere)"
			   						+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
	   
	   String sql_update_cours = "UPDATE cours SET jour=?, HeureDebut=?, HeureFin=?, salle=?, enseignant=?, classe=?, matiere=?"
					+ "WHERE identifiant = ?";
	   
	   String sql_delete_cours = "DELETE FROM cours WHERE identifiant = ?";
	   //String sql_find_cours = "SELECT * FROM cours WHERE identifiant=?";
	   
	   public AccesBD() {
		   
		   		//	Register JDBC driver
		      try {
		    	// chargement de la classe par son nom
		          Class c = Class.forName(JDBC_DRIVER) ;
		          Driver pilote = (Driver)c.newInstance() ;
		           // enregistrement du pilote auprès du DriverManager
		          DriverManager.registerDriver(pilote);
		          
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }
	   /*********************** OPERATIONS CRUD sur Cours **************************/
	   public List<Cours> getCours() {
		   List<Cours> cours = new ArrayList<Cours>();
		 
		      try {
		    	  /*
		    	// chargement de la classe par son nom
		          Class c = Class.forName(JDBC_DRIVER) ;
		          Driver pilote = (Driver)c.newInstance() ;
		           // enregistrement du pilote auprès du DriverManager
		          DriverManager.registerDriver(pilote);*/
		    	  /* Ouverture d'une connection à la BD : pour chaque accès à la BD, il faut ouvrir une
		    	   	 nouvelle connection qu'il faut fermer après */		    	   
			      System.out.println("Connecting to database...");
				conn = DriverManager.getConnection(DB_URL,USER,PASS);
					// Execution d'une requête
			      System.out.println("Creating statement...");
			      stmt = conn.createStatement();
			      ResultSet rs = stmt.executeQuery(sql_select_cours);
			      //Extraction des données du résultat de la requête
			      while(rs.next()){
			    	//On retrouve les données issues de la BD par les noms de scolonnes
			    	  cours.add(new Cours(rs.getInt("identifiant"),
			    			  				rs.getString("jour"),
			    			  				rs.getInt("HeureDebut"),
			    			  				rs.getInt("HeureFin"),
			    			  				rs.getString("salle"),
			    			  				rs.getString("enseignant"),
			    			  				rs.getString("classe"),
			    			  				rs.getString("matiere")));
			         			         
			      }
			      //Fermeture des connexions
			      rs.close();
			      stmt.close();
			      conn.close();
			      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
			return cours;
		}
	   
	   public boolean addCours(Cours unCours) {		 
		      try {
		    	  conn = DriverManager.getConnection(DB_URL,USER,PASS);
					
		    	  preparedStmt = conn.prepareStatement(sql_insert_cours);
		          preparedStmt.setString (1, unCours.getJour());
		          preparedStmt.setInt(2, unCours.getHeureDebut());
		          preparedStmt.setInt(3, unCours.getHeureFin());
		          preparedStmt.setString(4, unCours.getSalle());
		          preparedStmt.setString(5, unCours.getEnseignant());
		          preparedStmt.setString(6, unCours.getClasse());
		          preparedStmt.setString(7, unCours.getMatiere());

		          // execute the preparedstatement
		          preparedStmt.execute(); 			         			      
			      //Fermeture des connexions
			      stmt.close();
			      conn.close();
			      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}	
		      return true;
		}
	   
	   public void updateCours(Cours unCours) {		 
		      try {
		    	  conn = DriverManager.getConnection(DB_URL,USER,PASS);
					
		    	  preparedStmt = conn.prepareStatement(sql_update_cours);
		          preparedStmt.setString (1, unCours.getJour());
		          preparedStmt.setInt(2, unCours.getHeureDebut());
		          preparedStmt.setInt(3, unCours.getHeureFin());
		          preparedStmt.setString(4, unCours.getSalle());
		          preparedStmt.setString(5, unCours.getEnseignant());
		          preparedStmt.setString(6, unCours.getClasse());
		          preparedStmt.setString(7, unCours.getMatiere());
		          preparedStmt.setInt(8, unCours.getIdentifiant());

		          // execute the preparedstatement
		          preparedStmt.execute(); 			         			      
			      //Fermeture des connexions
		          preparedStmt.close();
			      conn.close();
			      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		    
		}
	   
	   public boolean deleteCours(int identifiant) {		 
		      try {
		    	  conn = DriverManager.getConnection(DB_URL,USER,PASS);
					
		    	  preparedStmt = conn.prepareStatement(sql_delete_cours);
		          preparedStmt.setInt (1, identifiant);		          

		          // execute the preparedstatement
		          preparedStmt.execute(); 			         			      
			      //Fermeture des connexions
		          preparedStmt.close();
			      conn.close();
			      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}	
		      return true;
		}
	   
	   public Cours findCours(int identifiant) {	
		   Cours unCours = null;
		   String sql_find_cours = "SELECT * FROM cours WHERE identifiant = "+identifiant;
		      try {
		    	  conn = DriverManager.getConnection(DB_URL,USER,PASS);
					
		    	  preparedStmt = conn.prepareStatement(sql_find_cours);
		          //preparedStmt.setInt (1, identifiant);		          
		          //preparedStmt.execute(); 		
		          
		          ResultSet rs = preparedStmt.executeQuery(sql_find_cours);
			      //Extraction des données du résultat de la requête
			      while(rs.next()){
			    	//On retrouve les données issues de la BD par les noms de scolonnes
			    	  unCours = new Cours (rs.getInt("identifiant"),
			    			  				rs.getString("jour"),
			    			  				rs.getInt("HeureDebut"),
			    			  				rs.getInt("HeureFin"),
			    			  				rs.getString("salle"),
			    			  				rs.getString("enseignant"),
			    			  				rs.getString("classe"),
			    			  				rs.getString("matiere"));
			         			         
			      }
			      //Fermeture des connexions
			      rs.close();
			      //Fermeture des connexions
			      preparedStmt.close();
			      conn.close();
			      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      return unCours;
		}
	   /***********************FIN OPERATIONS CRUD sur Cours **************************/
	   
	   /***********************DEBUT OPERATIONS CRUD sur CLASSE **************************/	   
	   public List<Classe> getClasse() {
		   List<Classe> classes = new ArrayList<Classe>();		 
		      try {		    	  
				conn = DriverManager.getConnection(DB_URL,USER,PASS);
					
			      stmt = conn.createStatement();
			      ResultSet rs = stmt.executeQuery(sql_select_classes);			      
			      while(rs.next()){
			    	  classes.add(new Classe(rs.getInt("identifiant"),
			    			  				rs.getString("codeClasse"),
			    			  				rs.getString("libelleClasse")));			         			         
			      }
			      rs.close();
			      stmt.close();
			      conn.close();			      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		    
			return classes;
		}
	   /***********************FIN OPERATIONS CRUD sur CLASSE **************************/
	   
	   /***********************DEBUT OPERATIONS CRUD sur Enseignant **************************/	   
	   public List<Enseignant> getEnseigants() {
		   List<Enseignant> enseignants = new ArrayList<Enseignant>();		 
		      try {		    	  
				conn = DriverManager.getConnection(DB_URL,USER,PASS);					
			      stmt = conn.createStatement();
			      ResultSet rs = stmt.executeQuery(sql_select_cours);
			      while(rs.next()){
			    	  enseignants.add(new Enseignant(rs.getInt("identifiant"),
			    			  				rs.getString("matricule"),
			    			  				rs.getString("prenomEtNom"),
			    			  				rs.getString("login"),
			    			  				rs.getString("motDePasse")));			         			         
			      }
			      rs.close();
			      stmt.close();
			      conn.close();			      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		    
			return enseignants;
		}
	   /***********************FIN OPERATIONS CRUD sur Enseignant **************************/
	   
	   /***********************DEBUT OPERATIONS CRUD sur Matiere **************************/
	   public List<Matiere> getMatieres() {
		   List<Matiere> matieres = new ArrayList<Matiere>();		 
		      try {		    	  
				conn = DriverManager.getConnection(DB_URL,USER,PASS);					
			      stmt = conn.createStatement();
			      ResultSet rs = stmt.executeQuery(sql_select_matieres);
			      while(rs.next()){
			    	  matieres.add(new Matiere(rs.getInt("identifiant"),
			    			  				rs.getString("codeMatiere"),
			    			  				rs.getString("libelleMatiere")));			         			         
			      }
			      rs.close();
			      stmt.close();
			      conn.close();			      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		    
			return matieres;
		}
	   /***********************FIN OPERATIONS CRUD sur Matiere **************************/
	   
	   /***********************DEBUT OPERATIONS CRUD sur Salle **************************/
	   public List<Salle> getSalles() {
		   List<Salle> salles = new ArrayList<Salle>();		 
		      try {		    	  
				conn = DriverManager.getConnection(DB_URL,USER,PASS);					
			      stmt = conn.createStatement();
			      ResultSet rs = stmt.executeQuery(sql_select_salles);
			      while(rs.next()){
			    	  salles.add(new Salle(rs.getInt("identifiant"),
			    			  				rs.getString("nomSalle")));			         			         
			      }
			      rs.close();
			      stmt.close();
			      conn.close();			      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		    
			return salles;
		}
	   /***********************FIN OPERATIONS CRUD sur Salle **************************/
	   
	   /*
		 * Méthode constituant et retournant la liste des jours de Cours (pas la peine de l'enregistrer dans la
		 * BD, puisque inchangé ...)
		 */
		public List<JourDeCours> listJour() {
			List<JourDeCours> listJour = new ArrayList<JourDeCours>();
			listJour.add(new JourDeCours(1, "Lundi"));
			listJour.add(new JourDeCours(2, "Mardi"));
			listJour.add(new JourDeCours(3, "Mercredi"));
			listJour.add(new JourDeCours(4, "Jeudi"));
			listJour.add(new JourDeCours(5, "Vendredi"));
			listJour.add(new JourDeCours(6, "Samedi"));
			return listJour;
		}
		
		/*
		 * Méthode constituant et retournant la liste des heures de Cours (pas la peine de l'enregistrer dans la
		 * BD, puisque inchangé ...)
		 */
		public List<HeureDeCours> listHeure() {
			List<HeureDeCours> listHeure = new ArrayList<HeureDeCours>();
			listHeure.add(new HeureDeCours(8, "8H 00"));
			listHeure.add(new HeureDeCours(9, "9H 00"));
			listHeure.add(new HeureDeCours(10, "10H 00"));
			listHeure.add(new HeureDeCours(11, "11H 00"));
			listHeure.add(new HeureDeCours(12, "12H 00"));
			listHeure.add(new HeureDeCours(13, "13H 00"));
			listHeure.add(new HeureDeCours(14, "14H 00"));
			listHeure.add(new HeureDeCours(15, "15H 00"));
			listHeure.add(new HeureDeCours(16, "16H 00"));
			listHeure.add(new HeureDeCours(17, "16H 00"));
			listHeure.add(new HeureDeCours(18, "18H 00"));
			listHeure.add(new HeureDeCours(19, "19H 00"));
			return listHeure;
		}		
	   
}
