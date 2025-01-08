import java.util.Scanner;

public class exerciceJustePrix {

    public static void main(String[] args) {
        int prix;
        int num;
        int tour = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("J1 - choisis un nombre entre 10000 et 50000 ");
        prix = sc.nextInt();
        while (prix < 10000 || prix > 50000) {
            System.out.println("Erreur - le nombre" + prix + "n'est pas entre 10000 et 50000");
            System.out.println("Saisir un nombre entre 10000 et 50000");
            prix = sc.nextInt();
        }
        System.out.println("J2 - Tu dois réussir a trouver le nombre choisis par le J-1");
        System.out.println("Saisis un nombre entre 10000 et 50000");
        num = sc.nextInt();
        while (num != prix) {
            tour ++;

            if (num < prix) {
                System.out.println("PLUS");
            } else if (num > prix) {
                System.out.println("MOINS");
            }
            num = sc.nextInt();
        }
        System.out.println("Bravo tu as trouvé le bon numéro en " +tour+ " coups");

    }
}