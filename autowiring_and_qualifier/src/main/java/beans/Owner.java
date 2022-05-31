package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Owner {

    @Autowired(required = false)
    @Qualifier("cat1")
    private  Cat cat;

//    @Autowired
//    public Owner(Cat cat) {
//        this.cat = cat;
//    }


    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Cat getCat() {
        return cat;
    }


    @Override
    public String toString() {
        return "Owner{" +
                "cat=" + cat +
                '}';
    }
}
