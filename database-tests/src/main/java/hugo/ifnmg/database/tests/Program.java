package hugo.ifnmg.database.tests;

import hugo.ifnmg.database.tests.util.Util;

/**
 * Class for tests
 * 
 * @author byhugoleo
 */
public class Program {
    public static void main(String[] args) {
        //---------------- CPF TESTS ----------------//
        String CPF = "10012666688";
        System.out.println(Util.isValidCPF(CPF));
        
        CPF = "11111111111";
        System.out.println(Util.isValidCPF(CPF));
        
        CPF = "12345678912";
        System.out.println(Util.isValidCPF(CPF));
        
        CPF = "100.126.666-88";
        System.out.println(Util.isValidCPF(CPF));
    }
}
