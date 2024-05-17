package chatgut.postservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PostService2Application {

    public static void main(String[] args)  {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            SpringApplication.run(PostService2Application.class, args);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
