package tzb.controller.CourseNotice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.CourseNotice;
import tzb.service.CourseNoticeService;

@RestController
@RequestMapping("/courseNotice")
public class CourseNoticeUpdateController {

    @Autowired
    private CourseNoticeService service;

    @PutMapping("/update")
    public String updateNotice(@RequestBody CourseNotice notice) {
        return service.updateNotice(notice) > 0 ? "修改成功" : "修改失败";
    }
}
