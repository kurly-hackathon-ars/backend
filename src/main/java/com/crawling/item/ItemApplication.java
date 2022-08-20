package com.crawling.item;

import com.crawling.item.config.ItemCategories;
import com.crawling.item.dto.ProductInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class ItemApplication {

	public static void main(String[] args) throws IOException {

		ItemCategories itemCategories = new ItemCategories();
		String[][] categories = itemCategories.getItemCategory();

		for ( String[] category : categories ) {
			Document doc = Jsoup.connect("https://www.oliveyoung.co.kr/store/display/getMCategoryList.do?dispCatNo="+category[0]+"&isLoginCnt=4&aShowCnt=0&bShowCnt=0&cShowCnt=0&gateCd=Drawer&trackingCd="+category[1]+"&rowsPerPage=400").get();
//			Document doc = Jsoup.connect("https://www.oliveyoung.co.kr/store/display/getMCategoryList.do?dispCatNo="+category[0]+"&isLoginCnt=4&aShowCnt=0&bShowCnt=0&cShowCnt=0&gateCd=Drawer&trackingCd="+category[1]).get();

			Elements divTagByClassName = doc.select(".prd_info");

			List<ProductInfo> products = new ArrayList<>();

			for ( Element productInfo : divTagByClassName ) {
				String prodName = productInfo.select(".tx_name").text();
				String imgUrl = productInfo.selectFirst("a > img").attr("src");
				String originPrice = productInfo.select(".tx_org > .tx_num").text();
				String salePrice = productInfo.select(".tx_cur > .tx_num").text();

				ProductInfo product = ProductInfo.builder()
						.imgUrl(imgUrl)
						.prodName(prodName)
						.originPrice(originPrice)
						.salePrice(salePrice)
						.build();

				products.add(product);
			}

			System.out.println(products.toString());
			break;
		}

	}

}
