package pe.edu.upao.books.controllers.dto;

import org.springframework.data.domain.Page;

import java.util.List;

public class PageDTO<T> {
    List<T> content;
    Integer page;
    Long total;

    public PageDTO(List<T> content, Integer page, Long total) {
        this.content = content;
        this.page = page;
        this.total = total;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
