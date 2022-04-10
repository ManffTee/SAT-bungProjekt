package Übungen.A_3;

import java.io.InputStream;
import java.io.PrintStream;

public class VierGewinnt {

    private final UserInteraction view;
    private final GameInformations model;

    public VierGewinnt(InputStream in, PrintStream out) {
        view = new UserInteraction(in, out);
        model = new GameInformations();
    }

    public void play(){
        //init Gameinformations
        if(!model.initGameInformations(
                this.view.inputString("Name von SpielerIn A\t\t\t: "),
                this.view.inputString("Name von SpielerIn B\t\t\t: "),
                this.view.inputInt("Breite des Spielfeldes (mindestens 4)\t: ", 4),
                this.view.inputInt("Hoehe des Spielfeldes (mindestens 4)\t: ", 4)
        )){
            this.view.outputString("Spiel existiert bereits!");
            return;
        }

        if(gameLoop() == null){
            this.spielUnentschieden();
        } else{
            this.spielFertig();
        }

    }

    public Character gameLoop(){
        Integer inputColumn = 0;

        while (this.model.getRoundCount() < this.model.getMaxMoverCounter()) {
            this.model.setCurrentPlayer((this.model.getRoundCount() % 2 == 0) ? this.model.getPlayerArr()[0] :  this.model.getPlayerArr()[1]);
            showField();

            inputColumn = this.view.inputIntMinMaxError(
                    "\n"+ this.model.getCurrentPlayer().getName() + "(" + this.model.getCurrentPlayer().getSymbol() + ") ist am Zug. Bitte gib die Spalte ein: ",
                    1,
                    this.model.getNumberOfColumns(),
                    "Feld existriert nicht.. Bitte versuch es nochmal!");

            if(inputColumn != null){
                this.model.setRoundCount();
                this.setField(inputColumn);

                if(this.model.getWinner() != null){
                    return this.model.getWinner().getSymbol();
                }
            }
        }
        return null;
    }


    /**
     *  Unentschieden
     */
    void spielUnentschieden() {
        this.showField();
        this.view.outputString("Unentschieden");
    }

    /**
     * liefert den Gewinner
     */
    void spielFertig() {
        this.showField();
        this.view.outputString(this.model.getCurrentPlayer() + " hat gewonnen\n");
    }

    /**
     * Zeigt das komplette Spielfeld auf dem Bildschirm
     */
    void showField() {
        StringBuffer Geruest = new StringBuffer();
        StringBuffer row_start = new StringBuffer(" "); // erste Zeile 1 2 3 4
        StringBuffer row_divide = new StringBuffer("|"); // Trennzeile |-----|
        StringBuffer row_end = new StringBuffer("-"); // letzte Zeile -------

        if (this.model.getField()[0].length > 9) {
            for (int i = 1; i <= this.model.getField()[0].length; i++)
                row_start.append((i/10==0) ? " " : i/10).append(" ");
            row_start.append("\n ");
        }
        for (int i = 1; i <= this.model.getField()[0].length; i++) {
            row_start.append(i%10).append(" ");
            row_divide.append((i==this.model.getField()[0].length)? "-|" : "--");
            row_end.append("--");
        }
        this.view.outputString(row_start.toString());
        this.view.outputString(row_divide.toString());

        for (char[] arrZeile : this.model.getField()) { //iteriere durch alle Zeilen
            for (char arrSpalte : arrZeile) { //iteriere durch alle Spalten
                Geruest.append("|");
                Geruest.append((arrSpalte == '\0') ? ' ' : arrSpalte);
            }
            Geruest.append("|\n");
        }
        Geruest.append(row_end).append("\n");
        this.view.outputString(Geruest.toString());
    }

    /**
     * Spalte wird übergeben und das Feld wird gesetzt
     * @param column -> eingegebene Spalte
     */
    void setField(int column) {
        column--; // Weil der gemeine Mensch denkt, der Zahlenbereich würde sich von 1 bis 4 erstrecken
        int pos2check;
        if (this.model.getField()[0][column] != '\0'){
            this.view.outputString("Die Reihe ist voll.. Pech!");
        }
        for (int i = 0; i < this.model.getField().length; i++) { //Iteriere durch die Zeilen
            if (i + 1 == this.model.getField().length) {
                // Nach der letzten Zeile kommt nichts mehr..
                // also darf in das aktuelle Kästchen geschrieben werden, obwohl im
                // nächsten nichts steht
                pos2check = i;
                if (this.model.getField()[pos2check][column] == '\0') {
                    this.model.setFieldValue(i, column, this.model.getCurrentPlayer().getSymbol());
                    if(GameLogic.IsGameOver(this.model.getField(), i, column, this.model.getCurrentPlayer().getSymbol())) {// Hat jmd gewonnen?
                        this.view.outputString("Spieler mit "+this.model.getCurrentPlayer().getSymbol()+"hat gewonnen");
                        this.model.setWinner(this.model.getCurrentPlayer());
                        return;
                    }
                    break;
                }

            } else {
                //Überprüfe immer das folgende Feld
                pos2check = i+1;
                if (this.model.getField()[pos2check][column] != '\0') {
                    this.model.setFieldValue(i, column, this.model.getCurrentPlayer().getSymbol());
                    if(GameLogic.IsGameOver(this.model.getField(), i, column, this.model.getCurrentPlayer().getSymbol())) {// Hat jmd gewonnen?
                        this.view.outputString("Spieler mit "+this.model.getCurrentPlayer().getSymbol()+"hat gewonnen");
                        this.model.setWinner(this.model.getCurrentPlayer());
                        return;
                    }
                    break;
                }
            }
        }
    }
}
