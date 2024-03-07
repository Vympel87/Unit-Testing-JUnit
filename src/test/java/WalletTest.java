import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {

    @Test
    public void testWithdrawSufficientBalance() {
        Owner owner = new Owner("Tanto", 30);
        List<Card> cards = new ArrayList<>();
        Wallet wallet = new Wallet(owner, cards, 500.0);

        Double withdrawnAmount = wallet.Withdraw(200.0);

        assertEquals(200.0, withdrawnAmount);
        assertEquals(300.0, wallet.getCash());
        assertTrue(wallet.getCash() >= 0, "Balance should be non-negative");
        assertNotNull(wallet.getOwner(), "Owner should not be null");
        assertSame(owner, wallet.getOwner(), "Owner reference should be the same");
    }

    @Test
    public void testWithdrawInsufficientBalance() {
        Owner owner = new Owner("Lea", 25);
        List<Card> cards = new ArrayList<>();
        Wallet wallet = new Wallet(owner, cards, 50.0);

        Double withdrawnAmount = wallet.Withdraw(100.0);

        assertEquals(0.0, withdrawnAmount);
        assertEquals(50.0, wallet.getCash());
        assertTrue(wallet.getCash() >= 0, "Balance should be non-negative");
        assertNotNull(wallet.getOwner(), "Owner should not be null");
        assertSame(owner, wallet.getOwner(), "Owner reference should be the same");
    }

    @Test
    public void testDeposit() {
        Owner owner = new Owner("Alif", 35);
        List<Card> cards = new ArrayList<>();
        Wallet wallet = new Wallet(owner, cards, 200.0);

        Double depositedAmount = wallet.Deposit(100.0);

        assertEquals(300.0, depositedAmount);
        assertEquals(300.0, wallet.getCash());
        assertTrue(wallet.getCash() >= 0, "Balance should be non-negative");
        assertNotNull(wallet.getOwner(), "Owner should not be null");
        assertNotSame(owner, new Owner("Alif", 35), "Owner reference should not be the same");
    }

    @Test
    public void testAddCard() {
        Owner owner = new Owner("Neta", 28);
        List<Card> cards = new ArrayList<>();
        Wallet wallet = new Wallet(owner, cards, 150.0);

        wallet.addCards("BCA", 123456789);

        assertEquals(1, wallet.getCards().size());
        assertEquals("Neta", wallet.getCards().get(0).getNamaPemilik());
        assertEquals("BCA", wallet.getCards().get(0).getNamaBank());
        assertEquals(123456789, wallet.getCards().get(0).getNoRek());
        assertTrue(wallet.getCards().contains(wallet.getCards().get(0)), "Card should be in the list");
        assertNotNull(wallet.getCards().get(0), "Card should not be null");
    }

    @Test
    public void testRemoveCard() {
        Owner owner = new Owner("Fadhil", 40);
        List<Card> cards = new ArrayList<>();
        Wallet wallet = new Wallet(owner, cards, 300.0);

        wallet.addCards("Mandiri", 987654321);
        wallet.addCards("BNI", 111222333);

        assertEquals(2, wallet.getCards().size());

        wallet.removeCard(987654321);

        assertEquals(1, wallet.getCards().size());
        assertNull(findCardByAccountNumber(wallet.getCards(), 987654321), "Card should be removed");
        assertTrue(wallet.getCards().isEmpty(), "Card list should be empty");
    }

    private Card findCardByAccountNumber(List<Card> cards, Integer accountNumber) {
        for (Card card : cards) {
            if (card.getNoRek().equals(accountNumber)) {
                return card;
            }
        }
        return null;
    }
}