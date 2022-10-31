import java.io.FileWriter;
import java.io.IOException;

public class RecordList {
    Record head;
    int length;
    public RecordList(){
        head = new Record();
        length = 0;
    }
    public int add(String name,double race){
        Data data = new Data(name,race);
        Record record = new Record(data);
        int index = 0;
        length++;
        if(head.next == null){
            head.next = record;
            return index;
        }
        Record currentNode = head;
        while(currentNode.next != null && currentNode.next.data.getRaceTime() < race){
            currentNode = currentNode.next;
            index++;
        }
        if(currentNode.next == null){
            currentNode.next = record;
        }else{
            record.next = currentNode.next;
            currentNode.next = record;
        }
        return index;
    }
    public void writeToFileMethod(String url){
        try{
            FileWriter fileWriter = new FileWriter(url);
            Record currentNode = head.next;
            while (currentNode != null){
                fileWriter.append(currentNode.data.getName());
                fileWriter.append(",");
                fileWriter.append(""+currentNode.data.getRaceTime());
                fileWriter.append('\n');
                currentNode = currentNode.next;
            }
            fileWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        RecordList recordList = new RecordList();
        System.out.println(recordList.add("Bob",10.5));
        System.out.println(recordList.add("Alice",12.4));
        System.out.println(recordList.add("Bill",14.0));
        System.out.println(recordList.add("Amy",13.0));
        recordList.writeToFileMethod("race.txt");
    }
}
