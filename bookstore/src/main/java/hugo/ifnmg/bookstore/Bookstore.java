package hugo.ifnmg.bookstore;

import hugo.ifnmg.bookstore.entity.Author;
import hugo.ifnmg.bookstore.repository.AuthorDAO;
import java.time.LocalDate;
import java.time.Month;

/**
 * Class for tests.
 */
public class Bookstore {
    public static void main(String[] args) {
    //------------- Author Entity Tests -------------\\
        Author a = new Author();
        a.setName("Autor Teste");
        a.setBirthdate(LocalDate.of(2000, Month.MARCH, 12));
        a.setDeathDate(LocalDate.of(2015, Month.JANUARY, 25));
        a.setDeathPlace("Cidade - SIGLA ESTADO");
        a.setBiography("Biografia qualquer.");
        AuthorDAO aDAO = new AuthorDAO();
        a.setID(aDAO.saveOrUpdate(a));
        System.out.println(a.toString());
    }
}