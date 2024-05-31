package com.jad.tennis_refactor_kata;


public class TennisGame2 implements TennisGame {
    private final String player1Name;
    private final String player2Name;
    public int player1Points = 0;
    public int player2Points = 0;
    public String player1Score = "";
    public String player2Score = "";

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.player1Name)) {
            this.player1Points++;
        }
        if (playerName.equals(this.player2Name)) {
            this.player2Points++;
        }
    }

    public String getScore() {
        String score = "";

        this.player1Score = TennisGame2.getPlayerScoreFromPoints(this.player1Points);
        this.player2Score = TennisGame2.getPlayerScoreFromPoints(this.player2Points);

        if (this.isPlayersPointsEqual()) {
            score = this.getEqualScore();
        }

        if (this.isPlayer1PointsHigher() || this.isPlayer2PointsHigher()) {
            score = this.player1Score + "-" + this.player2Score;
        }

        if (this.doesPlayer1HaveAdvantage()) {
            score = "Advantage player1";
        }
        if (this.doesPlayer2HaveAdvantage()) {
            score = "Advantage player2";
        }

        if (this.isPlayer1Winner()) {
            score = "Win for player1";
        }
        if (this.isPlayer2Winner()) {
            score = "Win for player2";
        }
        return score;
    }

    private static String getPlayerScoreFromPoints(int playerPoints) {
        String playerScore = "Love";
        if (playerPoints > 0) {
            if (playerPoints == 1) {
                playerScore = "Fifteen";
            }
            if (playerPoints == 2) {
                playerScore = "Thirty";
            }
            if (playerPoints == 3) {
                playerScore = "Forty";
            }
        }
        return playerScore;
    }

    private boolean isPlayersPointsEqual() {
        return this.player1Points == this.player2Points;
    }

    private String getEqualScore() {
        String score = "";
        if (this.player1Points == 0) {
            score = "Love";
        }
        if (this.player1Points == 1) {
            score = "Fifteen";
        }
        if (this.player1Points == 2) {
            score = "Thirty";
        }
        score += "-All";
        if (this.player1Points >= 3) {
            score = "Deuce";
        }
        return score;
    }

    private boolean isPlayer1PointsHigher() {
        return this.player1Points > this.player2Points;
    }

    private boolean isPlayer2PointsHigher() {
        return this.player2Points > this.player1Points;
    }

    private boolean doesPlayer1HaveAdvantage() {
        return this.player1Points > this.player2Points && this.player2Points >= 3;
    }

    private boolean doesPlayer2HaveAdvantage() {
        return this.player2Points > this.player1Points && this.player1Points >= 3;
    }

    private boolean isPlayer1Winner() {
        return this.player1Points >= 4 && this.player2Points >= 0 && (this.player1Points - this.player2Points) >= 2;
    }

    private boolean isPlayer2Winner() {
        return this.player2Points >= 4 && this.player1Points >= 0 && (this.player2Points - this.player1Points) >= 2;
    }
}