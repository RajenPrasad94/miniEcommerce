package dev.rajen.miniecommerce.services.sortingService;

import dev.rajen.miniecommerce.dtos.search.SortingCriteria;

public class SorterFactory {
    public static Sorter getSorterByCriteria(SortingCriteria criteria) {


        return switch (criteria) {
            case RELEVANCE -> null; // Relevance sorting logic can be added later
            case PRICE_LOW_TO_HIGH -> new PriceLowToHighSorter();
            case PRICE_HIGH_TO_LOW -> new PriceHighToLowSorter();
            case POPULARITY -> null;
            case RATING_LOW_TO_HIGH -> null;
            case RATING_HIGH_TO_LOW -> null;
            default -> null;
        };
    }
}
