package com.crawling.item.config;

import com.crawling.item.dto.ProductInfoDto;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class ItemLists {

    private final List<List<ProductInfoDto>> products = new ArrayList<>();

}
