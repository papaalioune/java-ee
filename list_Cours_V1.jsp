<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste Cours</title>
</head>
<body>
	<h2>Liste des cours</h2>
	<h3 align="center">
		<s:a action="cours_ajouter">	                    
            Ajouter un Cours
       	</s:a>
	</h3>
	<table border="1" cellpadding="1" cellspacing="1" align="center">	
		<tr>
                <td width="150">
                    Matière
                </td>
                <td width="150">
                    Enseignant
                </td>
                <td width="150">
                    Heure
                </td>
                <td width="150">
                    Action
                </td>
        </tr>
		<s:iterator value="listeDesCours">
			<tr>
                <td width="150">
                    <s:property value="matiere"/>
                </td>
                <td width="150">
                    <s:property value="enseignant"/>
                </td>
                <td width="150">
                    <s:property value="HeureDebut"/> H - <s:property value="HeureFin"/> H
                </td>
                <td width="150">
                    <s:a action="cours_detail">
	                    <s:param name="id" value="identifiant" />
	                    Détail
                	</s:a>
                	<s:a action="cours_suppression">
	                    <s:param name="id" value="identifiant" />
	                    Supprimer
                	</s:a>
                </td>
            </tr>
            
        </s:iterator>                                    
    </table>

    <!-- 
    <ul>
        <s:iterator value="listeDesCours">
            <li>
                <s:a action="cours_detail">
                    <s:param name="id" value="identifiant" />
                    <s:property value="matiere"/>
                </s:a>
                |
                <s:property value="enseignant"/>
            </li>
        </s:iterator>
    </ul>
     -->
</body>
</html>