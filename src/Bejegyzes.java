import java.time.LocalDateTime;

public class Bejegyzes {

    private String szerzo;
    private String tartalom;
    private int likes;
    private LocalDateTime letrejott;
    private LocalDateTime szerkesztve;

    public Bejegyzes(String szerzo, String tartalom) {
        this.szerzo = szerzo;
        this.tartalom = tartalom;
        this.likes = 0;
        this.letrejott = LocalDateTime.now();
        this.szerkesztve = LocalDateTime.now();
    }

    public String getSzerzo() {
        return szerzo;
    }

    public String getTartalom() {
        return tartalom;
    }

    public void setTartalom(String tartalom) {
        this.tartalom = tartalom;
        this.szerkesztve = LocalDateTime.now();
    }

    public int getLikes() {
        return likes;
    }

    public LocalDateTime getLetrejott() {
        return letrejott;
    }

    public LocalDateTime getSzerkesztve() {
        return szerkesztve;
    }

    public void Like() {
        this.likes++;
    }

    @Override
    public String toString() {
        if (this.szerkesztve == this.letrejott) {
            return this.szerzo + " - " + this.likes + " - " + this.letrejott + "\n" + this.tartalom + "\n" + "---------------------" + "\n";
        }
        else {
            return this.szerzo + " - " + this.likes + " - " + this.letrejott + "\n" + "Szerkesztve:" + this.szerkesztve + "\n" + this.tartalom + "\n" + "---------------------" + "\n";
        }
    }
}
