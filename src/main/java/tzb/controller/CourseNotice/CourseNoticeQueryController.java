package tzb.controller.CourseNotice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.CourseNotice;
import tzb.service.CourseNoticeService;

import java.util.List;

@RestController
@RequestMapping("/courseNotice")
public class CourseNoticeQueryController {

    @Autowired
    private CourseNoticeService service;

    @GetMapping("/get/{id}")
    public CourseNotice getById(@PathVariable long id) {
        return service.getNoticeById(id);
    }

    @GetMapping("/list")
    public List<CourseNotice> getAll() {
        return service.getAllNotices();
    }
}
