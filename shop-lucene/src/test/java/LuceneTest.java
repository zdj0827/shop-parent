/*
import lucene.dao.BookDao;
import lucene.dao.impl.BookDaoImpl;
import lucene.po.Book;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LuceneTest {
    //创建索引
    @Test
    public void createIndex(){
        //从数据库中查找数据
        BookDao bookDao = new BookDaoImpl();
        List<Book> books = bookDao.bookList();
        List<Document> documentList = new ArrayList<Document>();
        //遍历books集合
        for (Book book:books){
            //添加索引到文档域中
            Document document = new Document();
            //id：不分词/要索引/要存储
            Field id = new StringField("id",book.getId().toString(), Field.Store.YES);
            //name：要分词/要索引/要存储
            Field name = new TextField("name",book.getName().toString(),Field.Store.YES);
            //price:不分词/要索引/要存储
            Field price = new FloatField("price",book.getPrice(),Field.Store.YES);
            //pic：不分词/要索引/要存储
            Field pic = new StoredField("pic",book.getPic());
            //description:要分词/要索引/不存储
            Field description = new TextField("description",book.getDescription(),Field.Store.NO);
            //添加到文档域中
            document.add(id);
            document.add(name);
            document.add(price);
            document.add(pic);
            document.add(description);
            //添加到文档域集合中
            documentList.add(document);
        }
        //创建分词器
        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig inw_conf = new IndexWriterConfig(Version.LUCENE_4_10_3,analyzer);
        //指定索引库地址
        File indexFile = new File("I:/JAVA四阶段/LuceneIndexRepertory");
        Directory indexDirectory = null;
        IndexWriter indexWriter = null;
        try {
            //创建索引
            indexDirectory = FSDirectory.open(indexFile);
            indexWriter = new IndexWriter(indexDirectory,inw_conf);
            for(Document document:documentList){
                indexWriter.addDocument(document);
            }
            //关闭资源
            indexWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //查询索引
    @Test
    public void quaryIndex() throws ParseException, IOException {
        QueryParser queryParser = new QueryParser("description",new StandardAnalyzer());
        Query query = queryParser.parse("description:spring");
        //指定索引库位置
        File indexFile = new File("I:/JAVA四阶段/LuceneIndexRepertory");
        Directory directory = FSDirectory.open(indexFile);
        IndexReader indexReader = DirectoryReader.open(directory);
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        //搜索索引库中的内容
        TopDocs topDocs = indexSearcher.search(query,10);
        System.out.println("匹配的记录总数为：" + topDocs.totalHits);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for(ScoreDoc scoreDoc:scoreDocs){
            System.out.println("docId:" + scoreDoc.doc);
            Document document = indexSearcher.doc(scoreDoc.doc);
            System.out.println(document.get("id"));
            System.out.println(document.get("name"));
            System.out.println(document.get("description"));
        }
        indexReader.close();
    }
    //删除索引
    @Test
    public void deleteIndex() throws IOException {
        //创建分词器
        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig inw_conf = new IndexWriterConfig(Version.LUCENE_4_10_3,analyzer);
        //指定索引库地址
        File indexFile = new File("I:/JAVA四阶段/LuceneIndexRepertory");
        Directory directory = FSDirectory.open(indexFile);
        IndexWriter indexWriter = new IndexWriter(directory,inw_conf);
        //根据条件删除
        //Term term = new Term("name","solr");
        //indexWriter.deleteDocuments(term);
        //删除所有索引
        indexWriter.deleteAll();
        //释放资源
        indexWriter.close();
    }
    //更新索引
    @Test
    public void updateIndex() throws IOException {
        //创建分词器
        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig inw_conf = new IndexWriterConfig(Version.LUCENE_4_10_3,analyzer);
        //指定索引库地址
        File indexFile = new File("I:/JAVA四阶段/LuceneIndexRepertory");
        Directory directory = FSDirectory.open(indexFile);
        IndexWriter indexWriter = new IndexWriter(directory,inw_conf);
        //更新
        Term term = new Term("name","solr");
        //更新模板
        Document document = new Document();
        document.add(new TextField("name","java", Field.Store.YES));
        //如果存在则更新，不存在则新增
        indexWriter.updateDocument(term,document);
        //释放资源
        indexWriter.close();
    }
}
*/
