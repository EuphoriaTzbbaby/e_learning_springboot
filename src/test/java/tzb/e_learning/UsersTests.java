package tzb.e_learning;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tzb.pojo.ClassStudents;
import tzb.pojo.ClassTeachers;
import tzb.pojo.Users;
import tzb.pojo.VideoAlbum;
import tzb.service.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

@SpringBootTest
public class UsersTests {
    @Autowired
    private UsersService usersService;
    @Autowired
    private VideoAlbumService videoAlbumService;
    @Autowired
    private ClassStudentsService classStudentsService;
    @Autowired
    private ClassTeachersService classTeachersService;
    @Test
    public void selectAll() {
        List<Users> users = usersService.selectAll();
        List<VideoAlbum> videoAlbumList = videoAlbumService.getAll();
        for(Users user : users) {
            Random random = new Random();
            if(user.getRole().equals("student")) {
                ClassStudents v = new ClassStudents();
                v.setClassId(videoAlbumList.get(random.nextInt(1,100) % 3).getId());
                v.setStudentId(user.getId());
                classStudentsService.insert(v);
            } else if(user.getRole().equals("teacher")) {
                ClassTeachers v = new ClassTeachers();
                v.setClassId(videoAlbumList.get(random.nextInt(1, 100) % 3).getId());
                v.setTeacherId(user.getId());
                classTeachersService.insert(v);
            }
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
