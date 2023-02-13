package ifml3.story;

public class Story {

    private String name;

    private Story(Builder builder) {
        this.name = builder.name;
    }

    public String name() {
        return name;
    }

    public static Builder buidler() {
        return new Builder();
    }

    public static class Builder {

        private String name;

        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        public Story build() {
            return new Story(this);
        }
    }
}
