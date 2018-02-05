package lucene.dao;

import lucene.po.Book;

import java.util.List;

public interface BookDao {
    List<Book> bookList();
}
