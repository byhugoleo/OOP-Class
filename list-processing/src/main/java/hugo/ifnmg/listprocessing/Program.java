package hugo.ifnmg.listprocessing;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

/**
 * Class for tests
 * 
 * @author byhugoleo
 */
public class Program {
    public static void main(String[] args) {
        Integer k = 1;
        System.out.println("Test #" + k);
        {
            DecimalFormat formatter = new DecimalFormat("#0.000");
            List<Double> ins = Arrays.asList(1.0, 3.0, 5.0);
            List<Double> outs = Arrays.asList(1.0, 3.0, 5.0);
            Pair<Double, Double> ans = ListProcess.process(ins, outs);
            System.out.println(">> Test #" + k++ + " = <w0=" + formatter.format(ans.getX()) 
                        + ", w1" + formatter.format(ans.getY()) + ">");
        }
        System.out.println("Test #" + k);
        {
            DecimalFormat formatter = new DecimalFormat("#0.000");
            List<Double> ins = Arrays.asList(1.0, 3.0, 5.0);
            List<Double> outs = Arrays.asList(2.0, 4.0, 6.0);
            Pair<Double, Double> ans = ListProcess.process(ins, outs);
            System.out.println(">> Test #" + k++ + " = <w0=" + formatter.format(ans.getX()) 
                        + ", w1=" + formatter.format(ans.getY()) + ">");
        }
        System.out.println("Test #" + k);
        {
            DecimalFormat formatter = new DecimalFormat("#0.000");
            List<Double> ins = Arrays.asList(1.0, 3.0, 5.0);
            List<Double> outs = Arrays.asList(3.0, 7.0, 11.0);
            Pair<Double, Double> ans = ListProcess.process(ins, outs);
            System.out.println(">> Test #" + k++ + " = <w0=" + formatter.format(ans.getX()) 
                        + ", w1=" + formatter.format(ans.getY()) + ">");
        }
        System.out.println("Test #" + k);
        {
            DecimalFormat formatter = new DecimalFormat("#0.000");
            List<Double> ins = Arrays.asList(1.0, 3.0, 5.0);
            List<Double> outs = Arrays.asList(4.5, 12.5, 20.5);
            Pair<Double, Double> ans = ListProcess.process(ins, outs);
            System.out.println(">> Test #" + k++ + " = <w0=" + formatter.format(ans.getX()) 
                        + ", w1=" + formatter.format(ans.getY()) + ">");
        }
        System.out.println("Test #" + k);
        {
            DecimalFormat formatter = new DecimalFormat("#0.000");
            List<Double> ins = (List<Double>) Arrays.asList(2.900000095, 6.699999809, 4.900000095, 7.900000095, 9.800000191, 6.900000095, 6.099999905, 6.199999809, 6.0, 5.099999905, 4.699999809, 4.400000095, 5.800000191);
            List<Double> outs = Arrays.asList(4.0, 7.400000095, 5.0, 7.199999809, 7.900000095, 6.099999905, 6.0, 5.800000191, 5.199999809, 4.199999809, 4.0, 4.400000095, 5.199999809);
            Pair<Double, Double> ans = ListProcess.process(ins, outs);
            System.out.println(">> Test #" + k++ + " = <w0=" + formatter.format(ans.getX()) 
                        + ", w1=" + formatter.format(ans.getY()) + ">");
        }
    }
}
