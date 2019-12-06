package com.uasz.mmp.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.uasz.mmp.model.bean.Cours;
import com.uasz.mmp.model.dao.AccesBD;
import com.uasz.mmp.model.dao.CoursDAO;
/**
 * Action de gestion des Cours
 * @author Alioune Cissé
 *
 */

public class GestionCoursAction extends ActionSupport {
	
	// ==================== Attributs ====================
    // ----- Paramètres en entrée
    private Integer id;

    // ----- Eléments en sortie
    private List<Cours> listeDesCours;
    private Cours unCours;
    
    /***** un objet de type AccesBD pour les opération BD *****/
    AccesBD accesBD = new AccesBD();
    // ==================== Getters/Setters ====================
    public Integer getId() {
        return id;
    }
    public void setId(Integer pId) {
        id = pId;
    }
    public List<Cours> getListeDesCours() {
        return listeDesCours;
    }
    
    public void setListeDesCours(List<Cours> listeDesCours) {
		this.listeDesCours = listeDesCours;
	}
    
	public Cours getUnCours() {
        return unCours;
    }
    
              
	public void setUnCours(Cours unCours) {
		this.unCours = unCours;
	}
	
	
    public AccesBD getAccesBD() {
		return accesBD;
	}
	public void setAccesBD(AccesBD accesBD) {
		this.accesBD = accesBD;
	}
	
	// ==================== Méthodes de l'action ====================
	/************** EXPLICATIONS ...
	 Par défaut, si rien n'est précisé dans le mapping, Struts appelle la méthode public String execute() de 
	 la classe d'action. Cette méthode est déjà implémentée dans la classe ActionSupport et renvoie simplement 
	 ActionSupport.SUCCESS. La valeur (String) renvoyée est le nom du Result à utiliser à la fin de l'action. 
	 Celui-ci est configuré dans le mapping Struts. Une action peut donc renvoyer sur plusieurs Result 
	 différents.
	 Ici, pour que cela soit plus clair, on n'utilise pas la méthode execute(). On a créé 3 méthodes pour 
	 nos 3 points d'entrée (nos 3 cas d'utilisation suivants) :
	                                ... EXPLICATIONS *************/
    /**
     * Méthode listant les Cours
     * @return success
     */
    public String doList() {
    	listeDesCours = accesBD.getCours(); //On fait appel à AccesBD pour recupérer depuis la BD la liste des Cours
        return ActionSupport.SUCCESS;	// Le Result renvoyé est ActionSupport.SUCCESS (qui vaut "success").
    }


    /**
     * Méthode affichant les détails d'un Cours
     * @return success / error
     */
    public String doDetail() {
    	// On commence par recupérer l'identifiant du Cours passé via le paramètre id de la requête HTTP et 
    	//injecté automatiquement par Struts dans l'attribut de même nom id.
        if (id == null) {
            this.addActionError("Vous devez indiquer un id de cours");//Si l'attribut n'est pas renseigné, on ajoute un message d'erreur.
        } else {
        	unCours = accesBD.findCours(id); // Sinon, on appelle AccesBD pour qu'il nous renvoie le Cours demandé        	
        	if (unCours==null) {
        		this.addActionError("Cours non trouvé. ID = " + id); //Si le Cours n'est pas trouvé, on ajoute un message d'erreur.
        	}            
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS; //Enfin, si on n'a aucun message d'erreur, 
        //le Result renvoyé est ActionSupport.SUCCESS sinon c'est ActionSupport.ERROR (qui vaut "error").
    }
    
    /**
     * Action supprimant un Cours
     * @return success / error
     */
    public String doSuppression() {
        if (id == null) {
            this.addActionError("Vous devez indiquer un id de cours");
        } else {
        	boolean resultat = accesBD.deleteCours(id);
        	//listeDesCours = accesBD.getCours();
        	if (!resultat) {
        		this.addActionError("Cours non trouvé. ID = " + id);
        	}            
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
        
}
