package hello;

import cn.outofmemory.dbunit.dao.NoteMapper;
import cn.outofmemory.dbunit.entity.Note;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;


/**
 * NoteDao实现的测试类
 *
 * 这个类必须有@RunWith(SpringJUnit4ClassRunner.class)直接指定使用spring测试， @ContextConfiguration 注解指定要使用此单元测试类需要预先加载的spring配置文件
 *
 * Created by yukaizhao on 2015/10/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/spring-dao.xml"})
public class NoteDaoTest {

    /**
     * 使用@Autowired注解自动注入NoteDao测试类
     */
    @Autowired
    private NoteMapper noteMapper;

    /**
     * 测试NoteDao的insert方法， 此处我们构造了一个Note对象，然后将起insert到数据库
     */
    @Test
    public void insertTest() {
        Note note = new Note();
        note.setTitle("test title");
        note.setContent("test content");
        note.setCreateTime(new Date());
        noteMapper.insert(note);

        //此处通过验证note的id属性是否为正整数来验证插入是否成功
        Assert.assertTrue(note.getId() > 0);
    }


    /**
     * 测试更新操作
     */
    @Test
    public void updateTest() {
        Note note = new Note();
        note.setId(1);
        String newTitle = "new Title";
        note.setTitle(newTitle);
        String newContent = "new Content";
        note.setContent(newContent);

        int effectRows = noteMapper.update(note);
        //此处通过update操作返回的受影响行数来断定update操作是否执行成功
        Assert.assertTrue (effectRows == 1);
    }

    /**
     * 测试delete操作
     */
    @Test
    public void deleteTest() {
        int wantDeleteId = 2;
        int effectRows = noteMapper.delete(wantDeleteId);
        //通过验证受影响行数来断定是否成功执行操作
        Assert.assertEquals(1, effectRows);
    }

    /**
     * 测试select操作
     */
    @Test
    public void selectTest() {
        int selectId = 3;
        Note note = noteMapper.selectNoteById(selectId);
        //通过select出的note的id属性来断言是否成功
        Assert.assertEquals(selectId, note.getId());
    }
}
