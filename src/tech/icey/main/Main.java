package tech.icey.main;

// import javax.swing.*;

import tech.icey.sps.gun.Gun;

public class Main {
    public static void main(String[] args) {
        System.err.println(Gun.GUN_TYPES);

        Gun gun = new Gun();
        System.err.println(gun.getName());
        System.err.println("weight = " + gun.weight());

        /*
        JFrame f = new JFrame("SPring ReSharped (SPRS) devtest");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        f.setSize(600, 800);
        f.setVisible(true);
        */
    }
}
