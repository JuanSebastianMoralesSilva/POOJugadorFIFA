
public class Equipo {
   public Tecnico tecnicoEquipo;
   public Jugador[] plantilla;
   public String nameEquipo;

public Equipo() {
   this.plantilla = new Jugador[5];
}
public Equipo(String nameEquipo, int capacidad) {
   this.nameEquipo=nameEquipo;
   this.plantilla=new Jugador[capacidad];
}
public Jugador buscarJugadorPoId(String idBuscado) {
   for (Jugador != null && Jugador.getId() != null && Jugador.getId().equals(idBuscado)) {

   }
}

}
