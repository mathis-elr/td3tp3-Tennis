
public interface TennisGame {
    void SetP1Score(int number);
    void SetP2Score(int number);
    void wonPoint(String playerName);
    String getScore();
}