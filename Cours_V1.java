package com.uasz.mmp.model.bean;

/**
 * Bean du Cours
 */

public class Cours {
    private int identifiant;
    private String jour;
    private int HeureDebut;
    private int HeureFin;
    private String salle;
    private String enseignant;
    private String classe;
    private String matiere;

    //*************** Quelques Constructeurs *****************//
    public Cours() {
    }

    public Cours(int identifiant, String jour, int heureDebut, int heureFin, String salle, String enseignant, String classe, String matiere) {
        this.identifiant = identifiant;
        this.jour = jour;
        HeureDebut = heureDebut;
        HeureFin = heureFin;
        this.salle = salle;
        this.enseignant = enseignant;
        this.classe = classe;
        this.matiere = matiere;
    }

    public Cours(String jour, int heureDebut, int heureFin, String salle, String enseignant, String classe, String matiere) {
        this.jour = jour;
        HeureDebut = heureDebut;
        HeureFin = heureFin;
        this.salle = salle;
        this.enseignant = enseignant;
        this.classe = classe;
        this.matiere = matiere;
    }

    //**************** getteurs et setteurs *****************//
    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public int getHeureDebut() {
        return HeureDebut;
    }

    public void setHeureDebut(int heureDebut) {
        HeureDebut = heureDebut;
    }

    public int getHeureFin() {
        return HeureFin;
    }

    public void setHeureFin(int heureFin) {
        HeureFin = heureFin;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public String getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(String enseignant) {
        this.enseignant = enseignant;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }
    
}
