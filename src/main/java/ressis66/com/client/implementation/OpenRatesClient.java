package ressis66.com.client.implementation;

import ressis66.com.model.ExchangeRates;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import ressis66.com.client.RatesClient;

@FeignClient(name = "OERClient", url = "${openexchangerates.url.general}")
public interface OpenRatesClient extends RatesClient {

    @Override
    @GetMapping("/latest.json")
    ExchangeRates getLatestRates(
            @RequestParam("app_id") String appId
    );

    @Override
    @GetMapping("/historical/{date}.json")
    ExchangeRates getHistoricalRates(
            @PathVariable String date,
            @RequestParam("app_id") String appId
    );
}
