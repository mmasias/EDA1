package listas.genericaInterfaz;

import java.util.Calendar;

public class Participant {

    private String name;
    private String country;
    private Calendar birthday;
    private Calendar start;
    private Calendar end;

    public Participant() {
    }

    public Participant(String name, String country, Calendar birthday) {
        super();
        this.setName(name);
        this.setCountry(country);
        this.setBirthday(birthday);
    }

    public Calendar getStart() {
        return start;
    }

    public void setStart(Calendar start) {
        this.start = start;
    }

    public Calendar getEnd() {
        return end;
    }

    public void setEnd(Calendar end) {
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

}