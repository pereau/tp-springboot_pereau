package com.igs.ipi.tpspringbootPereauAlban.Model;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name="puissance4")
public class GameModel {


    @Id
    //@GeneratedValue(strategy = AUTO)
    @Column
    private long id;

    @Column(length = 50, nullable = false, unique = false)
    private String nom1;
    @Column(length = 50, nullable = false, unique = false)
    private String nom2;

    @Column(length = 50, nullable = false, unique = false)
    private String joueurActuel;
    @Column(length = 50, nullable = false, unique = false)
    private String gagnant="aucun";
    private int suite=0;



    private static final int LARGEUR = 7;
    private static final int HAUTEUR = 6;

    // création d'un tableau de dimension 7*6


    private String[][] tabJeu;

    {
        tabJeu = new String[HAUTEUR][LARGEUR];

    }


   public GameModel (Integer i,String joueur1, String joueur2, String joueurActuel,String gagnant) {
	   
	   this.id=i;
	   this.nom1=joueur1;
	   this.nom1=joueur2;
	   this.joueurActuel=joueurActuel;
	   this.gagnant=gagnant;
	   
	   
   }
    
    public GameModel() { //Le tableau tabJeu est créé en même temps que l'instance de GameModel
        for (int i=0 ; i<tabJeu.length ;i++) {
            for (int j = 0; j < tabJeu[i].length; j++) {
                tabJeu[i][j] = "vide";

            }
        }
    }


    public void tourSuivant() {


        if (this.joueurActuel.equals(this.getNom1())){

                    setJoueurActuel(this.getNom2());
        }

        else if (this.joueurActuel.equals(this.getNom2())){

            setJoueurActuel(this.getNom1());
        }

    }

    public void ajoutJeton(int colonne){// entier de 1 à 7 tandis que l'indice des colonnes va de 0 à 6




        int i=0;





        while (this.tabJeu[i][colonne - 1].equals("vide") && (i < 6) && (this.gagnant.equals("aucun"))) {
           if (!this.tabJeu[i+1][colonne-1].equals("vide") ){
               this.tabJeu[i][colonne-1]=this.joueurActuel;
               partieGagne(i,colonne-1);
            }
           if (this.tabJeu[i+1][colonne-1].equals("vide") && i==4 ){
               this.tabJeu[i+1][colonne-1]=this.joueurActuel ;
               partieGagne(i+1,colonne-1);
            }
            i+=1;
        }

    }


