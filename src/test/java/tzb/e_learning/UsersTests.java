package tzb.e_learning;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tzb.pojo.Users;
import tzb.service.UsersService;

import java.sql.Timestamp;
import java.util.List;

@SpringBootTest
public class UsersTests {
    @Autowired
    private UsersService usersService;

    @Test
    public void selectAll() {
        List<Users> users = usersService.selectAll();
        for(Users user : users){
            System.out.println(user);
        }
    }

    @Test
    public void insert() {
        Users user = new Users();
        user.setUsername("<UNK>");
        user.setPassword("123456");
        user.setRole("student");
        user.setName("<UNK>");
        user.setEmail("gg@example.com");
        user.setCreatedAt(Timestamp.valueOf("2025-04-26 21:42:02"));
        user.setAvatar("avatar.jpg");
        usersService.insert(user);
    }

    @Test
    public void deleteById() {
        usersService.deleteById(35);
    }

    @Test
    public void updateById() {
        Users user = new Users();
        user.setId(36);
        user.setUsername("<UNK>");
        user.setPassword("1234569999999");
        user.setRole("student");
        user.setName("<UNK>");
        user.setEmail("gg@example.com");
        user.setCreatedAt(Timestamp.valueOf("2025-04-26 21:42:02"));
        user.setAvatar("avatar.jpg");
        usersService.updateById(user);
    }

}
