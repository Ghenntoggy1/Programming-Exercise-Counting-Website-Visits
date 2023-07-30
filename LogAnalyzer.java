import java.util.ArrayList;
import edu.duke.FileResource;
import java.util.HashMap;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         records = new ArrayList<LogEntry>();
     }
     
     public void readFile(String filename) {
         FileResource fr = new FileResource(filename);
         for (String line : fr.lines()) {
             WebLogParser parser = new WebLogParser();
             LogEntry entry = parser.parseEntry(line);
             records.add(entry);
         }
     }
     
     private ArrayList<String> createUniqueIPsList () {
         ArrayList<String> uniqueIPs = new ArrayList<String>();
         for (LogEntry le : records) {
             String ipAddr = le.getIpAddress();
             if (!uniqueIPs.contains(ipAddr)) {
                 uniqueIPs.add(ipAddr);
             }
         }
         return uniqueIPs;
     }
     
     public int countUniqueIPs () {
         ArrayList<String> uniqueIPs = createUniqueIPsList();
         return uniqueIPs.size();
     }
     
     public ArrayList<String> uniqueIPVisitsOnDay (String someday) {
         ArrayList<String> uniqueIPsOnDay = new ArrayList<String>();
         for (LogEntry le : records) {
             String ipAddr = le.getIpAddress();
             String currDay = le.getAccessTime().toString();
             if (!uniqueIPsOnDay.contains(ipAddr) && currDay.contains(someday)) {
                 uniqueIPsOnDay.add(ipAddr);
             }
         }
         return uniqueIPsOnDay;
     }
     
     public int countUniqueIPsInRange (int low, int high) {
         ArrayList<String> uniqueIPs = new ArrayList<String>();
         for (LogEntry le : records) {
             int statusCode = le.getStatusCode();
             String ipAddr = le.getIpAddress();
             if (statusCode >= low && statusCode <= high && !uniqueIPs.contains(ipAddr)) { 
                 uniqueIPs.add(ipAddr);
             }
         }
         return uniqueIPs.size();
     }
     
     public HashMap<String, Integer> countVisitsPerIP () {
         HashMap<String, Integer> counts = new HashMap<String, Integer>();
         for (LogEntry logEntry : records) {
             String ipAddr = logEntry.getIpAddress();
             if (!counts.containsKey(ipAddr)) {
                 counts.put(ipAddr, 1);
             }
             else {
                 counts.put(ipAddr, counts.get(ipAddr) + 1);
             }
         }
         return counts;
     }
     
     public int mostNumberVisitsByIP (HashMap<String, Integer> counts) {
         int maxVisits = 0;
         int currVisits;
         for (String ip : counts.keySet()) {
             currVisits = counts.get(ip);
             if (maxVisits < currVisits) {
                 maxVisits = currVisits;
             }
         }
         return maxVisits;
     }
     
     public ArrayList<String> iPsMostVisits (HashMap<String, Integer> counts) {
         ArrayList<String> iPsMostVisitsList = new ArrayList<String>();
         int maxVisits = mostNumberVisitsByIP(counts);
         for (String ip : counts.keySet()) {
             if (counts.get(ip) == maxVisits) {
                 iPsMostVisitsList.add(ip);
             }
         }
         return iPsMostVisitsList;
     }
     
     public ArrayList<String> iPVisitsOnDay (String someday) {
         ArrayList<String> uniqueIPsOnDay = new ArrayList<String>();
         for (LogEntry le : records) {
             String ipAddr = le.getIpAddress();
             String currDay = le.getAccessTime().toString();
             if (currDay.contains(someday)) {
                 uniqueIPsOnDay.add(ipAddr);
             }
         }
         return uniqueIPsOnDay;
     }
     
     public HashMap<String, ArrayList<String>> iPsForDays () {
         HashMap<String, ArrayList<String>> iPsDays = new HashMap<String, ArrayList<String>>();
         ArrayList<String> iPsOnDay;
         ArrayList<String> days = new ArrayList<String>();
         for (LogEntry le : records) {
             String day = le.getAccessTime().toString().substring(4, 10);
             String ip = le.getIpAddress();
             if (!days.contains(day)) {
                 iPsOnDay = new ArrayList<String>();
                 iPsOnDay.add(ip);
                 days.add(day);
                 iPsDays.put(day, iPsOnDay);
             }
             else {
                 iPsOnDay = iPsDays.get(day);
                 iPsOnDay.add(ip);
                 iPsDays.put(day, iPsOnDay);
             }
         }
         return iPsDays;
     }
     
     public String dayWithMostIPVisits (HashMap<String, ArrayList<String>> iPsDays) {
         iPsDays = iPsForDays();
         int maxVisits = 0;
         int currVisits;
         String maxDay = "";
         for (String day : iPsDays.keySet()) {
             currVisits = iPsDays.get(day).size();
             if (maxVisits <= currVisits) {
                 maxVisits = currVisits;
                 maxDay = day;
             }
         }
         return maxDay;
     }
     
     public ArrayList<String> iPsWithMostVisitsOnDay (HashMap<String, ArrayList<String>> iPsDays, String day) {
         ArrayList<String> IPsOnDay = iPsDays.get(day);
         HashMap<String, Integer> visitsPerIpPerDay = new HashMap<String, Integer>();
         for (String ip : IPsOnDay) {
             if (!visitsPerIpPerDay.containsKey(ip)) {
                 visitsPerIpPerDay.put(ip, 1);
             }
             else {
                 int value = visitsPerIpPerDay.get(ip);
                 visitsPerIpPerDay.put(ip, value + 1);
             }
         }
         ArrayList<String> iPsWithMostVisitsOnOneDay = iPsMostVisits(visitsPerIpPerDay);
         return iPsWithMostVisitsOnOneDay;
     }
     
     public void printAllHigherThanNum (int num) {
         for (LogEntry le : records) {
             int statusCode = le.getStatusCode();
             if (statusCode > num) {
                 System.out.println(le);
             }
         }
     }
     
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
}
