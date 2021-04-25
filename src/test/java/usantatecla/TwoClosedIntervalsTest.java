package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TwoClosedIntervalsTest {

    private Point point1;
    private Point point2;
    private Point point3;
    private Point point4;
    private Interval firstOpenInterval;
    private Interval secondOpenInterval;

    @BeforeEach
    public void before() {
        this.point1 = new Point(-2.2);
        this.point2 = new Point(-1.0);
        this.point3 = new Point(3.1);
        this.point4 = new Point(4.4);
    }

    @Test
    public void givenTwoIntervalsWhenFirstIntersectsSecondIntervalThenTrue() {
        this.firstOpenInterval = new IntervalBuilder().closed(this.point1.getEquals()).closed(this.point4.getEquals()).build();
        this.secondOpenInterval = new IntervalBuilder().closed(this.point2.getEquals()).closed(this.point3.getEquals()).build();
        assertTrue(this.firstOpenInterval.intersectsWithOtherInterval(this.secondOpenInterval));
    }

    @Test
    public void givenTwoIntervalsWhenFirstIntersectsSecondIntervalThenFalse() {
        this.firstOpenInterval = new IntervalBuilder().closed(this.point1.getEquals()).closed(this.point2.getEquals()).build();
        this.secondOpenInterval = new IntervalBuilder().closed(this.point3.getEquals()).closed(this.point4.getEquals()).build();
        assertFalse(this.firstOpenInterval.intersectsWithOtherInterval(this.secondOpenInterval));
    }

    @Test
    public void givenTwoIntervalsWhenFirstIntersectsSecondIntervalThenFalse2() {
        this.firstOpenInterval = new IntervalBuilder().closed(this.point3.getEquals()).closed(this.point4.getEquals()).build();
        this.secondOpenInterval = new IntervalBuilder().closed(this.point1.getEquals()).closed(this.point2.getEquals()).build();
        assertFalse(this.firstOpenInterval.intersectsWithOtherInterval(this.secondOpenInterval));
    }

    @Test
    public void givenTwoIntervalsWhenFirstIntersectsSecondIntervalThenTrue2() {
        this.firstOpenInterval = new IntervalBuilder().closed(this.point2.getEquals()).closed(this.point3.getEquals()).build();
        this.secondOpenInterval = new IntervalBuilder().closed(this.point1.getEquals()).closed(this.point4.getEquals()).build();
        assertTrue(this.firstOpenInterval.intersectsWithOtherInterval(this.secondOpenInterval));
    }
}