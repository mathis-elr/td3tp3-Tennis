import java.util.Objects;

public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;

    private String player1Name = "";
    private String player2Name = "";

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){

        // Egalité
        if (P1point == P2point)
        {
            return switch (P1point) {
                case 0 -> "Love-All";
                case 1 -> "Fifteen-All";
                case 2 -> "Thirty-All";
                default -> "Deuce";
            };
        }

        // Avantage ou victoire
        if (P1point >= 4 || P2point >= 4) {
            int diff = P1point - P2point;

            if (diff == 1)  return "Advantage player1";
            if (diff == -1) return "Advantage player2";
            if (diff >= 2)  return "Win for player1";

            return "Win for player2";
        }

        // Score en cours
        return toNomPoint(P1point) + "-" + toNomPoint(P2point);
    }
    
    public void SetP1Score(int number){
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
    }
    
    public void SetP2Score(int number){
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
    }

    public void wonPoint(String player) {
        if (Objects.equals(player, "player1"))
            P1Score();
        else
            P2Score();
    }

    private void P1Score(){
        P1point++;
    }
    
    private void P2Score(){
        P2point++;
    }

    private String toNomPoint(int point) {
        return switch (point) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> throw new IllegalArgumentException("Point invalide: " + point);
        };
    }
}