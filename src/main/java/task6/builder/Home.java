package task6.builder;

public class Home {
    private final int floorsCount;

    private Home(int floorsCount) {
        this.floorsCount = floorsCount;
    }

    public int getFloorsCount() {
        return floorsCount;
    }

    public interface Builder {
        Builder addFoundation();
        Builder addFloor();
        Builder addRoof();
        Home build();
    }

    public static class BuilderImpl implements Builder {
        private int floorsCount;

        @Override
        public Builder addFoundation() {
            // Adding foundation
            return this;
        }

        @Override
        public Builder addFloor() {
            ++floorsCount;
            return this;
        }

        @Override
        public Builder addRoof() {
            // Adding roof
            return this;
        }

        @Override
        public Home build() {
            return new Home(floorsCount);
        }
    }
}
