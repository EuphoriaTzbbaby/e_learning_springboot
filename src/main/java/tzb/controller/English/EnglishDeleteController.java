package tzb.controller.English;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.service.EnglishService;

@RestController
@RequestMapping("/english")
public class EnglishDeleteController {

    @Autowired
    private EnglishService englishService;

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        int res = englishService.deleteById(id);
        return res > 0 ? "Delete successful" : "Delete failed";
    }
}
