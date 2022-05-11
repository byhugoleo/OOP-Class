package hugo.ifnmg.database.tests;

import hugo.ifnmg.database.tests.util.Util;

/**
 * Class for tests
 * 
 * @author byhugoleo
 */
public class Program {
    public static void main(String[] args) {
        String CPF = "10012666688";
        System.out.println(Util.isValidCPF(CPF));
    }
}
