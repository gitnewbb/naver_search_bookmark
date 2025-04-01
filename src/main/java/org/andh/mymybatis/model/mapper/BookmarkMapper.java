package org.andh.mymybatis.model.mapper;

import org.andh.mymybatis.model.vo.KeywordSearch;
import org.andh.mymybatis.model.vo.KeywordSearchDTO;

public interface BookmarkMapper {
    int insertBookmark(KeywordSearch keywordSearch);
}