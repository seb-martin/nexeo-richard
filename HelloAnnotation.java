import java.util.ArrayList;
import java.util.List;


public class HelloAnnotation {

    public static void main(String... args) {

        Hello hello = new Hello();

        // Warning "deprecation" à la compilation : appel d'une méthode annotée avec @Deprecated
        boolean b1 = hello.deprecatedMethod();
        assert b1;

        // Pas de warning
        boolean b2 = hello.deprecationWarningSuppressed();
        assert b2;

        // Pas de warning
        @SuppressWarnings("deprecation")
        boolean b3 = hello.deprecatedMethod();
        assert b3;

        // Warning "unchecked" à la compilation : le cast scabreux
        List<String> l1 = hello.notGenericList();
        assert l1 != null;

        // Pas de warning
        @SuppressWarnings("unchecked")
        List<String> l2 = hello.notGenericList();
        assert l2 != null;


        assert "hello".equals(hello.toString());
        assert "Helloooooo".equals(hello.toooooString());

        Object o = new Hello();

        assert "hello".equals(o.toString());

        // Erreur à la compilation
        // assert "Helloooooo".equals(o.toooooString());

    }

}

class Hello {

    @Deprecated
    public boolean deprecatedMethod() {
        return true;
    }

    @SuppressWarnings("deprecation")
    public boolean deprecationWarningSuppressed() {

        return this.deprecatedMethod();
    }

    public List notGenericList() {
        return new ArrayList<String>();
    }

    @Override // Réécrit la méthode Object.toString() : OK
    public String toString() {
        return "hello";
    }

    // @Override // Si non commenté : Erreur à la compilation
    public String toooooString() {
        return "Helloooooo";
    }
}
