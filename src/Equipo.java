import java.util.ArrayList;


public class Equipo {
   private Tecnico tecnicoEquipo;
   private ArrayList<Jugador> plantilla;
   private String nombreEquipo;

   public Equipo() {
      this.nombreEquipo = "Equipo";
      this.plantilla = new ArrayList<>();
   }

   public Equipo(String nombreEquipo) {
      this.nombreEquipo = nombreEquipo;
      this.plantilla = new ArrayList<>();
   }

   public String getNombreEquipo() {
      return nombreEquipo;
   }

   public void agregarJugador(Jugador jugador) {
      plantilla.add(jugador);
   }

   public void leerTodos() {
      if (plantilla.isEmpty()) {
         System.out.println("La plantilla está vacía.");
      } else {
         for (Jugador j : plantilla) {
            System.out.println("  -> " + j);
         }
      }
   }

   public Jugador buscarJugadorPorId(String idBuscado) {
      for (Jugador j : plantilla) {
         if (j.getId() != null && j.getId().equals(idBuscado)) {
            return j;
         }
      }
      return null;
   }

   public boolean actualizarJugador(String idBuscado, String nuevoNombre, int nuevoDorsal) {
      Jugador j = buscarJugadorPorId(idBuscado);
      if (j != null) {
         j.name = nuevoNombre;
         j.dorsal = nuevoDorsal;
         return true;
      }
      return false;
   }

   public boolean eliminarJugador(String idBuscado) {
      Jugador j = buscarJugadorPorId(idBuscado);
      if (j != null) {
         plantilla.remove(j);
         return true;
      }
      return false;
   }

   public Tecnico getTecnicoEquipo() {
      return tecnicoEquipo;
   }

   public void setTecnicoEquipo(Tecnico tecnicoEquipo) {
      this.tecnicoEquipo = tecnicoEquipo;
   }
}