package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    User getUserById(Long id);
    User getUserByCar(String model, int series); // получение юзера по car
}
