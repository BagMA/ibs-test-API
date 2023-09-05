package ibs;

public class PojoFood {

    private String name;
    private String type;
    private boolean exotic;
    private String typeBD;

    public PojoFood(String name, String type, boolean exotic, String typeBD) {
        this.name = name;
        this.type = type;
        this.exotic = exotic;
        this.typeBD = typeBD;
    }

    public String getTypeBD() {
        return typeBD;
    }

    public void setTypeBD(String typeBD) {
        this.typeBD = typeBD;
    }

    public PojoFood() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isExotic() {
        return exotic;
    }

    public void setExotic(boolean exotic) {
        this.exotic = exotic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PojoFood{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", exotic=" + exotic +
                ", typeBD='" + typeBD + '\'' +
                '}';
    }

    public String postBody() {
        return String.format("{\"name\":\"%s\", \"type\":\"%s\",\"exotic\":%s}",
                name, typeBD, exotic);
    }
}
