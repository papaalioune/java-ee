package com.uasz.mmp.model.bean;

public class Matiere {
	private int identifiant;
	private String codeMatiere;
	private String libelleMatiere;
	
	
	public Matiere() {
		
	}


	public int getIdentifiant() {
		return identifiant;
	}


	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}


	public String getCodeMatiere() {
		return codeMatiere;
	}


	public void setCodeMatiere(String codeMatiere) {
		this.codeMatiere = codeMatiere;
	}


	public String getLibelleMatiere() {
		return libelleMatiere;
	}


	public void setLibelleMatiere(String libelleMatiere) {
		this.libelleMatiere = libelleMatiere;
	}


	public Matiere(int identifiant, String codeMatiere, String libelleMatiere) {
		super();
		this.identifiant = identifiant;
		this.codeMatiere = codeMatiere;
		this.libelleMatiere = libelleMatiere;
	}
	
	
}
