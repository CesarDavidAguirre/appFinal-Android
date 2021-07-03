package com.example.cesar.appfinal;

/**
 * Created by Ing.Cesar on 01/04/2017.
 */

public class PuntoProvide {
    public static String [] dic;
    public static String [] descr;

    public static String [] GetPlanetas (){
        dic = new String[]{
                "HAMBRE DE PODER",
                "ANIMALES FANTASTICOS Y DONDE ENCONTRARLOS",
                "LA BELLA Y LA BESTIA",
                "KONG LA ISLA CALAVERA",
                "RAPIDOS Y FURIOSOS 8",
                "POWER RANGERS"
                };
        return dic;
    }

    public static String GetTrailer(int numero){
        String[] list= new String[]{"TKqNmqHpyMM",
                                    "6dIj-vQerNc",
                                    "KN_H5WZsorE",
                                    "gmn0AX-ooY8",
                                    "ovnphWd31Qk",
                                    "eCK1wPSUcpw"
                                    };


        String youtube = new String();
        youtube=list [numero];
        return youtube;
    }
    public static  String GetTrailerServer (int numero){
        String[] list= new String[]{"https://docs.google.com/uc?export=download&id=0ByJjdwTg7MnMNklkdFNueHVJb1k",
                "https://docs.google.com/uc?export=download&id=0ByJjdwTg7MnMX2cwR0NLME1fUzA",
                "https://docs.google.com/uc?export=download&id=0ByJjdwTg7MnMZjkxV3NPUXZVZ2c",
                "https://docs.google.com/uc?export=download&id=0ByJjdwTg7MnMOWQzRzlGRjRKZlE",
                "https://docs.google.com/uc?export=download&id=0ByJjdwTg7MnMb0Q4aEFwMlZBNUE",
                "https://docs.google.com/uc?export=download&id=0ByJjdwTg7MnMM1NsWWpBUnh0Y1E"
        };


        return list[numero];

    }

    public static String [] Descripcion(){
        descr= new String[]{"Hambre de poder nos trae la verdadera y polémica historia de cómo Ray Kroc, el fundador de McDonald´s, creó este imperio mundial de comida rápida, generador de millones de dólares.",
                                      "Año 1926. Newt Scamander acaba de completar un viaje por todo el mundo para encontrar y documentar una extraordinaria selección de criaturas mágicas. Llegando a Nueva York para hacer una breve parada en su camino, donde podría haber llegado y salido sin incidentes…pero no para un Muggle llamado Jacob, un caso perdido de magia, y la fuga de algunas criaturas fantásticas de Newt, que podrían causar problemas el mundo mágico y en el mundo Muggle. (FILMAFFINITY)",
                                      "Una hermosa joven llamada Bella acepta alojarse en un castillo con una bestia a cambio de la libertad de su padre. La bestia es, en realidad, un príncipe encantado. Para romper el hechizo, deberá ganarse el amor de una preciosa dama antes de que caiga el último pétalo de una rosa encantada.",
                                      "En esta historia un grupo de exploradores aventureros se reunen para adentrarse en la densa selva de una isla perdida en el Pacífico, sin saber que el territorio que invaden es dominado por el mítico Kong",
                                      "Rápidos y Furiosos 7 (2015), una de las película más rápidas en superar la barrera de los mil millones de dólares en taquilla y la sexta cinta más grande en la historia, regresa con una nueva entrega para la saga más popular de todos los tiempos: Rápidos y Furiosos 8. Justo cuando Dom y Letty celebran su luna de miel, Brian y Mia se han retirado del juego y el resto del equipo se ha desintegrado en busca de una vida común y corriente; una misteriosa mujer (Charlize Theron, ganadora al Óscar) intentará seducir a Dom para convencerlo de regresar a la vida criminal que tanto lo acecha, traicionando a quienes lo rodean y enfrentándose a retos nunca antes vistos. Desde la costa cubana pasando por las calles de Nueva York y hasta el helado Ártico, el equipo deberá cruzar el mundo para detener a una anarquista y evitar un desastre mundial trayendo de vuelta a casa al hombre que los convirtió en una familia. Para Rápidos y Furiosos 8, acompañan a Vin Diesel actores como Dwayne Johnson, Jason Statham, Michelle Rodriguez, Tyrese Gibson, Chris ¨Ludacris¨ Bridges, Natalie Emmanuel, Elsa Pataky y Kurt Russell. Junto con Theron, se unen por primera vez a la saga la también ganadora al Oscar Helen Mirren y Scott Eastwood. La cinta está dirigida por F. Gary Gray y producida por Neal H. Moritz, Michael Fottrell y Vin Diesel.",
                                      "Cinco adolescentes tienen que convertirse en algo extraordinario cuando descubren que su modesto poblado de Angel Grove -y el resto del mundo- está al borde de la aniquilación por una amenaza alienígena. Elegidos por el destino, nuestros héroes descubren rápidamente que son los únicos que pueden salvar al planeta. Para lograrlo tendrán que superar problemas de la vida real y unirse como los Power Rangers, antes de que sea demasiado tarde."
                                      };
        return descr;

    }

    public static int imagenes (int numero){
        int [] imagen =  new int []{R.drawable.hambre_de_poder,
                                    R.drawable.animales_fantasticos,
                                    R.drawable.bella_y_bestia,
                                    R.drawable.kong_isla_calavera,
                                    R.drawable.rapido_y_furioso_8,
                                    R.drawable.power_rangers};
        return imagen [numero];
    }

    public  static  String GetTitulo(int numero){
        return dic [numero];
    }
    public static  String GetDesc(int numero){
        return descr[numero];
    }
}
