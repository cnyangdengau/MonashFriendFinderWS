/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST.service;

/**
 *
 * @author Yang-Deng
 */
public class CalculateDistance {
    public static double CalculateDistance(double lat1, double long1, double lat2, double long2) {
        double GapA, GapB, Radius;
        Radius = 6378137; // earth radius（m）
        lat1 = lat1 * Math.PI / 180.0;
        lat2 = lat2 * Math.PI / 180.0;
        GapA = lat1 - lat2;
        GapB = (long1 - long2) * Math.PI / 180.0;
        double distance;
        double sa2, sb2;
        sa2 = Math.sin(GapA/2.0);
        sb2 = Math.sin(GapB/2.0);
        distance = 2 * Radius * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(sa2) * Math.cos(lat2) * sb2 * sb2));
        return distance;
    }
}
