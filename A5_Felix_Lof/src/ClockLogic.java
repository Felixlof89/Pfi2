public class ClockLogic implements ClockInterface {

	private DigitalClockGUI clock;
	private int alarmHour;
	private int alarmMinute;

	//startar tråden
	public ClockLogic(DigitalClockGUI clockIn) {
		this.clock = clockIn;
		Thread t = new ClockThread(this);
		t.start();
	}

	//sätter alarmet
	public void setAlarm(int hour, int minute) {
		 this.alarmHour = hour;
		this.alarmMinute = minute;
	}

	//tar bort larmet
	public void clearAlarm() {
		this.alarmHour = 100;
		this.alarmMinute = 100;
	}

	// printar
	@Override
	public void update(int h, int m, int s) {
		String time = "";
		time = (String.format("%02d", h) + " : " + String.format("%02d", m)
				+ " : " + String.format("%02d", s));

		// 
		clock.setTimeOnLabel(time);

		// kollar om tiden matchar alarmet
		if (alarmHour == h && alarmMinute == m) {
			clock.alarm(true);
		}
	}
}
