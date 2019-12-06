package com.uasz.mmp.model.bean;

public class HeureDeCours {
	private int identifiant;
	private String nomHeure;
	public HeureDeCours() {
		
	}
	public HeureDeCours(int identifiant, String nomHeure) {
		super();
		this.identifiant = identifiant;
		this.nomHeure = nomHeure;
	}
	public int getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	public String getNomHeure() {
		return nomHeure;
	}
	public void setNomHeure(String nomHeure) {
		this.nomHeure = nomHeure;
	}
	
	
}
