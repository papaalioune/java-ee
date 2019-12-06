<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    Ajouter un Cours
</head>

<body>
    <s:actionerror/>
    <s:actionmessage/>

    <h2>Ajout d'un Cours</h2>

    <s:form action="cours_ajouter" method="post" validate="true">
        <s:select name="unCours.matiere" label="Matière"
                  list="listMatiere" listKey="codeMatiere" listValue="libelleMatiere"
                  
                  requiredLabel="true"/> 
        <s:select name="unCours.classe" label="Formation"
                  list="listClasse" listKey="codeClasse" listValue="libelleClasse"
                  
                  requiredLabel="true"/>         
        <s:select name="unCours.enseignant" label="Enseignant"
                  list="listEnseignant" listKey="matricule" listValue="prenomEtNom"
                  
                  requiredLabel="true"/>        
        <s:select name="unCours.salle" label="Salle"
                  list="listSalle" listKey="nomSalle" listValue="nomSalle"
                  
                  requiredLabel="true"/>
        <s:select name="unCours.jour" label="Jour"
                  list="listJour" listKey="nomJour" listValue="nomJour"
                  
                  requiredLabel="true"/>   
    <s:select name="unCours.HeureDebut" label="Heure début"
                  list="listHeure" listKey="identifiant" listValue="nomHeure"
                  
                  requiredLabel="true"/> 
    <s:select name="unCours.HeureFin" label="Heure fin"
                  list="listHeure" listKey="identifiant" listValue="nomHeure"
                  
                  requiredLabel="true"/>                                        
        <s:submit value="Enregistrer"/>
    </s:form>
</body>
</html>
