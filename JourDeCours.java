package com.uasz.mmp.model.bean;

public class JourDeCours {
	private int identifiant;
	private String nomJour;
	public JourDeCours() {
		
	}
	public JourDeCours(int identifiant, String nomJour) {
		super();
		this.identifiant = identifiant;
		this.nomJour = nomJour;
	}
	public int getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	public String getNomJour() {
		return nomJour;
	}
	public void setNomJour(String nomJour) {
		this.nomJour = nomJour;
	}
	
	
}
