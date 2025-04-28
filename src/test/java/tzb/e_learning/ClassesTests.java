package tzb.e_learning;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import tzb.pojo.Classes;
import tzb.service.ClassesServiceImpl;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@SpringBootTest
public class ClassesTests {
    @Autowired
    private ClassesServiceImpl classesServiceImpl;
    @Test
    public void insert() {
        for(int i = 1; i <= 5; i += 1) {
            Classes classes = new Classes();
            classes.setName("九(" + String.valueOf(i) + ")");
            classes.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
            classesServiceImpl.insert(classes);
            System.out.println(666);
        }
    }

    @Test
    public void selectById() {
        System.out.println(classesServiceImpl.selectById(1));
    }

    @Test
    public void selectAll() {
        for(Classes classes : classesServiceImpl.selectAll()) {
            System.out.println(classes);
        }
    }

    @Test void updateById() {
        Classes classes = new Classes();
        classes.setId(1);
        classes.setName("九(1)");
        classes.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        classesServiceImpl.updateById(classes);
    }

    @Test void deleteById() {
        classesServiceImpl.deleteById(5);
    }

}
