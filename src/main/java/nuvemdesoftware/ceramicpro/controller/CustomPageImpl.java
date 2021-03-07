package nuvemdesoftware.ceramicpro.controller;

import nuvemdesoftware.ceramicpro.model.Product;
import org.springframework.data.domain.*;

import java.util.ArrayList;
import java.util.List;

public class CustomPageImpl<T> extends PageImpl<T> {
    private static final long serialVersionUID = 1L;
    private PageImpl page;
    private String nextPage;
    private String previousPage;

    public CustomPageImpl(List<T> list, PageRequest pageRequest, long totalElements) {
        super(list, pageRequest, totalElements);
        this.page = new PageImpl(list, pageRequest, totalElements);

        this.nextPage = "page=1&size=10";
        this.previousPage = "page=0&size=10";
    }
}