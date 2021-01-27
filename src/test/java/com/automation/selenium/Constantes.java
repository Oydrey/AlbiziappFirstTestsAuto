package com.automation.selenium;

public class Constantes {
	
	/* Constants XPATH */
	
	//Releves	
	public static final String XPATH_MAP = "/html/body/div[1]/div/div[1]/div[1]";	
	
	public static final String XPATH_HAUTEUR_MOINS_2M = "/html/body/div[1]/div/div[1]/div[5]/table/tbody/tr/td[2]";
	
	public static final String XPATH_HAUTEUR_2M_5M = "/html/body/div[1]/div/div[1]/div[5]/table/tbody/tr/td[3]";
	
	public static final String XPATH_HAUTEUR_5M_10M = "/html/body/div[1]/div/div[1]/div[5]/table/tbody/tr/td[4]";	
	
	public static final String XPATH_HAUTEUR_PLUS_10M = "/html/body/div[1]/div/div[1]/div[5]/table/tbody/tr/td[5]";	
	
	public static final String XPATH_RELEVE_PHOTO_INPUT = "/html/body/div[1]/div/div[1]/div[6]/div/div/input";	
	
	public static final String XPATH_RELEVE_BOUTON_VALIDER = "/html/body/div[1]/div/div[1]/button[1]";
	
	//Login
	public static final String XPATH_LOGIN_SIGN_IN_BOUTON = "/html/body/div[1]/div/div/div/div/button";
	
	public static final String XPATH_LOGIN_ACCORD_ACCESS_BOUTON = "/html/body/div/div[2]/div/form/input[5]";
	
	public static final String XPATH_LOGIN_MAP_BOUTON = "//*[@id=\\\"root\\\"]/div/div[1]/button[1]";
	
	//Menu
	public static final String XPATH_MENU_BOUTON_FEUILLE = "//*[@id=\\\"root\\\"]/div/header/div/button";
	
	public static final String XPATH_MENU_DECONNEXION_BOUTON = "/html/body/div[6]/div[3]/ul/div[3]";
	
	//Open Street Map (OSM)
	public static final String XPATH_OSM_MENU_ICONE = "//*[@id=\\\"menu-icon\\\"]";
	
	public static final String XPATH_OSM_MENU_PROFIL_BOUTON = "/html/body/header/nav[2]/div/a";
	
	public static final String XPATH_OSM_SE_DECONNECTER_BOUTON = "/html/body/header/nav[2]/div/div/a[4]";
	
	//Map
	public static final String XPATH_MAP_STYLE_SCALE = "//*[@id=\\\"root\\\"]/div/div[1]/div[1]/div[1]/div[7]";
	
	public static final String XPATH_MAP_BOUTON_ZOOM ="//*[@id=\\\"root\\\"]/div/div[1]/div[1]/div[2]/div[1]/div/a[1]";
	
	public static final String XPATH_MAP_BOUTON_DEZOOM = "//*[@id=\\\"root\\\"]/div/div[1]/div[1]/div[2]/div[1]/div/a[2]";
	
	public static final String XPATH_MAP_MISSION_EN_COURS = "//*[@id=\\\"root\\\"]/div/div[1]/div[2]";

	public static final String XPATH_MAP_BOUTON_CENTRER = "/html/body/div[1]/div/div[1]/button[1]";
	
	public static final String XPATH_MAP_STYLE = "//*[@id=\\\"root\\\"]/div/div[1]/div[1]/div[1]";
	
	public static final String XPATH_MAP_CURSEUR_POSITION = "//*[@id=\\\"root\\\"]/div/div[1]/div[1]/div[1]/div[4]/img";
	
	//Menu en bas
	
	public static final String XPATH_MENU_BAS_MAP_BOUTON = "//*[@id=\\\"root\\\"]/div/div[2]/button[1]";
	
	public static final String XPATH_MENU_BAS_MISSION_BOUTON = "//*[@id=\\\"root\\\"]/div/div[2]/button[2]";
	
	public static final String XPATH_MENU_BAS_ARBORETUM_BOUTON = "//*[@id=\\\"root\\\"]/div/div[2]/button[4]";
	
	//Missions
	
	public static final String XPATH_MISSIONS_LISTE_MISSIONS = "//*[@id=\\\"root\\\"]/div/div[1]//*";
		//Depuis liste missions
		public static final String XPATH_lISTE_MISSIONS_NOM_MISSION_SELECT = "./div/div/div[2]/h2";
		
		public static final String XPATH_LISTE_MISSIONS_BARRE_PROGRESSION_MISSION_SELECT = "./div/div/div[2]/div/div[1]/div";
		
	//Arboretum
		
	public static final String XPATH_ARBORETUM_LISTE_IDENTIFICATION = "//*[@id=\\\"root\\\"]/div/div[1]/div[2]//*";
		//Depuis liste identification
		public static final String XPATH_LISTE_IDENTIFIACTION_NOM_ESPECE_SELECT = ".//button/div[2]/h2";
		
	public static final String XPATH_ARBORETUM_PREMIERE_ESPECE_NOMBRE_IDENTIFICATIONS_TEXTE = "//*[@id=\\\"root\\\"]/div/div[1]/div[2]/div[1]/button/div[2]/p";
	
	
	
	
	/* Constants ID */
	
	//Releves
	public static final String ID_GENRE_COMMUN = "commonGenusSelect";
	
	public static final String ID_ESPECE_COMMUNE = "speciesCommonNameSelect";
	
	public static final String ID_GENRE_LATIN = "genusSelect";
	
	public static final String ID_ESPECE_LATINE = "speciesNameSelect";
	
	
	
	
	
	/* Constants CSS SELECTOR */
	
	//Releves		
	public static final String CSS_SELECTOR_RELEVE_BOUTON_CONFIMER_VALIDATION = ".MuiButtonBase-root.MuiButton-textPrimary";
	
	//Map
	public static final String CSS_SELECTOR_MAP_DERNIER_RELEVE = ".MuiListItem-root:nth-last-child(1)";
	
	public static final String CSS_SELECTOR_MAP_CLICK_ON_MAP = ".MuiButtonBase-root.MuiButton-textPrimary";	
	
	
	
	
	
	/* Constants NAME */
	
	//Login
	public static final String NAME_LOGIN_EMAIL_FIELD = "username";
	
	public static final String NAME_LOGIN_PASSWORD_FIELD = "password";
	
	public static final String NAME_LOGIN_COMMIT_BOUTON = "commit";
	
	
	
	
	
	/* Constants URL */
	
	public static final String URL_ALBIZIAPP_MAP = "https://albiziapp.ozytis.fr/map";
	
	
	
	
	
	/* Constants SELENIUM */
	
	public static final String SELENIUM_SERVER_URL = "http://127.0.0.1:4444/wd/hub";

	public static final String LOGIN_URL = "https://albiziapp.ozytis.fr/login";
	
	
	
	
	
	/* Constants REGEX */
	
	public static final String REGEX_CTRF031 = "(\\\\((.*?)\\\\))";

	
	
	
	
	/* Constants ASSERT */
	
	//CTRF061
	
	public static final String ASSERT_CTRF061_STYLE = "transform: translate3d(0px, 0px, 0px);";

	
	
	
	
	/* Constants LOGIN */
	
	public static final String LOGIN_OYDREY_EMAIL = "oydrey@gmail.com";
	
	public static final String LOGIN_OYDREY_PASSWORD = "azertyuiop";
	
	public static final String LOGIN_TQL_EMAIL = "tqlgroupe1@gmail.com";
	
	public static final String LOGIN_TQL_PASSWORD = "tqlgroupe1";
	
}