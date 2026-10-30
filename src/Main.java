import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        ArrayList<Equipo> listaEquipos = cargarEquiposReales();

        Equipo equipoActual = listaEquipos.get(0); // Por defecto arranca con Real Madrid
        int opcion;

        do {
            System.out.println("\n==========================================");
            System.out.println("   FUTBOL MANAGER - EQUIPO ACTUAL: " + equipoActual.getNombreEquipo().toUpperCase());
            System.out.println("==========================================");
            System.out.println("1. Cambiar de Equipo");
            System.out.println("2. ReadAllCSV (Ver Plantilla y Técnico)");
            System.out.println("3. ReadOneCSV (Buscar Jugador por ID)");
            System.out.println("4. SaveCSV (Agregar Jugador)");
            System.out.println("5. Update (Actualizar Jugador)");
            System.out.println("6. Delete (Borrar Jugador)");
            System.out.println("7. Salir");
            System.out.print("Elija una opción: ");
            opcion = lector.nextInt();
            lector.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("\n--- SELECCIONE UN EQUIPO ---");
                    for (int i = 0; i < listaEquipos.size(); i++) {
                        System.out.println((i + 1) + ". " + listaEquipos.get(i).getNombreEquipo());
                    }
                    System.out.print("Elija el número del equipo: ");
                    int idx = lector.nextInt() - 1;
                    lector.nextLine();
                    if (idx >= 0 && idx < listaEquipos.size()) {
                        equipoActual = listaEquipos.get(idx);
                        System.out.println("¡Cambiado a " + equipoActual.getNombreEquipo() + " con éxito!");
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- INFORMACIÓN DE " + equipoActual.getNombreEquipo().toUpperCase() + " ---");
                    if (equipoActual.getTecnicoEquipo() != null) {
                        System.out.println("Técnico: " + equipoActual.getTecnicoEquipo());
                    } else {
                        System.out.println("Técnico: No asignado.");
                    }
                    System.out.println("Plantilla de Jugadores:");
                    equipoActual.leerTodos();
                    break;

                case 3:
                    System.out.print("Ingrese el ID del jugador a buscar: ");
                    String idBusqueda = lector.nextLine();
                    Jugador encontrado = equipoActual.buscarJugadorPorId(idBusqueda);
                    if (encontrado != null) {
                        System.out.println("¡Encontrado!: " + encontrado);
                    } else {
                        System.out.println("Jugador no encontrado en este equipo.");
                    }
                    break;

                case 4:
                    System.out.print("ID del nuevo jugador: ");
                    String nuevoId = lector.nextLine();
                    System.out.print("Nombre del jugador: ");
                    String nuevoNom = lector.nextLine();
                    System.out.print("Dorsal: ");
                    int nuevoDor = lector.nextInt();
                    lector.nextLine();
                    System.out.print("País: ");
                    String nuevoPais = lector.nextLine();

                    Jugador nuevoJugador = new Jugador(nuevoNom, nuevoId, nuevoDor, Posicion.DELANTERO, LocalDate.of(2000, 1, 1), nuevoPais);
                    equipoActual.agregarJugador(nuevoJugador);
                    System.out.println("¡Jugador agregado exitosamente a la plantilla!");
                    break;

                case 5:
                    System.out.print("Ingrese el ID del jugador a actualizar: ");
                    String idAct = lector.nextLine();
                    System.out.print("Nuevo nombre: ");
                    String nomAct = lector.nextLine();
                    System.out.print("Nuevo dorsal: ");
                    int dorAct = lector.nextInt();
                    lector.nextLine();

                    if (equipoActual.actualizarJugador(idAct, nomAct, dorAct)) {
                        System.out.println("¡Jugador actualizado correctamente!");
                    } else {
                        System.out.println("No se encontró un jugador con ese ID.");
                    }
                    break;

                case 6:
                    System.out.print("Ingrese el ID del jugador a eliminar (Delete): ");
                    String idDel = lector.nextLine();
                    if (equipoActual.eliminarJugador(idDel)) {
                        System.out.println("¡Jugador eliminado del equipo!");
                    } else {
                        System.out.println("No se encontró el jugador.");
                    }
                    break;

                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 7);

        lector.close();
    }

    public static ArrayList<Equipo> cargarEquiposReales() {
        ArrayList<Equipo> equipos = new ArrayList<>();


        Equipo realMadrid = new Equipo("Real Madrid");
        realMadrid.setTecnicoEquipo(new Tecnico("Carlo Ancelotti", "RM01", "Real Madrid", "Italia"));
        realMadrid.agregarJugador(new Jugador("Thibaut Courtois", "RM1", 1, Posicion.PORTERO, LocalDate.of(1992, 5, 11), "Bélgica"));
        realMadrid.agregarJugador(new Jugador("Dani Carvajal", "RM2", 2, Posicion.DEFENSA, LocalDate.of(1992, 1, 11), "España"));
        realMadrid.agregarJugador(new Jugador("Éder Militão", "RM3", 3, Posicion.DEFENSA, LocalDate.of(1998, 1, 18), "Brasil"));
        realMadrid.agregarJugador(new Jugador("Antonio Rüdiger", "RM4", 22, Posicion.DEFENSA, LocalDate.of(1993, 3, 3), "Alemania"));
        realMadrid.agregarJugador(new Jugador("Ferland Mendy", "RM5", 23, Posicion.DEFENSA, LocalDate.of(1995, 6, 8), "Francia"));
        realMadrid.agregarJugador(new Jugador("Federico Valverde", "RM6", 8, Posicion.MEDIOCAMPISTA, LocalDate.of(1998, 7, 22), "Uruguay"));
        realMadrid.agregarJugador(new Jugador("Aurélien Tchouaméni", "RM7", 14, Posicion.MEDIOCAMPISTA, LocalDate.of(2000, 1, 27), "Francia"));
        realMadrid.agregarJugador(new Jugador("Jude Bellingham", "RM8", 5, Posicion.MEDIOCAMPISTA, LocalDate.of(2003, 6, 29), "Inglaterra"));
        realMadrid.agregarJugador(new Jugador("Rodrygo Goes", "RM9", 11, Posicion.EXTREMO, LocalDate.of(2001, 1, 9), "Brasil"));
        realMadrid.agregarJugador(new Jugador("Vinícius Jr.", "RM10", 7, Posicion.EXTREMO, LocalDate.of(2000, 7, 12), "Brasil"));
        realMadrid.agregarJugador(new Jugador("Kylian Mbappé", "RM11", 9, Posicion.DELANTERO, LocalDate.of(1998, 12, 20), "Francia"));
        equipos.add(realMadrid);


        Equipo barcelona = new Equipo("FC Barcelona");
        barcelona.setTecnicoEquipo(new Tecnico("Hansi Flick", "FCB01", "FC Barcelona", "Alemania"));
        barcelona.agregarJugador(new Jugador("Marc-André ter Stegen", "FC1", 1, Posicion.PORTERO, LocalDate.of(1992, 4, 30), "Alemania"));
        barcelona.agregarJugador(new Jugador("Jules Koundé", "FC2", 23, Posicion.DEFENSA, LocalDate.of(1998, 11, 12), "Francia"));
        barcelona.agregarJugador(new Jugador("Pau Cubarsí", "FC3", 2, Posicion.DEFENSA, LocalDate.of(2007, 1, 22), "España"));
        barcelona.agregarJugador(new Jugador("Ronald Araújo", "FC4", 4, Posicion.DEFENSA, LocalDate.of(1999, 3, 7), "Uruguay"));
        barcelona.agregarJugador(new Jugador("Alejandro Balde", "FC5", 3, Posicion.DEFENSA, LocalDate.of(2003, 10, 18), "España"));
        barcelona.agregarJugador(new Jugador("Frenkie de Jong", "FC6", 21, Posicion.MEDIOCAMPISTA, LocalDate.of(1997, 5, 12), "Países Bajos"));
        barcelona.agregarJugador(new Jugador("Pedri González", "FC7", 8, Posicion.MEDIOCAMPISTA, LocalDate.of(2002, 11, 25), "España"));
        barcelona.agregarJugador(new Jugador("Gavi", "FC8", 6, Posicion.MEDIOCAMPISTA, LocalDate.of(2004, 8, 5), "España"));
        barcelona.agregarJugador(new Jugador("Lamine Yamal", "FC9", 19, Posicion.EXTREMO, LocalDate.of(2007, 7, 13), "España"));
        barcelona.agregarJugador(new Jugador("Raphinha", "FC10", 11, Posicion.EXTREMO, LocalDate.of(1996, 12, 14), "Brasil"));
        barcelona.agregarJugador(new Jugador("Robert Lewandowski", "FC11", 9, Posicion.DELANTERO, LocalDate.of(1988, 8, 21), "Polonia"));
        equipos.add(barcelona);


        Equipo millonarios = new Equipo("Millonarios F.C.");
        millonarios.setTecnicoEquipo(new Tecnico("Alberto Gamero", "MIL01", "Millonarios F.C.", "Colombia"));
        millonarios.agregarJugador(new Jugador("Álvaro Montero", "M1", 31, Posicion.PORTERO, LocalDate.of(1995, 3, 29), "Colombia"));
        millonarios.agregarJugador(new Jugador("Danovis Banguero", "M2", 20, Posicion.DEFENSA, LocalDate.of(1989, 10, 20), "Colombia"));
        millonarios.agregarJugador(new Jugador("Andrés Llinás", "M3", 26, Posicion.DEFENSA, LocalDate.of(1997, 7, 10), "Colombia"));
        millonarios.agregarJugador(new Jugador("Juan Pablo Vargas", "M4", 4, Posicion.DEFENSA, LocalDate.of(1995, 6, 6), "Costa Rica"));
        millonarios.agregarJugador(new Jugador("Delvin Alfonzo", "M5", 13, Posicion.DEFENSA, LocalDate.of(2000, 9, 21), "Venezuela"));
        millonarios.agregarJugador(new Jugador("Daniel Giraldo", "M6", 21, Posicion.MEDIOCAMPISTA, LocalDate.of(1992, 7, 10), "Colombia"));
        millonarios.agregarJugador(new Jugador("Stiven Vega", "M7", 5, Posicion.MEDIOCAMPISTA, LocalDate.of(1998, 8, 22), "Colombia"));
        millonarios.agregarJugador(new Jugador("David Mackalister Silva", "M8", 14, Posicion.MEDIOCAMPISTA, LocalDate.of(1986, 12, 21), "Colombia"));
        millonarios.agregarJugador(new Jugador("Daniel Ruiz", "M9", 10, Posicion.EXTREMO, LocalDate.of(2001, 7, 30), "Colombia"));
        millonarios.agregarJugador(new Jugador("Jhon Emerson Córdoba", "M10", 7, Posicion.EXTREMO, LocalDate.of(2000, 5, 23), "Colombia"));
        millonarios.agregarJugador(new Jugador("Leonardo Castro", "M11", 23, Posicion.DELANTERO, LocalDate.of(1992, 6, 14), "Colombia"));
        equipos.add(millonarios);


        Equipo manCity = new Equipo("Manchester City");
        manCity.setTecnicoEquipo(new Tecnico("Pep Guardiola", "MC01", "Manchester City", "España"));
        manCity.agregarJugador(new Jugador("Ederson Moraes", "MC1", 31, Posicion.PORTERO, LocalDate.of(1993, 8, 17), "Brasil"));
        manCity.agregarJugador(new Jugador("Kyle Walker", "MC2", 2, Posicion.DEFENSA, LocalDate.of(1990, 5, 28), "Inglaterra"));
        manCity.agregarJugador(new Jugador("Rúben Dias", "MC3", 3, Posicion.DEFENSA, LocalDate.of(1997, 5, 14), "Portugal"));
        manCity.agregarJugador(new Jugador("John Stones", "MC4", 5, Posicion.DEFENSA, LocalDate.of(1994, 5, 28), "Inglaterra"));
        manCity.agregarJugador(new Jugador("Josko Gvardiol", "MC5", 24, Posicion.DEFENSA, LocalDate.of(2002, 1, 23), "Croacia"));
        manCity.agregarJugador(new Jugador("Rodri Hernández", "MC6", 16, Posicion.MEDIOCAMPISTA, LocalDate.of(1996, 6, 22), "España"));
        manCity.agregarJugador(new Jugador("Kevin De Bruyne", "MC7", 17, Posicion.MEDIOCAMPISTA, LocalDate.of(1991, 6, 28), "Bélgica"));
        manCity.agregarJugador(new Jugador("Phil Foden", "MC8", 47, Posicion.MEDIOCAMPISTA, LocalDate.of(2000, 5, 28), "Inglaterra"));
        manCity.agregarJugador(new Jugador("Bernardo Silva", "MC9", 20, Posicion.EXTREMO, LocalDate.of(1994, 8, 10), "Portugal"));
        manCity.agregarJugador(new Jugador("Jérémy Doku", "MC10", 11, Posicion.EXTREMO, LocalDate.of(2002, 5, 27), "Bélgica"));
        manCity.agregarJugador(new Jugador("Erling Haaland", "MC11", 9, Posicion.DELANTERO, LocalDate.of(2000, 7, 21), "Noruega"));
        equipos.add(manCity);


        Equipo seleccionCol = new Equipo("Selección Colombia");
        seleccionCol.setTecnicoEquipo(new Tecnico("Néstor Lorenzo", "COL01", "Selección Colombia", "Argentina"));
        seleccionCol.agregarJugador(new Jugador("Camilo Vargas", "COL1", 12, Posicion.PORTERO, LocalDate.of(1989, 3, 9), "Colombia"));
        seleccionCol.agregarJugador(new Jugador("Daniel Muñoz", "COL2", 21, Posicion.DEFENSA, LocalDate.of(1996, 5, 26), "Colombia"));
        seleccionCol.agregarJugador(new Jugador("Dávinson Sánchez", "COL3", 23, Posicion.DEFENSA, LocalDate.of(1996, 6, 12), "Colombia"));
        seleccionCol.agregarJugador(new Jugador("Jhon Lucumí", "COL4", 3, Posicion.DEFENSA, LocalDate.of(1998, 6, 26), "Colombia"));
        seleccionCol.agregarJugador(new Jugador("Johan Mojica", "COL5", 17, Posicion.DEFENSA, LocalDate.of(1992, 8, 21), "Colombia"));
        seleccionCol.agregarJugador(new Jugador("Jefferson Lerma", "COL6", 16, Posicion.MEDIOCAMPISTA, LocalDate.of(1994, 10, 25), "Colombia"));
        seleccionCol.agregarJugador(new Jugador("Richard Ríos", "COL7", 6, Posicion.MEDIOCAMPISTA, LocalDate.of(2000, 6, 2), "Colombia"));
        seleccionCol.agregarJugador(new Jugador("James Rodríguez", "COL8", 10, Posicion.MEDIOCAMPISTA, LocalDate.of(1991, 7, 12), "Colombia"));
        seleccionCol.agregarJugador(new Jugador("Jhon Arias", "COL9", 11, Posicion.EXTREMO, LocalDate.of(1997, 9, 21), "Colombia"));
        seleccionCol.agregarJugador(new Jugador("Luis Díaz", "COL10", 7, Posicion.EXTREMO, LocalDate.of(1997, 1, 13), "Colombia"));
        seleccionCol.agregarJugador(new Jugador("Jhon Córdoba", "COL11", 24, Posicion.DELANTERO, LocalDate.of(1993, 5, 11), "Colombia"));
        equipos.add(seleccionCol);

        return equipos;
    }
}
