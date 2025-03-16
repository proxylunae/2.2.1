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

      userService.add(new User(
              "John", "Doe", "john.doe@example.com", new Car("BMW", 5)));
      userService.add(new User(
              "Jane", "Smith", "jane.smith@example.com", new Car("Mercedes", 3)));
      userService.add(new User(
              "Ivan", "Ivanov", "ivan.ivanov@example.com", new Car("Lada", 1)));
      userService.add(new User(
              "Emily", "Jones", "emily.jones@example.com", new Car("Audi", 6)));
      //созданы и добавлены юзеры

      List<User> users = userService.listUsers(); //получены юзеры
      System.out.println("*****\n\n\n");
      for (User user : users) {
         System.out.println(user);
      }
      System.out.println("\n\n\n*****");

      User userByCar = userService.getUserByCar("Audi", 6); // юзер получен по car
      System.out.println("*****\n\n\n");
      System.out.println(userByCar);
      System.out.println("\n\n\n*****");


      context.close();
   }
}
