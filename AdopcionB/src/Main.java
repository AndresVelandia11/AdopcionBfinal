import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public static void main(String[] args) {


   Scanner teclado = new Scanner(System.in);

    List<Persona> personas = new ArrayList<>();
    List<Perro> perrosDisponibles = new ArrayList<>();

   int opcion;
   String placa;
   String nombre;
   String apellido;
   int edad = 0;
   String documento;
   String nombrePerro;
   String raza;
   int edadPerro;
   String tamaño;
   List<Perro> perrosAdoptados = List.of();



   do {

       System.out.println("""
               1. Registrar persona.
               2. Registrar perro.
               3. Ver personas registradas.
               4. Ver perros disponibles.
               5. Adoptar un perro.
               6. Consultar el perro mas viejo adoptado.
               7. Salir""");

       opcion = teclado.nextInt();
       teclado.nextLine();


       switch (opcion){
           case 1->{
               System.out.println("Ingrese su nombre: ");
               nombre = teclado.nextLine();
               System.out.println("Ingrese su apellido: ");
               apellido = teclado.nextLine();
               System.out.println("Ingrese su edad: ");
               edad = teclado.nextInt();
               teclado.nextLine();
               System.out.println("Ingrese su documento: ");
               documento = teclado.nextLine();
               
               personas.add(new Persona(nombre, apellido, edad, documento, perrosAdoptados));
               break;
           }

           case 2->{
               System.out.println("Ingrese la placa del perro: ");
               placa = teclado.nextLine();
               System.out.println("Ingrese el nombre del perro: ");
               nombrePerro = teclado.nextLine();
               System.out.println("Ingrese la raza del perro: ");
               raza = teclado.nextLine();
               System.out.println("Ingrese la edad del perro: ");
               edadPerro = teclado.nextInt();
               teclado.nextLine();
               System.out.println("Ingrese el tamaño del perro: ");
               tamaño = teclado.nextLine();
               perrosDisponibles.add(new Perro(placa, nombrePerro, raza, edad, tamaño));
               break;
           }

           case 3->{
               for (Persona persona: personas){
                   System.out.println(persona);
               }
           }

           case 4->{
               for (Perro perro: perrosDisponibles){
                   System.out.println(perro);
               }
           }

           case 5->{
               System.out.println("Ingrese su documento: ");
               documento = teclado.nextLine();

               for (Persona persona: personas){
                   if (persona.getDocumento().equals(documento)){
                       System.out.println("Placa del perro a adoptar: ");
                       placa = teclado.nextLine();

                       for (Perro perro: perrosDisponibles){
                           if (perro.getPlaca().equals(placa)){
                               if (persona.adoptarPerro(perro)){
                                   perrosDisponibles.remove(perro);
                                   System.out.println("Perro Adoptado correctamente");
                               }else {
                                   System.out.println("No se puede adoptar mas de 3 perros.");
                               }
                               break;
                           }

                       System.out.println("Perro no encontrado o persona no encontrada.");
                       break;
                   }
                   }


               }
           }

           case 6->{
               System.out.println("Ingrese su documento: ");
               documento = teclado.nextLine();
               for (Persona persona: personas){
                   if (persona.getDocumento().equals(documento)){
                       if (persona.getPerrosAdoptados().isEmpty()){
                           System.out.println("Aun no ha adoptado perro.");
                       }else {
                           Perro MasViejo = persona.perroMasGrande();
                           System.out.println("El perro mas viejo que se ha adoptado es: ");
                           System.out.println(MasViejo);
                       }
                       break;

                   }
               }
           }

           case 7->{

               System.out.println("Saliendo...");

           }
           default -> System.out.println("Opcion no valida.");


       }


    }while (opcion!=7);
}