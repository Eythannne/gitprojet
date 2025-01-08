import java.util.Scanner;

public class GestionDeCaisse {

    public static void main(String[] args) {
        String nomProduit;
        Boolean liste = true;
        int payement = 0;
        int prixArticle = 0;
        int prixTotal = 0;
        int nbProduit = 0;
        int prixPayement = 0;
        int reste = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Bonjour");
        while (liste == true) {
            nbProduit ++;
            System.out.println("donnez moi le nom de votre article");
            nomProduit = sc.nextLine();
            System.out.println("donnez moi le prix du " + nomProduit);
            prixArticle = sc.nextInt();
            System.out.println(nomProduit + " " + prixArticle + "€");
            System.out.println("Avez-vous d'autres articles ? (true = oui / false = non");
            liste = sc.nextBoolean();
            sc.skip("\n");
            prixTotal = prixTotal + prixArticle;
        }
        System.out.println("Votre liste d'achat à " +nbProduit+ " produits et est de " +prixTotal+ "€");

        System.out.println("vous avez le choix entre :");
        System.out.println("- carte");
        System.out.println("- espèce");
        System.out.println("Comment voulez vous payer ? (entré 1 pour carte et 2 pour espèce)");

        payement = sc.nextInt();
            if (payement == 1) {
                System.out.println("votre payement de " +prixTotal+ "€ est effectué, passer une bonne journée.");


            } else if (payement == 2) {
                System.out.println("Vous avez choisis le payement en espèce");
                System.out.println("Donner moi le montant a payer qui es : "+prixTotal+ "€");


                while (prixPayement != prixTotal) {
                    prixPayement = sc.nextInt();
                    if (prixPayement < prixTotal) {
                        System.out.println("Le montant n'est pas bon donner moi "+prixTotal+ "€");
                    }
                    else if (prixPayement > prixTotal) {
                        reste = prixPayement - prixTotal;
                        System.out.println("Vous m'avez donné "+prixPayement+ "€ au lieu de " +prixTotal+ "€ je vais donc vous rendre " +reste+ "€");
                        System.out.println("Voici "+reste+"€ passez une bonne journée / j'ai pas eu le temps de finir le details des billets");
                    }
                }
                System.out.println("votre payement de " +prixTotal+ "€ est effectué, passer une bonne journée.");

            }
            else {
                System.out.println("Pas de payement, pas d'article c'est la rêgle, et boum t'avais qu'à payer !");
            }



    }
}
