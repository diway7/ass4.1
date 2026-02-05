
public class Sculptor extends Artist {
    private String material;

    public Sculptor(String name, String surname, String country, int birthYear, String material) {
        super(name, surname, country, birthYear);
        this.material = material;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Material: " + this.material);
    }

    public String toString() {
        String var10000 = super.toString();
        return var10000 + ", Material: " + this.material;
    }
}
