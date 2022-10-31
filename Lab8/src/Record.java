public class Record {
    public Record next;
    public Data data;

    public Record(){
        this.next = null;
        this.data = null;
    }
    public Record(Data data){
        this.next = null;
        this.data = data;
    }
    public Record(Data data,Record next){
        this.data = data;
        this.next = next;
    }
}
class Data{
    private String name;
    private double raceTime;
    public Data(){}
    public Data(String name, double raceTime) {
        this.name = name;
        this.raceTime = raceTime;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRaceTime() {
        return raceTime;
    }

    public void setRaceTime(double raceTime) {
        this.raceTime = raceTime;
    }
}

