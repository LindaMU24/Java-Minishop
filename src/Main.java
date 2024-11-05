import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> cart = new ArrayList<>();

        String[] products = {"Bröd", "Mjölk", "Skinka", "Ost", "Ägg", "Smör"}; //Lägger till ägg och smör//
        double[] prices = {25.0, 14.0, 30.0, 79.0, 20.0, 45.0}; //Lägger till de nya priserna//

        boolean shopping = true;

        while (shopping) {
            printProducts(products, prices);
            // Fråga användaren om deras val och lägga till i kundkorgen
            System.out.println("Ange vilken produkt du vill lägga till i kundkorgen (1 för bröd, 2 för mjölk, etc.), " +
                    "eller 0 för att avsluta, eller -1 för att ta bort en vara: ");
            int choice = scanner.nextInt();

            // Beroende på användarens val, lägg till rätt produkt i kundkorgen
            if (choice == 0) {
                shopping = false;
            } else if (choice == -1) {
                removeFromCart(cart);
            } else if (choice >= 1 && choice <= products.length) {
                cart.add(products[choice - 1]);
            } else {
                System.out.println("Ogiltigt val, försök igen");
            }
        }
        viewCart(cart, products, prices);
    }

    public static void printProducts(String[] products, double[] prices) {
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " - " + prices[i] + " kr");
        }
    }

    public static void viewCart(ArrayList<String> cart, String[] products, double[] prices) {
        double total = 0;
        System.out.println("Din kundkorg innehåller:");
        for (String item : cart) {
            int index = java.util.Arrays.asList(products).indexOf(item);
            System.out.println("- " + item + ": " + prices[index] + " kr");
            total += prices[index];
        }
        System.out.println("Totalt pris i kundkorgen: " + total + " kr");
    }

    public static void removeFromCart(ArrayList<String> cart) {
        Scanner scanner = new Scanner(System.in);

        if (cart.isEmpty()) {
            System.out.println("Kundkorgen är tom. Det finns inget att ta bort");
            return;
        }
        System.out.println("Din kundkorg innehåller:");
        for (int i = 0; i < cart.size(); i++) {
            System.out.println((i + 1) + ". " + cart.get(i));
        }
        System.out.println("Ange numret för den vara du vill ta bort: ");
        int index = scanner.nextInt() - 1;

        if (index >= 0 && index < cart.size()) {
            String removedItem = cart.remove(index);
            System.out.println(removedItem + " har tagits bort från kundkorgen.");
        } else {
            System.out.println("Ogiltigt val, varan kunde inte tas bort.");
        }
    }
}


// Övning: "Mini-shop Simulator"
//Skapa ett enkelt program som simulerar ett mycket grundläggande shoppingsystem. Programmet ska innehålla funktionalitet för att visa en produktlista, lägga till produkter till en kundkorg, och visa den totala kostnaden.
//
//Steg 1: Variabler och datatyper
//
//Deklarera några variabler för att representera olika produkter och deras priser (t.ex., int eller double).
//Skapa variabler för att hålla reda på den totala kostnaden samt antalet produkter i kundkorgen.
//Steg 2: Funktioner
//
//Skriv en funktion printProducts som visar en lista med produkter och deras priser.
//Skriv en funktion addToCart som tar produktnamn och pris som argument, och uppdaterar kundkorgen samt den totala kostnaden.
//Skriv en funktion viewCart som visar alla produkter i kundkorgen och den totala kostnaden.
//Steg 3: Loopar och villkor
//
//Använd en while-loop som låter användaren välja en produkt från listan genom att ange ett nummer. Om användaren anger ett ogiltigt val ska de få ett felmeddelande.
//Lägg till en möjlighet för användaren att avsluta shoppingen genom att skriva "0".
//Steg 4: Array/Listor
//
//Använd en array eller ArrayList för att lagra produkterna och deras priser.
//Lägg till alla valda produkter i kundkorgen.
//Bonus
//
//lägg till fler produkter och justera priserna.
//
//skapa ytterligare en funktion, till exempel för att ta bort produkter från kundkorgen.