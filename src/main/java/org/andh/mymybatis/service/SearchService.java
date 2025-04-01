package org.andh.mymybatis.service;

import org.andh.mymybatis.model.vo.KeywordSearch;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

//@Service // Spring Container 에 Component 로 등록
public interface SearchService {
    List<KeywordSearch> searchByKeyword(String keyword) throws Exception;
}