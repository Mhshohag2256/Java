/*****************************
 * Author : Mehedi H Shohag  *
 * Assignment : 3            *
 * CSC 221-Section F         *
 * EMPLID:23614013           *
 *****************************/
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;


public class LogEntry {
    private final String sequence;
    private final String packetSize;
    private final String dateTime;
    private final String sourceIP;
    private final String destinationIP;
    private final String protocol;
    private final String comment;

    public LogEntry(String sequence, String packetSize, String dateTime, String sourceIP, String destinationIP, String protocol, String comment) {
        if (Integer.parseInt(sequence) > 1 && Integer.parseInt(sequence) < Integer.MAX_VALUE ||
                Integer.parseInt(packetSize) > 1 && Integer.parseInt(packetSize) < 1500 ||
                dateTime.length() == 19 ||
                sourceIP.length() > 0 && sourceIP != null ||
                destinationIP.length() > 0 && destinationIP != null ||
                protocol == "TCP" || protocol == "UDP") {
            this.sequence = sequence;
            this.packetSize = packetSize;
            this.dateTime = dateTime;
            this.sourceIP = sourceIP;
            this.destinationIP = destinationIP;
            this.protocol = protocol;
            this.comment = comment;
        }
        else
            throw new IllegalArgumentException("One or more values are invalid");
    }

    public String getSequence() {
        return sequence;
    }

    public String getPacketSize() {
        return packetSize;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getSourceIP() {
        return sourceIP;
    }

    public String getDestinationIP() {
        return destinationIP;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getComment() {
        return comment;
    }

    public Date getDateTimeAsDate(){
        {
            SimpleDateFormat obj=new SimpleDateFormat("MM/dd/yyyy HH:MM:ss");
            Date date = new Date(getDateTime());
            obj.format(date);
            return date;

        }

    }


    @Override
    public String toString() {
        return  sequence + ',' + packetSize + ',' + dateTime + ',' +
                sourceIP + ',' + destinationIP + ',' + protocol + ',' + comment + ','+"\n" ;
    }
}
