package FootballBoundProperties;

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