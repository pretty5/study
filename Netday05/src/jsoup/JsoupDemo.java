package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

/*
*@ClassName:JsoupDemo
 @Description:TODO
 @Author:
 @Date:2018/8/6 9:04 
 @Version:v1.0
*/
/*
使用jsoup来解析html文档
 */
public class JsoupDemo {
    public static void main(String[] args) throws IOException {

       /* Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
        //根据元素（标签）的id来获得元素（标签）
        Element element = doc.getElementById("firstHeading");
        System.out.println(element);
        //得到当前标签中的html
        System.out.println(element.html());;
        //得到当前标签中的内容
        System.out.println(element.text());;*/
        //System.out.println(doc.body());;

        Document doc = Jsoup.connect("http://www.yinwang.org/blog-cn/2018/04/13/csbook-chapter1").get();
        System.out.println(doc.title());
        //根据拥有此此属性的便签 来获取标签
        Elements links = doc.getElementsByAttribute("src");
        //attr方法表示获取元素中属性的值
        //String href = links.first().attr("href");
        //获取每一个元素中src属性的值
        /*List<String> hrefs = links.eachAttr("src");
        for (String href :
                hrefs) {
            System.out.println(href);
        }*/

        Elements p = doc.getElementsByTag("p");
        List<String> strings = p.eachText();
        for (String content:strings){
            System.out.println(content);
        }

       /* while (true){
            Elements e;
            if ((e=links.next())!=null){
                System.out.println(e.html("href"));
            }
        }*/
        //doc.get
        //System.out.println(links.);
        //Elements tags = doc.getElementsByTag("img");
       // System.out.println(tags);
    }

    }

