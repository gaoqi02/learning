package sohu.test.elasticsearch;


import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.FuzzyQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qigao212074 on 2016/11/9.
 */
public class ElasticsearchBean {

    public static void main(String[] args) throws UnknownHostException {
        Client client = TransportClient.builder().build()
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("121.40.188.130"), 9300));
        QueryBuilder qb = new FuzzyQueryBuilder("content","gaoqi");
        SearchResponse response = client.prepareSearch("tb_article").setTypes("article").setQuery(qb).execute()
                .actionGet();
        SearchHits shs = response.getHits();
        List<String> tagList = new ArrayList<String>();
        for(SearchHit hit : shs){
            tagList.add(hit.getSourceAsString());
        }

        System.out.print("ggg");
    }
}
