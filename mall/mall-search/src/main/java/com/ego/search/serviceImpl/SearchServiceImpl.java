package com.ego.search.serviceImpl;

import com.ego.domain.TbItem;
import com.ego.domain.TbItemCat;
import com.ego.domain.TbItemDesc;
import com.ego.search.domain.Item;
import com.ego.search.service.SearchService;
import com.ego.service.ListService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchServiceImpl implements SearchService {

    @Resource
    private CloudSolrClient client;

    @DubboReference(interfaceClass = ListService.class, version = "1.0")
    private ListService listService;

    @Override
    public void init() throws SolrServerException, IOException {
        List<TbItem> tbItems = listService.findListByStatus(1);
        TbItemDesc tbItemDesc;
        TbItemCat tbItemCat;
        SolrInputDocument doc;

        for (TbItem tb : tbItems) {
            tbItemDesc = listService.findTbItemDescById(tb.getId());
            tbItemCat = listService.findTbItemCatById(tb.getCid());
            //新建提交document
            doc = new SolrInputDocument();

            //将数据加入到doc中
            doc.addField("id", tb.getId());
            doc.addField("item_title", tb.getTitle());
            doc.addField("item_sell_point", tb.getSellPoint());
            doc.addField("item_price", tb.getPrice());
            doc.addField("item_image", tb.getImage());
            doc.addField("item_category_name", tbItemCat.getName());
            doc.addField("item_desc", tbItemDesc.getItemDesc());

            client.add(doc);
        }

        //提交事务
        client.commit();
    }


    @Override
    public void add(TbItem tb, String desc, String tbItemCatName) throws SolrServerException, IOException {

        SolrInputDocument doc = new SolrInputDocument();

        doc.addField("id", tb.getId());
        doc.addField("item_title", tb.getTitle());
        doc.addField("item_sell_point", tb.getSellPoint());
        doc.addField("item_price", tb.getPrice());
        doc.addField("item_image", tb.getImage());
        doc.addField("item_category_name", tbItemCatName);
        doc.addField("item_desc", desc);

        client.add(doc);

        //提交事务
        client.commit();
    }

    @Override
    public void deleteItem(long id) throws SolrServerException, IOException {
        client.deleteById(String.valueOf(id));
        client.commit();
    }

    @Override
    public Map<String, Object> searchItem(String field, int pages, int rows) throws SolrServerException, IOException{
        //新建查询体(左侧查询条件)
        SolrQuery query = new SolrQuery();
        //设置q
        query.set("q", "item_keywords:" + field);
        //过滤查询
        //query.setFilterQueries(过滤条件)
        //多条件过滤
        //query.setFilterQueries(过滤条件or|and过滤条件2)
        //排序sort
        //query.setFilterQueries(过滤条件or|and过滤条件2)
        //多条件过滤
        //query.addSort(排序规则)
        //分页规则
        query.setStart(rows * (pages - 1));
        query.setRows(rows);

        //回显（想查出来哪几个字段）
        //query.addSort(字段名1，字段名2)
        //高亮配置
        query.setHighlight(true);//启动高亮
        query.addHighlightField("item_title");//设置域名称
        query.setHighlightSimplePre("<span style='color:red'>");
        query.setHighlightSimplePost("</span>");

        //提交查询，获取查询数据
        QueryResponse res = client.query(query);

        //得到高亮数据
        Map<String, Map<String, List<String>>> highlighting = res.getHighlighting();
        //获取查询总记录数
        long numFound = res.getResults().getNumFound();

        List<Item> list = res.getBeans(Item.class);
        //重新在结果中设置高亮
        for (Item item : list) {
            Map<String, List<String>> stringListMap = highlighting.get(item.getId());
            if(null != stringListMap.get("item_title") && stringListMap.get("item_title").size() != 0)
                item.setTitle(stringListMap.get("item_title").get(0));
            item.setImages(item.getImage() == null||item.getImage().equals("")? new String[1]:item.getImage().split(","));
        }

        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("totalPages", numFound % rows == 0? numFound / rows : numFound / rows + 1);
        return map;
    }
}
