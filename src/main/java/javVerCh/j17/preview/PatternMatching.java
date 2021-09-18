package javVerCh.j17.preview;

public class PatternMatching {
    public static String switchOverClasses() {
        Object version = Runtime.version().feature();
        return switch (version) {
            case null -> throw new IllegalArgumentException("Impossible!");
            case Integer i && (i >= 17) -> "Hello, this is Java™ "+ i + " ;-)";
            case Integer i -> i +"? But how?";
            default -> "oops...";
        };
    }

}
