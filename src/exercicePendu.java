import java.util.Scanner;

public class exercicePendu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Étape 1 : Joueur 1 entre le mot à deviner
        System.out.print("Joueur 1, entrez un mot à deviner : ");
        String motADeviner = scanner.nextLine().toUpperCase();
        System.out.print("Confirmez-vous le mot '" +motADeviner+ "' ? (oui/non) : ");
        String confirmation = scanner.nextLine().toLowerCase();

        while (!confirmation.equals("oui")) {
            System.out.print("Entrez un nouveau mot : ");
            motADeviner = scanner.nextLine().toUpperCase();
            System.out.print("Confirmez-vous le mot '" +motADeviner+ "' ? (oui/non) : ");
            confirmation = scanner.nextLine().toLowerCase();
        }

        char[] motCache = new char[motADeviner.length()];
        for (int i = 0; i < motCache.length; i++) {
            motCache[i] = '_';
        }

        int essaisRestants = 9;
        boolean motTrouve = false;
        String lettresProposees = "";

        // Étape 2 : Joueur 2 essaie de deviner le mot
        while (essaisRestants > 0 && !motTrouve) {
            System.out.println("\nMot à deviner ("+essaisRestants+" essais restants) : " + new String(motCache));
            afficherPendu(9 - essaisRestants); // Affiche le dessin du pendu
            System.out.print("1 - proposer une lettre");
            System.out.print("\n2 - proposer un mot");
            System.out.print("\nJoueur 2, à votre tour, vous voulez proposer une lettre ou un mot (1/2): ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            if (choix == 1) {
                System.out.print("Proposez une lettre : ");
                char lettre = scanner.nextLine().toUpperCase().charAt(0);

                if (lettresProposees.indexOf(lettre) != -1) {
                    System.out.println("Cette lettre a déjà été proposée.");
                    continue;
                }

                lettresProposees += lettre;
                boolean lettreTrouvee = false;
                for (int i = 0; i < motADeviner.length(); i++) {
                    if (motADeviner.charAt(i) == lettre) {
                        motCache[i] = lettre;
                        lettreTrouvee = true;
                    }
                }

                if (!lettreTrouvee) {
                    essaisRestants--;
                }
            } else if (choix == 2) {
                System.out.print("Proposez un mot : ");
                String motPropose = scanner.nextLine().toUpperCase();

                if (motPropose.equals(motADeviner)) {
                    motTrouve = true;
                    break;
                } else {
                    System.out.println("Le mot proposé est incorrect.");
                    essaisRestants--;
                }
            } else {
                System.out.println("Choix invalide.");
            }

            motTrouve = new String(motCache).equals(motADeviner);
        }

        // Fin de la partie
        if (motTrouve) {
            System.out.println("\nFélicitations ! Joueur 2 a trouvé le mot : " + motADeviner);
        } else {
            afficherPendu(9);
            System.out.println("\nDommage ! Le mot à deviner était : " + motADeviner);
        }

        // Relancer une nouvelle partie
        System.out.print("Voulez-vous relancer une partie ? (oui/non) : ");
        String relancer = scanner.nextLine().toLowerCase();
        if (relancer.equals("oui")) {
            main(args);
        } else {
            System.out.println("C'est la fin du jeu, j'espère que tu as passés un bon moment !");
            System.out.println("Tu peux revenir jouer dès que tu le veux.");
            System.out.println("A très vite ! :)");
        }

        scanner.close();
    }

    // Méthode pour afficher le dessin du pendu
    public static void afficherPendu(int etape) {
        switch (etape) {
            case 1:
                System.out.println("      ");
                System.out.println("      ");
                System.out.println("       ");
                System.out.println("       ");
                System.out.println("    ===");
                break;
            case 2:
                System.out.println("     +");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("    ===");
                break;
            case 3:
                System.out.println(" +---+");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("    ===");
                break;
            case 4:
                System.out.println(" +---+");
                System.out.println(" O   |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("    ---");
                break;
            case 5:
                System.out.println(" +---+");
                System.out.println(" O   |");
                System.out.println(" |   |");
                System.out.println("     |");
                System.out.println("    ===");
                break;
            case 6:
                System.out.println(" +---+");
                System.out.println(" O   |");
                System.out.println("/|   |");
                System.out.println("     |");
                System.out.println("    ===");
                break;
            case 7:
                System.out.println(" +---+");
                System.out.println(" O   |");
                System.out.println("/|\\  |");
                System.out.println("     |");
                System.out.println("    ===");
                break;
            case 8:
                System.out.println(" +---+");
                System.out.println(" O   |");
                System.out.println("/|\\  |");
                System.out.println("/    |");
                System.out.println("    ===");
                break;
            case 9:
                System.out.println(" +---+");
                System.out.println(" O   |");
                System.out.println("/|\\  |");
                System.out.println("/ \\  |");
                System.out.println("    ===");
                break;
        }
    }
}
