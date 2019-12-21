package com.uasz.msia.jedt.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;


import com.opensymphony.xwork2.ActionSupport;
import com.uasz.msia.jedt.model.bean.Utilisateur;
import com.uasz.msia.jedt.model.dao.AccesBD;

/**
 * Action de gestion de la connexion/déconnexion d'un utilisateur
 */
public class GestionSecuriteAction extends ActionSupport implements ServletRequestAware, SessionAware {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ==================== Attributs ====================
    // ----- Paramètres en entrée
    private String login;
    private String password;
    
    /***** un objet de type AccesBD pour les opération BD *****/
    AccesBD accesBD = new AccesBD();
    
    // ----- Eléments Struts
    private Map<String, Object> session;
    
    private HttpServletRequest servletRequest;

    public void setServletRequest(HttpServletRequest pRequest) {
        this.servletRequest = pRequest;
    }

    
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }


    // ==================== Getters/Setters ====================
    public String getLogin() {
        return login;
    }
    public void setLogin(String pLogin) {
        login = pLogin;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String pPassword) {
        password = pPassword;
    }
    
    public AccesBD getAccesBD() {
		return accesBD;
	}
	public void setAccesBD(AccesBD accesBD) {
		this.accesBD = accesBD;
	}	


    // ==================== Méthodes ====================
    /**
     * Action permettant la connexion d'un utilisateur
     * @return input / success
     */
    public String doLogin() {
        String vResult = ActionSupport.INPUT;
        if (!StringUtils.isAllEmpty(login, password)) {
        	Utilisateur vUtilisateur = accesBD.findUtilisateur(login, password);
        	if (vUtilisateur != null) {
        		// Ajout de l'utilisateur en session
                this.session.put("user", vUtilisateur);
                
        		vResult = ActionSupport.SUCCESS;
        	} else {
        		this.addActionError("Identifiant ou mot de passe invalide !");
        	}                
        }
        return vResult;
    }


    /**
     * Action de déconnexion d'un utilisateur
     * @return success
     */
    public String doLogout() {
    	// Suppression de l'utilisateur en session
        this.session.remove("user");
        
    	// Invalidation de la session
        this.servletRequest.getSession().invalidate();
        
        return ActionSupport.SUCCESS;
    }
}