/**
 * Le package {@code Vue} contient les classes qui gèrent l'interaction utilisateur
 * et l'affichage des données liées au service Fibonacci.
 *
 * Ce package inclut la classe {@code VueFibonacci}, qui fournit une interface console permettant
 * à l'utilisateur de choisir parmi différentes options pour calculer et afficher la suite de Fibonacci.
 *
 * @version 2.0
 * @author Mourad Chikhi
 * @author Kazumi Watanabi Target
 */
package Vue;

import Service.ServiceFibonacci;

import java.util.Scanner;

/**
 * La classe {@code VueFibonacci} fournit une interface utilisateur pour exécuter les
 * différents services liés à la suite de Fibonacci.
 * Elle permet de calculer la suite de Fibonacci en utilisant les méthodes itérative
 * et récursive, de comparer leurs performances, et d'afficher les résultats à l'utilisateur.
 *
 * @version 1.0
 * @author Marc
 * @author Jacques
 */
public class VueFibonacci {

    /**
     * Instance du service de calcul pour la suite de Fibonacci.
     */
    private ServiceFibonacci serviceFibonacci;

    /**
     * Constructeur par défaut de la classe {@code VueFibonacci}.
     * Initialise l'instance de {@code ServiceFibonacci}.
     */
    public VueFibonacci() {
        this.serviceFibonacci = new ServiceFibonacci();
    }

    /**
     * Méthode principale pour interagir avec l'utilisateur.
     * Elle affiche un menu permettant de choisir parmi plusieurs options :
     * <ul>
     *     <li>1 : Calcul de la suite de Fibonacci par la méthode itérative.</li>
     *     <li>2 : Calcul de la suite de Fibonacci par la méthode récursive.</li>
     *     <li>3 : Comparaison des durées d'exécution entre les deux méthodes.</li>
     *     <li>4 : Quitter le programme.</li>
     * </ul>
     *
     * Pour les options 1, 2, et 3, l'utilisateur doit fournir un entier positif
     * représentant le nombre de termes de la suite à calculer.
     * Les résultats et les durées d'exécution sont affichés.
     */
    public void executerServiceFibonacci() {
        int option = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n***************** Service Suite Fibonacci **************\n");

        while (option == -1) {
            System.out.println("##################################################");
            System.out.println("Choisissez l'une des options suivantes : \n");
            System.out.println("1. Calculer une suite de Fibonacci par la méthode itérative;");
            System.out.println("2. Calculer une suite de Fibonacci par la méthode récursive;");
            System.out.println("3. Calculer en utilisant les deux méthodes et comparer la durée d'exécution;");
            System.out.println("4. Quitter le programme.\n");
            System.out.println("Votre choix : ");

            try {
                option = sc.nextInt();

                // Vérification de l'entrée
                if (option == 1 || option == 2 || option == 3) {
                    int termes = -1;

                    while (termes < 0) {
                        System.out.println("Entrer le nombre de termes à calculer (Si calcul récursif entier positif <= 40) : ");
                        try {
                            termes = sc.nextInt();

                            if (termes < 0) {
                                System.out.println("Erreur : Il faut entrer un entier positif.");
                            }
                        } catch (Exception e) {
                            System.out.println("Erreur : Il faut entrer un entier valide.");
                            sc.next(); // Consomme l'entrée invalide
                        }
                    }

                    if (option == 1) {
                        System.out.println("\n-------- Série de Fibonacci itérative : " + termes + " termes---------");
                        serviceFibonacci.calculerSuiteFibonacciIterative(termes);
                        System.out.println("\n\nDurée d'exécution :");
                        System.out.println(this.serviceFibonacci.calculerDureeExecution() + " microsecondes");
                    } else if (option == 2) {
                        System.out.println("\n--------- Série de Fibonacci récursive : " + termes + " termes---------");
                        serviceFibonacci.calculerSuiteFibonacciRecursive(termes);
                        System.out.println("\n\n-Durée d'exécution :");
                        System.out.println(this.serviceFibonacci.calculerDureeExecution() + " microsecondes");

                    } else {
                        System.out.println("\n-------- Série de Fibonacci itérative : " + termes + " termes----------");
                        serviceFibonacci.calculerSuiteFibonacciIterative(termes);
                        System.out.println("\n\n-Durée d'exécution de la méthode itérative :");
                        double dureeIterative = serviceFibonacci.calculerDureeExecution();
                        System.out.println(dureeIterative + " microsecondes");

                        System.out.println("\n--------- Série de Fibonacci récursive : " + termes + " termes---------");
                        serviceFibonacci.calculerSuiteFibonacciRecursive(termes);
                        System.out.println("\n-Durée d'exécution de la méthode récursive :");
                        double dureeRecursive = serviceFibonacci.calculerDureeExecution();
                        System.out.println(dureeRecursive + " microsecondes");

                        System.out.println("\n--------- Comparaison des durées de traitement ----------");
                        if (dureeRecursive < dureeIterative) {
                            System.out.println("La méthode récursive a été plus rapide");
                        } else if (dureeRecursive > dureeIterative) {
                            System.out.println("La méthode itérative a été plus rapide");
                        } else {
                            System.out.println("La durée de traitement est la même pour les deux méthodes");
                        }

                    }
                } else if (option == 4) {
                    System.out.println("Programme terminé. À bientôt !");
                    break;
                } else {
                    System.out.println("Erreur : entrez 1, 2, 3 ou 4 : \n");
                }
            } catch (Exception e) {
                System.out.println("Erreur : Entrez 1, 2, 3 ou 4");
                sc.next(); // Consomme l'entrée invalide
            }
            finally {
                option = -1;
            }
        }
    }
}
