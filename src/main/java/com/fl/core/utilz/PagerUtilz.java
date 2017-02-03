package com.fl.core.utilz;

import org.springframework.stereotype.Component;

@Component
public class PagerUtilz {
    
    public Integer getPageCount(Long recordsCount, Integer recordsOnPage) {
        Integer pageCount = 1;
        if (recordsCount != null) {
            pageCount = (int) (recordsCount / recordsOnPage);
            if (recordsCount % recordsOnPage > 0)
                pageCount++;
        }
        return pageCount;
    }
    
    public Integer getPage(Integer page, Integer pageCount) {
        if (page > pageCount)
            return pageCount;
        if (page < 1)
            return 1;
        return page;
    }
}
