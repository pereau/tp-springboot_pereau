package com.igs.ipi.tpspringbootPereauAlban.Model;


public class GameModel {

    private String nom1;
    private String nom2;

    private static final int LARGEUR = 7;
    private static final int HAUTEUR = 6;

    // création d'un tableau de dimension 7*6

    private String[][] tabJeu;

    {
        tabJeu = new String[HAUTEUR][LARGEUR];

    }



    public GameModel() {
        for (int i=0 ; i<tabJeu.length ;i++) {
            for (int j = 0; j < tabJeu[i].length; j++) {
                tabJeu[i][j] = "vide";
            }
        }
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
}
