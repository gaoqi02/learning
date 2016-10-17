package sohu.test.crawler;

import com.csvreader.CsvWriter;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Created by qigao212074 on 2016/10/17.
 */
public class Controller extends WebCrawler {
    /** 爬取数据保存文件路径 */
    private final static String CSV_PATH = "data/crawl/ziroom.csv";
    /** 爬取匹配原则 */
    private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|bmp|gif|jpe?g|ico"
            + "|png|tiff?|mid|mp2|mp3|mp4" + "|wav|avi|mov|mpeg|ram|m4v|pdf" + "|rm|smil|wmv|swf|wma|zip|rar|gz))$");
    /** 爬取link文件路径 */
    private final static String LINK_PATH = "data/crawl/link.csv";
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    private final static String URL_PREFIX = "http://sh.ziroom.com/z/nl/";

    private final File csv;

    private final File csv2;
    private CsvWriter cw;
    private CsvWriter cw2;

    /**
     * You should implement this function to specify whether the given url
     * should be crawled or not (based on your crawling logic).
     */
    CrawlStat myCrawlStat;

    public Controller() throws IOException {
        myCrawlStat = new CrawlStat();
        csv = new File(CSV_PATH);
        csv2 = new File(LINK_PATH);
        if (csv.isFile()) {
            csv.delete();
        }
        if (csv2.isFile()) {
            csv2.delete();
        }
        cw2 = new CsvWriter(new FileWriter(csv2, true), ',');
        cw2.write("请求路径");
        cw2.endRecord();
        cw2.close();
        cw = new CsvWriter(new FileWriter(csv, true), ',');
        cw.write("图片");
        cw.write("价格");
        cw.write("地址");
        cw.write("说明");
        cw.endRecord();
        cw.close();
    }

    public void dumpMyData() {
        final int id = getMyId();
        // You can configure the log to output to file
        logger.info("Crawler {} > Processed Pages: {}", id, myCrawlStat.getTotalProcessedPages());
        logger.info("Crawler {} > Total Links Found: {}", id, myCrawlStat.getTotalLinks());
        logger.info("Crawler {} > Total Text Size: {}", id, myCrawlStat.getTotalTextSize());
    }

    @Override
    public Object getMyLocalData() {
        return myCrawlStat;
    }

    @Override
    public void onBeforeExit() {
        dumpMyData();
    }

    /*
     * 这个方法决定了要抓取的URL及其内容，例子中只允许抓取“http://sh.ziroom.com/z/nl/”这个域的页面,
     * 不允许.css、.js和多媒体等文件
     *
     * @see edu.uci.ics.crawler4j.crawler.WebCrawler#shouldVisit(edu.uci.ics.
     * crawler4j.crawler.Page, edu.uci.ics.crawler4j.url.WebURL)
     */
    public boolean shouldVisit(Page referringPage, WebURL url) {
        final String href = url.getURL().toLowerCase();

        if (FILTERS.matcher(href).matches() || !href.startsWith(URL_PREFIX)) {
            return false;
        }
        return true;
    }

    /*
     * 当URL下载完成会调用这个方法。你可以轻松获取下载页面的url, 文本, 链接, html,和唯一id等内容。
     *
     * @see
     * edu.uci.ics.crawler4j.crawler.WebCrawler#visit(edu.uci.ics.crawler4j.
     * crawler.Page)
     */
    @Override
    public void visit(Page page) {
        final String url = page.getWebURL().getURL();
        System.out.println("-----------爬取路径：" + url);
        myCrawlStat.incProcessedPages();
        if (page.getParseData() instanceof HtmlParseData) {
            final HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            final List<WebURL> links = htmlParseData.getOutgoingUrls();
            try {
                linkToCsv(links);
            } catch (final IOException e2) {
                // TODO Auto-generated catch block
                e2.printStackTrace();
            }
            myCrawlStat.incTotalLinks(links.size());
            try {
                myCrawlStat.incTotalTextSize(htmlParseData.getText().getBytes("UTF-8").length);
            } catch (final UnsupportedEncodingException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            final String html = htmlParseData.getHtml();

            final Document doc = Jsoup.parse(html);

            final Elements contents = doc.select("li[class=clearfix]");

            for (final Element c : contents) {
                // 图片
                final String img = c.select(".img img").first().attr("src");
                System.out.println("图片：" + img);

                // 地址
                final Element txt = c.select("div[class=txt]").first();
                final String arr1 = txt.select("h3 a").first().text();
                final String arr2 = txt.select("h4 a").first().text();
                final String arr3 = txt.select("div[class=detail]").first().text();

                final String arr = arr1.concat(arr1 + ",").concat(arr2 + ",").concat(arr3);
                System.out.println("地址：" + arr);
                // 说明
                final String rank = txt.select("p").first().text();
                System.out.println("说明：" + rank);

                // 价格
                final String pirce = c.select("p[class=price]").first().text();

                try {
                    cw = new CsvWriter(new FileWriter(csv, true), ',');
                    cw.write(img);
                    cw.write(pirce);
                    cw.write(arr);
                    cw.write(rank);
                    cw.endRecord();
                    cw.flush();
                    cw.close();
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void linkToCsv(List<WebURL> links) throws IOException {
        cw2 = new CsvWriter(new FileWriter(csv2, true), ',');
        for (final WebURL webURL : links) {
            cw2.write(webURL.getURL());
        }
        cw2.flush();
        cw2.endRecord();
        cw2.close();
    }
}
