package measurements;

import java.time.LocalTime;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SliderData {
	private int value;
	private LocalTime time;

	/**
	 * This method should return a List of data's where the following things have
	 * been filtered out of and replaced by the average value. so that only the the
	 * data points where the user hangs for longer on one value or switches from
	 * direction in sliding
	 * <p>
	 * 
	 * So when the user slides back and forth quickly it should
	 * 
	 * @param data
	 * @return
	 */
	public List<SliderData> filter(List<SliderData> data) {
		if(data == null) {
			throw new IllegalArgumentException("empty data set");
		}
		
		long temp = getSeconds(data.get(0).getTime());
		data.stream().collect(Collectors.groupingBy(d -> {
			long t = getSeconds(d.getTime());
			long avarageSec = (temp-t)%500+t;
			
			
			return false;
		}));

		return data;
	}

	private long getSeconds(LocalTime time) {
		return time.toNanoOfDay();
	}

	public SliderData(int value, LocalTime time) {
		this.value = value;
		this.time = time;
	}

	public int getValue() {
		return value;
	}

	public LocalTime getTime() {
		return time;
	}

	public String toString() {
		return "(" + time + "," + value + ")";
	}

}
