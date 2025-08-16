package tzb.controller.English;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.English;
import tzb.service.EnglishService;

@RestController
@RequestMapping("/english")
public class EnglishUpdateController {

    @Autowired
    private EnglishService englishService;

    @PutMapping("/update")
    public String update(@RequestBody English english) {
        int res = englishService.update(english);
        return res > 0 ? "Update successful" : "Update failed";
    }
}
