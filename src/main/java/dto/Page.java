package dto;

public class Page {
    //这是bootstrap的page实例属性
    /*private Integer pageIndex;
    private Integer pageSize;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    //offset用来设置每次查询的起始位置
    public Integer getOffset() {
        return (pageIndex-1)*pageSize;
    }*/

    //这是easyui的page实例属性
    private Integer page;
    private Integer rows;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getOffset(){
        return (page-1)*rows;
    }
}
