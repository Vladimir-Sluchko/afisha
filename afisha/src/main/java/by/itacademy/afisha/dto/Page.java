package by.itacademy.afisha.dto;

import java.time.LocalDateTime;
import java.util.List;

public class Page<T> {
    private Long number;
    private Long size;
    private Long total_pages;
    private Long total_elements;
    private Boolean first;
    private Long number_of_elements;
    private Boolean last;
    private List<T> content;

    public Page() {
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Long total_pages) {
        this.total_pages = total_pages;
    }

    public Long getTotal_elements() {
        return total_elements;
    }

    public void setTotal_elements(Long total_elements) {
        this.total_elements = total_elements;
    }

    public Boolean getFirst() {
        return first;
    }

    public void setFirst(Boolean first) {
        this.first = first;
    }

    public Long getNumber_of_elements() {
        return number_of_elements;
    }

    public void setNumber_of_elements(Long number_of_elements) {
        this.number_of_elements = number_of_elements;
    }

    public Boolean getLast() {
        return last;
    }

    public void setLast(Boolean last) {
        this.last = last;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }
}
