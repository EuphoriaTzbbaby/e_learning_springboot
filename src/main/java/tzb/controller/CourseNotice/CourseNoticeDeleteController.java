package tzb.controller.CourseNotice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.service.CourseNoticeService;

@RestController
@RequestMapping("/courseNotice")
public class CourseNoticeDeleteController {

    @Autowired
    private CourseNoticeService service;

    @DeleteMapping("/delete/{id}")
    public String deleteNotice(@PathVariable long id) {
        return service.deleteNotice(id) > 0 ? "删除成功" : "删除失败";
    }
}
