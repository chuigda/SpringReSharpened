package tech.icey.sps;

public class Config {
    public static Config INSTANCE = new Config();

    // 到底什么人会用英制单位啊
    public boolean preferImperialUnits;

    private Config() {
        this.preferImperialUnits = false;
    }
}
