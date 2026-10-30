import java.time.LocalDate;
import java.time.Period;

public class Jugador extends Persona {
    public int dorsal;
    public Posicion posicion;
    private LocalDate nacimiento;

    public Jugador() {}

    public Jugador(String nombre, String id, int dorsal, Posicion posicion, LocalDate nacimiento, String pais) {
        this.name = nombre;
        this.setId(id);
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.setNacimiento(nacimiento);
        this.setCountry(pais);
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    public int getEdad() {
        if (nacimiento == null) return 0;
        return Period.between(nacimiento, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Jugador{dorsal=" + dorsal +
                ", posicion=" + posicion +
                ", edad=" + getEdad() + " años, " +
                super.toString() + "}";
    }
}
