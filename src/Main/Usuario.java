
public class Usuario {
    private int idUser;
    private String user;

    public Usuario (int idUser, String user){
        this.idUser = idUser;
        this.user = user;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getUser() {
        return user;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
