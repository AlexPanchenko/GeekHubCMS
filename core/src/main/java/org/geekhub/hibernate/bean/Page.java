package org.geekhub.hibernate.bean;

import java.util.List;

/**
 * Created by Odahovskiy on 18.05.2015.
 */
public class Page<T> {
    private List<T> list;
    private int begin;
    private int current;
    private int end;
    private int size;
    private int maxPages;
    private int resPerPage;

    public Page() {
    }

    public Page(List<T> list, int begin, int current, int size, int maxPages, int resPerPage, int end) {
        this.list = list;
        this.begin = begin;
        this.current = current;
        this.size = size;
        this.maxPages = maxPages;
        this.resPerPage = resPerPage;
        this.end = end;
    }

    public Page(List<T> list, int current, int maxPages) {
        this.list = list;
        this.current = current;
        this.maxPages = maxPages;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMaxPages() {
        return maxPages;
    }

    public void setMaxPages(int maxPages) {
        this.maxPages = maxPages;
    }

    public int getResPerPage() {
        return resPerPage;
    }

    public void setResPerPage(int resPerPage) {
        this.resPerPage = resPerPage;
    }
}