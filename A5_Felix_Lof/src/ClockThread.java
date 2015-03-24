import java.util.Calendar;

public class ClockThread extends Thread {

	private ClockInterface clockInterface;
	private Calendar calendar;

	public ClockThread(ClockInterface ci) {
		this.clockInterface = ci;
	}

	@Override
	public void run() {
		while (true) {
			// variabler
			calendar = Calendar.getInstance();

			int h = calendar.get(Calendar.HOUR_OF_DAY);
			int m = calendar.get(Calendar.MINUTE);
			int s = calendar.get(Calendar.SECOND);

			// uppdaterar klockan varje sek
			clockInterface.update(h, m, s);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}
}
