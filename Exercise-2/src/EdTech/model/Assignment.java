package EdTech.model;

public class Assignment {
    private final String detail;

    public Assignment(String detail) {
        if (detail == null || detail.isBlank()) {
            throw new IllegalArgumentException("Assignment detail cannot be null or empty");
        }
        this.detail = detail.trim();
    }

    public String getDetail() {
        return detail;
    }
}

