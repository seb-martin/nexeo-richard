package fr.nexeo.hello;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class HelloGenericsTest {

    @SuppressWarnings({"unchecked", "UnnecessaryBoxing", "UnnecessaryUnboxing"})
    @Test
    public void motivations() {

        /*
        Pour chaque type primitif (int, double, char, ...),
        il existe un équivalent objet : un Wrapper (Integer, Double, Character, ...)

        Pour qu'une valeur d'un' type primitif puisse intégrer une collection d'objet, un "boxing" doit être réalisé.
        Réciproquement, il faut réaliser un "unboxing" sur les objets issus d'une collection pour retrouver une valeur primitive
         */

        // JDK < 1.5 //

        // Une liste _censée_ contenir des entiers.
        List intList = new ArrayList();

        int i1 = 0;
        int i2 = 2;

        // Le boxing est à réaliser soi-même

        Integer wrapper1 = new Integer(i1);
        Integer wrapper2 = new Integer(i2);

        intList.add(wrapper1);
        intList.add(wrapper2);

        // On retrouve des objets
        Object o1 = intList.get(0);
        Object o2 = intList.get(1);

        // Qui nécessites un cast pour compiler
        Integer o1wrapper = (Integer)o1;
        Integer o2wrapper = (Integer)o2;

        // Unboxing
        int v1 = o1wrapper.intValue();
        int v2 = o2wrapper.intValue();

        assertTrue(i1 == v1);
        assertTrue(i2 == v2);


        try {
            // Oops, un String dans la liste d'entiers
            intList.add("12");

            // Lève une ClassCastException à l'exécution
            Integer badCast = (Integer)intList.get(2);

            fail("should throw a ClassCastException, found " + badCast);
        } catch (ClassCastException e) {
            assertTrue(true);
        }

    }

    @SuppressWarnings("unchecked")
    @Test
    public void autoboxing() {

        // Depuis Java 1.5, l'autoboxing est dispponible

        // Une liste _censée_ contenir des entiers.
        List intList = new ArrayList();

        int i1 = 0;
        int i2 = 2;

        // Auto-boxing :-)
        intList.add(i1);
        intList.add(i2);

        // On retrouve des objets
        Object o1 = intList.get(0);
        Object o2 = intList.get(1);

        // Qui nécessites un cast pour compiler
        // Auto-unboxing :-)
        int v1 = (Integer)o1;
        int v2 = (Integer)o2;

        assertTrue(i1 == v1);
        assertTrue(i2 == v2);


        try {
            // Oops, un String dans la liste d'entiers
            intList.add("12");

            // Lève une ClassCastException à l'exécution
            int badCast = (Integer)intList.get(2);

            fail("should throw a ClassCastException, found " + badCast);
        } catch (ClassCastException e) {
            assertTrue(true);
        }
    }

    @Test
    public void generics() {

        // Generic method

        String s = HelloGenerics.random("a", "b");
        int i = HelloGenerics.random(1, 2);

        assertTrue(Arrays.asList("a", "b").contains(s));
        assertTrue(Arrays.asList(1, 2).contains(i));

        // Generic object

        HelloGenerics<String> go1 = new HelloGenerics<>(s);
        HelloGenerics<Integer> go2 = new HelloGenerics<>(i);

        // Pas de cast :-)
        String s1 = go1.getGenericProperty();
        int i1 = go2.getGenericProperty();

        assertThat(s1, is(s));
        assertThat(i1, is(i));
    }

    @Test
    public void genericObjectOfGenericObject() {

        HelloGenerics<HelloGenerics<Integer>> o = new HelloGenerics<>(new HelloGenerics<>(0));

        assertThat(o.getGenericProperty().getGenericProperty(), is(0));

    }

    @Test
    public void genericList() {
        // Une liste d'entiers.
        List<Integer> intList = new ArrayList<>();

        int i1 = 0;
        int i2 = 2;

        // Auto-boxing :-)
        intList.add(i1);
        intList.add(i2);

        // On retrouve des entiers (après Auto-unboxing) :-)
        int v1 = intList.get(0);
        int v2 = intList.get(1);

        assertTrue(i1 == v1);
        assertTrue(i2 == v2);

        // Erreur à la compilatiion :-)
        // intList.add("12");

    }

    @Test
    public void genericListOfGenericObject() {

        List<HelloGenerics<HelloGenerics<Integer>>> list = new ArrayList<>();

        HelloGenerics<HelloGenerics<Integer>> o = new HelloGenerics<>(new HelloGenerics<>(0));

        list.add(o);

        for (HelloGenerics<HelloGenerics<Integer>> o1 : list) {

            assertThat(o1.getGenericProperty().getGenericProperty(), is(0));
        }

    }

}

