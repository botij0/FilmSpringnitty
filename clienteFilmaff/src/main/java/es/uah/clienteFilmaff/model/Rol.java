package es.uah.clienteFilmaff.model;

public class Rol {

    private Integer id;

    private String authority;

    public Rol() {
    }

    public Rol(String idRolAndName){
        if(idRolAndName != null && idRolAndName.length() > 0){
            String[] fieldPositions = idRolAndName.split("-");
            this.id = Integer.parseInt(fieldPositions[0]);
            this.authority = fieldPositions[1];
        }
    }

    public Integer getIdRol() {
        return id;
    }

    public void setIdRol(Integer id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "" + id +"-" + this.authority;
    }
}
