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
        //---------------- CPF Tests ----------------//
        String CPF = "10012666688";
        System.out.println(Util.isValidCPF(CPF));
        
        CPF = "11111111111";
        System.out.println(">> CPF[1] = " + Util.isValidCPF(CPF));
        
        CPF = "12345678912";
        System.out.println(">> CPF[2] = " + Util.isValidCPF(CPF));
        
        CPF = "100.126.666-88";
        System.out.println(">> CPF[3] = " + Util.isValidCPF(CPF));
        
        //---------------- Name TESTS ----------------//
        String name = "Hugo Leonardo Machado";
        System.out.println(">> Name[1] = " + Util.isValidName(name));
        
        name = "Hug0 Leonard0 Machad0";
        System.out.println(">> Name[2] = " + Util.isValidName(name));
        
        //---------------- E-mail TESTS ----------------//
        String email = "hugoleonardomachado@hotmail.com";
        System.out.println(">> Email[1] = " + Util.isValidEmail(email));
        
        email = "hugoleonardo/machado@outlook.com";
        System.out.println(">> Email[2] = " + Util.isValidEmail(email));
        
        email = "hugo.leo@gmail.uk";
        System.out.println(">> Email[3] = " + Util.isValidEmail(email));
        
        //---------------- NaturalPerson Tests ----------------//
        NaturalPerson np = new NaturalPerson();
        np.setCPF(CPF);
        np.setName("Hu");
        np.setBirth(LocalDate.of(1999, 10, 2));
        np.setEmail("hugoleonardo@email.com");
        np.setActive(true);
        System.out.println(np);
        NaturalPerson np2 = new NaturalPerson("10012666688", "Hugo Leonardo", "hugo@outlook.com", LocalDate.of(1999, 10, 2), true);
        System.out.println(np2);
    }
}
