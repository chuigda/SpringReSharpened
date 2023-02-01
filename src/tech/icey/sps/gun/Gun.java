package tech.icey.sps.gun;

import java.util.List;

import tech.icey.sps.Config;
import tech.icey.util.EnumUtil;
import tech.icey.util.Pair;
import tech.icey.util.unreachable.Todo;
import tech.icey.util.unreachable.Unreachable;

public class Gun {
    public enum GunType {
        MuzzleGun,
        BreechGun,

        AntiAirGun,
        DualPurposeGun,

        RapidFireGun,
        AutoRapidFireGun,
        MachineGun;

        public String spsName() {
            switch (this) {
            case MuzzleGun: return "前膛炮";
            case BreechGun: return "后膛炮";

            case AntiAirGun: return "防空炮";
            case DualPurposeGun: return "高平两用炮";

            case RapidFireGun: return "速射炮";
            case AutoRapidFireGun: return "自动速射炮";
            case MachineGun: return "机关炮";
            }

            return Unreachable.unreachable();
        }

        public String describe() {
            return Todo.todo();
        }

        public double weightAdj(double mountAdj) {
            // GunControl.cs F:gunWeightCalc L:652
            switch (this) {
            case MuzzleGun:
                return mountAdj < 0.6 ? 0.9 : 0.98;
            case RapidFireGun:
                return mountAdj < 0.6 ? 1.35 : 1.0;
            case AntiAirGun:
                return mountAdj < 0.6 ? 1.44 : 1.0;
            case DualPurposeGun:
                return mountAdj < 0.6 ? 1.57 : 1.1;
            case AutoRapidFireGun:
                return mountAdj < 0.6 ? 2.16 : 1.5;
            default:
                return 1.0;
            }
        }
    }

    public enum MountType {
        SideGun,
        DeckGun,
        DeckGunWithFeeder,
        Casemete,
        ColesEricssonTurret,
        OpenArmoredTurret,
        ArmoredTurret;

        public String spsName() {
            switch (this) {
            case SideGun: return "侧舷炮座";
            case DeckGun: return "甲板炮座";
            case DeckGunWithFeeder: return "带输弹机的甲板炮座";
            case Casemete: return "炮郭炮座";

            case ColesEricssonTurret: return "科尔斯/爱立信式旋转炮塔";
            case ArmoredTurret: return "开放式装甲炮塔";
            case OpenArmoredTurret: return "安装装甲炮座的旋转炮塔";
            }

            return Unreachable.unreachable();
        }

        public String describe() {
            return Todo.todo();
        }

        public double weightAdj() {
            // GunControl.cs F:gunWeightCalc L:633
            switch (this) {
            case SideGun: return 0.83;
            case OpenArmoredTurret: return 3.33;
            case DeckGunWithFeeder: return 3.15;
            case DeckGun: case Casemete: return 1.08;
            case ArmoredTurret:
            case ColesEricssonTurret: return 3.5;
            }

            return Unreachable.unreachable();
        }

        public double mountAdj() {
            // GunControl.cs F:mountChoiceSelectedIndexChanged L:795
            switch (this) {
            case SideGun: return 0.5;
            case ColesEricssonTurret: return 1.0;
            case OpenArmoredTurret: return 0.7;
            case ArmoredTurret: return 1.0;
            case DeckGunWithFeeder: return 1.0;
            case DeckGun: return 0.5;
            case Casemete: return 0.5;
            }

            return Unreachable.unreachable();
        }
    }

    public enum GunsInMount {
        Single,
        VerticalDuplex,
        VerticalQuadruple,
        Duplex,
        IndependentDuplex,
        DoubleRowQuadruple,
        Triplet,
        IndependentTriplet,
        DoubleRowSextuple,
        Quadruple,
        IndependentQuadruple,
        DoubleRowOctuple,
        Pentuple,
        IndependentPentuple,
        DoubleRowTenCouplets;

        String spsName() {
            switch (this) {
            case Single: return "单装";
            case VerticalDuplex: return "纵向双联";
            case VerticalQuadruple: return "纵向四联";
            case Duplex: return "双联";
            case IndependentDuplex: return "";
            case DoubleRowQuadruple: return "";
            case Triplet: return "";
            case IndependentTriplet: return "";
            case DoubleRowSextuple: return "";
            case Quadruple: return "";
            case IndependentQuadruple: return "";
            case DoubleRowOctuple: return "";
            case Pentuple: return "";
            case IndependentPentuple: return "";
            case DoubleRowTenCouplets: return "";
            }

            return Unreachable.unreachable();
        }

        int barrels() {
            switch (this) {
            case Single: return 1;

            case VerticalDuplex: return 2;
            case Duplex: return 2;
            case IndependentDuplex: return 2;

            case VerticalQuadruple: return 4;
            case DoubleRowQuadruple: return 4;
            case Quadruple: return 4;
            case IndependentQuadruple: return 4;

            case Triplet: return 3;
            case IndependentTriplet: return 3;

            case Pentuple: return 5;
            case IndependentPentuple: return 5;

            case DoubleRowSextuple: return 6;
            case DoubleRowOctuple: return 8;
            case DoubleRowTenCouplets: return 10;
            }

            return Unreachable.unreachable();
        }

        double weightCoefficient() {
            switch (this) {
            case Duplex:
            case Triplet:
            case Quadruple:
            case Pentuple:
                return 0.75;

            default:
                return 1.0;
            }
        }

