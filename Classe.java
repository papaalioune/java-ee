package com.uasz.mmp.model.bean;

import javax.validation.constraints.NotNull;

public class Classe {
	private int identifiant;    
    private String CodeClasse;
    private String libelleClasse;
    
	public Classe() {
		
	}

	public Classe(int identifiant, String codeClasse, String libelleClasse) {
		this.identifiant = identifiant;
		CodeClasse = codeClasse;
		this.libelleClasse = libelleClasse;
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public String getCodeClasse() {
		return CodeClasse;
	}

	public void setCodeClasse(String codeClasse) {
		CodeClasse = codeClasse;
	}

	public String getLibelleClasse() {
		return libelleClasse;
	}

	public void setLibelleClasse(String libelleClasse) {
		this.libelleClasse = libelleClasse;
	}
    
	
    
	
}
