package tzb.controller.ClassTeachers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.ClassTeachers;
import tzb.service.ClassTeachersService;

import java.util.List;

@RestController
@RequestMapping("/classTeachers/select")
public class ClassTeachersQueryController {

    @Autowired
    private ClassTeachersService classTeachersService;
    @GetMapping("/selectByTeacherId/{Id}")
    public List<ClassTeachers> selectById(@PathVariable long Id) {
        System.out.println("cnmmm");
        System.out.println(Id);
        return classTeachersService.selectByTeacherId(Id);
    }
}
