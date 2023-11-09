import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class AsyncWebScraper {

    private static String fetchTitleFromURL(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            return doc.title();
        } catch (Exception e) {
            return "Error fetching from " + url + ": " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        List<String> urls = Arrays.asList(
                "https://www.google.com",
                "https://www.bing.com",
                "https://www.duckduckgo.com",
                "https://www.yandex.com",
                "https://www.baidu.com",
                "https://www.yahoo.com",
                "https://www.ask.com",
                "https://www.aol.com",
                "https://www.wolframalpha.com",
                "https://www.startpage.com"
        );

        // Starting time
        long start = System.currentTimeMillis();

        useFutureToObtainUrls(urls, start);
    }

    public static void useFutureToObtainUrls(List<String> urls, long start) {
        List<CompletableFuture<String>> futures = urls.stream()
                .map(url -> CompletableFuture.supplyAsync(() -> fetchTitleFromURL(url)))
                .collect(Collectors.toList());

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allOf.thenRun(() -> {
            futures.forEach(future -> System.out.println(future.join()));
            long duration = System.currentTimeMillis() - start;
            System.out.println("Total time taken: " + duration + "ms");
        }).join();
    }
}
