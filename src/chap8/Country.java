package chap8;

public class Country {
    String name;
    String language;

    public Country(String name,String language){
        this.name=name;
        this.language=language;
    }

    public String getLanguage() {
        return language;
    }

    public String getName() {
        return name;
    }
}
