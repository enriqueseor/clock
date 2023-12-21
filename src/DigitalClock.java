import java.util.Observable;

public class DigitalClock extends Observable implements Runnable {

    private int hours, minutes, seconds;

    public DigitalClock(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    @Override
    public void run() {
        String time;
        try {
            while (true) {
                time = "";
                if (hours < 10) {time += "0" + hours;} else {time += hours;}
                time += ":";
                if (minutes < 10) {time += "0" + minutes;} else {time += minutes;}
                time += ":";
                if (seconds < 10) {time += "0" + seconds;} else {time += seconds;}
                this.setChanged();
                this.notifyObservers(time);
                this.clearChanged();
                Thread.sleep(1000);
                seconds++;
                if (seconds == 60) {
                    minutes++;
                    seconds = 0;
                    if (minutes == 60) {
                        minutes = 0;
                        hours++;
                        if (hours == 24) {
                            hours = 0;
                        }
                    }
                }
            }
        } catch (InterruptedException ex) {
            System.out.println("Error111");
        }
    }
}