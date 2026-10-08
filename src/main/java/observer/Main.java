package observer;

public class Main {
    public static void main(String[] args) {
        // Criar observadores (Proprietários)
        Proprietario proprietario1 = new Proprietario("Proprietario 1");
        Proprietario proprietario2 = new Proprietario("Proprietario 2");
        Proprietario proprietario3 = new Proprietario("Proprietario 3");

        // Criar Observables (Modelos)
        Modelo modeloDrive = new Modelo(2021, "Fiat", "Argo", "Drive");
        Modelo modeloTrekking = new Modelo(2021, "Fiat", "Argo", "Trekking");

        // Registrar observadores
        proprietario1.cadastrar(modeloDrive);
        proprietario2.cadastrar(modeloDrive);
        proprietario3.cadastrar(modeloTrekking);

        System.out.println("Convocando recall do " + modeloDrive);
        modeloDrive.convocarRecall();
        System.out.println(proprietario1.getUltimaNotificacao());
        System.out.println(proprietario2.getUltimaNotificacao());
        System.out.println(proprietario3.getUltimaNotificacao());

        System.out.println("\nConvocando recall do " + modeloTrekking);
        modeloTrekking.convocarRecall();
        System.out.println(proprietario1.getUltimaNotificacao());
        System.out.println(proprietario2.getUltimaNotificacao());
        System.out.println(proprietario3.getUltimaNotificacao());
    }
}
