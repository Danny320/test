package com.luodan.service;

import com.luodan.dao.BookDao;
import com.luodan.dao.SectionDao;
import com.luodan.model.Book;
import com.luodan.model.Section;
import com.luodan.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author ：LD
 * @description：TODO
 * @date ：2021/2/9 20:13
 */
public class BookService {
    private BookDao bookDao;
    private SectionDao sectionDao;

    public BookService() {
        bookDao = new BookDao();
        sectionDao = new SectionDao();
    }
    public List<Book> list() throws SQLException {
        return bookDao.selectAll();

    }

    public Book post(String title, User user) throws SQLException{
        return bookDao.insert(user,title);
    }

    public Book get(int bid) throws SQLException {
        return bookDao.select(bid);
    }
}