        Pair<Double, Double> mountWidth() {
            // GunControl.cs F:diameterCalc L:873-907
            switch (this) {
            case Single: case VerticalDuplex: case VerticalQuadruple:
                return new Pair<>(1.44, 0.609725);
            case Duplex: case IndependentDuplex: case DoubleRowQuadruple:
                return new Pair<>(1.52, 0.4205);
            case Triplet: case IndependentTriplet: case DoubleRowSextuple:
                return new Pair<>(1.64, 0.29);
            case Quadruple: case IndependentQuadruple: case DoubleRowOctuple:
                return new Pair<>(1.8, 0.2);
            case Pentuple: case IndependentPentuple: case DoubleRowTenCouplets:
                return new Pair<>(2.0, 0.14);
            }

            return Unreachable.unreachable();
        }
    }

    public static final List<GunType> GUN_TYPES =
            EnumUtil.enumerate(GunType.class);
    public static final List<MountType> MOUNT_TYPES =
            EnumUtil.enumerate(MountType.class);
    public static final List<GunsInMount> GUNS_IN_MOUNT_TYPES =
            EnumUtil.enumerate(GunsInMount.class);

    private static double dateGunAdj(int date) {
        if (date < 1850 || date > 1950) {
            return Unreachable.unreachable();
        }

        double coefficient;

        // Mainform.cs L:1119
        if (date <= 1890) {
            coefficient = 1.0 - (double)(1890 - date) / 66.6666666667;
        } else {
            coefficient = 1.0;
        }

        // GunControl.cs L:269
        return Math.sqrt(coefficient);
    }

    private String name;
    private int year;
    private GunType gunType;
    private MountType mountType;
    private GunsInMount gunsInMount;
    private double calibre;
    private double calibreLength;

    public Gun() {
        this.year = 1950;
        this.gunType = GunType.BreechGun;
        this.mountType = MountType.DeckGun;
        this.gunsInMount = GunsInMount.Single;
        this.calibre = 10;
        this.calibreLength = 45;

        generateName();
    }

    public String getName() {
        return this.name;
    }

    public int getYear() {
        return this.year;
    }

    public GunType getGunType() {
        return this.gunType;
    }

    public MountType getMountType() {
        return this.mountType;
    }

    public GunsInMount getGunsInMount() {
        return this.gunsInMount;
    }

    public double getCalibre() {
        return this.calibre;
    }

    public double getCalibreLength() {
        return this.calibreLength;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGunType(GunType gunType) {
        this.gunType = gunType;
    }

    public void setMountType(MountType mountType) {
        this.mountType = mountType;
    }

    public void setGunsInMount(GunsInMount gunsInMount) {
        this.gunsInMount = gunsInMount;
    }

    public void setCalibre(int calibre) {
        this.calibre = calibre;
    }

    public void setCalibreLength(double calibreLength) {
        this.calibreLength = calibreLength;
    }

    public void generateName() {
        String calibreText;
        if (Config.INSTANCE.preferImperialUnits) {
            calibreText = this.calibre + "吋";
        } else {
            calibreText = this.calibre * 25.4 + "毫米";
        }

        this.name = "未命名 " + calibreText + " " + calibreLength + "倍径 " + gunsInMount.spsName() + " " + gunType.spsName() + " (" + year + ")";
    }

    public double weight() {
        // GunControl.cs F:shellWeightCalc L:596
        double gunWeight = Math.pow(calibre, 3.0) / 1.9830943211886;
        if (calibreLength < 45.0) {
            gunWeight *= (45.0 - Math.sqrt(45.0 - calibreLength)) / 45.0f;
        } else {
            gunWeight *= (45.0 + Math.sqrt(calibreLength - 45.0)) / 45.0f;
        }
        gunWeight *= dateGunAdj(year);
        // GunControl.cs F:gunWeightCalc L:627
        gunWeight *= calibreLength / 812.389434917877 
                * (1.0 + Math.pow(1.0 / calibre, 2.3297949327695)) 
                * gunsInMount.barrels();

        // GunControl.cs F:gunWeightCalc L:624-700
        double mountWeight;
        if (calibre > 1.0) {
            double mountAdj = mountType.mountAdj();
            mountWeight = mountType.weightAdj() 
                    * gunType.weightAdj(mountAdj);
            mountWeight *= gunWeight;
            if (calibre > 10.0) {
                mountWeight *= 1.0 - 2.16237688064575 * calibre / 100.0;
            }
        } else {
            mountWeight = gunWeight;
        }

        // GunControl.cs F:diameterCalc
        /*
        Pair<Double, Double> mountWidth = gunsInMount.mountWidth();
        double num = mountWidth.first();
        double y = mountWidth.second();
        double gunDiameter = 
                num 
                * calibre 
                * (1.0 + Math.pow(1.0 / calibre, y));
        if (calibre < 12.0) {
            gunDiameter += 12.0 / calibre;
        }
        if (calibre > 1.0 && mountType.weightAdj() < 1.0) {
            gunDiameter *= 0.9;
        }

        // GunControl.cs F:armWeightCalc L:824-869
        double gunHouseHeight;
        if (mountType != MountType.ColesEricssonTurret) {
            gunHouseHeight = Math.max(7.5, 0.625 * calibre);
        } else {
            gunHouseHeight = Math.max(7.5, 0.625 * 2 * calibre);
        }

        double armorWeight;
        */

        return gunWeight + mountWeight;
    }
}
