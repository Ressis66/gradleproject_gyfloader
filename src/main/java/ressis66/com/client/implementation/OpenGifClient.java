package ressis66.com.client.implementation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import java.util.Map;
import ressis66.com.client.GifClient;

@FeignClient(name = "giphyClient", url = "${giphy.url.general}")
public interface OpenGifClient extends GifClient {

    @Override
    @GetMapping("/random")
    ResponseEntity<Map> getRandomGif(
            @RequestParam("api_key") String apiKey,
            @RequestParam("tag") String tag
    );

}