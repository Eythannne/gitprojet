import java.util.Scanner;

public class MasterMind {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rejouer;

        do {
            // Permettre à un deuxième joueur de définir la séquence secrète
            int[] sequenceSecrete = new int[5];
            boolean[] utilise = new boolean[10]; // Pour vérifier si un chiffre est déjà utilisé

            System.out.println("Joueur 2 : Entrez une séquence secrète de 5 chiffres uniques entre 1 et 9 (séparés par des espaces) :");
            for (int i = 0; i < 5; i++) {
                int chiffre;
                do {
                    chiffre = scanner.nextInt();
                    if (chiffre < 1 || chiffre > 9 || utilise[chiffre]) {
                        System.out.println("Chiffre invalide ou déjà utilisé. Essayez à nouveau :");
                    }
                } while (chiffre < 1 || chiffre > 9 || utilise[chiffre]);

                sequenceSecrete[i] = chiffre;
                utilise[chiffre] = true;
            }
            scanner.nextLine(); // Consommer le saut de ligne restant

            System.out.println("La séquence secrète a été définie par le joueur 2 !");

            int tentativesRestantes = 12;
            boolean victoire = false;

            while (tentativesRestantes > 0 && !victoire) {
                System.out.println("\nIl vous reste " + tentativesRestantes + " tentative(s).");
                System.out.println("Proposez une séquence de 5 chiffres (séparés par des espaces) :");

                // Lire la proposition du joueur
                int[] proposition = new int[5];
                for (int i = 0; i < 5; i++) {
                    proposition[i] = scanner.nextInt();
                }

                // Vérifier la proposition
                int bienPlaces = 0;
                int malPlaces = 0;
                boolean[] utiliseDansSecrete = new boolean[5];
                boolean[] utiliseDansProposition = new boolean[5];

                // Vérifier les chiffres bien placés
                for (int i = 0; i < 5; i++) {
                    if (proposition[i] == sequenceSecrete[i]) {
                        bienPlaces++;
                        utiliseDansSecrete[i] = true;
                        utiliseDansProposition[i] = true;
                    }
                }

                // Vérifier les chiffres corrects mais mal placés
                for (int i = 0; i < 5; i++) {
                    if (!utiliseDansProposition[i]) {
                        for (int j = 0; j < 5; j++) {
                            if (!utiliseDansSecrete[j] && proposition[i] == sequenceSecrete[j]) {
                                malPlaces++;
                                utiliseDansSecrete[j] = true;
                                break;
                            }
                        }
                    }
                }

                if (bienPlaces == 5) {
                    victoire = true;
                    System.out.println("\nFélicitations ! Vous avez deviné la séquence secrète !");
                } else {
                    System.out.println("\nIndices :");
                    System.out.println("- Chiffres bien placés : " + bienPlaces);
                    System.out.println("- Chiffres mal placés : " + malPlaces);
                }

                tentativesRestantes--;
            }

            if (!victoire) {
                System.out.println("\nVous avez épuisé toutes vos tentatives. La séquence secrète était : ");
                for (int chiffre : sequenceSecrete) {
                    System.out.print(chiffre + " ");
                }
                System.out.println();
            }

            System.out.println("\nVoulez-vous rejouer ? (oui/non)");
            scanner.nextLine(); // Consommer le saut de ligne restant
            rejouer = scanner.nextLine().trim().toLowerCase();

        } while (rejouer.equals("oui"));

        System.out.println("Merci d'avoir joué au MasterMind. À bientôt !");
        scanner.close();
    }
}