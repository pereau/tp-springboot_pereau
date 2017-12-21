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



    public GameModel() { //Le tableau tabJeu est créé en même temps que l'instance de GameModel
        for (int i=0 ; i<tabJeu.length ;i++) {
            for (int j = 0; j < tabJeu[i].length; j++) {
                tabJeu[i][j] = "vide";

            }
        }
    }

    public void ajoutJeton(int colonne){// entier de 1 à 7 tandis que l'indice des colonnes va de 0 à 6


        int i=0;
        while (this.tabJeu[i][colonne - 1].equals("vide") && (i < 6)) {


           if (this.tabJeu[i+1][colonne-1].equals("rempli") ){

                this.tabJeu[i][colonne-1]="rempli";

            }

           if (this.tabJeu[i+1][colonne-1].equals("vide") && i==4 ){

                this.tabJeu[i+1][colonne-1]="rempli";

            }

            i+=1;
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
