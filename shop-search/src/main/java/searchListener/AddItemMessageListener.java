package searchListener;

import interfaces.SearchItemService;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import vo.TbSearchItemC;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class AddItemMessageListener implements MessageListener{
    @Autowired
    private SolrServer solrServer;
    @Autowired
    private SearchItemService searchItemService;
    @Override
    public void onMessage(Message message) {
        try{
            //从消息中取值
            TextMessage textMessage = (TextMessage) message;
            String text = textMessage.getText();
            Long itemId = new Long(text);

            //从后台查找该商品
            TbSearchItemC item = searchItemService.searchItemById(itemId);

            //把商品添加到索引库
            SolrInputDocument document = new SolrInputDocument();
            document.addField("id",item.getId());
            document.addField("item_title", item.getTitle());
            document.addField("item_sell_point", item.getSellPoint());
            document.addField("item_price", item.getPrice());
            document.addField("item_image", item.getImage());
            document.addField("item_category_name", item.getCatName());

            //把document添加到索引库
            solrServer.add(document);

            //提交
            solrServer.commit();

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
