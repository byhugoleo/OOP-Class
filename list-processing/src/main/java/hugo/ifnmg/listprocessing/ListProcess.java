package hugo.ifnmg.listprocessing;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Class for processig Lists of Double type
 * 
 * @author byhugoleo
 */
public class ListProcess {
// Methods
    public static Pair<Double, Double> process(List<Double> ins, List<Double> outs) {
        return process(ins, outs, 2000, 0.025);
    }
    public static Pair<Double, Double> process(List<Double> ins, List<Double> outs, Integer e) {
        return process(ins, outs, e, 0.025);
    }
    public static Pair<Double, Double> process(List<Double> ins, List<Double> outs, Integer e, Double lr) {
        Double w0 = 0.0, w1 = 0.0;
        Double p, dif;
        for (int i = 1; i <= e; i++) {
            for (int k = 0; k < ins.size(); k++) {
                p = w1 * ins.get(k) + w0;
                dif = outs.get(k) - p;
                w0 += dif * lr;
                w1 += dif * lr * ins.get(k);
            }
            if (i % 10 == 0) {
                DecimalFormat formatter = new DecimalFormat("#0.000");
                System.out.println(">> [" + i + "] = <w0=" + formatter.format(w0) 
                        + ", w1=" + formatter.format(w1) + ">");
            }   
        }
        return new Pair<>(w0, w1);
    }
}
