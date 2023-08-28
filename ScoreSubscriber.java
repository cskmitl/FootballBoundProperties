package FootballBoundProperties;

class ScoreSubscriber implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("live result: " + evt.getNewValue());
    }
}
