package sohu.test.crawler;

public class CrawlStat {
    private long totalLinks;
    private int totalProcessedPages;
    private long totalTextSize;

    public long getTotalLinks() {
        return totalLinks;
    }

    public int getTotalProcessedPages() {
        return totalProcessedPages;
    }

    public long getTotalTextSize() {
        return totalTextSize;
    }

    public void incProcessedPages() {
        this.totalProcessedPages++;
    }

    public void incTotalLinks(int count) {
        this.totalLinks += count;
    }

    public void incTotalTextSize(int count) {
        this.totalTextSize += count;
    }

    public void setTotalLinks(long totalLinks) {
        this.totalLinks = totalLinks;
    }

    public void setTotalProcessedPages(int totalProcessedPages) {
        this.totalProcessedPages = totalProcessedPages;
    }

    public void setTotalTextSize(long totalTextSize) {
        this.totalTextSize = totalTextSize;
    }
}