package tzb.controller.Classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tzb.pojo.Classes;
import tzb.pojo.Users;
import tzb.service.ClassesService;

@RestController
@RequestMapping("/classes")
public class ClassesInsert {
    @Autowired
    private ClassesService  classesService;
    @PostMapping("/insert")
    public String createClass(@RequestBody Classes classes) {
        int result = classesService.insert(classes);
        return result == 1 ? "班级创建成功" : "班级创建失败";
    }
}
