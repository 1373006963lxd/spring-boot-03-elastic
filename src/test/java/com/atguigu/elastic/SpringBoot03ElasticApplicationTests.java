package com.atguigu.elastic;

import com.atguigu.elastic.bean.Article;
import com.atguigu.elastic.bean.Book;
import com.atguigu.elastic.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot03ElasticApplicationTests {

    @Autowired
    JestClient jestClient;

    /*对SpringData ElasticSearch进行测试*/

    @Autowired
    BookRepository bookRepository;


    @Test
    public void test02(){
        Book book = new Book();
        book.setId(1);
        book.setBookName("西游记");
        book.setAuthor("吴承恩");
        bookRepository.index(book);


        /*查询*/
       /* List<Book> books = bookRepository.findByBookNameLike("游");
        System.out.println(books);
*/
    }

    @Test
    public void contextLoads() {
        Article article = new Article();
        article.setId(1);
        article.setTitle("好消息");
        article.setAuthor("xld");
        article.setContent("ahahhhahha");
        /*构建一个索引*/
        Index index = new Index.Builder(article).index("atguigu").type("news").build();
        try {
            /*执行*/
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*
    * 测试搜索
    *
    * */
    @Test
    public void search(){
        /*这个地方加json数据的时候一定要先     加双引号，然后将内容放进去*/
        String json = "{\n" +
                "  \"query\": {\n" +
                "    \"match\": {\n" +
                "      \"content\":\"ahahhhahha\"\n" +
                "    }\n" +
                "  }\n" +
                "}";
        /*构建搜索功能*/
        Search search = new Search.Builder(json).addIndex("atguigu").addType("news").build();
        try {
            /*执行*/
            SearchResult searchResult = jestClient.execute(search);
            System.out.println(searchResult.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
