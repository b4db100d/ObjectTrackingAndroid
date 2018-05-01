package org.opencv.samples.facedetect;

import org.opencv.core.Rect;

/**
 * Created by AXH5QE3 on 4/5/2018.
 */

public class TrackedPerson {
    private Rect LastKnownRectangle;
    TrackedPerson(Rect LKR) {
        LastKnownRectangle = LKR;
    }
    public float Overlap(Rect NewRect) {
        int ax1 = LastKnownRectangle.x;
        int ax2 = LastKnownRectangle.x + LastKnownRectangle.width;
        int ay1 = LastKnownRectangle.y;
        int ay2 = LastKnownRectangle.y + LastKnownRectangle.height;
        int aArea = LastKnownRectangle.width * LastKnownRectangle.height;
        int bx1 = NewRect.x;
        int bx2 = NewRect.x + NewRect.width;
        int by1 = NewRect.y;
        int by2 = NewRect.y + NewRect.height;
        int bArea = NewRect.width*NewRect.height;
        int maxX = Math.max(ax1, bx1);
        int minX = Math.min(ax2, bx2);
        int maxY = Math.max(ay1, by1);
        int minY = Math.min(ay2, by2);
        int intersect = Math.max(0, minX - maxX) * Math.max(0, minY - maxY);
        //int union = aArea + bArea - intersect;
        //float overlap = (float) intersect / (float) union;
        float overlap1 = (float) intersect / (float) aArea;
        float overlap2 = (float) intersect / (float) bArea;
        float overlap = Math.max(overlap1, overlap2);
        return overlap;
    }
    public void updateLKR(Rect newLKR) { LastKnownRectangle = newLKR; }
}
