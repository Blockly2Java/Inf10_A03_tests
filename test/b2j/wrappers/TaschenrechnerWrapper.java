package b2j.wrappers;


import de.tum.cit.aet.levenshtein.ClassWrapper;
import de.tum.cit.aet.levenshtein.MethodWrapper;

public class TaschenrechnerWrapper<T> extends ClassWrapper<T>
{
    private final MethodWrapper<T, ?> addieren;
    private final MethodWrapper<T, ?> subtrahieren;
    private final MethodWrapper<T, ?> multiplizieren;
    private final MethodWrapper<T, ?> dividieren;
    private final MethodWrapper<T, ?> mittelwert;
    //private final MethodWrapper<T, ?> potenzieren;


    public TaschenrechnerWrapper()
    {
        super(
            "Taschenrechner",
            "", 
            "public"
        );

        addieren = new MethodWrapper<>(
                this,
                "addieren",
                double.class,
                new Class<?>[] { double.class, double.class },
                "public",
                "static"
        );

        subtrahieren = new MethodWrapper<>(
                this,
                "subtrahieren",
                double.class,
                new Class<?>[] { double.class, double.class },
                "public",
                "static"
        );

        multiplizieren = new MethodWrapper<>(
                this,
                "multiplizieren",
                double.class,
                new Class<?>[] { double.class, double.class },
                "public",
                "static"
        );

        dividieren = new MethodWrapper<>(
                this,
                "dividieren",
                double.class,
                new Class<?>[] { double.class, double.class },
                "public",
                "static"
        );

        mittelwert = new MethodWrapper<>(
                this,
                "mittelwert",
                double.class,
                new Class<?>[] { double.class, double.class },
                "public",
                "static"
        );

        /*
        potenzieren = new MethodWrapper<>(
                this,
                "potenzieren",
                double.class,
                new Class<?>[] { double.class, double.class },
                "public",
                "static"
        );
        */
    }
    @Override
    public Object getObj(boolean forceNew, boolean useByteBuddy) {
        return null;
    }

    public MethodWrapper<T, ?> addieren() {
        return addieren;
    }

    public MethodWrapper<T, ?> subtrahieren() {
        return subtrahieren;
    }

    public MethodWrapper<T, ?> multiplizieren() {
        return multiplizieren;
    }

    public MethodWrapper<T, ?> dividieren() {
        return dividieren;
    }
    public MethodWrapper<T, ?> mittelwert() {
        return mittelwert;
    }

    public MethodWrapper<T, ?> potenzieren() {
        return null;//potenzieren;
    }
}
