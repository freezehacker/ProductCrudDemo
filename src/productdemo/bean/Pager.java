package productdemo.bean;

import java.util.List;

/**
 * Created by sjk on 17-2-13.
 * Page:页
 * Record:记录
 */
public class Pager<T> {

    private List<T> recordList;
    private int pageOrder;  // 在可见页数中的顺序
    private int pageSize;
    private int pageIndex;  // 当前页在总页数中的顺序
    private int pageCount;
    private int pageStart;  // 可见页数的左边界
    //private int pageEnd;  // pageEnd = pageStart + pageSize
    private String url;


    public List<T> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<T> recordList) {
        this.recordList = recordList;
    }

    public int getPageOrder() {
        return pageOrder;
    }

    public void setPageOrder(int pageOrder) {
        this.pageOrder = pageOrder;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageStart() {
        return pageStart;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = pageStart;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
