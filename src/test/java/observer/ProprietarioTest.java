package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProprietarioTest {

    @Test
    void deveNotificarUmProprietario() {
        Modelo modelo = new Modelo(2021, "Fiat", "Argo", "Drive");
        Proprietario proprietario = new Proprietario("Proprietario 1");
        proprietario.cadastrar(modelo);
        modelo.convocarRecall();
        assertEquals("Proprietario 1, recall convocado no Modelo{ano=2021, montadora='Fiat', nomeModelo='Argo', versao='Drive'}", proprietario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarProprietarios() {
        Modelo modelo = new Modelo(2021, "Fiat", "Argo", "Drive");
        Proprietario proprietario1 = new Proprietario("Proprietario 1");
        Proprietario proprietario2 = new Proprietario("Proprietario 2");
        proprietario1.cadastrar(modelo);
        proprietario2.cadastrar(modelo);
        modelo.convocarRecall();
        assertEquals("Proprietario 1, recall convocado no Modelo{ano=2021, montadora='Fiat', nomeModelo='Argo', versao='Drive'}", proprietario1.getUltimaNotificacao());
        assertEquals("Proprietario 2, recall convocado no Modelo{ano=2021, montadora='Fiat', nomeModelo='Argo', versao='Drive'}", proprietario2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarProprietario() {
        Modelo modelo = new Modelo(2021, "Fiat", "Argo", "Drive");
        Proprietario proprietario = new Proprietario("Proprietario 1");
        modelo.convocarRecall();
        assertEquals(null, proprietario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarProprietarioVersaoDrive() {
        Modelo modeloDrive = new Modelo(2021, "Fiat", "Argo", "Drive");
        Modelo modeloTrekking = new Modelo(2021, "Fiat", "Argo", "Trekking");
        Proprietario proprietario1 = new Proprietario("Proprietario 1");
        Proprietario proprietario2 = new Proprietario("Proprietario 2");
        proprietario1.cadastrar(modeloDrive);
        proprietario2.cadastrar(modeloTrekking);
        modeloDrive.convocarRecall();
        assertEquals("Proprietario 1, recall convocado no Modelo{ano=2021, montadora='Fiat', nomeModelo='Argo', versao='Drive'}", proprietario1.getUltimaNotificacao());
        assertEquals(null, proprietario2.getUltimaNotificacao());
    }
}