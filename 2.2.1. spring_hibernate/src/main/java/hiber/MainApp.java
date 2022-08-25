package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);
      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("Mazda", 323);
      Car car2 = new Car("BMW", 530);
      Car car3 = new Car("Mercedes", 63);
      Car car4 = new Car("Ford", 150);
      Car car5 = new Car("AUDI", 5);

      User user1 = new User("Max", "Fray", "maxfray@mail.ru");
      User user2 = new User("Juffin", "Halli", "juffinhalli@mail.ru");
      User user3 = new User("Melamori", "Blimm", "melamoriblimm@mail.ru");
      User user4 = new User("Shurf", "Lonli-Lockli", "shurfll@mail.ru");
      User user5 = new User("Koffa", "Joh", "koffajoh@mail.ru");

      user1.setCar(car1);
      user2.setCar(car2);
      user3.setCar(car3);
      user4.setCar(car4);
      user5.setCar(car5);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);
      userService.add(user5);

      System.out.println(userService.getUserByCar("Ford", 150 ));
      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user.toString());
      }
      context.close();
   }
}
