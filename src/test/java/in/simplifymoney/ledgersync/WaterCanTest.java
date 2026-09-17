package in.simplifymoney.ledgersync;

import static org.junit.jupiter.api.Assertions.assertEquals;

import in.simplifymoney.ledgersync.parse.Amounts;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

public class WaterCanTest {

    @Test
    void testWaterCanAmountParsingBug() {
        String smsBody = "Rs.5 debited from a/c **4821 on 11-09-26 at 03:14 to UPI/WATER CAN. Avl Bal: Rs.92,213.10";

        // Verify that the transaction amount is correctly extracted as 5.00, NOT 92213.10
        assertEquals(new BigDecimal("5.00"), Amounts.first(smsBody));

        // Verify that the stated balance is correctly extracted as 92213.10
        assertEquals(new BigDecimal("92213.10"), Amounts.statedBalance(smsBody));
    }
}