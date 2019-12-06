package com.uasz.mmp.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.uasz.mmp.model.bean.Classe;
import com.uasz.mmp.model.bean.Cours;
import com.uasz.mmp.model.bean.Enseignant;
import com.uasz.mmp.model.bean.HeureDeCours;
import com.uasz.mmp.model.bean.JourDeCours;
import com.uasz.mmp.model.bean.Matiere;
import com.uasz.mmp.model.bean.Salle;
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
    
    private List<JourDeCours> listJour;
    private List<Classe> listClasse;
    private List<HeureDeCours> listHeure;
    private List<Salle> listSalle;
    private List<Matiere> listMatiere;
    private List<Enseignant> listEnseignant;

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
    
    public List<JourDeCours> getListJour() {
        return listJour;
    }
    public void setListJour(List<JourDeCours> listJour) {
        this.listJour = listJour;
    }
    public List<Classe> getListClasse() {
        return listClasse;
    }
    public void setListClasse(List<Classe> listClasse) {
        this.listClasse = listClasse;
    }
    public List<HeureDeCours> getListHeure() {
        return listHeure;
    }
    public void setListHeure(List<HeureDeCours> listHeure) {
        this.listHeure = listHeure;
    }
    public List<Salle> getListSalle() {
        return listSalle;
    }
    public void setListSalle(List<Salle> listSalle) {
        this.listSalle = listSalle;
    }
    public List<Matiere> getListMatiere() {
        return listMatiere;
    }
    public void setListMatiere(List<Matiere> listMatiere) {
        this.listMatiere = listMatiere;
    }
    public List<Enseignant> getListEnseignant() {
        return listEnseignant;
    }
    public void setListEnseignant(List<Enseignant> listEnseignant) {
        this.listEnseignant = listEnseignant;
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
        return ActionSupport.SUCCESS;   // Le Result renvoyé est ActionSupport.SUCCESS (qui vaut "success").
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
    
    /**
     * Methode permettant de créer un nouveau Cours
     * @return input / success / error
     */
    public String doAjouter() {
        // Si (this.projet == null) c'est que l'on entre dans l'ajout d'un Cours
        // Sinon, c'est que l'on vient de valider le formulaire d'ajout

        // Par défaut, le result est "input"
        String vResult = ActionSupport.INPUT;

        // ===== Validation de l'ajout de Cours (unCours != null)
        if (this.unCours != null) {
            /*
             listeDesCours = coursDAO.getCours();
            // id du Cours : c'est le nombre d'éléments de la liste des cours + 10
            //this.unCours.setIdentifiant(this.getListeDesCours().size() + 10);
            */
            // Si pas d'erreur, ajout du Cours...
            if (!this.hasErrors()) {
                boolean res = accesBD.addCours(this.unCours);
                // Si ajout avec succès -> Result "success"
                if (res) {
                    vResult = ActionSupport.SUCCESS;
                    this.addActionMessage("Cours ajouté avec succès");
                } else {
                    vResult = ActionSupport.ERROR;
                    this.addActionMessage("Erreur dans l'ajout du Cours");
                }                               
            }
        }

        // Si on doit aller sur le formulaire de saisie, il faut ajouter les info nécessaires
        if (vResult.equals(ActionSupport.INPUT)) {
            this.listClasse = accesBD.getClasse();
            this.listJour = accesBD.listJour();
            this.listHeure = accesBD.listHeure();
            this.listEnseignant = accesBD.getEnseigants();
            this.listSalle = accesBD.getSalles();
            this.listMatiere = accesBD.getMatieres();
        }

        return vResult;
    }
    
}
