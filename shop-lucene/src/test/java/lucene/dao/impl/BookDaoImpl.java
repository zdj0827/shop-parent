package lucene.dao.impl;

import lucene.dao.BookDao;
import lucene.po.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao{
    @Override
    public List<Book> bookList() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lucene", "root", "123");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from book");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Book> books = new ArrayList<Book>();
            while(resultSet.next()){
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setName(resultSet.getString("name"));
                book.setPrice(resultSet.getFloat("price"));
                book.setPic(resultSet.getString("pic"));
                book.setDescription(resultSet.getString("description"));
                books.add(book);
            }
            return books;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
