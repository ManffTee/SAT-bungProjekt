package Übungen.A_3;

public class GameInformations {

    private Player currentPlayer;
    private int numberOfRows;
    private int numberOfColumns;
    private Player[] playerArr;
    private char[][] field;
    private int roundCount;
    private Player winner;

    public GameInformations() {
        //max 2 Players
        playerArr = new Player[2];
        this.roundCount = 0;
        this.winner = null;
    }

    public boolean initGameInformations(String playerName1, String playerName2, int numberOfRows, int numberOfColumns){
        boolean result;

        if(this.getNumberOfColumns() != 0)
            return false;

        result = this.setNumberOfRows(numberOfRows);
        result = this.setNumberOfColumns(numberOfColumns);

        if(result){
            this.playerArr[0] = new Player(playerName1, 'o');
            this.playerArr[1] = new Player(playerName2, '+');
            this.field = new char[this.numberOfRows][numberOfColumns];
        }

        return result;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    public boolean setNumberOfRows(int numberOfRows){
        //wenn die Zahl noch ihren default-value besitzt
        //und der übergebene Wert nicht kleiner als 4 ist
        if(this.numberOfRows == 0 && numberOfRows <= 4)
        {
            this.numberOfRows = numberOfRows;
            return true;
        }
        else
            return false;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public boolean setNumberOfColumns(int numberOfColumns) {
        //wenn die Zahl noch ihren default-value besitzt
        //und der übergebene Wert nicht kleiner als 4 ist
        if(this.numberOfColumns == 0 && numberOfColumns <= 4)
        {
            this.numberOfColumns = numberOfRows;
            return true;
        }
        else
            return false;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public int getMaxMoverCounter() {
        return this.numberOfColumns * this.numberOfRows;
    }

    public Player[] getPlayerArr() {
        return playerArr;
    }

    public char[][] getField() {
        return field;
    }

    public void setFieldValue(int row, int column, char symbol) {
        this.field[row][column] = symbol;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public void setRoundCount() {
        this.roundCount++;
    }


    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
