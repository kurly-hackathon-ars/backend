package com.crawling.item.controller;

import com.crawling.item.config.ItemCategories;
import com.crawling.item.config.ItemLists;
import com.crawling.item.dto.ProductInfoDto;
import com.crawling.item.entity.Product;
import com.crawling.item.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CrawlingController {

    private final ItemCategories itemCategories;
    private final ItemLists itemLists;
    private final ProductRepository productRepository;

    @GetMapping("/crawl")
    public void crawling() throws IOException {
        String[][] categories = itemCategories.getItemCategory();

        Long id = 1L;

        for ( String[] category : categories ) {
            Document doc = Jsoup.connect("https://www.oliveyoung.co.kr/store/display/getMCategoryList.do?dispCatNo="+category[0]+"&isLoginCnt=4&aShowCnt=0&bShowCnt=0&cShowCnt=0&gateCd=Drawer&trackingCd="+category[1]+"&rowsPerPage=400").get();
//			Document doc = Jsoup.connect("https://www.oliveyoung.co.kr/store/display/getMCategoryList.do?dispCatNo="+category[0]+"&isLoginCnt=4&aShowCnt=0&bShowCnt=0&cShowCnt=0&gateCd=Drawer&trackingCd="+category[1]).get();

            Elements divTagByClassName = doc.select(".prd_info");

            List<ProductInfoDto> products = new ArrayList<>();

            for ( Element productInfo : divTagByClassName ) {
                String prodName = productInfo.select(".tx_name").text();
                String imgUrl = productInfo.selectFirst("a > img").attr("src");
                String originPrice = productInfo.select(".tx_org > .tx_num").text();
                String salePrice = productInfo.select(".tx_cur > .tx_num").text();

                originPrice = originPrice.replaceAll("[,]","");
                salePrice = salePrice.replaceAll("[,]","");

                if (originPrice.isBlank()) originPrice = null;
                if (salePrice.isBlank()) salePrice = null;

                Product product = ProductInfoDto.builder()
                        .id(id)
                        .imgUrl(imgUrl)
                        .prodName(prodName)
                        .originPrice(originPrice)
                        .salePrice(salePrice)
                        .category(category[2])
                        .build().toProductEntity();

                productRepository.save(product);

                id+=1;

            }

        }
    }
}
