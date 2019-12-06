package com.uasz.mmp.model.bean;

public class Enseignant {
	private int identifiant;
	private String matricule;
	private String prenomEtNom;
	private String login;
	private String motDePasse;
	public Enseignant() {
		
	}
	public Enseignant(int identifiant, String matricule, String prenomEtNom, String login, String motDePasse) {
		super();
		this.identifiant = identifiant;
		this.matricule = matricule;
		this.prenomEtNom = prenomEtNom;
		this.login = login;
		this.motDePasse = motDePasse;
	}
	public int getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getPrenomEtNom() {
		return prenomEtNom;
	}
	public void setPrenomEtNom(String prenomEtNom) {
		this.prenomEtNom = prenomEtNom;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}		
}