    public void partieGagne(int ligne, int col){
        int ligneHaut = ligne;
        int colDroite = col ;
        int ligneBas = ligne;
        int colGauche = col;
        String joueur = this.tabJeu[ligne][col];
        int nbJetonsConsecutifs=1;

        boolean cont;
        cont = true;
        this.suite = nbJetonsConsecutifs;
       // Alignement horizontal
        while (cont){

            if (colDroite!=col) {
                nbJetonsConsecutifs += 1;
            }

            if (nbJetonsConsecutifs==4){
                this.gagnant = this.joueurActuel;
            }

            colDroite = colDroite + 1;

            if (colDroite>=LARGEUR) {
                cont=false;
            }
            else if (!this.tabJeu[ligne][colDroite].equals(joueur) ){
                cont = false;
            }

        }
        cont = true;
        while(cont){

            if (colGauche!=col) {
                nbJetonsConsecutifs+=1;
             }

            if (nbJetonsConsecutifs==4){
                this.gagnant = this.joueurActuel;
            }


            colGauche = colGauche - 1;

            if (colGauche<0) {
                cont=false;
            }
            else if (!this.tabJeu[ligne][colGauche].equals(joueur) ){
                cont = false;
            }

        }


        this.suite=nbJetonsConsecutifs;
        // Alignement horizontal
        ligneHaut = ligne;
        colDroite = col ;
        ligneBas = ligne;
        colGauche = col;
        nbJetonsConsecutifs = 1;
        this.suite=nbJetonsConsecutifs;
        cont = true;
        while (cont){

            if (ligneBas!=ligne) {
                nbJetonsConsecutifs += 1;
            }

            if (nbJetonsConsecutifs==4){
                this.gagnant = this.joueurActuel;
            }

            ligneBas = ligneBas + 1;

            if (ligneBas>=HAUTEUR) {
                cont=false;
            }
            else if (!this.tabJeu[ligneBas][col].equals(joueur) ){
                cont = false;
            }

        }
        cont = true;
        while(cont){

            if (ligneHaut!=ligne) {
                nbJetonsConsecutifs+=1;
            }

            if (nbJetonsConsecutifs==4){
                this.gagnant = this.joueurActuel;
            }


            ligneHaut = ligneHaut - 1;

            if (ligneHaut<0) {
                cont=false;
            }
            else if (!this.tabJeu[ligneHaut][col].equals(joueur) ){
                cont = false;
            }

        }
        this.suite=nbJetonsConsecutifs;
        // Alignement diagonal_croissant // croissant dans le sens visuel : on monte dans les cases lorqu'on se déplace à droite
        ligneHaut = ligne;
        colDroite = col ;
        ligneBas = ligne;
        colGauche = col;
        nbJetonsConsecutifs = 1;
        this.suite=nbJetonsConsecutifs;
        cont = true;
        while (cont){

            if (ligneHaut!=ligne && colDroite!=col) {
                nbJetonsConsecutifs += 1;
            }

            if (nbJetonsConsecutifs==4){
                this.gagnant = this.joueurActuel;
            }

            ligneHaut = ligneHaut - 1;
            colDroite = colDroite+1;

            if (ligneHaut < 0 || colDroite >= LARGEUR) {
                cont=false;
            }
            else if (!this.tabJeu[ligneHaut][colDroite].equals(joueur) ){
                cont = false;
            }

        }
        cont = true;
        while(cont){

            if (ligneBas!=ligne && colGauche!=col) {
                nbJetonsConsecutifs+=1;
            }

            if (nbJetonsConsecutifs==4){
                this.gagnant = this.joueurActuel;
            }


            ligneBas = ligneBas + 1;
            colGauche = colGauche -1;

            if (ligneBas >= HAUTEUR || colGauche < 0) {
                cont=false;
            }
            else if (!this.tabJeu[ligneBas][colGauche].equals(joueur) ){
                cont = false;
            }

        }

        this.suite=nbJetonsConsecutifs;

        // Alignement diagonal_decroissant : visuellement, on descent lorqu'on se déplace vers la droite
        ligneHaut = ligne;
        colDroite = col ;
        ligneBas = ligne;
        colGauche = col;
        nbJetonsConsecutifs = 1;
        this.suite=nbJetonsConsecutifs;
        cont = true;
        while (cont){

            if (ligneHaut!=ligne && colGauche!=col) {
                nbJetonsConsecutifs += 1;
            }

            if (nbJetonsConsecutifs==4){
                this.gagnant = this.joueurActuel;
            }

            ligneHaut = ligneHaut - 1;
            colGauche = colGauche-1;

            if (ligneHaut < 0 || colGauche < 0) {
                cont=false;
            }
            else if (!this.tabJeu[ligneHaut][colGauche].equals(joueur) ){
                cont = false;
            }

        }
        cont = true;
        while(cont){

            if (ligneBas!=ligne && colDroite!=col) {
                nbJetonsConsecutifs+=1;
            }

            if (nbJetonsConsecutifs==4){
                this.gagnant = this.joueurActuel;
            }


            ligneBas = ligneBas + 1;
            colDroite = colDroite +1;

            if (ligneBas >= HAUTEUR || colDroite >= LARGEUR) {
                cont=false;
            }
            else if (!this.tabJeu[ligneBas][colDroite].equals(joueur) ){
                cont = false;
            }

        }

        this.suite=nbJetonsConsecutifs;

    }


    public String getNom1() {
        return nom1;
    }

    public void setNom1(String nom1) {
        this.nom1 = nom1;
    }

    public String getNom2() {
        return nom2;
    }

    public void setNom2(String nom2) {
        this.nom2 = nom2;
    }

    public String getJoueurActuel() {
        return joueurActuel;
    }

    public String getGagnant() {
        return gagnant;
    }

    public void setGagnant(String gagnant) {
        this.gagnant = gagnant;
    }

    public void setJoueurActuel(String joueurActuel) {
        this.joueurActuel = joueurActuel;
    }
}
