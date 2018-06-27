package telephony;

public class Smartphone implements Callable, Browsable {

    @Override
    public String call(String number) {
        return String.format("Calling... %s", number);
    }

    @Override
    public String browse(String url) {
        return String.format("Browsing: %s!", url);
    }
}
