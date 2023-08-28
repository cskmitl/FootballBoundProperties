package FootballBoundProperties;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Scanner;

class LiveScoreBean {
    private String scoreLine;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public String getScoreLine() {
        return scoreLine;
    }

    public void setScoreLine(String newScoreLine) {
        String oldScoreLine = this.scoreLine;
        this.scoreLine = newScoreLine;
        pcs.firePropertyChange("scoreLine", oldScoreLine, newScoreLine);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }
}

class ScoreSubscriber implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("live result: " + evt.getNewValue());
    }
}

public class BoundPropertiesFootballScoreApp {
    public static void main(String[] args) {
        LiveScoreBean liveScoreBean = new LiveScoreBean();

        ScoreSubscriber subscriber1 = new ScoreSubscriber();
        ScoreSubscriber subscriber2 = new ScoreSubscriber();

        liveScoreBean.addPropertyChangeListener(subscriber1);
        liveScoreBean.addPropertyChangeListener(subscriber2);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter Score: ");
            String scoreInput = scanner.nextLine();

            if (scoreInput.isEmpty()) {
                break;
            }

            liveScoreBean.setScoreLine(scoreInput);
        }

        scanner.close();
    }
}
