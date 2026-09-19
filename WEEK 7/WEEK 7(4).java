class TrafficLight {
    private final String id;
    private String color;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    public String getColor() {
        return this.color;
    }

    public void next() {
        if (color.equals("RED")) {
            color = "GREEN";
        } else if (color.equals("GREEN")) {
            color = "YELLOW";
        } else if (color.equals("YELLOW")) {
            color = "RED";
        }
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("t.getColor() -> " + t.getColor());

        t.next();
        System.out.println("t.next() -> " + t.getColor());

        t.next();
        System.out.println("t.next() -> " + t.getColor());

        t.next();
        System.out.println("t.next() -> " + t.getColor());
    }
}