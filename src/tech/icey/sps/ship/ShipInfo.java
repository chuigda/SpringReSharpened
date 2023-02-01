package tech.icey.sps.ship;

public class ShipInfo {
    public enum ShipType {
        Generic,

        GunBoat,
        TorpedoBoat,
        Destroyer,

        LightCruiser,
        HeavyCruiser,
        GrandCruiser,
        BattleshipCruiser,

        PreDreadnought,
        Dreadnought,

        EscortCarrier,
        LightAircraftCarrier,
        AircraftCarrier;
    }

    private String shipName;
    private String shipDescription;
    private ShipType shipType;
    private int buildYear;

    public ShipInfo() {
        this.setShipName("新设计");
        this.setShipDescription("");
        this.setShipType(ShipType.Generic);
        this.setBuildYear(1950);
    }

    public String getShipName() {
        return shipName;
    }

    public String getShipDescription() {
        return shipDescription;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public int getBuildYear() {
        return buildYear;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public void setShipDescription(String shipDescription) {
        this.shipDescription = shipDescription;
    }

    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }

    public void setBuildYear(int buildYear) {
        this.buildYear = buildYear;
    }
}
