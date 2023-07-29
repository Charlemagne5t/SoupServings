import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void soupServingsTest1(){
        double delta = 1e-5;
        int n = 50;
        double expected = 0.62500;
        double actual = new Solution().soupServings(n);

        Assert.assertEquals(expected, actual, delta);

    }

    @Test
    public void soupServingsTest2(){
        double delta = 1e-5;
        int n = 100;
        double expected = 0.71875;
        double actual = new Solution().soupServings(n);

        Assert.assertEquals(expected, actual, delta);

    }
}
