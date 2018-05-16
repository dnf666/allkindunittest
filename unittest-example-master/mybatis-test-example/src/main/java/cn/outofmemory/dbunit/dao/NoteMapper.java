package cn.outofmemory.dbunit.dao;

import cn.outofmemory.dbunit.entity.Note;

/**
 * Created by yukaizhao on 2015/10/19.
 */
public interface NoteMapper {
    int insert(Note note);
    int delete(int noteId);
    int update(Note note);
    Note selectNoteById(int id);
}
