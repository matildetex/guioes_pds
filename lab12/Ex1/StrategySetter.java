package Ex1;

import java.util.List;

public class StrategySetter {
    private List<MobilePhone> phones;
    private Strategy strategy;

    public StrategySetter(List<MobilePhone> phones) {
        this.phones = phones;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public String sort() {
        return strategy.doStrategy(phones);
    }
}
