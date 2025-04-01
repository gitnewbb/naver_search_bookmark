package org.andh.mymybatis.service;

import org.andh.mymybatis.config.MyBatisConfig;
import org.andh.mymybatis.model.mapper.BookmarkMapper;
import org.andh.mymybatis.model.vo.KeywordSearch;
import org.andh.mymybatis.util.MyLogger;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class BookmarkService {
    final public MyLogger logger = new MyLogger(this.getClass().getName());

    public void createBookmark(KeywordSearch keywordSearch) {
        try (SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()) {
            BookmarkMapper mapper = session.getMapper(BookmarkMapper.class);
            int count = mapper.insertBookmark(keywordSearch);
            logger.info(count + " bookmark inserted");
            session.commit();
        }
    }
}