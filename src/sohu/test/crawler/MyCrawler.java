package sohu.test.crawler;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by qigao212074 on 2016/10/17.
 */
public class MyCrawler {

    public static void main(String[] args) {
        System.out.println("-------begin:" + new Timestamp(System.currentTimeMillis()));
        final String crawlStorageFolder = "data/crawl/root";
        final int numberOfCrawlers = 7;

        final CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);
        config.setPolitenessDelay(1000);
        config.setIncludeBinaryContentInCrawling(false);
        config.setMaxPagesToFetch(50);
        // config.setResumableCrawling(true);
        /*
         * Instantiate the controller for this crawl.
         */
        final PageFetcher pageFetcher = new PageFetcher(config);
        final RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        final RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller;
        try {
            controller = new CrawlController(config, pageFetcher, robotstxtServer);
            /*
             * For each crawl, you need to add some seed urls. These are the
             * first URLs that are fetched and then the crawler starts following
             * links which are found in these pages
             */
            controller.addSeed("http://sh.ziroom.com/z/nl/");
            // controller.addSeed("http://www.ziroom.com/z/nl/z3-u2.html/");
            // controller.addSeed("http://www.ics.uci.edu/~welling/");
            // controller.addSeed("http://www.ics.uci.edu/");

            /*
             * Start the crawl. This is a blocking operation, meaning that your
             * code will reach the line after this only when crawling is
             * finished.
             */
            controller.start(Controller.class, numberOfCrawlers);

            final List<Object> crawlersLocalData = controller.getCrawlersLocalData();
            long totalLinks = 0;
            long totalTextSize = 0;
            int totalProcessedPages = 0;
            for (final Object localData : crawlersLocalData) {
                final CrawlStat stat = (CrawlStat) localData;
                totalLinks += stat.getTotalLinks();
                totalTextSize += stat.getTotalTextSize();
                totalProcessedPages += stat.getTotalProcessedPages();
            }

            System.out.println("Aggregated Statistics:");
            System.out.println("\tProcessed Pages: {}" + totalProcessedPages);
            System.out.println("\tTotal Links found: {}" + totalLinks);
            System.out.println("\tTotal Text Size: {}" + totalTextSize);
        } catch (final Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
