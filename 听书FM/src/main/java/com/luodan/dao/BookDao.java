package com.luodan.dao;

import com.luodan.model.Book;
import com.luodan.model.User;
import com.luodan.util.DB;

import javax.servlet.ServletException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：LD
 * @description：TODO
 * @date ：2021/2/9 20:12
 */
public class BookDao {
    public Book insert(User user,String title) throws SQLException {
        String sql = "insert into books (uid,title) values (?,?)";
        try(Connection c = DB.getConnection()) {
            try(PreparedStatement s = c.prepareStatement(sql)){
                s.setInt(1,user.uid);
                s.setString(2,title);
                s.executeUpdate();

                try(ResultSet r = s.executeQuery()) {
                    while (!r.next()) {
                        return null;
                    }
                    return new Book(r.getInt(1),user,title);
                }
            }

        }
    }

    public List<Book> selectAll() throws SQLException {
        String sql = "select bid, title, users.uid, users.username " +
                "from books,users " +
                "where books.uid = users.uid " +
                "order by bid desc";
        List<Book> books = new ArrayList<>();
        try(Connection c = DB.getConnection()) {
            try(PreparedStatement s = c.prepareStatement(sql)) {
                try(ResultSet r = s.executeQuery()) {
                    while (r.next()) {
                        User user = new User(r.getInt("uid"),r.getString("username"));
                        Book book = new Book(r.getInt("bid"),user,r.getString("title"));
                        books.add(book);
                    }
                }
            }
        }
        return books;
    }

    public Book select(int bid) throws SQLException {
        String sql = "select bid,title,users.uid,users.name" +
                " from books,users " +
                "where books.bid = users.uid and bid = ?";
        try(Connection c = DB.getConnection()) {
            try(PreparedStatement s = c.prepareStatement(sql)) {
                s.setInt(1,bid);
                try(ResultSet r = s.executeQuery()) {
                    if(!r.next()) {
                        return null;
                    }
                    User user = new User(r.getInt("uid"),r.getString("username"));
                    return new Book(r.getInt("bid"),user,r.getString("title"));
                }
            }

        }

    }
}
