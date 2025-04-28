package tzb.controller.Classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tzb.pojo.Classes;
import tzb.service.ClassesServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassesSelect {
    @Autowired
    private ClassesServiceImpl classesServiceImpl;

    @GetMapping("/selectAll")
    public List<Classes> selectAll() {
        return classesServiceImpl.selectAll();
    }
    @GetMapping("/select/{id}")
    public Classes selectById(long id) {
        return classesServiceImpl.selectById(id);
    }
}
