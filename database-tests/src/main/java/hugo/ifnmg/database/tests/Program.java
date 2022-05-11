package hugo.ifnmg.database.tests;

import hugo.ifnmg.database.tests.util.Util;
import java.time.LocalDate;

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
        
        //---------------- NaturalPerson TESTS ----------------//
        NaturalPerson np = new NaturalPerson();
        np.setCPF(CPF);
        np.setName("Hugo Leonardo");
        np.setBirth(LocalDate.of(1999, 10, 2));
        np.setEmail("hugoleonardo@email.com");
        np.setActive(true);
        System.out.println(np);
    }
}
