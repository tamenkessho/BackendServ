package ch.nag.tamenkessho.server.data;

import com.google.gson.Gson;

public class NagWorker {
    String name;
    String dept;
    int age;

    public NagWorker(String name, String dept, int age) {
        this.name = name;
        this.dept = dept;
        this.age = age;
    }

    @Override
    public String toString() {
        return name+dept+age;
    }

    public static String getGson(NagWorker[] nagWorkers){
        return new Gson().toJson(nagWorkers);
    }
}
