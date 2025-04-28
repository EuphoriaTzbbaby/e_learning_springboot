package tzb.e_learning;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import tzb.pojo.ClassStudents;
import tzb.pojo.Users;
import tzb.service.ClassStudentsService;
import tzb.service.UsersService;

import java.util.List;

@SpringBootTest
public class ClassStudentsTests {
    @Autowired
    private ClassStudentsService classStudentsService;

    @Autowired
    private UsersService usersService;
    @Test
    public void insert() {
        List<Users> users = usersService.selectAll();
        System.out.println(users.size());
        for(Users user : users){
            ClassStudents classStudents = new ClassStudents();
            classStudents.setStudentId(user.getId());
            classStudents.setClassId(user.getId() % 4 + 1);
            classStudentsService.insert(classStudents);
        }
    }
    @Test
    public void selectByClassId() {
        for(ClassStudents classStudents : classStudentsService.selectByClassId(1)){
            System.out.println(classStudents);
        }
    }
}
