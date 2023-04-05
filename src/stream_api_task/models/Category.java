package stream_api_task.models;

public enum Category {

    PHONE ("Phone"),
    LAPTOP ("Laptop"),
    WATCH ("Watch");

    private final String title;

    Category(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
