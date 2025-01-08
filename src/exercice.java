import java.util.Scanner;

public class exercice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//variable
        int nombreEleve;
        int nombreNote;


//Code
        System.out.println("Bonjour, combien d'élève y a t-il ?");
        nombreEleve = scanner.nextInt();
        String[] nomEtudiant = new String[nombreEleve];
        double [] moyenne = new double[nombreEleve];
        System.out.println("d'accord il y aura "+nombreEleve+" élèves");
        System.out.println("Maintenant combien de notes auront ces élèves ?");
        nombreNote = scanner.nextInt();
        double [][] note = new double[nombreEleve][nombreNote];
        double [][] coef = new double[nombreEleve][nombreNote];
        System.out.println("donc il y aura "+nombreEleve+" élèves et "+nombreNote+" notes par élèves.");

        for (int i = 0; i < nombreEleve; i++) {
            System.out.println("Entrez le nom de l'élève n°" + (i + 1) + " :");
            scanner.skip("\n");
            nomEtudiant[i] = scanner.nextLine();

            double sommeNote = 0;
            double sommeCoef = 0;

            System.out.println("Entrez les notes et coefficients de " + nomEtudiant[i] + " :");
            for (int j = 0; j < nombreNote; j++) {
                System.out.println("Entrez la note " + (j + 1) + " :");
                note[i][j] = scanner.nextDouble();
                System.out.println("Entrez le coefficient de la note " + (j + 1) + " :");
                coef[i][j] = scanner.nextDouble();

                sommeNote += note[i][j] * coef[i][j];
                sommeCoef += coef[i][j];
            }

            moyenne[i] = sommeNote / sommeCoef;
        }

        for (int i = 0; i < nombreEleve; i++) {
            System.out.println("Elève : " + nomEtudiant[i]);
            for (int j = 0; j < nombreNote; j++) {
                System.out.println("Note " + (j + 1) + " - " + note[i][j] + " / Coef - " + coef[i][j]);
            }
            System.out.println("Moyenne : " + moyenne[i]);
            System.out.println();
        }

        for (int i = 0; i < nombreEleve - 1; i++) {
            for (int j = i + 1; j < nombreEleve; j++) {
                if (moyenne[i] < moyenne[j]) {

                    String echangeNom = nomEtudiant[i];
                    nomEtudiant[i] = nomEtudiant[j];
                    nomEtudiant[j] = echangeNom;

                    double echangeMoyenne = moyenne[i];
                    moyenne[i] = moyenne[j];
                    moyenne[j] = echangeMoyenne;

                    double[] echangeNote = note[i];
                    note[i] = note[j];
                    note[j] = echangeNote;

                    double[] echangeCoef = coef[i];
                    coef[i] = coef[j];
                    coef[j] = echangeCoef;
                }
            }
        }


        System.out.println("Voici le classement des élève de la meilleure à la moins bonne moyenne :");
        for (int i = 0; i < nombreEleve; i++) {
            System.out.println((i + 1) + ". " + nomEtudiant[i] + " : " + moyenne[i]);
        }

    }
}
