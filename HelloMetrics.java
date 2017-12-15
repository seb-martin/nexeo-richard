
public class HelloMetrics {

  private static int KO = 1024;

  public static void main(String[] args) {

    // See https://docs.oracle.com/javase/8/docs/api/java/lang/System.html#nanoTime--
    long startTime = System.nanoTime();

    // See https://docs.oracle.com/javase/8/docs/api/java/lang/Runtime.html
    Runtime runtime = Runtime.getRuntime();
    System.out.println("Used memory : " + ((runtime.totalMemory() - runtime.freeMemory()) / KO) + " Kb");
    System.out.println("Free memory : " + (runtime.freeMemory() / KO) + " Kb");
    System.out.println("Total memory: " + (runtime.totalMemory() / KO) + " Kb");
    System.out.println("Max memory  : " + (runtime.maxMemory() / KO) + " Kb");

    long elapsedTime = System.nanoTime() - startTime;
    System.out.println("Elapsed time: " + elapsedTime + " nanoseconds");

  }
}
