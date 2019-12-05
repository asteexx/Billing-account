package com.netcracker.gorbunov.fapi.beClasses;

import java.util.List;

public class ChanelModelPage {
    private List<ChanelModel> content;
    private int totalPages;

    public ChanelModelPage() {
    }

    public ChanelModelPage(List<ChanelModel> content, int totalPages) {
        this.content = content;
        this.totalPages = totalPages;
    }

    public List<ChanelModel> getContent() {
        return content;
    }

    public void setContent(List<ChanelModel> content) {
        this.content = content;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
