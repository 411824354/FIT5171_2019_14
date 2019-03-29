package rockets.model;

import static org.apache.commons.lang3.Validate.notBlank;

public abstract class Entity {
    private Long id;

    private String wikilink;

    public String getWikilink() {
        return wikilink;
    }

    public void setWikilink(String wikilink) {
        notBlank(wikilink, "wikilink cannot be null or empty");
        this.wikilink = wikilink;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (id == null)
            throw new NullPointerException("Id cannot be null");
        else if (id < 0)
            throw new IllegalArgumentException("id cannot be negative");
        else
            this.id = id;
    }
}
