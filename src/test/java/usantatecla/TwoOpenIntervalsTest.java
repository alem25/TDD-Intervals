package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TwoOpenIntervalsTest {

    private Point point1;
    private Point point2;
    private Point point3;
    private Point point4;

    private IntervalBuilder intervalBuilder;
    private Interval firstOpenInterval;
    private Interval secondOpenInterval;

    @BeforeEach
    public void before() {
        this.point1 = new Point(-2.2);
        this.point2 = new Point(-1.0);
        this.point3 = new Point(3.1);
        this.point4 = new Point(4.4);
        this.intervalBuilder = new IntervalBuilder();
    }

    @Test
    public void givenTwoIntervalsWhenFirstIncludeSecondIntervalThenTrue() {
        this.firstOpenInterval = this.intervalBuilder.open(this.point1.getEquals()).open(this.point4.getEquals()).build();
        this.secondOpenInterval = this.intervalBuilder.open(this.point2.getEquals()).open(this.point3.getEquals()).build();
        assertTrue(this.firstOpenInterval.includeOtherInterval(this.secondOpenInterval));
    }

}