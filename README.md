# Hello Annotation

Un example d'utilisation des 3 annotations fournies avec le JDK :

- [`@Deprecated`](https://docs.oracle.com/javase/8/docs/api/java/lang/Deprecated.html)
- [`@SuppressWarnings`](https://docs.oracle.com/javase/8/docs/api/java/lang/SuppressWarnings.html)
- [`@Override`](https://docs.oracle.com/javase/8/docs/api/java/lang/Override.html)

Ce programme lève des alertes à la compilation.

```sh
> javac HelloAnnotation.java
Note: HelloAnnotation.java uses or overrides a deprecated API.
Note: Recompile with -Xlint:deprecation for details.
Note: HelloAnnotation.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

```

Pour obtenir le détail des alertes :

```sh
> javac -Xlint:deprecation -Xlint:unchecked HelloAnnotation.java
```

Ce programme ne produit aucune sortie mais réalise des assertions pour démontrer son bon fonctionnement.

```sh
> java -enableassertions HelloAnnotation
```

Pour supprimer les bytecodes (clean) :

```sh
> rm *.class
```
