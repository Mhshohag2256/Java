/*****************************
 * Author : Mehedi H Shohag  *
 * Assignment : 3            *
 * CSC 221-Section F         *
 * EMPLID:23614013           *
 *****************************/
import sun.rmi.runtime.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class LogUtility {
    private final ArrayList<LogEntry> listLogEntries;


    public LogUtility() {
        this.listLogEntries = new ArrayList<LogEntry>();
    }
    public boolean parseFile(String file) throws FileNotFoundException {
        File network=new File(file);
        Scanner inputFile = new Scanner(network);
        String line;
        while(inputFile.hasNext()){
            line=inputFile.nextLine();
            String arr[]=line.split(",");
            try {
                listLogEntries.add(new LogEntry(arr[0].trim(), arr[1].trim(), arr[2].trim(), arr[3].trim(), arr[4].trim(), arr[5].trim(), arr[6].trim()));
            }
            catch(Exception e){
                System.out.printf("Skipping Line: %s",line);
            }
        }

        inputFile.close();
        return true;
    }

    public String toString(){
        return String.format("There are %d records",listLogEntries.size());
    }


    public enum find{
        sequence, packetSize, dateTime, sourceIP, destinationIP, protocol, comment
    }

    private LogEntry findFirst(String data,find member){
        for(LogEntry entry:listLogEntries){
            String value;
            switch(member){
                case sequence:
                    value= entry.getSequence(); break;
                case packetSize:
                    value=entry.getPacketSize();break;
                case dateTime:
                    value= entry.getDateTime();break;
                case sourceIP:
                    value=entry.getSourceIP();break;
                case destinationIP:
                    value=entry.getDestinationIP(); break;
                case protocol:
                    value=entry.getProtocol(); break;
                case comment:
                    value=entry.getComment(); break;
                default:
                    value=null;

            }
        }
        return null;
    }

    public LogEntry findFirstId(String str){
        return findFirst(str,find.sequence);
    }
    public LogEntry findFirstPacketSize(String str){
        return findFirst(str,find.packetSize);
    }
    public LogEntry findFirstTimestamp(String str){
        return findFirst(str,find.dateTime);
    }
    public LogEntry findFirstSourceIP(String str){
        return findFirst(str,find.sourceIP);
    }
    public LogEntry findFirstDestinationIP(String str){
        return findFirst(str,find.destinationIP);
    }
    public LogEntry findFirstProtocol(String str){
        return findFirst(str,find.protocol);
    }
    public LogEntry findFirstComment(String str){
        return findFirst(str,find.comment);
    }

    public ArrayList<LogEntry> getBetween(String fromDate,String toDate) throws ParseException {
        ArrayList<LogEntry> list=new ArrayList<LogEntry>();
        Date from=new SimpleDateFormat("MM/dd/yyyy HH:MM:ss").parse(fromDate);
        Date to=new SimpleDateFormat("MM/dd/yyyy HH:MM:ss").parse(toDate);

        for(LogEntry L:listLogEntries){
            Date date =new SimpleDateFormat("MM/dd/yyyy HH:MM:ss").parse(L.getDateTime());

            if(date.compareTo(from)>=0 && date.compareTo(to)<=0){
                list.add(L);
            }
        }
        return list;

    }


}
