package tech.icey.sps.gun;

import tech.icey.util.unreachable.Unreachable;

public class GunSet {
    public enum GunPosition {
        SubMount,
        OnDeck,
        SuperMount;

        String spsName() {
            switch (this) {
            case OnDeck: return "低于干舷甲板";
            case SubMount: return "位于干舷甲板";
            case SuperMount: return "高于干舷甲板";
            }

            return Unreachable.unreachable();
        }
    }
}
