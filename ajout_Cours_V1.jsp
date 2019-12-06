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

    <s:form action="cours_ajouter">
        <s:textfield name="unCours.matiere" label="Matière" requiredLabel="true" />
        <s:select name="unCours.classe" label="Formation"
                  list="listClasse" value=""
                  emptyOption="true"
                  requiredLabel="true"/> 
        <s:textfield name="unCours.enseignant" label="Enseignant" requiredLabel="true" />
        <s:textfield name="unCours.salle" label="Salle" requiredLabel="true" />
        <s:select name="unCours.jour" label="Jour"
                  list="listJour" value=""
                  emptyOption="true"
                  requiredLabel="true"/>   
		<s:select name="unCours.HeureDebut" label="Heure début"
                  list="listHeure" value=""
                  emptyOption="true"
                  requiredLabel="true"/> 
		<s:select name="unCours.HeureFin" label="Heure fin"
                  list="listHeure" value=""
                  emptyOption="true"
                  requiredLabel="true"/>                                       	
        <s:submit value="Enregistrer"/>
    </s:form>
</body>
</html>