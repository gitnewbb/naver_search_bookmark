package org.andh.mymybatis.model.vo;

import org.springframework.stereotype.Service;

public record KeywordSearch(String uuid, String title, String link, String description, String date, String createdAt) {
}