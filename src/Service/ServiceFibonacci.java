/**
 * Le package {@code Service} contient les classes responsables de la logique métier de l'application.
 *
 * Ce package inclut notamment la classe {@code ServiceFibonacci}, qui fournit des méthodes
 * pour effectuer des calculs sur la suite de Fibonacci de manière itérative ou récursive, ainsi que
 * pour mesurer la durée de ces calculs.
 *
 * @version 2.0
 * @author Mourad Chikhi
 * @author Kazumi Watanabi Target
 */
package Service;

import java.math.BigInteger;

/**
 * La classe {@code ServiceFibonacci} fournit des services pour :
 * <ul>
 *     <li>Calculer et afficher les termes de la suite de Fibonacci de manière itérative.</li>
 *     <li>Calculer et afficher les termes de la suite de Fibonacci de manière récursive.</li>
 *     <li>Mesurer le temps d'exécution des calculs effectués.</li>
 * </ul>
 *
 * @version 2.0
 * @author Mourad Chikhi
 * @author Kazumi Watanabi Target
 */
public class ServiceFibonacci {
    /**
     * Temps de début du calcul, en nanosecondes.
     */
    private long debutCalcul;

    /**
     * Temps de fin du calcul, en nanosecondes.
     */
    private long finCalcul;

    /**
     * Constructeur par défaut de la classe {@code ServiceFibonacci}.
     * Initialise les attributs {@code debutCalcul} et {@code finCalcul} à zéro.
     */
    public ServiceFibonacci() {
        this.debutCalcul = 0;
        this.finCalcul = 0;
    }

    /**
     * Obtient le temps de début du calcul.
     *
     * @return le temps de début du calcul, en nanosecondes
     */
    public long getDebutCalcul() {
        return debutCalcul;
    }

    /**
     * Définit le temps de début du calcul.
     *
     * @param debutCalcul le temps de début du calcul, en nanosecondes
     */
    public void setDebutCalcul(long debutCalcul) {
        this.debutCalcul = debutCalcul;
    }

    /**
     * Obtient le temps de fin du calcul.
     *
     * @return le temps de fin du calcul, en nanosecondes
     */
    public long getFinCalcul() {
        return finCalcul;
    }

    /**
     * Définit le temps de fin du calcul.
     *
     * @param finCalcul le temps de fin du calcul, en nanosecondes
     */
    public void setFinCalcul(long finCalcul) {
        this.finCalcul = finCalcul;
    }

    /**
     * Calcule et affiche les termes de la suite de Fibonacci jusqu'à un nombre donné en paramètre.
     * Cette méthode utilise une approche itérative pour optimiser les performances.
     * Elle enregistre les moments de début et de fin de l'exécution.
     *
     * @param termes le nombre de termes de la suite de Fibonacci à calculer et à afficher
     */
    public void calculerSuiteFibonacciIterative(int termes) {
        this.debutCalcul = System.nanoTime();
        BigInteger termeA = BigInteger.valueOf(0);
        BigInteger termeB = BigInteger.valueOf(1);
        BigInteger termeSuivant;

        for (int i = 0; i < termes; i++) {
            System.out.print(termeA + (i < termes - 1 ? ", " : " "));
            termeSuivant = termeA.add(termeB);
            termeA = termeB;
            termeB = termeSuivant;
        }

        this.finCalcul = System.nanoTime();
    }

    /**
     * Calcule le n-ième terme de la suite de Fibonacci de manière récursive.
     *
     * @param terme l'indice du terme à calculer (doit être un entier non négatif)
     * @return le n-ième terme de la suite de Fibonacci
     */
    public BigInteger calculerTermeFibonacciRecursive(int terme) {
        if (terme <= 1) {
            return BigInteger.valueOf(terme);
        }
        return calculerTermeFibonacciRecursive(terme - 1).add(calculerTermeFibonacciRecursive(terme - 2));

    }

    /**
     * Calcule et affiche un nombre donné de termes de la suite de Fibonacci.
     * Cette méthode fait appel à {@code calculerTermeFibonacciRecursive} pour calculer chaque terme.
     * Elle enregistre les moments de début et de fin de l'exécution.
     *
     * @param termes le nombre de termes de la suite de Fibonacci à calculer et à afficher
     */
    public void calculerSuiteFibonacciRecursive(int termes) {
        this.debutCalcul = System.nanoTime();

        for (int i = 0; i < termes; i++) {
            System.out.print(this.calculerTermeFibonacciRecursive(i) + (i < termes - 1 ? ", " : " "));
        }

        this.finCalcul = System.nanoTime();
    }

    /**
     * Calcule la durée d'exécution du calcul de la suite de Fibonacci, en microsecondes.
     *
     * @return la durée d'exécution en microsecondes
     */
    public long calculerDureeExecution() {
        return (this.finCalcul - this.debutCalcul) / 1000; // Conversion de nanosecondes en microsecondes
    }
}
