package tzb.controller.Classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tzb.pojo.Classes;
import tzb.pojo.Users;
import tzb.service.ClassesService;

@RestController
@RequestMapping("/classes")
public class ClassesUpdate {
    @Autowired
    private ClassesService classesService;
    @PutMapping("/updateById")
    public String updateClasses(@RequestBody Classes classes) {
        int result = classesService.updateById(classes);
        return result == 1 ? "班级更新成功" : "班级更新失败";
    }
}
