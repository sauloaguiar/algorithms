import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class PointTest {

  Point point;

  @Before
  public void setUp() {
    point = new Point(1, 1);
  }

  @Test
  public void shouldReturnZeroForEqualPoints(){
    Point p = new Point(1, 1);
    assertThat(point.compareTo(p), is(equalTo(0)));
  }

  @Test
  public void shouldReturnNegativeForPointAbove() {
    Point p = new Point(1, 2);
    assertThat(point.compareTo(p), is(equalTo(-1)));
  }

  @Test
  public void shouldReturnPositiveForPointBelow() {
    Point p = new Point(1, 0);
    assertThat(point.compareTo(p), is(equalTo(1)));
  }

  @Test
  public void shouldReturnPositiveForInlineWithSmallerX() {
    Point p = new Point(0, 1);
    assertThat(point.compareTo(p), is(equalTo(1)));
  }

  @Test
  public void shouldReturnNegativeForInlineWithGreaterX() {
    Point p = new Point(2, 1);
    assertThat(point.compareTo(p), is(equalTo(-1)));
  }

  @Test
  public void shouldHaveZeroWhenSlopeIsHorizontal(){
    Point p = new Point(2, 1);
    assertThat(point.slopeTo(p), is(equalTo(0.0)));
  }

  @Test
  public void shouldHavePositiveInfinityWhenSlopeIsVertical() {
    Point p = new Point(1, 2);
    assertThat(point.slopeTo(p), is(equalTo(Double.POSITIVE_INFINITY)));
  }

  @Test
  public void shouldHaveNegativeInfinityWhenPointsAreEqual() {
    Point p = new Point(1, 1);
    assertThat(point.slopeTo(p), is(equalTo(Double.NEGATIVE_INFINITY)));
  }



}
