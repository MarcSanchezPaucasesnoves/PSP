public class Operacio {
    public static String obtenirSigne(int idSigne){
        return idSigne == 0 ? "+" : "/";
    }

    public static int operarDosNombres(int a, int b, String operador) throws Exception{
        return switch (operador) {
            case "+" -> a + b;
            case "/" -> a / b;
            default -> throw new Exception("L'operador no existeix");
        };
    }

}
