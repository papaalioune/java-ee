<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Détail du Cours</h2>

    <ul>
        <li>Matière : <s:property value="unCours.matiere" /></li>
        <li>Enseignant : <s:property value="unCours.enseignant" /></li>
        <li>Jour : <s:property value="unCours.jour" /></li>
        <li>Heure : <s:property value="unCours.HeureDebut" /> H - <s:property value="unCours.HeureFin" /> H</li>
        <li>Salle : <s:property value="unCours.salle" /></li>
        <li>Formation : <s:property value="unCours.classe" /></li>
    </ul>
</body>
</html>