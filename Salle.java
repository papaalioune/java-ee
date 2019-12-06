package com.uasz.mmp.model.bean;

public class Salle {
	private int identifiant;
	private String nomSalle;
	
	public Salle() {
		
	}
	public Salle(int identifiant, String nomSalle) {
		super();
		this.identifiant = identifiant;
		this.nomSalle = nomSalle;
	}
	public int getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	public String getNomSalle() {
		return nomSalle;
	}
	public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
	}
	
	
}
