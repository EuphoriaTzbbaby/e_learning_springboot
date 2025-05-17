package tzb.e_learning;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tzb.pojo.ClassTeachers;
import tzb.pojo.Users;
import tzb.service.ClassTeachersService;
import tzb.service.UsersService;

import java.util.List;

@SpringBootTest
public class ClassTeachersTests {
    @Autowired
    private ClassTeachersService classTeachersService;

    @Autowired
    private UsersService usersService;
    @Test
    public void insert() {
        List<Users> users = usersService.selectAll();
        System.out.println(users.size());
        for(Users user : users){
            ClassTeachers classTeachers = new ClassTeachers();
            classTeachers.setTeacherId(user.getId());
            classTeachers.setClassId(user.getId() % 4 + 1);
            classTeachersService.insert(classTeachers);
        }
    }
    @Test
    public void selectByClassId() {
        
    }
}
