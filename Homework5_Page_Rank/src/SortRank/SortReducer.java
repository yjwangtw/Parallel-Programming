package page_rank;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.NullWritable;

public class SortReducer extends Reducer<SortPair, NullWritable, Text, DoubleWritable> {

    public void reduce(SortPair key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
	// output the word and average
	Text K = key.getWord();
	DoubleWritable V = new DoubleWritable(key.getAverage());
        context.write(K,V);
    }
}
