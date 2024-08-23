import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1() {
        String expression = "-1/2+1/2";
        String expected = "0/1";
        String actual = new Solution().fractionAddition(expression);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test2() {
        String expression = "1/3-1/2";
        String expected = "-1/6";
        String actual = new Solution().fractionAddition(expression);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test3() {
        String expression = "-1/4-4/5-1/4";
        String expected = "-13/10";
        String actual = new Solution().fractionAddition(expression);

        Assert.assertEquals(expected, actual);
    }


}
