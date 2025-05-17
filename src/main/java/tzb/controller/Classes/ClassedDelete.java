package tzb.controller.Classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.Classes;
import tzb.service.ClassesService;
@RestController
@RequestMapping("/classes")
public class ClassedDelete {
    @Autowired
    private ClassesService classesService;
    @DeleteMapping("/delete/{id}")
    public String deleteClasses(@PathVariable long id) {
        int result = classesService.deleteById(id);
        return result == 1 ? "班级删除成功" : "班级删除失败";
    }
}
