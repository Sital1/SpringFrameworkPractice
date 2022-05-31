package beans;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyBean {

    private String text;

    /**
     * After constructing the bean do this
     */
    @PostConstruct
    private void init(){
        this.text = "Hello PostConstruct!";
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
