import java.util.ArrayList;
import java.util.List;

public class SocialSecurity {
    private List<Person> people_ss;

    public SocialSecurity(){
        people_ss=new ArrayList<>();
    }

    public void regist(Person p) {
        people_ss.add(p);
        System.out.println("Employee " + p.getName() + " registered in Social Security with success!");
    }
}
