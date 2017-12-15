import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class HelloAnnotation {

    public static void main(String... args) {

        Hello hello = new Hello();

        assert "hello".equals(hello.toString());
        assert "Helloooooo".equals(hello.toooooString());

        // Warning "unchecked" à la compilation : le cast scabreux
        // Warning "deprecation" à la compilation : appel d'une méthode annotée avec @Deprecated
        List<String> helloList1 = (List<String>) hello.deprecatedHello();

        assert helloList1 != null;

        // Ici, les warnings ne sont pas levés
        @SuppressWarnings({"unchecked", "deprecation"})
        List<String> helloList2 = (List<String>) hello.deprecatedHello();

        assert helloList1 == helloList2;
        assert helloList1.toString().equals(helloList2.toString());
    }

}

class Hello {

    private List<String> helloList = Arrays.asList("h", "e", "l", "l", "o");

    @Deprecated
    public List deprecatedHello() {

        return helloList;
    }

    @Override // Réécrit la méthode Object.toString() : OK
    public String toString() {
        return helloList.stream().collect(Collectors.joining(""));
    }

    // @Override // Si non commenté : Erreur à la compilation
    public String toooooString() {
        return "Helloooooo";
    }
}
