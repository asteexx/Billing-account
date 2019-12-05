package com.netcracker.gorbunov.backend.chanelPageConverter;

import java.util.List;

public class ChanelEntityPage<T> {
    private List<T> content;
    private int totalPages;

    public ChanelEntityPage() {
    }

    public ChanelEntityPage(List<T> content, int totalPages) {
        this.content = content;
        this.totalPages = totalPages;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
