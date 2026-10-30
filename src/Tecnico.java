public class Tecnico extends Persona{
    public String club;

    public Tecnico() {}

    public Tecnico(String nombre, String id, String club, String pais) {
        this.name = nombre;
        this.setId(id);
        this.club = club;
        this.setCountry(pais);
    }

    @Override
    public String toString() {
        return "Tecnico{equipoActual='" + club + "', " + super.toString() + "}";
    }
}

