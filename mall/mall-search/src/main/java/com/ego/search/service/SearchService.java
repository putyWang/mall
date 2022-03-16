package com.ego.search.service;

import com.ego.domain.TbItem;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;
import java.util.Map;

public interface SearchService {
    void init() throws SolrServerException, IOException;

    void add(TbItem tbItem, String desc, String tbItemCatName) throws SolrServerException, IOException;

    void deleteItem(long id) throws SolrServerException, IOException;

    Map<String, Object> searchItem(String field, int pages, int rows) throws SolrServerException, IOException;
}
