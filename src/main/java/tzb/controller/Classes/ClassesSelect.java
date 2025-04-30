package tzb.controller.Classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tzb.pojo.Classes;
import tzb.service.ClassesServiceImpl;
import tzb.utils.Match;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassesSelect {
    @Autowired
    private ClassesServiceImpl classesServiceImpl;
    @GetMapping("/selectAll")
    public List<Classes> selectAll() {
        return classesServiceImpl.selectAll();
    }
    @GetMapping("/selectClass/{id}")
    public Classes selectById(long id) {
        return classesServiceImpl.selectById(id);
    }
    @GetMapping("/select/{selectVal}")
    public List<Classes> selectBySelectVal(@PathVariable String selectVal) {
        List<Classes> classes = classesServiceImpl.selectAll();
        List<Classes> ans = new ArrayList<>();
        Match match = new Match();
        for(Classes classe : classes){
            if(match.checkContainSubsequence(String.valueOf(classe.getId()), selectVal)) {
                ans.add(classe);
                continue;
            }
            if(match.checkContainSubsequence(classe.getName(), selectVal)) {
                ans.add(classe);
                continue;
            }
            if(match.checkContainSubsequence(String.valueOf(classe.getCreatedAt()), selectVal)) {
                ans.add(classe);
            }
        }
        return ans;
    }
}
