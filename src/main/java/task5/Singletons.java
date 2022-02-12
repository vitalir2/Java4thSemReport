package task5;

public class Singletons {
    public static class LazyInit {

        private volatile static LazyInit INSTANCE = null;

        private LazyInit() {

        }

        public static LazyInit getInstance() {
            if (INSTANCE == null) {
                synchronized (LazyInit.class) {
                    if (INSTANCE == null) {
                        INSTANCE = new LazyInit();
                    }
                }
            }
            return INSTANCE;
        }
    }

    public enum Enum {
        INSTANCE;

        public static Enum getInstance() {
            return INSTANCE;
        }
    }

    public static class ImmediateInit {
        private static final ImmediateInit INSTANCE = new ImmediateInit();

        public static ImmediateInit getInstance() {
            return INSTANCE;
        }
    }
}
