import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bonjour joueur 1, entrez un pseudo :");
        String joueur1 = scanner.nextLine();
        System.out.println("Bonjour joueur 2, entrez un pseudo :");
        String joueur2 = scanner.nextLine();
        System.out.println(joueur1 + " vous etes les 'X'");
        System.out.println(joueur2 + " vous etes les 'O'");
        System.out.println(joueur1 + " VS " + joueur2);

        char [][] tableau = {
                {' ',' ',' '},
                {' ',' ',' '},
                {' ',' ',' '},
        };

        char charX ='X';
        int boucle = 4;
        for (int i = 0; i < boucle; i++) {

            System.out.println(joueur1 + " choisis entre 0 / 1 / 2 pour la ligne :");
            int junlig = scanner.nextInt();
            System.out.println("maintenant choisi entre 0 / 1 / 2 pour la colone :");
            int juncol = scanner.nextInt();

            for (int k = 0; k < tableau.length; k++) {
                for (int j = 0; j < tableau[k].length; j++) {
                    System.out.print(" " + tableau[k][j] + " ");
                    if (j < tableau[k].length - 1) {
                        System.out.print("|");
                    }
                }
                System.out.println();
                if (k < tableau.length - 1) {
                    System.out.println("|");
                }

            System.out.println();
            if (i < tableau.length - 1) {
                System.out.println("---+---+---");
                }
            }
            if (junlig == 0 && juncol == 0) {
                System.out.println("Haut / Gauche");
                tableau [1][1] = charX;
            } else if (junlig == 0 && juncol == 1) {
                System.out.println("Haut / Milieu");
            } else if (junlig == 0 && juncol == 2) {
                System.out.println("Haut / Droite");
            } else if (junlig == 1 && juncol == 0) {
                System.out.println("Milieu / Gauche");
            } else if (junlig == 1 && juncol == 1) {
                System.out.println("Milieu / Milieu");
            } else if (junlig == 1 && juncol == 2) {
                System.out.println("Milieu / Droite");
            } else if (junlig == 2 && juncol == 0) {
                System.out.println("Bas / Gauche");
            } else if (junlig == 2 && juncol == 1) {
                System.out.println("Bas / Milieu");
            } else if (junlig == 2 && juncol == 2) {
                System.out.println("Bas / Droite");
            }


            System.out.println(joueur2 + " choisis entre 0 / 1 / 2 pour la ligne :");
            int jdelig = scanner.nextInt();
            System.out.println("maintenant choisi entre 0 / 1 / 2 pour la colone :");
            int jdecol = scanner.nextInt();

            if (jdelig == 0 && jdecol == 0) {
                System.out.println("Haut / Gauche");
            } else if (jdelig == 0 && jdecol == 1) {
                System.out.println("Haut / Milieu");
            } else if (jdelig == 0 && jdecol == 2) {
                System.out.println("Haut / Droite");
            } else if (jdelig == 1 && jdecol == 0) {
                System.out.println("Milieu / Gauche");
            } else if (jdelig == 1 && jdecol == 1) {
                System.out.println("Milieu / Milieu");
            } else if (jdelig == 1 && jdecol == 2) {
                System.out.println("Milieu / Droite");
            } else if (jdelig == 2 && jdecol == 0) {
                System.out.println("Bas / Gauche");
            } else if (jdelig == 2 && jdecol == 1) {
                System.out.println("Bas / Milieu");
            } else if (jdelig == 2 && jdecol == 2) {
                System.out.println("Bas / Droite");
            }
        }
    }
}