package com.onedu.demo.global.paging;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@ToString
public class Pagination {

    private int page;

    private int total;

    private int ranges;

    private int limit;

    private int totalPages;

    private int firstRangePage;

    private int lastRangePage;

    private int nextRangeFirstPage;

    private int prevRangeLastPage;

    private String baseUrl;

    /**
     *
     * @param page : 현재 페이지 번호
     * @param total : 총 레코드 개수
     * @param ranges : 페이지 구간 개수
     * @param limit : 한 페이지당 출력될 레코드 개수
     */
    public Pagination(int page, int total, int ranges, int limit) {

        this(page, total, ranges, limit, null);
    }

    public Pagination(int page, int total, int ranges, int limit, HttpServletRequest request) {

        // 기본값 처리
        page = Math.max(page, 1);

        total = Math.max(total, 0);

        ranges = ranges < 1 ? 10 : ranges;

        limit = limit < 1 ? 20 : limit;

        if (total == 0) return;

        // 전체 페이지 개수
        int totalPages = (int)Math.ceil(total / (double)limit);

        // 구간 번호
        int rangeCnt = (page - 1) / ranges;

        // 현재 구간의 시작 페이지
        int firstRangePage = rangeCnt * ranges + 1;

        // 현재 구간의 마지막 페이지
        int lastRangePage = firstRangePage + ranges - 1;

        lastRangePage = Math.min(lastRangePage, totalPages);

        // 이전 구간의 시작 페이지, 다음 구간의 시작 페이지
        int prevRangeLastPage = 0, nextRangeFirstPage = 0;

        if (rangeCnt > 0) prevRangeLastPage = firstRangePage - 1;

        // 마지막 구간
        int lastRangeCnt = (totalPages - 1) / ranges;

        if (rangeCnt < lastRangeCnt) nextRangeFirstPage = (rangeCnt + 1) * ranges + 1;

        /* QueryString 값 처리 S */
        String qs = request == null ? "" : request.getQueryString();

        if (request == null) baseUrl = "?";

        else {

            int port = request.getServerPort();

            String _port = port == 80 || port == 443 ? "" : ":" + port;

            baseUrl = String.format("%s://%s%s%s?", request.getScheme(), request.getServerName(), _port, StringUtils.hasText(request.getContextPath()) ? request.getContextPath() : "/");
        }

        if (StringUtils.hasText(qs)) baseUrl += Arrays.stream(qs.split("&"))
                .filter(s -> !s.contains("page="))
                .collect(Collectors.joining("&")) + "&";

        baseUrl += "page=";
        /* QueryString 값 처리 E */

        this.page = page;

        this.ranges = ranges;

        this.limit = limit;

        this.total = total;

        this.totalPages = totalPages;

        this.firstRangePage = firstRangePage;

        this.lastRangePage = lastRangePage;

        this.prevRangeLastPage = prevRangeLastPage;

        this.nextRangeFirstPage = nextRangeFirstPage;
    }

    /**
     * [0] : 페이지 번호 숫자
     * [1] : 페이지 Url
     *
     * @return
     */
    public List<String[]> getPages() {

        if (total == 0) return Collections.EMPTY_LIST;

        List<String[]> pages = new ArrayList<>();

        for (int i = firstRangePage; i <= lastRangePage; i++) {

            String url = baseUrl + i;

            pages.add(new String[] {"" + i, url});
        }

        return pages;
    }
}
