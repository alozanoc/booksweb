package pe.edu.upao.books.controllers.dto;

public class SimpleUserDTO {
    String name;
    String username;

    String token;

    public SimpleUserDTO(String name, String username, String token) {
        this.name = name;
        this.username = username;
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
