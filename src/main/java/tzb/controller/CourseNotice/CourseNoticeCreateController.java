package tzb.controller.CourseNotice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.CourseNotice;
import tzb.service.CourseNoticeService;

@RestController
@RequestMapping("/courseNotice")
public class CourseNoticeCreateController {

    @Autowired
    private CourseNoticeService service;

    @PostMapping("/add")
    public String addNotice(@RequestBody CourseNotice notice) {
        return service.addNotice(notice) > 0 ? "添加成功" : "添加失败";
    }
}
