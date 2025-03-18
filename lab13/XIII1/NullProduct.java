package lab13.XIII1;

public class NullProduct implements Product{

    @Override
    public String code() {
        return null;
    }

    @Override
    public String description() {
        return null;
    }

    @Override
    public double points() {
        return 0;
    }
    
}
