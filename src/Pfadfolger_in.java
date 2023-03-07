import java.io.*;
import java.util.*;

/**
 * Die Klasse implementiert eine Pfadfolger:in, die eine Wegbeschreibung
 * zu einem Schatz aus einer Datei einliest und nach dieser navigiert. In
 * der Wegbeschreibung steht eine Abfolge von Richtungen, in die sie in
 * der Methode "bewege" gehen muss. Kann die Datei nicht gefunden werden,
 * bleibt die Pfadfolger_in einfach stehen.
 */
class Pfadfolger_in
{
    /** Die Figur, die gesteuert wird. */
    private final GameObject figur;

    // Hier weitere Attribute, falls ihr welche benötigt

    /**
     * Konstruktor der Klasse Pfadfolger_in.
     * @param figur Die gesteuerte Figur.
     * @param dateiname Der Name der Datei, in der die Wegbeschreibung
     *         gespeichert ist. In der Datei stehen einfach, durch
     *         Leerraum getrennt, die Richtungen (Parameter von
     *         "setRotation"), in die der Reihe nach gegangen werden
     *         muss.
     */
    Pfadfolger_in(final GameObject figur, final String dateiname)
    {
        this.figur = figur;

        // Datei einlesen
    }
    /**
     * Wenn die Wegbeschreibung erfolgreich gelesen werden konnte, muss
     * bei jedem Aufruf der nächste Eintrag der Wegbeschreibung als
     * Rotation gesetzt werden. Die Figur macht dann einen Schritt in
     * die entsprechende Richtung. Ist die Wegbeschreibung vollständig
     * abgearbeitet und der Schatz somit erreicht oder konnte keine
     * Wegbeschreibung eingelesen werden, muss false zurückgeliefert
     * werden.
     * @return true, wenn die Figur einen Schritt vorwärts machen soll.
     *         false, wenn der Schatz erreicht wurde oder die
     *         Wegbeschreibung nicht lesbar war.
     */
    boolean bewege()
    {
        return false; // Ersetzen
    }

    /**
     * Die Testmethode. Bei richtiger Implementierung folgt die eine Figur
     * dem Weg in der Datei "pfad.txt" und bleibt stehen, wenn das Ziel
     * erreicht wurde. Insbesondere sollte dann auch das Programm anhalten.
     * Die andere (transparente) Figur bewegt sich hingegen nicht.
     */
    public static void main(String[] args)
    {
        final GameObject[] figuren = {
            new GameObject(8, 16, 0, "woman"),
            new GameObject(4, 3, 0, "ghost")
        };
        final Pfadfolger_in[] instanzen = {
            new Pfadfolger_in(figuren[0], "pfad.txt"),
            new Pfadfolger_in(figuren[1], "fehlt.txt")
        };
        final int[][] versatz = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        boolean weiter = true;
        while (weiter) {
            weiter = false;
            for (int i = 0; i < figuren.length; ++i) {
                if (instanzen[i].bewege()) {
                    final GameObject figur = figuren[i];
                    figur.setLocation(figur.getX() + versatz[figur.getRotation()][0],
                                      figur.getY() + versatz[figur.getRotation()][1]);
                    weiter = true;
                }
            }
            Game.sleep(100);
        }
    }
}
