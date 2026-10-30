public class Persona {
    public String name;
    private String country ;
    private String id ;
    public boolean is_alive = true;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id=id;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry(String newCountry){
        this.country=newCountry;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", is_alive=" + is_alive +
                '}';
    }




}
