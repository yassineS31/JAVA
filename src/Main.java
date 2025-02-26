import com.yassineS31.sqlcda.db.Bdd;
import com.yassineS31.sqlcda.model.User;
import com.yassineS31.sqlcda.repository.UserRepository;


public class Main {
    public static void main(String[] args) {

        User newUser = new User("Thomas", "Shelbyte", "toto@gmail.com", "123");
        System.out.println(newUser);
        boolean exist = UserRepository.isExist("toto@gmail.com");
        if(exist) {
            System.out.println("Le compte existe");
        }
        else {
            System.out.println("Le compte n'existe pas");
        }

        User findEmail = UserRepository.findByEmail("toto@gmail.com");
        if(!findEmail.getEmail().equals("")){
            System.out.println("L'utilisateur existe déjà en bdd !");
        }else {
            System.out.println("L'utilisateur n'existe pas");
        }
    }
}