
public class Painter extends Artist {
    private String style;

    public Painter(String name, String surname, String country, int birthYear, String style) {
        super(name, surname, country, birthYear);
        this.style = style;
    }

    public String getStyle() {
        return this.style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Style: " + this.style);
    }

    public String toString() {
        String var10000 = super.toString();
        return var10000 + ", Style: " + this.style;
    }
}
