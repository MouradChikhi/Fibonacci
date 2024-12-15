import Service.ServiceFibonacci;
import Vue.VueFibonacci;

import java.util.Scanner;
/**
 * La classe {@code Main} est le point d'entrée de l'application.
 * Elle initialise et exécute l'interface utilisateur pour le service de calcul de la suite de Fibonacci.
 *
 * @version 2.0
 * @author Mourad Chikhi
 * @author Kazumi Watanabi Target
 */
public class Main {

    /**
     * Point d'entrée de l'application.
     * Cette méthode initialise une instance de {@code VueFibonacci} et lance son exécution.
     *
     * @param args les arguments de la ligne de commande (non utilisés dans cette application)
     */
    public static void main(String[] args) {
        VueFibonacci vueFibonacci = new VueFibonacci();
        vueFibonacci.executerServiceFibonacci();

    }
}