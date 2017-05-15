import java.text.DecimalFormat;

public class Timer {

	long starts, ends;

	public long set(){
		return System.nanoTime();
	}
	
	public double timeElapsed(long start, long end){
		return (end - start)/1000000000d;
	}
	
	public void printTime(double time){
		DecimalFormat df = new DecimalFormat("0");
        df.setMaximumFractionDigits(4);
        System.out.print(df.format(time));
	}

	public void start(){
		starts = set();
	}

	public void stop(){
		ends = set();
	}

	public void print(){
		printTime(timeElapsed(starts, ends));
	}

}