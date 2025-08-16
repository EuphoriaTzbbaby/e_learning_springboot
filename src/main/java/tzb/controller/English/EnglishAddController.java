package tzb.controller.English;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.English;
import tzb.service.EnglishService;

@RestController
@RequestMapping("/english")
public class EnglishAddController {

    @Autowired
    private EnglishService englishService;

    @PostMapping("/add")
    public String add(@RequestBody English english) {
        int res = englishService.insert(english);
        return res > 0 ? "Insert successful" : "Insert failed";
    }
}
