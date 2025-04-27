package tzb.e_learning;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tzb.pojo.Users;
import tzb.service.UsersService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
public class UsersDataGeneratorTest {

    @Autowired
    private UsersService usersService;

    private static final String[] ROLES = {"admin", "teacher", "student"};
    private static final Random RANDOM = new Random();

    private List<Users> generateUsers(int count) {
        List<Users> usersList = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            Users user = new Users();
            user.setUsername("user" + i);
            user.setPassword("pass" + i);
            user.setRole(ROLES[RANDOM.nextInt(ROLES.length)]);
            user.setName("User Name " + i);
            user.setEmail("user" + i + "@example.com");
            user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            user.setAvatar("avatar.jpg");
            usersList.add(user);
        }
        return usersList;
    }

    @Test
    public void testInsertUsers() {
        List<Users> users = generateUsers(20);
        for (Users user : users) {
            usersService.insert(user);
            System.out.println("插入用户: " + user);
        }
    }
}
