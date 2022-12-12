public class User {
    private String name;
    private int yearOfBirth;
    private String country;
    private String city;
    private String favoriteFilm;
    private String favoriteBook;

    public User() {
    }

    public User(String name, int yearOfBirth, String country, String city, String favoriteBook, String favoriteFilm) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.country = country;
        this.city = city;
        this.favoriteFilm = favoriteFilm;
        this.favoriteBook = favoriteBook;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setFavoriteBook(String favoriteBook) {
        this.favoriteBook = favoriteBook;
    }

    public void setFavoriteFilm(String favoriteFilm) {
        this.favoriteFilm = favoriteFilm;
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getFavoriteBook() {
        return favoriteBook;
    }

    public String getFavoriteFilm() {
        return favoriteFilm;
    }

    @Override
    public String toString() {
        if (this == null) {
            return "Null";
        }
        return getName() + ", \n"
                + getYearOfBirth() + ", \n"
                + getCountry() + ", \n"
                + getCity() + ", \n"
                + getFavoriteFilm() + ", \n"
                + getFavoriteBook();

    }
}
