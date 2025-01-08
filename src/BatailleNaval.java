import java.util.Scanner;

public class BatailleNaval {

    //TODO : Toucher - Couler
    //TODO : faire les statistiques (nombre de parties jouer, nombre de victoire par joueur)
    //TODO : verifier ligne 198  "nbPartie ++"


    public static void main(String[] args) {

        final int TAILLE_GRILLE = 10;
        char[][] grilleJoueur1 = new char[TAILLE_GRILLE][TAILLE_GRILLE];
        char[][] grilleJoueur2 = new char[TAILLE_GRILLE][TAILLE_GRILLE];
        int[] bateauxJoueur1 = {5, 4, 3, 3, 2};
        int[] bateauxJoueur2 = {5, 4, 3, 3, 2};
        int nbPartie = 0;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < TAILLE_GRILLE; i++) {
            for (int j = 0; j < TAILLE_GRILLE; j++) {
                grilleJoueur1[i][j] = ' ';
                grilleJoueur2[i][j] = ' ';
            }
        }
        System.out.println("Entrez le nom du joueur 1:");
        String joueur1 = scanner.nextLine();
        System.out.println("Entrez le nom du joueur 2:");
        String joueur2 = scanner.nextLine();

        afficherGrille(grilleJoueur1);
        for (int i = 0; i < bateauxJoueur1.length; i++) {
            int tailleBateau = bateauxJoueur1[i];
            System.out.println(joueur1 + ", placez un bateau de taille " + tailleBateau);
            boolean bateauPlace = false;
            while (!bateauPlace) {
                System.out.println("Entrez les coordonnées du bateau (ex: A1H / H pour horizontal, V pour vertical) :");
                String coord = scanner.nextLine();
                int x = coord.charAt(1) - '0';
                int y = coord.charAt(0) - 'A';
                String orientation = coord.substring(2).toUpperCase();

                if (orientation.equals("H") && y + tailleBateau <= TAILLE_GRILLE) {
                    boolean valid = true;
                    for (int j = 0; j < tailleBateau; j++) {
                        if (grilleJoueur1[x][y + j] != ' ') {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) {
                        for (int j = 0; j < tailleBateau; j++) {
                            grilleJoueur1[x][y + j] = '#';
                        }
                        bateauPlace = true;
                        afficherGrille(grilleJoueur1);
                    }
                } else if (orientation.equals("V") && x + tailleBateau <= TAILLE_GRILLE) {
                    boolean valid = true;
                    for (int j = 0; j < tailleBateau; j++) {
                        if (grilleJoueur1[x + j][y] != ' ') {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) {
                        for (int j = 0; j < tailleBateau; j++) {
                            grilleJoueur1[x + j][y] = '#';
                        }
                        bateauPlace = true;
                        afficherGrille(grilleJoueur1);
                    }
                }
                if (!bateauPlace) {
                    System.out.println("Placement invalide, essayez à nouveau.");
                }
            }
        }
        int temp = 40;
        for (int i = 0; i < temp; i++) {
            System.out.println(" ");
        }
        afficherGrille(grilleJoueur2);
        for (int i = 0; i < bateauxJoueur2.length; i++) {
            int tailleBateau = bateauxJoueur2[i];
            System.out.println(joueur2 + ", placez un bateau de taille " + tailleBateau);
            boolean bateauPlace = false;
            while (!bateauPlace) {
                System.out.println("Entrez les coordonnées du bateau (ex: A1H / H pour horizontal, V pour vertical) :");
                String coord = scanner.nextLine();
                int x = Character.getNumericValue(coord.charAt(1)); // Lecture directe sans décalage

                int y = coord.charAt(0) - 'A';
                String orientation = coord.substring(2).toUpperCase();

                if (orientation.equals("H") && y + tailleBateau <= TAILLE_GRILLE) {
                    boolean valid = true;
                    for (int j = 0; j < tailleBateau; j++) {
                        if (grilleJoueur2[x][y + j] != ' ') {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) {
                        for (int j = 0; j < tailleBateau; j++) {
                            grilleJoueur2[x][y + j] = '#';
                        }
                        bateauPlace = true;
                        afficherGrille(grilleJoueur2);
                    }
                } else if (orientation.equals("V") && x + tailleBateau <= TAILLE_GRILLE) {
                    boolean valid = true;
                    for (int j = 0; j < tailleBateau; j++) {
                        if (grilleJoueur2[x + j][y] != ' ') {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) {
                        for (int j = 0; j < tailleBateau; j++) {
                            grilleJoueur2[x + j][y] = '#';
                        }
                        bateauPlace = true;
                        afficherGrille(grilleJoueur2);
                    }
                }
                if (!bateauPlace) {
                    System.out.println("Placement invalide, essayez à nouveau.");
                }
            }
        }
        for (int i = 0; i < temp; i++) {
            System.out.println(" ");
        }

        // Lancement de la partie
        boolean partieEnCours = true;
        int tour = 0;
        while (partieEnCours) {
            String joueurActuel = (tour % 2 == 0) ? joueur1 : joueur2;
            char[][] grilleActuelle = (tour % 2 == 0) ? grilleJoueur2 : grilleJoueur1;
            System.out.println(joueurActuel + ", à vous de jouer !");

            System.out.println("  A B C D E F G H I J");
            for (int i = 0; i < TAILLE_GRILLE; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < TAILLE_GRILLE; j++) {
                    if (grilleActuelle[i][j] == '#') {
                        System.out.print("  ");
                    } else {
                        System.out.print(grilleActuelle[i][j] + " ");
                    }
                }
                System.out.println();
            }

            System.out.println("Entrez les coordonnées du tir (ex: A5) :");
            String tir = scanner.nextLine();
            int x = tir.charAt(1) - '0';
            int y = tir.charAt(0) - 'A';

            if (x < 0 || x >= TAILLE_GRILLE || y < 0 || y >= TAILLE_GRILLE) {
                System.out.println("Coordonnées invalides. Essayez à nouveau.");
                continue;
            }

            if (grilleActuelle[x][y] == 'X' || grilleActuelle[x][y] == 'O') {
                System.out.println("Vous avez déjà tiré ici !");
                continue;
            }

            if (grilleActuelle[x][y] == '#') {
                grilleActuelle[x][y] = 'X';
                System.out.println("Touché !");
            } else if (grilleActuelle[x][y] == ' ') {
                grilleActuelle[x][y] = 'O';
                System.out.println("Plouf !");
            }

            // Vérification de la victoire
            boolean victoire = true;
            for (int i = 0; i < TAILLE_GRILLE; i++) {
                for (int j = 0; j < TAILLE_GRILLE; j++) {
                    if (grilleActuelle[i][j] == '#') {
                        victoire = false;
                        break;
                    }
                }
            }

            if (victoire) {
                System.out.println(joueurActuel + " a gagné !");
                partieEnCours = false;

                System.out.println("Voulez-vous rejouer ? (O/N)");
                String reponse = scanner.nextLine().toUpperCase();
                if (reponse.equals("O")) {
                    nbPartie ++;
                    main(args);
                    return;
                } else {
                    System.out.println("Merci d'avoir joué ! À bientôt.");
                    scanner.close();
                    return;
                }
            }

            tour++;
        }
        scanner.close();
    }

    // Fonction pour afficher la grille
    public static void afficherGrille(char[][] grille) {
        System.out.println("  A B C D E F G H I J");
        for (int i = 0; i < grille.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < grille[i].length; j++) {
                System.out.print(grille[i][j] + " ");
            }
            System.out.println();
        }
    }
}
