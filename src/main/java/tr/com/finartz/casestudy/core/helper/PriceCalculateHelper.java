package tr.com.finartz.casestudy.core.helper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PriceCalculateHelper {

    public Double calculateTicketPrice(Integer totalQuota, Integer currentQuota, Double basePrice){
        double percentage = (double) (currentQuota * 100) / totalQuota;
        int raiseCount = (int) (percentage / 10);
        return basePrice + (basePrice / 10.0) * raiseCount;
    }


}
