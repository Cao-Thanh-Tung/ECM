package mta.oneToOne;


public interface UserService {
    void save(User user);
    User findById(Long id);
}
