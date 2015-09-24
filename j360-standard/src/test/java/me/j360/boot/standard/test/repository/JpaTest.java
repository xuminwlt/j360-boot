package me.j360.boot.standard.test.repository;

import me.j360.boot.standard.J360Configuration;
import me.j360.boot.standard.domain.Note;
import me.j360.boot.standard.domain.Tag;
import me.j360.boot.standard.repository.NoteRepository;
import me.j360.boot.standard.repository.TagRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created with j360-boot -> me.j360.boot.standard.test.repository.
 * User: min_xu
 * Date: 2015/9/24
 * Time: 15:13
 * ËµÃ÷£º
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = J360Configuration.class)
public class JpaTest {
    @Autowired
    NoteRepository noteRepository;
    @Autowired
    TagRepository tagRepository;

    @Test
    public void findsAllTags() {
        List<Tag> tags = this.tagRepository.findAll();
        assertEquals(3, tags.size());
    }

    @Test
    public void findsAllNotes() {
        List<Note> notes = this.noteRepository.findAll();
        assertEquals(4, notes.size());
    }
}
