package dto;

import java.util.ArrayList;
import java.util.List;
public class Order {
    private String sort;
    private String order;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    //多字段排序用到的属性
    public List<String> getOrderParam(){
       List<String> list = new ArrayList<String>();
       String[] sorts = sort.split(",");
       String[] orders = order.split(",");
       for(int i =0;i<sorts.length;i++){
           if("title".equals(sorts[i])){
               list.add("convert("+sorts[i]+"using gbk) "+orders[i]);
           }else{
               list.add(sorts[i]+" "+orders[i]);
           }
       }
       return list;
    }
}
