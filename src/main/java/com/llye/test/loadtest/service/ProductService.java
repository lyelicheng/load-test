package com.llye.test.loadtest.service;

import com.llye.test.loadtest.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ProductService {
    private final Random random = new Random();

    public List<ProductDto> getAllProducts(int pageNumber, int pageSize) throws InterruptedException {
        List<ProductDto> productDtos = buildDummyProducts();

        long delayedInMs = generateRandomDelayedMs();
        Thread.sleep(delayedInMs);

        int startIndex = pageNumber * pageSize;
        int endIndex = Math.min(startIndex + pageSize, productDtos.size());
        return productDtos.subList(startIndex, endIndex);
    }

    private List<ProductDto> buildDummyProducts() {
        return List.of(
                ProductDto.builder()
                          .id(1L)
                          .productName("Type A - LG TV")
                          .productPrice(3800.50)
                          .build(),
                ProductDto.builder()
                          .id(2L)
                          .productName("Type A - Samsung TV")
                          .productPrice(3500.50)
                          .build(),
                ProductDto.builder()
                          .id(3L)
                          .productName("Type A - Philips TV")
                          .productPrice(3000.50)
                          .build(),
                ProductDto.builder()
                          .id(4L)
                          .productName("Type A - Sony TV")
                          .productPrice(2800)
                          .build(),
                ProductDto.builder()
                          .id(5L)
                          .productName("Type A - Sharp TV")
                          .productPrice(2500)
                          .build());
    }

    private long generateRandomDelayedMs() {
        long min = 100L;
        long max = 1_000L;

        return min + (long) (random.nextDouble() * (max - min + 1));
    }
}
