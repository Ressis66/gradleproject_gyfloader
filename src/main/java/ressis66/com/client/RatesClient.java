package ressis66.com.client;

import ressis66.com.model.ExchangeRates;

public interface RatesClient {

    ExchangeRates getLatestRates(String appId);

    ExchangeRates getHistoricalRates(String date, String appId);
}
