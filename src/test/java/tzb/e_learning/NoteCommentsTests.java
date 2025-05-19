package tzb.e_learning;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tzb.pojo.NoteComments;
import tzb.service.NoteCommentsService;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class NoteCommentsTests {
    @Autowired
    private NoteCommentsService noteCommentsService;

    @Test
    public void test() {
        List<NoteComments> noteComments = new ArrayList<>();
        List<NoteComments> res = noteCommentsService.findAll();
        res.get(0).setCommentId("8888");
        noteComments.add(res.get(0));
        res.get(1).setCommentId("9999");
        noteComments.add(res.get(1));
        noteCommentsService.saveBatch(noteComments);
    }
}
