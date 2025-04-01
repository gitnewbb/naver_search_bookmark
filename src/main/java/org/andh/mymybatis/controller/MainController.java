package org.andh.mymybatis.controller;

import jakarta.servlet.http.HttpSession;
import org.andh.mymybatis.model.vo.KeywordSearch;
import org.andh.mymybatis.service.BookmarkService;
import org.andh.mymybatis.service.SearchService;
import org.andh.mymybatis.util.MyLogger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
//@RequestMapping("/") // 이런 경우는 생략해도 무방함
public class MainController {
    final private MyLogger logger = new MyLogger(this.getClass().getSimpleName());

    // 멤버변수
    private final SearchService searchService;
    private final BookmarkService bookMarkService;
    // 구별을 굳이 안해도 돼 -> 1:1 대응이 되니까

    // 생성자 주입 -> 의존성 주입을 한 타입은? SearchService
    public MainController(SearchService searchService, BookmarkService bookMarkService) {
        this.searchService = searchService;
        this.bookMarkService = bookMarkService;
    }

    @GetMapping
    public String index(Model model, @RequestParam(value = "keyword", required = false) String keyword, HttpSession session) throws Exception {
        if (keyword == null) {
            return "index";
        }
        List<KeywordSearch> result = searchService.searchByKeyword(keyword);
        Map<String,KeywordSearch> map = new HashMap<>();
        for (KeywordSearch search : result) {
            map.put(search.uuid(), search);
        }
//        임시 uuid로 일종의 케싱
        session.setAttribute("temp",map);
        model.addAttribute("result", result);
        return "index";
    }

    @PostMapping("/bookmark")
    public String bookmark(@RequestParam("uuid") String uuid, Model model, HttpSession session) throws Exception {
        // 임시 저장 후 꺼내다 쓴 것
        Map<String, KeywordSearch> temp = (HashMap<String, KeywordSearch>) session.getAttribute("temp");
        logger.info(temp.get(uuid).link());
        bookMarkService.createBookmark(temp.get(uuid));
        return "redirect:/"; // servlet으로 보내기
    }
}