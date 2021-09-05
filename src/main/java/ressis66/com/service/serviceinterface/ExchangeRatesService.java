package ressis66.com.service.serviceinterface;

import java.util.List;

public interface ExchangeRatesService {

    List<String> getCharCodes();

    int getKeyForTag(String charCode);

    void refreshRates();

}